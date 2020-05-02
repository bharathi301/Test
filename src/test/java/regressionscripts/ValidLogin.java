package regressionscripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Datadriven_excelread;
import generic.Generic_Test;
import pom.OnlineShoppingSitePage;
import pom.TryThisSolidMenPoloNeckWhitePage;

public class ValidLogin extends Generic_Test
{
	@Test
	 public void validlogin() throws InterruptedException
	   {   
		   String username = Datadriven_excelread.getData("testdata", 0, 0);
		   String password = Datadriven_excelread.getData("testdata", 0, 1);
		   test=Reports.createTest("Valid Login","user tries to login with valid credentials");
		   OnlineShoppingSitePage lp = new OnlineShoppingSitePage(driver);
		    test.info("test started");
		    	lp.setusername(username);
		    	test.pass("user enters username");
				lp.setpassword(password);
				test.pass("user enters password");
				lp.clicklogin();
				test.pass("user clicks on login");
				lp.title(driver);
				test.pass("title verified");
                lp.hover(driver);
                test.pass("user hover over men");
                lp.Tshirt(driver);
                test.pass("user clicks on t-shirt");
			    lp.Click(driver);
			    test.pass("user clicks on solid polo neck");
			    lp.switchwindow();
			    test.pass("open child window");
			    TryThisSolidMenPoloNeckWhitePage hp = new TryThisSolidMenPoloNeckWhitePage(driver);
			    hp.title(driver);
			    test.pass("title verified");
			    hp.size();
			    test.pass("user selects size");
			    hp.Click();
			    test.pass("click on buy now");
			    Thread.sleep(3000);
			    hp.carttitle(driver);
			    test.pass("verify cart title");
			    hp.removefromcart();
			    test.pass("user removes from cart");
			    Thread.sleep(3000);
			    hp.removecartpopup();
			    test.pass("user clicks on remove cart popup");
			    hp.Myaccount();
			    test.pass("click on MyAccount");
			    hp.Logout();
			    test.pass("user logout");
			    test.info("test ended");
			
}

}