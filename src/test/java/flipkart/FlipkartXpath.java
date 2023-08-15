package flipkart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartXpath {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(4000);
		WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
		          close.click(); 
		         
		          
		      driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 14");
		      driver.findElement(By.xpath("submit")).click();
		  WebElement iphone = driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 14 (Purple, 128 GB)')]/parent::div/parent::div[@class='_3pLy-c row']/child::div[@class='col col-5-12 nlI3QM']/child::div/child::div[@class='_25b18c']/child::div[@class='_30jeq3 _1_WHN1']"));
	            String price = iphone.getText();
	            System.out.println(price);
	}
	
	
}
