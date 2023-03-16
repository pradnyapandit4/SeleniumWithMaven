package learn.SeleniumwithMaven;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//How to capture cookies from browser?
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies: "+cookies.size());
		
		//How to print cookies from browser?
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		//How to add cookie to the browser?
		Cookie cookieobj = new Cookie("MyCookie123", "123456");
		driver.manage().addCookie(cookieobj);
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after adding: "+cookies.size());
		
		//How to delete specific cookie from the browser?
		//driver.manage().deleteCookie(cookieobj);
		driver.manage().deleteCookieNamed("MyCookie123");
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after deletion: "+cookies.size());
		
		//How to delete all the cookies from browser?
		driver.manage().deleteAllCookies();
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookies after deletion: "+cookies.size());
		
		driver.quit();

	}

}
