package learn.SeleniumwithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
		String year = "2023";
		String month = "July";
		String date = "10";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click(); //opens the date picker
		
		while(true)
		{
			String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			
			if(mon.equalsIgnoreCase(month) && yr.equals(year))
				break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();

		}
		
		//Date Selection
		List <WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		for(WebElement ele:allDates)
		{
			String dt= ele.getText();
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}

	}

}
