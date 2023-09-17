package repositorios;

import entidades.ClientePf;
import interfaces.iClientePfRepositorio;

import java.util.ArrayList;

public class ClientePfArrayListRepositorio implements iClientePfRepositorio {

    public ArrayList<ClientePf> clientePf = new ArrayList<>();

    public ClientePfArrayListRepositorio(ArrayList<ClientePf> clientePf){
        this.clientePf = clientePf;
    }
    @Override
    public ArrayList<ClientePf> pesquisarPorNome(String nome) {
        return null;
    }

    @Override
    public ArrayList<ClientePf> pesquisarPorCpf(String cpf) {
        return null;
    }

    public void salvar(ClientePf clientePf){

    }
    public void alterar(ClientePf clientePf){

    }
    public ArrayList<ClientePf> listarTodos(){
        return null;
    }
    public ClientePf listarPorCodigo(int codigo){
        return null;
    }
    public void excluir (ClientePf clientePf){

    }
}
