public abstract class Automovil {
    private String marca;
    private String modelo;
    private int AnioFabricación;

    public Automovil() {
    }

    public Automovil(String marca) {
        this.marca = marca;
    }

    public Automovil(String marca, String modelo, int anioFabricación) {
        this.marca = marca;
        this.modelo = modelo;
        this.AnioFabricación = anioFabricación;
    }

    public abstract void acelerar();

    String frenar() {
        return "Frenando";
    }

    public void setMarca(String value) {
        this.marca = value;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

}
