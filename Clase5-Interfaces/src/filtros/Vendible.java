package filtros;

import clases.Producto;
import interfaces.Filtrable;

public class Vendible implements Filtrable {
    @Override
    public boolean cumpleFiltro(Producto producto) {
        return producto.getPrecio() > 0;
    }
}
