package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailObject;
	ShoppingCartPage cartObject;
	
	@Test(priority = 1)
	public void UserCanSearchProductsWithAutoComplet()
	{
			searchObject = new SearchPage(driver);
			searchObject.SearchProductUsingAutoComplet("MacB");
			detailObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailObject.productNameBreadCrumb.getText().contains(productName));		
	}
	
	@Test(priority = 2)
	public void UserCanAddProductsToShoppingCart() throws InterruptedException 
	{
		detailObject = new ProductDetailsPage(driver);
		detailObject.AddProductToCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.totallbl.getText().contains("$3,600.00"));
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() 
	{
		cartObject = new ShoppingCartPage(driver);
		cartObject.RemoveProductFromCart();
	}
}
