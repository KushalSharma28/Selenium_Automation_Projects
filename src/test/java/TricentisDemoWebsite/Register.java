package TricentisDemoWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
	private WebDriver driver;

	public Register(WebDriver driver) 
	{
	    this.driver = driver;
	}

	public void Registeration(String fname, String lname, String email, String pwd, String cpwd) {
		//registration
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(fname);
		driver.findElement(By.id("LastName")).sendKeys(lname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(cpwd);
		driver.findElement(By.id("register-button")).click();
	}

}
