import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();

        System.out.println("Gestión de diccionario etilizando un Map");
        EjemploMap.gestionarDiccionario(hashMap);



        EjemploMap.mostrarDiccionario(hashMap);
    }
}