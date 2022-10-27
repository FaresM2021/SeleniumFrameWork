package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstNamedTxtBox;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastNameTxtBox;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxtBox;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement adressTxtBox;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxtBox;
	
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingmethod;
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement continuePaymentBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement continueInfoBtn;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "h1")
	public WebElement thankYouMessage;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;
	
	@FindBy(css = "div.title")
	public WebElement successMessage;
	
	public void RegistredUserCheckoutProduct(String countryName, String address, String postecode, String phone, String city, String productNumber ) throws InterruptedException 
	{
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementTxt(cityTxtBox, city);
		setTextElementTxt(adressTxtBox, address);
		setTextElementTxt(zipCode, postecode);
		setTextElementTxt(phoneNumberTxtBox, phone);
		clickBtn(continueBtn);
		clickBtn(shippingmethod);
		clickBtn(continueShippingBtn);
		Thread.sleep(1000);
		clickBtn(continuePaymentBtn);
		Thread.sleep(1000);
		clickBtn(continueInfoBtn);
	}
	
	public void ConfirmOrder() throws InterruptedException 
	{
		Thread.sleep(2000);
		clickBtn(confirmBtn);
	}
	
	public void printOrder() 
	{
		clickBtn(orderDetailsLink);
	}
}
