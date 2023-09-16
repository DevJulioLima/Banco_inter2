package interfaces;

import entidades.ClientePj;

import java.util.ArrayList;

public interface iClientePjRepositoporio {
    public ArrayList<ClientePj> pesquisarPorNome(String nome);
    public ArrayList<ClientePj> pesquisarPorCnpj(String cnpj);
}
