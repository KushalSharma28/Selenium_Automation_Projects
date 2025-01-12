package TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PVUserLogin 
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
	public void navigationwebsite()
	{
		//Password Vault Website
		driver.get("https://pv.npav.net/Login.aspx?cmp_id=FJ6XVT67");
		driver.manage().window().maximize();
	}
	@Test()
	public void login()
	{
		//Password Vault login 
		//driver.findElements(By.xpath("//*[@id=\"TxtUserId\"]")).sendKeys("kushals@npavteam.net");
		driver.findElement(By.name("txtUserName")).sendKeys("AshokS");
		driver.findElement(By.name("txtPassword")).sendKeys("Ashok@123");
		driver.findElement(By.name("btnLogin")).click();
	}
	@Test(priority=3)
	public void operation()
	{
		driver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]")).click();
		driver.findElement(By.name("txtCokiee")).sendKeys("12966589917785412858851753311800");	
		driver.findElement(By.name("btnConfirmCokiee")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[7]/a/span/i")).click();
		driver.findElement(By.id("chkIsPublicvault")).click();
		driver.findElement(By.id("txtVaultName")).sendKeys("Hello");
		//driver.findElement(By.id("ViewLoginRPT")).click();
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
}
