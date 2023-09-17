package repositorios;

import entidades.Funcionario;
import interfaces.iFuncionarioRepositorioJdbc;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioMysqlRepositorio implements iFuncionarioRepositorioJdbc {

    private Connection conn;
    public FuncionarioMysqlRepositorio(){
        try{
            //this.conn = ConnectionSingleton.getInstance().conexao;
        } catch (Exception e){
            System.out.println("Error:\n" + e);
        }
    }

    public long cadastrar(Funcionario funcionario) throws Exception{

        try{
            String sql_funcionario = "INSERT INTO sistema"
                    + "nome, email, dataDeNascimento, telefone, rg, cpf, cargo, salario"
                    + "VALUESA(?,?,?,?,?,?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql_funcionario, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEmail());
            ps.setDate(3, funcionario.getDataDeNascimento());
            ps.setString(4, funcionario.getTelefone());
            ps.setString(5, funcionario.getRg());
            ps.setString(6, funcionario.getCpf());
            ps.setString(7, funcionario.getCargo());
            ps.setFloat(8, funcionario.getSalario());

            //Execulta a instrução

            int retorno = ps.executeUpdate();
            System.out.println("Aquisalvo");
            if (retorno == 0){
                throw new SQLException("persistencia do FUNCIONARIO falhou , ID do FUNCIONARIO não foi gerado.");
            }
            try (ResultSet generatedkeys = ps.getGeneratedKeys()){
                if (generatedkeys.next()){
                    return generatedkeys.getLong(1);
                }else{
                    throw new SQLException("persistencia do FUNCIONARIO falhou , ID do FUNCIONARIO não foi gerado.");
                }
            }
        } catch (SQLException e2){
            System.out.printf("Erro:%s", e2.getMessage());
            throw new SQLException("persistencia do FUNCIONARIO falhou , ID do FUNCIONARIO não foi gerado.");
        }
    }
    public void alterar(Funcionario funcionario) throws SQLException{
        try{

            String sqlFuncionario = "UPDATE funcionario SET nome=?, email=?, telefone=?, cargo=?, salario=?;";

            PreparedStatement ps = conn.prepareStatement(sqlFuncionario);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEmail());
            ps.setString(3,funcionario.getTelefone());
            ps.setString(4, funcionario.getCargo());
            ps.setFloat(5, funcionario.getSalario());
            System.out.println(">>>ALTERAR: " + funcionario.getNome());
            int retorno = ps.executeUpdate();

            if (retorno == 0){
                throw new SQLException("Alteração do FUNCIONARIO falhou");
            }
        } catch (SQLException e2){
            System.out.printf("Erro:%s", e2.getMessage());
            throw new SQLException("Alteração do FUNCIONARIO falhou");
        }
    }

    public ArrayList<Funcionario> listarTodos() throws SQLException{
        String sql="SELECT idFuncionario, nome, email, telefone, dataDeNascimento, rg, cpf, cargo, salario;";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        while (rs.next()){
            try{
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getFloat("salario"));
                funcionarios.add(funcionario);
            } catch (SQLException e1){
                System.out.println(e1);
            }
        }
        return funcionarios;
    }

    public void excluir(Funcionario funcionario){

    }

    public Funcionario listarPorCodigo(int codigo) throws SQLException{
        String sql="SELECT idFuncionario, nome, email, dataDeNascimento, telefone, rg, cpf, cargo, salario"
                + "FROM funcionario where idFuncionario=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        rs.next();

        Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getInt("idFuncionario"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setEmail(rs.getString("email"));
        funcionario.setTelefone(rs.getString("telefone"));
        funcionario.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        funcionario.setRg(rs.getString("rg"));
        funcionario.setCpf(rs.getString("cpf"));
        funcionario.setCargo(rs.getString("cargo"));
        funcionario.setSalario(rs.getFloat("salario"));

        return funcionario;
    }


    @Override
    public Funcionario listarPorNome(String nome) throws SQLException {
        String sql="SELECT nome, email, dataDeNascimento, telefone, rg, cpf, cargo, salario"
                + "FROM funcionario where nome=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        rs.next();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(rs.getString("nome"));
        funcionario.setEmail(rs.getString("email"));
        funcionario.setTelefone(rs.getString("telefone"));
        funcionario.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        funcionario.setRg(rs.getString("rg"));
        funcionario.setCpf(rs.getString("cpf"));
        funcionario.setCargo(rs.getString("cargo"));
        funcionario.setSalario(rs.getFloat("salario"));

        return funcionario;
    }

    @Override
    public Funcionario listarPorCpf(String cpf) throws SQLException {
        String sql="SELECT nome, email, dataDeNascimento, telefone, rg, cpf, cargo, salario"
                + "FROM funcionario where cpf=?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cpf);
        ResultSet rs = ps.executeQuery();
        rs.next();

        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(rs.getString("cpf"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setEmail(rs.getString("email"));
        funcionario.setTelefone(rs.getString("telefone"));
        funcionario.setDataDeNascimento(rs.getDate("dataDeNascimento"));
        funcionario.setRg(rs.getString("rg"));
        funcionario.setCargo(rs.getString("cargo"));
        funcionario.setSalario(rs.getFloat("salario"));

        return funcionario;
    }
}
