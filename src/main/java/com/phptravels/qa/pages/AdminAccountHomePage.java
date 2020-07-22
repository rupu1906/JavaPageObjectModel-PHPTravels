package com.phptravels.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class AdminAccountHomePage extends TestBase{

	@FindBy(xpath="//ul[@id='social-sidebar-menu' and @class='list-unstyled components']//li[5]//a[contains(text(),'Accounts')]")
	WebElement account;
	
	@FindBy(xpath="//ul[@id='social-sidebar-menu' and @class='list-unstyled components']//li[6]//a//i[@class='fa fa-list-alt w30']")
	WebElement cms;
	
	@FindBy(xpath="//form[@class='add_button']//button")
	WebElement clickOnAdd;
	
	
	public AdminAccountHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateAccountPageTitle() {
		
		return driver.getTitle();
	}
	
	public AdminAccountHomeSuppliersPage clickOnAccountandSuppliers() {
		account.click();
		driver.findElement(By.xpath("//ul[@id='ACCOUNTS']//li[2]//a")).click();
	
	return new AdminAccountHomeSuppliersPage();
	}


	
}
