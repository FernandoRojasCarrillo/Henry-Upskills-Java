import java.util.Set;
import java.util.TreeSet;

public class EjemploImplementacionesSet {

    public static void ejecutarAgregacionDeSet(Set<String> setPaises) {

        setPaises.add("Argentina");
        setPaises.add("Colombia");
        setPaises.add("Brasil");

        boolean esDuplicado = setPaises.add("Chile");
        System.out.println("¿Se agrego elemento al conjunto? " + esDuplicado);


        System.out.println("MOSTRANDO LISTADO");
        for (String pais : setPaises) {
            System.out.println(pais);
        }
    }

    public static void mostrarPaises(Set<String> setPaises) {
        Set<String> setPaisesOrdenados = new TreeSet<>(setPaises);

        System.out.println("\nMOSTRANDO LISTADO CON THEESET");
        System.out.println("Conjunto de paises");
        for (String paises : setPaisesOrdenados) {
            System.out.println(paises);
        }

    }
}
