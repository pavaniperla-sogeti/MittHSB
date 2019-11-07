package com.mitthsb.qa.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
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

public class HomePageTest extends TestBase {

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

	public HomePageTest() {
		super();
		// to call testbase constructor to execute prop

	}

	// testcases should be independent.. ideal is to close the browser afer every
	// case and launched before the test case.
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
		
		TestUtil.pause(4000);
		System.out.println("class is" + this.getClass().getName() + "and method is" + method.getName());
		String role=prop.getProperty("role");
		rolePrevilege=TestUtil.retrieveRole(method.getName(),role);
		System.out.println("roel is" + rolePrevilege);	
		homePage=homePage.clickMittUppdragLink(rolePrevilege);
		TestUtil.pause(4000);

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
	


	@Test(groups="Regression",description="verify the link StallInDinLista is displayed based on the role")
	public void stallIDinListaLinkDisplayTest() {

		boolean flag = homePage.validateStallInDinLista(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

			}

	@Test(groups="Regression",description="Verify that information Icon of Likvida Medel Graph is showing rihgt content")
	public void informationIconLikvidaMedelGraphTest() {

		boolean flag = homePage.validateInformationIcon(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

		

	}

	@Test(groups="Regression",description="Verify that link StallIndinLista function is properly working")
	public void stallIDinListaFunctionTest() {

		boolean flag = homePage.stallInDinListaLinkTest(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

		

	}

	

	@Test(groups="Regression",description="Verify that Fakturor list is displayed")
	public void fakturorDisplayTest() {
	
		boolean flag = homePage.validateFakturorDisplay(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test(groups="Regression",description="Verify that Go till Kalender link is displayed and redirecting to admin page for creation ")
	public void goTillKalenderLinkTest() {
	
		adminPage = homePage.goTillKalender(rolePrevilege);
		softAssert.assertAll();

	}

	@Test(groups="Regression",description="Verify that seAllaNyheterLink is redirecting to the correct page")
	public void seAllaNyheterLinkTest() {
		NyttFranHSBPage = homePage.validateSeAllaNyheter(rolePrevilege);
		softAssert.assertAll();

	}

	@Test(groups="Regression",description="verify whether clicking on any News article in professional page is redirecting to nyttfranHSB page")
	public void nyheterArticleTest() {
		NyttFranHSBPage = homePage.validateNyheterArticle(rolePrevilege);

	}
	
	@Test(groups="Regression",description="verify whether News frame in professional page is displayed")
	public void priorityNewsFrameTest() {
		boolean flag = homePage.validateHsbNews(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}


	@Test (groups="Regression",description="Verify whether Genvagar can be added or modified correctly")// for testing shortcuts functionalities to add or delete
	public void genvagarLinkTest() {
			boolean flag = homePage.validateRedigeraGenvägar(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test (groups="Regression",description="Verify whether adding one of the Genvagar in professional page is redirecting to correct page based on the role")// for validating ekonomi shortcut
	// to validate whether clicking on ekonomi shortcutlink is taking to the
	// respective page or not
	public void EkonomiGenvagarLinkTest() {
	
		boolean flag = homePage.validateGenvägar(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test (groups="Regression",description="Verify whether EkonomiOversikt graph in professional page is displayed based on the role")// for validating ekonomi oversiktGraph
	public void ekonomiOversiktGraphTest() {
				boolean flag = homePage.validateEkonomicOversiktGraph(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test (groups="Regression",description="Verify whether Senaste7Handelser fram  in professional page is displayed based on the role")// for validating senaste 7handelser frame display
	public void senatste7HandelserFrameTest() {
		boolean flag = homePage.validateSenate7HandelserFrame(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

	@Test(groups="Regression",description="Verify whether SenasteAldreHandelser fram  in professional page is displayed based on the role") // for validating senaste Aldre handelser frame display
	public void senatsteAldreHandelserFrameTest() {
		boolean flag = homePage.validateSenateAldreHandelserFrame(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();

	}

//	@Test(priority=6)
//	public void hsbNewsTest() {
//		
//		boolean flag=homePage.validateHsbNews();
//		softAssert.assertTrue(flag);
//		
//	}



//	@Test(priority=11)
//	public void clickMinaSidorLinkTest() {
//		if(prop.getProperty("role").equals("Grund"))
//				Assert.assertTrue(true);
//		else
//			MinaSidorPage=homePage.minaSidorLink();
//			
//		
//	}
//	
//
//
//
//@Test(priority=13)
//
//public void arendenAndFelanmalanPageTest() {
//	if(prop.getProperty("role").equals("Grund"))
//		ArendenAndFelanmalanPage=homePage.arendenAndFelanmalanTab();
//	else {
//		MinaSidorPage=homePage.minaSidorLink();
//	MinaSidorPage.arendenAndFelanmalanTab();
//	}
//	
//}
//	
//	@Test(priority=14)
//	public void minBostadTabTest() {
//		if(prop.getProperty("role").equals("Grund"))
//				MinBostadPage=homePage.MinBostadTab();
//		else {
//			MinaSidorPage=homePage.minaSidorLink();
//		MinaSidorPage.MinBostadTab();
//	}
//		
//	}
//	
//	@Test(priority=15)
//	public void bosparTabTest() {
//		if(prop.getProperty("role").equals("Grund"))
//				BosparPage=homePage.BosparTab();
//		else {
//			MinaSidorPage=homePage.minaSidorLink();
//		MinaSidorPage.BosparTab();
//		
//	}
//	}
//	
//	@Test(priority=16)
//	public void medlemskapetTabTest() {
//		if(prop.getProperty("role").equals("Grund"))
//					MedlemskapetPage=homePage.MedlemskapetTab();
//		else {
//			MinaSidorPage=homePage.minaSidorLink();
//		MinaSidorPage.MedlemskapetTab();
//		
//		}
//	}
//	
//
//	@Test(priority=17)
//	public void sokBostadTabTest() {
//		if(prop.getProperty("role").equals("Grund"))
//					SokBostadPage=homePage.SokBostadTab();
//		
//		else {
//			MinaSidorPage=homePage.minaSidorLink();
//		MinaSidorPage.SokBostadTab();
//		}
//		
//	}
//	
//	@Test(priority=18)
//	public void minProfilTabTest() {
//		if(prop.getProperty("role").equals("Grund"))
//			MinProfilPage=homePage.MinProfilTab();
//		
//		else {
//			MinaSidorPage=homePage.minaSidorLink();
//		MinaSidorPage.MinProfilTab();
//	}
//		
//	}
//
////	@Test(priority=19)
////	public void HomePageBrokenLinksTest()
////	
////	{
////		
////			int Brokencount=TestUtil.BrokenLinks();
////			Assert.assertFalse(Brokencount>0);
////		
////	}
////		

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		System.out.println("this methiod is ended");
		// driver.close();
		driver.quit();
	}

}
