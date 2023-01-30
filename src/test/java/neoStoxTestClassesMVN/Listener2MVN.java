package neoStoxTestClassesMVN;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBaseClasses.BaseStatic;
import neoStoxPOMClasses.Utility;



public class Listener2MVN extends BaseStatic implements ITestListener
{
  
   public void onTestFailure(ITestResult result) 
   {
	   try 
	   {
		  
	       Reporter.log("TC "+result.getName()+" is failed, please try again", true);
	      
		   Utility.takeScreenshot(driver, result.getName());
		
	   } 
	   catch (Exception e)  
	   {
		   e.printStackTrace();
	   }
	  

   }
   public void onTestSuccess(ITestResult result) 
   {
	   String tcName = result.getName();
	   Reporter.log("TC "+tcName+" is passed successfully", true);
		
   }
   
   public void onTestSkipped(ITestResult result) 
   {
	   Reporter.log("TC "+result.getName()+" is skipped, please have a look", true);
		
   }
}
