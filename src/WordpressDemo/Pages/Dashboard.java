package WordpressDemo.Pages;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class Dashboard {
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver){
		
		this.driver = driver;
			
	}
	
	
public void verifyTitle(){
		
		String actualTitle = driver.getTitle();		
		
		Assert.assertTrue(actualTitle.contains("Dashboard"));
	}

public void verifyWelcomeMessage(){
	
	String pageText = driver.getPageSource();
	Assert.assertTrue(pageText.contains("Welcome to WordPress!"));
}


}
