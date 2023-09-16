package entidades;

public class ClientePf {
    private double rendaMensal;

    public ClientePf() {
    }

    public ClientePf(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
