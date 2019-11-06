package com.mitthsb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;
//import com.mitthsb.qa.testcases.kalenderMinasidor;
import com.mitthsb.qa.util.TestUtil;

public class MinaSidorPage extends TestBase {

	// minasidor objects
	@FindBy(partialLinkText = "HSB brf")
	List<WebElement> brfFacklanTab;

	@FindBy(xpath = "//h5[contains(text(),'Mina händelser')]")
	WebElement brfPageElement;

	@FindBy(xpath = "//a[contains(@class,'mn-btn')][contains(text(),'felanm')]")
	List<WebElement> arendenTab;

	@FindBy(xpath = "//main[@id='main-gradient']")
	WebElement arendenPageElement;

	@FindBy(linkText = "Min Bostad")
	List<WebElement> minBostadTab;

	@FindBy(xpath = "//main[@id='main-gradient']")
	WebElement minBostadPageElement;

	@FindBy(linkText = "Bospar")
	List<WebElement> bosparTab;

	@FindBy(xpath = "//span[contains(text(),'BLI MEDLEM')]")
	WebElement bosparPageElement;

	@FindBy(linkText = "Medlemskapet")
	List<WebElement> medlemskapTab;

	@FindBy(xpath = "//h4[contains(text(),'HSB Medlemskap')]")
	WebElement medlemskapPageElement;

	@FindBy(xpath = "//a[contains(@class,'mn-btn')][contains(text(),'Sök bostad')]")
	List<WebElement> sokBostadTab;

	@FindBy(xpath = "//h1[contains(text(),'Hitta din nya bostad med HSB')]")
	WebElement sokBostadPageElement;

	@FindBy(linkText = "Min profil")
	List<WebElement> minProfileTab;

	@FindBy(xpath = "//h4[contains(text(),'Mina uppgifter')]")
	WebElement minProfilePageElement;

	@FindBy(xpath = "//button[contains(text(),'Skapa kalenderhändelse')]")
	WebElement kalenderElement;

	@FindBy(xpath = "//a[contains(text(),'Gå till kalender')]")
	List<WebElement> goTillKalenderLink;

	@FindBy(xpath = "//div[@class='card event-item']")
	List<WebElement> minaHandelserFrame;
	
	@FindBy(xpath = "//a[@class='link-primary'][contains(text(),'Klar')]")
	WebElement genvagarKlarButton;
	
	@FindBy(xpath = "//a[@class='link-shortcuts'][contains(text(),'Redigera genväg')]")
	WebElement redigeraGenvagar;	

	@FindBy(xpath = "//span[@class='create-shortcuts']")
	WebElement skapaGenevägar;
	
	@FindBy(xpath = "//label[contains(text(),'Mina uppgifter')]")
	WebElement minaUppgifterShortcut;
	
	@FindBy(xpath = "//label[contains(text(),'Kalender')]")
	WebElement kalenderShortcut;
	
	@FindBy(xpath = "//label[contains(text(),'Mina ärenden')]")
	WebElement minaArendenShortcut;

	public MinaSidorPage() {

		// to initialize page factory /object repository objects

		PageFactory.initElements(driver, this);
	}

	public String validateMinaSidorPageTitle() {
		return driver.getTitle();

	}

	public boolean validateBrfLandingTab(String rolePrevilege) {

		int ElementSize = brfFacklanTab.size();
		System.out.println("brfFacklanTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			boolean flag1 = brfFacklanTab.get(0).isDisplayed();
			System.out.println("flag value is" + flag1);
			return true;
		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public BrfFacklanPage clickBrfLandingTab(String rolePrevilege) {

		int ElementSize = brfFacklanTab.size();
		System.out.println("brfFacklanTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			brfFacklanTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(brfPageElement));
			return new BrfFacklanPage();

		}
		if (flag && !futheraction)
			return new BrfFacklanPage();

		else
			return null;

	}

	public boolean validateArendenTab(String rolePrevilege) {

		int ElementSize = arendenTab.size();
		System.out.println("arendenTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			boolean flag1 = arendenTab.get(0).isDisplayed();
			System.out.println("flag value is" + flag1);
			return true;
		}

		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public ArendenAndFelanmalanPage clickArendenTab(String rolePrevilege) {

		int ElementSize = arendenTab.size();
		System.out.println("arendenTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			arendenTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(arendenPageElement));
			return new ArendenAndFelanmalanPage();

		}
		if (flag && !futheraction)
			return new ArendenAndFelanmalanPage();

		else
			return null;

	}

	public boolean validateMinBostadTab(String rolePrevilege) {

		int ElementSize = minBostadTab.size();
		System.out.println("minBostadTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			boolean flag1 = minBostadTab.get(0).isDisplayed();
			System.out.println("flag value is" + flag1);
			return true;
		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public MinBostadPage clickMinBostadTab(String rolePrevilege) {

		int ElementSize = minBostadTab.size();
		System.out.println("minBostadTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			minBostadTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(minBostadPageElement));
			return new MinBostadPage();

		}
		if (flag && !futheraction)
			return new MinBostadPage();

		else
			return null;

	}

	public boolean validateBosparTab(String rolePrevilege) {
		int ElementSize = bosparTab.size();
		System.out.println("bosparTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			boolean flag1 = bosparTab.get(0).isDisplayed();
			System.out.println("flag value is" + flag1);
			return true;
		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public BosparPage clickBosparTab(String rolePrevilege) {

		int ElementSize = bosparTab.size();
		System.out.println("bosparTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			bosparTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(bosparPageElement));
			return new BosparPage();

		}
		if (flag && !futheraction)
			return new BosparPage();

		else
			return null;

	}

	public boolean validateMedlemskapTab(String rolePrevilege) {

		int ElementSize = medlemskapTab.size();
		System.out.println("medlemskapTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			boolean flag1 = medlemskapTab.get(0).isDisplayed();
			System.out.println("flag value is" + flag1);
			return true;
		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public MedlemskapetPage clickMedlemskapTab(String rolePrevilege) {

		int ElementSize = medlemskapTab.size();
		System.out.println("medlemskapTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			medlemskapTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(medlemskapPageElement));
			return new MedlemskapetPage();

		}
		if (flag && !futheraction)
			return new MedlemskapetPage();

		else
			return null;

	}

	public boolean validateSokBostadTab(String rolePrevilege) {

		int ElementSize = sokBostadTab.size();
		System.out.println("sokBostadTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			boolean flag1 = sokBostadTab.get(0).isDisplayed();
			System.out.println("flag value is" + flag1);
			return true;
		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public SokBostadPage clickSokBostadTab(String rolePrevilege) {

		int ElementSize = sokBostadTab.size();
		System.out.println("sokBostadTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			sokBostadTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(sokBostadPageElement));
			return new SokBostadPage();

		}
		if (flag && !futheraction)
			return new SokBostadPage();

		else
			return null;

	}

	public boolean validateMinProfileTab(String rolePrevilege) {

		int ElementSize = minProfileTab.size();
		System.out.println("minProfileTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			boolean flag1 = minProfileTab.get(0).isDisplayed();
			System.out.println("flag value is" + flag1);
			return true;
		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public MinProfilPage clickMinProfileTab(String rolePrevilege) {

		int ElementSize = minProfileTab.size();
		System.out.println("minProfileTab element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			minProfileTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(minProfilePageElement));
			return new MinProfilPage();

		}
		if (flag && !futheraction)
			return new MinProfilPage();

		else
			return null;

	}

	public boolean goTillKalenderMinaSidorPageTest(String rolePrevilege) {

		int ElementSize = goTillKalenderLink.size();
		System.out.println("goTillKalender element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			goTillKalenderLink.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(kalenderElement));
			Boolean flag1 = AdministrationPage.createKalenderHäandelseAdminProfeesionalPage(rolePrevilege);
			return flag1;

		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}
	
	
	public boolean deleteKalenderMinaSidorPageTest(String rolePrevilege) {

		int ElementSize = goTillKalenderLink.size();
		System.out.println("goTillKalender element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction) {
			goTillKalenderLink.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(kalenderElement));
			Boolean flag1 = AdministrationPage.deleteKalenderHäandelse(rolePrevilege);
			return flag1;

		}
		if (flag && !futheraction)
			return true;

		else
			return false;

	}

	public boolean minaHandelserFrameDisplay(String rolePrevilege) {

		int ElementSize = minaHandelserFrame.size();
		System.out.println("minaHandelserFrame element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction)
			return minaHandelserFrame.get(0).isDisplayed();
		if (flag && !futheraction)
			return true;

		else
			return false;

	}
	
	
	public boolean validateGenvägar(String rolePrevilege) {

		boolean flag = false;
		int j = 1;
		while (j == 1) {
			List<WebElement> dropdown1 = driver.findElements(By.xpath("//a[@id='linkName-a']"));
			if (dropdown1.size() == 0) {
					skapaGenevägar.click();
					TestUtil.pause(2000);
					minaUppgifterShortcut.click();
					TestUtil.pause(2000);
					genvagarKlarButton.click();
					TestUtil.pause(2000);				
			}
			List<WebElement> dropdown = driver.findElements(By.xpath("//a[@id='linkName-a']"));
			for (int i = 0; i < dropdown.size(); i++) {
				String drop_down_values = dropdown.get(i).getText();
				System.out.println("shortcutvalue is" + dropdown.get(i));
				if (drop_down_values.equals("Mina uppgifter")) {					
					dropdown.get(i).click();
					wait.until(ExpectedConditions.visibilityOf(minProfilePageElement));
					flag = true;
					System.out.println("shortcut is present and redirected to page correctly so breaking the for loop");
					break;
				}
			}
			if (flag) {
				j = 0;
				System.out.println("shortcut is working correctly so breaking the outer whileloop ");
				break;
			}
			

			else {
				System.out.println("shortcut is not present, so adding it ");
				redigeraGenvagar.click();
				TestUtil.pause(2000);
				minaUppgifterShortcut.click();
				TestUtil.pause(2000);
				genvagarKlarButton.click();

			}
			}

				
		return flag;
	}
	
	//for editing shortcuts
	public boolean validateRedigeraGenvägar(String rolePrevilege) {

		Boolean flag_before = false;
		Boolean flag_after = false;
		List<WebElement> dropdown = driver.findElements(By.xpath("//a[@id='linkName-a']"));
		if (dropdown.size() == 0) {
		
				skapaGenevägar.click();
				TestUtil.pause(2000);
				minaUppgifterShortcut.click();
				TestUtil.pause(2000);
				kalenderShortcut.click();
				TestUtil.pause(2000);
				minaArendenShortcut.click();
				TestUtil.pause(2000);
				genvagarKlarButton.click();
				TestUtil.pause(2000);
			
		}
		for (int i = 0; i < dropdown.size(); i++) {
			String drop_down_values = dropdown.get(i).getText();
			if (drop_down_values.equals("Kalender")) {
				System.out.println("shortcut is present " + drop_down_values);
				flag_before = true;
			}
		}

	
			redigeraGenvagar.click();
			TestUtil.pause(2000);
			kalenderShortcut.click();
			TestUtil.pause(2000);
			genvagarKlarButton.click();
			TestUtil.pause(2000);
		
		// refresh page and see whether shortcuts are properly added or deleted.

		driver.navigate().refresh();
		TestUtil.pause(8000);
		//wait.until(ExpectedConditions.visibilityOf(grundLadingElement));
		List<WebElement> dropdownLatest = driver.findElements(By.xpath("//a[@id='linkName-a']"));
		for (int j = 0; j < dropdownLatest.size(); j++) {
			String drop_down_latest_values = dropdownLatest.get(j).getText();
			if (drop_down_latest_values.equals("Kalender")) {
				System.out.println("shortcut is present " + drop_down_latest_values);
				flag_after = true;
			}
		}
		if (flag_before == flag_after)
			return false;
		else
			return true;
	}

}
