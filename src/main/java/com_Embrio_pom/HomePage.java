package com_Embrio_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Embrio_Base.TestBase;
import com_Emrio_Test_util.TestUtil;

public class HomePage extends TestBase 
{

private @FindBy(xpath = "//a[@class='dropdown-toggle'][text()='Registration']" )WebElement Registration;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public PatientRegistrationPage ClickOnRegistrationButton()
	{
		TestUtil.ActionForMovetoElement(Registration);
		Registration.click();
		
		
		return new PatientRegistrationPage();
	}

}
