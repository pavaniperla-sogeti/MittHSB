package com.mitthsb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.pages.HomePage;
import com.mitthsb.qa.pages.Loginpage;
import com.mitthsb.qa.testdata.UserHashMap;
import com.mitthsb.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	Loginpage loginPage;
	HomePage homePage;
	SoftAssert softAssert=new SoftAssert();
	String Sheetname="Sheet1";
	
	
	

	public LoginPageTest() {
		super();
		// to call testbase constructor to execute prop

	}

	@BeforeTest
	public void setUp() {

		initialization();
		loginPage = new Loginpage();
		log = Logger.getLogger(LoginPageTest.class);

	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		softAssert.assertEquals(title, "NetScaler Gateway");
		
	}
	
	@Test(priority=2)
	public void hsbLogoTest() {
		boolean flag=loginPage.validateHSBLogo();
		softAssert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void bankIdlinkTest() {
		boolean flag=loginPage.validateBankIDLink();
		softAssert.assertTrue(flag);
		
	}
	
	@Test(priority=4)
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
		return TestUtil.getJSONdata("C:\\Users\\pperla\\eclipse-workspace\\MittHSBTest\\src\\main\\java\\com\\mitthsb\\qa\\testdata\\LoginFile.json", "Login Data",3);
		
			}
	
	@Test(priority=5,dataProvider="getTestDataForLogin",groups={"LoginPageTest.login"})
//	//@Test(priority=5,dataProvider="getTestDataForLoginfromJson",groups={"LoginPageTest.login"})
	public void login(String login, String pwd, String role)
	
{
	
			homePage=loginPage.login(login,pwd,role);
		
	}
	
	@Test(priority=6,dataProvider="getTestDataForLoginHashMap",groups={"LoginPageTest.login"})	
public void loginBasedonHashMap(Map<Object, Object> map)
	
	{
		//System.out.println("useris"+(String)map.get("UserName")+"pwd id"+(String)map.get("password")+"role is"+(String)map.get("Role"));
			homePage=loginPage.login(String.valueOf(map.get("UserName")),(String)map.get("password"),(String)map.get("Role"));
		
	}
	
//	@Test(priority = 6)
//	public void longPageBrokenLinksTest()
//
//	{
//
//		int Brokencount = TestUtil.BrokenLinks();
//		Assert.assertFalse(Brokencount > 0);
//
//	}
	
		

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
