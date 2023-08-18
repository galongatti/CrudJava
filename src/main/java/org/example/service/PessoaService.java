package org.example.service;

import org.example.exceptions.PessoaException;
import org.example.model.Pessoa;
import org.example.repository.PessoaRepository;

import java.util.List;

public class PessoaService {

    public boolean verificarNomePreenchido(Pessoa pessoa) throws PessoaException {

        if(pessoa.getNome().isEmpty()) throw new PessoaException("Nome não pode ser vazio");

        return true;
    }

    public boolean verificarMaioridade(Pessoa pessoa) throws PessoaException {
        if(pessoa.getIdade() < 18) throw new PessoaException("Pessoa deve ser ter mais de 18 anos");
        return pessoa.getIdade() >= 18;
    }

    public boolean verificarDocumento(Pessoa pessoa) throws PessoaException {
        String documento = pessoa.getDocumento();

        boolean docValido = pessoa.getTipoPessoa().validarDocumento(documento);
        if(!docValido) throw new PessoaException("Documento inválido");

        return true;
    }
    public boolean cadastrarPessoa(Pessoa pessoa) throws PessoaException {

        boolean cadastroValido = this.validarCadastro(pessoa);

        if(cadastroValido){
            PessoaRepository repository = new PessoaRepository();
            return repository.cadastrarPessoa(pessoa);
        }

        return true;
    }

    public List<Pessoa> buscarPessoaByDoc(String documento) throws PessoaException {
        PessoaRepository repository = new PessoaRepository();
        return repository.buscarPessoaByDoc(documento);
    }

    private boolean validarCadastro(Pessoa pessoa) throws PessoaException {

        boolean nomeOk = this.verificarNomePreenchido(pessoa);
        boolean maioridadeOk = this.verificarMaioridade(pessoa);
        boolean documentoOk = this.verificarDocumento(pessoa);

        return !nomeOk && maioridadeOk && documentoOk;
    }

}
