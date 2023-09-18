package bucles;

import java.util.Scanner;

public class WhileDoWhile {

    public static void ejecutarDoWhile() {
        int numero;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Ingrese un número entre 1 y 10");
            numero = scanner.nextInt();
        } while (numero < 1 || numero > 8);

        System.out.println("El número ingredado es: " + numero);
        scanner.close();
    }

    public static void ejecutarWhile() {
        int contador = 1;

        while(contador <= 5) {
            System.out.println("El valor del contardor es: " + contador);
            contador++;
        }

    }
}
