package com.phptravels.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.AdminAccountHomePage;
import com.phptravels.qa.pages.AdminAccountLoginPage;
import com.phptravels.qa.pages.IndexPage;
import com.phptravels.qa.util.TestUtil;

public class AdminAccountHomePageTest extends TestBase{
	
	IndexPage index;
	TestUtil testUtil;
	AdminAccountLoginPage adminAccount;
	AdminAccountHomePage adminUserHomePage;
	
	
	public AdminAccountHomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		index=new IndexPage();
		adminAccount=new AdminAccountLoginPage();
		adminAccount=	index.clickOnAdminLoginPage();
		adminUserHomePage =adminAccount.login(prop.getProperty("usernameAdmin"), prop.getProperty("passwordAdmin"));
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=adminUserHomePage.validateAccountPageTitle();
		Assert.assertEquals(title, "Administator Login","Incorrect Page");
	}
	
	
	@Test(priority=1)
	public void clickOnSuppliers() {
		adminUserHomePage.clickOnAccountandSuppliers();
	}
	
	
	
}
