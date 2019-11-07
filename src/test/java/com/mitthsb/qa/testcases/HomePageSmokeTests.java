package com.mitthsb.qa.testcases;
import java.lang.reflect.Method;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.pages.AdministrationPage;
import com.mitthsb.qa.pages.ArendenAndFelanmalanPage;
import com.mitthsb.qa.pages.BosparPage;
import com.mitthsb.qa.pages.BrfFacklanPage;
import com.mitthsb.qa.pages.DokumentPage;
import com.mitthsb.qa.pages.EkonomiPage;
import com.mitthsb.qa.pages.FastighetenPage;
import com.mitthsb.qa.pages.HomePage;
import com.mitthsb.qa.pages.Loginpage;
import com.mitthsb.qa.pages.MedlemskapetPage;
import com.mitthsb.qa.pages.MinBostadPage;
import com.mitthsb.qa.pages.MinProfilPage;
import com.mitthsb.qa.pages.MinaSidorPage;
import com.mitthsb.qa.pages.NyttFranHSBPage;
import com.mitthsb.qa.pages.SokBostadPage;
import com.mitthsb.qa.util.TestUtil;

public class HomePageSmokeTests extends TestBase{
	
	Loginpage loginPage;
	HomePage homePage;
	AdministrationPage adminPage;
	FastighetenPage fastiPage;
	DokumentPage dokumentPage;
	EkonomiPage ekonomiPage;
	TestUtil testUtil;
	BrfFacklanPage BrfFacklanPage;
	MinBostadPage MinBostadPage;
	BosparPage BosparPage;
	MedlemskapetPage MedlemskapetPage;
	SokBostadPage SokBostadPage;
	MinProfilPage MinProfilPage;
	ArendenAndFelanmalanPage ArendenAndFelanmalanPage;
	MinaSidorPage MinaSidorPage;
	NyttFranHSBPage NyttFranHSBPage;
	SoftAssert softAssert;
	String rolePrevilege;

	public HomePageSmokeTests() {
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

		System.out.println("class is" + this.getClass().getName() + "and method is" + method.getName());
		String role=prop.getProperty("role");
		rolePrevilege=TestUtil.retrieveRole(method.getName(),role);
		System.out.println("roel is" + rolePrevilege);		

	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify the title of MittUpdrag Page is Översikt - NOT FOR COMMERCIAL USE")
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		softAssert.assertEquals(title, "Översikt - NOT FOR COMMERCIAL USE");
		softAssert.assertAll();
		

	}

	@Test(groups = { "Regression", "smokeTest" },description="Verify whether HSB logo is present in the top center of the page")
	public void hsbLogoTest() {

		boolean flag = homePage.validateHSBLogoHomePage();
		softAssert.assertTrue(flag);
		softAssert.assertAll();

		
	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify that Brf Listbox  is displayed")
	public void brfDisplayTest() {

		boolean flag = homePage.validateBrfDisplay();
		softAssert.assertTrue(flag);
		softAssert.assertAll();

		

	}

	@Test(groups = { "Regression", "smokeTest" },description="Verify that MittUppdrag link is displayed")
	public void mittUpdragLinkTest() {		
		boolean flag = homePage.validateMittUpdragLink(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test(groups = { "Regression", "smokeTest" },description="Verify that MinaSidor link in top menu is displayed")
	public void minaSidorlinkTest() {
		boolean flag = homePage.validateMinaSidorLink(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test(groups = { "Regression", "smokeTest" },description="Verify that NyttLinkfranHSB link is displayed")
	public void nyttLinkTest() {
		boolean flag = homePage.validateNyttFranHsb();
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify whether Ekonomi tab in professional page is redirecting to the right page",dependsOnMethods={"homePageTitleTest", "hsbLogoTest"})
	public void ekonomiTabTest() {
		
		ekonomiPage = homePage.ekonomiTab(rolePrevilege);

	}

	@Test(groups = { "Regression", "smokeTest" },description="Verify whether Admin tab in professional page is redirecting to the right page",dependsOnMethods={"homePageTitleTest", "hsbLogoTest"})
	public void adminTabTest() {
		
			adminPage = homePage.adminTab(rolePrevilege);

	}

	@Test(groups = { "Regression", "smokeTest" },description="Verify whether Fastigheten tab in professional page is redirecting to the right page",dependsOnMethods={"homePageTitleTest", "hsbLogoTest"})
	public void fastighetenTabTest() {
		
		fastiPage = homePage.fastightenTab(rolePrevilege);

	}

	@Test(groups = { "Regression", "smokeTest" },description="Verify whether Dokument tab in professional page is redirecting to the right page",dependsOnMethods={"homePageTitleTest", "hsbLogoTest"})
	public void dokumentTabTest() {
	
		dokumentPage = homePage.dokumentTab(rolePrevilege);

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		System.out.println("this methiod is ended");
		// driver.close();
		driver.quit();
	}

}
