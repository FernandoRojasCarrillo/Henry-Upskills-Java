import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<List<String>> lista = Arrays.asList(
                Arrays.asList("Tom", "Holland"),
                Arrays.asList("Thomas", "Smith"),
                Arrays.asList("Thomas", "Smith"),
                Arrays.asList("Thomas", "Smith"),
                Arrays.asList("Thomas", "Smith"),
                Arrays.asList("Thomas", "Smith"),
                Arrays.asList("Thomas", "Smith"),
                Arrays.asList("Something", "Else")
        );

        MostrarTabla.ImprimirTabla(lista);
    }
}