package WebsiteTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class YatraWebsite {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try 
        {
            driver.get("https://www.yatra.com");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // --- Close Personal Account Login Modal ---
            try 
            {
                WebElement closeLoginPopup = wait.until(
                        ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='cross']")));
                closeLoginPopup.click();
                System.out.println("Closed Personal Account login popup.");
            } 
            catch (TimeoutException e) 
            {
                System.out.println("Login popup did not appear within timeout.");
            } 
            catch (NoSuchElementException e) 
            {
                System.out.println("Login popup element not found in DOM.");
            }

            // --- Handle IndiGo Ad Popup inside iframe ---
            try {
                
            //WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[id^='webklipper-publisher-widget-container']")));
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']")));
            	driver.switchTo().frame(iframe);
            	System.out.println("iframe locate sucessfully");

                //WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='close'] svg")));
            	//WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='close']//*[name()='path']")));
                //closeBtn.click();
            	
            	//Use JavaScript click This bypasses coordinate interception entirely
            	WebElement closeBtn = driver.findElement(By.cssSelector("button[name='close']"));
            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);

                System.out.println("Closed IndiGo ad popup.");

                driver.switchTo().defaultContent();
            } 
            catch (TimeoutException e) 
            	{
                System.out.println("Ad popup iframe did not appear within timeout.");
            } 
            catch (NoSuchElementException e) 
            {
                System.out.println("Ad popup close button not found.");
            }

            Thread.sleep(3000);

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            driver.quit();
        }
	}
}
