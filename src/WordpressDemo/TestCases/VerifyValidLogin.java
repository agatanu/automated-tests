package WordpressDemo.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WordpressDemo.Helper.BrowserFactory;
import WordpressDemo.Pages.Dashboard;
import WordpressDemo.Pages.LoginPage;
import WordpressDemo.Pages.TopMenu;

public class VerifyValidLogin {
	
	WebDriver driver;
	
	@BeforeClass
	public void start(){
		
		System.out.println("Valid login test has just started!");
		
	}
	
	
	@BeforeTest
	public void browserSetup(){
		
		driver = BrowserFactory.startBrowser("chrome", "http://demosite.center/wordpress/wp-login.php");
	}
	
	@Test (priority=1)
	public void checkValidUser(){
	
	LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
	Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
	
	login_page.loginToWordpress();
	dashboard.verifyTitle();
	dashboard.verifyWelcomeMessage();
	
	}
	
	@Test (priority=2)
	public void logOutUser(){
	
	LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);	
	TopMenu top_menu = PageFactory.initElements(driver, TopMenu.class);
	
	top_menu.logOut();
	login_page.verifyThatUserIsLoggedOut();
	
	}
	
	@AfterTest
	public void quitBrowser(){
		
		driver.quit();
	}

	@AfterClass
	
	public void finish(){
		
		
		System.out.println("Test is finished");
	}
}
