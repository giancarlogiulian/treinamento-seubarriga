package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MovimentacaoPage;

public class MovimentacaoTest {

	MovimentacaoPage page;
	
	@Before
	public void setUp() {
		this.page = new MovimentacaoPage();
		this.page.login();
	}
	
	@Test
	public void deveRetornarMovimentacaoAdicionadaComSucesso() {	
		this.page.clicarNoBotaoCriarMovimentacao();
		this.page.setDataMovimentacao08DeDezembroDe2020();
		this.page.setDataPagamento08DeDezembroDe2020();
		this.page.setDescricaoIgualAProlabore();
		this.page.setInteressadoIgualAGiancarlo();
		this.page.setValorIgualA100Mil();
		this.page.salvar();
		
		assertEquals("Movimentação adicionada com sucesso!", this.page.resultado());
	}	
	
	@After
	public void fechar() {
		this.page.fechar();
	}
}
