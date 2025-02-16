/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package validator;

/**
 *
 * @author diego
 */

public class App {
    public static void main(String[] args) {
        try {
            // Parte 4: Solicitar unha matrícula
            String matricula = Input.getValidInput("Introduce unha matrícula válida: ", new MatriculaValidator());
            System.out.println("Matrícula correcta: " + matricula);

            // Parte 5: Validar array de textos
            String[] datos = {"1234ABC", "12/05/2025", "9999ZZZ", "31/02/2025", "ABCD123", "01/01/2024"};
            
            Validator<String> matriculaValidator = new MatriculaValidator();
            Validator<String> dateValidator = new DateValidator();

            System.out.println("\nTextos non válidos como matrículas:");
            for (String dato : datos) {
                matriculaValidator = new MatriculaValidator(dato);
                if (!matriculaValidator.isValid()) {
                    System.out.println(dato + " -> " + matriculaValidator.getMessage());
                }
            }

            System.out.println("\nTextos non válidos como datas:");
            for (String dato : datos) {
                dateValidator = new DateValidator(dato);
                if (!dateValidator.isValid()) {
                    System.out.println(dato + " -> " + dateValidator.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}