package generic;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Generic_Test implements Auto_const
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports Reports;
	public static ExtentTest test;
  public WebDriver driver;
  @BeforeSuite
  public void setup()
  {
	  htmlReporter = new ExtentHtmlReporter("./reports/"+new Date().toString().replace(":","-")+"E.html");
	  Reports = new ExtentReports();
	  Reports.attachReporter(htmlReporter);
  }
  @Parameters({"browser"})
  @BeforeMethod
  public void openAppn(String browser)
  {
	  FileManager fm = new FileManager();
	  BrowserFactory bff = new BrowserFactory();
	  if(browser.equals("chrome"))
	  {
	  driver = bff.getBrowser("chrome");
	  driver.get(fm.getApplicationUrl());
	  }
	  else
	  {
		 driver = bff.getBrowser("firefox");
		 driver.get(fm.getApplicationUrl());
	  }
	  
	  driver.manage().timeouts().implicitlyWait(fm.getImplicitlyWait(), TimeUnit.SECONDS);
  }
	   
  
  @AfterMethod
  public void closeAppn(ITestResult res) throws IOException
  {  
	  System.out.println(res.getStatus());
		if(ITestResult.FAILURE==res.getStatus())
		{
		    String testName = res.getName();
			test.fail("test script failed", MediaEntityBuilder.createScreenCaptureFromPath(new Screenshot().capturePhoto(driver, testName)).build());
			}
test.assignAuthor("Bharathi");
test.assignCategory("GUI Automation");
test.assignDevice("laptop");
Reports.setSystemInfo("windows","10");
driver.quit();
}
  @AfterSuite
  public void tearDown()
  {
Reports.flush();
}
}