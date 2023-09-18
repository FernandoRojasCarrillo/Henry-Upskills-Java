import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //EjemploImplementacionesList.ejecutarEjemploArrayList();
        //EjemploImplementacionesList.ejecutarEjemploLinkedList();

        Set<String> hashSet = new HashSet<>();

        EjemploImplementacionesSet.ejecutarAgregacionDeSet(hashSet);

        EjemploImplementacionesSet.mostrarPaises(hashSet);
    }
}