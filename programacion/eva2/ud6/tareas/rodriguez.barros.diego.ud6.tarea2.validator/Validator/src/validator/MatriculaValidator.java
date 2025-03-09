/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package validator;

/**
 *
 * @author diego
 */

public class MatriculaValidator extends Validator<String> {

    public MatriculaValidator() {
        super();
    }

    public MatriculaValidator(String object) {
        super(object);
    }

    @Override
    public boolean isValid() {
        if (object == null) {
            message = "A matrícula non pode ser nula.";
            return false;
        }
        if (object.matches("\\d{4}[A-Z]{3}")) {
            return true;
        } else {
            message = "Formato de matrícula incorrecto. Debe ter 4 díxitos seguidos de 3 letras maiúsculas.";
            return false;
        }
    }
}