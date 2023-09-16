package interfaces;

import entidades.ClientePj;

import java.util.ArrayList;

public interface iClientePjServico {
    public void cadastrar(ClientePj clientePj);
    public void cadastrar(String nome);
    public void alterar(ClientePj clientePj);
    public ArrayList<ClientePj> pesquisar(String nome);
    public void excluir(ClientePj clientePj);
}
