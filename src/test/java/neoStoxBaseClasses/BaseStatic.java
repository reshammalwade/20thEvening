package neoStoxBaseClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOMClasses.Utility;



public class BaseStatic 
{
	protected static WebDriver driver;
	public void launchbrowser() throws IOException
	{
	  System.setProperty("webdriver.chrome.driver","D:\\20th_evening\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get(Utility.readDataFromPropertyFile("url"));
	  Reporter.log("Launching browser", true);
	  Utility.implicitWait(1000, driver);
	}

}
