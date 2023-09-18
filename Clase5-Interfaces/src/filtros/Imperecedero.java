package filtros;

import clases.Producto;
import interfaces.Filtrable;

public class Imperecedero implements Filtrable {
    @Override
    public boolean cumpleFiltro(Producto producto) {
        // Aquí podríamos definir criterios propios para determinar si un producto es imperecedero
        // Por ejemplo, si su precio es mayor que 100:
        return producto.getPrecio() > 100;
    }
}