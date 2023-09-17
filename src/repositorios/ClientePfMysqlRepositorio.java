package repositorios;


import entidades.ClientePf;
import interfaces.iClientePfRepositorioJdbc;

import java.sql.*;
import java.util.ArrayList;


public class ClientePfMysqlRepositorio implements iClientePfRepositorioJdbc {

    private Connection conn;
    public ClientePfMysqlRepositorio(){
        try{
            //this.conn = ConnectionSingleton.getInstance().conexao;
        } catch (Exception e) {
            System.out.println("Error:\n" + e);
        }
    }
    public long cadastrar(ClientePf clientePf) throws Exception {

        try{
            String sql_clientePf = "INSERT INTO sistema"
                    + "(tipoCliente, nome, email, dataDeNascimento, telefone, rg, cpf, rendaMensal)"
                    + "VALUES(?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql_clientePf, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1,clientePf.isTipoCliente());
            ps.setString(2, clientePf.getNome());
            ps.setString(3, clientePf.getEmail());
            ps.setDate(4, clientePf.getDataDeNascimento());
            ps.setString(5, clientePf.getTelefone());
            ps.setString(6, clientePf.getRg());
            ps.setString(7, clientePf.getCpf());
            ps.setFloat(8, clientePf.getRendaMensal());

            // Execulta a instrução

            int retorno = ps.executeUpdate();
            System.out.println("Aquisalvo");
            if(retorno == 0){
                throw new SQLException("persistencia do CLIENTEPF falhou , ID do CLIENTEPF não foi gerado.");
            }
            try (ResultSet generatedkeys = ps.getGeneratedKeys()){
                if(generatedkeys.next()){
                    return generatedkeys.getLong(1);
                }else{
                    throw new SQLException("persistencia do CLIENTEPF falhou , ID do CLIENTEPF não foi gerado.");
                }
            }
        } catch (SQLException e2){
            System.out.printf("Erro:%s", e2.getMessage());
            throw new SQLException("persistencia do CLIENTEPF falhou");
        }
    }

    public void alterar(ClientePf clientePf) throws SQLException{
        try{

            String sqlClientePf = "UPDATE clientePf SET nome=? ,tipoCliente=?"
                    + ", email=?, telefone=?, rendaMensal=?;";

            PreparedStatement ps = conn.prepareStatement(sqlClientePf);
            ps.setString(1, clientePf.getNome());
            ps.setBoolean(2, clientePf.isTipoCliente());
            ps.setString(3, clientePf.getEmail());
            ps.setString(4, clientePf.getTelefone());
            ps.setFloat(5, clientePf.getRendaMensal());
            System.out.println(">>>ALTERAR: " + clientePf.getNome());
            int retorno = ps.executeUpdate();

            if(retorno == 0){
                throw new SQLException("Alteração do CLIENTEPF falhou");
            }

        } catch (SQLException e2){
            System.out.printf("Erro:%s", e2.getMessage());
            throw new SQLException("Alteração do CLIENTEPF falhou");
        }
    }

    public ArrayList<ClientePf> listarTodos() throws SQLException{
        String sql="SELECT idClientePf, tipoCliente, nome, email, dataDeNascimento, telefone, rg, cpf;";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<ClientePf> clientesPf = new ArrayList<ClientePf>();
        while (rs.next()){
            try{
                ClientePf clientePf = new ClientePf();
                clientePf.setId(rs.getInt("idClientePf"));
                clientePf.setNome(rs.getString("nome"));

                clientePf.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                clientesPf.add(clientePf);
                    } catch (SQLException e1){
                System.out.println(e1);
                }

            }
        return clientesPf;
        }

        public void excluir(ClientePf clientePf){

    }

    public ClientePf listarPorCodigo(int codigo) throws SQLException{
        String sql="SELECT idClientePf, tipoCliente, nome, email, dataDeNascimento, telefone, rg, cpf"
                + "FROM clientePf where idClientePf=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        rs.next();

        ClientePf clientePf = new ClientePf();
        clientePf.setId(rs.getInt("idClientePf"));
        clientePf.setTipoCliente(rs.getBoolean("tipoCliente"));
        clientePf.setNome(rs.getString("nome"));
        clientePf.setEmail(rs.getString("email"));
        clientePf.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        clientePf.setTelefone(rs.getString("telefone"));
        clientePf.setRg(rs.getString("rg"));
        clientePf.setCpf(rs.getString("cpf"));

        return clientePf;
    }


    @Override
    public ClientePf listarPorNome(String nome) throws SQLException {
        String sql="SELECT idClientePf, tipoCliente, nome, email, dataDeNascimento, telefone, rg, cpf"
                + "FROM clientePf where idClientePf=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        rs.next();

        ClientePf clientePf = new ClientePf();
        clientePf.setId(rs.getInt("idClientePf"));
        clientePf.setTipoCliente(rs.getBoolean("tipoCliente"));
        clientePf.setNome(rs.getString("nome"));
        clientePf.setEmail(rs.getString("email"));
        clientePf.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        clientePf.setTelefone(rs.getString("telefone"));
        clientePf.setRg(rs.getString("rg"));
        clientePf.setCpf(rs.getString("cpf"));

        return clientePf;

    }

    @Override
    public ClientePf listarPorCpf(String cpf) throws SQLException {
        String sql="SELECT idClientePf, tipoCliente, nome, email, dataDeNascimento, telefone, rg, cpf"
                + "FROM clientePf where idClientePf=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cpf);
        ResultSet rs = ps.executeQuery();
        rs.next();

        ClientePf clientePf = new ClientePf();
        clientePf.setId(rs.getInt("idClientePf"));
        clientePf.setTipoCliente(rs.getBoolean("tipoCliente"));
        clientePf.setNome(rs.getString("nome"));
        clientePf.setEmail(rs.getString("email"));
        clientePf.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        clientePf.setTelefone(rs.getString("telefone"));
        clientePf.setRg(rs.getString("rg"));
        clientePf.setCpf(rs.getString("cpf"));

        return clientePf;
    }
}

