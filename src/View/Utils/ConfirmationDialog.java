package View.Utils;

import javax.swing.*;

public class ConfirmationDialog {

    public static boolean confirmYESNO(String message){
        int option = JOptionPane.showConfirmDialog(
                null,
                message,
                "Confirmación de salida.",
                JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_NO_OPTION;
    }
}
