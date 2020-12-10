package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.LoginPage;

public class LoginTest {
	
	LoginPage page;
	
	@Before
	public void setUp() {
		this.page = new LoginPage();
	}

	@Test
	public void deveRetornarSenhaIncorreta() {
		this.page.setEmailCorreto();
		this.page.setSenhaIncorreta();
		this.page.entrar();
		
		assertEquals("Problemas com o login do usuário", this.page.getMensagemLogin());
	}
	
	@Test
	public void deveRetornarSenhaCorreta() {
		this.page.setEmailCorreto();
		this.page.setSenhaCorreta();
		this.page.entrar();
		
		assertEquals("Bem vindo, Giancarlo!", this.page.getMensagemLogin());
	}
	
	@Test
	public void deveRetornarEmailObrigatorio() {
		this.page.setSenhaCorreta();
		this.page.entrar();
		
		assertEquals("Email é um campo obrigatório", this.page.getMensagemLogin());
	}	
	
	@Test
	public void deveRetornarSenhaObrigatorio() {
		this.page.setEmailCorreto();
		this.page.entrar();
		
		assertEquals("Senha é um campo obrigatório", this.page.getMensagemLogin());
	}		
	
	@After
	public void quit() {
		this.page.getDsl().fechar();
	}
}
