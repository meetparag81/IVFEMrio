package com_Embrio_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_Embrio_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Embrio_pom.HomePage;
import com_Embrio_pom.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage Loginpage;	
HomePage HomePage;
Exls_Reader reader = new Exls_Reader("C:\\Parag\\PrjectIVF\\EMRio_Project\\src\\main\\java\\com_Embrio_TestData\\Embriodata.xlsx");
	
	
@BeforeMethod
public void setup()
{
	TestBase.initalization();
	Loginpage = new LoginPage();
}
@Test(priority=1)
public void InvalidusernameTest() 
{
	String username = reader.getCellData("LoginPage", 0, 2);	
	String Actual= Loginpage.Invalidusername(username);
	String Msg= reader.getCellData("LoginPage", 2, 2);
	String Expected= Msg;
	Assert.assertEquals(Actual, Expected);
	System.out.println("InvalidusernameTest is completed");
}

@Test(priority=2)
public void InvalidPasswordTest() 
{
	String username = reader.getCellData("LoginPage", 0, 3);
	String password = reader.getCellData("LoginPage", 1, 3);
	String Actual= Loginpage.Invaliduserpassword(username, password);
	String Msg= reader.getCellData("LoginPage", 2, 3);
	String Expected= Msg;
	Assert.assertEquals(Actual, Expected);
	System.out.println("InvalidpasswordTest is completed");
}

@Test(priority=3)
public void ButtonEnableConditionTest()
{
	
	boolean flag1=Loginpage.ButtonEnableCondition(prop.getProperty("username"));
	Assert.assertFalse(flag1);
}

@ Test(priority=4)
public void LoginTest() 
{
	HomePage= Loginpage.Verifylogin( prop.getProperty("username"),prop.getProperty("password"));
	String Title = "Palash IVF - Login";		
	String Actual = Loginpage.Homepagetitle();
	Assert.assertEquals(Title, Actual);
}	


@ AfterMethod
public void Teardown()
{
	driver.quit();
}

	

}
