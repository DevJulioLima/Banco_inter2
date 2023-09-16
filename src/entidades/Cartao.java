package entidades;

import java.util.Date;

public class Cartao {
    private float credito;
    private String numeroCartao;
    private boolean bandeira;
    private String cvv;
    private Date validade;
    private float fatura;

    public Cartao() {
    }

    public Cartao(float credito, String numeroCartao, boolean bandeira, String cvv, Date validade,float fatura) {
        this.credito = credito;
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.cvv = cvv;
        this.validade = validade;
        this.fatura = fatura;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public boolean getBandeira() {
        return bandeira;
    }

    public void setBandeira(boolean bandeira) {
        this.bandeira = bandeira;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public float getFatura(){
        return fatura;
    }

    public void setFatura (float fatura){
        this.fatura = fatura;
    }
}

