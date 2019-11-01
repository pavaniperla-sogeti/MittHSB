package com.mitthsb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.util.TestUtil;

public class EkonomiPage extends TestBase{
	
	@FindBy(xpath = "//ul[@id='first-level']//descendant::div[@class='list-group-item-container'][contains(text(),'Alla Fakturor (WebbFaktura)')]")
	List<WebElement> allaFakturorListItem;
	
	
	@FindBy(xpath = "//a[@class='btn-primary'][contains(text(),'Digital WebbFaktura')]")
	WebElement digitalWebFakturaButton;

	@FindBy(xpath = "//ul[@id='first-level']//descendant::div[@class='list-group-item-container'][contains(text(),'Finansiella rapporter')]")
	List<WebElement> finansiellaRapportListItem;
	
	@FindBy(xpath = "//div[@class='visible']//div[@id='graph1']")
	WebElement likvidaMedelGraph;
	
	@FindBy(xpath = "//div[@class='cash-flow-graph']//descendant::div[@class='visible']")
	WebElement cashFlowGraph;
	
	@FindBy(xpath = "//div[@class='disposable-and-bound-funds-graph']//descendant::div[@class='visible']")
	WebElement disposableBoundFundsGraph;
	
	@FindBy(xpath = "//accounts-receivable-graph//descendant::div[@class='visible']")
	List<WebElement> accountsReceivableGraph;

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
	
	@FindBy(xpath = "//h5[contains(text(),'Likvida medel & skulder')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	WebElement informationIconLikvidaMedel;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'Diagrammet')]")
	WebElement informationIconLikvidaMedelIconText;	
	
	@FindBy(xpath = "//h5[contains(text(),'Rapportgenvägar')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	WebElement informationIconRapportGenvagar;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'ekonomiska rapporter')]")
	WebElement informationIconRapportGenvagarText;	
	
	@FindBy(xpath = "//h5[contains(text(),'Disponibelt- och bundet kapital')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	WebElement informationIconDisponibelt;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'disponibelt kapital')]")
	WebElement informationIconDisponibeltText;	
	
	@FindBy(xpath = "//h5[contains(text(),'Kapitalflöde')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	WebElement informationIconCashFlow;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'föreningens')]")
	WebElement informationIconCashFlowText;	
	

	
public EkonomiPage() {
		
		//to initialize page factory /object repository objects
		
		PageFactory.initElements(driver,this);
	}

//Actions

public String validateEkonomiPageTitle(){
	return driver.getTitle();
	
}
public AllaFakturorListItemPage clickAllaFakturorListItem() {
	 allaFakturorListItem.get(0).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12 content standard-template']")));
	 return new AllaFakturorListItemPage();
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));
}

public FinansiellaRapporterPage clickfinansiellaRapportListItem() {
	 finansiellaRapportListItem.get(0).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));
	 return new FinansiellaRapporterPage();
	
}

public SaldoRapportPage clicksaldoRapport() {
	 saldoRapport.click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@class='main gradient-bg']")));
	 return new SaldoRapportPage();
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
}

public boolean validateAllaFakturorListItem(String rolePrevilege) {
	
	int ElementSize = allaFakturorListItem.size();
	System.out.println("allaFakturorListItem element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	return flag;

	
	
}

public boolean validateAccountsReceivableGraph(String rolePrevilege) {
	
	int ElementSize = accountsReceivableGraph.size();
	System.out.println("accountsReceivableGraph element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	return flag;

	
}



public boolean validatefinansiellaRapportListItem(String rolePrevilege) {
	
	int ElementSize = finansiellaRapportListItem.size();
	System.out.println("finansiellaRapportListItem element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	return flag;
	
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
}

public boolean validatesaldoRapport() {
	return saldoRapport.isDisplayed();	
	
	
}

public boolean clickGenvagar() {
	 saldoRapport.click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));
	 return true;
	
	
}
//this is in sub category of alla fakturor list item
public String validateDigitalWebFakturaButtonAllaFakturorListItem() {
	allaFakturorListItem.get(0).click();
	digitalWebFakturaButton.click();
	String ChildwindowId=TestUtil.getNewChildWindowId();
	driver.switchTo().window(ChildwindowId);
	
	 return driver.getTitle();
	
	
}

public boolean validateRapportGenvagar() {
	
	List<WebElement> rapportGenvagar=driver.findElements(By.xpath("//li[@class='list-group-item shortcut-item econmical-reports-item']"));
	int j=0;
	
 for(int i=0;i<rapportGenvagar.size();i++){
		 
		 String drop_down_values=rapportGenvagar.get(i).getText();
		 if(drop_down_values.equals("Saldoförteckning") || drop_down_values.equals("Balansrapport") || drop_down_values.equals("Leverantörsrapport") || drop_down_values.equals("Likvidkontorapport") || drop_down_values.equals("Resultatrapport"))
			 j++;
 }
		
	if(j==5)
		return true;
	else
		return false;
	
	
}

public boolean validateLikvidaMedelGraph() {
	return likvidaMedelGraph.isDisplayed();	
	
	
}

public boolean validateDisponibeltGraph() {
	return cashFlowGraph.isDisplayed();	
	
	
}

public boolean validateCashFlowGraph() {
	return disposableBoundFundsGraph.isDisplayed();	
	
	
}

public boolean validateInformationIconLikvidaMedelGraph() {
	
	informationIconLikvidaMedel.click();
	return informationIconLikvidaMedelIconText.isDisplayed();
}

public boolean validateInformationIconRapportGenvagarFrame() {
	
	informationIconRapportGenvagar.click();
	return informationIconRapportGenvagarText.isDisplayed();
}

public boolean validateInformationIconDisponiBeltGraph() {
	
	informationIconDisponibelt.click();
	return informationIconDisponibeltText.isDisplayed();
}

public boolean validateInformationIconCashFlowGraph() {
	
	informationIconCashFlow.click();
	return informationIconCashFlowText.isDisplayed();
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
