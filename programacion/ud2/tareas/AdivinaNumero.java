import java.util.Scanner;

public class AdivinaNumero {
    private static int numInt = 5; // numero de intentos por defecto
    private static int numMax = 10; // numero máximo por defecto

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Configurar");
            System.out.println("2. Xogar");
            System.out.println("3. Sair");
            System.out.print("Selecciona unha opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    configurar(scanner);
                    break;
                case 2:
                    xogar(scanner);
                    break;
                case 3:
                    System.out.println("Saindo do xogo. Grazas por xogar!");
                    break;
                default:
                    System.out.println("Opcion non valida. Por favor, elixe de novo.");
            }

        } while (opcion != 3);
    }

    private static void configurar(Scanner scanner) {
        System.out.print("Introduce o numero de intentos permitidos: ");
        numInt = scanner.nextInt();
        System.out.print("Introduce o numero máximo a xerar: ");
        numMax = scanner.nextInt();
        System.out.println("Configuracion actualizada: Intentos = " + numInt + ", Máximo = " + numMax);
    }

    private static void xogar(Scanner scanner) {
        int numOculto = (int) Math.floor(Math.random() * (numMax + 1)); // numero aleatorio entre 0 e numMax
        int intentosRestantes = numInt;
        boolean adivinado = false;

        System.out.println("Adiviña o numero entre 0 e " + numMax + "! Tes " + numInt + " intentos.");

        while (intentosRestantes > 0 && !adivinado) {
            System.out.print("Introduce o teu intento: ");
            int intento = scanner.nextInt();
            intentosRestantes--;

            if (intento == numOculto) {
                adivinado = true;
                System.out.println("Ganaches! Necesitaches " + (numInt - intentosRestantes) + " intentos.");
            } else if (intento < numOculto) {
                System.out.println("O numero oculto e maior. Intentos restantes: " + intentosRestantes);
            } else {
                System.out.println("O numero oculto e menor. Intentos restantes: " + intentosRestantes);
            }
        }

        if (!adivinado) {
            System.out.println("Perdiches! Intentos esgotados. O numero oculto era: " + numOculto);
        }
    }
}
