package TricentisDemoWebsite;

import org.openqa.selenium.WebDriver;


public class HomePage {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = DriverManager.getDriver();
		
		NavigationHomePage navigatehome = new NavigationHomePage(driver);
		
		navigatehome.NavigateToRegisterButton();
//		Register register = new Register(driver);
//		register.Registeration("Kushal", "Sharma", "kushalsharmatester@gmail.com", "kushal@123", "kushal@123");
		
		navigatehome.NavigateToLoginButton();
//		Login login=new Login(driver);
//		Thread.sleep(2000);
//		login.login("kushalsharmatester@gmail.com", "kushal@123");	
//		Thread.sleep(5000);
		
		navigatehome.NavigationToShoppingCart();
		navigatehome.NavigateToWishlist();
		driver.quit();
	}

}
