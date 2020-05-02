package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_page;
import generic.Reusablemethods;

public class TryThisSolidMenPoloNeckWhitePage extends Base_page
{

	public TryThisSolidMenPoloNeckWhitePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//a[@class='_1TJldG _2I_hq9 _2UBURg']")
	private WebElement size;
	@FindBy(xpath = "//button[@class = '_2AkmmA _2Npkh4 _2MWPVK']")
	private WebElement addtocart;
	
	@FindBy(xpath="//div[contains(text(),'Remove')]")
	private WebElement Remove;
	@FindBy(xpath="//div[@class='gdUKd9 _3Z4XMp _2nQDKB']")
	private WebElement Removepopup;
	@FindBy(xpath="//div[@class='_2aUbKa']")
	private WebElement account;
	@FindBy(xpath="//div[.='Logout']")
	private WebElement lout;
	
	
	
	 public void title(WebDriver driver)
	    {
	    	String title = "T-Shirts for Men - Shop for Branded Men's T-Shirts at Best Prices in India";
	        verifyTitle(title,40);
	    }
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	public void size()
	{
		js.executeScript("window.scrollBy(0, 500)");
		verifyElement(size, 5);
		size.click();
	}
	public void Click()
	{   
		js.executeScript("window.scrollBy(0, 500)");
		verifyElement(addtocart, 5);
		addtocart.click();
	}
	public void carttitle(WebDriver driver)
    {
    	String title1 = "Shopping Cart";
        verifyTitle(title1,30);
    }
	
	public void removefromcart()
	{
	verifyElement(Remove,30);
	Remove.click();
	}
	public void removecartpopup() 
	{
   verifyElement(Removepopup,20);
   Removepopup.click();
	}
	public void Myaccount()
	{
	verifyElement(account,20);
	Reusablemethods obj = new Reusablemethods();
	obj.mousehover(driver,account);
	}
	public void Logout()
	{
		verifyElement(lout,20);
		lout.click();
	}
	
}







