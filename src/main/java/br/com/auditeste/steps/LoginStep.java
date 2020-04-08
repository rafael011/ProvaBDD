package br.com.auditeste.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.auditeste.pageobjects.DriverFactory;
import br.com.auditeste.pageobjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	private WebDriver driver;
	private DriverFactory df = new DriverFactory();
	private LoginPage login;
	
//	@Before
//	public void inicializar() throws Exception {
//		driver = df.inicializar();
//		login = PageFactory.initElements(driver, LoginPage.class);
//		excel = new MassaDeDados();
//	}
//
//	@After
//	public void finalizar() throws Exception {
//	    df.encerrar();
//	}
	
	
	@Given("^estou na tela de login$")
	public void estouNaTelaDeLogin() throws Throwable {
		driver = df.inicializar();
		login = PageFactory.initElements(driver, LoginPage.class);
	}

	@When("^preencher o campo Usuario$")
	public void preencherOCampoUsuario() throws Throwable {
		login.preencherLogin("veron.oliveira@auditeste.com.br");
	}

	@When("^preencher o campo Senha$")
	public void preencherOCampoSenha() throws Throwable {
		login.preencherSenha("auditeste");
	}

	@When("^clicar no botao Login$")
	public void clicarNoBotaoLogin() throws Throwable {
		login.clicarBotaoLogin();
	}

	@Then("^validar Login com sucesso$")
	public void validarLoginComSucesso() throws Throwable {
		login.validacaoLogin();
	    Assert.assertEquals("Ana Sousa", login.validacaoLogin());
	    df.encerrar();
	}

	@When("^preencher o campo Usuario com dados invalidos$")
	public void preencherOCampoUsuarioComDadosInvalidos() throws Throwable {
		login.preencherLogin("emailinvalido@auditeste.com.br");
	}

	@When("^preencher o campo Senha com dados invalidos$")
	public void preencherOCampoSenhaComDadosInvalidos() throws Throwable {
		login.preencherSenha("senhainvalida");
	}
	
	@Then("^validar mensagem de usuario ou senha invalidos$")
	public void validarMensagemDeUsuarioOuSenhaInvalidos() throws Throwable {
		Assert.assertEquals("E-mail não Localizado", login.validacaoLoginMensagemErro());
		df.encerrar();
	}
}
