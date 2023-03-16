package learn.SeleniumwithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://itera-qa.azurwebsites.net/home/automation");
		
		//1)Select specific check box
		driver.findElement(By.xpath("//input[@id='monday']")).click(); // monday
		
		//2)Select all the check boxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		System.out.println("Total no of check boxes: "+checkboxes.size());
		
		//using for loop
		
		/*for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}*/
		
		//using for...each loop
		
		/*for(WebElement chbox:checkboxes)
		{
			chbox.click();
		}*/
		
		//3) select multiple check boxes by choice - Monday and sunday
		
		/*for(WebElement chbox:checkboxes)
		{
			String checkboxname = chbox.getAttribute("id");
			if(checkboxname.equals("monday") || checkboxname.equals("sunday"))
			{
				chbox.click();
			}
		}*/
		
		//4) select last 2 check boxes
		//total no of check boxes - no of check boxes want to select = starting index : 7-2=5 
		
		int totalcheckboxes = checkboxes.size();
		
		/*for(int i=totalcheckboxes-2;i<totalcheckboxes;i++)
		{
			checkboxes.get(i).click();
		}*/
		
		//5) select first 2 check boxes
		
		for(int i=0;i<totalcheckboxes;i++)
		{
			if(i<2)
			{
				checkboxes.get(i).click();
			}
		}

	}

}
