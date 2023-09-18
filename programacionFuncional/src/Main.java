import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Persona> personas = new ArrayList<>();
        agregarPersonas(personas);

        // EjemploInicial.aproximacionImperativa(personas);
        // EjemploInicial.aproximacionDeclarativa(personas);
        // EjemploFuncionalMap.aproximacionImperativa(personas);
        EjemploFuncionalMap.aproximacionDeclarativa(personas);
    }

    public static void agregarPersonas(List<Persona> personas) {
        personas.add(new Persona(1, "Tom", "Holland", "holland@gmail.com", 13));
        personas.add(new Persona(2, "Thomas", "Smith", "thomas@gmail.com", 17));
        personas.add(new Persona(3, "Axel", "Snow", "snow@gmail.com", 18));
    }
}
