package TricentisDemoWebsite;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHomePage {
	private WebDriver driver;
	
	public NavigationHomePage(WebDriver driver) 
    {
        this.driver = driver;
    }
	public void NavigateToRegisterButton()  
	{
		//navigate to url
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-register")).click(); 
        System.out.println("Navigate to Register Successfully");
    }
	public void NavigateToLoginButton() 
	{
		//navigate to url
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click(); 
        System.out.println("Navigate to Login Successfully");
    }
	public void NavigationToShoppingCart()
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-cart")).click();
		System.out.println("Navigate to Shopping Cart Successfully");
	}
	public void NavigateToWishlist()
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-wishlist")).click();
		System.out.println("Navigate to Wishlist Successfully");
	}
}
