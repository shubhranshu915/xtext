package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import helper.Base;

public class LoginPage extends Base {
	
	public void user_enter_correct_username_and_password(String username,String password)  {
		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		waitforvisibility(userName,10);
		userName.sendKeys(username);
		
		WebElement passWord  = driver.findElement(By.xpath("//input[@id='password']"));
		waitforvisibility(passWord,10);
		passWord.sendKeys(password);
	}

	public void user_click_on_login_button()  {
		
		WebElement loginbutton= driver.findElement(By.xpath("//input[@id='login-button']"));
		waitforclickable(loginbutton,10);
		loginbutton.click();
		  
	}

	public boolean validate_sucessful_login() {
	    WebElement productheading=driver.findElement(By.xpath("//span[@class='title']"));
	    return productheading.isDisplayed();
	}
	
	}
