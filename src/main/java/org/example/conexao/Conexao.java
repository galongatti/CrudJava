package org.example.conexao;

import java.sql.*;

public class Conexao {

    private String databaseUrl = "jdbc:postgresql://localhost/CrudJava";
    private String usuario = "postgres";
    private String senha = "123456789";
    private String driverName = "org.postgresql.Driver";
    public Connection conn;

    public Conexao(){}

    public void abrirConexao(){

        try {
            Class.forName(driverName).newInstance();
            this.conn = DriverManager.getConnection(databaseUrl, usuario, senha);
            this.conn.setAutoCommit(true);
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception e) {
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
        }
    }

    public void closeConexao(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception e) {
            System.out.println("Problemas ao tentar fechar conexão com o banco de dados: " + e);
        }
    }

    public int executarCreateUpdate(PreparedStatement query) throws SQLException {
        return query.executeUpdate();
    }

    public ResultSet executarConsulta(PreparedStatement query) throws SQLException{
        return query.executeQuery();
    }
}
