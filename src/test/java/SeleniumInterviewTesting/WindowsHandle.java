package SeleniumInterviewTesting;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle {

	public static void main(String[] args) {
		// Setup ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open the Selenium Playground
        driver.get("https://www.lambdatest.com/selenium-playground");

        // Maximize the window
        driver.manage().window().maximize();

        // Click on "Window Popup Modal"
        driver.findElement(By.linkText("Window Popup Modal")).click();

        // Click on "Follow On Twitter" which opens a new tab
        driver.findElement(By.linkText("Follow On Twitter")).click();

        // Store the parent window handle
        String parentWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Child Window Title: " + driver.getTitle());

                // Close the child window
                driver.close();
            }
        }

        // Switch back to the parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window Title: " + driver.getTitle());

        // Close the parent window
        driver.quit();

	}

}
