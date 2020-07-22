package com.phptravels.qa.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.util.TestUtil;

public class HomePageFrontUserHomePage extends TestBase{
	

	 //PHPTRAVELS |  
	
	//(ExpectedConditions.visibilityOf(myAccountBtn));
	
	@FindBy(xpath=" //ul//li/descendant::div[@class='dropdown dropdown-login dropdown-tab']")
	WebElement myAccountBtn;

	@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-right show']//a[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-right show']//a[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//ul//li/descendant::div[@class='dropdown dropdown-currency']")
	WebElement currencyBtn;
	
	@FindBy(xpath="//ul//li/descendant::div[@class='dropdown dropdown-language']//a[@id='dropdownLangauge']")
	WebElement selectLanguage;
	
	@FindBy(xpath="//div[@id='s2id_autogen10']//a[@class='select2-choice']//span[text()='Search by Hotel or City Name']")
	WebElement clickOnSelectLocation;
	
	@FindBy(xpath="//div[@class='col-md-4 col-2 o2']//div//a//img")
	WebElement logoImg;
	

	
	public HomePageFrontUserHomePage() {	
		PageFactory.initElements(driver, this);
	}

	 public HomePageFrontUserHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}


	 public boolean validateImg() {
		 
		 return logoImg.isDisplayed();
	 }
	 
	 public String getPageTitle() {
		 String title=driver.getTitle();
		 return title;
	 }
	 
	 
	public HomePageFrontUserLoginPage clickOnLogin() {

		myAccountBtn.click();				
		 loginBtn.click();
		 return new HomePageFrontUserLoginPage();
		 
		 
	 }
	
	public void chooseCurrency() {
		currencyBtn.click();		
		TestUtil.chooseFromMulitpleOptions("//ul//li/descendant::div[@class='dropdown-menu-inner']//a[@class='dropdown-item text-center']","INR");
	}
	
	
	
	public boolean chooseLanguage(String language,String blogContent) {
		selectLanguage.click();
		TestUtil.chooseFromMulitpleOptions("//ul//li/descendant::div[@class='dropdown-menu dropdown-menu-right show']//a",language);
	return driver.findElement(By.xpath("//h2[@class='float-none' and contains(text(),'"+blogContent+"')]")).isDisplayed();
	}

	public RegisterPage clickOnSignUp() {
		 myAccountBtn.click();
		 signUpBtn.click();
		 return new RegisterPage();
		 
		 
	 }
	
public void fillOutForm(String passCity,String city,String startDate1, String endDate1){
		
		clickOnSelectLocation.click();		
		WebElement formLocation=driver.findElement(By.xpath("//div[@id='select2-drop']//input[@type='text']"));
		formLocation.sendKeys(passCity);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT, TimeUnit.SECONDS);
		TestUtil.chooseFromMulitpleOptions("//ul[@class='select2-result-sub']//li/descendant::div[@class='select2-result-label']",city);
		WebElement startDate=driver.findElement(By.xpath("//input[@id='checkin']"));
		startDate.clear();
		startDate.sendKeys(startDate1);
		WebElement endDate=driver.findElement(By.xpath("//input[@id='checkout']"));
		endDate.clear();
		endDate.sendKeys(endDate1);		
		WebElement select1=driver.findElement(By.xpath("//div[@class='col-md-2 col-xs-12']//button[@type='submit' and contains(text(),'Search') and @class='btn btn-primary btn-block']"));
		TestUtil.clickOnElementByJS(select1, driver);
	}
	
	
	
}
