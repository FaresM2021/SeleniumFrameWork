package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.remove-btn")
	WebDriver removeBtn;

	@FindBy(id = "updatecart")
	WebElement upadateBtn;

	@FindBy(id = "itemquantity11228")
	public WebElement quantityTxt;

	@FindBy(css= "td.subtotal")
	public WebElement totallbl;
	
	@FindBy(id = "termsofservice")
	public WebElement agreeCheckBox;
	
	@FindBy(id= "checkout")
	public WebElement checkoutBtn;

	public void RemoveProductFromCart() 
	{
		clickBtn(upadateBtn);
	}
	
	public void OpenCheckoutPage() 
	{
		clickBtn(agreeCheckBox);
		clickBtn(checkoutBtn);
	}

	public void UpdateProductQuantityInCart(String quantity) 
	{
		clearTxt(quantityTxt);
		setTextElementTxt(quantityTxt, quantity);
		clickBtn(upadateBtn);
	}
}
