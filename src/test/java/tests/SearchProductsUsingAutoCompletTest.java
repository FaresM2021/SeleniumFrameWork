package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductsUsingAutoCompletTest extends TestBase
{

	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailObject;
	
	@Test
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

}
