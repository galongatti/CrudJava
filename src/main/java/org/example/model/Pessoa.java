package org.example.model;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private TipoPessoa tipoPessoa;

    private String documento;
    public Pessoa(){}

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }

    public void setTipoPessoa(TipoPessoa tipo){
        this.tipoPessoa = tipo;
    }
    public TipoPessoa getTipoPessoa(){
        return this.tipoPessoa;
    }


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new String("Nome: %s , Idade %d , Documento: %s, Tipo: %s".formatted(this.nome, this.idade,this.documento,
                                                                                    this.tipoPessoa));
    }
}
