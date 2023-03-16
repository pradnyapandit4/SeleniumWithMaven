package learn.SeleniumwithMaven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Full page screenshot
		
		/*TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\homepage.png");
		FileUtils.copyFile(src, trg);*/
		
		//Screenshot of section/portion of the page
		/*WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File src = section.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\featuredproducts.png");
		FileUtils.copyFile(src, trg);*/
		
		//Screenshot of section/portion of the page
		WebElement ele= driver.findElement(By.xpath("//img[@alt='nopcommerce demo store']"));
		
		File src = ele.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, trg);
		
		
		driver.close();

	}

}
