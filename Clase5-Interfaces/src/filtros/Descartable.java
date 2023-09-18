package filtros;

import clases.Producto;
import interfaces.Filtrable;

public class Descartable implements Filtrable {
    @Override
    public boolean cumpleFiltro(Producto producto) {
        // Aquí podríamos definir criterios propios para determinar si un producto es descartable
        // Por ejemplo, si su código contiene la letra 'D':
        return producto.getNombre().toUpperCase().contains("DESCARTABLE");
    }
}
