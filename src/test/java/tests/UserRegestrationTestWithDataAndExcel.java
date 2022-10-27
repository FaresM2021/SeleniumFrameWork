package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestretionPage;

public class UserRegestrationTestWithDataAndExcel extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	
	@DataProvider(name = "ExcelData")
	public Object[][] UserRegisterData() throws IOException
	{
		// Get data from Excel reader class
		ExcelReader Er = new ExcelReader();
			return Er.getExcelData();
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
	public void UserCanRegistreSuccssfully(String firstName, String lastName, String email, String password) 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion(firstName, lastName, email, password);
		Assert.assertTrue(regeisterObject.succssMessage.getText().contains("Your registration completed"));
		regeisterObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(regeisterObject.logoutLink.isDisplayed());
		regeisterObject.userLogout();
	}

}
