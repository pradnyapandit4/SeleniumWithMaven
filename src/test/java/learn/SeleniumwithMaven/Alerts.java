package learn.SeleniumwithMaven;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Alert window with OK button
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		*/
		
		//Alert window with OK and Cancel button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept(); //close alert by using OK button
		driver.switchTo().alert().dismiss(); //close alert by using Cancel button
		
		//Alert window with input box, capture text from alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert alertwindow = driver.switchTo().alert();
		System.out.println("The message displayed on alert: "+alertwindow.getText());
		Thread.sleep(3000);
		alertwindow.sendKeys("Welcome");
		Thread.sleep(3000);
		alertwindow.accept();
		
		

	}

}
