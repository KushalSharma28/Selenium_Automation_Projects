package WebsiteTesting;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParabankWebsite {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		

	}

}
