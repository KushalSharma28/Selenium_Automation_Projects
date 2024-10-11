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
		driver.findElement(By.xpath("//*[@id=\"tblKeyDet_filter\"]/label/input")).sendKeys("V-EFCA8EA698");
		driver.findElement(By.cssSelector(".#tblKeyDet_filter")).sendKeys("V-EFCA8EA698");

		// Select Key using checkbox		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".SelectedChk")).click();

		// Select Policy for Key
		
		//driver.findElement(By.cssSelector(".select2-selection__arrow")).click();
	    	driver.findElement(By.id("select2-ddlpolicy-container")).click();
	    
		//WebElement element = driver.findElement(By.id("select2-ddlpolicy-container"));
		//element.click();
		//element.sendKeys("KushalS Null Policy");
	    
		//driver.findElement(By.id("select2-ddlpolicy-container")).text("KushalS Null Policy");
		driver.findElement(By.cssSelector("select2-search__field")).sendKeys("KushalS Null Policy");
		
		
		//select2-ddlpolicy-result-ib7e-1209
		
		// logout from profile Menu
		//driver.findElement(By.id("imagelogout")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.cssSelector(".ti-lock.text-muted.mr-2")).click();
	    
	    Thread.sleep(3000);
	    driver.close();
		
		// driver.findElement(By.xpath("//*[@id=\"V-EFCA8EA698\"]")).click();
		// WebElement checkBox = driver.findElement(By.id("V-EFCA8EA698")); 
																     }
		// logout from profile Menu
		//driver.findElement(By.xpath("//*[@id="menuss"]")).click();
		//driver.findElement(By.xpath("//*[@id="menuss"]/li/a[5]/i")).click();
	}

}
