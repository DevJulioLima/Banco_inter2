package entidades;

public class Investimento {
    private String acoes;
    private String titulos;
    private double selic;

    public Investimento() {
    }

    public Investimento(String acoes, String titulos, double selic) {
        this.acoes = acoes;
        this.titulos = titulos;
        this.selic = selic;
    }

    public String getAcoes() {
        return acoes;
    }

    public void setAcoes(String acoes) {
        this.acoes = acoes;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public double getSelic() {
        return selic;
    }

    public void setSelic(double selic) {
        this.selic = selic;
    }
}
