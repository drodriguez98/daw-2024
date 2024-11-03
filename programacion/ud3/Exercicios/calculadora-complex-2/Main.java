import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Solicitar os coeficientes a, b e c
        System.out.print("Introduce o coeficiente a: ");
        double a = scanner.nextDouble();
        System.out.print("Introduce o coeficiente b: ");
        double b = scanner.nextDouble();
        System.out.print("Introduce o coeficiente c: ");
        double c = scanner.nextDouble();

        // Calcular o discriminante
        double D = b * b - 4 * a * c;

        // Determinar as solucions baseadas no valor do discriminante
        if (D > 0) {
            // Duas raíces reais
            double root1 = (-b + Math.sqrt(D)) / (2 * a);
            double root2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("As solucions son: " + root1 + " e " + root2);
        } else if (D == 0) {
            // Raíces reais iguais
            double root = -b / (2 * a);
            System.out.println("A solucion e: " + root);
        } else {
            // D < 0, así que temos raíces complexas
            Complex2 realPart = new Complex2(-b / (2 * a), 0); // Parte real
            Complex2 imaginaryPart = new Complex2(0, Math.sqrt(-D) / (2 * a)); // Parte imaxinaria
            System.out.println("As solucions son: " + realPart.add(imaginaryPart) + " e " + realPart.subtract(imaginaryPart));
        }
    }
}
