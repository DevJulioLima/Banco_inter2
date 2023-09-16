package entidades;

import java.util.Date;

public class Cartao {
    private String credito;
    private String numeroCartao;
    private String bandeira;
    private String cvv;
    private Date validade;
    private String fatura;

    public Cartao() {
    }

    public Cartao(String credito, String numeroCartao, String bandeira, String cvv, Date validade, String fatura) {
        this.credito = credito;
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.cvv = cvv;
        this.validade = validade;
        this.fatura = fatura;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
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

    public String getFatura(){
        return fatura;
    }

    public void setFatura(String fatura){
        this.fatura = fatura;
    }
}

