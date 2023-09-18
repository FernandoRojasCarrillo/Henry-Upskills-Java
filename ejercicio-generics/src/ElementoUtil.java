import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ElementoUtil<T extends Comparable<T>> {

    public void mostrarListado(List<T> lista) {
        for(T entero : lista) {
            System.out.println(entero);
        }
    }

    public T encontrarMaximo(List<? extends T> lista) {

        T maximo = lista.get(0);

        for (int i = 1; i < lista.size(); i++) {
            T elemento = lista.get(i);

            if (elemento.compareTo(maximo) > 0) {
                maximo = elemento;
            }

        }

        return maximo;
    }
}
