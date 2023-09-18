public class Main {
    public static void main(String[] args) {

        Habilidad programadorHabil = new Programador(
                "Tom",
                27,
                "Video juegos",
                "Java"
        );
        programadorHabil.mostrarHabilidadPrincipal();

        Informacion programadorConInformacionExtra = new Programador(
                "Matias",
                28,
                "Leer",
                "Javascript"
        );
        programadorConInformacionExtra.mostrarInformaciónAdicional();
    }
}