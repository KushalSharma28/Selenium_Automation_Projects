package AdminConsole;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllDetailsTab 
{
	private WebDriver driver;

    public AllDetailsTab(WebDriver driver) 
	{
        this.driver = driver;
    }
    public void selectKeyDetails() 
	{
        driver.findElement(By.cssSelector(".feather-monitor")).click();
        System.out.println("All Details Tab Selected Successfully");
    }
    public void searchUser (String userKey) 
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".tbl_alldetails_filter"))); 
        WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/section/div[1]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/div/label/input"))); 
        filterElement.sendKeys(userKey);
        System.out.println("Search User Successfully");
        
      //WebElement searchfilter = driver.findElement(By.cssSelector(".tbl_alldetails_filter"));
      		//searchfilter.click();
      		//searchfilter.sendKeys("V-1EC04AE979");
    }
    public void selectDropdownOption(String optionValue) 
	{
        //driver.findElement(By.cssSelector(".SelectedChk")).click();
        //driver.findElement(By.xpath("//*[@id=\"E-D9B13F3B31\"]")).click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"E-D9B13F3B31\"]")));
    	//WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".SelectedChk")));
    	//WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.id("E-D9B13F3B31")));
        option.click();
        System.out.println("Select User Successfully");
        driver.findElement(By.id("select2-ddlpolicy-container")).click(); 
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='" + optionValue + "']")));
        option1.click();
        
        // Close the dropdown
        driver.findElement(By.xpath("//body")).click(); 
        
        // Locate the button using class name
        //WebElement applyButton = driver.findElement(By.xpath("//button[@onclick='AssignPolicy()']"));

        // Click the button
       	//applyButton.click();
	}
}
