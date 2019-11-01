package com.mitthsb.qa.pages;

import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriverException;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.util.TestUtil;

public class Loginpage extends TestBase {

	// need to define page factory or object repository

	@FindBy(xpath = "//input[@id='login']")
	WebElement username;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(id = "nsg-x1-logon-button")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='logo _ctxstxt_LogoContainer']")
	WebElement hsbLogo;

	@FindBy(xpath = "//p[contains(@class,'_ctxstxt_HelpWithBankID')]")
	WebElement bankIdLink;

	@FindBy(xpath = "//p[contains(text(),'Information om GDPR')]")
	WebElement infoGDPRLink;
	
	@FindBy(xpath = "//h5[@class='heading-icon'][contains(text(),'Mina händelser')]")
	WebElement grundLadingElement;
	
	@FindBy(xpath = "//h3[@class='tenant-heading'][contains(text(),'HSB Bostadsrättsförening')]")
	WebElement brfHavareGrundLandingElement;
	
			
	@FindBy(partialLinkText = "in din lista")
	WebElement adminLandingElement;

	public Loginpage() {

		// to initialize page factory /object repository objects
		System.out.println("loginpage constructor");

		PageFactory.initElements(driver, this);
	}

	// define Actions

	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean validateHSBLogo() {
		return hsbLogo.isDisplayed();
	}

	public boolean validateBankIDLink() {
		return bankIdLink.isDisplayed();
	}

	public boolean validateGDPRLink() {
		return infoGDPRLink.isDisplayed();
	}

	public HomePage login(String un, String pwd, String role) {

			username.sendKeys(un);			
			TestUtil.pause(2000);
			
			password.sendKeys(pwd);
			TestUtil.pause(2000);

			loginBtn.click();
			TestUtil.pause(2000);
			System.out.println("roleis"+role);	

		switch(role) {
		
		case "Grund":
			wait.until(ExpectedConditions.visibilityOf(grundLadingElement));
			break;
			
		case "maklare":
			wait.until(ExpectedConditions.visibilityOf(adminLandingElement));
			break;
			
		case "brfHavare":
			wait.until(ExpectedConditions.visibilityOf(brfHavareGrundLandingElement));
			break;
			
		case "brfHavareAdmin":
			wait.until(ExpectedConditions.visibilityOf(adminLandingElement));
			break;
			
		case "admin":
			wait.until(ExpectedConditions.visibilityOf(adminLandingElement));
			break;
		}
		

		return new HomePage();
	}

}



