package View.Clients;

import Model.Entities.Client;
import Model.Entities.ClientType;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
import View.Utils.NavigationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientTypeView extends JFrame implements IBasicView, IManageView<ClientType> {
    private JLabel lblClient;
    private JTextField txtName;
    private JTextField txtEmail;
    private JButton btnMenu;
    private JButton btnActiveRents;
    private JButton btnSave;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnClean;
    private JList clientList;
public ClientTypeView() {
    btnActiveRents.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            NavigationView.openRentView();
        }
    });
}

    @Override
    public void configView() {

    }

    @Override
    public void setCurrentData() {

    }

    @Override
    public ClientType selectItem() {
        return null;
    }

    @Override
    public void cleanFields() {

    }

    @Override
    public void updateList() {

    }

    @Override
    public void createItem() {

    }

    @Override
    public void editItem() {

    }

    @Override
    public void deleteItem(long id) {

    }
}
