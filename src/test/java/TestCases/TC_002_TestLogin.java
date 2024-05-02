package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_TestLogin extends BaseClass{

	@Test(groups= {"sanity","regression","master"})
	public void verify_login() {
		try {
		logger.info("*********tc002login started**********");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setEmailpassword(p.getProperty("password"));
		lp.clicklogin();
		
		MyAccountPage mac=new MyAccountPage(driver);
		boolean target=mac.checkmyaccount();
		
			if(target==true) {
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.fail();
			}
		
		logger.info("***********tc002 login end**********");
		}catch(Exception e) {
			Assert.fail();
		}
	}
}
