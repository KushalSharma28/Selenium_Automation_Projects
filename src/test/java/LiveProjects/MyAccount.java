package LiveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccount {

	public static void main(String[] args) 
	{
		//Chrome Webdriver Path
		System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
						
		WebDriver driver = new ChromeDriver();
						
				//My Account Website
		driver.get("https://myaccount.npav.net/login");
		driver.manage().window().maximize();
					
				//My Account login 
		driver.findElement(By.name("email")).sendKeys("kushalsharmatester@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Kushal@npav");
		driver.findElement(By.className("login100-form-btn")).click();
				
				//logout account from profile
		driver.findElement(By.xpath("/html/body/app-root/app-navbarvertical/div/mat-toolbar/div[3]/mat-menu")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/a[4]/div")).click();

	}

}
