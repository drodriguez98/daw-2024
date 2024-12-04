import java.util.Scanner;

public class SustituirTexto {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            // Solicitar tres cadeas de texto
            System.out.print("Cadea 1: ");
            String cadea1 = scanner.nextLine();
            System.out.print("Cadea 2: ");
            String cadea2 = scanner.nextLine();
            System.out.print("Cadea 3: ");
            String cadea3 = scanner.nextLine();

            // Substituír o segundo texto polo terceiro
            String resultado = substituirTexto(cadea1, cadea2, cadea3);

            // Mostrar o resultado
            System.out.println("Resultado: " + resultado);

        } catch (Exception e) {
            System.out.println("Produciuse un erro: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close(); // Cerrar o scanner correctamente
            }
        }
    }

    // Método para substituir o segundo texto polo terceiro na primeira cadea
    public static String substituirTexto(String cadea1, String cadea2, String cadea3) {
        StringBuilder resultado = new StringBuilder();
        int posicionActual = 0; // Posición actual na cadea1

        while (posicionActual < cadea1.length()) {
            // Buscar a posición do próximo cadea2 na cadea1
            int indice = cadea1.indexOf(cadea2, posicionActual);

            if (indice == -1) {
                // Se non hai máis ocorrencias, engadir o resto da cadea
                resultado.append(cadea1.substring(posicionActual));
                break;
            }

            // Engadir a parte da cadea antes da ocorrencia de cadea2
            resultado.append(cadea1.substring(posicionActual, indice));

            // Engadir cadea3 no lugar de cadea2
            resultado.append(cadea3);

            // Actualizar a posición actual para continuar a búsqueda
            posicionActual = indice + cadea2.length();
        }

        return resultado.toString();
    }
}
