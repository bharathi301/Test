package generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Datadriven_example {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		if(driver.getTitle().contains("Online Shopping Site for Mobiles, Electronics"))
		{
			System.out.println("welcomepage displayed");
			Datadriven_writedatatoexcel.writedata("testdata", 0, 2,"pass");
		}
		else
		{
			System.out.println("welcomepage is not displayed");
			Datadriven_writedatatoexcel.writedata("testdata", 0, 2,"fail");
		}
		      
		}
		      
	}

