package View.Rents;

import Controller.Rents.RentController;
import Model.Entities.Rents.IRentable;
import View.Interfaces.IBasicView;
import View.Utils.NavigationView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HistoricalRentView extends JFrame implements IBasicView {
    private JPanel Panel;
    private JList closedRentsList;
    private JButton btnMenu;
    private JLabel dataId;
    private JLabel dataStartDate;
    private JLabel dataCloseDate;
    private JLabel dataGivebackDate;
    private JLabel dataObject;
    private JLabel dataClient;
    private JLabel dataPayment;
    private JLabel dataEarning;
    private JLabel dataTotal;
    private final RentController controller = new RentController();
    public HistoricalRentView() {
        configView();
        loadRents();
        loadTotalEarnings();
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
            }
        });


        closedRentsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                setSelectedData();
            }
        });
    }

    private void setSelectedData(){
        if (selectItem() != null){
            dataClient.setText(selectItem().getClient().toString());
            dataObject.setText(selectItem().getRentableObject().toString());
            dataId.setText(String.valueOf(selectItem().getId()));
            dataCloseDate.setText(String.valueOf(selectItem().getRent().getCloseDate()));
            dataStartDate.setText(String.valueOf(selectItem().getRent().getDate()));
            dataGivebackDate.setText(String.valueOf(selectItem().getRent().getGiveBackDate()));
            dataEarning.setText(String.format("%.2f",selectItem().getEarning()));
            dataPayment.setText(selectItem().getMethod().toString());

        }

    }

    public IRentable selectItem() {
        IRentable value = (IRentable) closedRentsList.getSelectedValue();

        return value;
    }
    private void loadTotalEarnings(){
        dataTotal.setText(String.format("%.2f",controller.getTotalEarnings()));
    }
    private void loadRents(){
        IRentable[] arreglo = controller.getClosedRentDao().getAll().toArray(new IRentable[0]);
        closedRentsList.setListData(arreglo);
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
