package View;

import Controller.ClientController;
import Controller.ClientTypeController;
import Model.Entities.Client;
import Model.Entities.ClientType;
import Model.Entities.RentableObjects.Vehicle;
import Model.Strategy.Cash;
import Model.Strategy.CreditCard;
import Model.Strategy.IPayment;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
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
import java.util.Arrays;
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

    }

    @Override
    public void editItem() {

    }

    @Override
    public void deleteItem(long id) {
        clientController.getDao().deleteById(id);
        Notifications.showSuccess("Client deleted");
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
        return false;
    }

}
