public class EjemploEqualsIgnoreCase {
    public static void ejecutarEqualsIgnoreCase() {
        String texto1 = "mundo";
        String texto2 = "MUNDO";

        boolean sonIguales = texto1.equalsIgnoreCase(texto2);
        System.out.println("Los strings son iguales? " + sonIguales);

    }
}
