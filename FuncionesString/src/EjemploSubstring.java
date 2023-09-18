public class EjemploSubstring {
    public static void ejecutarSubstring() {
        String texto = "Hola Mundo Java";
        String subcadena = texto.substring(5, 10);
        System.out.println("El nuevo string es: " + subcadena);

        String subcadenajava = texto.substring(11);
        System.out.println("El nuevo string es: " + subcadenajava);
    }
}
