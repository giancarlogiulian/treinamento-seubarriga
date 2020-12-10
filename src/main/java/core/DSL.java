package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	DriverFactory driverFactory;
	
	public DSL() {
		this.driverFactory = new DriverFactory();
	}
	
	private DriverFactory getDriverFactory() {
		return driverFactory;
	}

	public void escrever(String id, String texto) {
		getDriverFactory().getDriver().findElement(By.id(id)).sendKeys(texto);
	}
	
	public void clicarById(String id) {
		getDriverFactory().getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarByClassName(String classe) {
		getDriverFactory().getDriver().findElement(By.className(classe)).click();
	}
	
	public void clicarByLinkText(String linkText) {
		getDriverFactory().getDriver().findElement(By.linkText(linkText)).click();
	}	
	
	public WebElement encontrarElementoById(String id) {
		return getDriverFactory().getDriver().findElement(By.id(id));
	}
	
	public WebElement encontrarElementoByClassName(String className) {
		return getDriverFactory().getDriver().findElement(By.className(className));
	}	
	
	public void selecionar(WebElement combo, String texto) {
		Select select = new Select(combo);
		select.selectByVisibleText(texto);		
	}
	
	public String getValorDoElemento(String id) {
		return getDriverFactory().getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	public Boolean isElementoSelecionado(String id) {
		return getDriverFactory().getDriver().findElement(By.id(id)).isSelected();
	}
	
	public String pegarTextoSelecionadoDoCombo(WebElement combo) {
		Select selectEscolaridade = new Select(combo);
		return selectEscolaridade.getFirstSelectedOption().getText();		
	}
	
	public void fechar() {
		this.driverFactory.quit();
	}
}
