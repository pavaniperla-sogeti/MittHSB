package com.mitthsb.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.lang.reflect.Method;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.pages.HomePage;
import com.mitthsb.qa.pages.Loginpage;
import com.mitthsb.qa.pages.logoutPage;
import com.mitthsb.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	Loginpage loginPage;
	HomePage homePage;
	SoftAssert softAssert=new SoftAssert();
	String Sheetname="Sheet1";
	logoutPage logoutPage;
	
	
	

	public LoginPageTest() {
		super();
		// to call testbase constructor to execute prop

	}

	@BeforeMethod
	public void setUp(Method method) throws StaleElementReferenceException {

		initialization();
		loginPage = new Loginpage();
		log = Logger.getLogger(LoginPageTest.class);
		System.out.println("class is"+this.getClass().getName()+"and method is"+method.getName());

	}
	
	@Test
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		softAssert.assertEquals(title, "NetScaler Gateway");
		
	}
	
	@Test
	public void hsbLogoTest() {
		boolean flag=loginPage.validateHSBLogo();
		softAssert.assertTrue(flag);
		
	}
	
	@Test
	public void bankIdlinkTest() {
		boolean flag=loginPage.validateBankIDLink();
		softAssert.assertTrue(flag);
		
	}
	
	@Test
	public void gdprLinkTest() {
		boolean flag=loginPage.validateGDPRLink();
		softAssert.assertTrue(flag);
		
	}
	
	@DataProvider//using Excel
	public Object[][] getTestDataForLogin() {
		Object  data[][]=TestUtil.getTestData(Sheetname);
		return data;
		
		
	}
	

	@DataProvider//using HashMap
	public Object[][] getTestDataForLoginHashMap() throws Exception {
				
		 return TestUtil.getTestDataFromHashMap(Sheetname);
		
		
	}
	
	
	// reading data from json use this data provider.
	@DataProvider
	public Object[][] getTestDataForLoginfromJson() throws IOException, ParseException {
		return TestUtil.getJSONdata(System.getProperty("user.dir")+ "/src/main/java/com/mitthsb/qa/testdata/LoginFile.json", "Login Data",3);
		
		
		
			}
	
	//	@Test(priority=5,dataProvider="getTestDataForLogin",groups={"LoginPageTest.login"})
	@Test(dataProvider="getTestDataForLoginfromJson",groups={"LoginPageTest.login"})
	public void login(String login, String pwd, String role)
	
{
	
			homePage=loginPage.login(login,pwd,role);
			homePage.logout();
		
	}
	
//	@Test(priority=6,dataProvider="getTestDataForLoginHashMap",groups={"LoginPageTest.login"})	
//public void loginBasedonHashMap(Map<Object, Object> map)
//	
//	{
//		//System.out.println("useris"+(String)map.get("UserName")+"pwd id"+(String)map.get("password")+"role is"+(String)map.get("Role"));
//			homePage=loginPage.login(String.valueOf(map.get("UserName")),(String)map.get("password"),(String)map.get("Role"));
//		
//	}
	
//	@Test(priority = 6)
//	public void longPageBrokenLinksTest()
//
//	{
//
//		int Brokencount = TestUtil.BrokenLinks();
//		Assert.assertFalse(Brokencount > 0);
//
//	}
//	
		

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
