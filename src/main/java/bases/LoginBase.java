package bases;

import core.DSL;

public class LoginBase {
	
	DSL dsl;
	
	public LoginBase() {
		this.dsl = new DSL();
	}

	public DSL getDsl() {
		return dsl;
	}
		
	public void login() {
		setEmailCorreto();
		setSenhaCorreta();
		entrar();
	}	
	
	public void setEmailCorreto() {
		this.getDsl().escrever("email", "gagiulian@github.com");
	}
	
	public void setSenhaCorreta() {
		this.getDsl().escrever("senha", "123456");
	}	
	
	public void entrar() {
		this.getDsl().clicarByClassName("btn-primary");
	}		
}
