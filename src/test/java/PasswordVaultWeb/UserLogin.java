package PasswordVaultWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserLogin {

	public static void main(String[] args) {
		//Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:/Users/Supporting files/chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
						
				//MSEdge Driver
				//System.setProperty("webdriver.edge.driver", "C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
							
				WebDriver driver = new ChromeDriver();
								
				driver.get("https://pv.npav.net/Login.aspx?cmp_id=FJ6XVT67");
				driver.manage().window().maximize();
						
				//driver.findElements(By.xpath("//*[@id=\"TxtUserId\"]")).sendKeys("kushals@npavteam.net");
				driver.findElement(By.name("txtUserName")).sendKeys("AshokS");
				driver.findElement(By.name("txtPassword")).sendKeys("Ashok@123");
				driver.findElement(By.name("btnLogin")).click();
						
				driver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]")).click();
				driver.findElement(By.name("txtCokiee")).sendKeys("12966589917785412858851753311800");	
				driver.findElement(By.name("btnConfirmCokiee")).click();
				driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[7]/a/span/i")).click();
				driver.findElement(By.id("chkIsPublicvault")).click();
				driver.findElement(By.id("txtVaultName")).sendKeys("Hello");
				//driver.findElement(By.id("ViewLoginRPT")).click();
						
				/*
				 * driver.findElement(By.name("email")).sendKeys("kushalsharmaji2@gmail.com");
				 * driver.findElement(By.name("pass")).sendKeys("Kushal@npav");
				 * driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div/div/form/div[3]/button")).click();
				*/

	}

}
