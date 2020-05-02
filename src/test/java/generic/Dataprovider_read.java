package generic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_read
{
@Test(dataProvider = "Authentication")
public void login(String username,String password) throws InterruptedException
{
	System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://preptool-pipeline.w3ibm.mybluemix.net/");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("bharam59@in.ibm.com");
	driver.findElement(By.xpath("//button[@id='continue-button']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='desktop']")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys(password);
    Thread.sleep(3000);
	driver.findElement(By.xpath("//button[.='Sign In']")).click();
	Thread.sleep(10000);
	String atitle = driver.getTitle();
	String expected = "IBM Procurement Requirement Entry Process";
	Assert.assertEquals(atitle,expected);
}
@DataProvider(name="Authentication")
public Object[][] credentials()
{
	
	Object[][] arrobj=Dataprovider_exceldata.getData();
	return arrobj;
		
}
}
