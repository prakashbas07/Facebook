package org.baseclass;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

		public static WebDriver driver;
		
		public static  WebDriver browserLaunch(String a) {
			if (a.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (a.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (a.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			return driver;
		}
		public static void implicitlywait(int a) {
			driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		}
		public static void maximize() {
			driver.manage().window().maximize();
		}
		public static void url(String a) {
			driver.get(a);
		}
		public static void sendkeys(WebElement a, String i) {
			a.sendKeys(i);
		}
		public static void click(WebElement a) {
			a.click();
		}
		public static void close() {
			driver.close();
		}
		public static void clear(WebElement we) {
			we.clear();
		}
		public static void sleep(int a) throws InterruptedException {
			Thread.sleep(a);
		}
		public static String currenturl() {
			String currenturl = driver.getCurrentUrl();
			return currenturl;
		}
		public static String title() {
			String title = driver.getTitle();
			return title;
		}
		public static void quit() {
			driver.quit();
		}
		public static void movetoelement(WebElement i) {
			Actions a = new Actions(driver);
			a.moveToElement(i).perform();
		}
		public static void draganddrop(WebElement src, WebElement trg) {
			Actions a = new Actions(driver);
			a.dragAndDrop(src, trg).perform();
		}
		public static void contextclick(WebElement i) {
			Actions a = new Actions(driver);
			a.contextClick(i).perform();
		}
		public static void doubleclick(WebElement i) {
			Actions a = new Actions(driver);
			a.doubleClick(i).perform();
		}
		public static void actionsendkeys(WebElement webElement, String values) {
			Actions a=new Actions(driver);
			a.sendKeys(webElement, values).perform();

		}
		public static void robotkey(String a) throws AWTException {
			Robot r = new Robot();
			if (a.equalsIgnoreCase("escape")) {
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
			} else if (a.equalsIgnoreCase("enter")) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			} else if (a.equalsIgnoreCase("downarrow")) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			} else if (a.equalsIgnoreCase("uparrow")) {
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			}
			else if (a.equalsIgnoreCase("ctrl")) {
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_CONTROL);
			}
			else if (a.equalsIgnoreCase("t")) {
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_T);
			}
		}
		public static String getattribute(WebElement a) {
			String attribute = a.getAttribute("value");
			return attribute;
		}
		public static String gettext(WebElement a) {
			String text = a.getText();
			return text;
		}
		public static void selectbyindex(WebElement we, int index) {
			Select s = new Select(we);
			s.selectByIndex(index);
		}
		public static void selectbyvalue(WebElement we, String a) {
			Select s = new Select(we);
			s.selectByValue(a);
		}
		public static void selectbyvisibletext(WebElement we, String a) {
			Select s = new Select(we);
			s.selectByVisibleText(a);
		}
		public static List<WebElement> getoptions(WebElement we ) {
			Select s= new Select(we);
			List<WebElement> options = s.getOptions();
			return options;
		}
		public static List<WebElement> getAllSelectedOptions(WebElement we) {
			Select s= new Select(we);
			List<WebElement> options = s.getAllSelectedOptions();
			return options;
		}
		public static WebElement getFirstSelectedOptions(WebElement we) {
			Select s= new Select(we);
			WebElement option = s.getFirstSelectedOption();
			return option;
		}
		public static boolean isMultiple(WebElement we) {
			Select s= new Select(we);
			boolean multiple = s.isMultiple();
			return multiple;
		}
		public static void deselectByIndex(WebElement we, int index) {
			Select s= new Select(we);
			s.deselectByIndex(index);
		}
		public static void deselectByValue(WebElement we, String arg) {
			Select s= new Select(we);
			s.deselectByValue(arg);
		}
		public static void deselectByVisibletext(WebElement we, String arg ) {
			Select s= new Select(we);
			s.deselectByVisibleText(arg);
		}
		public static void deselectByAll(WebElement we) {
			Select s= new Select(we);
			s.deselectAll();
		}
		public static void screenshot(WebElement a, String name) throws IOException {
			TakesScreenshot tk = (TakesScreenshot) a;
			File image = tk.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\praka\\eclipse-workspace\\Selenium\\Screenshot\\" + name + ".png");
			FileUtils.copyFile(image, dest);
		}
		public static void screenshot( String name) throws IOException {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File image = tk.getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir")+"\\Screenshot\\" + name + ".png");
			FileUtils.copyFile(image, dest);
		}
		public static void javascriptscroll(WebElement a) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", a);
		}
		public static void javascriptset(WebElement a, String data) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + data + "')", a);
		}
		public static void javascriptstyle(WebElement a, String data) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','" + data + "')", a);
		}
		public static Object javascriptget(WebElement a) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object script = js.executeScript("return arguments[0].getAttribute('value')", a);
			return script;
		}
		public static void javascriptclick(WebElement a) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", a);
		}
		public static void alertAccept() {
			Alert a1 = driver.switchTo().alert();
			a1.accept();
		}
		public static void alertdismiss() {
			Alert a1 = driver.switchTo().alert();
			a1.dismiss();
		}
		public static void alertsendkeys(String a) {
			Alert a1 = driver.switchTo().alert();
			a1.sendKeys(a);
		}
		public static String alertgettext() {
			Alert a1 = driver.switchTo().alert();
			String text = a1.getText();
			return text;
		}
		public static void switchWindowByUrl(String url) {
			driver.switchTo().window(url);
		}
		public static void switchWindowByTitle(String title) {
			driver.switchTo().window(title);
		}
		public static void switchWindowByIndex(int index) {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> li = new ArrayList<>();
			li.addAll(windowHandles);
			driver.switchTo().window(li.get(index));
		}
		public static void switchWindowByCount(int count) {
			Set<String> allId = driver.getWindowHandles();
			List<String> li = new ArrayList<>();
			li.addAll(allId);
			count--;
			driver.switchTo().window(li.get(count));
		}
		public static void switchToParentId() {
			String windowHandle = driver.getWindowHandle();
			driver.switchTo().window(windowHandle);
		}
		public static void navigateTo(String url) {
			driver.navigate().to(url);
		}
		public static void navigateBack() {
			driver.navigate().back();
		}
		public static void navigateForward() {
			driver.navigate().forward();
		}
		public static void navigateRefresh() {
			driver.navigate().refresh();
		}
		public static boolean isDisplayed(WebElement we) {
			boolean displayed = we.isDisplayed();
			return displayed;
		}
		public static boolean isEnabled(WebElement we) {
			boolean enabled = we.isEnabled();
			return enabled;
		}
		public static boolean isSelected(WebElement we) {
			boolean selected = we.isSelected();
			return selected;
		}
		public static Cell getCellValue(File f,String sheet, int rowIndex, int cellIndex) throws IOException {
			FileInputStream st=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(st);
			Sheet Sheet = w.getSheet(sheet);
			Row row = Sheet.getRow(rowIndex);
			Cell cell = row.getCell(cellIndex);
			return cell;
		}
		public static long doubleToLong(Cell cell) {
			double cellValue = cell.getNumericCellValue();
			long cellValu=(long)cellValue;
			return cellValu;
		}
		public static void createSheet(File location, String SheetName) throws IOException {
			FileInputStream st=new FileInputStream(location);
			Workbook w=new HSSFWorkbook(st);
			w.createSheet(SheetName);
		}
		public static void createRow(File location, String SheetName) throws IOException {
			FileInputStream st=new FileInputStream(location);
			Workbook w=new HSSFWorkbook(st);
			Sheet sheet = w.getSheet(SheetName);
			sheet.createRow(0);
		}
		public static void createCell(File location, String SheetName, int rowIndex, int cellIndex, String cellValue) throws IOException {
			FileInputStream st=new FileInputStream(location);
			Workbook w=new HSSFWorkbook(st);
			Sheet sheet = w.getSheet(SheetName);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.createCell(cellIndex);
			cell.setCellValue(cellValue);
			FileOutputStream ot=new FileOutputStream(location);
			w.write(ot);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

