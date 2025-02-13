package View;

import View.Interfaces.IBasicView;
import View.Utils.NavigationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HistoricalRentView extends JFrame implements IBasicView {
    private JPanel Panel;
    private JList closedRentsList;
    private JButton btnMenu;

    public HistoricalRentView() {
        configView();
        loadRents();
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
            }
        });
        closedRentsList.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        });
    }

    private void loadRents(){

    }
    @Override
    public void configView() {
        this.setContentPane(this.Panel);
        this.setTitle("Histórico de rentas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }
}
