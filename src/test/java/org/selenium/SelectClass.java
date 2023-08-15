package org.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

      public static void main(String[] args) throws InterruptedException {
		
    	  
    	  WebDriverManager.chromedriver().setup();
    	  
    	  WebDriver driver = new ChromeDriver();
    	  
    	  driver.get("https://www.facebook.com/");
    	  
    	 WebElement account =  driver.findElement(By.xpath("//a[text() = 'Create new account']"));
    	 
    	 account.click();
    	 
    	 Thread.sleep(3000);
    	 
    	 WebElement months = driver.findElement(By.xpath("//select[@id='month']"));
    	 
    	 //Select class
    	 
    	 Select s = new Select(months); 
    	 
    	 s.selectByValue("4");
    	 s.selectByIndex(0);
    	 s.selectByVisibleText("Feb");
    	
    	 Boolean multiple = s.isMultiple();
    	 System.out.println(multiple);
    	
    	 
    	 //getoptions
    	   List<WebElement> opt = s.getOptions();
    	   
    	   int size = opt.size();
    	   System.out.println(size);
    	  
	
        //Print all options available in drop down using text
    	   for (int i = 0; i < size; i++) {
			      WebElement t = opt.get(i);
			      String text = t.getText();
			      System.out.println(text);
		}
      
      
      
      
      }

}

