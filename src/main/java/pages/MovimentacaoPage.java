package pages;

public class MovimentacaoPage extends LoginPage {

	public void clicarNoBotaoCriarMovimentacao() {
		this.getDsl().clicarByLinkText("Criar Movimentação");
	}
	
	public void setDataMovimentacao08DeDezembroDe2020() {
		this.getDsl().escrever("data_transacao", "08/12/2020");
	}
		
	public void setDataPagamento08DeDezembroDe2020() {
		this.getDsl().escrever("data_pagamento", "08/12/2020");
	}	
	
	public void setDescricaoIgualAProlabore() {
		this.getDsl().escrever("descricao", "Pro Labore");
	}		
	
	public void setInteressadoIgualAGiancarlo() {
		this.getDsl().escrever("interessado", "Giancarlo");
	}		
	
	public void setValorIgualA100Mil() {
		this.getDsl().escrever("valor", "100000");
	}	
	
	public void salvar() {
		this.getDsl().clicarByClassName("btn-primary");
	}
	
	public String resultado() {
		return this.getDsl().encontrarElementoByClassName("alert").getText();
	}	

	public void fechar() {
		this.getDsl().fechar();
	}	
}
