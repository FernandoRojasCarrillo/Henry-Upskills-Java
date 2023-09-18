import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EjemploImplementacionesList {
    public static void ejecutarEjemploArrayList() {
        List<String> arrayList = new ArrayList<>();

        arrayList.add("Manzana");
        arrayList.add("Banana");
        arrayList.add(2, "Naranja");

        String primerElemento = arrayList.get(1);
        String segundoElemento = arrayList.get(2);

        System.out.println("Todos los elementos: " + arrayList);
        System.out.println("Elemento 1: " + primerElemento);
        System.out.println("Elemento 2: " + segundoElemento);

        System.out.println("\nIteracion con bucle for");

        for (String elemento : arrayList) {
            System.out.println("Elemento: " + elemento);
        }

        boolean contieneNaranja = arrayList.contains("Kiwi");
        System.out.println("¿El ArrayList contiene Naranja? " + contieneNaranja);

        int cantidadDeElementos = arrayList.size();
        System.out.println("Tamaño del ArrayList " + cantidadDeElementos);
    }

    public static void ejecutarEjemploLinkedList() {
        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        linkedList.remove(Integer.valueOf(20));

        System.out.println("BLUCKE DE LINKEDLIST");
        for (Integer num : linkedList) {
            System.out.println(num);
        }

        boolean contains20 = linkedList.contains(20);
        System.out.println("¿La lista contiene el número 20? " + contains20);

        int cantidadElementos = linkedList.size();
        System.out.println("Cantidad elementos: " + cantidadElementos);
    }
}
