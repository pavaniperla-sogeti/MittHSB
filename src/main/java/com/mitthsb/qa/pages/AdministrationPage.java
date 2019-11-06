package com.mitthsb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.util.TestUtil;

public class AdministrationPage extends TestBase{
	
	@FindBy(xpath = "//button[@class='btn-primary'][contains(text(),'Skapa kalender')]")
	static
	List<WebElement> skapaKalenderButton;
	
	@FindBy(xpath = "//input[@id='resident']")
	WebElement calenderBoendeCheckbox;
	
	@FindBy(xpath = "//input[@id='title']")
	static
	WebElement calenderTitle;
	
	@FindBy(xpath = "//input[@id='resident']")
	static
	WebElement calenderBoende;
	
	@FindBy(xpath = "//input[@id='start-date']")
	static
	WebElement CalenderStartDate;
	
	@FindBy(xpath = "//select[@id='start-time']//option[contains(text(),'01:00')]")
	static
	WebElement CalenderStartTime;
	
	@FindBy(xpath = "//input[@id='end-date']")
	static
	WebElement CalenderEndDate;	
	
	@FindBy(xpath = "//select[@id='end-time']//option[contains(text(),'02:00')]")
	static
	WebElement CalenderEndTime;
		
	@FindBy(xpath = "//input[@id='place']")
	static
	WebElement CalenderPlace;	
	
	@FindBy(xpath = "//button[@class='btn btn-primary large'][contains(text(),'Skapa kal')]")
	static
	WebElement skapaKalenderButtonInsideModal;
	
	@FindBy(xpath = "//p[contains(text(),'Automat')]")
	static
	List<WebElement> calenderCreationCheck;

	@FindBy(xpath = "//a[@class='link-secondary delete-calendar-item']")
	static
	List<WebElement> deleteCalenderButton;
	
	@FindBy(xpath = "//span[@class='btn btn-primary large'][contains(text(),'Ja, radera')]")
	static
	WebElement deleteCalenderRaderaButton;
	
	public AdministrationPage() {

		// to initialize page factory /object repository objects
		System.out.println("homepage constructor");

		PageFactory.initElements(driver, this);
	}
	
	public String validateAdminPageTitle() {		
		
		return driver.getTitle();

	}
	
	public boolean validateSkapaKalenderButton(String rolePrevilege) {

		int ElementSize = skapaKalenderButton.size();
		System.out.println("allaFakturorListItem element size is" + ElementSize);
		boolean flag = TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if (futheraction)
			return skapaKalenderButton.get(0).isDisplayed();

		if (flag && !futheraction)
			return true;

		else
			return false;

	}
	
	public  static  boolean createKalenderHäandelseAdminProfeesionalPage(String rolePrevilege) {
		
		PageFactory.initElements(driver, AdministrationPage.class);
		System.out.println("entered into function");
		int ElementSize = skapaKalenderButton.size();
		System.out.println("allaFakturorListItem element size is"+ElementSize);
		boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
		if(futheraction) {	
		
			skapaKalenderButton.get(0).click();
			driver.switchTo().activeElement();
			TestUtil.pause(5000);
			calenderBoende.click();
			TestUtil.pause(1000);
			String day=TestUtil.getTomorrowDate();
			calenderTitle.sendKeys("Automation");
			TestUtil.pause(1000);
			CalenderStartDate.click();
			TestUtil.pause(1000);
			driver.findElement(By.xpath("//span[@class='is-other-month']")).click();
			TestUtil.pause(1000);
			CalenderStartTime.click();
			TestUtil.pause(1000);
			CalenderEndDate.click();
			TestUtil.pause(1000);
			driver.findElement(By.xpath("//span[@class='is-other-month']")).click();
			TestUtil.pause(1000);
			CalenderEndTime.click();
			TestUtil.pause(1000);
			CalenderPlace.sendKeys("WorkPlace");
			TestUtil.pause(1000);
			skapaKalenderButtonInsideModal.click();
						
		
		return calenderCreationCheck.get(0).isDisplayed();
		}
		if(flag && !futheraction)
			return true;
		
		else
			return false;
		
	}
	
public static boolean deleteKalenderHäandelse(String rolePrevilege) {
	
	PageFactory.initElements(driver, AdministrationPage.class);
	
	int calenderSizeBefore= calenderCreationCheck.size();
	
	int ElementSize = deleteCalenderButton.size();
	System.out.println("deleteCalenderButton element size is"+ElementSize);
	boolean flag=TestUtil.getRoleResult(rolePrevilege, ElementSize);
	if(futheraction) {	
	
	deleteCalenderButton.get(0).click();
	TestUtil.pause(2000);	
	deleteCalenderRaderaButton.click();	
	
		TestUtil.pause(2000);		
		int calenderSizeAfterDelte= calenderCreationCheck.size();
		if(calenderSizeBefore>calenderSizeAfterDelte)
		return true;
		else
			return false;
		
	}
	
	if(flag && !futheraction)
		return true;
	
	else
		return false;
	
	}
	
	
	
	
	

}
