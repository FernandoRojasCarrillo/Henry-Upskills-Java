public class Programador extends Persona{
    private boolean TieneComputadora;
    private int SueldoAnual;
    private String[] LenguajesProgramacion;

    public Programador() {}

    public Programador(String fistName, String lastName) {
        super(fistName, lastName);
    }

    public Programador(String firstName, String lastName, double height, String nationality, int age, boolean tieneComputadora, int sueldoAnual, String[] lenguajesProgramacion) {
        super(firstName, lastName, height, nationality, age);
        TieneComputadora = tieneComputadora;
        SueldoAnual = sueldoAnual;
        LenguajesProgramacion = lenguajesProgramacion;
    }

    @Override
    public String getFullName() {
        return "El nombre del programador es: " + this.getFirstName() + " " + this.getLastName();
    }

    public boolean isTieneComputadora() {
        return TieneComputadora;
    }

    public void setTieneComputadora(boolean tieneComputadora) {
        TieneComputadora = tieneComputadora;
    }

    public int getSueldoAnual() {
        return SueldoAnual;
    }

    public void setSueldoAnual(int sueldoAnual) {
        SueldoAnual = sueldoAnual;
    }

    public String[] getLenguajesProgramacion() {
        return LenguajesProgramacion;
    }

    public void setLenguajesProgramacion(String[] lenguajesProgramacion) {
        LenguajesProgramacion = lenguajesProgramacion;
    }
}
