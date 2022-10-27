package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegestretionPage;



public class MyAccountPageTest extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	String oldPassword = "123456";
	String newPassword = "12345678";
	String firstName = "Fares";
	String lastName = "Mkadmini";
	String email ="support.technique125@gmail.com";

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegistreSuccssfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion(firstName, lastName, email, oldPassword);
		Assert.assertTrue(regeisterObject.succssMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void RegisterUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.changeResult.getText().contains("Password was changed"));
	}

	@Test(priority = 3)
	public void RegisterUserCanLogout() 
	{
		regeisterObject.userLogout();
	}

	@Test(priority = 4)
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, newPassword);
		Assert.assertTrue(regeisterObject.logoutLink.isDisplayed());
	}
}
