package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestretionPage;

public class UserRegestrationTestWithDataAndCSV extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	CSVReader reader;
	
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegistreSuccssfully() throws CsvValidationException, IOException 
	{
		//Get path of CSV file
		String CSV_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserDataSheet1.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String[] csvCell;
		
		// While loop will be executed till the last value in CSV file
		while ((csvCell = reader.readNext()) != null) 
		{
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
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
}
