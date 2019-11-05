package com.mitthsb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;
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

	@FindBy(xpath = "///h4[contains(text(),'Mina uppgifter')]")
	WebElement minProfilePageElement;

	

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

	public BrfFacklanPage clickBrfLandingTab(String role) {

		if (role.equals("x")) {
			brfFacklanTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(brfPageElement));
			return new BrfFacklanPage();

		}
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

		int ElementSize = minBostadTab.size();
		System.out.println("minBostadTab element size is" + ElementSize);
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
			minBostadTab.get(0).click();
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
			minBostadTab.get(0).click();
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
			minBostadTab.get(0).click();
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
			minBostadTab.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(minProfilePageElement));
			return new MinProfilPage();

		}
		if (flag && !futheraction)
			return new MinProfilPage();

		else
			return null;


	}

}
