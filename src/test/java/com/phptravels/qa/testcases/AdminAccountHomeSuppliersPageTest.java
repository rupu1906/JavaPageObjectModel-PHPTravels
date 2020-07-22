package com.phptravels.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.AdminAccountHomePage;
import com.phptravels.qa.pages.AdminAccountHomeSuppliersPage;
import com.phptravels.qa.pages.AdminAccountLoginPage;
import com.phptravels.qa.pages.IndexPage;
import com.phptravels.qa.util.TestUtil;

public class AdminAccountHomeSuppliersPageTest extends TestBase{

	IndexPage index;
	TestUtil testUtil;
	AdminAccountLoginPage adminAccount;
	AdminAccountHomePage adminUserHomePage;
	AdminAccountHomeSuppliersPage suppliers;
	
	
	public AdminAccountHomeSuppliersPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		index=new IndexPage();
		adminAccount=new AdminAccountLoginPage();
		adminUserHomePage=new AdminAccountHomePage();
		adminAccount=	index.clickOnAdminLoginPage();
		adminUserHomePage =adminAccount.login(prop.getProperty("usernameAdmin"), prop.getProperty("passwordAdmin"));
		suppliers=adminUserHomePage.clickOnAccountandSuppliers();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=suppliers.validateAccountPageTitle();
		Assert.assertEquals(title, "Dashboard","Incorrect Page");
	}
	
	@Test(priority=2)
	public void validateLogoImg() {
		boolean flag=suppliers.validateLogoImagVisible();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3, dataProvider="getTestDataPHP")
	public void clickOnSuppliers(String fname,String lname,String email,String pass,String mNum,String country) {
		suppliers.clickOnAddBtn();
		suppliers.addNewSuppliers(fname,lname,email,pass,mNum,country);
		
	}
	
	@DataProvider()
	public Object[][] getTestDataPHP() throws IOException {
		Object data [][]=TestUtil.getTestData("Suppliers");
		return (data);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
