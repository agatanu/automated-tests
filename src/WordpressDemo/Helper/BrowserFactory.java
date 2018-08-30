package WordpressDemo.Helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Agata\\Selenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Agata\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.edge.driver","C:\\Users\\Agata\\Selenium\\Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
		
	}
	
}
