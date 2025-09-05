package WebsiteTesting;

//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchSuggestions {

	public static void main(String[] args) throws InterruptedException {
		// Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Animal");
		Thread.sleep(3000);
		List <WebElement> lst=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		//List <WebElement> lst=driver.findElements(By.xpath("//div[@jsname='erkvQe']//ul[@role='listbox']"));
		//System.out.println(lst.get(1));

		for(WebElement option : lst) 
        {
            if(option.getText().equalsIgnoreCase("\"animal drawing\"")); 
            {
                option.click();
                break;
            }
        }

	}

}
