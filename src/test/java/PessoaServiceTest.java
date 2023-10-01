import org.example.exceptions.PessoaException;
import org.example.model.Pessoa;
import org.example.model.TipoPessoa;
import org.example.service.PessoaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    @Test
    public void verificarNomePessoa(){

        PessoaService service = new PessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("");
        pessoa.setIdade(18);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("999999999");

        try {
            service.verificarNomePreenchido(pessoa);
            fail();
        }catch (PessoaException ex){
            assertEquals("Nome não pode ser vazio", ex.getMessage());
        }
    }

    @Test
    public void verificarMaioridade(){
        PessoaService service = new PessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Gabriel");
        pessoa.setIdade(17);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("46142094833");

        try {
            service.verificarMaioridade(pessoa);
            fail();
        }catch (PessoaException ex){
            assertEquals("Pessoa deve ser ter mais de 18 anos", ex.getMessage());
        }
    }
    @Test
    public void verificarDocumentoPessoaFisica() {

        PessoaService service = new PessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Gabriel");
        pessoa.setIdade(18);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("46242094833");

        try {
            service.verificarDocumento(pessoa);
            fail();
        }catch (PessoaException ex){
            assertEquals("Documento inválido", ex.getMessage());
        }
    }


    @Test
    public void cadastrarPessoaFisica(){

        PessoaService service = new PessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Gabriel");
        pessoa.setIdade(17);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("46142494833");

        assertThrows(PessoaException.class, () -> service.cadastrarPessoa(pessoa));
    }
}
