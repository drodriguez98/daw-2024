import java.util.Scanner;

public class CalcularMCM {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            // Solicitar dous numeros
            System.out.print("Introduce o primeiro numero positivo: ");
            int num1 = scanner.nextInt();
            System.out.print("Introduce o segundo numero positivo: ");
            int num2 = scanner.nextInt();

            // Comprobar se ambos numeros son positivos
            if (num1 <= 0 || num2 <= 0) {
                System.out.println("Ambos numeros deben ser positivos.");
                return; // Finalizar o programa
            }

            // Calcular o MCM directamente
            int mcm = calcularMCM(num1, num2);
            System.out.println("O Minimo Comun Multiplo de " + num1 + " e " + num2 + " e: " + mcm);

        } catch (Exception e) {
            System.out.println("Produciuse un erro: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Método para calcular o MCM sen usar MCD
    public static int calcularMCM(int a, int b) {
        int max = Math.max(a, b);
        while (true) {
            if (max % a == 0 && max % b == 0) {
                return max;
            }
            max++;
        }
    }
}
