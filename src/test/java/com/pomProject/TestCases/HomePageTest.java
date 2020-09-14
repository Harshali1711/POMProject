package com.pomProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pomProject.Base.TestBase;
import com.pomProject.Pages.HomePage;
import com.pomProject.Pages.LoginPage;
import com.pomProject.Utils.TestUtil;


public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;

	@BeforeMethod
	public void Setup()
	{
		initialization();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void VeriTitleHomePage()
	{
		String title=homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Homepage Title not found");
	}
	
	@Test(priority = 2)
	public void VerifyUserNameTest()
	{
		testutil.switchtoFrame();
		Assert.assertTrue(homepage.VerifyCorrectUserName());
	}
		
	

	@AfterMethod()
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}


}
