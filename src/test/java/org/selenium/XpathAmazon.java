package org.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAmazon {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	          search.sendKeys("mobiles");
	          
	     WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']")); 
	         searchButton.click();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	   WebElement  checkbox = driver.findElement(By.xpath("//div[@id='brandsRefinements']/child::ul/child::span/child::li[@id='p_89/Redmi']/descendant::a/descendant::label/child::i[@class='a-icon a-icon-checkbox']"));

       checkbox.click();
	}
	
}
