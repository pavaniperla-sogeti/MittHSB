package com.mitthsb.qa.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
	SoftAssert softAssert;
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
		role = prop.getProperty("role");
		rolePrevilege = TestUtil.retrieveRole(method.getName(), role);
		System.out.println("roel is" + rolePrevilege);
		MinaSidorPage=homePage.minaSidorLink();
		TestUtil.pause(2000);

	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify the title of Minasidor Page as Översikt - NOT FOR COMMERCIAL USE")
	public void minaSidorTitleTest() {
	
		String title = MinaSidorPage.validateMinaSidorPageTitle();
		if (rolePrevilege.equals("x")) {

			softAssert.assertEquals(title, "Översikt - NOT FOR COMMERCIAL USE");
			softAssert.assertAll();
		} else

			softAssert.assertTrue(true);
	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify whether Brf landing page is visible based on the role previlege")
	public void brfLandingTabDisplayTest() {

		boolean flag = MinaSidorPage.validateBrfLandingTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		

	}
	
	@Test(groups = "Regression",description="Verify whether Brf landing Tab is redirecting to the rifht page based on the role previlege")
	public void clickbrfLandingTabTest() {
		
		BrfFacklanPage = MinaSidorPage.clickBrfLandingTab(rolePrevilege);			

	}

	@Test(groups =  { "Regression", "smokeTest" },description="Verify whether ArendenTab is visible based on the role previlege")
	public void arendenTabDisplayTest() {

		boolean flag = MinaSidorPage.validateArendenTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}
	
	@Test(groups = "Regression",description="Verify whether Arenden Tab is redirecting to the rifht page based on the role previlege")
	public void clickArendenTabTest() {
		
		ArendenAndFelanmalanPage = MinaSidorPage.clickArendenTab(rolePrevilege);			

	}
	
	

	@Test(groups =  { "Regression", "smokeTest" },description="Verify whether MinBostad Tab is visible based on the role previlege")
	public void minBostadTabDisplayTest() {

		boolean flag = MinaSidorPage.validateMinBostadTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression",description="Verify whether MinBostad Tab is redirecting to the rifht page based on the role previlege")
	public void clickMinBostadTabTest() {
		
		MinBostadPage = MinaSidorPage.clickMinBostadTab(rolePrevilege);			

	}

	@Test(groups =  { "Regression", "smokeTest" },description="Verify whether Bospar Tab is visible based on the role previlege")
	public void bosparTabDisplayTest() {

		boolean flag = MinaSidorPage.validateBosparTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression",description="Verify whether Bospar Tab is redirecting to the rifht page based on the role previlege")
	public void clickBosparTabTest() {
		
		BosparPage = MinaSidorPage.clickBosparTab(rolePrevilege);			

	}

	@Test(groups =  { "Regression", "smokeTest" },description="Verify whether Medlemskap Tab is visible based on the role previlege")
	public void medelemskapTabDisplayTest() {

		boolean flag = MinaSidorPage.validateMedlemskapTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression",description="Verify whether MedlemSkap Tab is redirecting to the rifht page based on the role previlege")
	public void clickMedlemskapTabTest() {
		
		MedlemskapetPage = MinaSidorPage.clickMedlemskapTab(rolePrevilege);			

	}
	
	@Test(groups =  { "Regression", "smokeTest" },description="Verify whether SokBostad tab is visible based on the role previlege")
	public void sokBostadTabDisplayTest() {

		boolean flag = MinaSidorPage.validateSokBostadTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression",description="Verify whether Sok Bostad Tab is redirecting to the rifht page based on the role previlege")
	public void clickSokBostadTabTest() {
		
		SokBostadPage = MinaSidorPage.clickSokBostadTab(rolePrevilege);			

	}
	
	@Test(groups =  { "Regression", "smokeTest" },description="Verify whether Minprofile tab is visible based on the role previlege")
	public void minProfileTabDisplayTest() {

		boolean flag = MinaSidorPage.validateMinProfileTab(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();


	}
	
	@Test(groups = "Regression",description="Verify whether MinProfile Tab is redirecting to the rifht page based on the role previlege")
	public void clickMinProfileTabTest() {
		
		MinProfilPage = MinaSidorPage.clickMinProfileTab(rolePrevilege);			

	}
	
	@Test(groups="Regression",description="Verify whether seAllaNyheter link in Minasidor page is redirecting to the nyttfranHSB page based on the role previlege")
	public void seAllaNyheterLinkTestMinaSidorPage() {
		NyttFranHSBPage = homePage.validateSeAllaNyheter(rolePrevilege);
		softAssert.assertAll();

	}	
	
	@Test(groups="Regression",description="Verify whether a news article is redirecting to the nyttfranHSB page based on the role previlege")
	public void nyheterArticleTest() {
		NyttFranHSBPage = homePage.validateNyheterArticle(rolePrevilege);

	}
	
	@Test(groups="Regression",description="Verify whether news articles frame is displayed in Minasidor Page")
	public void priorityNewsFrameTest() {
		boolean flag = homePage.validateHsbNews(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}
	
	@Test(groups="Regression",description="verify whether go till kalender is properly redirecting to kalender page and verify the functionality of skapa kalender button")
	public void goTillKalenderAndCreateKalenderEvent() {
		boolean flag = MinaSidorPage.goTillKalenderMinaSidorPageTest(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}
	
	
	@Test(groups="Regression",dependsOnMethods="goTillKalenderAndCreateKalenderEvent",description="verify whether go till kalender is properly redirecting to kalender page and verify the functionality of skapa kalender button")
	public void deleteKalenderHandelseMinaSidorPage() {
		Boolean flag1 = MinaSidorPage.deleteKalenderMinaSidorPageTest(rolePrevilege);;
		softAssert.assertTrue(flag1);
		softAssert.assertAll();

	}
	
	
	
	
	@Test(groups="Regression",description="verify whether Mina Handelser frame is displayed or not")
	public void minaHandelseFrameDisplayTest() {
		boolean flag = MinaSidorPage.minaHandelserFrameDisplay(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}
	
	@Test (groups="Regression",description="Verify whether adding one of the Genvagar in private page is redirecting to correct page based on the role")// for validating ekonomi shortcut
	// to validate whether clicking on ekonomi shortcutlink is taking to the
	// respective page or not
	public void minaUppgifterGenvagarLinkTest() {
	
		boolean flag = MinaSidorPage.validateGenvägar(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}
	
	@Test (groups="Regression",description="Verify whether Genvagar can be added or modified correctly")// for testing shortcuts functionalities to add or delete
	public void genvagarLinkMinaSidorTest() {
			boolean flag = MinaSidorPage.validateRedigeraGenvägar(rolePrevilege);
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
