package View.RentableObject;

import Controller.RentableObjects.ClothingController;
import Model.Entities.RentableObjects.Clothing;
import Model.Exceptions.IllegalSizeException;
import Model.Exceptions.OutOfRangeNumberException;
import View.Interfaces.IBasicView;
import View.Interfaces.IManageView;
import View.Utils.ConfirmationDialog;
import View.Utils.NavigationView;
import View.Utils.Notifications;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
                lblRopa.setText("Editar Ropa");
                edit = true;
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem(selectItem().getId());
                updateList();
            }
        });
        btnRentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NavigationView.openRentView();
            }
        });
        clothingList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                setCurrentData();
            }
        });
    }
    @Override
    public void configView() {
        this.setContentPane(this.Panel);
        this.setTitle("Configurar indumentaria");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
    }

    @Override
    public void setCurrentData() {
        if (selectItem().getObject() != null){

            txtName.setText(selectItem().getObject().getName());
            txtDescripcion.setText(selectItem().getObject().getDescription());
            txtColor.setText(selectItem().getColor());
            txtTalle.setText(String.valueOf(selectItem().getSize()));
            txtPrecio.setText(String.valueOf(selectItem().getObject().getPricePerDay()));
        }
    }

    @Override
    public Clothing selectItem() {
        Clothing clothing = (Clothing) clothingList.getSelectedValue();
        if (clothing == null) {
            clothing = new Clothing();
        }
        return clothing;
    }

    @Override
    public void cleanFields() {
        lblRopa.setText("Formulario de indumentaria");
        edit = false;
        txtName.setText("");
        txtDescripcion.setText("");
        txtTalle.setText("");
        txtColor.setText("");
        txtPrecio.setText("");
    }

    @Override
    public void updateList() {
        cleanFields();
        Clothing[] arreglo = clothingController.getDao().getAll().toArray(new Clothing[0]);
        clothingList.setListData(arreglo);
    }

    @Override
    public void createItem() {
        try{
            String name = txtName.getText();
            String description = txtDescripcion.getText();
            double price = Double.parseDouble(txtPrecio.getText());
            String size = txtTalle.getText();
            String color = txtColor.getText();

            clothingController.newCloth(name, description, price, size, color);
            cleanFields();
            Notifications.showSuccess("Indumentaria creada");
        } catch (IllegalSizeException e) {
            Notifications.showError("Error " + e.getMessage());
        }
        catch (OutOfRangeNumberException e) {
            Notifications.showError("Error " + e.getMessage());
        }
        catch (NumberFormatException e){
            Notifications.showError("Error " + e.getMessage());
        }catch (IllegalArgumentException e){
            Notifications.showError("Error" + e.getMessage());
        }

    }

    @Override
    public void editItem() {

        if(ConfirmationDialog.confirmYESNO("Estás por editar el registro, deseas continuar?")){
            try{
                selectItem().getObject().setPricePerDay(Double.parseDouble(txtPrecio.getText()));
                selectItem().getObject().setName(txtName.getText());
                selectItem().getObject().setDescription(txtDescripcion.getText());
                selectItem().setColor(txtColor.getText());
                selectItem().setSize(txtTalle.getText());
                clothingController.getDao().updateById(selectItem().getId(),selectItem());
                Notifications.showSuccess("Indumentaria actualizada");
            }catch (IllegalSizeException e) {
                Notifications.showError("Error " + e.getMessage());
            }
            catch (OutOfRangeNumberException e) {
                Notifications.showError("Error " + e.getMessage());
            }catch (IllegalArgumentException e){
                Notifications.showError("Error" + e.getMessage());
            }
        }
    }

    @Override
    public void deleteItem(long id) {
        if(ConfirmationDialog.confirmYESNO("Estás seguro que deseas eliminar el registro?")){
            clothingController.getDao().deleteById(id);
            Notifications.showSuccess("Indumentaria eliminada");
        }
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
        if(txtPrecio.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar un precio");
            return false;
        }
        if(txtTalle.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar un talle (s, m, l, xl, xxl, xxxl");
            return false;
        }
        if(txtColor.getText().isEmpty()){
            Notifications.showWarning("Debe ingresar un color");
            return false;
        }
        return true;
    }


}
