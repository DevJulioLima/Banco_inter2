package interfaces;

import entidades.ClientePf;

import java.util.ArrayList;

public interface iClientePfServico {
    public void cadastrar(ClientePf clientePf);
    public void cadastrar(String nome);
    public void alterar(ClientePf clientePf);
    public ArrayList<ClientePf> pesquisar(String nome);
    public void excluir(ClientePf clientePf);
}
