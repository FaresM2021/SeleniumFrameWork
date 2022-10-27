package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestretionPage;

public class UserRegestrationTestWithDataAndJSon extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegistreSuccssfully() throws IOException, ParseException 
	{
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion(jsonReader.firstName, jsonReader.lastName, jsonReader.email, jsonReader.password);
		Assert.assertTrue(regeisterObject.succssMessage.getText().contains("Your registration completed"));
		regeisterObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(regeisterObject.logoutLink.isDisplayed());
		regeisterObject.userLogout();
	}
}
