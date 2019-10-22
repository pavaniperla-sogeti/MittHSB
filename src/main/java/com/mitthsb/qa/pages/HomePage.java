//if you wnat to switch the frame before checking the xpath.

package com.mitthsb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='visible']//div[@id='graph1']")
	WebElement ekonomiskOversiktGraph;
	
	@FindBy(xpath = "//div[@class='visible']//div[@class='card-body']//p[contains(text(),'7 dagarna')]")
	WebElement senaste7Handelser;
	
	@FindBy(xpath = "//div[@class='visible']//div[@class='card-body']//p[contains(text(),'�ldre h�ndelser')]")
	WebElement senasteAldreHandelser;
	
	@FindBy(xpath = "//a[contains(text(),'Se alla nyheter')]")
	WebElement seAllaNyheter;
	
	@FindBy(xpath = "//body//latest-news//li[1]")
	WebElement NyheterArticle;
	
	@FindBy(xpath = "//div[@class='menu-item menu-item--logo']//img")
	WebElement hsbLogo;
	
	@FindBy(xpath = "//a[@class='link-secondary white preferences'][contains(text(),'in din lista')]")
	WebElement stallDinListaLink;		
	
	@FindBy(xpath = "//div[@class='view-selector-component--desktop']//button[@class='view-selector-trigger'][contains(text(),'brf')]")
	WebElement brf;
	
	@FindBy(xpath = "//a[@class='link-shortcuts'][contains(text(),'Redigera genv�g')]")
	WebElement redigeraGenvagar;
	
	@FindBy(xpath = "//label[contains(text(),'Ekonomisk �versikt')]")
	WebElement ekonomiShortcut;
	
	@FindBy(xpath = "//a[@class='link-primary'][contains(text(),'Klar')]")
	WebElement genvagarKlarButton;

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
	
	@FindBy(xpath = "//div[@class='view-selector-component--desktop']//a[@class='link-secondary'][contains(text(),'Logga ut')]")
	WebElement logoutBtn;
	
	@FindBy(linkText = "Logga ut")
	WebElement vivalya_MinaSidor;
	
	@FindBy(linkText = "Logga ut")
	WebElement vivalya_NyttfranHsb;
	
	@FindBy(xpath = "//div[@class='view-selector-component--desktop']//button[@class='view-selector-trigger']")
	WebElement vivalyaren;
	
	@FindBy(xpath = "//a[contains(text(),'G� till kalender')]")
	WebElement goTillKalender;	
	
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

	@FindBy(xpath = "//button[@class='btn-primary'][contains(text(),'Skapa kalenderh�ndelse')]")
	WebElement sokBostadTab;
	
	@FindBy(linkText = "Min profil")
	WebElement minProfileTab;



	public HomePage() {

		// to initialize page factory /object repository objects
		System.out.println("homepage constructor");

		PageFactory.initElements(driver, this);
	}
	
	public boolean validateHSBLogoHomePage() {
		return hsbLogo.isDisplayed();
	}

	public String validateHomePageTitle() {
		return driver.getTitle();

	}

	public boolean validateMittUpdragLink() {
		return mittUppdragLink.isDisplayed();
	}
	
	public boolean validateBrfDisplay() {
		return brf.isDisplayed();	
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
	
	public boolean validateStallInDinLista() {
		return hsbNews.isDisplayed();
	}
	
	public boolean validateEkonomicOversiktGraph() {
		return ekonomiskOversiktGraph.isDisplayed();
	}
	
	public boolean validateSenate7HandelserFrame() {
		return senaste7Handelser.isDisplayed();
	}
	
	public boolean validateSenateAldreHandelserFrame() {
		return senasteAldreHandelser.isDisplayed();
	}

	
	
	public boolean validateGenv�gar() {
	
		boolean flag = false;
		int j = 1;
		while (j == 1) {
			List<WebElement> dropdown = driver.findElements(By.xpath("//a[@id='linkName-a']"));
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText();
				if (drop_down_values.equals("Ekonomisk �versikt")) {
					dropdown.get(i).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//h4[@class='bold-uppercase'][contains(text(),'Ekonomisk �versikt')]")));
					System.out.println("shortcut is present ");
					flag = true;
				}
			}
			if (flag) {
				j = 0;
				System.out.println("shortcut is present, so breaking the loop ");
				break;
			}

			else {
				System.out.println("shortcut is not present, so adding it ");
				redigeraGenvagar.click();
				ekonomiShortcut.click();
				genvagarKlarButton.click();

			}

		}
		return flag;
	}
	
	public boolean validateRedigeraGenv�gar()  {

		Boolean flag_before = false;
		Boolean flag_after = false;
		List<WebElement> dropdown = driver.findElements(By.xpath("//a[@id='linkName-a']"));
		for (int i = 0; i < dropdown.size(); i++) {
			String drop_down_values = dropdown.get(i).getText();
			if (drop_down_values.equals("Ekonomisk �versikt")) {
				System.out.println("shortcut is present " + drop_down_values);
				flag_before = true;
			}
		}

		try {
			redigeraGenvagar.click();
			Thread.sleep(2000);
			ekonomiShortcut.click();
			Thread.sleep(2000);
			genvagarKlarButton.click();
			Thread.sleep(2000);
				} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//refresh page and see whether shortcuts are properly added or deleted.

		driver.navigate().refresh();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("in din lista")));
		List<WebElement> dropdownLatest = driver.findElements(By.xpath("//a[@id='linkName-a']"));
		for (int j = 0; j < dropdownLatest.size(); j++) {
			String drop_down_latest_values = dropdownLatest.get(j).getText();
			if (drop_down_latest_values.equals("Ekonomisk �versikt")) {
				System.out.println("shortcut is present " + drop_down_latest_values);
				flag_after = true;
			}
		}
		if (flag_before == flag_after)
			return false;
		else			
		return true;
	}
	
	
	public NyttFranHSBPage validateSeAllaNyheter() {
		
		seAllaNyheter.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'NYTT FR�N HSB')]")));
		
		return new NyttFranHSBPage();
	}
	
	public NyttFranHSBPage validateNyheterArticle() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", NyheterArticle);
		
		NyheterArticle.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/nytt-fran-hsb/' and @class='link-dark']")));
		
		return new NyttFranHSBPage();
	}
	
	public AdministrationPage goTillKalender() {

		goTillKalender.click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-primary']")));

		return new AdministrationPage();

	}


	public EkonomiPage ekonomiTab() {
		

		ekonomiTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='bold-uppercase'][contains(text(),'Ekonomisk �versikt')]")));

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
	
	public logoutPage logout() {
		
		vivalyaren.click();
		
		logoutBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='login_title']")));
		
		return new logoutPage();
		
		
	}

}
