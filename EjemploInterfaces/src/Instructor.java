public class Instructor extends Persona
        implements Habilidad, Informacion {
    private String especialidad;

    public Instructor() {}

    public Instructor(String especialidad) {
        this.especialidad = especialidad;
    }

    public Instructor(String nombre, int edad, String hobby, String especialidad) {
        super(nombre, edad, hobby);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarHabilidadPrincipal() {
        System.out.println(getNombre() + "es un instructor especializado en " + this.especialidad);
    }

    @Override
    public void mostrarInformaciónAdicional() {
        System.out.println("Información adicional sobre " + getNombre() + ": Edad: " + getEdad() + ", Hobby: " + getHobby());
    }
}
