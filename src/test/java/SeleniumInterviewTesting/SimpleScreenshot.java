package SeleniumInterviewTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class SimpleScreenshot {

	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open a real website
        driver.get("https://www.selenium.dev/");

        // Take screenshot and save to local machine
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("selenium-home.png"));

        driver.quit();
        System.out.println("Screenshot saved as selenium-home.png");
	}

}
