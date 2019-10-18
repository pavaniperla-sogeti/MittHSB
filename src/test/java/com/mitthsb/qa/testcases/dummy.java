package com.mitthsb.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mitthsb.qa.base.TestBase;

public class dummy extends TestBase{
	
	@Test(priority=1)
	public void dummyTest() {
	//	String title=homePage.validateHomePageTitle();	
		
		System.out.println("dummy");
			
		Assert.assertTrue(true);		
		//softAssert.assertTrue(homePage.validateHomePageTitle(), "&#214;versikt");
		
	}

}
