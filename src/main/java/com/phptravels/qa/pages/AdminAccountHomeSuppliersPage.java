package com.phptravels.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.util.TestUtil;

public class AdminAccountHomeSuppliersPage extends TestBase{

	
	@FindBy(xpath="//form[@class='add_button']//button")
	WebElement clickOnAdd;
	
	@FindBy(xpath="//div[@class='panel panel-default']//div[text()='Suppliers Management']")
	WebElement logoImg;

	public AdminAccountHomeSuppliersPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateAccountPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateLogoImagVisible() {
		boolean flag=logoImg.isDisplayed();
		return flag;
		
		
	}
	
	
	public void clickOnAddBtn() {
		clickOnAdd.click();
	
	}
	
	
	public void addNewSuppliers(String fname, String lname,  String email, String pass, String mobile,String country) {
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//div[@id='s2id_autogen1']//a//span[text()='Please Select']")).click();
		TestUtil.chooseFromMulitpleOptions("//ul[@class='select2-results']//li/descendant::div[contains(text(),'')]", country);
		driver.findElement(By.xpath("//div[@class='panel-footer']//button")).click();
		
		
	}

	
	
}
