package WordpressDemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddNewPostPage {
	
	WebDriver driver;
	
	public AddNewPostPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	@FindBy(css="input#title") WebElement titleField;
	@FindBy(id="content_ifr") WebElement postContentField;
	@FindBy (xpath="//input[@name='save']") WebElement saveDraftButton;
	
	public void verifyTitle(){
		
		String actualTitle = driver.getTitle();		
		
		Assert.assertTrue(actualTitle.contains("Add New Post"));
	}
	
	public void saveAsDraftWithTextOnly(){
		
		titleField.sendKeys("Test by Agata 0.1");
		//postContentField.sendKeys("Test by Agata 0.1");
		
		driver.switchTo().frame(postContentField);
		System.out.println("Entering something in text input");
		postContentField.sendKeys("Test text");
		
		//saveDraftButton.click();
		
		
		
	}
	
}




