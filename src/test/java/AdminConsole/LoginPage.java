package AdminConsole;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
	    this.driver = driver;
	}

	public void login(String email, String password)  
	{
	    	
	  	driver.get("https://epsweb.adminconsole.net/");
	    driver.findElement(By.name("EmailId")).sendKeys(email);
	    driver.findElement(By.name("Password")).sendKeys(password);
	    driver.findElement(By.id("btnSubmit")).click();
	    System.out.println("Login Success");
	}
}
