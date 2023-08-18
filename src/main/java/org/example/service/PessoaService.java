package org.example.service;

import org.example.model.Pessoa;
import org.example.repository.CadastroPessoaRepository;

public class CadastroPessoaService {

    public boolean verificarNomeVazio(Pessoa pessoa) {
        return pessoa.getNome().isEmpty();
    }

    public boolean verificarMaioridade(Pessoa pessoa){
        return pessoa.getIdade() >= 18;
    }
    public boolean verificarDocumento(Pessoa pessoa) {
        String documento = pessoa.getDocumento();
        return pessoa.getTipoPessoa().validarDocumento(documento);
    }
    public boolean cadastrarPessoa(Pessoa pessoa){

        boolean cadastroValido = this.validarCadastro(pessoa);

        if(cadastroValido){
            CadastroPessoaRepository repository = new CadastroPessoaRepository();
            return repository.cadastrarPessoa(pessoa);
        }

        return true;
    }

    private boolean validarCadastro(Pessoa pessoa) {

        boolean nomeOk = this.verificarNomeVazio(pessoa);
        boolean maioridadeOk = this.verificarMaioridade(pessoa);
        boolean documentoOk = this.verificarDocumento(pessoa);

        return !nomeOk && maioridadeOk && documentoOk;
    }
}
