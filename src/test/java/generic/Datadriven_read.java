package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Datadriven_read 
{
public static void main(String[] args)
{
	System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.flipkart.com");
	String username = Datadriven_excelread.getData("testdata",0,0);
	String password = Datadriven_excelread.getData("testdata",0,1);
    driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();

	
	
}
}
