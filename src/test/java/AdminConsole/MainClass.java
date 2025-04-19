package AdminConsole;

import org.openqa.selenium.WebDriver;

public class MainClass 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = DriverManager.getDriver();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("kushalsharmatester@gmail.com", "16161326");
		Thread.sleep(5000);
	
		NavigationPage navigationPage = new NavigationPage(driver);
		navigationPage.navigateToMenu();
		Thread.sleep(5000);
		
		// Key Details
		KeyDetailsTab keydetails = new KeyDetailsTab(driver);
		keydetails.selectKeyDetails();
		
		//keydetails.selectKeyDetails();
		Thread.sleep(5000);
		keydetails.searchUser ("E-EF17214413");
		Thread.sleep(5000);
		//keydetails.selectDropdownOption("1247");
		keydetails.applysetting();
		
		//All details
		/*AllDetailsTab alldetails = new AllDetailsTab(driver);
		alldetails.selectKeyDetails();
		Thread.sleep(5000);
		alldetails.searchUser ("E-D9B13F3B31");
		Thread.sleep(4000);
		alldetails.selectDropdownOption("1247");*/
		
		/*navigationPage.selectKeyDetails();
		Thread.sleep(3000);
		navigationPage.searchUser ("F-E1A7EDFE90");
		navigationPage.selectDropdownOption("1247");*/
		
		// Policy Management Tab
		/*PolicyManagementTab policymanage = new PolicyManagementTab(driver);
		policymanage.selectpolicymanagement();
		Thread.sleep(5000);
		policymanage.searchpolicy("E-D9B13F3B31");
		Thread.sleep(4000);*/
		//policymanage.selectDropdownOption("1247");
		
		navigationPage.logout();
	
	
		DriverManager.closeDriver();
	}

}
