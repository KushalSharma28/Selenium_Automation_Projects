package SeleniumInterviewTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraWebsiteTryCatchException 
{

	public static void main(String[] args) 
	{
		// Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");

        // Create ChromeOptions to disable browser notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Initialize ChromeDriver with the specified options
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        try {
            // Navigate to the Yatra website
            driver.get("https://www.yatra.com");

            // Create a WebDriverWait object with a 10-second timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // --- Close Personal Account Login Modal ---
            try {
                // Wait until the close button of the login popup is clickable
                WebElement closeLoginPopup = wait.until(
                        ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='cross']")));
                // Click the close button to dismiss the popup
                closeLoginPopup.click();
                System.out.println("Closed Personal Account login popup.");
            } catch (TimeoutException e) {
                // This exception occurs if the popup does not appear within 10 seconds
                System.out.println("Login popup did not appear within timeout.");
            } catch (NoSuchElementException e) {
                // This exception occurs if the close button element is not found in the DOM
                System.out.println("Login popup element not found in DOM.");
            }

            // --- Handle IndiGo Ad Popup inside iframe ---
            try {
                // Wait until the iframe containing the ad popup is present in the DOM
                WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']")));

                // Switch the driver's context to the iframe to interact with elements inside it
                driver.switchTo().frame(iframe);
                System.out.println("iframe located successfully");

                // Find the close button inside the iframe
                WebElement closeBtn = driver.findElement(By.cssSelector("button[name='close']"));

                // Use JavaScript to click the close button to avoid coordinate interception issues
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
                System.out.println("Closed IndiGo ad popup.");

                // Switch back to the main page content from the iframe
                driver.switchTo().defaultContent();
            } catch (TimeoutException e) {
                // This exception occurs if the iframe does not appear within 10 seconds
                System.out.println("Ad popup iframe did not appear within timeout.");
            } catch (NoSuchElementException e) {
                // This exception occurs if the close button inside the iframe is not found
                System.out.println("Ad popup close button not found.");
            }

            // Pause the execution for 3 seconds to observe the result (optional)
            Thread.sleep(3000);

        } catch (Exception e) {
            // Catch any other unexpected exceptions and print the stack trace for debugging
            e.printStackTrace();
        } finally {
            // Quit the driver to close all browser windows and end the WebDriver session
            driver.quit();
        }

	}

}
