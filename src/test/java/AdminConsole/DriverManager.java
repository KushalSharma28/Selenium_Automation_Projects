package AdminConsole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager 
{
	private static WebDriver driver;

    public static WebDriver getDriver() 
	{
        if (driver == null) 
        {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver();
           driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver() 
	{
        if (driver != null) 
        {
            driver.quit();
            driver = null;
        }
    }
}
