package pages;

import org.openqa.selenium.WebElement;

import bases.LoginBase;

public class LoginPage extends LoginBase {
	
	public LoginPage() {
		super();
	}

	public void setSenhaIncorreta() {
		this.getDsl().escrever("senha", "123");
	}
	
	public String getMensagemLogin() {
		WebElement elemento = this.getDsl().encontrarElementoByClassName("alert");
		return elemento.getText();
	}
}
