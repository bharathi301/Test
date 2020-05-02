package generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusablemethods 
{
	
	public void mousehover(WebDriver driver, WebElement men)
	{
		Actions act = new Actions(driver);
		act.moveToElement(men).perform();	
	}
	public void windowhandler(WebDriver driver)
	{
		Set<String> allwindows = driver.getWindowHandles();
		for( String str:allwindows)
		{
			driver.switchTo().window(str);
			System.out.println(driver.getTitle());
			}
		
	}
public void popup(WebDriver driver)
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.alertIsPresent());
	Alert remove = driver.switchTo().alert();
	remove.accept();
}

public void rightclick(WebDriver driver, WebElement element)
{
	
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}

	public void selectByPosition(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	public List<String> selectAllOptions(WebElement element)
     {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		List<String> li = new ArrayList<String>();
		for(WebElement we:options)
		{
			li.add(we.getText());
		}
		return li;
	}
	
	public int findAllElements(WebDriver driver,String xpath)
	{
	List<WebElement> alladdress = driver.findElements(By.xpath(xpath));
	int count = alladdress.size();
	return count;
}
}