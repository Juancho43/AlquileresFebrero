package View.Utils;

import javax.swing.*;

public class Notifications {

    public static void showSuccess(String message){
        showMessage(message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(String message){
        showMessage(message, "error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showWarning(String message){
        showMessage(message, "warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void showMessage(String message, String title, int messageType){
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}
