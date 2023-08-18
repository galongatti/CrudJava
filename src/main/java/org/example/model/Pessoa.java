package org.example;

public class Pessoa {

    public String nome;
    public int idade;
    public TipoPessoa tipoPessoa;
    public Pessoa(){}

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }

    public void setNome(TipoPessoa tipo){
        this.tipoPessoa = tipo;
    }
    public TipoPessoa getTipoPessoa(){
        return this.tipoPessoa;
    }






}
