package PasswordVaultWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminLogin {

	public static void main(String[] args) {
		//Chrome Webdriver Path
				System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				
				WebDriver driver = new ChromeDriver();
				
				//Password Vault Website
				driver.get("https://pv.npav.net/Login.aspx?cmp_id=FJ6XVT67");
				driver.manage().window().maximize();
				
				//Password Vault login 
				driver.findElement(By.name("txtUserName")).sendKeys("Kushal");
				driver.findElement(By.name("txtPassword")).sendKeys("Kushal@npav");
				driver.findElement(By.name("btnLogin")).click();
				
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
				//driver.findElement(By.xpath("//*[@id=\"ModalNewUser\"]/div/div/div[2]/div[8]/div/div/button[2]")).click();

	}

}
