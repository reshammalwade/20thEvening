package neoStoxPOMClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility 
{
	//Excel
	//Wait
	//ScreenShot
	//ScrollIntoView
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//1.Create object of property file
		Properties prop=new Properties();
		//2.create object of fileInputstream
		FileInputStream myFile= new FileInputStream("C:\\Users\\rajat\\eclipse-workspace\\mavenProjects\\src\\test\\resources\\neoStoxPropertyFile\\myProperty.properties");
	    //3.load file
		prop.load(myFile);
		//4.read data from file
		String value = prop.getProperty(key);
		Reporter.log("Reading data from property file", true);
		Reporter.log("Data is: "+value, true);
		return value;
		
	
	}
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		File myFile= new File("D:\\20th_evening\\Countries.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String value=mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Read data from excel is: row: "+row+", cell is: "+cell, true);
		Reporter.log("Data is: "+value, true);
		return value;
	}
	
	public static void implicitWait(int time, WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("Waiting for: "+time, true);
	}
	
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException
	{
		String random = RandomString.make(3);
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //interface                             interface
        File dest= new File("D:\\20th_evening\\Screensht\\"+fileName+random+".png");
        FileHandler.copy(scr, dest);
        Reporter.log("Taking ScreenShot", true);
        Reporter.log("ScreenShot Taken and saved at: "+dest, true);
 	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scroll into view to: "+element.getText(),true);
		
	}

}
