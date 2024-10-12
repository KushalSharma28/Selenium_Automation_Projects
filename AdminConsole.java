package Janfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.*;

public class AdminConsole 
{
	public static void main(String[] args) throws InterruptedException
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
						
		// EPS Website
		driver.get("https://epsweb.adminconsole.net/");
                Thread.sleep(5000);
		
		// EPS Website login
		driver.findElement(By.name("EmailId")).sendKeys("santoshs@npav.net");
		// driver.findElement(By.name("EmailId")).sendKeys("santoshs@npav.net");
		Thread.sleep(1000);
		driver.findElement(By.name("Password")).sendKeys("cclm789");
		// driver.findElement(By.name("Password")).sendKeys("cclm789");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(10000);

		// Click on the Menu toggle
		driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/ul/li/[i]/a/i")).click();
		Thread.sleep(3000);

		// Select Key-details tab
		driver.findElement(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/a/span")).click();
		Thread.sleep(8000);
		
		// Search the user in key details
		driver.findElement(By.xpath("//*[@id=\"tblKeyDet_filter\"]/label/input")).sendKeys("V-EFCA8EA698");
		// driver.findElement(By.xpath("//*[@id=\"tblKeyDet_filter\"]/label/input")).sendKeys("V-1EC04AE979");
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector(".#tblKeyDet_filter")).sendKeys("V-EFCA8EA698");

		// Select Key using checkbox		
		driver.findElement(By.cssSelector(".SelectedChk")).click();
		Thread.sleep(2000);
		// Select Policy for Key
		
		//driver.findElement(By.cssSelector(".select2-selection__arrow")).click();
	    	driver.findElement(By.id("select2-ddlpolicy-container")).click();
		Thread.sleep(2000);
	    
		//WebElement element = driver.findElement(By.id("select2-ddlpolicy-container"));
		//element.click();
		//element.sendKeys("KushalS Null Policy");
	    
		//driver.findElement(By.id("select2-ddlpolicy-container")).text("KushalS Null Policy");
		//driver.findElement(By.cssSelector("select2-search__field")).sendKeys("KushalS Null Policy");
		
		// Click on Dropdown
		WebElement dropdown = driver.findElement(By.id("select2-ddlpolicy-container"));
		dropdown.click();
		Thread.sleep(4000);
		
		// Select the Dropdown value
		WebElement option = driver.findElement(By.xpath("//option[@value='1209']"));
		// WebElement option = driver.findElement(By.xpath("//option[@value='1247']"));
		option.click();
		
		// Close the dropdown
		driver.findElement(By.xpath("//body")).click();
		Thread.sleep(3000);
		
		//select2-ddlpolicy-result-ib7e-1209
		
		// logout from profile Menu
		driver.findElement(By.id("imagelogout")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ti-lock.text-muted.mr-2")).click();
	    
	    	Thread.sleep(3000);
	    	driver.close();																     }
		
	}

}
