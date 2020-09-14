package com.pomProject.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pomProject.Base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory -- OR-Object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(linkText="Sign Up")
	WebElement SignupLink;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CRMlogo;
	
	//Initialize all object repository' -- constuctor
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions methods
	
	public String ValidatePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateCRMlogo()
	{
		return CRMlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		//Click on button
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
		
		
		return new HomePage(); //Login method should return home page class object 
		                       //that is why the return type of method is HomePage.
		
	}

}
