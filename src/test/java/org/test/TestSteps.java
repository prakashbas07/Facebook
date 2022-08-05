package org.test;

import java.awt.AWTException;
import java.io.IOException;
import org.baseclass.BaseClass;
import org.locate.Locators;
import org.poM.PageObjectManager;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

//@Listeners(Transform.class)
public class TestSteps extends BaseClass {
	
	
	@BeforeClass
	private void beforeClass() throws InterruptedException {
		System.out.println("Login Functionality......");
		browserLaunch("chrome");
		implicitlywait(20);
		Thread.sleep(3000);
	}
	@AfterClass
	private void afterClass() throws InterruptedException {
		System.out.println("Login Functionality Done......");
		quit();
		Thread.sleep(1000);
	}
	@BeforeMethod
	private void beforeMethod() throws AWTException, InterruptedException {
		System.out.println("Before Method");
		url("http://www.facebook.com");
		System.out.println(title());
		Thread.sleep(2000);
	}
	@AfterMethod
	private void afterMethod(ITestResult it) throws IOException, AWTException {
		System.out.println("AfterMethod");
		Locators l = PageObjectManager.getPage().getLogin();
		javascriptstyle(l.getErrorMsg(), "border: solid 3px red");
		screenshot(it.getName());
	}

	@Test(priority=0, groups="smoke")
	public void Test1() {
		Locators l = PageObjectManager.getPage().getLogin();
		System.out.println("Test1 Execution");
		sendkeys(l.getTxtUsername(), "prakash");
		sendkeys(l.getTxtPassword(), "12345");
		click(l.getBtnLogin());
	}
	
	@Test(priority=0, retryAnalyzer=RetryAnalyzerTest.class)
	public void Test2() {
		Locators l = PageObjectManager.getPage().getLogin();
		System.out.println("Test2 Execution");
		sendkeys(l.getTxtUsername(), "bas");
		sendkeys(l.getTxtPassword(), "12345");
		click(l.getBtnLogin());
		Assert.assertTrue(false);
	}
	
	@Test(priority=0,groups="Sanity")
	public void Test3() {
		Locators l = PageObjectManager.getPage().getLogin();
		System.out.println("Test3 Execution");
		sendkeys(l.getTxtUsername(), "aksh");
		sendkeys(l.getTxtPassword(), "12345");
		click(l.getBtnLogin());
	}

}
