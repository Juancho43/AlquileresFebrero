package View.RentableObject;

import Controller.RentableObjects.VehicleController;
import Model.Entities.RentableObjects.Clothing;
import Model.Entities.RentableObjects.Vehicle;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
import View.Utils.NavigationView;
import View.Utils.Notifications;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleView extends JFrame implements IBasicView, IManageView {
    private JTextField txtName;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JButton btnLimpiar;
    private JButton btnGuardar;
    private JButton btnAtras;
    private JButton btnRentas;
    private JList vehicleList;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JPanel panel;
    private JLabel lblVehicle;
    private final VehicleController vehicleController = new VehicleController();
    private boolean edit = false;

    public VehicleView(){
        configView();
        updateList();
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openMenuView();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFields();
                lblVehicle.setText("Formulario de vehiculos");
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
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
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    @Override
    public void configView() {
        this.setContentPane(this.panel);
        this.setTitle("Configurar Vehiculos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }

    @Override
    public void setCurrentData() {

    }

    @Override
    public Vehicle selectItem() {
        return (Vehicle) vehicleList.getSelectedValue();
    }

    @Override
    public void cleanFields() {
        txtName.setText("");
        txtDescripcion.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtPrecio.setText("");
    }

    @Override
    public void updateList() {
        Vehicle[] arreglo = vehicleController.getAllVehicles().toArray(new Vehicle[0]);
        vehicleList.setListData(arreglo);
    }

    @Override
    public void createItem() {
        String name = txtName.getText();
        String description = txtDescripcion.getText();
        double price = Double.parseDouble(txtPrecio.getText());
        String band = txtMarca.getText();
        String model = txtModelo.getText();
        int year = Integer.parseInt(txtAnio.getText());

        vehicleController.addVehicle(name, description, price, band, model, year);
        cleanFields();
    }

    @Override
    public void editItem() {

    }

    @Override
    public void deleteItem(long id) {
        vehicleController.getDao().deleteById(id);
    }

    public boolean validateFields() {
        if(txtName.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar un nombre");
            return false;
        }
        if(txtDescripcion.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar una descripcion");
            return false;
        }
        if(txtMarca.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar una marca");
            return false;
        }
        if(txtModelo.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar un modelo");
            return false;
        }
        if(txtAnio.getText().isEmpty() || !isInteger(txtAnio.getText())){
            Notifications.showWarning("Debe ingresar un año, valor entero");
            return false;
        }
        if(txtPrecio.getText().isEmpty() || !isDouble(txtPrecio.getText()) || !isPositive(txtPrecio.getText())){
            Notifications.showWarning("Debe ingresar un precio, valor decimal positivo");
            return false;
        }
        return true;
    }

    private boolean isInteger(String year){
        String integerRegex = "\\d+";
        return year.matches(integerRegex);
    }

    private boolean isDouble(String price){
        String doubleRegex = "\\d+(\\.\\d+)?";
        return price.matches(doubleRegex);
    }

    private boolean isPositive(String price){
        if(isDouble(price)){
            try{
                return Double.parseDouble(price) > 0;
            } catch (NumberFormatException e){
                return false;
            }
        }
        return false;
    }
}
