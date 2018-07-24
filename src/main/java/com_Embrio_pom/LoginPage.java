package com_Embrio_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com_Embrio_Base.TestBase;
import com_Embrio_Excelutility.Exls_Reader;
import com_Emrio_Test_util.TestUtil;
import com_Embrio_pom.HomePage;

public class LoginPage extends TestBase 
{
	private @FindBy(xpath="//input[@name='LoginName']") WebElement username;
	private @FindBy(xpath = "//input[@name='password']") WebElement password;
	private @FindBy(xpath = "//select[@name='InputSourceOfReference']") WebElement clinic;
	private	@FindBy(name = "Login") WebElement Loginbutton;
	private @FindBy(name = "Login") WebElement homepagetxt;
	@FindBy(xpath = "//span[text() = 'Total Count :']//following::span")
	WebElement SizeOfPaitent;
	private @FindBy(xpath = "//span[@class='errorMsg ng-binding']")
	WebElement Msgcorrectusername;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\PrjectIVF\\EMRio_Project\\src\\main\\java\\com_Embrio_TestData\\Embriodata.xlsx");
	
	public HomePage Verifylogin(String un, String psw) 
	{
		username.sendKeys(un);

		password.sendKeys(psw);

		try
		{
		TestUtil.VisibleOn(driver, clinic, 30);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
				Select drop = new Select(clinic);
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Element seen within 20 secs");
		}
		drop.selectByVisibleText("Embrio");
		Loginbutton.click();
		return new HomePage();

	}

	public String Homepagetitle() 
	{
		
		String msg = driver.getTitle();
		return msg;

	}

	public boolean ButtonEnableCondition(String un) 
	{
		username.sendKeys(un);
		boolean flag = Loginbutton.isEnabled();

		if (flag == false) {
			System.out.println("username or password is bot entered");
		}
		return flag;

	}

	public String Invalidusername(String un) 
	{
		
		username.sendKeys(un);
		password.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		String message = Msgcorrectusername.getText();
		return message;
	}

	public String Invaliduserpassword(String un, String psw) 
	{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(psw);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		clinic = wait.until(ExpectedConditions.visibilityOf(clinic));
		Select drop = new Select(clinic);
		String message = Msgcorrectusername.getText();
		return message;
	
	}
	


}
