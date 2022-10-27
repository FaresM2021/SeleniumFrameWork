package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;

	@FindBy(id = "addproductrating_4")
	WebElement rating4RadBtn;
	
	@FindBy(name = "add-review")
	WebElement submitReview;

	@FindBy(css = "div.result")
	public WebElement reviewNotification;
	
	public void AddProductReview(String reviewTitle, String reviewMessage) 
	{
		setTextElementTxt(reviewTitleTxt, reviewTitle);
		setTextElementTxt(reviewTxt, reviewMessage);
		clickBtn(rating4RadBtn);
		clickBtn(submitReview);
	}
}
