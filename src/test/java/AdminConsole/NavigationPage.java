package AdminConsole;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage 
{
	private WebDriver driver;
	
	public NavigationPage(WebDriver driver) 
    {
        this.driver = driver;
    }
    public void navigateToMenu() 
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-link-icon.mdi.mdi-menu.text-dark")));
        element.click();
        System.out.println("Navigate to Menu Successfully");
    }
    public void navigateToKeyDetails() throws InterruptedException 
    {
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/ul/li[1]/a/i")).click();
        driver.findElement(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/a/span")).click();
        System.out.println("Navigate to Key Details Successfully");
    }
    public void logout() throws InterruptedException 
    {
        //driver.findElement(By.id("#imagelogout")).click();
    	//driver.findElement(By.xpath("//*[@id=\"imagelogout\"]")).click(); 
    	driver.findElement(By.id("imagelogout"));
        Thread.sleep(3000);
    	driver.findElement(By.xpath("//i[contains(@class, 'ti-lock') and contains(@class, 'text-muted') and contains(@class, 'mr-2')]"));
        //driver.findElement(By.cssSelector("i.ti-lock.text-muted.mr-2")).click();
        //driver.findElement(By.xpath("//*[@id=\"menuss\"]/li/a[5]")).click();
        Thread.sleep(3000);
        System.out.println("Logout Successfully");
    }
}
