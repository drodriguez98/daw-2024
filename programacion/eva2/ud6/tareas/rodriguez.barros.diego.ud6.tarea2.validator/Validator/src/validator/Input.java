/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package validator;

/**
 *
 * @author diego
 */

import java.util.Scanner;

public class Input {
    public static String getValidInput(String text, Validator<String> v) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(text);
            input = scanner.nextLine();
            if (input.equals("*")) {
                throw new Exception("Cancelouse a operación.");
            }
            v = v.getClass().getConstructor(String.class).newInstance(input);
            if (v.isValid()) {
                return input;
            } else {
                System.out.println("Erro: " + v.getMessage());
            }
        }
    }
}