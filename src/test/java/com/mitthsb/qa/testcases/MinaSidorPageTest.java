package com.mitthsb.qa.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.pages.AdministrationPage;
import com.mitthsb.qa.pages.ArendenAndFelanmalanPage;
import com.mitthsb.qa.pages.BosparPage;
import com.mitthsb.qa.pages.BrfFacklanPage;
import com.mitthsb.qa.pages.HomePage;
import com.mitthsb.qa.pages.Loginpage;
import com.mitthsb.qa.pages.MedlemskapetPage;
import com.mitthsb.qa.pages.MinBostadPage;
import com.mitthsb.qa.pages.MinProfilPage;
import com.mitthsb.qa.pages.MinaSidorPage;
import com.mitthsb.qa.pages.NyttFranHSBPage;
import com.mitthsb.qa.pages.SokBostadPage;
import com.mitthsb.qa.util.TestUtil;

public class MinaSidorPageTest extends TestBase {
	Loginpage loginPage;
	HomePage homePage;
	AdministrationPage adminPage;
	MinaSidorPage MinaSidorPage;
	TestUtil testUtil;
	SoftAssert softAssert = new SoftAssert();
	String rolePrevilege;
	String role;
	BrfFacklanPage BrfFacklanPage;
	MinBostadPage MinBostadPage;
	BosparPage BosparPage;
	MedlemskapetPage MedlemskapetPage;
	SokBostadPage SokBostadPage;
	MinProfilPage MinProfilPage;
	ArendenAndFelanmalanPage ArendenAndFelanmalanPage;
	NyttFranHSBPage NyttFranHSBPage;
	

	public MinaSidorPageTest() {
		super();
// to call testbase constructor to execute prop

	} 
	
	@BeforeMethod
	public void setUp(Method method) throws StaleElementReferenceException {

		System.out.println("before intialization");

		initialization();
		System.out.println("class is" + this.getClass().getName() + "and method is" + method.getName());
		role = prop.getProperty("role");
		rolePrevilege = TestUtil.retrieveRole(method.getName(), role);
		System.out.println("roel is" + rolePrevilege);
		loginPage = new Loginpage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("login"), prop.getProperty("pwd"), prop.getProperty("role"));
		MinaSidorPage=homePage.minaSidorLink();

	}
	
	@Test
	public void minaSidorTitleTest() {
	
		String title = MinaSidorPage.validateMinaSidorPageTitle();
		if (rolePrevilege.equals("x")) {

			softAssert.assertEquals(title, "Översikt - NOT FOR COMMERCIAL USE");
			softAssert.assertAll();
		} else

			softAssert.assertTrue(true);
	}
	
	@Test(groups = "Regression")
	public void brfLandingTabDisplayTest() {

		boolean flag = MinaSidorPage.validateBrfLandingTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		

	}
	
	@Test(groups = "Regression")
	public void clickbrfLandingTabTest() {
		
		BrfFacklanPage = MinaSidorPage.clickBrfLandingTab(rolePrevilege);			

	}

	@Test(groups = "Regression")
	public void arendenTabDisplayTest() {

		boolean flag = MinaSidorPage.validateArendenTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}
	
	@Test(groups = "Regression")
	public void clickArendenTabTest() {
		
		ArendenAndFelanmalanPage = MinaSidorPage.clickArendenTab(rolePrevilege);			

	}
	
	

	@Test(groups = "Regression")
	public void minBostadTabDisplayTest() {

		boolean flag = MinaSidorPage.validateMinBostadTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression")
	public void clickMinBostadTabTest() {
		
		MinBostadPage = MinaSidorPage.clickMinBostadTab(rolePrevilege);			

	}

	@Test(groups = "Regression")
	public void bosparTabDisplayTest() {

		boolean flag = MinaSidorPage.validateBosparTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression")
	public void clickBosparTabTest() {
		
		BosparPage = MinaSidorPage.clickBosparTab(rolePrevilege);			

	}

	@Test(groups = "Regression")
	public void medelemskapTabDisplayTest() {

		boolean flag = MinaSidorPage.validateMedlemskapTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression")
	public void clickMedlemskapTabTest() {
		
		MedlemskapetPage = MinaSidorPage.clickMedlemskapTab(rolePrevilege);			

	}
	
	@Test(groups = "Regression")
	public void sokBostadTabDisplayTest() {

		boolean flag = MinaSidorPage.validateSokBostadTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression")
	public void clickSokBostadTabTest() {
		
		SokBostadPage = MinaSidorPage.clickSokBostadTab(rolePrevilege);			

	}
	
	@Test(groups = "Regression")
	public void minProfileTabDisplayTest() {

		boolean flag = MinaSidorPage.validateMinProfileTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression")
	public void clickMinProfileTabTest() {
		
		MinProfilPage = MinaSidorPage.clickMinProfileTab(rolePrevilege);			

	}
	
//	@Test(groups="Regression")
//	public void seAllaNyheterLinkTest() {
//		NyttFranHSBPage = homePage.validateSeAllaNyheter();
//		softAssert.assertAll();
//
//	}	
//	
//	@Test(groups="Regression")
//	public void nyheterArticleTest() {
//		NyttFranHSBPage = homePage.validateNyheterArticle();
//
//	}
//	
//	@Test(groups="Regression")
//	public void priorityNewsFrameTest() {
//		boolean flag = homePage.validateHsbNews(rolePrevilege);
//		softAssert.assertTrue(flag);
//		softAssert.assertAll();
//
//	}
//	
//	public kalenderMinasidor goTillKalenderMinaSidorPageTest() {
//
//		goTillKalender.click();
//
//		wait.until(ExpectedConditions.visibilityOf(adminPageElement));
//
//		return new AdministrationPage();
//
//	}

	@AfterMethod
	public void tearDown() {

		System.out.println("this methiod is ended");
		// driver.close();
		driver.quit();
	}


}
