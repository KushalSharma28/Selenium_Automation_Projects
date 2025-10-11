package SeleniumInterviewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload 
{
	public static void main(String[] args) throws InterruptedException
	{
		// Set up ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        	WebDriver driver = new ChromeDriver();
        
        	// Navigate to a real-time file upload demo site
        	driver.get("https://the-internet.herokuapp.com/upload");
        	driver.manage().window().maximize();
        
        	// Locate the file input element
        	WebElement uploadInput = driver.findElement(By.id("file-upload"));
        
        	// Provide the absolute path of the file to upload
        	String filePath = System.getProperty("user.dir") + "/testdata/sample.txt";
        	uploadInput.sendKeys(filePath);
        
        	// Click the upload button
        	driver.findElement(By.id("file-submit")).click();
        
        	// Verification step
        	String uploadedFileName = driver.findElement(By.id("uploaded-files")).getText();
        	if (uploadedFileName.equals("sample.txt")) 
		{
            		System.out.println("✅ File uploaded successfully!");
        	} 
		else 
		{
            		System.out.println("❌ File upload failed!");
        	}
        
        	Thread.sleep(2000);
        	driver.quit();
	}
}
