package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_Test_AccountReg extends BaseClass {
	
	
	
	
	
	@Test(groups= {"regression","master"})
	public void verifyaccountregistration() {
		logger.info("*************Test case verifyaccountregistration started********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*************Clicked on myaccount********");
		hp.clickRegister();
		
		RegisterPage rp=new RegisterPage(driver);
		
		rp.setFirstName(randomeString().toUpperCase());
		rp.setLastName(randomeString().toUpperCase());
		rp.setEmail(randomeString()+"gmail.com");
		//String pwd=randomAlphaNumberic();
		rp.setPassword(randomAlphaNumberic());
		rp.setPrivacyPolicy();
		rp.clickContinue();
		String confmsg=rp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "our Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test case failed");
			Assert.fail();
		}
		logger.info("*************Test case verifyaccountregistration ended********");
	}
	
	
	
	

}
