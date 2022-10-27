package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement ContactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropDownList;
	
	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement NoteBoksMenu;

	public void openRegestrationPage() 
	{
		//registerLink.click();
		clickBtn(registerLink);
	}

	public void openLoginPage() 
	{
		clickBtn(loginLink);
	}

	public void openContactUsPage() 
	{
		scrolltoBottom();
		clickBtn(ContactUsLink);
	}
	
	public void changeCurrency() 
	{
		select = new Select(currencyDropDownList);
		select.selectByIndex(1);
	}
	
	public void selectNoteBooksMenu() 
	{
		action.moveToElement(computerMenu).moveToElement(NoteBoksMenu).build().perform();
	}
}
