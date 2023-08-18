package org.example.repository;

import org.example.conexao.Conexao;
import org.example.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaRepository {

    public boolean cadastrarPessoa(Pessoa pessoa) {

        Conexao conn = new Conexao();

        try{
            conn.abrirConexao();

            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO Pessoa");
            query.append("(nome,tipo,documento,idade)");
            query.append("VALUES(?,?,?,?)");

            PreparedStatement preStr = conn.conn.prepareStatement(query.toString());
            preStr.setString(1, pessoa.getNome());
            preStr.setString(2, pessoa.getTipoPessoa().toString());
            preStr.setString(3, pessoa.getDocumento());
            preStr.setInt(4, pessoa.getIdade());

            int resultado = conn.executarCreateUpdate(preStr);
            return resultado > 0;
        } catch (Exception e){
            return false;
        } finally {
            conn.closeConexao();
        }


    }







}
