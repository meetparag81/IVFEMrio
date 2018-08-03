package com_Embrio_pom;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com_Embrio_Base.TestBase;
import com_Embrio_Excelutility.Exls_Reader;
import com_Emrio_Test_util.TestUtil;

public class PatientRegistrationPage extends TestBase 
{
	
	private @FindBy(xpath="//a[@class='dropdown-toggle'][text()='Registration']//following-sibling::div//li[1]/a")WebElement RegistrationPage;
	private @FindBy(xpath="(//button[@class='btn btn-primary btn-sm'])[1]")WebElement LinkbuttonforAttachpagePatient; 
	private @FindBy(xpath="(//button[@class='btn btn-primary btn-sm'])[3]")WebElement LinkbuttonForPartner; 
	private @FindBy(xpath="(//button[@class='btn btn-success gallary-btn '])[2]")WebElement choosephoto;
	private @FindBy(xpath="//div[@class='GallaryWrapper']/input[@class='upload']")WebElement upload;
	private @FindBy(xpath="(//button[@class='btn btn-primary'])[1]")WebElement SaveButton;
	private @FindBy(xpath="//input[@name='txtFirstName']")WebElement patientFirstName;
	private @FindBy(xpath="//input[@name='txtLastName']")WebElement patientLastName;
	private @FindBy(xpath="//input[@name='txtPartnrFirstName']")WebElement partnerFirstName;
	private @FindBy(xpath="//input[@name='txtpartnrLastName']")WebElement partnerLastName;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[1]")WebElement dOBPaitY;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[2]")WebElement dOBPaitM;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[3]")WebElement dOBPaitD;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[5]")WebElement dOBPartY;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[6]")WebElement dOBPartM;
	private@FindBy(xpath="(//label[text()='Date Of Birth '])[1]//following::select[7]")WebElement dOBPartD;
	private @FindBy(xpath="//label[contains(text(),'Mobile No.')]/following::input[@name='txtMobCountryCode']")WebElement CountryCodePait;
	private @FindBy(xpath="//label[contains(text(),'Mobile No.')]/following::input[@name='txtMobNo']")WebElement MobileNoPait ;
	private @FindBy(xpath="//label[contains(text(),'Mobile No.')]/following::input[@name='txtpartnrMobConCode']")WebElement CountryCodeParnt;
	private @FindBy(xpath="//label[contains(text(),'Mobile No.')]/following::input[@name='txtpartnrMobNo']")WebElement MobileNoPartn ;
	private @FindBy(xpath="(//button[@class='btn btn-primary'])[1]")WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement FlashMessage;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']") WebElement UploadMessage;
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
		TestUtil.VisibleOn(driver, LinkbuttonForPartner, 50);
		TestUtil.ActionForMovetoElement(LinkbuttonForPartner);
		}
		catch(Exception e)
		{
			System.out.println("Element- LinkbuttonforAttachpage is not seen within 50 sec");
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LinkbuttonForPartner);
		//LinkbuttonforAttachpage.click();
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
		TestUtil.VisibleOn(driver, LinkbuttonforAttachpagePatient, 50);
		TestUtil.ActionForMovetoElement(LinkbuttonforAttachpagePatient);
		}
		catch(Exception e)
		{
			System.out.println("Element- LinkbuttonforAttachpage is not seen within 50 sec");
		}
		LinkbuttonforAttachpagePatient.click();
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
			Thread.sleep(2000);
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
	public  String UloadPictureOFPatientMessage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		try
		{
		TestUtil.VisibleOn(driver, LinkbuttonforAttachpagePatient, 50);
		TestUtil.ActionForMovetoElement(LinkbuttonforAttachpagePatient);
		}
		catch(Exception e)
		{
			System.out.println("Element- LinkbuttonforAttachpage is not seen within 50 sec");
		}
		LinkbuttonforAttachpagePatient.click();
				
		WebElement SaveButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[5]"));
		
		try
		{
		TestUtil.VisibleOn(driver, SaveButton, 30);
		TestUtil.ActionForMovetoElement(SaveButton);
		}
		catch(Exception e)
		{
			System.out.println("Element-SaveButton is not seen within 30 sec");
		}
		SaveButton.click();
		try
		{
			TestUtil.VisibleOn(driver, UploadMessage, 20);
			TestUtil.ActionForMovetoElement(UploadMessage);
		}
		catch(Exception e)
		{
			System.out.println("Element-UploadMessage is not seen for 20 sec");
		}
		msg= UploadMessage.getText();
		
		return msg;
	}
	
	
	public void FillMandetoryFieldsPatient()
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
		String PatientFirst=reader.getCellData("RegistrationPage", "PatientFirstName", 2); 
		patientFirstName.sendKeys(PatientFirst);
		String PatientLast =reader.getCellData("RegistrationPage", "PatientLastName", 2); 
		patientLastName.clear();
		patientLastName.sendKeys(PatientLast);
		Select BOBPaitY1 = new Select(dOBPaitY);
		String year= reader.getCellData("RegistrationPage", "PatientDOBYear", 2);
		BOBPaitY1.selectByVisibleText(year);
		String month= reader.getCellData("RegistrationPage", "PatientDOBMonth", 2);
		Select DOBPaitM1 = new Select(dOBPartM);
		DOBPaitM1.selectByVisibleText(month);
		String Day= reader.getCellData("RegistrationPage", "PatientDOBDay", 2);
		Select DODPaitD1 = new Select(dOBPaitD);
		DODPaitD1.selectByVisibleText(Day);
		CountryCodePait.clear();
		CountryCodePait.sendKeys("91");
		MobileNoPait.clear();
		String MbileNoPatient=reader.getCellData("RegistrationPage", "MobileNoPatient", 2);
		MobileNoPait.sendKeys(MbileNoPatient);
		
		
		
		
		
		
		
	}
	public void FillMandetoryFieldsPartner()
	{
		try
		{
		TestUtil.VisibleOn(driver, partnerFirstName, 30);
		TestUtil.ActionForMovetoElement(partnerFirstName);
		}
		catch(Exception e)
		{
			System.out.println("Element-partnerFirstName is not seen within30 sec");
		}
		partnerFirstName.clear();
		String PartnerFirst=reader.getCellData("RegistrationPage", "PartnerFirstName", 2); 
		partnerFirstName.sendKeys(PartnerFirst);
		String PartnertLast =reader.getCellData("RegistrationPage", "PartnerLastName", 2); 
		partnerLastName.clear();
		partnerLastName.sendKeys(PartnertLast);
		Select DOBPaitY1 = new Select(dOBPartY);
		String year= reader.getCellData("RegistrationPage", "PartnerDOBYear", 2);
		DOBPaitY1.selectByVisibleText(year);
		String month= reader.getCellData("RegistrationPage", "PartnerDOBMonth", 2);
		Select DOBPaitM1 = new Select(dOBPaitM);
		DOBPaitM1.selectByVisibleText(month);
		Select DODPartnerDay = new Select(dOBPartD);
		String Day= reader.getCellData("RegistrationPage", "PartnerDOBDay", 2);
		DODPartnerDay.selectByVisibleText(Day);
		CountryCodeParnt.clear();
		CountryCodeParnt.sendKeys("91");
		MobileNoPartn.clear();
		String MobilePartner=reader.getCellData("RegistrationPage", "MobileNoPartner", 2);
		MobileNoPartn.sendKeys(MobilePartner);
		
		
		
		
	}
	public String MessageForMandetoryFieldRegistrationForm()
	{
		
		try
		{
			TestUtil.VisibleOn(driver, SaveButton, 30);
			TestUtil.ActionForMovetoElement(SaveButton);
		}
		catch(Exception e)
		{
			System.out.println("Element- SaveButton is not seen with in 30 sec");
		}
		
		SaveButton.click();
		try
		{
			TestUtil.VisibleOn(driver, FlashMessage, 30);
			TestUtil.ActionForMovetoElement(FlashMessage);
		}
		catch(Exception e)
		{
		System.out.println("Element- FlashMessage is not seen within 30 sec");	
		}
		msg= FlashMessage.getText();
		//msg = "Fill all mandatory fields.";
		return msg;
	}
		 
		
		
	
	
	
	public void FillRegistrationForm()
	{
		UloadPictureOFPatient();
		UloadPictureOFPartner();
		FillMandetoryFieldsPatient();
		FillMandetoryFieldsPartner();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			System.out.println("InterruptedException is seen");
		}
		UloadPictureOFPartner();
			
	}
	
	
	public String SaveThePatient()
	{
		try
		{
		TestUtil.VisibleOn(driver, Save, 30);
		TestUtil.ActionForMovetoElement(Save);
		
		}
		catch(Exception e)
		{
			System.out.println("Element-Save is not seen within 30 sec");
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Save);
		//Save.click();
		msg= FlashMessage.getText();
		return msg;
		
	}
	public  ArrayList<Object[]> getdatafromExcel() 
	{
		Exls_Reader reader = null;

		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		int count1 = reader.getRowCount("Addictions");
		for (int rows = 2; rows <= count1; rows++) 
		{

			String FirstNameP = reader.getCellData("RegistrationPage", "PatientFirstName", rows);
			String LastNameP = reader.getCellData("RegistrationPage", "PatientLastName", rows);
			String PatientDOBYear = reader.getCellData("RegistrationPage", "PatientDOBYear", rows);
			String PatientDOBMonth = reader.getCellData("RegistrationPage", "PatientDOBMonth", rows);
			String PatientDOBDay = reader.getCellData("RegistrationPage", "PatientDOBDay", rows);
			String PartnerFirstName = reader.getCellData("RegistrationPage", "PartnerFirstName", rows);
			String PartnerLastName = reader.getCellData("RegistrationPage", "PartnerLastName", rows);
			String PartnerDOBYear = reader.getCellData("RegistrationPage", "PartnerDOBYear", rows);
			String PartnerDOBMonth = reader.getCellData("RegistrationPage", "PartnerDOBMonth", rows);
			String PartnerDOBDay = reader.getCellData("RegistrationPage", "PartnerDOBDay", rows);

			Object[] obj = { FirstNameP, LastNameP, PatientDOBYear, PatientDOBMonth, PatientDOBDay,PartnerFirstName,PartnerLastName, PartnerDOBYear,PartnerDOBMonth,PartnerDOBDay };
			mydata.add(obj);
		}

		return mydata;
	}
	
	
	
	
	
	

}
