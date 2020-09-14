package com.pomProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pomProject.Base.TestBase;
import com.pomProject.Pages.ContactsPage;
import com.pomProject.Pages.HomePage;
import com.pomProject.Pages.LoginPage;
import com.pomProject.Utils.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName = "Contacts";

	public ContactsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void Setup()
	{
		initialization();
		testutil=new TestUtil();
		//	contactspage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoFrame();
		contactspage=homepage.ClickOnContactsLink();
	}


	@Test(priority = 1,enabled = false)
	public void verifyContactPageLabel()
	{
		Assert.assertTrue(contactspage.VerifyContactsLabel(),"Contacts label is missing on the page");
	}

	@Test(priority = 2,enabled = false)
	public void SelectContactsTest() throws Exception
	{
		contactspage.SelectContactByName("Amukta Sharma");
		contactspage.SelectContactByName("As G");
		Thread.sleep(8000);
	}

	@Test(priority = 3, enabled = false)
	public void ValidateCreateNewContact() throws InterruptedException
	{
		homepage.ClickOnNewContactLink();
		contactspage.CreateNewContact("Ms.", "Arya", "Mehta", "ABC", "Manish");

		Thread.sleep(8000);
	}

	@DataProvider
	public Object[][] getContactData()
	{
		Object data[][]=testutil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4,dataProvider="getContactData")
	public void ValidateCreateNewContactDDT(String title,String firstname,String lastname,String Company,String refernce) throws InterruptedException
	{
		homepage.ClickOnNewContactLink();
		contactspage.CreateNewContact(title, firstname, lastname, Company, refernce);
		Thread.sleep(5000);
	}



	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
