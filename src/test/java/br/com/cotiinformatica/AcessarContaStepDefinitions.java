package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AcessarContaStepDefinitions {

	WebDriver driver;
	
	@Given("Acessar a página de autenticação de usuário")
	public void acessar_a_pagina_de_autenticacao_de_usuario() {
		
		//apontar o local onde está o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
		
		//abrir o navegador
		driver = new ChromeDriver();
		
		//maximizar o navegador
		driver.manage().window().maximize();
		
		//acessar a página do sistema que será testada
		driver.get("http://testesoftware-001-site1.atempurl.com/exercicios/tarefa01");
	}

	@Given("Informar meu email de acesso")
	public void informar_meu_email_de_acesso() {

		//acessando o campo para preenchimento do email
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		
		//limpar o conteudo do campo
		element.clear();
		
		//preencher o campo
		element.sendKeys("admin@gmail.com");
	}

	@Given("Informar minha senha de acesso")
	public void informar_minha_senha_de_acesso() {

		//acessando o campo para preenchimento da senha
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		
		//limpar o conteudo do campo
		element.clear();
		
		//preencher o campo
		element.sendKeys("@Admin123");
	}

	@When("Solicitar a realização do acesso")
	public void solicitar_a_realizacao_do_acesso() {

		//acessando o botão de confirmação do formulário
		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnAcesso\"]"));
		
		//clicando no botão
		element.click();
	}

	@Then("Sistema autentica o usuário com sucesso")
	public void sistema_autentica_o_usuario_com_sucesso() {

		//acessando o elemento HTML que contem a mensagem de sucesso
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));
		
		//criando uma asserção de teste
		//comparando o resultado esperado X resultado obtido
		assertEquals("Autenticação realizada com sucesso.", element.getText());
		
		//gerar a evidência do teste
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Acessar conta com sucesso.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close(); //fechar o navegador
		}
	}
	
	@Given("Informar um email inválido")
	public void informar_um_email_invalido() {
		
		//localizando o campo onde será preenchido o valor do email
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		
		//limpar o conteúdo do campo
		element.clear();
		
		//preenchendo o campo
		element.sendKeys("teste@gmail.com");
	}
	
	@Given("Informar uma senha inválida")
	public void informar_uma_senha_invalida() {
		
		//localizando o campo onde será preenchido o valor da senha
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		
		//limpar o conteúdo do campo
		element.clear();
		
		//preenchendo o campo
		element.sendKeys("@Teste123");
	}
	
	@Then("Sistema informa que o acesso é negado")
	public void sistema_informa_que_o_acesso_e_negado() {
		
		//localizando o elemento onde está sendo exibida a mensagem
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));
		
		//comparando a mensagem
		assertEquals("Acesso negado.", element.getText());
		
		//gerar a evidência do teste
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Acesso negado.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close(); //fechar o navegador
		}
	}	
}




