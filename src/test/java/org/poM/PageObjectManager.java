package org.poM;
import org.locate.Locators;
import org.locate.RegistrationPage;

public class PageObjectManager {

	private PageObjectManager() {
		
	}
	private static PageObjectManager page;
	private static Locators login;
	private static RegistrationPage register;
	
	public static PageObjectManager getPage() {
		return page==null?page=new PageObjectManager():page;
	}
	public Locators getLogin() {
		return login==null?login=new Locators():login;
	}
	public RegistrationPage getRegister() {
		return register==null? register=new RegistrationPage():register;
	}
	
	
	
}
