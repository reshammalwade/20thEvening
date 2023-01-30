package neoStoxTestClassesMVN;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBaseClasses.BaseFile;
import neoStoxPOMClasses.NeoStoxHomePage;
import neoStoxPOMClasses.NeoStoxMobileNoField;
import neoStoxPOMClasses.NeoStoxPasswordPage;
import neoStoxPOMClasses.NeostoxDashBoard;
import neoStoxPOMClasses.Utility;



public class ValidateNeoStox2UserNameBalanceFileMVN extends BaseFile
{
	NeoStoxHomePage home;
	NeoStoxMobileNoField mobile;
	NeoStoxPasswordPage pass;
	NeostoxDashBoard dash;
	String s="TCID_002";
	String s1="TCID_005";
	
	
	@BeforeClass
	public void launchNeostoxApp() throws IOException
	{   launchbrowser();
		home=new NeoStoxHomePage(driver);
		mobile=new NeoStoxMobileNoField(driver);
		pass=new NeoStoxPasswordPage(driver);
		dash=new NeostoxDashBoard(driver);
		
	}
	@BeforeMethod
	public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		home.ClickOnSignInButton();
		Utility.implicitWait(1000, driver);
		
		mobile.insertMobileNo(Utility.readDataFromPropertyFile("mobile"));
		//Thread.sleep(1000);
		mobile.clickOnSignIn();
		
		Utility.implicitWait(1000, driver);
		pass.enterPassword(Utility.readDataFromPropertyFile("password"));
		pass.clickOnSubmit();
		
		Utility.implicitWait(1000, driver);
		dash.handleAlertPopUp(driver);	
		
	}
    @Test
    public void validateUserName() throws EncryptedDocumentException, IOException 
    {
    	Assert.assertEquals(dash.getActualUserName(), Utility.readDataFromPropertyFile("userName"));
    	Utility.takeScreenshot(driver, s);
	  
    }
    @Test
    public void validateACBalance() throws IOException
    {
    	Assert.assertNotNull(dash.getAcBalance(), "AC Balance is null TC id failed");
    	Utility.takeScreenshot(driver, s1);
    }
    @AfterMethod
    public void logOutFromNeoStox() throws InterruptedException
    {
    	dash.logOutFromNeoStox();
    }
    @AfterClass
    public void closeNeoStoxApp() throws InterruptedException
    {
    	Thread.sleep(2000);
    	driver.close();
    	Reporter.log("Closing application", true);
    	
    }
}
