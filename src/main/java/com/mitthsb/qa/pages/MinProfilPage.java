package com.mitthsb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;

public class MinProfilPage extends TestBase {
	
	@FindBy(xpath = "//div[contains(text(),'Mina uppgifter')]")
	WebElement minaUppgifterLink;
	
	@FindBy(xpath = "//div[contains(text(),'Medlemsbevis')]")
	WebElement medlemBevisLink;

	@FindBy(linkText = "//div[contains(text(),'Frågor och svar')]")
	WebElement fragorOchSvarLink;
	
	public MinProfilPage() {
		// to initialize page factory /object repository objects

		PageFactory.initElements(driver, this);
	}
	

	public boolean validateMinaUppgifterLinkLink() {
		return minaUppgifterLink.isDisplayed();
	}

	public boolean validateMedlemBevisLinkLink() {
		return medlemBevisLink.isDisplayed();
	}

	public boolean validateFragorOchSvarLink() {
			return fragorOchSvarLink.isDisplayed();
	}
	
	


public MinaUppgifterPage minaUppgifterLink() {
	

	minaUppgifterLink.click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='graph1']")));

	return new MinaUppgifterPage();
	}


public MedlembevisPage medlemBevisLink() {
	

	medlemBevisLink.click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='graph1']")));

	return new MedlembevisPage();
	}

public FragorOchSvarPage fragorOchSvarTab() {
	

	fragorOchSvarLink.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='graph1']")));

		return new FragorOchSvarPage();
		}


	

}
