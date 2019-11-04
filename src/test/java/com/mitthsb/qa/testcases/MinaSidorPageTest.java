package com.mitthsb.qa.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.StaleElementReferenceException;
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
	com.mitthsb.qa.pages.BrfFacklanPage ArendenAndFelanmalanPage;
	

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
	
		String title = adminPage.validateAdminPageTitle();
		if (rolePrevilege.equals("x")) {

			softAssert.assertEquals(title, "Översikt - NOT FOR COMMERCIAL USE");
			softAssert.assertAll();
		} else

			softAssert.assertTrue(true);
	}
	
	@Test(groups="Regression")
	public void brfLandingTabTest() {
	
		BrfFacklanPage= MinaSidorPage.validateBrfLandingTab(rolePrevilege);
		

	}
	
	@Test(groups="Regression")
	public void arendenTabTest() {
	
		ArendenAndFelanmalanPage= MinaSidorPage.validateBrfLandingTab(rolePrevilege);
		

	}
	
	@Test(groups="Regression")
	public void minBostadTabTest() {
	
		//boolean flag = MinaSidorPage.validateBrfLandingTab(rolePrevilege);
		

	}
	
	@Test(groups="Regression")
	public void bosparTabTest() {
	
		//boolean flag = MinaSidorPage.validateBrfLandingTab(rolePrevilege);
		

	}
	
	@Test(groups="Regression")
	public void medelemskapTabTest() {
	
		//boolean flag = MinaSidorPage.validateBrfLandingTab(rolePrevilege);
		

	}
	
	@AfterMethod
	public void tearDown() {

		System.out.println("this methiod is ended");
		// driver.close();
		driver.quit();
	}


}
