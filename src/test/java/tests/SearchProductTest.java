package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase 
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailObject;

	@Test
	public void UserCanSearchForProduct() 
	{
		searchObject = new SearchPage(driver);
		detailObject = new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetails();
		Assert.assertTrue(detailObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		//Assert.assertEquals(detailObject.productNameBreadCrumb.getText(), productName);
	}

}
