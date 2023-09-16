package interfaces;

import entidades.Funcionario;

import java.util.ArrayList;

public interface iFuncionarioServico {
    public void cadastrar(Funcionario funcionario);
    public void cadastrar(String nome);
    public void alterar(Funcionario funcionario);
    public ArrayList<Funcionario> pesquisar(String nome);
    public void excluir(Funcionario funcionario);
}
