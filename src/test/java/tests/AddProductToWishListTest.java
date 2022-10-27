package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailObject;
	WishListPage wishListObject;

	@Test(priority = 1)
	public void UserCanSearchProductsWithAutoComplet()
	{
			searchObject = new SearchPage(driver);
			searchObject.SearchProductUsingAutoComplet("MacB");
			detailObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailObject.productNameBreadCrumb.getText().contains(productName));		
	}

	@Test(priority = 2)
	public void UserCanAddProductToWishList() 
	{
		detailObject = new ProductDetailsPage(driver);
		detailObject.AddProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishListObject = new WishListPage(driver);
		Assert.assertTrue(wishListObject.wishListHeader.isDisplayed());
		Assert.assertTrue(wishListObject.productCell.getText().contains(productName));
	}

	@Test(priority = 3)
	public void UserCanRemoveProductFromWishList() 
	{
		wishListObject = new WishListPage(driver);
		wishListObject.removeProductFromWishList();
		Assert.assertTrue(wishListObject.EmeptyCartMessage.getText().contains("The wishlist"));
	}
}
