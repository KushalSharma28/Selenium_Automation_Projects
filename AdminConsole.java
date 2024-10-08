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

		//epsweb login
		driver.findElement(By.name("EmailId")).sendKeys("santoshs@npav.net");
		driver.findElement(By.name("Password")).sendKeys("cclm789");
		driver.findElement(By.id("btnSubmit")).click();
		thread.sleep(5000);

		//click on the menu toggle
		driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/ul/li/[i]/a/i")).click();

		//select key-details tab
		driver.findElement(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/a/span")).click();

		// search the user in key details
		driver.findElement(By.xpath("//*[@id=\"tblKeyDet_filter\"]/label/input")).sendKeys("kushal");
		
		driver.findElement(By.xpath("//*[@id=\"V-EFCA8EA698\"]")).click();
		WebElement checkBox = driver.findElement(By.id("V-EFCA8EA698")); 
		if (!checkBox.isSelected()) 
		{ 
			checkBox.setSelected(true); 
		}
													     }
		// logout from profile Menu
		//driver.findElement(By.xpath("//*[@id="menuss"]")).click();
		//driver.findElement(By.xpath("//*[@id="menuss"]/li/a[5]/i")).click();
	}

}
