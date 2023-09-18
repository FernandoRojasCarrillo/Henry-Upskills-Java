public class Persona {
    private String nombre;
    private int edad;
    private String hobby;

    public Persona() {}

    public Persona(String nombre, int edad, String hobby) {
        this.nombre = nombre;
        this.edad = edad;
        this.hobby = hobby;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
