import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploFuncionalMap {


    public static void aproximacionImperativa(List<Persona> personas) {
        List<PersonaTransfer> personasTransfers = new ArrayList<>();

        for (Persona persona : personas) {
            PersonaTransfer personaTransfer = PersonaTransfer.map(persona);
            personasTransfers.add(personaTransfer);
        }

        for (PersonaTransfer personaTransfer : personasTransfers) {
            System.out.println(personaTransfer);
        }
    }

    public static void aproximacionDeclarativa(List<Persona> personas) {
         List<PersonaTransfer> personaTransferList = personas.stream()
                .map(persona -> PersonaTransfer.map(persona))
                .collect(Collectors.toList());
         personaTransferList.forEach(System.out::println);
    }
}
