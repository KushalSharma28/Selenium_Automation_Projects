package WebsiteTesting;

import org.openqa.selenium.By;
//import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class TricentisVehicleInsuranceWebsite 
{

	public static void main(String[] args) 
	{
			
		//driver define
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
		        
		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();
		        
		//maximize windows
		driver.manage().window().maximize();

		// Define explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		//navigate to url
		driver.get("https://www.sparkstone.co.nz/sampleapp/101/index.php");
		
		driver.findElement(By.id("nav_automobile")).click();
		driver.findElement(By.id("nav_truck")).click();
		driver.findElement(By.id("nav_motorcycle")).click();
		driver.findElement(By.id("nav_camper")).click();
		
		driver.close();
	}

}
