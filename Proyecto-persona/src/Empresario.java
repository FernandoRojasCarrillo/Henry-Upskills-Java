public class Empresario extends Persona {
    private String Empresa;
    private int AnioCreacionEmpresa;
    private int Empleados;

    public Empresario() {};

    public Empresario(String firstName, String lastName ) {
        super(firstName, lastName);
    };

    public Empresario(String firstName, String lastName, double height, String nationality, int age, String empresa, int anioCreacionEmpresa, int empleados) {
        super(firstName, lastName, height, nationality, age);
        Empresa = empresa;
        AnioCreacionEmpresa = anioCreacionEmpresa;
        Empleados = empleados;
    }

    public String getFullName() {
        return "El nombre comple del empresario es: " + this.getFirstName() + " " + this.getLastName();
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public int getAnioCreacionEmpresa() {
        return AnioCreacionEmpresa;
    }

    public void setAnioCreacionEmpresa(int anioCreacionEmpresa) {
        AnioCreacionEmpresa = anioCreacionEmpresa;
    }

    public int getEmpleados() {
        return Empleados;
    }

    public void setEmpleados(int empleados) {
        Empleados = empleados;
    }
}
