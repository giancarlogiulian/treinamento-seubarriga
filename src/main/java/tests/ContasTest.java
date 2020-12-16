package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ContasPage;

public class ContasTest {
	
	ContasPage page;
	
	@Before
	public void setUp() {
		this.page = new ContasPage();
		this.page.login();
	}
	
	@Test
	public void deveAdicionarContaSicredi() {
		this.page.clicarNoMenuContas();
		this.page.clicarNoBotaoAdicionar();
		this.page.setContaSicredi();
		this.page.salvarConta();
		
		assertEquals("Conta adicionada com sucesso!", this.page.resultado());
	}
	
	@Test
	public void deveRetornarMensagemDeContaJaCadastrada() {		
		this.page.clicarNoMenuContas();
		this.page.clicarNoBotaoAdicionar();
		this.page.setContaSicredi();
		this.page.salvarConta();
		
		assertEquals("Já existe uma conta com esse nome!", this.page.resultado());
	}	
	
	@Test
	public void deveExcluirContaSicredi() {		
		this.page.clicarNoMenuContas();
		this.page.clicarNoMenuListar();
		this.page.deletarConta();
		
		assertEquals("Conta removida com sucesso!", this.page.resultado());
	}
	
	@Test
	public void deveNomeDaContaSerObrigatorio() {			
		this.page.clicarNoMenuContas();
		this.page.clicarNoBotaoAdicionar();
		this.page.salvarConta();
		
		assertEquals("Informe o nome da conta", this.page.resultado());
	}
	
	@Test
	public void deveAdicionarContaBancoDoBrasil() {	
		this.page.clicarNoMenuContas();
		this.page.clicarNoBotaoAdicionar();
		this.page.setContaBancoDoBrasil();
		this.page.salvarConta();
		
		assertEquals("Conta adicionada com sucesso!", this.page.resultado());
	}	
	
	
	@Test
	public void deveAlterarContaBancoDoBrasilParaCEF() {	
		this.page.clicarNoMenuContas();
		this.page.clicarNoMenuListar();
		this.page.alterarConta();
		this.page.setContaCEF();
		this.page.salvarConta();
		
		assertEquals("Conta alterada com sucesso!", this.page.resultado());
	}
	
	@After
	public void fechar() {
		this.page.fechar();
	}
}
