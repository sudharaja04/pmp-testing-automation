package com.dev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dev.config.Base;

public class LandingPage extends Base {

	String b2cURL;
	
//Object Repository
	@FindBy(id = "loginButton")
	@CacheLookup
	private WebElement enter;
	
	@FindBy(xpath = "//span[contains(text(), 'Terms')]")
	private WebElement TermsOfService;
	
	@FindBy(xpath = "//span[contains(text(), 'Privacy')]")
	private WebElement PrivacyPolicy;
	
	
//Initialize the OR
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
//Page Actions
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage enterAzureB2CLoginScreen() {
		enter.click();
		b2cURL = driver.getCurrentUrl();
		return new LoginPage();
	}
}
