import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploInicial {

    public static void aproximacionImperativa(List<Persona> personas) {
        List<Persona> personasJovenes = new ArrayList<>();
        int contador = 0;
        int limite = 2;

        for (Persona persona : personas ) {
            if (persona.getEdad() <= 18) {
                personasJovenes.add(persona);
                contador++;
            }

            if (contador == limite) {
                break;
            }
        }

        for (Persona personaJoven : personasJovenes ) {
            System.out.println(personaJoven);
        }
    }

    public static void aproximacionDeclarativa(List<Persona> personas) {
        List<Persona> personasJovenes = personas.stream()
                .filter(persona -> persona.getEdad() <= 18)
                .limit(2)
                .collect(Collectors.toList());

        personasJovenes.forEach(System.out::println);
    }
}
