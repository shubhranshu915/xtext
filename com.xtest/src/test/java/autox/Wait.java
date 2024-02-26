package autox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait {
	public static void main( String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
	//implicit wait /dynamic wait../write max time /implement on all session/page load timeout error
	driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage()	.timeouts().pageLoadTimeout(Duration.ofSeconds(10))	;
	
	
	//Explicit wait /on condition../ one time call  ..one time  use/no such exception error
	WebElement windowbtnElement=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(windowbtnElement));
		
	//Explicit wait    /rare use	
		
	}
}
