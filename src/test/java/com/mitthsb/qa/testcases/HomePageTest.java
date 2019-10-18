package com.mitthsb.qa.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
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
import com.mitthsb.qa.pages.SokBostadPage;
import com.mitthsb.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
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
	MinaSidorPage MinaSidorPage ;
	SoftAssert softAssert=new SoftAssert();
	
	public HomePageTest() {
		super();
		// to call testbase constructor to execute prop

	}
	
	//testcases should be independent.. ideal is to close the browser afer every case and launched before the test case.
	@BeforeTest
	public void setUp() {

		initialization();
		loginPage = new Loginpage();
		testUtil = new TestUtil();
		homePage=loginPage.login(prop.getProperty("login"),prop.getProperty("pwd"),prop.getProperty("role"));

	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title=homePage.validateHomePageTitle();		
			
		softAssert.assertEquals(title, "&#214;versikt");		
		//softAssert.assertTrue(homePage.validateHomePageTitle(), "&#214;versikt");
		
	}
	
	
	@Test(priority=2)
	public void mittUpdragLinkTest() {
		//if you want to tswitch the frame before checking any link 
		//testUtil.switchToFrame();
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		boolean flag=homePage.validateMittUpdragLink();
		softAssert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void validateMinaSidorlinkTest() {
		boolean flag=homePage.validateMinaSidorLink();
		softAssert.assertTrue(flag);
		
	}
	
	@Test(priority=4)
	public void nyttLinkTest() {
		boolean flag=homePage.validateNyttFranHsb();
		//Assert.assertTrue(false);		
		softAssert.assertTrue(flag);
		
	}
	
	@Test(priority=5)
	public void fakturorDisplayTest() {
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		boolean title=homePage.validateFakturorDisplay();
		softAssert.assertEquals(title, "&#214;versikt");
		
		
	}
	
//	@Test(priority=6)
//	public void hsbNewsTest() {
//		
//		boolean flag=homePage.validateHsbNews();
//		softAssert.assertTrue(flag);
//		
//	}
	
	@Test(priority=7)
	
	public void adminTabTest() {
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		adminPage=homePage.adminTab();
		
		
	}
	
	@Test(priority=8)
	public void fastighetenTabTest() {
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		fastiPage=homePage.fastightenTab();
		
		
	}
	
	@Test(priority=9)
	public void dokumentTabTest() {
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		dokumentPage=homePage.dokumentTab();
		
		
	}
	
	@Test(priority=10)
	public void ekonomiTabTest() {
		if(prop.getProperty("role").equals("Grund"))
			throw new SkipException("Skipping this exception");
		ekonomiPage=homePage.ekonomiTab();
		
		
	}
	
	@Test(priority=11)
	public void clickMinaSidorLinkTest() {
		if(prop.getProperty("role").equals("Grund"))
				Assert.assertTrue(true);
		else
			MinaSidorPage=homePage.minaSidorLink();
			
		
	}
	

	
	//Minasidor methods if login user is only have access to private page
	
//@Test(priority=12)
//	
//	public void brfFacklanPageTest() {
//		if(prop.getProperty("role").equals("Grund"))
//			BrfFacklanPage=homePage.BrfFacklanTab();
//		//System.out.println("insideif");}
//		else
//		{
//			//System.out.println("inside else");
//			MinaSidorPage=homePage.minaSidorLink();
//		MinaSidorPage.BrfFacklanTab();
//		}
//		
//		
//	}

@Test(priority=13)

public void arendenAndFelanmalanPageTest() {
	if(prop.getProperty("role").equals("Grund"))
		ArendenAndFelanmalanPage=homePage.arendenAndFelanmalanTab();
	else {
		MinaSidorPage=homePage.minaSidorLink();
	MinaSidorPage.arendenAndFelanmalanTab();
	}
	
}
	
	@Test(priority=14)
	public void minBostadTabTest() {
		if(prop.getProperty("role").equals("Grund"))
				MinBostadPage=homePage.MinBostadTab();
		else {
			MinaSidorPage=homePage.minaSidorLink();
		MinaSidorPage.MinBostadTab();
	}
		
	}
	
	@Test(priority=15)
	public void bosparTabTest() {
		if(prop.getProperty("role").equals("Grund"))
				BosparPage=homePage.BosparTab();
		else {
			MinaSidorPage=homePage.minaSidorLink();
		MinaSidorPage.BosparTab();
		
	}
	}
	
	@Test(priority=16)
	public void medlemskapetTabTest() {
		if(prop.getProperty("role").equals("Grund"))
					MedlemskapetPage=homePage.MedlemskapetTab();
		else {
			MinaSidorPage=homePage.minaSidorLink();
		MinaSidorPage.MedlemskapetTab();
		
		}
	}
	

	@Test(priority=17)
	public void sokBostadTabTest() {
		if(prop.getProperty("role").equals("Grund"))
					SokBostadPage=homePage.SokBostadTab();
		
		else {
			MinaSidorPage=homePage.minaSidorLink();
		MinaSidorPage.SokBostadTab();
		}
		
	}
	
	@Test(priority=18)
	public void minProfilTabTest() {
		if(prop.getProperty("role").equals("Grund"))
			MinProfilPage=homePage.MinProfilTab();
		
		else {
			MinaSidorPage=homePage.minaSidorLink();
		MinaSidorPage.MinProfilTab();
	}
		
	}

//	@Test(priority=19)
//	public void HomePageBrokenLinksTest()
//	
//	{
//		
//			int Brokencount=TestUtil.BrokenLinks();
//			Assert.assertFalse(Brokencount>0);
//		
//	}
//		

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
