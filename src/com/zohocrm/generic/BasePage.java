package com.zohocrm.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Verify the title
	public void verifyTitle(String etitle)
	{
		try{
			
			WebDriverWait wait =new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.titleIs(etitle));
			Reporter.log("Title is matching "+etitle,true);
	    }
		catch(Exception e)
		{
			Reporter.log("Title is not matching "+"|"+etitle+"|",true);
			
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	//Verify the element
	public void verifyElement(WebElement element )
	{
		try{
			 WebDriverWait wait =new WebDriverWait(driver,10);
			 wait.until(ExpectedConditions.visibilityOf(element));
			 Reporter.log("Element is present"+element.getText(),true);
		    }
			catch(Exception e)
			{
			 Reporter.log("Element is not present"+element.getText(),true);
			 Assert.fail();
			 //e.printStackTrace();
			}
			
		}

}
