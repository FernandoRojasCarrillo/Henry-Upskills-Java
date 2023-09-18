import com.github.mrebhan.crogamp.cli.TableList;

import java.util.List;
// import com.github.mrebhan.crogamp.cli.TableList;

public class MostrarTabla {


    public static <T> void ImprimirTabla(List<List<T>> elementosDeLaLista) {

        TableList table = new TableList(2, "FirstName", "LastName")
                .sortBy(0)
                .withUnicode(true);


        elementosDeLaLista
                .forEach(elemento ->
                        table.addRow(
                                String.valueOf(elemento.get(0)),
                                String.valueOf(elemento.get(1))
                        )
                );

        table.print();
    }
}
