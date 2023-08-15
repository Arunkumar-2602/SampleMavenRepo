package org.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.spicejet.com/");
		
		String parentW = driver.getWindowHandle();
		System.out.println(parentW);
		Thread.sleep(3000);
		
		 WebElement hotel =	driver.findElement(By.xpath("//div[text()='Hotels']"));
			hotel.click();

			
			
		 Set<String> allWindows = driver.getWindowHandles();
		 System.out.println(allWindows);
		 
//		 for (String x : allWindows) {
//			 if (!parentW.equals(x)) {
//				driver.switchTo().window(x);
//				
//				Thread.sleep(3000);
//				 WebElement printText = driver.findElement(By.xpath("//h1[@class='title']"));
//			         String text = printText.getText();
//			         System.out.println(text);
//			}
//			 
//		 }
		 //Copy all set values into list using addAll method
		 List<String> li = new ArrayList<String>();
		    li.addAll(allWindows);
		    //fetch the second window id -> parent windo id is 0
		    String x = li.get(1);
		    driver.switchTo().window(x);
		    Thread.sleep(3000);
			 WebElement printText = driver.findElement(By.xpath("//h1[@class='title']"));
		         String text = printText.getText();
		         System.out.println(text);
		         //again switch to parent window and print login text
		         driver.switchTo().window(parentW);
		         WebElement loginText = driver.findElement(By.xpath("//div[text()='Login']"));
	                  String printLogin = loginText.getText();
	                  System.out.println(printLogin);
	
	}
	
	
}
