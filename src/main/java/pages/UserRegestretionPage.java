package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegestretionPage extends PageBase {

	public UserRegestretionPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement gendrRadioBtn;

	@FindBy(id = "FirstName")
	WebElement firstNamedTxtBox;

	@FindBy(id = "LastName")
	WebElement lastNameTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement PasswordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "div.result")
	public WebElement succssMessage;

	@FindBy(linkText  = "Log out")
	public WebElement logoutLink;
	
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	public void userRegestretion(String firstName, String lastName, String email, String password) 
	{
		clickBtn(gendrRadioBtn);
		setTextElementTxt(firstNamedTxtBox, firstName);
		setTextElementTxt(lastNameTxtBox, lastName);
		setTextElementTxt(emailTxtBox, email);
		setTextElementTxt(PasswordTxtBox, password);
		setTextElementTxt(confirmPassword, password);
		clickBtn(registerBtn);
	}

	public void userLogout() 
	{
		clickBtn(logoutLink);
	}
	
	public void openMyAccount() 
	{
		clickBtn(myAccountLink);
	}
}
