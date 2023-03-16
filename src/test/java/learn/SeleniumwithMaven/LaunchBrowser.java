package learn.SeleniumwithMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chrome driver\\chromedriver.exe");		
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/"); 
		
		System.out.println("Title of the web page: "+driver.getTitle());
		
		System.out.println("Current URL of the web page: "+driver.getCurrentUrl());
		
		System.out.println(driver.getPageSource());

	}

}
