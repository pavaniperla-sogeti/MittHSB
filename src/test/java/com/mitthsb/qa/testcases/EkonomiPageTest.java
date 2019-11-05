//author pavani
package com.mitthsb.qa.testcases;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
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
	public void setUp(Method method) throws StaleElementReferenceException, TimeoutException, NoSuchElementException {

		initialization();
		System.out.println("class is"+this.getClass().getName()+"and method is"+method.getName());
		String role=prop.getProperty("role");
		rolePrevilege=TestUtil.retrieveRole(method.getName(),role);
		System.out.println("roel is" + rolePrevilege);
		loginPage = new Loginpage();
		testUtil = new TestUtil();
		homePage=loginPage.login(prop.getProperty("login"),prop.getProperty("pwd"),prop.getProperty("role"));
		ekonomiPage=homePage.ekonomiTab(rolePrevilege);

	}
	
	@Test(description="Verify the title of ekonomiPage as Ekonomisk översikt - NOT FOR COMMERCIAL USE")
	public void ekonomiPageTitleTest() {
		String title=ekonomiPage.validateEkonomiPageTitle();
		System.out.println("title is"+title);
		softAssert.assertEquals(title, "Ekonomisk översikt - NOT FOR COMMERCIAL USE");
		softAssert.assertAll();
		
		//softAssert.assertTrue(homePage.validateHomePageTitle(), "&#214;versikt");
		
	}
	
	@Test(description="Verify the list item AllFaktuor is displayed or not")
	public void validateAllaFakturorListItemTest() {
		boolean flag=ekonomiPage.validateAllaFakturorListItem(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test(description="Verify the list item Finansiella Rappport is displayed or not")
	public void validateFinansiellaRapportListItemTest() {
		boolean flag=ekonomiPage.validatefinansiellaRapportListItem(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@Test(description="Verify that saldo Rapport Genvagar is displayed or not")//to see whether shortcut is displayed or not
	public void validatesaldoRapportTest() {
		boolean flag=ekonomiPage.validatesaldoRapport(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@Test(description="Verify that Saldo Genvagar link is redirecting ot the right page")//to see whether shortcut is properly redirecting to iframe or not
	public void clicksaldoRapportGenvagarTest() {
		boolean flag=ekonomiPage.clickGenvagar(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@Test(description="Verify that DigitalWebFakturor button is redirecting to the right page")//to see digitalwebfaktura button in allFakturor list item is properly redirecting to external webpage
	public void clickDigitalWebFakturaButtonTest() {
		String childTitle=ekonomiPage.validateDigitalWebFakturaButtonAllaFakturorListItem(rolePrevilege);
		System.out.println("childtitle is "+childTitle);
		softAssert.assertEquals(childTitle, "Basware Login Failed");
		softAssert.assertAll();
	}
	
	
	@Test(description="Verify that likvida Medel graph is displayed or not")
	public void likvidaMedelGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validatesaldoRapport(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test(description="Verify that Disponible graph is displayed or not")
	public void disponibelGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validateDisponibeltGraph(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test(description="Verify that CashFlow graph is displayed or not")
	public void cashFlowGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validateCashFlowGraph(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test(description="Verify that Ekonomi graph is displayed or not")
	public void accountsReceivablesGraphEkonomiPageTest() {
		boolean flag=ekonomiPage.validateAccountsReceivableGraph(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test(description="Verify the display of 5 genvagars in ekonomi page")
	public void reportGenvagarDisplayTest() {
		boolean flag=ekonomiPage.validateRapportGenvagar(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	
	
	@Test(description="Verify whether click on any Genvagar is redirecting to the right rapport page")
	public void  saldoRapportLinkTest() {
		SaldoRapportPage=ekonomiPage.clicksaldoRapport();
		
		
	}
	
	@Test(description="Verify the list item FinansiellaRapport is redirecting to proper page or not")
	public void  finansiellaRapporterTest() {
		FinansiellaRapporterPage=ekonomiPage.clickfinansiellaRapportListItem();
		
		
	}
	
	@Test(description="Verify the list item AllaFakturor is redirecting to proper page or not")
	public void  allaFakturorListItemTest() {
		AllaFakturorListItemPage=ekonomiPage.clickAllaFakturorListItem();
		
		
	}
	

	@Test(description="Verify the information icon on LikvidaMedel graph is showing the right informatio ")
	public void  InformationIconLikvidaMedelGraphTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconLikvidaMedelGraph(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	@Test(description="Verify the information icon on RapportGenvagar graph is showing the right informatio ")
	public void  InformationIconRapportGenvagarFrameTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconRapportGenvagarFrame(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	@Test(description="Verify the information icon on DisponiBelt graph is showing the right informatio ")
	public void  InformationIconDisponiBeltGraphTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconDisponiBeltGraph(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	@Test(description="Verify the information icon on Cashflow graph is showing the right information")
	public void  InformationIconCashFlowGraphTest() {
		softAssert.assertTrue(ekonomiPage.validateInformationIconCashFlowGraph(rolePrevilege));
		softAssert.assertAll();
		
		
	}
	
	
	
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	

}
