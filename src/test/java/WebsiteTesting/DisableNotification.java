package WebsiteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DisableNotification {

	public static void main(String[] args) 
	{
		// Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        
		// Configure ChromeOptions to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        
     // Open Yatra.com
        driver.get("https://www.yatra.com");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Interact with the 'Departure' calendar widget
        WebElement departureDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("BE_flight_origin_date")));
        departureDate.click();

        // Wait for the calendar widget to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("month-wrapper")));

        // Locate the calendar for the current month
        WebElement calendar = driver.findElement(By.className("month-wrapper"));

        // Get all the fare elements from the calendar
        List<WebElement> fareElements = calendar.findElements(By.xpath(".//td[@class='fare']/a"));

        // Initialize variables to track the minimum fare
        int minFare = Integer.MAX_VALUE;
        String minFareDate = "";

        // Loop through each fare element to find the minimum fare
        for (WebElement fareElement : fareElements) 
        {
            String fareText = fareElement.getText().replace(",", ""); // Remove commas from fare
            int fare = Integer.parseInt(fareText);

            // Check if the current fare is the lowest so far
            if (fare < minFare) 
            {
                minFare = fare;
                minFareDate = fareElement.getAttribute("data-date"); // Get the date for the fare
            }
        }

        // Print the lowest fare and its corresponding date
        System.out.println("Lowest Fare: ₹" + minFare);
        System.out.println("Date: " + minFareDate);
        
        driver.quit();

	}
}