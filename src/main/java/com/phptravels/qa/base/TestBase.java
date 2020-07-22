package com.phptravels.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.phptravels.qa.util.TestUtil;
import com.phptravels.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() {
		
		  
		try {
			
			prop=new Properties();
			 FileInputStream ip = new FileInputStream("C:\\Users\\Sharmistha\\Documents\\Java Training\\PHPTravelsTest\\src\\main\\java\\com\\phptravels\\qa\\conf\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	public static void initialization() {
		
		String browser=prop.getProperty("browser");
		  
			if(browser.equals("chrome"))
			{
				
				System.setProperty("webdriver.chrome.driver","C:/Users/Sharmistha/Documents/Java Training/Selenium Jar files/chromedriver.exe");
				 driver = new ChromeDriver();
			}
			
			else if(browser.equals("FF")){
				System.setProperty("webdriver.gecko.driver","C:/Users/Sharmistha/Documents/Java Training/Selenium Jar files/geckodriver.exe");
				 driver = new FirefoxDriver();
			}
			
			else {
				
				System.setProperty("webdriver.ie.driver","C:\\Users\\Sharmistha\\Documents\\Java Training\\Selenium Jar files\\IEDriverServer.exe"); 
				 driver=new InternetExplorerDriver();
				
			}
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get(prop.getProperty("url"));
		}

	
	
}
