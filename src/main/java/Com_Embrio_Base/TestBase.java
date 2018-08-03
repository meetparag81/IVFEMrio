package Com_Embrio_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com_Emrio_Test_util.TestNGListner;
import com_Emrio_Test_util.TestUtil;

@Listeners(com_Emrio_Test_util.TestNGListner.class)
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverEventListener e_driver;
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try
		{
			prop = new Properties();
			 ip = new FileInputStream("C:\\Parag\\PrjectIVF\\EMRio_Project\\src\\main\\java\\Com_Embrio_Config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
			
		
	}
	
	public static void initalization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Parag\\Paragdata30032018\\Parag\\Selenium\\Selenium Setup\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();		
		}	
		else if(browsername.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver" ,"C:\\Parag\\Paragdata30032018\\Parag\\Selenium\\Selenium Setup\\chrome exe for 65\\chromedriver.exe");
			driver = new ChromeDriver();
		 }
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		//	WebDriverEventListener eventListener =  new TestNGListner();
		//	e_driver.register(eventListener);
			driver = e_driver;			
		//e_driver.register(eventListener);
		driver = e_driver;
		try
		{
		driver.manage().window().maximize();
		}
		catch(WebDriverException e)
		{
			System.out.println("Webdriver exception seen");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try
		{
		driver.get(prop.getProperty("url"));
		}
		catch(Exception e)
		{
			System.out.println("url is not entered");
			
		}

}
}
