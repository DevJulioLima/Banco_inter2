package interfaces;

import entidades.Funcionario;

import java.sql.SQLException;

public interface iFuncionarioRepositorioJdbc {
    public Funcionario listarPorNome(String nome) throws SQLException;
    public Funcionario listarPorCpf(String cpf) throws SQLException;
}
