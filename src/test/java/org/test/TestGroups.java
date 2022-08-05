package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseclass.BaseClass;
import org.locate.RegistrationPage;
import org.poM.PageObjectManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestGroups extends BaseClass {

	@BeforeMethod
	private void beforeMethod() throws InterruptedException {
		System.out.println("Before Method");
		 url("http://www.facebook.com");
		System.out.println(title());
		Thread.sleep(3000);
	}

	@AfterMethod
	private void afterMethod(ITestResult it) throws IOException {
		System.out.println("AfterMethod");
		RegistrationPage r = PageObjectManager.getPage().getRegister();
		javascriptstyle(r.getErrorMsg(), "border: solid 3px red");
		screenshot(it.getName());
	}

	@BeforeClass
	private void beforeClass() throws InterruptedException {
		System.out.println("Registration Functionality......");
		 browserLaunch("chrome");
		implicitlywait(20);
		Thread.sleep(2000);
	}

	@AfterClass
	private void afterClass() throws InterruptedException {
		System.out.println("Registration Functionality Done......");
		 quit();
		Thread.sleep(1000);
	}

	// @Test(priority = 0, enabled = false, groups = "smoke")
	// public void Test11() {
	// System.out.println("Test11 Execution");
	// RegistrationPage r = PageObjectManager.getPage().getRegister();
	// click(r.getCreateBtn());
	// sendkeys(r.getFirstname(), "parakash");
	// sendkeys(r.getLastname(), "akash");
	// click(r.getWebsubmit());
	// }

	// @Parameters({ "name", "pass" })
	// @Test(priority = 0, enabled = false, groups = "smoke")
	// public void Test21(@Optional("prakash") String name, @Optional("123456")
	// String pass) {
	// System.out.println("Test21 Execution");
	// RegistrationPage r = PageObjectManager.getPage().getRegister();
	// click(r.getCreateBtn());
	// sendkeys(r.getFirstname(), name);
	// sendkeys(r.getLastname(), pass);
	// click(r.getWebsubmit());
	// }

	@Test(dataProvider = "login")
	public void Test31(String name, String pass) {
		System.out.println("Test31 Execution");
		 RegistrationPage r = PageObjectManager.getPage().getRegister();
		 click(r.getCreateBtn());
		 sendkeys(r.getFirstname(), name);
		 sendkeys(r.getLastname(), pass);
		 click(r.getWebsubmit());
	}

	
//	private Object[][] input() throws IOException {
//		Object[][] objects = details();
//		return objects;
//
//	}
	@DataProvider(name = "login")
	private Object[][] details() throws IOException {
		

		File f = new File("C:\\Users\\praka\\eclipse-workspace\\TestNgRerun\\src\\main\\Deatils.xlsx");
		FileInputStream is = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(is);
		Sheet sheet = w.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		Row rows = sheet.getRow(0);
		int k = rows.getPhysicalNumberOfCells();
		Object[][] loginDetail = new Object[rowCount][k];
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < k; j++) {
				Cell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				loginDetail[i][j] = value;
				System.out.println(value);
			}

		}
		return loginDetail;

	}
}
