package org.locate;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Locators extends BaseClass {

	public Locators() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement txtUsername;
	
	@FindBy(id="pass")
	private WebElement txtPassword;;
	
	@FindBy(name="login")
	private WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='_9ay7']")
	private WebElement errorMsg;
	

	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
}
