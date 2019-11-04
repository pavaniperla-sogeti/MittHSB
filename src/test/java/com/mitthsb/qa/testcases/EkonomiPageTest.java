//author pavani
package com.mitthsb.qa.testcases;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
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
	String rolePrevilege;
	
	public EkonomiPageTest() {
		super();
		// to call testbase constructor to execute prop

	}
	
	//testcases should be independent.. ideal is to close the browser afer every case and launched before the test case.
	@BeforeMethod
	public void setUp(Method method) throws StaleElementReferenceException {

		initialization();
		System.out.println("class is"+this.getClass().getName()+"and method is"+method.getName());
		String role=prop.getProperty("role");
		rolePrevilege=TestUtil.retrieveRole(method.getName(),role);
		System.out.println("roel is" + rolePrevilege);
		loginPage = new Loginpage();
		testUtil = new TestUtil();
		homePage=loginPage.login(prop.getProperty("login"),prop.getProperty("pwd"),prop.getProperty("role"));
		ekonomiPage=homePage.ekonomiTab();

	}
	
	@Test
	public void ekonomiPageTitleTest() {
		String title=ekonomiPage.validateEkonomiPageTitle();
		softAssert.assertEquals(title, "Ekonomisk översikt - NOT FOR COMMERCIAL USE");
		softAssert.assertAll();
		
		//softAssert.assertTrue(homePage.validateHomePageTitle(), "&#214;versikt");
		
	}
	
	@Test
	public void validateAllaFakturorListItemTest() {
		boolean flag=ekonomiPage.validateAllaFakturorListItem(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test
	public void validateFinansiellaRapportListItemTest() {
		boolean flag=ekonomiPage.validatefinansiellaRapportListItem(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@Test//to see whether shortcut is displayed or not
	public void validatesaldoRapportTest() {
		boolean flag=ekonomiPage.validatesaldoRapport(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@Test//to see whether shortcut is properly redirecting to iframe or not
	public void clicksaldoRapportGenvagarTest() {
		boolean flag=ekonomiPage.clickGenvagar(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@Test//to see digitalwebfaktura button in allFakturor list item is properly redirecting to external webpage
	public void clickDigitalWebFakturaButtonTest() {
		String childTitle=ekonomiPage.validateDigitalWebFakturaButtonAllaFakturorListItem(rolePrevilege);
		softAssert.assertEquals(childTitle, "Basware Login Failed");
		softAssert.assertAll();
	}
	
	
	@Test
	public void likvidaMedelGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validatesaldoRapport(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test
	public void disponibelGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validateDisponibeltGraph(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test
	public void cashFlowGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validateCashFlowGraph(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test
	public void accountsReceivablesGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validateAccountsReceivableGraph(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test
	public void reportGenvagarDisplayTest() {
		boolean flag=ekonomiPage.validateRapportGenvagar(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	
	
	@Test
	public void  saldoRapportLinkTest() {
		SaldoRapportPage=ekonomiPage.clicksaldoRapport();
		
		
	}
	
	@Test
	public void  finansiellaRapporterTest() {
		FinansiellaRapporterPage=ekonomiPage.clickfinansiellaRapportListItem();
		
		
	}
	
	@Test
	public void  allaFakturorListItemTest() {
		AllaFakturorListItemPage=ekonomiPage.clickAllaFakturorListItem();
		
		
	}
	

	@Test
	public void  InformationIconLikvidaMedelGraphTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconLikvidaMedelGraph(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	@Test
	public void  InformationIconRapportGenvagarFrameTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconRapportGenvagarFrame(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	@Test
	public void  InformationIconDisponiBeltGraphTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconDisponiBeltGraph(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	@Test
	public void  InformationIconCashFlowGraphTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconCashFlowGraph(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
