package learn.SeleniumwithMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * how many rows in table
 * how many columns in table
 * retrieve the specific row/column data
 * retrieve all the data from the table
 * print release date, versionNo of java language of Selenium
 */
public class WebTable1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		//1)how many rows in table
		int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println("Total no of rows in a table: "+rows);
		
		//2)how many columns in table
		int cols = driver.findElements(By.xpath("//table[@class='data-list']//thead/tr/th")).size();
		System.out.println("Total no of columns in a table: "+cols);
		
		//3) retrieve the specific row/column data
		String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
		System.out.println("The value is"+ value);
		
		//4)retrieve all the data from the table
		/*System.out.println("Data from the Table.....");
		for(int r=1;r<=rows;r++) //1 2
		{
			for(int c=1;c<=cols;c++) //1 2 3 4 5 6...
			{
				String data = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td["+c+"]")).getText();
				System.out.println(data+"       ");
			}
			System.out.println();
		}*/
		
		//5)print release date, versionNo of java language of Selenium
		for(int r=1;r<=rows;r++)
		{
			String language = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[1]")).getText();
			if(language.equals("Java"))
			{
				String versionno = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[2]")).getText();
				String releasedate = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[3]")).getText();
				System.out.println(language+"    "+ versionno+"    "+ releasedate);
			}
		}
		
		driver.quit();

	}

}
