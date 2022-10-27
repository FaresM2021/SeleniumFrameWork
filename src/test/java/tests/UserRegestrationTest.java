package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestretionPage;

public class UserRegestrationTest extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegistreSuccssfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion("Fares", "Mkadmini", "support.technique12345@gmail.com", "123456");
		Assert.assertTrue(regeisterObject.succssMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = "UserCanRegistreSuccssfully")
	public void RegisterUserCanLogout() 
	{
		regeisterObject.userLogout();
	}
	
	@Test(dependsOnMethods = "RegisterUserCanLogout")
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("support.technique12345@gmail.com", "123456");
		Assert.assertTrue(regeisterObject.logoutLink.isDisplayed());
	}
}
