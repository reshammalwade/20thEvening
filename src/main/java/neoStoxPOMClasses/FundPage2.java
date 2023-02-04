package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FundPage2 
{
	@FindBy(xpath = "(//a[text()='Sign In'])[1]")private WebElement signInButton;

	public FundPage2(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnSignInButton()
	{
	    signInButton.click();
	    Reporter.log("Clicking on SignIn Button", true);
	}

}
