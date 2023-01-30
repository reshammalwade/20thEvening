package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeostoxDashBoard 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]")private WebElement alertOkButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement alertCloseButton;
	
	@FindBy(xpath = "//span[@id='lbl_username']")private WebElement userName;
	
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logOutButton;
	
	@FindBy(id = "lbl_curbalancetop")private WebElement acBalance;
	
	public NeostoxDashBoard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void handleAlertPopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
	  if(alertOkButton.isDisplayed())
	  {
		Thread.sleep(1000);
		Utility.scrollIntoView(driver, alertOkButton);
		alertOkButton.click();
		Reporter.log("Clicking on Pop Up OK Button", true);
		Thread.sleep(1000);
//		Utility.scrollIntoView(driver, alertCloseButton);
//		alertCloseButton.click();
//		Reporter.log("Clicking on Pop Up Close Button", true);
	  }
	  else
	  {
		  Reporter.log("There is no Pop-up", true);
	  }
	}
	
	
	
	public String getActualUserName() 
	{
		String actualUserName = userName.getText();
		Reporter.log("Getting actual user name", true);
		Reporter.log("Actual user name is---> "+actualUserName, true);
		return actualUserName;
		
	}
	
	public void logOutFromNeoStox() throws InterruptedException
	{
		userName.click();
		Thread.sleep(2000);
		logOutButton.click();
		Reporter.log("Logging out from neostox", true);
	}
	
	public String getAcBalance()
	{
		String balance = acBalance.getText();
		Reporter.log("Getting AC Balance", true);
		Reporter.log("Account balance is: "+balance, true);
		return balance;
	}
	
	

}
