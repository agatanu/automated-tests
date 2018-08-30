package WordpressDemo.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WordpressDemo.Helper.BrowserFactory;
import WordpressDemo.Pages.AddNewPostPage;
import WordpressDemo.Pages.Dashboard;
import WordpressDemo.Pages.LoginPage;
import WordpressDemo.Pages.SideMenu;

public class AddAndDeleteANewPost {
	
	WebDriver driver;
	
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
	public void openAddANewPostPage(){
		
		SideMenu side_menu = PageFactory.initElements(driver, SideMenu.class);
		side_menu.goToAddANewPostPage();
	}
	
	@Test (priority=3)
	public void savePostDraft(){
		
		AddNewPostPage add_new_post_page = PageFactory.initElements(driver, AddNewPostPage.class);
		
		add_new_post_page.verifyTitle();
		add_new_post_page.saveAsDraftWithTextOnly();
	}
	

}
	
