package com_Embrio_pom;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Embrio_Base.TestBase;
import com_Emrio_Test_util.TestUtil;

public class HomePage extends TestBase 
{

private @FindBy(xpath = "//a[@class='dropdown-toggle'][text()='Registration']" )WebElement Registrationbutton;
private @FindBy(xpath="//span[text()='Patient Registration']") WebElement RegistrationTitle;
private @FindBy(xpath="//span[text()='Queue Management']") WebElement HomePageTitle;
private @FindBy(xpath="//a[@class='dropdown-toggle']//following-sibling::div[@class='dropdown-menu']//li/a[text()='Registration']")WebElement Registration;
private String msg;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public PatientRegistrationPage ClickOnRegistrationButton()
	{
		try
		{
			TestUtil.VisibleOn(driver, Registrationbutton, 30);
			TestUtil.ActionForMovetoElement(Registrationbutton);
		}
		catch(Exception e)
		{
			System.out.println("Registrationbutton is not seen within 30 sec");
		}
		
				
		Registrationbutton.click();
		Registration.click();
				
		return new PatientRegistrationPage();
	}
	public String RegistrationTitle()
	{
		try
		{
		TestUtil.VisibleOn(driver, RegistrationTitle, 50);
		TestUtil.ActionForMovetoElement(RegistrationTitle);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element-RegistrationTitle is not seen within 30 sec");
		}
		
		return msg = RegistrationTitle.getText();				
		
		
	}
	public String HomePageTitle()
	{
		try
		{
		TestUtil.VisibleOn(driver, HomePageTitle, 50);
		}
		catch(Exception e)
		{
			System.out.println("Element- HomePageTitle is not seen within 30 sec");
		}
		msg = HomePageTitle.getText();	
		return msg ;
		
		
	}
	
	

}
