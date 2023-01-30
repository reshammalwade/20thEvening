package neoStoxTestClassesMVN;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo 
{   
	@Test
	public void loginTest() throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();

     driver.manage().window().maximize();
     driver.get("https://neostox.com/sign-in"); 
     Thread.sleep(1000);
	 driver.manage().window().maximize();
	  driver.get("https://neostox.com/sign-in"); 
	  Thread.sleep(1000);
	  //click on sign in 
	  driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
	  //entering mobile number
	  driver.findElement(By.xpath("//input[@type='number']")).sendKeys("9172328567");
	  //click on sign in button
	  driver.findElement(By.xpath("//a[@id='lnk_signup1']")).click();
	}
}
