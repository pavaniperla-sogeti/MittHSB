package com.mitthsb.qa.testcases;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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

public class EkonomiPageSmokeTests extends TestBase{
	
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
	SoftAssert softAssert;
	String rolePrevilege;
	
	public EkonomiPageSmokeTests() {
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
		ekonomiPage=homePage.ekonomiTab(rolePrevilege);

	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify the list item AllFaktuor is displayed or not")
	public void validateAllaFakturorListItemTest() {
		boolean flag=ekonomiPage.validateAllaFakturorListItem(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		
	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify the list item Finansiella Rappport is displayed or not")
	public void validateFinansiellaRapportListItemTest() {
		boolean flag=ekonomiPage.validatefinansiellaRapportListItem(rolePrevilege);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@Test(groups = { "Regression", "smokeTest" },description="Verify the title of ekonomiPage as Ekonomisk översikt - NOT FOR COMMERCIAL USE")
	public void ekonomiPageTitleTest() {
		String title=ekonomiPage.validateEkonomiPageTitle();
		System.out.println("title is"+title);
		softAssert.assertEquals(title, "Ekonomisk översikt - NOT FOR COMMERCIAL USE");
		softAssert.assertAll();
		
		//softAssert.assertTrue(homePage.validateHomePageTitle(), "&#214;versikt");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		System.out.println("this methiod is ended");
		// driver.close();
		driver.quit();
	}

}
