package interfaces;

import clases.Producto;

@FunctionalInterface
public
interface Filtrable {
    boolean cumpleFiltro(Producto producto);
}
