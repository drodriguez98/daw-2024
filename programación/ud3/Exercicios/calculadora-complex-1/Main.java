import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in); // Scanner para a entrada de datos

    // Método para obter a entrada dun número complexo
    public static Complex getComplexInput() {
        System.out.print("Introduce a parte real: "); // Mensaxe para introduciri a parte real
        double real = scanner.nextDouble(); // Lectura da parte real
        System.out.print("Introduce a parte imaxinaria: "); // Mensaxe para introduciri a parte imaxinaria
        double imag = scanner.nextDouble(); // Lectura da parte imaxinaria
        return new Complex(real, imag); // Retorna un novo obxecto Complex
    }

    public static void main(String[] args) {
        boolean continuar = true; // Variable para controlar o bucle

        while (continuar) {
            System.out.println("\nMenu de Operacions con Numeros Complexos");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Sair");

            System.out.print("Elixe unha opcion (1-5): "); // Solicita a elección ao usuario
            int choice = scanner.nextInt(); // Lectura da elección

            if (choice == 5) {
                System.out.println("Saindo da aplicacion..."); // Mensaxe de saída
                continuar = false; // Cambia a variable a false para saír do bucle
            } else if (choice >= 1 && choice <= 4) {
                System.out.println("\nIntroduce o primeiro numero complexo:"); // Mensaxe para introducir o primeiro número
                Complex complex1 = getComplexInput(); // Obtén o primeiro número complexo
                System.out.println("\nIntroduce o segundo numero complexo:"); // Mensaxe para introducir o segundo número
                Complex complex2 = getComplexInput(); // Obtén o segundo número complexo

                Complex result = null; // Variable para almacenar o resultado
                String operation = ""; // Variable para almacenar a operación

                // Realiza a operación escollida sen usar breaks
                switch (choice) {
                    case 1 -> {
                        result = complex1.add(complex2); // Suma
                        operation = "Suma"; // Nome da operación
                    }
                    case 2 -> {
                        result = complex1.subtract(complex2); // Resta
                        operation = "Resta"; // Nome da operación
                    }
                    case 3 -> {
                        result = complex1.multiply(complex2); // Multiplicación
                        operation = "Multiplicacion"; // Nome da operación
                    }
                    case 4 -> {
                        try {
                            result = complex1.divide(complex2); // División
                            operation = "Division"; // Nome da operación
                        } catch (ArithmeticException e) {
                            System.out.println("Erro: " + e.getMessage()); // Mensaxe de erro
                            continue; // Salta á seguinte iteración do bucle
                        }
                    }
                }

                System.out.println("\nResultado da " + operation + ": " + result); // Mostra o resultado da operación
            } else {
                System.out.println("Opcion invalida. Por favor, escolle unha opcion valida."); // Mensaxe de opción inválida
            }
        }
    }
}