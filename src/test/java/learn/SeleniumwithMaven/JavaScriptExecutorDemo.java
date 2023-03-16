package learn.SeleniumwithMaven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		//Syntax
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript(Script, args);
		
		
		//Flash
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopcommerce demo store']"));
		JavaScriptUtil.flash(logo, driver);
		
		//Drawing border and take SS
//		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopcommerce demo store']"));
//		JavaScriptUtil.drawBorder(logo, driver);
//		
//		TakesScreenshot ts =(TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File trg = new File(".\\screenshots\\logo.png");
//		FileUtils.copyFile(src, trg);
		
		//Getting title of the page
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);
		
		//Click action
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		//regLink.click();
		JavaScriptUtil.clickElementByJS(regLink, driver);
		
		//Generate alert
		JavaScriptUtil.generateAlert(driver, "This is my Alert...");
		
		//Refreshing the page
		JavaScriptUtil.refreshBrowserByJS(driver);
		
		//Scrolling down page
		JavaScriptUtil.scrollPageDown(driver);
		
		Thread.sleep(4000);
		
		//Scroll up page
		JavaScriptUtil.scrollPageUp(driver);
		
		//Zoom page
		JavaScriptUtil.zoomPageByJS(driver);
		

	}

}
