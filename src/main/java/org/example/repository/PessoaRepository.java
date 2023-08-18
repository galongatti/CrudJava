package org.example.repository;

import org.example.conexao.Conexao;
import org.example.model.Pessoa;
import org.example.model.TipoPessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Pessoa> buscarPessoaByDoc(String documento){

        Conexao conn = new Conexao();
        List<Pessoa> resultado = new ArrayList<Pessoa>();

        try {
            conn.abrirConexao();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Pessoa");
            query.append(" WHERE documento = ?");

            PreparedStatement preStr = conn.conn.prepareStatement(query.toString());
            preStr.setString(1, documento);

            ResultSet res = conn.executarConsulta(preStr);


            while(res.next()){

                Pessoa pessoa = new Pessoa();
                pessoa.setId(res.getInt("id"));
                pessoa.setNome(res.getString("nome"));
                pessoa.setDocumento(res.getString("documento"));
                pessoa.setIdade(res.getInt("idade"));
                pessoa.setTipoPessoa(TipoPessoa.valueOf(res.getString(("tipo"))));

                resultado.add(pessoa);
            }


        }catch (Exception e){
            System.out.println(e);
        }finally {
            conn.closeConexao();
            return resultado;
        }

    }







}
