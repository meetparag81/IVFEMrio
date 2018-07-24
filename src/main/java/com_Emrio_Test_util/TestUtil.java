package com_Emrio_Test_util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com_Embrio_Base.TestBase;

public class TestUtil extends TestBase 
{

	public static final long PAGE_LOAD_TIMEOUT =30;
	public static final long IMPLICIT_WAIT = 30;
	
	public static void ClickOn(WebDriver driver,WebElement locator,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeSelected(locator));
		locator.click();
		
	}
	public static void  VisibleOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void  VisibleElementsOn(WebDriver driver,List<WebElement> element,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	
	
	public static void takeScreenshotAtEndOfTest1()
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try 
		{
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots1/" + System.currentTimeMillis() + ".png"));
		}
		catch (IOException e) 
		{
			System.out.println("Exception are" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static String takescreenshotForSkip(WebDriver driver, String screenshotname)  
	{
	      //below line is just to append the date format with the screenshot name to avoid duplicate names 
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		    formatter = new SimpleDateFormat("dd,MM,yyyy"); 
		    String dateName = new SimpleDateFormat("dd,MM,yyyy").format(new Date());
		   //     String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/SkippedTestScrrenshots/"+screenshotname+dateName+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        //Returns the captured file path
		return destination;

	}
	public static  void ActionForMovetoElement(WebElement element )
	{
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(element);
		
	}
	
	
	
	public static String TskeScreenshotForFail(WebDriver driver, String screenshotName) 
		{
	        //below line is just to append the date format with the screenshot name to avoid duplicate names 
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    formatter = new SimpleDateFormat("dd,MM,yyyy"); 
	    String dateName = new SimpleDateFormat("dd,MM,yyyy").format(new Date());
	   //     String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	try {
		FileUtils.copyFile(source, finalDestination);
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	        //Returns the captured file path
	return destination;
		}
	public static String getMonthForInt(int num) 
	{
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) 
        {
            month = months[num];
        }
        return month;	
		
	}
	public static String Date()
	{
		Date date1 = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    formatter = new SimpleDateFormat("dd,MMMM,yyyy,zzzz"); 
	    String strDate = formatter.format(date1);  
		strDate = formatter.format(date1); 
		
		
		return strDate;
		
	
	

}
}
