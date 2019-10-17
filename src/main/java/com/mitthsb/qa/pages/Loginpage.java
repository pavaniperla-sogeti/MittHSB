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

	public Loginpage() {

		// to initialize page factory /object repository objects

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

		password.sendKeys(pwd);
		loginBtn.click();

		// try {
		if (role.equals("Grund"))

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='content no-max-width gradient-bg col-12']")));

		else

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("in din lista")));
		// wait.until(ExpectedConditions.
//		} catch (TimeoutException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	

		return new HomePage();
	}

}



