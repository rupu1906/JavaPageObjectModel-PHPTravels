package com.phptravels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.pages.AdminAccountLoginPage;
import com.phptravels.qa.pages.HomePageFrontUserHomePage;
import com.phptravels.qa.pages.IndexPage;
public class IndexPageTest extends TestBase{
	
	IndexPage index;
	HomePageFrontUserHomePage homePage;
	AdminAccountLoginPage adminHomePage;

	public IndexPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		index=new IndexPage();
		
	}
	@Test(priority=1)
	public void indexPageTitleTest() {
		
		String title=index.indexPageTitle();
		Assert.assertEquals(title, "Demo Script Test drive - PHPTRAVELS","Incorrect Page");
	}
	
	@Test
	public void validateLogoLink() {
		
		boolean flag=index.validateLogoLink();
		Assert.assertTrue(flag);
	}
	
	
	@Test
	public void validateLoginLink() {
		boolean flag=index.validateLoginLink();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateDocsLink() {
		
		boolean flag=index.validateDocsLink();
		Assert.assertTrue(flag);
	}
	
	
	@Test
	public void validateBlogLink() {
		
		boolean flag=index.validateBlogLink();
		Assert.assertTrue(flag);
	}
	

	@Test
	public void validateCheckPricingLink() {
		boolean flag=index.validateCheckPricingLink();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateExploreDemoPage() {
	boolean flag=index.validateExploreDemoLink();
	Assert.assertTrue(flag);
	}
	
	
	@Test
	public void validateHomePageFrontUserHomePage() {
		homePage=index.clickOnHomePageFrontUserHomePage();
	}
	
	@Test
	public void validateAdminAccountHomePage() {
		adminHomePage=index.clickOnAdminLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {	
		driver.quit();
	}
	
}
