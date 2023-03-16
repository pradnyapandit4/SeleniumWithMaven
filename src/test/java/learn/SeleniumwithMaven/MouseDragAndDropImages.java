package learn.SeleniumwithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropImages {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement item1 = driver.findElement(By.xpath("//li[1]"));
		
		WebElement item2 = driver.findElement(By.xpath("//li[2]"));
		
		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions act = new Actions(driver);
		
		//moved both the items in trash
		act.dragAndDrop(item1, trash).perform();
		act.dragAndDrop(item2, trash).perform();

	}

}
