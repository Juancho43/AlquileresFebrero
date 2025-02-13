package View;

import Controller.Rents.RentController;
import Model.Entities.RentableObjects.Vehicle;
import Model.Entities.Rents.IRentable;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
import View.Utils.NavigationView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentView extends JFrame implements IBasicView, IManageView<IRentable> {
    private JLabel lblClient;
    private JComboBox cmClient;
    private JComboBox cmCategory;
    private JButton btnMenu;
    private JButton btnCloseRents;
    private JButton btnSave;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnClean;
    private JList rentList;
    private JComboBox cmObject;
    private JTextField txtDays;
    private JPanel Panel;

    private final RentController controller = new RentController();
    private boolean edit = false;

    public RentView() {
        this.configView();
        this.updateList();


    rentList.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {

        }
    });
    btnSave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnClean.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnEdit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnCloseRents.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnMenu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            NavigationView.openMenuView();
        }
    });
}

    @Override
    public void configView() {

        this.setContentPane(this.Panel);
        this.setTitle("Rentas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }

    @Override
    public void setCurrentData() {

    }

    @Override
    public IRentable selectItem() {
        return null;
    }

    @Override
    public void cleanFields() {

    }

    @Override
    public void updateList() {
        cleanFields();
        IRentable[] arreglo = controller.getDao().getAll().toArray(new IRentable[0]);
        System.out.println(controller.getDao().getAll());
        rentList.setListData(arreglo);
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
