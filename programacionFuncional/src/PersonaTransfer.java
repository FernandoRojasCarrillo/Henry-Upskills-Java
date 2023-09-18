public class PersonaTransfer {
    private Integer id;
    private String nombre;
    private String apellido;

    public PersonaTransfer() {}

    public PersonaTransfer(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona(" +
                "id: " + id +
                ", nombre: " + nombre +
                ", apellido: " + apellido +
                ")";
    }

    public static PersonaTransfer map(Persona persona) {
        return new PersonaTransfer(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido()
        );
    }
}
