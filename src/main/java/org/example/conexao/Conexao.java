package org.example.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    String databaseUrl = "jdbc:postgresql://localhost/CrudJava";
    String usuario = "postgres";
    String senha = "123456789";
    String driverName = "org.postgresql.Driver";
    private Connection conn;

    public Conexao(){}

    public void getConexao(){

        try {
            Class.forName(driverName).newInstance();
            this.conn = DriverManager.getConnection(databaseUrl, usuario, senha);
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





}
