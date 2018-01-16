package com.zohocrm.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest implements AutoConstant{
	
	public static WebDriver driver=null;
	@BeforeMethod
	public void preCondition() throws MalformedURLException
	{
		System.setProperty(chrome_key, chrome_value);
		driver=new FirefoxDriver();
		//URL  url=new URL("http://localhost:4444/wd/hub");
		//DesiredCapabilities dc = new DesiredCapabilities();
		//dc.setBrowserName("chrome");
		
		//driver=new RemoteWebDriver(url,dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://crm.zoho.com/crm/");
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
