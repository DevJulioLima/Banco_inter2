package servicos;

import entidades.ClientePf;
import interfaces.iClientePfServico;
import repositorios.ClientePfArrayListRepositorio;

import java.util.ArrayList;

public class ClientePfServico implements iClientePfServico {

    private ClientePfArrayListRepositorio repositorioClientePf = null;

    public ClientePfServico(ClientePfArrayListRepositorio repositorioClientePf){
        this.repositorioClientePf = repositorioClientePf;
    }

    @Override
    public void cadastrar(ClientePf clientePf) {

        if(clientePf.getNome().isBlank())
            System.out.println("NOME EM BRANCO!");
        else{
            if(clientePf.getNome().isEmpty())
                System.out.println("NOME VAZIO!");
            else{
                if(clientePf.getNome().length() <= 4)
                    System.out.println("DIGITE SEU NOME COMPLETO!");
                else{
                    if(clientePf.getCpf().length() != 11)
                        System.out.println("CPF INCORRETO!");
                    else{
                        if(clientePf.getEmail().length() <= 15)
                            System.out.println("DIGITE UM EMAIL VALIDO!");
                        else{
                            if(clientePf.getTelefone().length() != 11)
                                System.out.println("DIGITE UM NUMERO DE TELEFONE VALIDO! APENAS NUMEROS!");
                            else{
                                if(clientePf.getRg().length() != 8)
                                    System.out.println("DIGITE O NUMERO DE RG VALIDO");
                                else{
                                    repositorioClientePf.salvar(clientePf);
                                }
                            }
                        }
                    }
                }
            }
        }



    @Override
    public void alterar(ClientePf ) {
            if(clientePf.getEmail().length() <= 15)
                System.out.println("DIGITE UM EMAIL VALIDO!");
            else{
                if(clientePf.getTelefone().length() != 11)
                    System.out.println("DIGITE UM NUMERO DE TELEFONE VALIDO! APENAS NUMEROS!");
                else{
                    repositorioClientePf.alterar(clientePf);
                }
    }

            }



    @Override
    public ArrayList<ClientePf> pesquisar(String nome) {
        return null;
    }

    @Override
    public void excluir(ClientePf clientePf) {

    }

}
