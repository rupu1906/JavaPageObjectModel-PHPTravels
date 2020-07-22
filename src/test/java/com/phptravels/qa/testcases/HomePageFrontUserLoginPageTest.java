package com.phptravels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.HomePageFrontUserHomeLoginUserPage;
import com.phptravels.qa.pages.HomePageFrontUserHomePage;
import com.phptravels.qa.pages.HomePageFrontUserLoginPage;
import com.phptravels.qa.pages.IndexPage;
import com.phptravels.qa.pages.RegisterPage;
import com.phptravels.qa.util.TestUtil;

public class HomePageFrontUserLoginPageTest extends TestBase{
	IndexPage index;
	HomePageFrontUserHomePage homePage;
	HomePageFrontUserLoginPage loginPage;
	RegisterPage registerPage;
	HomePageFrontUserHomeLoginUserPage homeUser;
	TestUtil testUtil;
	
	
	public HomePageFrontUserLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		index=new IndexPage();
		homePage=	index.clickOnHomePageFrontUserHomePage();
		homePage=new HomePageFrontUserHomePage();
		loginPage= homePage.clickOnLogin();
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login","Incorrect Page");
	}
	
	@Test(priority=2)
	public void validateLoginImgTest() {
		boolean b=loginPage.validateLoginImg();
		Assert.assertTrue(b);
	}
	@Test(priority=3)
	public void loginTest() {
		homeUser =loginPage.login(prop.getProperty("usernameHomePage"), prop.getProperty("passwordHomePage"));
	}
	
	@AfterMethod
	public void tearDown() {	
		driver.quit();
	}
	
	
	
}
