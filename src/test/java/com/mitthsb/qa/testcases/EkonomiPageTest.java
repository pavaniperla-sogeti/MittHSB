package com.mitthsb.qa.testcases;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.pages.AdministrationPage;
import com.mitthsb.qa.pages.AllaFakturorListItemPage;
import com.mitthsb.qa.pages.DokumentPage;
import com.mitthsb.qa.pages.EkonomiPage;
import com.mitthsb.qa.pages.FastighetenPage;
import com.mitthsb.qa.pages.FinansiellaRapporterPage;
import com.mitthsb.qa.pages.HomePage;
import com.mitthsb.qa.pages.Loginpage;
import com.mitthsb.qa.pages.SaldoRapportPage;
import com.mitthsb.qa.util.TestUtil;

public class EkonomiPageTest extends TestBase {
	
	Loginpage loginPage;
	HomePage homePage;
	AdministrationPage adminPage;
	FastighetenPage fastiPage;
	DokumentPage dokumentPage;
	EkonomiPage ekonomiPage;
	TestUtil testUtil;
	AllaFakturorListItemPage AllaFakturorListItemPage;
	SaldoRapportPage SaldoRapportPage;
	FinansiellaRapporterPage FinansiellaRapporterPage;
	SoftAssert softAssert=new SoftAssert();
	
	public EkonomiPageTest() {
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
		ekonomiPage=homePage.ekonomiTab();

	}
	
	@Test(priority=1)
	public void ekonomiPageTitleTest() {
		String title=ekonomiPage.validateEkonomiPageTitle();
		softAssert.assertEquals(title, "Ekonomisk &#246;versikt");
		
		//softAssert.assertTrue(homePage.validateHomePageTitle(), "&#214;versikt");
		
	}
	
	@Test(priority=2)
	public void validateAllaFakturorListItemTest() {
		boolean flag=ekonomiPage.validateAllaFakturorListItem();
		softAssert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void validateFinansiellaRapportListItemTest() {
		boolean flag=ekonomiPage.validatefinansiellaRapportListItem();
		softAssert.assertTrue(flag);
		
	}
	
	@Test(priority=4)
	public void validatesaldoRapportTest() {
		boolean title=ekonomiPage.validatesaldoRapport();
		softAssert.assertEquals(title, "&#214;versikt");
		
	}
	
	
	
	@Test(priority=5)
	public void  saldoRapportLinkTest() {
		SaldoRapportPage=ekonomiPage.clicksaldoRapport();
		
		
	}
	
	@Test(priority=6)
	public void  finansiellaRapporterTest() {
		FinansiellaRapporterPage=ekonomiPage.clickfinansiellaRapportListItem();
		
		
	}
	
	@Test(priority=7)
	public void  allaFakturorListItemTest() {
		AllaFakturorListItemPage=ekonomiPage.clickAllaFakturorListItem();
		
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
