package com.mitthsb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;

public class EkonomiPage extends TestBase{
	
	@FindBy(xpath = "//div[contains(text(),'Alla Fakturor (WebbFaktura)')]")
	WebElement allaFakturorListItem;

	@FindBy(xpath = "//div[contains(text(),'Finansiella rapporter')]")
	WebElement finansiellaRapportListItem;

	@FindBy(xpath = "//a[@id='linkName-a' and contains(text(), 'Saldo')]")
	WebElement saldoRapport;

	@FindBy(partialLinkText = "Balansrapport")
	WebElement balansRapport;

	@FindBy(partialLinkText = "Leverant")
	WebElement leveranRapport;
	
	@FindBy(partialLinkText = "Likvidkonto")
	WebElement lividkontoRapport;
	
	@FindBy(partialLinkText = "Resultatrapport")
	WebElement resultRapport;
	
	
public EkonomiPage() {
		
		//to initialize page factory /object repository objects
		
		PageFactory.initElements(driver,this);
	}

//Actions

public String validateEkonomiPageTitle(){
	return driver.getTitle();
	
}
public AllaFakturorListItemPage clickAllaFakturorListItem() {
	 allaFakturorListItem.click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12 content standard-template']")));
	 return new AllaFakturorListItemPage();
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));
}

public FinansiellaRapporterPage clickfinansiellaRapportListItem() {
	 finansiellaRapportListItem.click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));
	 return new FinansiellaRapporterPage();
	
}

public SaldoRapportPage clicksaldoRapport() {
	 saldoRapport.click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@class='main gradient-bg']")));
	 return new SaldoRapportPage();
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
}

public boolean validateAllaFakturorListItem() {
	 return allaFakturorListItem.isDisplayed();
	
	
}

public boolean validatefinansiellaRapportListItem() {
	return finansiellaRapportListItem.isDisplayed();
	 
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
}

public boolean validatesaldoRapport() {
	return saldoRapport.isDisplayed();
	
	
	
}

//public void clickbalansRapport() {
//	 balansRapport.click();
//	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
//}
//
//public void clickleveranRapport() {
//	 leveranRapport.click();
//	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
//}
//
//public void clicklividkontoRapport() {
//	 lividkontoRapport.click();
//	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
//}
//
//public void clickresultRapport() {
//	 resultRapport.click();
//	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
//}

}
