package Janfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}
