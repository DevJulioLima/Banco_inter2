package repositorios;

import entidades.ClientePj;
import interfaces.iClientePjRepositorioJdbc;

import java.sql.*;
import java.util.ArrayList;

public class ClientePjMysqlRepositorio implements iClientePjRepositorioJdbc {
    private Connection conn;
    public ClientePjMysqlRepositorio(){
        try{
            //this.conn = ConnectionSingleton.getInstance().conexao;
        } catch (Exception e){
            System.out.println("Error:\n" + e);
        }
    }
    public long cadastrar (ClientePj clientePj) throws Exception {

        try{
            String sql_clientePj = "INSERT INTO sistema"
                    + "(tipoCliente, nome, nomeFantasia, email, dataDeNascimento, cnpj, telefone)"
                    + "VALUES(?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql_clientePj, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, clientePj.isTipoCliente());
            ps.setString(2, clientePj.getNome());
            ps.setString(3, clientePj.getNomeFantasia());
            ps.setString(4, clientePj.getEmail());
            ps.setDate(5, clientePj.getDataDeNascimento());
            ps.setString(6, clientePj.getCnpj());
            ps.setString(7, clientePj.getTelefone());

            // Execulta a instrução

            int retorno = ps.executeUpdate();
            System.out.println("Aquisalvo");
            if(retorno == 0){
                throw new SQLException("persistencia do CLIENTEPJ falhou , ID do CLIENTEPJ não foi gerado.");
            }
            try (ResultSet generatedkeys = ps.getGeneratedKeys()){
                if (generatedkeys.next()){
                    return generatedkeys.getLong(1);
                }else{
                    throw new SQLException("persistencia do CLIENTEPF falhou , ID do CLIENTEPF não foi gerado.");
                }
            }
        }catch (SQLException e2){
            System.out.printf("Erro:%s", e2.getMessage());
            throw new SQLException("persistencia do CLIENTEPF falhou");
        }
    }

    public void alterar(ClientePj clientePj) throws SQLException{
        try{

            String sqlClientePj = "UPDATE clientePj SET nomeFantasia=?, tipoCliente=?"
                    + ", email=?, telefone=?;";

            PreparedStatement ps = conn.prepareStatement(sqlClientePj);
            ps.setString(1, clientePj.getNomeFantasia());
            ps.setBoolean(2, clientePj.isTipoCliente());
            ps.setString(3, clientePj.getEmail());
            ps.setString(4, clientePj.getTelefone());
            System.out.println(">>>ALTERAR: " + clientePj.getNomeFantasia());
            int retorno = ps.executeUpdate();

            if (retorno == 0){
                throw new SQLException("Alteração do CLIENTEPJ falhou");
            }
        } catch (SQLException e2){
            System.out.printf("Error:%s", e2.getMessage());
            throw new SQLException("Alteração do CLIENTEPJ falhou");
        }
    }

    public ArrayList<ClientePj> listarTodos() throws SQLException{
        String sql="SELECT idClientePj, tipoCliente, nomeFantasia, nome, dataDeNascimento, telefone, cnpj";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<ClientePj> clientesPj = new ArrayList<>();
        while (rs.next()){
            try{
                ClientePj clientePj = new ClientePj();
                clientePj.setId(rs.getInt("idClientePj"));
                clientePj.setNomeFantasia(rs.getString("nomeFantasia"));

                clientePj.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                clientesPj.add(clientePj);
            }catch (SQLException e1){
                System.out.println(e1);
            }
        }
        return clientesPj;
    }

    public void excluir(ClientePj clientePj){

    }

    public ClientePj listaPorCodigo(int codigo) throws SQLException{
        String sql="SELECT idClientePj, tipoCliente, nomeFantasia, email, dataDeNascimento, telefone, cnpj"
                + "FROM clientePj where idClientePj=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        rs.next();

        ClientePj clientePj = new ClientePj();
        clientePj.setId(rs.getInt("idClientePj"));
        clientePj.setTipoCliente(rs.getBoolean("tipoCliente"));
        clientePj.setNome(rs.getString("nomeFantasia"));
        clientePj.setTelefone(rs.getString("telefone"));
        clientePj.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        clientePj.setCnpj(rs.getString("cnpj"));

        return clientePj;
    }


    @Override
    public ClientePj listarPorNome(String nomeFantasia) throws SQLException {
        String sql="SELECT nomeFantasia, idClientePj, tipoCliente, nomeFantasia, email, dataDeNascimento, telefone, cnpj"
                + "FROM clientePj where idClientePj=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nomeFantasia);
        ResultSet rs = ps.executeQuery();
        rs.next();

        ClientePj clientePj = new ClientePj();
        clientePj.setNomeFantasia(rs.getString("nomeFantasia"));
        clientePj.setId(rs.getInt("idClientePj"));
        clientePj.setTipoCliente(rs.getBoolean("tipoCliente"));
        clientePj.setTelefone(rs.getString("telefone"));
        clientePj.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        clientePj.setCnpj(rs.getString("cnpj"));

        return clientePj;
    }



    @Override
    public ClientePj listarPorCnpj(String cnpj) throws SQLException {
        String sql="SELECT cnpj, idClientePj, tipoCliente, nomeFantasia, email, dataDeNascimento, telefone, cnpj"
                + "FROM clientePj where idClientePj=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cnpj);
        ResultSet rs = ps.executeQuery();
        rs.next();

        ClientePj clientePj = new ClientePj();
        clientePj.setCnpj(rs.getString("cnpj"));
        clientePj.setId(rs.getInt("idClientePj"));
        clientePj.setTipoCliente(rs.getBoolean("tipoCliente"));
        clientePj.setNome(rs.getString("nomeFantasia"));
        clientePj.setTelefone(rs.getString("telefone"));
        clientePj.setDataDeNascimento(rs.getDate("dataDeNascimento"));

        return clientePj;
    }

    }

