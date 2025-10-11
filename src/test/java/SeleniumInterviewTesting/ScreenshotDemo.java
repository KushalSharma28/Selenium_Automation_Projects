package SeleniumInterviewTesting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ScreenshotDemo 
{
    public static void main(String[] args) 
    {
        // If your environment needs it, uncomment and set the path:
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            ensureFolder("./screenshots");

            driver.get("https://www.selenium.dev/");

            // Wait for a visible, stable element (header navigation)
            WebElement downloadsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Downloads")));

            // Take a page screenshot
            takePageScreenshot(driver, "./screenshots/selenium-home-" + timestamp() + ".png");

            // Take an element screenshot (Selenium logo in header)
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Selenium']")));
            takeElementScreenshot(logo, "./screenshots/selenium-logo-" + timestamp() + ".png");

            // Optional: click and capture another page
            downloadsLink.click();
            wait.until(ExpectedConditions.titleContains("Downloads"));
            takePageScreenshot(driver, "./screenshots/selenium-downloads-" + timestamp() + ".png");

            System.out.println("Screenshots saved in ./screenshots");
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

    // Save the current viewport as a PNG file
    private static void takePageScreenshot(WebDriver driver, String filePath) throws IOException 
    {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(filePath));
    }

    // Save a specific web element as a PNG file
    private static void takeElementScreenshot(WebElement element, String filePath) throws IOException 
    {
        File src = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(filePath));
    }

    // Ensure output folder exists
    private static void ensureFolder(String folderPath) throws IOException 
    {
        Path path = Path.of(folderPath);
        if (!Files.exists(path)) 
	{
            Files.createDirectories(path);
        }
    }

    // Timestamp for unique filenames
    private static String timestamp() 
    {
        return new SimpleDateFormat("yyyyMMdd-HHmmss-SSS").format(new Date());
    }
}
