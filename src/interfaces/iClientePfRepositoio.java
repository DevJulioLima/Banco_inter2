package interfaces;

import entidades.ClientePf;

import java.util.ArrayList;

public interface iClientePfRepositoio {
    public ArrayList<ClientePf> pesquisarPorNome(String nome);
    public ArrayList<ClientePf> pesquisarPorCpf(String cpf);
}
