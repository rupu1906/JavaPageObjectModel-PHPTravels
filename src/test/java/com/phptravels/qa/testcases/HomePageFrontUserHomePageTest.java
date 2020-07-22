package com.phptravels.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.HomePageFrontUserHomePage;
import com.phptravels.qa.pages.HomePageFrontUserLoginPage;
import com.phptravels.qa.pages.IndexPage;
import com.phptravels.qa.pages.RegisterPage;
import com.phptravels.qa.util.TestUtil;

public class HomePageFrontUserHomePageTest extends TestBase{

	IndexPage index;
	HomePageFrontUserHomePage homePage;
	HomePageFrontUserLoginPage loginPage;
	RegisterPage registerPage;
	
	TestUtil testUtil;
	
	public HomePageFrontUserHomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil=new TestUtil();
		index=new IndexPage();
		homePage=	index.clickOnHomePageFrontUserHomePage();
	}
	
	@Test
	public void validatePageTitle() {
		String title=homePage.getPageTitle();
		Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner");
	}
	@Test
	public void validateImgLogo() {
		boolean flag=homePage.validateImg();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateLoginPage() {
		loginPage=homePage.clickOnLogin();
	}
	
	@Test
	public void validateSignInPage() {
		registerPage=homePage.clickOnSignUp();
	}
	
	@Test
	public void chooseCurrency() {
		homePage.chooseCurrency();
	}
	
	@Test
	public void chooseLanguage() {
		boolean flag =homePage.chooseLanguage("French","Nouvelles du blog");
		Assert.assertTrue(flag);
	}
	
	@Test
	public void fillOutTheForm() throws InterruptedException {
		homePage.fillOutForm("Toro","Toronto","10/08/2020","25/08/2020");
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
}
