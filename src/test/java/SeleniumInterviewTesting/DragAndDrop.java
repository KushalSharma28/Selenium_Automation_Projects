package SeleniumInterviewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException
	{
		// Set up ChromeDriver (make sure chromedriver is in your PATH)
		System.setProperty("webdriver.chrome.driver", "D:/Supporting files/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Navigate to a real-time drag-and-drop demo site
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        
        // Switch to the frame containing the draggable elements
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        
        // Locate source (draggable) and target (droppable) elements
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        
        // Perform drag and drop using Actions class
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
        
        // Verification step (optional but good for interviews)
        String textAfterDrop = target.getText();
        if (textAfterDrop.equals("Dropped!")) {
            System.out.println("✅ Drag and Drop successful!");
        } else {
            System.out.println("❌ Drag and Drop failed!");
        }
        
        Thread.sleep(2000);
        driver.quit();

	}

}
