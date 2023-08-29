package com.phptravels.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.phptravels.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITE_WAIT=20;
	String currentDir = System.getProperty("user.dir");
	String path = "\\src\\main\\java\\com\\phptravels\\qa\\testdata\\DemoFile.xlsx";
	public static String TEST_DATA_SHEET=currentDir+path;
	public static Workbook book;
	public static XSSFSheet sheet;
	
	static JavascriptExecutor js;
	
	//Switch to Frame
	public static void switchToFrame() {
		driver.switchTo().frame(0);
	}
	
	//Switch to new Window
	public static void switchToNewWindow() {
		 Set <String> handles =driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			//iterate through your windows
			while (it.hasNext()) {
			String newwin = it.next();
			driver.switchTo().window(newwin);	
		}
	 }
	 
	 //Choose from Multiple Options specially in a Drop Down
	 public static void chooseFromMulitpleOptions(String xpath,String option) {
		 List<WebElement> list=driver.findElements(By.xpath(xpath));
		 for( int i=0;i<list.size();i++) {
			  //System.out.println(list.get(i).getText());
			  if(list.get(i).getText().contains(option)) {
				  
				  list.get(i).click();
				 break;
			  }
		  }
		}
	 
	 //Fetch the data from Excel Sheet
	 public static Object[][] getTestData(String sheetName) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(TEST_DATA_SHEET);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (IllegalFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = (XSSFSheet) book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			return data;
		}
	 
	 
	 // Click On Element usign JS
	 public static void clickOnElementByJS(WebElement element, WebDriver driver) {	
			JavascriptExecutor js= ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();",element);	
	 }
	 
	 //TO scrollInTO view using JS
	 public static void scrollInToView(WebElement element,WebDriver driver) {
		 JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
			
	 }
	 //Select Date in a Calendar using JS
	 public static void selectDateByJS(WebDriver driver,WebElement element,String dateVal) {
			
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		}
	 
	 //To take ScreenShots
	 public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			long imgName= System.currentTimeMillis();
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + imgName + ".png"));
			//FileHandler.copy(scrFile, new File("C:\\Users\\Sharmistha\\Documents\\Java Training\\ScreenShots\\123.png"));
		}
	 
	 
	 
	 
	 
	 public static void runTimeInfo(String messageType, String message) throws InterruptedException {
			js = (JavascriptExecutor) driver;
			// Check for jQuery on the page, add it if need be
			js.executeScript("if (!window.jQuery) {"
					+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
					+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
					+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
			Thread.sleep(5000);

			// Use jQuery to add jquery-growl to the page
			js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

			// Use jQuery to add jquery-growl styles to the page
			js.executeScript("$('head').append('<link rel=\"stylesheet\" "
					+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
			Thread.sleep(5000);

			// jquery-growl w/ no frills
			js.executeScript("$.growl({ title: 'GET', message: '/' });");
	//'"+color+"'"
			if (messageType.equals("error")) {
				js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
			}else if(messageType.equals("info")){
				js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
			}else if(messageType.equals("warning")){
				js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
			}else
				System.out.println("no error message");
			// jquery-growl w/ colorized output
//			js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
			Thread.sleep(5000);
		}

	 
	 
}
