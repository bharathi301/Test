package regressionscripts;

import org.testng.annotations.Test;

import generic.Datadriven_excelread;
import generic.Generic_Test;
import pom.OnlineShoppingSitePage;

public class InvalidLogin extends Generic_Test
{
@Test
public void InvalidLogin()
{
	String username = Datadriven_excelread.getData("testdata", 0, 0);
	   String password = Datadriven_excelread.getData("testdata", 1, 1);
	   test=Reports.createTest("Invalid Login","user tries to login with invalid credentials");
	   OnlineShoppingSitePage lp = new OnlineShoppingSitePage(driver);
	    test.info("test started");
	    	lp.setusername(username);
	    	test.pass("user enters username");
			lp.setpassword(password);
			test.pass("user enters password");
			lp.clicklogin();
			 test.info("test ended");
			 System.out.println("done");
}
}
