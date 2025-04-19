package LiveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EPSWeb {

	public static void main(String[] args) throws InterruptedException
	{
		//Chrome Webdriver Path
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kushal Sharma\\Desktop\\Supporting files\\chromedriver.exe");
				// old "C:/Users/Supporting files/chromedriver.exe"
						
				//Firefox Webdriver Path
				//System.setProperty("webdriver.gecko.driver", "C:/Users/Supporting files/geckodriver.exe");
				//System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
						
				//chrome driver
				WebDriver driver = new ChromeDriver();
						
				//firefox driver
				//FirefoxDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				    
				//epsweb webpage
				driver.get("https://epsweb.adminconsole.net/");
				
				Thread.sleep(5000);
				//epsweb login
				driver.findElement(By.name("EmailId")).sendKeys("kushalsharmatester@gmail.com");
				Thread.sleep(1000);
				driver.findElement(By.name("Password")).sendKeys("16161326");
				Thread.sleep(2000);
				driver.findElement(By.id("btnSubmit")).click(); 
				Thread.sleep(10000);
				 
				//click on menu toggle
				driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/ul/li[1]/a/i")).click();
				
				Thread.sleep(3000);
				//select keydetails tab
				//driver.findElement(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/a/span")).click(); 
				
				//select all details tab
				//driver.findElement(By.xpath("/html/body/div[2]/aside/section/ul/li[3]/a/svg")).click();
				driver.findElement(By.cssSelector(".feather-monitor")).click();
				// //*[@id=\"alldetailstab\"]/a/svg
				
				Thread.sleep(8000);
				// search the user in key details
				//driver.findElement(By.xpath("//*[@id=\"tblKeyDet_filter\"]/label/input")).sendKeys("V-1EC04AE979");
				
				// search the user in all details
				driver.findElement(By.xpath("//*[@id=\"tbl_alldetails_filter\"]/label/input")).sendKeys("");
						
				// Select Key using checkbox		
				
				Thread.sleep(3000);
				driver.findElement(By.cssSelector(".SelectedChk")).click();
				
				Thread.sleep(2000);
				
				// Select Policy for Key
				driver.findElement(By.id("select2-ddlpolicy-container")).click();
				
				Thread.sleep(2000);
				
				driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("Null Policy");
				
				Thread.sleep(3000);
				
				// logout from profile Menu
				driver.findElement(By.id("imagelogout")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector(".ti-lock.text-muted.mr-2")).click();
					    
				Thread.sleep(3000);
				driver.close();		
	}

}
