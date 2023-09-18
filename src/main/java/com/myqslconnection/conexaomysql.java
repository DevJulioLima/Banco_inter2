package com.myqslconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexaomysql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String user = "root";
        String password = "bancointer";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Sucesso ao conectar com o banco de dados: " + url);

            String query =  "use banco_inter insert into tbpessoa (CPF,NOME,RG,DATA_DE_NASCIMENTO,TELEFONE, EMAIL,CLIENTE)" +
                    " VALUES('13777799906','ADRYAN TESTE', '10666999', 2002-02-14, '81984479047', 'ADRYANRIAN@GMAIL.COM',1)";

            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
