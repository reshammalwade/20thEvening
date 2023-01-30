package neoStoxBaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOMClasses.Utility;



public class BaseClass
{
	protected WebDriver driver;
	public void launchBrowser()
	{
		
	  System.setProperty("webdriver.chrome.driver","D:\\20th_evening\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("https://neostox.com/");
	  Reporter.log("Launching browser", true);
	  Utility.implicitWait(1000, driver);
	  
	}

}
