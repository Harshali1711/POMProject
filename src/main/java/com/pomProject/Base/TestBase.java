package com.pomProject.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.pomProject.Utils.TestUtil;
import com.pomProject.Utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	static WebEventListener eventlistener;
	
	//Create construtor of TestBase class(This is parent class(super))
	public TestBase()
	{
		try
		{
			//Instantiate object
			prop=new Properties(); 
			
			//File we need in read mode
			FileInputStream fis=new FileInputStream("C:\\Users\\dpkBhatt\\eclipse-workspace\\POMProject\\src\\main\\java\\com\\pomProject\\Config\\config.properties");
			
			//load the complete file
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	//	sheet=book.get
	}
	
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dpkBhatt\\eclipse-workspace\\POMProject\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dpkBhatt\\eclipse-workspace\\POMProject\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		//Webdriver fire event
		e_driver=new EventFiringWebDriver(driver);
		//Now create the object of EventListnerHandler to register it with EventFiringWebDriver
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//Page Load timeout
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		//Implicitely wait
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//Go to the Application
		driver.get(prop.getProperty("url"));
	}

}
