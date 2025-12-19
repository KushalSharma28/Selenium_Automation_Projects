package ParabankWebsiteTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParabankWebsiteTryCatchException 
{
	public static void main(String[] args) 
	{

        // 1. Launch Browser
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 2. Open Application
            driver.manage().window().maximize();
            driver.get("https://parabank.parasoft.com");

            // 3. Login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("john");

            driver.findElement(By.name("password")).sendKeys("demo");

            driver.findElement(By.xpath("//input[@value='Log In']")).click();

            // 4. Validate successful login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log Out']")));
            System.out.println("Login successful");

            // 5. Store parent window
            String parentWindow = driver.getWindowHandle();

            // 6. Open new tab - Open Accounts Overview
            ((JavascriptExecutor) driver).executeScript("window.open('https://parabank.parasoft.com/parabank/overview.htm','_blank');");

            // 7. Switch to newly opened tab
            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) 
            {
                if (!window.equals(parentWindow)) 
                {
                    driver.switchTo().window(window);
                }
            }

            // 8. Work on second tab
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Accounts Overview']")));
            System.out.println("Accounts Overview page opened in new tab");

            // 9. Close current tab
            driver.close();

            // 10. Switch back to parent tab
            driver.switchTo().window(parentWindow);

            // 11. Open another tab - Transfer Funds
            ((JavascriptExecutor) driver).executeScript("window.open('https://parabank.parasoft.com/parabank/transfer.htm','_blank');");

            // 12. Switch to transfer funds tab
            for (String window : driver.getWindowHandles()) 
            {
                if (!window.equals(parentWindow)) 
                {
                    driver.switchTo().window(window);
                }
            }

            // 13. Validate Transfer Funds page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Transfer Funds']")));
            System.out.println("Transfer Funds page opened");

            // 14. Close Transfer Funds tab
            driver.close();

            // 15. Switch back to main window
            driver.switchTo().window(parentWindow);

            // 16. Logout
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Log Out']"))).click();
            System.out.println("Logout successful");

            // 17. Close browser window
            driver.close();

        } 
        finally 
        {
            // 18. Quit WebDriver session (closes all windows & ends driver process)
            driver.quit();
            System.out.println("Driver quit completed");
        }
    }
}
