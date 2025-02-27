package View.Clients;

import Controller.ClientTypeController;
import Model.Entities.Clients.ClientType;
import Model.Exceptions.OutOfRangeNumberException;
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

public class ClientTypeView extends JFrame implements IBasicView, IManageView<ClientType> {
    private JLabel lblClient;
    private JTextField txtName;
    private JTextField txtDiscount;
    private JButton btnMenu;
    private JButton btnActiveRents;
    private JButton btnSave;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnClean;
    private JList clientList;
    private JPanel Panel;

    private final ClientTypeController clientTypeController = new ClientTypeController();
    private boolean edit = false;

    public ClientTypeView() {
    configView();
    updateList();


    btnActiveRents.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            NavigationView.openRentView();
        }
    });
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
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
        btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFields();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblClient.setText("Editar tipo de cliente");
                edit = true;
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem(selectItem().getId());
                updateList();
            }
        });
        clientList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                setCurrentData();
            }
        });
    }

    @Override
    public void configView() {
        this.setContentPane(this.Panel);
        this.setTitle("Configurar tipos de cliente");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }

    @Override
    public void setCurrentData() {
        if (selectItem() != null){
            txtName.setText(selectItem().getType());
            txtDiscount.setText(String.valueOf(selectItem().getDiscount()));
        }
    }

    @Override
    public ClientType selectItem() {
        ClientType value = (ClientType) clientList.getSelectedValue();
        if (value == null) {
            value = new ClientType();
        }
        return value;
    }

    @Override
    public void cleanFields() {
        lblClient.setText("Formulario de tipos de clientes");
        txtName.setText("");
        txtDiscount.setText("");
        edit = false;
    }

    @Override
    public void updateList() {
        cleanFields();
        ClientType[] arreglo = clientTypeController.getDao().getAll().toArray(new ClientType[0]);
        clientList.setListData(arreglo);
    }

    @Override
    public void createItem() {
        try {
            clientTypeController.newType(txtName.getText(), Double.parseDouble(txtDiscount.getText()));
            Notifications.showSuccess("Tipo de cliente creado");
        }catch (OutOfRangeNumberException e){
            Notifications.showError("Error " + e.getMessage());
        }catch (IllegalArgumentException e){
            Notifications.showError("Error " + e.getMessage());
        }
    }

    @Override
    public void editItem() {
        if(ConfirmationDialog.confirmYESNO("Estás por editar el registro, deseas continuar?")){
            try{
                selectItem().setType(txtName.getText());
                selectItem().setDiscount(Double.parseDouble(txtDiscount.getText()));
                clientTypeController.getDao().updateById(selectItem().getId(),selectItem());
                Notifications.showSuccess("Tipo de cliente actualizado");
            }catch (OutOfRangeNumberException e){
                Notifications.showError("Error " + e.getMessage());
            } catch (IllegalArgumentException e){
                Notifications.showError("Error " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteItem(long id) {
        if(ConfirmationDialog.confirmYESNO("Estás seguro que deseas eliminar el registro?")){
            clientTypeController.getDao().deleteById(id);
            Notifications.showSuccess("Tipo de cliente eliminado");
        }
    }

    public boolean validateFields() {
        if (txtName.getText().isEmpty()) {
            Notifications.showWarning("Debe ingresar un nombre");
            return false;
        }
        if (txtDiscount.getText().isEmpty()) {
            Notifications.showWarning("Debe ingresar un descuento");
            return false;
        }
        return true;
    }
}
