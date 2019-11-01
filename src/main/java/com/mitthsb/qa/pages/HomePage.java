package com.mitthsb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='visible']//div[@id='graph1']")
	List<WebElement> ekonomiskOversiktGraph;
	
	@FindBy(xpath = "//h4[@class='bold-uppercase'][contains(text(),'Ekonomisk översikt')]")
	WebElement ekonomiPageElement;


	@FindBy(xpath = "//span[@class='encircled text-center border border-primary rounded-circle'][contains(text(),'i')]")
	List<WebElement>  informationIconLikvidaMedel;

	@FindBy(xpath = "//div[@class='popover-body'][contains(text(),'Diagrammet')]")
	WebElement informationIconLikvidaMedelIconText;

	@FindBy(xpath = "//span[@class='create-shortcuts']")
	WebElement skapaGenevägar;

	@FindBy(xpath = "//div[@class='visible']//div[@class='card-body']//p[contains(text(),'7 dagarna')]")
	List<WebElement>  senaste7Handelser;

	@FindBy(xpath = "//div[@class='visible']//div[@class='card-body']//p[contains(text(),'äldre händelser')]")
	List<WebElement>  senasteAldreHandelser;

	@FindBy(xpath = "//a[contains(text(),'Se alla nyheter')]")
	WebElement seAllaNyheter;

	@FindBy(xpath = "//body//latest-news//li[1]")
	WebElement NyheterArticle;

	@FindBy(xpath = "//div[@class='menu-item menu-item--logo']//img")
	WebElement hsbLogo;

	@FindBy(xpath = "//a[@class='link-secondary white preferences'][contains(text(),'in din lista')]")
	List<WebElement>  stallDinListaLink;

	@FindBy(xpath = "//button[@class='btn btn-primary large'][contains(text(),'Spara')]")
	WebElement stallDinListaLinkSparaButton;

	@FindBy(xpath = "//input[@id='Överlåtelser']")
	WebElement stallDinListaLinkOverlatelseCheckbox;

	@FindBy(xpath = "//div[@class='view-selector-component--desktop']//div[@class='view-selector-trigger-container view-selector-trigger-container--desktop']")
	WebElement brf;
	//// div[@class='view-selector-component--desktop']//descendant::button[@class='view-selector-trigger'][contains(text(),'Brf')]
	@FindBy(xpath = "//a[@class='link-shortcuts'][contains(text(),'Redigera genväg')]")
	WebElement redigeraGenvagar;

	@FindBy(xpath = "//label[contains(text(),'Ekonomisk översikt')]")
	WebElement ekonomiShortcut;

	@FindBy(xpath = "//label[contains(text(),'Alla Fakturor (WebbFaktura)')]")
	WebElement allaFakturorShortcut;

	@FindBy(xpath = "//label[contains(text(),'Placeringar')]")
	WebElement placeringarShortcut;

	@FindBy(xpath = "//a[@class='link-primary'][contains(text(),'Klar')]")
	WebElement genvagarKlarButton;

	@FindBy(xpath = "//div[contains(@class, 'priority-news')]")
	List<WebElement>  hsbNews;

	@FindBy(xpath = "//a[contains(text(),'Mitt uppdrag')]")
	List<WebElement> mittUppdragLink;

	@FindBy(xpath = "//a[contains(text(),'Mina sidor')]")
	List<WebElement>  minaSidorLink;

	@FindBy(linkText = "Nytt från HSB")
	WebElement nyttFranHsb;

	@FindBy(xpath = "//a[contains(text(),'in din lista')]")
	List<WebElement> todoFakturorList;

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

	@FindBy(xpath = "//a[contains(text(),'Gå till kalender')]")
	WebElement goTillKalender;

	@FindBy(xpath = "//div[@class='calendar-item-wrapper']//descendant::p[@class='bold'][contains(text(),'Automat')]")
	List<WebElement> calenderEventCheck;

	// minasidor objects
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

	@FindBy(xpath = "//button[@class='btn-primary'][contains(text(),'Skapa kalenderhändelse')]")
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

	public boolean validateMittUpdragLink(String rolePrevilege){
		
		int ElementSize = mittUppdragLink.size();
		System.out.println("mkttupdrag size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;
		
	}

	public boolean validateBrfDisplay() {
		return brf.isDisplayed();
	}

	public boolean validateMinaSidorLink(String rolePrevilege) {
		
		int ElementSize = minaSidorLink.size();
		System.out.println("minasidor size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;
		
	}

	public boolean validateNyttFranHsb() {
		return nyttFranHsb.isDisplayed();
	}

	public boolean validateFakturorDisplay(String rolePrevilege) {

		int ElementSize = todoFakturorList.size();
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;

	}

	public boolean validateHsbNews(String rolePrevilege) {
		
		int ElementSize = hsbNews.size();
		System.out.println("hsbNews element size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;
		
	}

	public boolean validateStallInDinLista(String rolePrevilege) {	
		
		int ElementSize = stallDinListaLink.size();
		System.out.println("stallDinListaLink element size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;
	
	}

	public boolean validateInformationIcon(String rolePrevilege) {

		int ElementSize = informationIconLikvidaMedel.size();
		System.out.println("informationIconLikvidaMedel element size is"+ElementSize);
		boolean flag=false;
		 flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if(ElementSize>0) {
			System.out.println("clicking on i button");
		informationIconLikvidaMedel.get(0).click();
		return informationIconLikvidaMedelIconText.isDisplayed();
		}
		return flag;
	}

	public boolean stallInDinListaLinkTest() {

	
			stallDinListaLink.get(0).click();
			driver.switchTo().activeElement();
			TestUtil.pause(2000);
			stallDinListaLinkOverlatelseCheckbox.click();
			TestUtil.pause(2000);
			stallDinListaLinkSparaButton.click();
			stallDinListaLink.get(0).isDisplayed();

		

		return true;
	}

	public boolean validateEkonomicOversiktGraph(String rolePrevilege) {
		
		int ElementSize = ekonomiskOversiktGraph.size();
		System.out.println("ekonomiskOversiktGraph element size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;
		
	}

	public boolean validateSenate7HandelserFrame(String rolePrevilege) {
		
		int ElementSize = senaste7Handelser.size();
		System.out.println("senaste7Handelser element size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;
		
	}

	public boolean validateSenateAldreHandelserFrame(String rolePrevilege) {
		
		int ElementSize = senasteAldreHandelser.size();
		System.out.println("senaste7Handelser element size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;
		
	}

	// to validate whether clicking on shortlink is taking to the respective page or
	// not
	public boolean validateGenvägar(String rolePrevilege) {

		boolean flag = false;
		int j = 1;
		while (j == 1) {
			List<WebElement> dropdown1 = driver.findElements(By.xpath("//a[@id='linkName-a']"));
			if (dropdown1.size() == 0) {
					skapaGenevägar.click();
					TestUtil.pause(2000);
					ekonomiShortcut.click();
					TestUtil.pause(2000);
					genvagarKlarButton.click();
					TestUtil.pause(2000);				
			}
			List<WebElement> dropdown = driver.findElements(By.xpath("//a[@id='linkName-a']"));
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText();
				System.out.println("shortcutvalue is" + dropdown.get(i));
				if (drop_down_values.equals("Ekonomisk översikt")) {					
					dropdown.get(i).click();
					wait.until(ExpectedConditions.visibilityOf(ekonomiPageElement));
					flag = true;
					System.out.println("shortcut is present so breaking the for loop");
					break;
				}
			}
			if (flag) {
				j = 0;
				System.out.println("shortcut is present, so breaking the outer whileloop ");
				break;
			}
			

			else {
				System.out.println("shortcut is not present, so adding it ");
				redigeraGenvagar.click();
				TestUtil.pause(2000);
				ekonomiShortcut.click();
				TestUtil.pause(2000);
				genvagarKlarButton.click();

			}
			}

				
		return flag;
	}

	// this function is to see whether we can edit shortcuts
	public boolean validateRedigeraGenvägar(String rolePrevilege) {

		Boolean flag_before = false;
		Boolean flag_after = false;
		List<WebElement> dropdown = driver.findElements(By.xpath("//a[@id='linkName-a']"));
		if (dropdown.size() == 0) {
		
				skapaGenevägar.click();
				TestUtil.pause(2000);
				ekonomiShortcut.click();
				TestUtil.pause(2000);
				allaFakturorShortcut.click();
				TestUtil.pause(2000);;
				placeringarShortcut.click();
				TestUtil.pause(2000);
				genvagarKlarButton.click();
				TestUtil.pause(2000);
			
		}
		for (int i = 0; i < dropdown.size(); i++) {
			String drop_down_values = dropdown.get(i).getText();
			if (drop_down_values.equals("Ekonomisk översikt")) {
				System.out.println("shortcut is present " + drop_down_values);
				flag_before = true;
			}
		}

	
			redigeraGenvagar.click();
			TestUtil.pause(2000);
			ekonomiShortcut.click();
			TestUtil.pause(2000);
			genvagarKlarButton.click();
			TestUtil.pause(2000);
		
		// refresh page and see whether shortcuts are properly added or deleted.

		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("in din lista")));
		List<WebElement> dropdownLatest = driver.findElements(By.xpath("//a[@id='linkName-a']"));
		for (int j = 0; j < dropdownLatest.size(); j++) {
			String drop_down_latest_values = dropdownLatest.get(j).getText();
			if (drop_down_latest_values.equals("Ekonomisk översikt")) {
				System.out.println("shortcut is present " + drop_down_latest_values);
				flag_after = true;
			}
		}
		if (flag_before == flag_after)
			return false;
		else
			return true;
	}

	public boolean displayKalenderHäandelse(String rolePrevilege) {
		
		int ElementSize = calenderEventCheck.size();
		System.out.println("calenderEventCheck element size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		return flag;

			}

	public NyttFranHSBPage validateSeAllaNyheter() {

		seAllaNyheter.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'NYTT FRÅN HSB')]")));

		return new NyttFranHSBPage();
	}

	public NyttFranHSBPage validateNyheterArticle() {

		js.executeScript("arguments[0].scrollIntoView(true);", NyheterArticle);

		NyheterArticle.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@href='/nytt-fran-hsb/' and @class='link-dark']")));

		return new NyttFranHSBPage();
	}

	public AdministrationPage goTillKalender() {

		goTillKalender.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-primary']")));

		return new AdministrationPage();

	}

	public EkonomiPage ekonomiTab() {

		ekonomiTab.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h4[@class='bold-uppercase'][contains(text(),'Ekonomisk översikt')]")));

		return new EkonomiPage();
	}

	public AdministrationPage adminTab() {

		adminTab.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"content-first\"]/div[2]/div/button")));

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

		minaSidorLink.get(0).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='content no-max-width gradient-bg col-12']")));

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

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='content no-max-width gradient-bg col-12']")));

		return new BrfFacklanPage();
	}

	public ArendenAndFelanmalanPage arendenAndFelanmalanTab() {

		arendenTab.click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

		return new ArendenAndFelanmalanPage();

	}

	public MinBostadPage MinBostadTab() {

		minBostadTab.click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

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
