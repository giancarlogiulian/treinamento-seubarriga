package pages;

import bases.LoginBase;

public class ContasPage extends LoginBase {
	
	public ContasPage() {
		super();
	}

	public void clicarNoMenuContas() {
		this.getDsl().clicarByLinkText("Contas");
	}
	
	public void clicarNoMenuListar() {
		this.getDsl().clicarByLinkText("Listar");
	}	
	
	public void clicarNoBotaoAdicionar() {
		this.getDsl().clicarByLinkText("Adicionar");
	}
	
	public void setContaSicredi() {
		this.getDsl().escrever("nome", "Sicredi");
	}
	
	public void setContaBancoDoBrasil() {
		this.getDsl().escrever("nome", "Banco do Brasil");
	}	
	
	public void setContaCEF() {
		this.getDsl().escrever("nome", "CEF");
	}		
	
	public void salvarConta() {
		this.getDsl().clicarByClassName("btn-primary");
	}
	
	public void deletarConta() {
		this.getDsl().clicarByClassName("glyphicon-remove-circle");
	}	
	
	public void alterarConta() {
		this.getDsl().clicarByClassName("glyphicon-edit");
	}		
	
	public String resultado() {
		return this.getDsl().encontrarElementoByClassName("alert").getText();
	}
	
	public void fechar() {
		this.getDsl().fechar();
	}
}
