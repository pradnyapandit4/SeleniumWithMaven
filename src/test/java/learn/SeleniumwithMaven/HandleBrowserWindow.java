package learn.SeleniumwithMaven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//getWindowhandle() - return id of the single browser window
		
		//String windowID = driver.getWindowHandle();
		//System.out.println(windowID);
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click(); //opens another browser window-child window
		
		//getWindowhandles() - return ids of multiple browser windows
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		//First method - iterator()
		
		/*Iterator<String> it = windowIDs.iterator();
		
		String parentWindowID = it.next();
		String childWindowID = it.next();
		
		System.out.println("Parent window ID: "+parentWindowID);
		System.out.println("Child Window ID: "+childWindowID);*/
		
		//Second method - using List/ArrayList
		
		List<String> windowIDsList = new ArrayList();//converting set --> list
		
		/*String parentWindowID = windowIDsList.get(0); //parent window id
		String childWindowID = windowIDsList.get(1);  //child window id
		
		System.out.println("Parent window ID: "+parentWindowID);
		System.out.println("Child Window ID: "+childWindowID);
		
		// how to use window ID's for switching
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window title: "+driver.getTitle()); //OrangeHRM
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child window title: "+driver.getTitle()); //HR Management System | HR Management Software | OrangeHRM
		*/
		
		//For each loop
		/*for(String winid:windowIDsList)
		{
			//System.out.println(winid);
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println(title);
		}*/
		
		//driver.close(); //close single browser window which is pointing driver
		
		//driver.quit(); //close all the browser windows
		
		for(String winid:windowIDsList)
		{
			String title = driver.switchTo().window(winid).getTitle();
			//if(title.equals("OrangeHRM") || title.equals("another title"))
			
			if(title.equals("OrangeHRM"))
			{
				driver.close();
			}
		}

	}

}
