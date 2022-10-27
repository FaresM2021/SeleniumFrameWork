package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestretionPage;
import tests.TestBase;

public class UserRegistration extends TestBase
{
	HomePage homeObject;
	UserRegestretionPage regeisterObject;
	LoginPage loginObject;
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegestrationPage();
	}
	
	@When("I click on register link")
	public void i_click_on_register_link() 
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	/*
	 * @When("I entred the user data") public void i_entred_the_user_data() {
	 * regeisterObject = new UserRegestretionPage(driver);
	 * regeisterObject.userRegestretion("Fares", "Mkadmini",
	 * "m.mohamed523@gmail.com", "123456"); }
	 */
	
	@When("I entred {string} , {string} , {string} , {string}")
	public void i_entred(String firstname, String lastname, String email, String password)
	{
		regeisterObject = new UserRegestretionPage(driver);
		regeisterObject.userRegestretion(firstname, lastname, email, password);
	}
	
	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() 
	{
		regeisterObject.userLogout();
	}
}
