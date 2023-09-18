public class EjemploTrim {
    public static void ejecutarTrim() {
        String texto = "    Hola Mundo     ";
        String textoSinEspacios = texto.trim().toUpperCase();
        System.out.println(textoSinEspacios);
    }
}