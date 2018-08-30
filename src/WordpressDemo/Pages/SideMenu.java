package WordpressDemo.Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SideMenu {
	
	WebDriver driver;
	
	
	
	
	public SideMenu(WebDriver driver){
		
		this.driver=driver;
		
	}
		
		@FindBy(xpath="//div[contains(text(),'Posts')]")
		WebElement posts;
		
		@FindBy(xpath="//a[@href='post-new.php']")
		WebElement addNew;
		
			
		
		public void goToAddANewPostPage(){
			
			Actions actions = new Actions(driver);
			actions.moveToElement(posts);
			actions.perform();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;	
		    js.executeScript("arguments[0].click();", addNew);
			
		
		}
		
	

}
