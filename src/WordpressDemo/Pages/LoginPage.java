package WordpressDemo.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	@FindBy(id="user_login") WebElement username;
	@FindBy(id="user_pass") WebElement password;
	@FindBy(css="#wp-submit") WebElement logInButton;
	@FindBy(xpath="//p[contains(@class,'message')]") WebElement messageText;
	
	
	
	
	public void loginToWordpress(){
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		username.sendKeys("admin");
		password.sendKeys("demo123");
		logInButton.click();
		
	}
	
	public void verifyThatUserIsLoggedOut(){
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		String message = messageText.getText();
		Assert.assertTrue(message.contains("You are now logged out"));
	}
	
	

}
