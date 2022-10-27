package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegestretionPage;

public class EmailFriendTest extends TestBase 
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailObject;
	EmailPage emailObject;
	
	// 1-User registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegistreSuccssfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion("Fares", "Mkadmini", "support.technique126@gmail.com", "123456");
		Assert.assertTrue(regeisterObject.succssMessage.getText().contains("Your registration completed"));
	}
	
	// 2-Search Product
	@Test(priority = 2)
	public void UserCanSearchProductsWithAutoComplet()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.SearchProductUsingAutoComplet("MacB");
			detailObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailObject.productNameBreadCrumb.getText(), productName);			
		} catch (Exception e) {
			System.out.println("Error occured" + e.getMessage());
		}
	}

	// 3-Send email to friend
	@Test(priority = 3)
	public void RegistredUserCanSendProductToFriend() 
	{
		detailObject.OpenSendEmailFriend();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend("aaa@test.com", "hello welcom to test automation");
		Assert.assertTrue(emailObject.messageNotifction.getText().contains("Your message has"));
	}

	
	// 4-User Logout
	@Test(priority = 4)
	public void RegisterUserCanLogout() 
	{
		regeisterObject.userLogout();
	}

}
