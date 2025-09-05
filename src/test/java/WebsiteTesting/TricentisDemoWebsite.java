package WebsiteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TricentisDemoWebsite {

	public static void main(String[] args) throws InterruptedException {
		//driver define
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        //maximize windows
        driver.manage().window().maximize();

        //navigate to url
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("ico-register")).click(); 
		
		//registration
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Kushal");
		driver.findElement(By.id("LastName")).sendKeys("Sharma");
		driver.findElement(By.id("Email")).sendKeys("kushalsharmatester@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("kushal@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("kushal@123");
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(5000);
		
		//login
		driver.findElement(By.id("Email")).sendKeys("kushalsharmatester@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("kushal@123");
		
		driver.quit();
	}

}
