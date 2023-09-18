public class EjemploConcat {
    public static void ejecutarConcat() {
        String texto = "Hola Mundo";
        String texto2 = " Java";

        String textoConcatenado = texto.concat(texto2);
        System.out.println("El texto concatenado es: " + textoConcatenado);
    }
}
