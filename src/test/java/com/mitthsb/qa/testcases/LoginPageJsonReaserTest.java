package com.mitthsb.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.stream.JsonReader;
import com.mitthsb.qa.base.TestBase;
import com.mitthsb.qa.pages.HomePage;
import com.mitthsb.qa.pages.Loginpage;
import com.mitthsb.qa.util.TestUtil;

public class LoginPageJsonReaserTest extends TestBase {
	Loginpage loginPage;
	HomePage homePage;
	SoftAssert softAssert=new SoftAssert();
	String Sheetname="Sheet1";
	
	
	

	public LoginPageJsonReaserTest() {
		super();
		// to call testbase constructor to execute prop

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new Loginpage();
		log = Logger.getLogger(LoginPageTest.class);

	}

	
	@DataProvider
	public Object[][] getTestDataForLoginfromJson() throws IOException, ParseException {
		return TestUtil.getJSONdata("C:\\Users\\pperla\\eclipse-workspace\\MittHSBTest\\src\\main\\java\\com\\mitthsb\\qa\\testdata\\LoginFile.json", "Login Data",3);
		
		
	}
	
	@Test(priority=5,dataProvider="getTestDataForLoginfromJson",groups={"LoginPageTest.login"})
	public void login(String login, String pwd, String role)
	
	{
		System.out.println("loginuseris"+login +"and role is "+role);
		
			homePage=loginPage.login(login,pwd,role);
		
	}
	
	
		

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
