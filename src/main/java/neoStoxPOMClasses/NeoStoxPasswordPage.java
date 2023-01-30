
package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPasswordPage 
{
    @FindBy(xpath = "//input[@id='txt_accesspin']")private WebElement passwordField;
    @FindBy(xpath = "//a[text()='Submit']")private WebElement submitButton;
    
    public NeoStoxPasswordPage(WebDriver driver) 
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void enterPassword(String passwrd)
    {
    	passwordField.sendKeys(passwrd);
    	Reporter.log("Entering password", true);
    }
    
    public void clickOnSubmit() throws InterruptedException
    {
    	Thread.sleep(1000);
    	submitButton.click();
    	Reporter.log("Clicking on Submit Button", true);
    }
    
}
