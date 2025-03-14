package View.Rents;

import Controller.ClientController;
import Controller.IControllable;
import Controller.IFactory;
import Controller.RentableObjects.ClothingController;
import Controller.RentableObjects.VehicleController;
import Controller.Rents.RentController;
import Model.Entities.Clients.Client;
import Model.Entities.RentableObjects.Clothing;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.RentableObjects.Vehicle;
import Model.Entities.Rents.IRentable;
import Model.Exceptions.OutOfRangeNumberException;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
import View.Utils.ConfirmationDialog;
import View.Utils.NavigationView;
import View.Utils.Notifications;
import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentView extends JFrame implements IBasicView, IManageView<IRentable> {
    private JLabel lblRent;
    private JComboBox cmClient;
    private JComboBox cmCategory;
    private JButton btnMenu;
    private JButton btnCloseRents;
    private JButton btnSave;
    private JButton btnDelete;
    private JButton btnClean;
    private JList rentList;
    private JComboBox cmObject;
    private JTextField txtDays;
    private JPanel Panel;
    private JButton btnClosedRents;
    private JButton btnClients;
    private JButton btnObjects;
    private final RentController controller = new RentController();
    private final ClientController clientController = new ClientController();

    public RentView() {
        configView();
        updateList();
        setCmClient();
        setCmCategory();

        rentList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                setCurrentData();
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createItem();
                cleanFields();
                updateList();
            }
        });
        btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFields();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem(selectItem().getId());
                updateList();
                cleanFields();
            }
        });
        btnCloseRents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getClosedRentDao().save(selectItem().closeRent(LocalDate.now()));
                Notifications.showSuccess("Renta cerrada");
                updateList();
                cleanFields();
            }
        });
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
            }
        });
        cmCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IFactory c = (IFactory) cmCategory.getSelectedItem();
                controller.setRentFactory(c.getFactory());
                setCmObject();
            }
        });
        btnClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openClientView();
            }
        });
        btnClosedRents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openHistoricalRentView();
            }

        });
        btnObjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openRentableObjectView();
            }
        });
    }

    @Override
    public void configView() {

        this.setContentPane(this.Panel);
        this.setTitle("Rentas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }

    @Override
    public void setCurrentData() {

        if (selectItem() != null) {
            cmClient.setSelectedItem(selectItem().getClient());
            if (selectItem().getRentableObject() instanceof Clothing) cmCategory.setSelectedIndex(0);
            if (selectItem().getRentableObject() instanceof Vehicle) cmCategory.setSelectedIndex(1);
            IFactory c = (IFactory) cmCategory.getSelectedItem();
            controller.setRentFactory(c.getFactory());
            cmObject.setSelectedItem(selectItem().getRentableObject());
            txtDays.setText(String.valueOf(selectItem().getRent().calculateFirstDuration()));
        }
    }

    @Override
    public IRentable selectItem() {
        IRentable value = (IRentable) rentList.getSelectedValue();

        return value;
    }


    @Override
    public void cleanFields() {
        cmCategory.setSelectedIndex(0);
        cmClient.setSelectedIndex(0);
        cmObject.setSelectedIndex(0);
        txtDays.setText("0");
    }

    @Override
    public void updateList() {
        List<IRentable> rentas = controller.getAllStartedRents();
        rentas.addAll(controller.getAllOutOfDateRents());
        IRentable[] arreglo = controller.getAllStartedRents().toArray(new IRentable[0]);
        rentList.setListData(arreglo);
    }

    @Override
    public void createItem() {
        try {
            controller.newRent(Integer.parseInt(txtDays.getText()), (IRentableObject) cmObject.getSelectedItem(), (Client) cmClient.getSelectedItem());
            Notifications.showSuccess("Renta creada");
        } catch (OutOfRangeNumberException e){
            Notifications.showError("Error" + e.getMessage());
        }
    }

    @Override
    public void editItem() {
        try {
            throw new ExecutionControl.NotImplementedException("No implementado");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItem(long id) {
        if(ConfirmationDialog.confirmYESNO("Estás seguro que deseas eliminar el registro?")){
            controller.getDao().deleteById(id);
            Notifications.showSuccess("Renta eliminada");
            cleanFields();
        }
    }

    private void setCmClient() {
        Client[] clients = clientController.getDao().getAll().toArray(new Client[0]);
        cmClient.setModel(new DefaultComboBoxModel<>(clients));
    }

    private void setCmCategory() {
        List<IFactory> controllers = new ArrayList<>();
        controllers.add(new ClothingController());
        controllers.add(new VehicleController());
        IFactory[] controllables = controllers.toArray(new IFactory[0]);
        cmCategory.setModel(new DefaultComboBoxModel<>(controllables));
    }

    private void setCmObject() {
        IControllable controllable = (IControllable) cmCategory.getSelectedItem();
        IRentableObject[] objects = new IRentableObject[0];
        if (controllable instanceof ClothingController)
            objects = ((ClothingController) controllable).getAllAvaliableCloth().toArray(new IRentableObject[0]);
        if (controllable instanceof VehicleController)
            objects = ((VehicleController) controllable).getAllAvaliableVehicles().toArray(new IRentableObject[0]);
        cmObject.setModel(new DefaultComboBoxModel<>(objects));
    }

}