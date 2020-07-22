package com.phptravels.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.util.TestUtil;

public class IndexPage extends TestBase{

	//Title----Demo Script Test drive - PHPTRAVELS

	
	@FindBy(xpath="//div[@class='text']//h2[@class='wow fadeIn upper animated']")
	WebElement logoIndex;
	
	@FindBy(xpath="//a[contains(text(),'Log in')]")
	WebElement loginLink;
	
	@FindBy(xpath="//a[@class='yx-njm' and contains(text(),'Docs')]")
	WebElement docsLink;
	
	@FindBy(xpath="//a[@class='yx-njm' and contains(text(),'Blog')]")
	WebElement blogLink;
	
	@FindBy(xpath="//div[@class='col-md-6']//a[@class='btn btn-hero btns btn-success hero-right']")
	WebElement checkPricingLink;
	
	@FindBy(xpath="//div[@class='col-md-6']//a[@class='btn btn-hero btns btn-light-blue']")
	WebElement exploreDemoLink;
	
	@FindBy(xpath="//div[@class='col-md-6']//a[@class='btn btn-primary btn-lg btn-block']//small[contains(text(),'http://www.phptravels.net/admin')]")
	WebElement adminLoginPageLink;
	
	@FindBy(xpath="//div[@class='col-md-6']//a[@class='btn btn-primary btn-lg btn-block']//small[text()='http://www.phptravels.net']")
	WebElement homePageFrontEnd;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String indexPageTitle() {
		return driver.getTitle();	
		
	}
	
	public boolean validateLogoLink() {	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b= logoIndex.isDisplayed();
		return b;
	}
	
	
	public boolean validateLoginLink() {
		boolean b=loginLink.isDisplayed();
		return b;
	}
	
	public ClientLoginPage clickOnLoginLink() {
		loginLink.click();
		return new ClientLoginPage();
	}
	
	public boolean validateDocsLink() {
		boolean b= docsLink.isDisplayed();	
		return b;
	}
	
	public DocsPage clickOnDocsPage() {
		docsLink.click();
		return new DocsPage();
	}
	
	public boolean validateBlogLink() {
		boolean b= blogLink.isDisplayed();
		return b;
	}
	
	public BlogPage clickOnBlogPage() {
		docsLink.click();
		return new BlogPage();
	}
	
	public boolean validateCheckPricingLink() {
		boolean b= checkPricingLink.isDisplayed();
		return b;
	}
	
	public PricingPage clickOncheckPricingPage() {
		checkPricingLink.click();
		return new PricingPage();
	}
	
	public boolean validateExploreDemoLink() {
		boolean b= exploreDemoLink.isDisplayed();
		return b;
	}
	
	public IndexPage clickOnExploreDemoPage() {
		exploreDemoLink.click();
		return new IndexPage();
	}
	
	public HomePageFrontUserHomePage clickOnHomePageFrontUserHomePage() {
		homePageFrontEnd.click();
		TestUtil.switchToNewWindow();
		return new HomePageFrontUserHomePage();
	}



	public AdminAccountLoginPage clickOnAdminLoginPage() {
		adminLoginPageLink.click();
		TestUtil.switchToNewWindow();
		return new AdminAccountLoginPage();
	}
	
	
}
