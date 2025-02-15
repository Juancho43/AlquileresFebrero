package View;

import View.Interfaces.IBasicView;
import View.Utils.ConfirmationDialog;
import View.Utils.NavigationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame implements IBasicView {
    private JButton btnRentas;
    private JButton btnInventario;
    private JButton btnHistorico;
    private JButton btnClientes;
    private JButton btnExit;
    private JButton btnAcercade;
    private JPanel MenuPanel;

    public MenuView(){

        this.configView();
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ConfirmationDialog.confirmYESNO("Estás seguro que deseas cerra la aplicación?")){
                    System.exit(0);
                }
            }
        });
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openClientView();
            }
        });
        btnInventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openRentableObjectView();
            }
        });

        btnAcercade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openAboutView();
            }
        });
        btnRentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openRentView();
            }
        });
        btnHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openHistoricalRentView();
            }
        });
    }

    @Override
    public void configView() {
        this.setContentPane(this.MenuPanel);
        this.setTitle("Sistema Alquileres");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(400, 300);
    }
}
