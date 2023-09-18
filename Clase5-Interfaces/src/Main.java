import clases.Producto;
import filtros.Descartable;
import filtros.Imperecedero;
import filtros.Vendible;
import interfaces.Filtrable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear lista de productos
        List listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("clases.Producto 1", 50.0, 1));
        listaProductos.add(new Producto("clases.Producto 2", 25.0, 2));
        listaProductos.add(new Producto("clases.Producto 3", 150.0, 3));
        listaProductos.add(new Producto("filtros.Descartable 1", 5.0, 4));
        listaProductos.add(new Producto("filtros.Descartable 2", 10.0, 5));

        // Ordenar productos por precio
        Collections.sort(listaProductos);

        System.out.println("Lista de productos ordenada por precio:");
        listaProductos.forEach(System.out::println);

        // Filtrar y mostrar productos que cumplen con los filtros
        System.out.println("\nProductos que cumplen con el filtro 'filtros.Vendible':");
        Filtrable vendibleFiltro = new Vendible();
        filtrarProductos(listaProductos, vendibleFiltro).forEach(System.out::println);

        System.out.println("\nProductos que cumplen con el filtro 'filtros.Descartable':");
        Filtrable descartableFiltro = new Descartable();
        filtrarProductos(listaProductos, descartableFiltro).forEach(System.out::println);

        System.out.println("\nProductos que cumplen con el filtro 'filtros.Imperecedero':");
        Filtrable imperecederoFiltro = new Imperecedero();
        filtrarProductos(listaProductos, imperecederoFiltro).forEach(System.out::println);
    }

    private static List<Producto> filtrarProductos(List<Producto> productos, Filtrable filtro) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (filtro.cumpleFiltro(producto)) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
}