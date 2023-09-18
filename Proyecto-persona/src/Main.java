public class Main {
    public static void main(String[] args) {

        Empresario empresario = new Empresario(
                "Axel",
                "Smith",
                1.80,
                "USD Citizen",
                40,
                "Nombre Empresa",
                2021,
                300

        );

        Piloto piloto = new Piloto("Tom", "Holland");

        Programador programador = new Programador("Thomas", "Carter");

        System.out.println(empresario.getFullName());
        System.out.println(piloto.getFullName());
        System.out.println(programador.getFullName());
    }
}