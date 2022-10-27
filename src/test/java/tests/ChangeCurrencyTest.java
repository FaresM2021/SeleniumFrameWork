package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase 
{
	HomePage home;
	ProductDetailsPage details;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;

	@Test(priority = 1)
	public void UserCanChangeCurrency() 
	{
		home = new HomePage(driver);
		home.changeCurrency();
	}

	@Test(priority = 2)
	public void UserCanSearchProductsWithAutoComplet()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.SearchProductUsingAutoComplet("MacB");
			details = new ProductDetailsPage(driver);
			Assert.assertTrue(details.productPriceLabel.getText().contains("€"));
			System.out.println(details.productPriceLabel.getText());
		} catch (Exception e) {
			System.out.println("Error occured" + e.getMessage());
		}
	}
}