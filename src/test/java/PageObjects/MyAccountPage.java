package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	

	@FindBy(xpath="//div[@id='content']/h2")
	WebElement myaccount;
	
	@FindBy(xpath="//a[text()='Logout'][@class='list-group-item']")
	WebElement logout;
	
	public boolean checkmyaccount() {
		try {
			return (myaccount.isDisplayed());
		}catch(Exception e) {
			return(false);
		}
	}
	
	public void clicklogout() {
		logout.click();
	}
}
