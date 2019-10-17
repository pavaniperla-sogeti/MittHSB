package com.mitthsb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mitthsb.qa.base.TestBase;

public class MinaSidorPage extends TestBase {
	
	//minasidor objects
		@FindBy(linkText = "Brf Facklan")
		WebElement brfFacklanTab;
		
		@FindBy(linkText = "Ärenden & felanmälan")
		WebElement arendenTab;

		@FindBy(linkText = "Min Bostad")
		WebElement minBostadTab;

		@FindBy(linkText = "Bospar")
		WebElement bosparTab;

		@FindBy(linkText = "Medlemskapet")
		WebElement medlemskapTab;

		@FindBy(linkText = "Sök bostad")
		WebElement sokBostadTab;
		
		@FindBy(linkText = "Min profil")
		WebElement minProfileTab;
		
		public MinaSidorPage() {

			// to initialize page factory /object repository objects

			PageFactory.initElements(driver, this);
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

			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

			return new ArendenAndFelanmalanPage();

		}

		public MinBostadPage MinBostadTab() {

			minBostadTab.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

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
