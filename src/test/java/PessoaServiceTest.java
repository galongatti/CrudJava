import org.example.model.Pessoa;
import org.example.model.TipoPessoa;
import org.example.service.CadastroPessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CadastroPessoaServiceTest {

    @Test
    public void verificarNomePessoa(){
        CadastroPessoaService service = new CadastroPessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Gabriel");
        pessoa.setIdade(18);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("46142094833");

        boolean nomeValido = service.verificarNomeVazio(pessoa);
        Assertions.assertEquals(false, nomeValido);
    }

    @Test
    public void verificarMaioridade(){
        CadastroPessoaService service = new CadastroPessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Gabriel");
        pessoa.setIdade(18);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("46142094833");

        boolean maioridadeOk = service.verificarMaioridade(pessoa);
        Assertions.assertEquals(true, maioridadeOk);
    }
    @Test
    public void verificarDocumentoPessoaFisica(){
        CadastroPessoaService service = new CadastroPessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Gabriel");
        pessoa.setIdade(18);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("46142094833");

        boolean verificarDocumento = service.verificarDocumento(pessoa);
        Assertions.assertEquals(true, verificarDocumento);
    }


    @Test
    public void cadastrarPessoaFisica(){

        CadastroPessoaService service = new CadastroPessoaService();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Gabriel");
        pessoa.setIdade(18);
        pessoa.setTipoPessoa(TipoPessoa.FISICA);
        pessoa.setDocumento("46142094833");


        boolean nomeValido = service.verificarNomeVazio(pessoa);
        Assertions.assertEquals(false, nomeValido);

        boolean maioridadeOk = service.verificarMaioridade(pessoa);
        Assertions.assertEquals(true, maioridadeOk);

        boolean verificarDocumento = service.verificarDocumento(pessoa);
        Assertions.assertEquals(true, verificarDocumento);

    }









}
