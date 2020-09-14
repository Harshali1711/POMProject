package com.pomProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pomProject.Base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastname;
	
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@name='contact_lookup_ref']")
	WebElement referrredby;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveBtn;
		
	

	//Initializing the Page objects
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions Methods
	public boolean VerifyContactsLabel()
	{
		return ContactsLabel.isDisplayed();
	}

	public void SelectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void CreateNewContact(String title,String fname,String lname,String Company,String reference)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(Company);
		referrredby.sendKeys(reference);
		SaveBtn.click();
	}


}
