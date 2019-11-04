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
	
	//minasidor objects
		@FindBy(partialLinkText = "Hsb Brf")
		List<WebElement> brfFacklanTab;
		
		@FindBy(xpath = "//h5[contains(text(),'Mina händelser')]")
		WebElement brfPageElement;
		
		@FindBy(xpath = "//a[contains(@class,'mn-btn')][contains(text(),'felanm')]")
		List<WebElement> arendenTab;

		@FindBy(linkText = "Min Bostad")
		List<WebElement> minBostadTab;

		@FindBy(linkText = "Bospar")
		List<WebElement> bosparTab;

		@FindBy(linkText = "Medlemskapet")
		List<WebElement> medlemskapTab;
		
		@FindBy(xpath = "//a[contains(text(),'Mina sidor')]")
		WebElement minaSidorLink;

		@FindBy(xpath = "//a[contains(@class,'mn-btn')][contains(text(),'Sök bostad')]")
		List<WebElement> sokBostadTab;
		
		@FindBy(linkText = "Min profil")
		List<WebElement> minProfileTab;
		
		public MinaSidorPage() {

			// to initialize page factory /object repository objects

			PageFactory.initElements(driver, this);
		}
		
		public boolean validateBrfLandingTab(String rolePrevilege) {
			
			int ElementSize = brfFacklanTab.size();
			System.out.println("brfFacklanTab element size is" + ElementSize);
			boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
			if (futheraction)
				return brfFacklanTab.get(0).isDisplayed();

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
			
			return null;
			
		}

		public boolean validateArendenTab(String rolePrevilege) {
			
			int ElementSize = arendenTab.size();
			System.out.println("arendenTab element size is" + ElementSize);
			boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
			if (futheraction)
				return arendenTab.get(0).isDisplayed();

			if (flag && !futheraction)
				return true;

			else
				return false;
			
		}

		public boolean validateMinBostadTab(String rolePrevilege) {
			
			int ElementSize = minBostadTab.size();
			System.out.println("minBostadTab element size is" + ElementSize);
			boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
			if (futheraction)
				return minBostadTab.get(0).isDisplayed();

			if (flag && !futheraction)
				return true;

			else
				return false;
			
		}

		public boolean validateBosparTab(String rolePrevilege) {
			int ElementSize = bosparTab.size();
			System.out.println("bosparTab element size is" + ElementSize);
			boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
			if (futheraction)
				return bosparTab.get(0).isDisplayed();

			if (flag && !futheraction)
				return true;

			else
				return false;
			
			
		}

		public boolean validateMedlemskapTab(String rolePrevilege) {
			
			int ElementSize = medlemskapTab.size();
			System.out.println("medlemskapTab element size is" + ElementSize);
			boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
			if (futheraction)
				return medlemskapTab.get(0).isDisplayed();

			if (flag && !futheraction)
				return true;

			else
				return false;
			
		}
		
		public boolean validateSokBostadTab(String rolePrevilege) {
			
			int ElementSize = sokBostadTab.size();
			System.out.println("sokBostadTab element size is" + ElementSize);
			boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
			if (futheraction)
				return sokBostadTab.get(0).isDisplayed();

			if (flag && !futheraction)
				return true;

			else
				return false;
			
		
		}

		public boolean validateMinProfileTab(String rolePrevilege) {
			
			int ElementSize = minProfileTab.size();
			System.out.println("minProfileTab element size is" + ElementSize);
			boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
			if (futheraction)
				return minProfileTab.get(0).isDisplayed();

			if (flag && !futheraction)
				return true;

			else
				return false;
			
		}

		public BrfFacklanPage BrfFacklanTab() {
			

			brfFacklanTab.get(0).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='content no-max-width gradient-bg col-12']")));

			return new BrfFacklanPage();
			}


		public ArendenAndFelanmalanPage arendenAndFelanmalanTab() {

			arendenTab.get(0).click();

			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

			return new ArendenAndFelanmalanPage();

		}

		public MinBostadPage MinBostadTab() {

			minBostadTab.get(0).click();

			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iFrameResizer0']")));

			return new MinBostadPage();

		}

		public BosparPage BosparTab() {

			bosparTab.get(0).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@id='main-gradient']")));

			return new BosparPage();

		}
		
		public MedlemskapetPage MedlemskapetTab() {

			medlemskapTab.get(0).click();

			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@id='main-gradient']")));

			return new MedlemskapetPage();

		}

		public SokBostadPage SokBostadTab() {

			sokBostadTab.get(0).click();

			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));

			return new SokBostadPage();

		}

		public MinProfilPage MinProfilTab() {

			minProfileTab.get(0).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-gradient\"]")));

			return new MinProfilPage();

		}

}
