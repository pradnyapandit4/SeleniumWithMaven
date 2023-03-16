package learn.SeleniumwithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrame2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult"); //switch to outer iframe
		driver.switchTo().frame(0); //switch to inner iframe
		
		System.out.println("Text present inside the inner frame: "+driver.findElement(By.xpath("//h1")).getText());
		
		driver.switchTo().parentFrame(); //go to parent frame/ outer frame
		
		String text = driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attribute to spe')]")).getText();
		
		System.out.println("Text present inside the inner frame: "+text);

	}

}
