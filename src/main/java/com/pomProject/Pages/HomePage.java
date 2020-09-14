package com.pomProject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pomProject.Base.TestBase;

public class HomePage extends TestBase {

	//Page factory or Object Repository
	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement UsernameLabel;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;

	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;

	//Initialize page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action Methods
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean VerifyCorrectUserName() {
		return UsernameLabel.isDisplayed();
	}

	public ContactsPage ClickOnContactsLink()
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink()
	{
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksLink()
	{
		TasksLink.click();
		return new TasksPage();
	}

	public void ClickOnNewContactLink() {

		Actions action=new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactLink.click();
	}
	

	
	
	
}
