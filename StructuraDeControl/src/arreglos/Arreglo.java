package arreglos;

import java.util.Arrays;
import java.util.Scanner;

public class Arreglo {
    public static void ejecutarArrayUnidimencional() {
        int[] numeros = new int[4];

        numeros[0] = 5;
        numeros[1] = 23;
        numeros[2] = 45;
        numeros[3] = 55;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("El npumero es: " + numeros[i]);
        }
    }

    public static void ejecutarArrayMultidimencional() {
        int[][] matriz = new int[3][3];

        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[2][0] = 7;
        matriz[2][1] = 8;
        matriz[2][2] = 9;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void prueba() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];

        int index = 0;

        do {
            System.out.println("Please enter a number: ");
            int number = scanner.nextInt();
            array[index] = number;
            index++;

        } while (index < array.length);

        int counter = 0;
        for( int num : array ) {
            counter += num;
        }

        System.out.println(Arrays.toString(array));
        System.out.println("Result: " + counter);
    }
}
