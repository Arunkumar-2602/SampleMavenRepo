package dataProviderinTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestNG {

	public static WebDriver driver;
	
	@BeforeTest
	public void brower() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	String [][] data = {
			{"Admin","admin123"}
			
	};
	
	@DataProvider(name="loginData")
	public String[][] loginDataProvider() {
		
		return data;
	}
	
	@Test(dataProvider ="loginData" ) 
	public void Login(String uName,String PWord) {
		 
		
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(uName);
		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys(PWord);
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		 
	 }
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}

