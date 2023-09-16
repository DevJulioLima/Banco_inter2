package interfaces;

import entidades.Funcionario;

import java.util.ArrayList;

public interface iFuncionarioRepositorio {
    public ArrayList<Funcionario> pesquisarPorNome(String nome);
    public ArrayList<Funcionario> pesquisarPorCpf(String cpf);
}
