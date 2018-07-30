package com_Embrio_pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com_Embrio_Base.TestBase;
import com_Embrio_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class PatientRegistrationPage extends TestBase 
{
	
	private @FindBy(xpath="//a[@class='dropdown-toggle'][text()='Registration']//following-sibling::div//li[1]/a")WebElement RegistrationPage;
	private @FindBy(xpath="(//button[@class='btn btn-primary btn-sm'])[1]")WebElement LinkbuttonforAttachpage; 
	private @FindBy(xpath="(//button[@class='btn btn-success gallary-btn '])[2]")WebElement choosephoto;
	private @FindBy(xpath="//div[@class='GallaryWrapper']/input[@class='upload']")WebElement upload;
	private @FindBy(xpath="(//button[@class='btn btn-primary'])[5]")WebElement SaveButton;
	private @FindBy(xpath="//input[@name='txtFirstName']")WebElement patientFirstName;
	private @FindBy(xpath="//input[@name='txtLastName']")WebElement patientLastName;
	private @FindBy(xpath="//input[@name='txtPartnrFirstName']")WebElement partnerFirstName;
	private @FindBy(xpath="//input[@name='txtpartnrLastName']")WebElement partnerLastName;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[1]")WebElement BOBPaitY;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[2]")WebElement BOBPaitM;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[2]")WebElement BOBPaitD;
	private @FindBy(xpath="//button[@class='btn btn-primary']")WebElement Save;
	private @FindBy(xpath="toast-msg ng-binding ng-scope")WebElement FlashMessage;
	String msg;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\PrjectIVF\\EMRio_Project\\src\\main\\java\\com_Embrio_TestData\\Embriodata.xlsx");
	
	public PatientRegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	public  void UloadPictureOFPartner()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		try
		{
		TestUtil.VisibleOn(driver, LinkbuttonforAttachpage, 50);
		TestUtil.ActionForMovetoElement(LinkbuttonforAttachpage);
		}
		catch(Exception e)
		{
			System.out.println("Element- LinkbuttonforAttachpage is not seen within 50 sec");
		}
		LinkbuttonforAttachpage.click();
		try
		{
		TestUtil.VisibleOn(driver, choosephoto, 50);
		TestUtil.ActionForMovetoElement(choosephoto);
		}
		catch(Exception e)
		{
			System.out.println("Exception is seen");
		}
		choosephoto.click();
		try
		{
			TestUtil.VisibleOn(driver, upload, 30);
			TestUtil.ActionForMovetoElement(upload);
		}
		catch(Exception e)
		{
			System.out.println("Exception is seen");
		}
		upload.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		try {
			Runtime.getRuntime().exec("C:\\Parag\\Git\\IVFmilan\\AutoIT\\FileUpload.exe");
		} catch (IOException e) 
		{
			System.out.println("IOException is seen");
		}
		WebElement SaveButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[5]")); 
		SaveButton.click();
	}
	public  void UloadPictureOFPatient()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		try
		{
		TestUtil.VisibleOn(driver, LinkbuttonforAttachpage, 50);
		TestUtil.ActionForMovetoElement(LinkbuttonforAttachpage);
		}
		catch(Exception e)
		{
			System.out.println("Element- LinkbuttonforAttachpage is not seen within 50 sec");
		}
		LinkbuttonforAttachpage.click();
		try
		{
		TestUtil.VisibleOn(driver, choosephoto, 50);
		TestUtil.ActionForMovetoElement(choosephoto);
		}
		catch(Exception e)
		{
			System.out.println("Exception is seen");
		}
		choosephoto.click();
		try
		{
			TestUtil.VisibleOn(driver, upload, 30);
			TestUtil.ActionForMovetoElement(upload);
		}
		catch(Exception e)
		{
			System.out.println("Exception is seen");
		}
		upload.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		try {
			Runtime.getRuntime().exec("C:\\Parag\\Git\\IVFmilan\\AutoIT\\FileUpload.exe");
		} catch (IOException e) 
		{
			System.out.println("IOException is seen");
		}
		WebElement SaveButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[5]")); 
		SaveButton.click();
	}
	
	
	public void FillMandetoryFieldsPatient( )
	{
		try
		{
		TestUtil.VisibleOn(driver, patientFirstName, 30);
		TestUtil.ActionForMovetoElement(patientFirstName);
		}
		catch(Exception e)
		{
			System.out.println("Element-FirstName is not seen within30 sec");
		}
		patientFirstName.clear();
		String PatientFirst=reader.getCellData("Registration", "PatientFirst Name", 2); 
		patientFirstName.sendKeys(PatientFirst);
		String PatientLast =reader.getCellData("Registration", "PatientLastName", 2); 
		patientLastName.clear();
		patientLastName.sendKeys(PatientLast);
		Select BOBPaitY1 = new Select(BOBPaitY);
		String year= reader.getCellData("Registration", "PatientDOBYear", 2);
		BOBPaitY1.selectByVisibleText(year);
		String month= reader.getCellData("Registration", "PatientDOBMonth", 2);
		Select BOBPaitM1 = new Select(BOBPaitM);
		String Day= reader.getCellData("Registration", "PatientDOBDay", 2);
		
		
		
		
		
	}
	public void FillMandetoryFieldsPartner( )
	{
		try
		{
		TestUtil.VisibleOn(driver, patientFirstName, 30);
		TestUtil.ActionForMovetoElement(patientFirstName);
		}
		catch(Exception e)
		{
			System.out.println("Element-FirstName is not seen within30 sec");
		}
		partnerFirstName.clear();
		String PatientFirst=reader.getCellData("Registration", "PartnerFirstName", 2); 
		partnerFirstName.sendKeys(PatientFirst);
		String PatientLast =reader.getCellData("Registration", "PartnerLastName", 2); 
		patientLastName.clear();
		patientLastName.sendKeys(PatientLast);
		Select BOBPaitY1 = new Select(BOBPaitY);
		String year= reader.getCellData("Registration", "PatientDOBYear", 2);
		BOBPaitY1.selectByVisibleText(year);
		String month= reader.getCellData("Registration", "PatientDOBMonth", 2);
		Select BOBPaitM1 = new Select(BOBPaitM);
		String Day= reader.getCellData("Registration", "PatientDOBDay", 2);
		
		
		
		
		
	}
	public String MessageForMandetoryFieldRegistrationForm()
	{
		TestUtil.ActionForMovetoElement(SaveButton);
		SaveButton.click();
		TestUtil.ActionForMovetoElement(FlashMessage);
		msg= FlashMessage.getText();
		msg = "Fill all mandatory fields.";
		return msg;
		 
		
		
	}
	
	
	public void FillRegistrationForm()
	{
		FillMandetoryFieldsPatient( );
		UloadPictureOFPatient();
		UloadPictureOFPartner();
			
	}
	
	
	
	
	
	public String SaveThePatient()
	{
		return msg;
		
	}

}
