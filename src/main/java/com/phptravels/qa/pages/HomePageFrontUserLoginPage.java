package com.phptravels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class HomePageFrontUserLoginPage extends TestBase {

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='img-fluid mt-auto']")
	WebElement loginLogo;
	
	@FindBy(xpath="//a[@class='btn btn-success br25 btn-block form-group']")
	WebElement signUpBtn;
	
	
	@FindBy(xpath="//a[contains(text(),'Forget Password')]")
	WebElement fogotPassword;
	
	//Initializing the Page Objects
	public HomePageFrontUserLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateLoginImg() {
		
		return loginLogo.isDisplayed();
	}
	
	public HomePageFrontUserHomeLoginUserPage login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePageFrontUserHomeLoginUserPage();
	}
	
	
	
}
