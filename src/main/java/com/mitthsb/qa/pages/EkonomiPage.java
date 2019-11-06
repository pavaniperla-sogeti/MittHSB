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
	
	@FindBy(xpath = "//li[@class='list-group-item shortcut-item econmical-reports-item']")
	List<WebElement> rapportGenvagar;
	
	@FindBy(xpath = "//a[@class='btn-primary'][contains(text(),'Digital WebbFaktura')]")
	WebElement digitalWebFakturaButton;
	
	@FindBy(xpath = "//h4[contains(text(),'Alla Fakturor (WebbFaktura')]")
	WebElement allFakturorListItemPageElement;
	
	@FindBy(xpath = "//iframe[@id='iFrameResizer0']")
	WebElement finansiellRaportListItemPageElement;
	
	@FindBy(xpath = "//main[@class='main gradient-bg']")
	WebElement saldoRaportPageElement;

	@FindBy(xpath = "//ul[@id='first-level']//descendant::div[@class='list-group-item-container'][contains(text(),'Finansiella rapporter')]")
	List<WebElement> finansiellaRapportListItem;
	
	@FindBy(xpath = "//div[@class='visible']//div[@id='graph1']")
	List<WebElement> likvidaMedelGraph;
	
	@FindBy(xpath = "//div[@class='cash-flow-graph']//descendant::div[@class='visible']")
	List<WebElement> cashFlowGraph;
	
	@FindBy(xpath = "//div[@class='disposable-and-bound-funds-graph']//descendant::div[@class='visible']")
	List<WebElement> disposableBoundFundsGraph;
	
	@FindBy(xpath = "//accounts-receivable-graph//descendant::div[@class='visible']")
	List<WebElement> accountsReceivableGraph;

	@FindBy(xpath = "//a[@id='linkName-a' and contains(text(), 'Saldo')]")
	List<WebElement>  saldoRapport;

	@FindBy(partialLinkText = "Balansrapport")
	WebElement balansRapport;

	@FindBy(partialLinkText = "Leverant")
	WebElement leveranRapport;
	
	@FindBy(partialLinkText = "Likvidkonto")
	WebElement lividkontoRapport;
	
	@FindBy(partialLinkText = "Resultatrapport")
	WebElement resultRapport;
	
	@FindBy(xpath = "//h5[contains(text(),'Likvida medel & skulder')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	List<WebElement> informationIconLikvidaMedel;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'Diagrammet')]")
	WebElement informationIconLikvidaMedelIconText;	
	
	@FindBy(xpath = "//h5[contains(text(),'Rapportgenvägar')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	List<WebElement> informationIconRapportGenvagar;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'ekonomiska rapporter')]")
	WebElement informationIconRapportGenvagarText;	
	
	@FindBy(xpath = "//h5[contains(text(),'Disponibelt- och bundet kapital')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	List<WebElement> informationIconDisponibelt;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'disponibelt kapital')]")
	WebElement informationIconDisponibeltText;	
	
	@FindBy(xpath = "//h5[contains(text(),'Kapitalflöde')]//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	List<WebElement> informationIconCashFlow;	
	
	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'inklusive bankkonton och bundna placeringar')]")
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
	 wait.until(ExpectedConditions.visibilityOf(allFakturorListItemPageElement));
	 return new AllaFakturorListItemPage();
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));
}

public FinansiellaRapporterPage clickfinansiellaRapportListItem() {
	 finansiellaRapportListItem.get(0).click();
	 wait.until(ExpectedConditions.visibilityOf(finansiellRaportListItemPageElement));
	 return new FinansiellaRapporterPage();
	
}

public SaldoRapportPage clicksaldoRapport() {
	 saldoRapport.get(0).click();
	 wait.until(ExpectedConditions.visibilityOf(saldoRaportPageElement));
	 return new SaldoRapportPage();
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
}

public boolean validateAllaFakturorListItem(String rolePrevilege) {
	
	int ElementSize = allaFakturorListItem.size();
	System.out.println("allaFakturorListItem element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	System.out.println("flag size is"+flag);
	return flag;

	
	
}

public boolean validateAccountsReceivableGraph(String rolePrevilege) {
	
	int ElementSize = accountsReceivableGraph.size();
	System.out.println("accountsReceivableGraph element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	System.out.println("flag value is"+flag);
	return flag;

	
}



public boolean validatefinansiellaRapportListItem(String rolePrevilege) {
	
	int ElementSize = finansiellaRapportListItem.size();
	
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	System.out.println("finansiellaRapportListItem element size is"+ElementSize+"flag value is"+flag);
	return flag;
	
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("fakturor att")));
}

//display of saldo rapport
public boolean validatesaldoRapport(String rolePrevilege) {
	
	int ElementSize = saldoRapport.size();
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	System.out.println("saldoRapport element size is"+ElementSize+"and flag is"+flag);
	return flag;
		
	
	
}

public boolean clickGenvagar(String rolePrevilege) {
	int ElementSize = allaFakturorListItem.size();
	System.out.println("allaFakturorListItem element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	if(futheraction) {
		System.out.println("inside success loop");
	 saldoRapport.get(0).click();
	 wait.until(ExpectedConditions.visibilityOf(saldoRaportPageElement));
	 return true;
	}
	if(flag && !futheraction)
		return true;
	
	else
		return false;
	
	
	
}
//this is in sub category of alla fakturor list item
public String validateDigitalWebFakturaButtonAllaFakturorListItem(String rolePrevilege) {
	
	int ElementSize = allaFakturorListItem.size();
	System.out.println("allaFakturorListItem element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	if(futheraction) {		
	allaFakturorListItem.get(0).click();
	digitalWebFakturaButton.click();
	String ChildwindowId=TestUtil.getNewChildWindowId();
	driver.switchTo().window(ChildwindowId);
		 return driver.getTitle();
	}
	
	return null;
	
	
}

	public boolean validateRapportGenvagar(String rolePrevilege) {

		int j = 0;

		for (int i = 0; i < rapportGenvagar.size(); i++) {

			String drop_down_values = rapportGenvagar.get(i).getText();
			if (drop_down_values.equals("Saldoförteckning") || drop_down_values.equals("Balansrapport")
					|| drop_down_values.equals("Leverantörsrapport") || drop_down_values.equals("Likvidkontorapport")
					|| drop_down_values.equals("Resultatrapport"))
				
				j++;
		}

		if (j == 5)
		{
			System.out.println("found all 5 reports");
		
			return true;
		}
		else
			return false;

	}

public boolean validateLikvidaMedelGraph(String rolePrevilege) {
	
	int ElementSize = likvidaMedelGraph.size();
	System.out.println("likvidaMedelGraph element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	return flag;
	
	
}

public boolean validateCashFlowGraph(String rolePrevilege) {
	
	int ElementSize = cashFlowGraph.size();
	System.out.println("cashFlowGraph element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	System.out.println("flag value is "+flag);
	return flag;
	
	
	
}

public boolean validateDisponibeltGraph(String rolePrevilege) {
	
	int ElementSize = disposableBoundFundsGraph.size();
	
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	System.out.println("disposableBoundFundsGraph element size is"+ElementSize+"and flag value is"+flag);
	return flag;
	
	
	
}

public boolean validateInformationIconLikvidaMedelGraph(String rolePrevilege) {
	
	int ElementSize = informationIconLikvidaMedel.size();
	System.out.println("likvidaMedelGraph element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	
	if(futheraction) {
		System.out.println("furtheraction true");
		informationIconLikvidaMedel.get(0).click();
			boolean flag1= informationIconLikvidaMedelIconText.isDisplayed();
			System.out.println("flag value is"+flag1);
			return true;
		}
		if(flag && !futheraction)
			return true;
		
		else
			return false;
	}

public boolean validateInformationIconRapportGenvagarFrame(String rolePrevilege) {
	
	int ElementSize = informationIconRapportGenvagar.size();
	System.out.println("rapportGenvagar element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	if(futheraction) {
		System.out.println("furtheraction true");
		informationIconRapportGenvagar.get(0).click();
		boolean flag1= informationIconRapportGenvagarText.isDisplayed();
		System.out.println("flag value is"+flag1);
		return true;
		}
		if(flag && !futheraction)
			return true;
		
		else
			return false;
	
}

public boolean validateInformationIconDisponiBeltGraph(String rolePrevilege) {
	
	int ElementSize = informationIconDisponibelt.size();
	System.out.println("informationIconDisponibelt element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	
	if(futheraction) {
		System.out.println("furtheraction true");
		informationIconDisponibelt.get(0).click();
			boolean flag1=informationIconDisponibeltText.isDisplayed()	;
			System.out.println("flag value of text is"+flag1);
			return flag1;
		}
		if(flag && !futheraction)
			return true;
		
		else
			return false;
	
	
}

public boolean validateInformationIconCashFlowGraph(String rolePrevilege) {
	
		
	int ElementSize = informationIconCashFlow.size();
	System.out.println("informationIconCashFlow element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	System.out.println("flag value is true");
	if(futheraction) {
		System.out.println("furtheraction true");
		informationIconCashFlow.get(0).click();
		boolean flag1=informationIconCashFlowText.isDisplayed()	;
		System.out.println("flag value of text is"+flag1);
		return flag1;
		
	}
	if(flag && !futheraction) {
		System.out.println("furtheraction flase");
		return true;
	}
		
	
	else
		return false;
	

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
