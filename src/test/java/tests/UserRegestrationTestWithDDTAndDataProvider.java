package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestretionPage;

public class UserRegestrationTestWithDDTAndDataProvider extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	
	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"Fares", "Mkadmini", "m.testData42@gmail.com", "123456"},
			{"Omar", "Aziz", "m.dataTest1@gmail.com", "12345678"}
			};			
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void UserCanRegistreSuccssfully(String fname, String lname, String email, String password) 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion(fname, lname, email, password);
		Assert.assertTrue(regeisterObject.succssMessage.getText().contains("Your registration completed"));
		regeisterObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(regeisterObject.logoutLink.isDisplayed());
		regeisterObject.userLogout();
	}
}
