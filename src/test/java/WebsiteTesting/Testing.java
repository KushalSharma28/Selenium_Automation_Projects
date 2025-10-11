package WebsiteTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing 
{

	public static void main(String[] args) 
	{
		/*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
		WebDriver driver =new ChromeDriver();
		driver.get("https://khivi.com/");
		List<WebElement> socialicons=driver.findElements(By.xpath("//div[contains(@class,'flex') and contains(@class,'justify-center')]"));
		System.out.println("Print Linkedin");
		socialicons.size();
		
		if(socialicons.size()==5)
		{
			System.out.println("icon found");
		}
		else
		{
			System.out.println("not found");
		}
		driver.quit();*/
		
		// Headless Chrome setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        
        try 
        {
            driver.get("https://kushalsharma28.github.io/My_Portfolio/");

            // Explicit wait for the social icons container to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'flex') and contains(@class,'justify-center')]")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/section[@id='contact']/div/div/div/div[2]/div[1]")));
            
            // Find all link elements within this container (social icons are typically <a> tags inside)
            List<WebElement> socialIcons = driver.findElements(By.tagName("a"));

            System.out.println("✅ Number of social icons found: " + socialIcons.size());

            // Assert expected count, e.g., 5
            if (socialIcons.size() == 2) 
            {
                System.out.println("Social icons count is correct ✔");
            } 
            else 
            {
                System.out.println("Unexpected social icons count ❌ Found: " + socialIcons.size());
            }

        } 
        catch (Exception e) 
        {
            System.out.println("Test failed due to: " + e.getMessage());
        } 
        finally 
        {
            driver.quit();
        }
	}
}
