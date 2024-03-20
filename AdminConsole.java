package Janfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.*;

public class AdminConsole 
{
	public static void main(String[] args) 
	{
		//Chrome Webdriver Path
		System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");
				
		//Firefox Webdriver Path
		//System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				
		//chrome driver
		WebDriver driver = new ChromeDriver();
				
		//firefox driver
		//FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
						
		//epsweb webpage
		driver.get("https://epsweb.adminconsole.net/");
		driver.findElement(By.name("EmailId")).sendKeys("amey@npav.net");
		driver.findElement(By.name("Password")).sendKeys("npav1");
		driver.findElement(By.id("btnSubmit")).click();
				
	}

}
