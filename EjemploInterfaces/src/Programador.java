public class Programador extends Persona implements Habilidad, Informacion, Comparable<Programador> {
    private String lenguajePrincipal;

    public Programador() {}

    public Programador(String nombre, int edad, String hobby, String lenguajePrincipal) {
        super(nombre, edad, hobby);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public void mostrarHabilidadPrincipal() {
        System.out.println(this.getNombre() + "es un programador especializado en " + this.lenguajePrincipal);
    }

    @Override
    public void mostrarInformaciónAdicional() {
        System.out.println("Información adicional sobre " + this.getNombre() + ": Edad: " + this.getEdad() + ", Hobby: " + this.getHobby());
    }

    @Override
    public int compareTo(Programador programador) {
        return this.getNombre().compareTo(programador.getNombre());
    }
}
