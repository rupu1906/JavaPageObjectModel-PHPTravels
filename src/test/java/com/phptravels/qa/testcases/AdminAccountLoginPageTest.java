package com.phptravels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.AdminAccountHomePage;
import com.phptravels.qa.pages.AdminAccountLoginPage;
import com.phptravels.qa.pages.IndexPage;
import com.phptravels.qa.util.TestUtil;
public class AdminAccountLoginPageTest extends TestBase{
	IndexPage index;
	TestUtil testUtil;
	AdminAccountLoginPage adminAccount;
	AdminAccountHomePage adminUserHomePage;
	
	
	public AdminAccountLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		index=new IndexPage();
		adminAccount=	index.clickOnAdminLoginPage();
	//	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		//test = report.startTest("ExtentDemo");
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=adminAccount.validateLoginPageTitle();
		Assert.assertEquals(title, "Administator Login","Incorrect Page");
	}
	
	
	@Test(priority=3)
	public void loginTest() {
		adminUserHomePage =adminAccount.login(prop.getProperty("usernameAdmin"), prop.getProperty("passwordAdmin"));
	}
	
	@AfterMethod
	public void tearDown() {	
		driver.quit();
	}
	

}
