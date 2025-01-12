package TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PVAdminLogin 
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
	@Test(priority=2)
	public void login()
	{
		//Password Vault login 
		driver.findElement(By.name("txtUserName")).sendKeys("Kushal");
		driver.findElement(By.name("txtPassword")).sendKeys("Kushal@npav");
		driver.findElement(By.name("btnLogin")).click();
	}
	@Test(priority=3)
	public void operation()
	{
		driver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]")).click();
		//driver.switchTo().alert().accept();
		driver.findElement(By.name("txtCokiee")).sendKeys("12966589917785412858851753311800");	
		driver.findElement(By.name("btnConfirmCokiee")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[1]/a")).click();
		//driver.findElement(By.id("ViewLoginRPT")).click();
		driver.findElement(By.xpath("//*[@id=\"btnNewUser\"]")).click();
	
		Select ddlUserType = new Select(driver.findElement(By.id("ddlUserType")));
		ddlUserType.selectByVisibleText("Standard User");
	
		Select ddltwofactor = new Select(driver.findElement(By.id("ddltwofactor")));
		ddltwofactor.selectByVisibleText("OFF");
	
		driver.findElement(By.id("txtUserName")).sendKeys("AshokS");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("Ashok@123");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]")).click();
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
