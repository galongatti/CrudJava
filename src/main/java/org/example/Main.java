package org.example;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import org.example.exceptions.PessoaException;
import org.example.model.Pessoa;
import org.example.model.TipoPessoa;
import org.example.service.PessoaService;

public class Main {
    public static void main(String[] args) {

        try {
            consultarByDocumento();
        } catch (PessoaException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultarByDocumento() throws PessoaException {
        PessoaService service = new PessoaService();
        List<Pessoa> res = service.buscarPessoaByDoc("46142094833");
        System.out.println(res);
    }

    public static void cadastrarPessoa(){
        Pessoa pessoa = new Pessoa();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o nome: \0");
        String nome = teclado.nextLine();

        System.out.println("Insira a idade: \0");
        int idade = teclado.nextInt();

        System.out.println("Insira o documento(apenas numero): \0");
        BigInteger documento = teclado.nextBigInteger();
        String documentoStr = documento.toString();

        System.out.println("Insira o tipo de pessoa - Fisica(0), Juridica(1): \0");
        int tipo = teclado.nextInt();

        TipoPessoa tipoPessoa = tipo == 0 ? TipoPessoa.FISICA : TipoPessoa.JURIDICA;

        pessoa.setNome(nome);
        pessoa.setIdade(idade);
        pessoa.setTipoPessoa(tipoPessoa);
        pessoa.setDocumento(documentoStr);
        PessoaService service = new PessoaService();

        try {
            boolean sucesso =  service.cadastrarPessoa(pessoa);
            if(sucesso) System.out.println("Sucesso ao cadastrar");
        } catch (PessoaException e) {
            System.out.println(e.getMessage());
        }
    }
}