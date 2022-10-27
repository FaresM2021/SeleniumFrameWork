package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase 
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "My account")
	WebElement myAccountPageLink;

	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxy;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordTxt;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtn;

	@FindBy(className = "content")
	public WebElement changeResult;
	
	@FindBy(className = "close")
	WebElement closeBtn;
	
	public void openMyAccountPage() 
	{
		clickBtn(myAccountPageLink);
	}

	public void openChangePasswordPage() 
	{
		clickBtn(changePasswordLink);
	}

	public void ChangePassword(String oldPassword, String newPassword) 
	{
		setTextElementTxt(oldPasswordTxt, oldPassword);
		setTextElementTxt(newPasswordTxy, newPassword);
		setTextElementTxt(confirmPasswordTxt, newPassword);
		clickBtn(changePasswordBtn);
		clickBtn(closeBtn);
	}
	
}
