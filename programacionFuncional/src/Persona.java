public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;

    public Persona() {}

    public Persona(Integer id, String nombre, String apellido, String email, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona(" +
                "id: " + id +
                ", nombre: " + nombre +
                ", apellido: " + apellido +
                ", email: " + email +
                ", edad: " + edad +
                ")";
    }
}
