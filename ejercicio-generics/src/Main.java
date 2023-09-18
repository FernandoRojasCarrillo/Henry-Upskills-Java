import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer>  listaEnteros = Arrays.asList(1, 2, 3, 4, 5);

        List<String> listaCadenas = Arrays.asList("Hola", "Mundo", "Generics");

        ElementoUtil<Integer> utilEntero = new ElementoUtil<>();
        utilEntero.mostrarListado(listaEnteros);

        ElementoUtil<String> utilString = new ElementoUtil<>();
        utilString.mostrarListado(listaCadenas);



        Integer maximoEntero = utilEntero.encontrarMaximo(listaEnteros);
        System.out.println("El maximo de la lista de enteros es: " + maximoEntero);

        String maximoString = utilString.encontrarMaximo(listaCadenas);
        System.out.println("El valor maximo de la lista de strings es: " + maximoString);


            List<String> nombres = new ArrayList<>();

            nombres.add("Alice");

            nombres.add("Bob");

            nombres.add("Charlie");


            boolean resultado = nombres.stream()
                    .anyMatch(nombre -> nombre.length() > 5);


            System.out.println(resultado);


    }
}