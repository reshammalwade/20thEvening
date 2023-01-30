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

import neoStoxBaseClasses.BaseClass;
import neoStoxPOMClasses.NeoStoxHomePage;
import neoStoxPOMClasses.NeoStoxMobileNoField;
import neoStoxPOMClasses.NeoStoxPasswordPage;
import neoStoxPOMClasses.NeostoxDashBoard;
import neoStoxPOMClasses.Utility;



public class ValidateNeoStox1UserNameExcelMVN extends BaseClass
{
	NeoStoxHomePage home;
	NeoStoxMobileNoField mobile;
	NeoStoxPasswordPage pass;
	NeostoxDashBoard dash;
	String s="TCID_002";
	
	
	@BeforeClass
	public void launchNeostoxApp()
	{   launchBrowser();
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
		
		mobile.insertMobileNo(Utility.readDataFromExcel(3, 1));
		Thread.sleep(1000);
		mobile.clickOnSignIn();
		
		Utility.implicitWait(1000, driver);
		pass.enterPassword(Utility.readDataFromExcel(6, 3));
		pass.clickOnSubmit();
		
		Utility.implicitWait(1000, driver);
		dash.handleAlertPopUp(driver);	
		
	}
    @Test
    public void validateUserName() throws EncryptedDocumentException, IOException 
    {
    	Assert.assertEquals(dash.getActualUserName(), Utility.readDataFromExcel(12, 5));
    	Utility.takeScreenshot(driver, s);
	  
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
    	Reporter.log("Cloasing application", true);
    	
    }
}
