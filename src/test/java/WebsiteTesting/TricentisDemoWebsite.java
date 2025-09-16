package WebsiteTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TricentisDemoWebsite {

	public static void main(String[] args) throws InterruptedException {
		//driver define
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        
        //maximize windows
        driver.manage().window().maximize();

        // Define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //navigate to url
		driver.get("https://demowebshop.tricentis.com/");
//		Thread.sleep(2000);
//		driver.findElement(By.className("ico-register")).click();
		
		/*
		// Wait until register link is clickable and click
        WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("ico-register")));
        registerLink.click();
		
		//registration
		//driver.findElement(By.id("gender-male")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-male"))).click();
		driver.findElement(By.id("FirstName")).sendKeys("Kushal");
		driver.findElement(By.id("LastName")).sendKeys("Sharma");
		driver.findElement(By.id("Email")).sendKeys("kushalsharmatester@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("kushal@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("kushal@123");
		//driver.findElement(By.id("register-button")).click();
		
		// Click Register
        wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button"))).click();
		//Thread.sleep(5000);*/
		
		// Wait until register link is clickable and click
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("ico-login")));
        loginLink.click();
		
		//login
		driver.findElement(By.id("Email")).sendKeys("kushalsharmatester@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("kushal@123");
		driver.findElement(By.xpath("(//input[@value='Log in'])[1]")).click();
		
		// Wait for registration to complete (e.g., wait for logout button to appear or confirmation message)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ico-logout")));
		
		//driver.quit();
	}

}
