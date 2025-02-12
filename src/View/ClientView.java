package View;

import View.Interfaces.IBasicView;
import View.Utils.NavigationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView extends JFrame implements IBasicView {
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtDNI;
    private JButton btnClean;
    private JButton btnSave;
    private JButton btnMenu;
    private JButton btnEdit;
    private JButton btnActiveRents;
    private JLabel lblDNIelected;
    private JLabel lblEmailSelected;
    private JLabel lblNameSelected;
    private JPanel Panel;
    private JComboBox cmClientType;
    private JComboBox cmPayment;
    private JList listClient;
    private JButton btnDelete;

    public ClientView() {
        configView();
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
            }
        });
    }

    public void cleanFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtDNI.setText("");
        cmClientType.getSelectedIndex();
        cmPayment.getSelectedIndex();
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
}
