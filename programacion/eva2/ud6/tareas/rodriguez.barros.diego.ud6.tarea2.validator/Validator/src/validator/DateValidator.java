/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package validator;

/**
 *
 * @author diego
 */

import java.util.regex.Pattern;

public class DateValidator extends Validator<String> {
    
    public DateValidator() {
        super();
    }

    public DateValidator(String object) {
        super(object);
    }

    @Override
    public boolean isValid() {
        if (object == null) {
            message = "A data non pode ser nula.";
            return false;
        }
        // Formato DD/MM/AAAA
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        if (Pattern.matches(regex, object)) {
            return true;
        } else {
            message = "Formato de data incorrecto. Debe ser DD/MM/AAAA.";
            return false;
        }
    }
}