package View.Clients;

import Controller.ClientController;
import Controller.ClientTypeController;
import Model.Exceptions.DuplicateObjectException;
import Model.Entities.Clients.Client;
import Model.Entities.Clients.ClientType;
import Model.Exceptions.IllegalDNIException;
import Model.Exceptions.IllegalEmailException;
import Model.Strategy.Cash;
import Model.Strategy.CreditCard;
import Model.Strategy.IPayment;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
import View.Utils.ConfirmationDialog;
import View.Utils.NavigationView;
import View.Utils.Notifications;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ClientView extends JFrame implements IBasicView, IManageView<Client> {
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtDNI;
    private JButton btnClean;
    private JButton btnSave;
    private JButton btnMenu;
    private JButton btnEdit;
    private JButton btnActiveRents;
    private JPanel Panel;
    private JComboBox cmClientType;
    private JComboBox cmPayment;
    private JList clientList;
    private JButton btnDelete;
    private JLabel lblClient;
    private JButton btnClientType;
    private final ClientController clientController = new ClientController();
    private final ClientTypeController clientTypeController = new ClientTypeController();
    private boolean edit = false;

    public ClientView() {
        configView();
        updateList();
        setCmClientType();
        setCmPaymentMethod();
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
            }
        });
        btnActiveRents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openRentView();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem(selectItem().getId());
                updateList();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblClient.setText("Editar cliente");
                edit = true;
            }
        });

        btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFields();
            }
        });
        clientList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                setCurrentData();
            }
        });
        cmClientType.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        });
        cmPayment.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateFields()){
                    if(edit){
                        editItem();
                    }else{
                        createItem();
                    }
                    cleanFields();
                    updateList();
                }
            }
        });
        btnClientType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openClientTypeView();
            }
        });
    }

    @Override
    public void setCurrentData() {
        if (selectItem() != null){
            txtName.setText(selectItem().getName());
            txtEmail.setText(selectItem().getEmail());
            txtDNI.setText(selectItem().getDni());
            cmClientType.setSelectedItem(selectItem().getType());
            cmPayment.setSelectedItem(selectItem().getPaymentMethod());
        }
    }

    @Override
    public Client selectItem() {
        Client client = (Client) clientList.getSelectedValue();
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public void cleanFields() {
        lblClient.setText("Formulario de clientes");
        txtName.setText("");
        txtEmail.setText("");
        txtDNI.setText("");
        cmClientType.getSelectedIndex();
        cmPayment.getSelectedIndex();
    }
    private void setCmClientType(){
        ClientType[] clients = clientTypeController.getDao().getAll().toArray(new ClientType[0]);
        cmClientType.setModel(new DefaultComboBoxModel<>(clients));
    }
    private void setCmPaymentMethod(){
        List<IPayment> paymentsList = new ArrayList<>();
        paymentsList.add(new Cash());
        paymentsList.add(new CreditCard());
        IPayment[] payments = paymentsList.toArray(new IPayment[0]);

        cmPayment.setModel(new DefaultComboBoxModel<>(payments));
    }


    @Override
    public void updateList() {
        cleanFields();
        Client[] arreglo = clientController.getDao().getAll().toArray(new Client[0]);
        clientList.setListData(arreglo);

    }

    @Override
    public void createItem() {
        try{
            clientController.newClient(txtName.getText(),txtEmail.getText(),txtDNI.getText(),(ClientType) cmClientType.getSelectedItem(), (IPayment) cmPayment.getSelectedItem());
            Notifications.showSuccess("Cliente creado");
        } catch (DuplicateObjectException e) {
            Notifications.showError("Error " + e.getMessage());
        } catch (IllegalEmailException e) {
            Notifications.showError("Error " + e.getMessage());
        } catch (IllegalDNIException e) {
            Notifications.showError("Error " + e.getMessage());
        }
    }

    @Override
    public void editItem() {
        if(ConfirmationDialog.confirmYESNO("Estás por editar el registro, deseas continuar?")) {
            try{
                selectItem().setClientType((ClientType) cmClientType.getSelectedItem());
                selectItem().setPaymentMethod((IPayment) cmPayment.getSelectedItem());
                selectItem().setName(txtName.getText());
                selectItem().setEmail(txtEmail.getText());
                selectItem().setDni(txtDNI.getText());
                clientController.getDao().updateById(selectItem().getId(),selectItem());
                Notifications.showSuccess("Cliente actualizado");
            } catch (DuplicateObjectException e) {
                Notifications.showError("Error " + e.getMessage());
            } catch (IllegalEmailException e) {
                Notifications.showError("Error " + e.getMessage());
            } catch (IllegalDNIException e) {
                Notifications.showError("Error " + e.getMessage());
            }

        }
    }

    @Override
    public void deleteItem(long id) {
        if(ConfirmationDialog.confirmYESNO("Estás seguro que deseas eliminar el registro?")){
            clientController.getDao().deleteById(id);
            Notifications.showSuccess("Cliente eliminado");
        }
    }

    @Override
    public void configView() {
        this.setContentPane(this.Panel);
        this.setTitle("Configurar clientes");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }
    public boolean validateFields() {
        if (txtName.getText().isEmpty()) {
            Notifications.showWarning("Debe ingresar un nombre");
            return false;
        }
        if (txtDNI.getText().isEmpty()) {
            Notifications.showWarning("Debe ingresar un DNI");
            return false;
        }
        if (txtEmail.getText().isEmpty()) {
            Notifications.showWarning("Debe ingresar un email");
            return false;
        }
        return true;
    }

}
