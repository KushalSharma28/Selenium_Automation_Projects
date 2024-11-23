package Janfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class VirusTotal 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//virus total website
		driver.get("https://www.virustotal.com/gui/home/upload");
		driver.manage().window().maximize();
		
		//xpath=//input[@id='searchInput'])[1]
		//full xpath=/html/body/vt-ui-shell//uno-navbar//div/div[2]/div[1]/input-autocomplete//div/div/div[2]/input
		//id=searchInput[1]
		
		// Find the search box element
		//WebDriverWait wait = new WebDriverWait(driver, 10);
        
		//WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/vt-ui-shell//uno-navbar//div/div[2]/div[1]/input-autocomplete//div/div/div[2]/input")));
		//WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput'])[1]")); //*[@id=\"searchInput\"][1]
		//WebElement searchBox = driver.findElement(By.id("searchInput[1]"));
		//WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));
		
		//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//String xpath = "/html/body/vt-ui-shell//uno-navbar//div/div[2]/div[1]/input-autocomplete//div/div/div[2]/input";
		//String script = "return document.evaluate('" + xpath + "', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";
		//WebElement searchBox = (WebElement) jsExecutor.executeScript(script);
		
		// Locate the search input element
		WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput'])[1]"));

		// Use JavaScriptExecutor to focus and click on the element
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].focus(); arguments[0].click();", searchInput);
		
		
		// Locate the search input element
		//WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput'])[1]"));

		// Focus on the search input element
		//searchInput.click();

		// Alternatively, you can use the Actions class to focus and click on the element
		Actions actions = new Actions(driver);
		actions.moveToElement(searchInput).click().perform();
		
		//WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-input")));
		
		//enter the search item
		//searchBox.sendKeys("");
        
		//WebElement searchButton = driver.findElement(By.id("search-button"));
        //searchButton.click();
        
        // Close the browser
        //driver.quit();
	}

}
