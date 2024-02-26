package stepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class Loginstep extends Base {
	LoginPage login=new LoginPage();
    
	@When("user enter correct {string} and {string}")
	public void user_enter_correct_and(String uname, String pass) {
	    login.user_enter_correct_username_and_password(uname, pass);
	}

	@When("user enter incorrect {string} and {string}")
	public void user_enter_incorrect_and(String uname, String pass) {
		login.user_enter_correct_username_and_password(uname, pass);  
	}

	@When("user click on login button")
	public void user_click_on_login_button() throws InterruptedException {
	    login.user_click_on_login_button();
	}

	@Then("validate sucessful login")
	public void validate_sucessful_login() {
	    assertTrue(login.validate_sucessful_login());
	}
	
	@Then("validate error message")
	public void validate_error_message() {
		WebElement error=driver.findElement(By.xpath("//h3[@data-test='error']"));
		String E=error.getText();
		
		assertTrue(E.contains("Epic sadface"));
	}
	}
