public class AutoDeportivo extends Automovil {
    private boolean esConvertible;

    public AutoDeportivo() {};

    public AutoDeportivo(String marca) {
        super(marca);
    }

    public AutoDeportivo(String marca, String modelo, int anioFabricacio, boolean esConvertible) {
        super(marca, modelo, anioFabricacio);
        this.esConvertible = esConvertible;
    }

    @Override
    public void acelerar() {
        System.out.println("Acelera rapoido");
    }

    public boolean getEsConvertible() {
        return esConvertible;
    }

    public void setEsConvertible(boolean esConvertible) {
        this.esConvertible = esConvertible;
    }
}
