package com.mitthsb.qa.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.pages.AdministrationPage;
import com.mitthsb.qa.pages.HomePage;
import com.mitthsb.qa.pages.Loginpage;
import com.mitthsb.qa.util.TestUtil;

public class AdministrationPageTest extends TestBase {
	Loginpage loginPage;
	HomePage homePage;
	AdministrationPage adminPage;
	TestUtil testUtil;
	SoftAssert softAssert=new SoftAssert();
	String rolePrevilege;
	
	public AdministrationPageTest() {
		super();
// to call testbase constructor to execute prop

}
	
	
	@BeforeMethod
	public void setUp(Method method) throws StaleElementReferenceException {
		
		System.out.println("before intialization");

		initialization();
		System.out.println("class is"+this.getClass().getName()+"and method is"+method.getName());
		String role=prop.getProperty("role");
		rolePrevilege=TestUtil.retrieveRole(method.getName(),role);
		System.out.println("roel is" + rolePrevilege);
		loginPage = new Loginpage();
		testUtil = new TestUtil();
		homePage=loginPage.login(prop.getProperty("login"),prop.getProperty("pwd"),prop.getProperty("role"));
		

	}
	
	@Test
	public void adminPageTitleTest() {
		
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		String title=adminPage.validateAdminPageTitle();
				softAssert.assertEquals(title, "Styrelsekalender");				
		
	}
	
	
	
	@Test
	public void skapaKalenderTest() {
		adminPage=homePage.adminTab();
		
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		Boolean flag=adminPage.createKalenderHäandelseAdminProfeesionalPage();
				softAssert.assertTrue(flag);				
		
	}
	
	@Test(dependsOnMethods={"skapaKalenderTest"})
	public void displayKalenderEventHomePageTest() {
		
				Boolean flag=homePage.displayKalenderHäandelse(rolePrevilege);
				softAssert.assertTrue(flag);				
		
	}
	
	@Test(dependsOnMethods={"skapaKalenderTest","displayKalenderEventHomePageTest"})
	public void deleteKalenderTest() {
		
		adminPage=homePage.adminTab();
		
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		Boolean flag=adminPage.deleteKalenderHäandelse();
				softAssert.assertTrue(flag);				
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		System.out.println("this methiod is ended");
		//driver.close();
		driver.quit();
	}
	
	
	
}
