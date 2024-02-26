package autox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap_dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().window().maximize();
		
		//-------------------------
		WebElement dropdown=driver.findElement(By.xpath("//button[@id='menu1']"));
		dropdown.click();
		Thread.sleep(5000);
		
		List<WebElement> dropList=driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
       
		for(WebElement element:dropList) {
    	  String elementname=element.getText();
    	  System.out.println(elementname);
  
    	 if (elementname.equals("CSS")) {
    	  element.click();
    	  System.out.println(elementname);
    	 }
       }
	}

}
