import java.util.Scanner;

import static funciones.CalculadoraFunciones.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("¡Bienvenido! por favor ingresa la catidad de estudiantes.");
        Scanner scanner = new Scanner(System.in);

        int numeroEstudiantes = scanner.nextInt();
        int[] Calificaciones = new int[numeroEstudiantes];

        for (int i = 0; i < Calificaciones.length; i++) {
            int numEstudiante = i + 1;
            Scanner scannerNota = new Scanner(System.in);
            System.out.println("Ingresa la calificación del estudiante #" + numEstudiante);
            int notaEstudiante = scannerNota.nextInt();

            Calificaciones[i] = notaEstudiante;
        }


        System.out.println("Menú de opciones:");
        System.out.println();
        System.out.println("> Promedio de las calificaciones: opción (1).");
        System.out.println("> Calificación más alta: opción (2).");
        System.out.println("> Calificación más baja: opción (3).");
        System.out.println("> Salir del programa: opcion (0).");

        Scanner scannerOpciones = new Scanner(System.in);
        int opcionSeleccionada = scannerOpciones.nextInt();

        float result = switch (opcionSeleccionada) {
            case 1 -> calcularPromedio(Calificaciones);
            case 2 -> encontrarNotaMasAlta(Calificaciones);
            case 3 -> encontrarNotaMasBaja(Calificaciones);
            default -> 0;
        };

        mostrarResultadoDeNotas(Calificaciones, result);
        scannerOpciones.close();
    }
}