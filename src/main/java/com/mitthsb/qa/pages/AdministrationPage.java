package com.mitthsb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.util.TestUtil;

public class AdministrationPage extends TestBase{
	
	@FindBy(xpath = "//button[@class='btn-primary'][contains(text(),'Skapa kalender')]")
	WebElement skapaKalenderButton;
	
	@FindBy(xpath = "//input[@id='resident']")
	WebElement calenderBoendeCheckbox;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement calenderTitle;
	
	@FindBy(xpath = "//input[@id='start-date']")
	WebElement CalenderStartDate;
	
	@FindBy(xpath = "//select[@id='start-time']//option[contains(text(),'01:00')]")
	WebElement CalenderStartTime;
	
	@FindBy(xpath = "//input[@id='end-date']")
	WebElement CalenderEndDate;	
	
	@FindBy(xpath = "//select[@id='end-time']//option[contains(text(),'02:00')]")
	WebElement CalenderEndTime;
		
	@FindBy(xpath = "//input[@id='place']")
	WebElement CalenderPlace;	
	
	@FindBy(xpath = "//button[@class='btn btn-primary large'][contains(text(),'Skapa kal')]")
	WebElement skapaKalenderButtonInsideModal;
	
	@FindBy(xpath = "//p[contains(text(),'Automat')]")
	WebElement calenderCreationCheck;

	@FindBy(xpath = "//a[@class='link-secondary delete-calendar-item']")
	WebElement deleteCalenderButton;
	
	@FindBy(xpath = "//span[@class='btn btn-primary large'][contains(text(),'Ja, radera')]")
	WebElement deleteCalenderRaderaButton;
	
	public AdministrationPage() {

		// to initialize page factory /object repository objects
		System.out.println("homepage constructor");

		PageFactory.initElements(driver, this);
	}
	
	public String validateAdminPageTitle() {
		return driver.getTitle();

	}
	
	public boolean validateMittUpdragLink() {
		return skapaKalenderButton.isDisplayed();
	}
	
	public boolean createKalenderHäandelseAdminProfeesionalPage() {
		
		try {
			skapaKalenderButton.click();
			driver.switchTo().activeElement();
			Thread.sleep(1000);
			String day=TestUtil.getTomorrowDate();
			calenderTitle.sendKeys("Automation");
			Thread.sleep(1000);
			CalenderStartDate.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@class='is-other-month']")).click();
			Thread.sleep(1000);
			CalenderStartTime.click();
			Thread.sleep(1000);
			CalenderEndDate.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@class='is-other-month']")).click();
			Thread.sleep(1000);
			CalenderEndTime.click();
			Thread.sleep(1000);
			CalenderPlace.sendKeys("WorkPlace");
			Thread.sleep(1000);
			skapaKalenderButtonInsideModal.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return calenderCreationCheck.isDisplayed();
	}
	
public boolean deleteKalenderHäandelse() {
	
	deleteCalenderButton.click();
	deleteCalenderRaderaButton.click();	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return calenderCreationCheck.isDisplayed();
	}
	
	
	
	
	

}
