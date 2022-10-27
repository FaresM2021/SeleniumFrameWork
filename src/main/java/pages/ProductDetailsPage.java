package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase 
{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailToFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement productPriceLabel;
	
	@FindBy(linkText = "Add your review")
	WebElement reviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;
	
	@FindBy(id ="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void OpenSendEmailFriend() 
	{
		clickBtn(emailToFriendBtn);
	}
	
	public void openAddReview() 
	{
		clickBtn(reviewLink);
	}
	
	public void AddProductToWishList() 
	{
		clickBtn(addToWishListBtn);
	}
	
	public void AddProductToCompareList() 
	{
		clickBtn(addToCompareListBtn);
	}
	
	public void AddProductToCart() 
	{
		clickBtn(addToCartBtn);
	}
}
