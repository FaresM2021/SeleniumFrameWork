package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegestretionPage;

public class RegistredUserCheckoutProductsTest extends TestBase 
{
	// 1- Register User
	// 2- Search for product
	// 3- Add to cart
	// 4- Logout

	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailPage orderObject;

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegistreSuccssfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion("Fares", "Mkadmini", "support.technique43475@gmail.com", "123456");
		Assert.assertTrue(regeisterObject.succssMessage.getText().contains("Your registration completed"));
	}

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

	@Test(priority = 3)
	public void UserCanAddProductsToShoppingCart() throws InterruptedException 
	{
		detailObject = new ProductDetailsPage(driver);
		detailObject.AddProductToCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.totallbl.getText().contains("$3,600.00"));
	}

	@Test(priority = 4)
	public void UserCanCheckoutProtuct() throws InterruptedException 
	{
		checkoutObject = new CheckoutPage(driver);
		cartObject.OpenCheckoutPage();
		checkoutObject.RegistredUserCheckoutProduct("Tunisia", "test", "123456", "6458625", "Beja", productName);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.ConfirmOrder();
		Assert.assertTrue(checkoutObject.thankYouMessage.isDisplayed());
		checkoutObject.printOrder();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailPage(driver);
		orderObject.DownloadOrderDetails();
		orderObject.PrintOrderDetails();
	}

	@Test(priority = 5)
	public void RegisterUserCanLogout() 
	{
		regeisterObject.userLogout();
	}
}