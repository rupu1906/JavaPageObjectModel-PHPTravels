package com.phptravels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class AdminAccountLoginPage extends TestBase {

	@FindBy(xpath="//div//label//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//div//label//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	public AdminAccountLoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public  AdminAccountHomePage login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		return new AdminAccountHomePage();
	}
	
}
