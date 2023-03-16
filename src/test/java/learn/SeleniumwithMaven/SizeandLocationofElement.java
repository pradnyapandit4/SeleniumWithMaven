package learn.SeleniumwithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeandLocationofElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
		//Location - method1
		System.out.println("Location(x,y): "+logo.getLocation());
		System.out.println("Location(x,y): "+logo.getLocation().getX());
		System.out.println("Location(x,y): "+logo.getLocation().getY());
		
		//Location - method2
		System.out.println("Location(x,y): "+logo.getRect().getX());
		System.out.println("Location(x,y): "+logo.getRect().getY());
		
		//Size - method1
		System.out.println("Size(Width,Height): "+logo.getSize());
		System.out.println("Size(Width): "+logo.getSize().getWidth());
		System.out.println("Size(Height): "+logo.getSize().getHeight());
		
		//Size - method2
		System.out.println("Size(Width): "+logo.getRect().getDimension().getWidth());
		System.out.println("Size(Height): "+logo.getRect().getDimension().getHeight());

	}

}
