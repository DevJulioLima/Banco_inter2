package interfaces;

import entidades.ClientePf;

import java.sql.SQLException;
import java.util.ArrayList;

public interface iClientePfRepositorioJdbc {
    public ClientePf listarPorNome(String nome) throws SQLException;
    public ClientePf listarPorCpf(String cpf) throws SQLException;
}
