import java.util.Scanner;

public class CalculoNumeroE {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            // Solicitar a precision para o calculo de e
            System.out.print("Introduce a resolucion para o calculo de e (numero de termos): ");
            int precision = scanner.nextInt();

            // Validar a entrada
            if (precision < 0) {
                System.out.println("A precision debe ser un numero enteiro non negativo.");
                return;
            }

            // Chamar ao método para calcular e
            double resultado = calcula_e(precision);
            System.out.println("O valor de e calculado e: " + resultado);

        } catch (Exception e) {
            System.out.println("Produciuse un erro: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Método para calcular o valor de e
    public static double calcula_e(int precision) {
        double resultado = 1.0; // Comezamos co primeiro termo da sucesión (1)

        for (int termo = 1; termo <= precision; termo++) {
            resultado += 1.0 / factorial(termo); // Sumar o termo 1/n!
        }

        return resultado;
    }

    // Método para calcular o factorial de n
    public static long factorial(int n) {
        long resultado = 1; // O factorial de 0 é 1

        for (int factorialTermino = 1; factorialTermino <= n; factorialTermino++) {
            resultado *= factorialTermino; // Multiplicar cada numero desde 1 ata n
        }

        return resultado;
    }
}