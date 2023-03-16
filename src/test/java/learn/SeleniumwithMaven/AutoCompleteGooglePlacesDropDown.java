package learn.SeleniumwithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click(); //live posting
		
		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		
		searchBox.clear();
		Thread.sleep(3000);
		
		searchBox.sendKeys("toronto");
		Thread.sleep(3000);
		
		String text;
		
		do
		{
			searchBox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			
			text = searchBox.getAttribute("value");
			
			if(text.equals("Toronto, OH, USA"))
			{
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(3000);
			
		}while(!text.isEmpty());

	}

}
