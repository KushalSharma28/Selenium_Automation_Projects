package LiveProjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShubhCommunication 
{
	
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
        // Set the path for the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
     // Set implicit wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Wait for up to 10 seconds
        
        try {
            // Open the website
            driver.get("https://shubhcommunication.com/");
            
         // Set up WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
         // Wait for the source and target elements to be visible
            WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'dragger_arrow')]"))); 
            WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'drag_tips')]")));

            // Locate the source and target elements
            //WebElement source = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div[3]/div[1]/div[2]/div[2]")); 
          //*[@id=\"Intro\"]/div/div[2]/div[3]/div[1]/div[2]/div[2] // //*[contains(@class, 'dragger_arrow')] 
            //WebElement target = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div[3]/div[2]")); 
          //*[@id=\"Intro\"]/div/div[2]/div[3]/div[2] // //*[contains(@class, 'drag_tips')]

            // Create an instance of Actions class
            Actions actions = new Actions(driver);

            // Perform drag and drop
            //actions.dragAndDrop(source, target).perform();
            
            actions.clickAndHold(source).moveToElement(target).release().build().perform();
            
        } 
        catch (Exception e) {
            // Print the exception message
            System.out.println("An error occurred: " + e.getMessage());
        }
       finally {
    	   
    	   
            // Close the browser
            driver.quit();
        }
    }
}
