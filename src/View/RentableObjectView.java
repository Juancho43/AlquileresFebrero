package View;

import View.Interfaces.IBasicView;
import View.Utils.NavigationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentableObjectView extends JFrame implements IBasicView{
    private JButton btnVehicle;
    private JButton btnCloth;
    private JButton btnAtras;
    private JPanel panel;

    public RentableObjectView(){
        this.configView();
        btnCloth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openClothingView();

            }
        });
        btnVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openVehicleView();
            }
        });
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
            }
        });
    }

    @Override
    public void configView() {
        this.setContentPane(this.panel);
        this.setTitle("Configurar clientes");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }
}
