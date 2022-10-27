package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductsToComapreTest extends TestBase 
{
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondeProductName = "Asus N551JK-XO076H Laptop";
	
	// 1-Search product number 1
	// 2-Search product number 2
	// 3-Add to Compare page
	// 4-Clear list
	
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;
	
	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException 
	{
		detailsObject = new ProductDetailsPage(driver);
		searchObject = new SearchPage(driver);
		compareObject = new ComparePage(driver);
		
		searchObject.SearchProductUsingAutoComplet("MacB");
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompareList();
		
		searchObject.SearchProductUsingAutoComplet("Asus");
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().contains(secondeProductName));
		detailsObject.AddProductToCompareList();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.isDisplayed());
		Assert.assertTrue(compareObject.secondeProductName.isDisplayed());
		compareObject.CompareProducts();
	}
	
	@Test(priority = 2)
	public void UserCanClearCompareList() 
	{
		compareObject.ClearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
	
}
