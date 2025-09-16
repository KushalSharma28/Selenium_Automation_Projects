package SeleniumInterviewTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraWebsiteThrowException 
{

	public static void main(String[] args) throws Exception
	{
		// Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");

        // Create ChromeOptions to disable browser notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the Yatra website
        driver.get("https://www.yatra.com");

        // Create WebDriverWait with 10 seconds timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the personal account login popup close button to be clickable and click it
        WebElement closeLoginPopup = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='cross']")));
        closeLoginPopup.click();
        System.out.println("Closed Personal Account login popup.");

        // Wait for the IndiGo ad popup iframe to be present on the page
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']")));

        // Switch to the iframe containing the ad popup
        driver.switchTo().frame(iframe);
        System.out.println("iframe located successfully");

        // Find the close button inside the iframe
        WebElement closeBtn = driver.findElement(By.cssSelector("button[name='close']"));

        // Use JavaScript executor to click the close button to avoid coordinate interception issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
        System.out.println("Closed IndiGo ad popup.");

        // Switch back to the main page content from the iframe
        driver.switchTo().defaultContent();

        // Pause execution for 3 seconds to observe the result (not recommended for production)
        Thread.sleep(3000);

        // Close the browser and end the session
        driver.quit();

	}

}
