package utils;

public class DniValidator extends Validator {
    
    private static final String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    @Override
    public boolean isValid(Object data) {
        if (data instanceof String) {
            String dni = (String) data;
            if (!dni.matches("\\d{8}[A-Z]")) return false;

            int number = Integer.parseInt(dni.substring(0, 8));
            char expectedLetter = LETTERS.charAt(number % 23);
            return dni.charAt(8) == expectedLetter;
        }
        return false;
    }

    @Override
    public String message() {
        return "DNI inválido. Debe ter 8 díxitos e unha letra válida.";
    }

}