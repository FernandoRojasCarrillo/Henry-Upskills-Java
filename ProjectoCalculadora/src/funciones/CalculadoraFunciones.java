package funciones;

import java.util.Arrays;

public class CalculadoraFunciones {

    public static float calcularPromedio(int[] notas) {
        float result = Arrays.stream(notas).reduce(0, (a, b) -> {
            return a + b;
        });
        return result / notas.length;
    }

    public static int encontrarNotaMasAlta(int[] notas) {
        int notaMasAlta = notas[0];
        for (int num : notas) {
            if (num > notaMasAlta) {
                notaMasAlta = num;
            }
        }
        return notaMasAlta;
    }

    public static int encontrarNotaMasBaja(int[] notas) {
        int notaMasBaja = notas[0];
        for (int num : notas) {
            if (num < notaMasBaja) {
                notaMasBaja = num;
            }
        }
        return notaMasBaja;
    }

    public static void mostrarResultadoDeNotas(int[] notas, float result) {
        for (int i = 0; i < notas.length; i++) {
            int estudiante = i + 1;
            System.out.println("| Estuandiante " + estudiante + " | nota " + notas[i] + " |");
        }
        System.out.println("| Resultado:     |    " + result + " |");
    }

}
