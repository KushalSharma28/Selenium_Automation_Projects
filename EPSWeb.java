package TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EPSWeb 
{
	private WebDriver driver;

    @BeforeClass
    public void setUp() 
    {
        // Set the path for the Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority=1)
    public void navigatewebsite() throws InterruptedException 
    {
        // Navigate to the EPSWeb page
        driver.get("https://epsweb.adminconsole.net/");
        Thread.sleep(5000);
    }
    @Test(priority=2)
    public void login() throws InterruptedException
    {
        // Perform login
        driver.findElement(By.name("EmailId")).sendKeys("kushalsharmatester@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("Password")).sendKeys("16161326");
        Thread.sleep(2000);
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(10000);
    }
    @Test(priority=3)
    public void navigatemenu() throws InterruptedException
    {
        // Click on menu toggle
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/ul/li[1]/a/i")).click();
        Thread.sleep(3000);
        
        // Select all details tab
        driver.findElement(By.cssSelector(".feather-monitor")).click();
        Thread.sleep(8000);

        // Search the user in all details
        driver.findElement(By.xpath("//*[@id=\"tbl_alldetails_filter\"]/label/input")).sendKeys("");
        Thread.sleep(3000);

        // Select Key using checkbox
        driver.findElement(By.cssSelector(".SelectedChk")).click();
        Thread.sleep(2000);

        // Select Policy for Key
        driver.findElement(By.id("select2-ddlpolicy-container")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("Null Policy");
        Thread.sleep(3000);

        // Logout from profile Menu
        driver.findElement(By.id("imagelogout")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".ti-lock.text-muted.mr-2")).click();
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() 
    {
        // Close the browser
        if (driver != null) 
        {
            driver.close();
        }
    }
	/*
	 * void openwebsite() { driver.get("https://epsweb.adminconsole.net/"); }
	 */
}
