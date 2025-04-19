package AdminConsole;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyDetailsTab 
{
	private WebDriver driver;

    public KeyDetailsTab(WebDriver driver) 
	{
        this.driver = driver;
    }
    public void selectKeyDetails() 
	{
        driver.findElement(By.cssSelector(".feather-key")).click();
        System.out.println("Key Details Selected Successfully");
    }
    public void searchUser (String userKey) 
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/section/div[1]/div/div/div[2]/div[2]/div/div/div/div[1]/div[3]/div/label/input")));
        filterElement.sendKeys(userKey);
        System.out.println("User Enter Successfully");
        //driver.findElement(By.cssSelector(".SelectedChk")).click();
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement option = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/section/div[1]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr/td[2]/div/input"))); //*[@id=\"E-EF17214413\"]
        // WebElement option = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".SelectedChk")));
    	//WebElement option = wait1.until(ExpectedConditions.elementToBeClickable(By.id("E-D9B13F3B31")));
    	//WebElement option = wait1.until(ExpectedConditions.elementToBeClickable(By.className("SelectedChk")));
        option.click();
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/section/div[1]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr/td[2]/div/input")).click();
        System.out.println("User Selected Successfully");
    }
    public void selectDropdownOption(String optionValue) 
	{
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	//WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/section/div[1]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr/td[2]/div/input"))); //*[@id=\"E-EF17214413\"]
        // WebElement option = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".SelectedChk")));
    	//WebElement option = wait1.until(ExpectedConditions.elementToBeClickable(By.id("E-D9B13F3B31")));
    	//WebElement option = wait1.until(ExpectedConditions.elementToBeClickable(By.className("SelectedChk")));
        //option.click();
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/section/div[1]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr/td[2]/div/input")).click();
        System.out.println("User Selected Successfully");
    	
        driver.findElement(By.id("select2-ddlpolicy-container")).click();
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='" + optionValue + "']")));
        option1.click();
        
        // Close the dropdown
        driver.findElement(By.xpath("//body")).click(); 
        
        // Locate the button using class name
        WebElement applyButton = driver.findElement(By.xpath("//button[@onclick='AssignPolicy()']"));

        // Click the button
       	applyButton.click();
    }
    public void applysetting() throws InterruptedException 
    {
    	Thread.sleep(5000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"settingsDropdownToggle\"]")));
    	option.click();
    	System.out.println("Go to setting");
        
    	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement option1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"settingsDropdown\"]/a[1]")));
    	option1.click();
    	System.out.println("Command Setting Selected Successfully");
    	
    	//WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement option2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("chkUpdateNow")));
    	option2.click();
    	System.out.println("Update Setting Applied Successfully");
    }
}
