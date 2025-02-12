package View;

import View.Interfaces.IBasicView;
import View.Utils.NavigationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutView extends JFrame implements IBasicView {
    private JButton btnBack;
    private JPanel panel;

    public AboutView() {
        this.configView();
        btnBack.addActionListener(new ActionListener() {
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
        this.setTitle("Acerca de");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(500, 400);
    }
}
