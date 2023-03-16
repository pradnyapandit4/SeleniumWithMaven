package learn.SeleniumwithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		
		//to switch to frame
		//-->driver.switchTo().frame(name of the frame/id of the frame)
		// -->driver.switchTo().frame(WebElement)
		//-->driver.switchTo().frame(0)
		
		//first frame
		driver.switchTo().frame("packageListFrame"); //name of the frame
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent(); //go back to the main page
		
		Thread.sleep(3000);
		
		//2 iframe
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		driver.switchTo().defaultContent(); //go back to the main page
		
		Thread.sleep(5000);
		
		//3 iframe
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click(); //Help
		

	}

}
