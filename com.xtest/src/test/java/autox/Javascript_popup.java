package autox;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript_popup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
                 //Alert with OK
	           
		        
		
		WebElement btn1Element=driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li[1]"));
		btn1Element.click();
		WebElement btnpop1Element=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		btnpop1Element.click();
		Alert a=driver.switchTo().alert();
		Thread.sleep(5000);
		a.accept();
		 //	Alert with OK & Cancel
		WebElement btn2Element=driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li[2]"));
		btn2Element.click();
		WebElement btnpop2Element=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		btnpop2Element.click();
		Alert b=driver.switchTo().alert();
		Thread.sleep(5000);
		b.dismiss();
		//Alert with Textbox
		WebElement btn3Element=driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li[3]"));
		btn3Element.click();
		WebElement btnpop3Element=driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		btnpop3Element.click();
		Alert c=driver.switchTo().alert();
		String v=c.getText();
		System.out.println(v);
		c.sendKeys("great");
		Thread.sleep(5000);
		c.accept();
		
	}

}
