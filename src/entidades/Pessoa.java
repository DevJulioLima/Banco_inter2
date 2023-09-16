package entidades;

import java.util.Date;

public abstract class Pessoa {
    private boolean tipoCliente;
    private String nome;
    private String email;
    private Date dataDeNasimento;
    private String telefone;
    private String rg;
    private String cpf;


    public Pessoa(boolean tipoCliente,String nome, String email, Date dataDeNasimento, String telefone, String rg, String cpf) {
        this.tipoCliente = tipoCliente;
        this.nome = nome;
        this.email = email;
        this.dataDeNasimento = dataDeNasimento;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
    }

    public boolean isTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeNasimento() {
        return dataDeNasimento;
    }

    public void setDataDeNasimento(Date dataDeNasimento) {
        this.dataDeNasimento = dataDeNasimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
