package entidades;

import java.sql.Date;
import java.util.ArrayList;

public class Funcionario extends Pessoa{
    private String cargo;
    private float salario;

    private ArrayList<Funcionario> funcionario = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(boolean tipoCliente, String nome, String email, Date dataDeNasimento, String telefone,
                       String rg, String cpf, int id, String cargo, float salario) {
        super(tipoCliente, nome, email, dataDeNasimento, telefone, rg, cpf, id);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
