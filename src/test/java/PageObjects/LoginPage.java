package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtemailpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnlogin;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setEmailpassword(String password) {
		txtemailpassword.sendKeys(password);
	}
	
	public void clicklogin() {
		btnlogin.click();
	}
}
