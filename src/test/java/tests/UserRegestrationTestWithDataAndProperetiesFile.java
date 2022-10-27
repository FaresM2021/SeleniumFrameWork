package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.loadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestretionPage;

public class UserRegestrationTestWithDataAndProperetiesFile extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	String firstname = loadProperties.userData.getProperty("firstname");
	String lastname = loadProperties.userData.getProperty("lastname");
	String email = loadProperties.userData.getProperty("email");
	String password = loadProperties.userData.getProperty("password");

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegistreSuccssfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion(firstname, lastname, email, password);
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
		loginObject.userLogin(email, password);
		Assert.assertTrue(regeisterObject.logoutLink.isDisplayed());
	}
}
