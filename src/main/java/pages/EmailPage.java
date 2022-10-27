package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement emailFriendTxt;

	@FindBy(id = "PersonalMessage")
	WebElement personalMessagetxt;

	@FindBy(name = "send-email")
	WebElement sendEmailBtn;

	@FindBy(css = "div.result")
	public WebElement messageNotifction;

	public void SendEmailToFriend(String emailFriend, String personalMess) 
	{
		setTextElementTxt(emailFriendTxt, emailFriend);
		setTextElementTxt(personalMessagetxt, personalMess);
		clickBtn(sendEmailBtn);
	}
}
