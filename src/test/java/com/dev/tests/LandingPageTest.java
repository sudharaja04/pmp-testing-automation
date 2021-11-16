package com.dev.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dev.config.Base;
import com.dev.pages.LandingPage;
import com.dev.pages.LoginPage;

public class LandingPageTest extends Base {

	LandingPage landingPage;
	LoginPage loginPage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		landingPage = new LandingPage();
	}
	
	@Test
	public void landingPageTitleTest() {
		String actualTitle = landingPage.validateLandingPageTitle();
		Assert.assertEquals(actualTitle, "Member Portal");
	}
	
	@Test
	public void enterLoginPageTest() {
		loginPage = landingPage.enterAzureB2CLoginScreen();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
