package TricentisDemoWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver;

	public Login(WebDriver driver) 
	{
	    this.driver = driver;
	}

	public void login(String email, String pwd) {
		//login
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("(//input[@value='Log in'])[1]")).click();
	}
}
