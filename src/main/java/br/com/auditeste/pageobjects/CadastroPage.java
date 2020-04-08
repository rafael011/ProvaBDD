package br.com.auditeste.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroPage {
	
private WebDriver driver;
	
	public CadastroPage() {
		this.driver = driver;
	}
	
	public void clicarBotaoCadastro() {
		driver.findElement(By.xpath("//a[contains(text(),'Faça seu cadastro')]")).click();
	}
	
	public void preencherCampoNome(String nome) {
		driver.findElement(By.id("MainContent_txt_usp_nome")).sendKeys(nome);
	}
	public void preencherCampoSobreome(String senha) {
		driver.findElement(By.id("MainContent_txt_usp_sobrenome")).sendKeys(senha);
	}
	
	public void preencherCampoCpf(String cpf) {
		driver.findElement(By.id("MainContent_txt_usp_cpf")).sendKeys(cpf);
	}
	
	public void preencherCampoEmail(String email) {
		driver.findElement(By.id("MainContent_txt_usp_email")).sendKeys(email);
	}
	
	public void clicarBotaoEnvair() {
		driver.findElement(By.id("MainContent_BtnGravar")).click();
	}
	
	public String validacao() {
		WebElement validacao = driver.findElement(By.xpath("MainContent_lbl_Msg"));
		return validacao.getText();
	}
	
	
	
	
	
	
	public void Esperar(String tempo) {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1],"+tempo+");");
	}
}
