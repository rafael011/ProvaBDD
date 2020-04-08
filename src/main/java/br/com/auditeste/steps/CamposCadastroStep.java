package br.com.auditeste.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.auditeste.pageobjects.CadastroPage;
import br.com.auditeste.pageobjects.DriverFactory;
import cucumber.api.java.en.*;

public class CamposCadastroStep {
	private WebDriver driver;
	private DriverFactory df = new DriverFactory();
	private CadastroPage cadastro;
	
	@Given("^estou na pagina de login$")
	public void estouNaPaginaDeLogin() throws Throwable {
		driver = df.inicializar();
		cadastro = PageFactory.initElements(driver, CadastroPage.class);
	}

	@When("^clicar no botao cadastro$")
	public void clicarNoBotaoCadastro() throws Throwable {
	    cadastro.clicarBotaoCadastro();
	}

	@When("^preencher o campo nome$")
	public void preencherOCampoNome() throws Throwable {
	    cadastro.preencherCampoNome("Rafael");
	}

	@When("^preencher o campo sobrenome$")
	public void preencherOCampoSobrenome() throws Throwable {
	    cadastro.preencherCampoSobreome("Carmignotto");
	}

	@When("^preencher o campo cpf com dados invalidos$")
	public void preencherOCampoCpfComDadosInvalidos() throws Throwable {
	    cadastro.preencherCampoCpf("354354");
	}

	@When("^preencher o campo email$")
	public void preencherOCampoEmail() throws Throwable {
	    cadastro.preencherCampoEmail("rafael1.gomes@hotmail.com");
	}

	@When("^clicar no botao enviar$")
	public void clicarNoBotaoEnviar() throws Throwable {
	    cadastro.clicarBotaoEnvair();
	}

	@Then("^validar mensagem de erro cpf$")
	public void validarMensagemDeErroCpf() throws Throwable {
		Assert.assertEquals("C.P.F. Inválido.", cadastro.validacao());
		df.encerrar();
	}

	@When("^preencher o campo cpf$")
	public void preencherOCampoCpf() throws Throwable {
	    cadastro.preencherCampoCpf("43633908838");
	}

	@When("^preencher o campo email com dados invalidos$")
	public void preencherOCampoEmailComDadosInvalidos() throws Throwable {
		cadastro.preencherCampoEmail("rafael@test");
	}

	@Then("^validar mensagem de erro email$")
	public void validarMensagemDeErroEmail() throws Throwable {
		Assert.assertEquals("Formato de E-mail Inválido.", cadastro.validacao());
		df.encerrar();
	}

}
