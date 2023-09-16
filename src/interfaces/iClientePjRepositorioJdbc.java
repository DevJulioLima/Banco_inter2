package interfaces;

import entidades.ClientePj;

import java.sql.SQLException;
import java.util.ArrayList;

public interface iClientePjRepositorioJdbc {
    public ClientePj listarPorNome(String nome) throws SQLException;
    public ClientePj listarPorCnpj(String cnpj) throws SQLException;
}
