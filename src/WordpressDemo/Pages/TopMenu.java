package WordpressDemo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TopMenu {
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver){
		
		this.driver=driver;
	}

	@FindBy(id="wp-admin-bar-my-account") WebElement userMenu;
	@FindBy(xpath="//a[contains(@class,'ab-item')][contains(text(),'Log Out')]") WebElement logOutButton;


	public void logOut(){
	
		Actions actions = new Actions(driver);
		actions.moveToElement(userMenu);
		actions.perform();
	
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();", logOutButton);
	}	
}
