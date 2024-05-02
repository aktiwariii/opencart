package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.DataProviders;
import testBase.BaseClass;

public class TC_003_TestLoginDataDrivenTesting extends BaseClass{
	
	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class)
	public void verify_loginddt(String email,String password,String exp) {
		
		logger.info("************TC_003_TestLoginDataDrivenTesting started*********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setEmailpassword(password);
		lp.clicklogin();
		
		MyAccountPage mac=new MyAccountPage(driver);
		boolean target=mac.checkmyaccount();
		
		if (exp.equalsIgnoreCase("Valid")){
			if(target==true) {
				mac.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(target==true) {
				mac.clicklogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("************TC_003_TestLoginDataDrivenTesting ended*********");
	}

}
