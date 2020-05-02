package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Screenshot 
{
public String capturePhoto(WebDriver driver,String testname)
{
	Date d = new Date();
	String d1 = d.toString();
	String date = d1.replace(":", "-");
	final String path = System.getProperty("user.dir")+"/photos/"+date+testname+".png";
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File(path);
	try
	{
		FileHandler.copy(src, dst);
	}
	catch(IOException e)
	{
		Reporter.log("Failed to take screen shot",true);
	}
	return path;
	}
}
