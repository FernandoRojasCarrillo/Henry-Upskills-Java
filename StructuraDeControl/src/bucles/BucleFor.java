package bucles;

public class BucleFor {
    public static void ejecutarForeach() {
        int[] numeros = {1, 2, 3, 4, 5};

        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }
    }

    public static void  ejecutarFor() {

        int[] numeros = new int[5];

        for (int i = 1; i <= numeros.length; i++) {
            System.out.println("El número es: " + i);
        }
    }
}
