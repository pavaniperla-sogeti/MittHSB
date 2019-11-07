package com.mitthsb.qa.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
	SoftAssert softAssert;
	String rolePrevilege;

	public AdministrationPageTest() {
		super();
// to call testbase constructor to execute prop

	}
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws StaleElementReferenceException {

		System.out.println("before intialization");
		initialization();				
		loginPage = new Loginpage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("login"), prop.getProperty("pwd"), prop.getProperty("role"));
		softAssert = new SoftAssert();

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws StaleElementReferenceException {
		
		TestUtil.pause(2000);
		System.out.println("class is" + this.getClass().getName() + "and method is" + method.getName());
		String role = prop.getProperty("role");
		rolePrevilege = TestUtil.retrieveRole(method.getName(), role);
		System.out.println("role is" + rolePrevilege);
		TestUtil.pause(2000);

	}

	@Test(groups="Regression",description="Verify the title of Admin page is Styrelsekalender - NOT FOR COMMERCIAL USE")
	public void adminPageTitleTest() {
		
		adminPage = homePage.adminTab(rolePrevilege);
		String title = adminPage.validateAdminPageTitle();
		if (rolePrevilege.equals("x")) {

			softAssert.assertEquals(title, "Styrelsekalender - NOT FOR COMMERCIAL USE");
			softAssert.assertAll();
		} else

			softAssert.assertTrue(true);
	}

	@Test(groups="Regression",description="Verify whether SkapaKalender button functionality is proper or not based on the role")
	public void skapaKalenderTest() {
		adminPage = homePage.adminTab(rolePrevilege);

		Boolean flag = adminPage.createKalenderHäandelseAdminProfeesionalPage(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test(groups="Regression",dependsOnMethods = { "skapaKalenderTest" },description="verify whether created kalender event is getting displayed in Home page")
	public void displayKalenderEventHomePageTest() {
		
		homePage=homePage.clickMittUppdragLink(rolePrevilege);
		Boolean flag = homePage.displayKalenderHäandelse(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test(groups="Regression",dependsOnMethods = { "skapaKalenderTest", "displayKalenderEventHomePageTest" },description="verify that delete kalender functionality is working and removing the calender event")
	public void deleteKalenderTest() {

		adminPage = homePage.adminTab(rolePrevilege);

		Boolean flag = adminPage.deleteKalenderHäandelse(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		System.out.println("this methiod is ended");
		// driver.close();
		driver.quit();
	}

}
