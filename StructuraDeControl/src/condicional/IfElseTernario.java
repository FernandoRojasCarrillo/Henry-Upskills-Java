package condicional;

import java.sql.SQLOutput;

public class IfElseTernario {
    public static void ejecutarCondicional() {
        int numero = 8;
        /*if (numero % 2 == 0) {
            System.out.println("El número es par");
        } else {
            System.out.println("El número es inpar");
        }*/

        String resultado = numero % 2 == 0
                ? "El número es par"
                : "El número es inpar";
        System.out.println("El resultado de la valicación es: " + resultado);
    }
}
