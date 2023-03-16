package learn.SeleniumwithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_DropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='dob']")).click(); //opens the date picker
		
		//month and year selection
		Select month_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drp.selectByVisibleText("Oct");
		
		Select year_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drp.selectByVisibleText("1990");
		
		String date = "10";
		
		//Date Selection
		List <WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calender']//td"));
		
		for(WebElement ele:allDates)
		{
			String dt = ele.getText();
			
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}

	}

}
