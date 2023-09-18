public class Piloto extends Persona{
    private boolean TieneLicencia;
    private String aerolinea;

    public Piloto() {}

    public Piloto(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Piloto(String firstName, String lastName, double height, String nationality, int age, boolean tieneLicencia, String aerolinea) {
        super(firstName, lastName, height, nationality, age);
        TieneLicencia = tieneLicencia;
        this.aerolinea = aerolinea;
    }

    @Override
    public String getFullName() {
        return "El nombre del piloto es: " + this.getFirstName() + " " + this.getLastName();
    }

    public boolean isTieneLicencia() {
        return TieneLicencia;
    }

    public void setTieneLicencia(boolean tieneLicencia) {
        TieneLicencia = tieneLicencia;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
}
