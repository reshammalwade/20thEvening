package neoStoxTestClassesMVN;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerMVN implements ITestListener
{
  
   public void onTestFailure(ITestResult result) 
   {
	   String tcName = result.getName();
       Reporter.log("TC "+tcName+" is failed, please try again", true);

   }
   public void onTestSuccess(ITestResult result) 
   {
	   Reporter.log("TC "+result.getName()+" is passed successfully", true);
		
   }
   
   public void onTestSkipped(ITestResult result) 
   {
	   Reporter.log("TC "+result.getName()+" is skipped, please have a look", true);
		
   }
}
