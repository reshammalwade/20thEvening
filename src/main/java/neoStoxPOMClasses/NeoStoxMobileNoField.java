package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxMobileNoField 
{
	@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement mobileNoField;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")private WebElement signInButton;
	
	
	public NeoStoxMobileNoField(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void insertMobileNo(String mobN)
	{
		mobileNoField.sendKeys(mobN);
		Reporter.log("Entering mobile number", true);
	}
	
	public void clickOnSignIn() 
	{
		signInButton.click();
		Reporter.log("Clicking on SignIn Button", true);
	}

}
