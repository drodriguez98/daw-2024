import java.util.Scanner;

public class EcuacionSegundoGrado {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            // Solicitar os coeficientes da ecuacion
            System.out.print("Introduce o coeficiente a: ");
            double a = scanner.nextDouble();
            System.out.print("Introduce o coeficiente b: ");
            double b = scanner.nextDouble();
            System.out.print("Introduce o coeficiente c: ");
            double c = scanner.nextDouble();

            // Chamar ao método estático para obter as solucions
            double[] solucions = ec2g(a, b, c);

            // Amosar o resultado dependendo de se hai solucions ou non
            if (solucions == null) {
                System.out.println("A ecuacion non ten solucions reais.");
            } else if (solucions.length == 1) {
                System.out.println("A solucion : " + formatSolution(solucions[0]));
            } else {
                System.out.println("As solucions son: " + formatSolution(solucions[0]) + " e " + formatSolution(solucions[1]));
            }

        } catch (Exception e) {
            System.out.println("Produciuse un erro: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Método estático que resolve a ecuacion de segundo grao
    public static double[] ec2g(double a, double b, double c) {
        if (a == 0) {
            // Se a é 0, non é unha ecuacion de segundo grao
            if (b != 0) {
                // ecuacion lineal bx + c = 0
                return new double[]{ -c / b };
            } else {
                // Se tamén b é 0, non hai ecuacion
                return null;
            }
        }

        // Calcular o discriminante
        double discriminante = b * b - 4 * a * c;

        if (discriminante < 0) {
            // Se o discriminante é negativo, non hai solucions reais
            return null;
        } else if (discriminante == 0) {
            // Se o discriminante é 0, hai unha única solucion
           double solucion = -b / (2 * a);
            return new double[]{ solucion };
        } else {
            // Se o discriminante é positivo, hai dúas solucions reais
            double solucion1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double solucion2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return new double[]{ solucion1, solucion2 };
        }
    }

    // Método para formatear a solucion
   public static String formatSolution(double solucion) {
        return (solucion == (int) solucion) ? String.valueOf((int) solucion) : String.valueOf(solucion);
    }
}
