package learn.SeleniumwithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionVsActions {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		WebElement features = driver.findElement(By.xpath("//a[@title='Women']"));
		
		Actions act = new Actions(driver);  //Actions == class
		//act.moveToElement(features).perform();
		//act.moveToElement(features).build().perform();
		
		Action action = act.moveToElement(features).build();  //Action == interface
		action.perform();

	}

}
