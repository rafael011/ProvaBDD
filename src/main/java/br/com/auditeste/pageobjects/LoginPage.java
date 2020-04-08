package br.com.auditeste.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}	
	
	public void preencherLogin(String login) {
		driver.findElement(By.name("ctl00$MainContent$txt_usu_email")).sendKeys(login);
	}

	public void preencherSenha(String senha) {
		driver.findElement(By.name("ctl00$MainContent$txt_sen_descricao")).sendKeys(senha);
	}

	public void clicarBotaoLogin() {
		driver.findElement(By.id("MainContent_BtnEntrar")).click();
		Esperar("5000");
	}
	
	public String validacaoLogin() {
		WebElement validacao = driver.findElement(By.xpath("//b[contains(text(),'Ana Sousa')]"));
		return validacao.getText();
	}
	
	public String validacaoLoginMensagemErro() throws InterruptedException {
		WebElement validacao = driver.findElement(By.id("MainContent_lbl_Msg"));
		Esperar("500");
		return validacao.getText();
	}
	
	public void Esperar(String tempo) {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1],"+tempo+");");
	}
}
