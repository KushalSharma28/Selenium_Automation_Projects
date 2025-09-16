package SeleniumInterviewTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdownHandle {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");

		Thread.sleep(4000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));

		for(WebElement option : options) 
        {
            if(option.getText().equalsIgnoreCase("India")) 
            {
                option.click();
                break;
            }
        }
        // Close the driver
       // driver.quit();
	}
}
