package ParabankWebsiteTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParabankWebsiteThrowException 
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open ParaBank
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Login
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        username.sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

        // Wait for dashboard to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Accounts Overview")));

        // Open a new tab and navigate to a different page
        ((JavascriptExecutor) driver).executeScript("window.open('https://parabank.parasoft.com/parabank/bank/transfer.htm','_blank');");
        String originalTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) 
        {
            if (!tab.equals(originalTab)) 
            {
                driver.switchTo().window(tab);
                break;
            }
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("amount")));

        // Switch back to original tab
        driver.switchTo().window(originalTab);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Accounts Overview")));

        // Logout
        driver.findElement(By.linkText("Log Out")).click();
        wait.until(ExpectedConditions.urlContains("index.htm"));

        // Close all tabs and quit browser
        for (String tab : driver.getWindowHandles()) 
        {
            driver.switchTo().window(tab);
            driver.close();
        }
        driver.quit();
	}
}
