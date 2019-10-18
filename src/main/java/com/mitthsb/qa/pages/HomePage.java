//if you wnat to switch the frame before checking the xpath.

package com.mitthsb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[contains(@id,'graph1')]")
	WebElement LikvidaGraph;

	@FindBy(xpath = "//div[contains(@class, 'col-12 col-md-5 centered-second')]")
	WebElement hsbNews;

	@FindBy(linkText = "Mitt uppdrag")
	WebElement mittUppdragLink;

	@FindBy(linkText = "Mina sidor")
	WebElement minaSidorLink;

	@FindBy(xpath = "//a[contains(text(),'Nytt') and @class='navigation-link']")
	WebElement nyttFranHsb;

	@FindBy(xpath = "//a[contains(text(),'in din lista')]")
	WebElement todoFakturorList;

	@FindBy(linkText = "Ekonomi")
	WebElement ekonomiTab;

	@FindBy(linkText = "Administration")
	WebElement adminTab;

	@FindBy(linkText = "Fastigheten")
	WebElement FastightenTab;

	@FindBy(linkText = "Dokument")
	WebElement dokumentTab;
	
	@FindBy(linkText = "Logga ut")
	WebElement logoutBtn;
	
	@FindBy(linkText = "Logga ut")
	WebElement vivalya_MinaSidor;
	
	@FindBy(linkText = "Logga ut")
	WebElement vivalya_NyttfranHsb;
	
	//minasidor objects
	@FindBy(linkText = "Brf Facklan")
	WebElement brfFacklanTab;
	
	@FindBy(xpath = "//a[contains(@class,'mn-btn')][contains(text(),'felanm')]")
	WebElement arendenTab;

	@FindBy(xpath = "//a[contains(@class,'mn-btn')][contains(text(),'Min Bostad')]")
	WebElement minBostadTab;

	@FindBy(linkText = "Bospar")
	WebElement bosparTab;

	@FindBy(linkText = "Medlemskapet")
	WebElement medlemskapTab;

	@FindBy(xpath = "//a[contains(@class,'mn-btn')][contains(text(),'Sök bostad')]")
	WebElement sokBostadTab;
	
	@FindBy(linkText = "Min profil")
	WebElement minProfileTab;



	public HomePage() {

		// to initialize page factory /object repository objects

		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();

	}

	public boolean validateMittUpdragLink() {
		return mittUppdragLink.isDisplayed();
	}

	public boolean validateMinaSidorLink() {
		return minaSidorLink.isDisplayed();
	}

	public boolean validateNyttFranHsb() {
			return nyttFranHsb.isDisplayed();
	}

	public boolean validateFakturorDisplay() {
		return todoFakturorList.isDisplayed();
	}

	public boolean validateHsbNews() {
		return hsbNews.isDisplayed();
	}

	public EkonomiPage ekonomiTab() {
		

		ekonomiTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='graph1']")));

		return new EkonomiPage();
		}


	public AdministrationPage adminTab() {

		adminTab.click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content-first\"]/div[2]/div/button")));

		return new AdministrationPage();

	}

	public FastighetenPage fastightenTab() {

		FastightenTab.click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));

		return new FastighetenPage();

	}

	public DokumentPage dokumentTab() {

		dokumentTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));

		return new DokumentPage();

	}
	// define Actions for minasidor page
	
	public MinaSidorPage minaSidorLink() {

		minaSidorLink.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content no-max-width gradient-bg col-12']")));

		return new MinaSidorPage();

	}
	
	

	public boolean validateBrfFacklan() {
		return brfFacklanTab.isDisplayed();
	}

	public boolean validateArendenTab() {
		return arendenTab.isDisplayed();
	}

	public boolean validateMinBostadTab() {
			return minBostadTab.isDisplayed();
	}

	public boolean validateBosparTab() {
		return bosparTab.isDisplayed();
	}

	public boolean validateMedlemskapTab() {
		return medlemskapTab.isDisplayed();
	}
	
	public boolean validateSokBostadTab() {
		return sokBostadTab.isDisplayed();
	}

	public boolean validateMinProfileTab() {
		return minProfileTab.isDisplayed();
	}

	public BrfFacklanPage BrfFacklanTab() {
		

		brfFacklanTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content no-max-width gradient-bg col-12']")));

		return new BrfFacklanPage();
		}


	public ArendenAndFelanmalanPage arendenAndFelanmalanTab() {

		arendenTab.click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

		return new ArendenAndFelanmalanPage();

	}

	public MinBostadPage MinBostadTab() {

		minBostadTab.click();

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

		return new MinBostadPage();

	}

	public BosparPage BosparTab() {

		bosparTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@id='main-gradient']")));

		return new BosparPage();

	}
	
	public MedlemskapetPage MedlemskapetTab() {

		medlemskapTab.click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@id='main-gradient']")));

		return new MedlemskapetPage();

	}

	public SokBostadPage SokBostadTab() {

		sokBostadTab.click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));

		return new SokBostadPage();

	}

	public MinProfilPage MinProfilTab() {

		minProfileTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));

		return new MinProfilPage();

	}

}
