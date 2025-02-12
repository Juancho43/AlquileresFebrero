package View.RentableObject;

import Controller.RentableObjects.ClothingController;
import Model.Entities.RentableObjects.Clothing;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
import View.Utils.NavigationView;
import View.Utils.Notifications;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClothingView extends JFrame implements IBasicView, IManageView {
    private JTextField txtName;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtTalle;
    private JTextField txtColor;
    private JButton btnLimpiar;
    private JButton btnGuardar;
    private JButton btnAtras;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnRentas;
    private JList clothingList;
    private JPanel Panel;
    private JLabel lblRopa;
    private final ClothingController clothingController = new ClothingController();
    private boolean edit = false;

    public ClothingView(){
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
                lblRopa.setText("Formulario de indumentaria");
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
        this.setContentPane(this.Panel);
        this.setTitle("Configurar clientes");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }

    @Override
    public void setCurrentData() {
    }

    @Override
    public Clothing selectItem() {
        return (Clothing) clothingList.getSelectedValue();
    }

    @Override
    public void cleanFields() {
        edit = false;
        txtName.setText("");
        txtDescripcion.setText("");
        txtTalle.setText("");
        txtColor.setText("");
        txtPrecio.setText("");
    }

    @Override
    public void updateList() {
        Clothing[] arreglo = clothingController.getAllClothies().toArray(new Clothing[0]);
        clothingList.setListData(arreglo);
    }

    @Override
    public void createItem() {
            String name = txtName.getText();
            String description = txtDescripcion.getText();
            double price = Double.parseDouble(txtPrecio.getText());
            String size = txtTalle.getText();
            String color = txtColor.getText();

            clothingController.newCloth(name, description, price, size, color);
            cleanFields();
    }

    @Override
    public void editItem() {

    }

    @Override
    public void deleteItem(long id) {
        clothingController.getDao().deleteById(id);
        Notifications.showSuccess("Cloth Deleted");
    }

    private boolean validateFields(){
        if(txtName.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar un nombre");
            return false;
        }
        if(txtDescripcion.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar una descripcion");
            return false;
        }
        if(txtPrecio.getText().isEmpty() || !isDouble(txtPrecio.getText()) || !isPositive(txtPrecio.getText())){
            Notifications.showWarning("Debe ingresar un precio, valor decimal positivo");
            return false;
        }
        if(txtTalle.getText().isEmpty() || !isValidSize(txtTalle.getText())){
            Notifications.showWarning("Debe ingresar un talle valido (s, m, l, xl, xxl, xxxl");
            return false;
        }
        if(txtColor.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar un color");
            return false;
        }
        return true;
    }

    private boolean isValidSize(String size) {
        String sizeRegex = "^(s|m|l|x{1,3}l)$"; // s, m, l, xl, xxl, xxxl
        return size.toLowerCase().matches(sizeRegex);
    }

    private boolean isDouble(String price){
        String doubleRegex = "\\d+(\\.\\d+)?";
        return price.matches(doubleRegex);
    }

    private boolean isPositive(String price){
        if (isDouble(price)){
            try{
                return Double.parseDouble(price) > 0;
            } catch (NumberFormatException e){
                return false;
            }
        }
        return false;
    }
}
