package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class ClientePj extends Pessoa{
    private String cnpj;
    private String ie;
    private String nomeFantasia;

    private ArrayList<ClientePj> clientePj = new ArrayList<>();

    public ClientePj() {
    }

    public ClientePj(boolean tipoCliente, String nome, String email, Date dataDeNasimento, String telefone, String rg,
                     String cpf, int id, String cnpj, String ie, String nomeFantasia) {
        super(tipoCliente, nome, email, dataDeNasimento, telefone, rg, cpf, id);
        this.cnpj = cnpj;
        this.ie = ie;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
