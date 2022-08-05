package org.locate;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass {

	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create New Account")
	private WebElement createBtn;
	
	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement email;
	
	public WebElement getEmail() {
		return email;
	}

	@FindBy(name="websubmit")
	private WebElement websubmit;
	
	@FindBy(xpath="//i[contains(@class, '_5dbc img sp_98')]")
	private WebElement errorMsg;

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getWebsubmit() {
		return websubmit;
	}
	
}
