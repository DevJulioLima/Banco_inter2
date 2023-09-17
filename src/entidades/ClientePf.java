package entidades;
import entidades.Pessoa;

import java.sql.Date;
import java.util.ArrayList;


public class ClientePf extends Pessoa{
    private float rendaMensal;

    private ArrayList<ClientePf> clientePf = new ArrayList<ClientePf>();

    public ClientePf() {
    }

    public ClientePf (float rendaMensal, boolean tipoCliente, String nome, String email, Date dataDeNascimento, String telefone,
                      String rg, String cpf, int id) {
        super(tipoCliente, nome, email, dataDeNascimento, telefone, rg, cpf, id);

        this.rendaMensal = rendaMensal;
    }

    public float getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
