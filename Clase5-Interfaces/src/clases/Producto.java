package clases;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;
    private int codigo;

    public Producto(String nombre, double precio, int codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int compareTo(Producto otroProducto) {
        return Double.compare(this.precio, otroProducto.precio);
    }

    @Override
    public String toString() {
        return "clases.Producto: " + nombre + " | Precio: $" + precio + " | Código: " + codigo;
    }
}
