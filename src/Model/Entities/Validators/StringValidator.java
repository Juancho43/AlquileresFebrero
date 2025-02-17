package Model.Entities.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    public static boolean isValidString(String str) {
        // Expresión regular para permitir solo letras, números y espacios
        String regex = "^[a-zA-Z0-9\\s]*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
