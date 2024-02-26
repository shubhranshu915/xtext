package autox;

import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandle {
public static void main(String[] args) throws InterruptedException {
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	driver.manage().window().maximize();
	
	String parentid=driver.getWindowHandle();
	//....................................................
	WebElement windowbtnElement=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
	windowbtnElement.click();
	Thread.sleep(3000);
	
	Set<String>  allwindow=driver.getWindowHandles();
	for(String a:allwindow) {
		if (!parentid.equals(a)) {
			driver.switchTo().window(a);
			break;
		}
	}
	WebElement firstnameElement=driver.findElement(By.xpath("//input[@id='firstName']"));
	firstnameElement.sendKeys("shardendu");
	Thread.sleep(3000);
	driver .close(); // Quit will Close  all Session .
	driver.switchTo().window(parentid);
	
	//.....tab handles...............................................................
	     
	WebElement tabbtnElement=driver.findElement(By.xpath("//button[@id='newTabBtn']"));
	tabbtnElement.click();
	Thread.sleep(3000);
	
	Set<String> alltabSet=driver.getWindowHandles();
	for(String t:alltabSet) {
		if(!parentid.equals(t)) {
		driver.switchTo().window(t)	;
		String windowtitle =driver.getTitle();
		System.out.println(windowtitle);
		break ;
		}	
	}
	Thread.sleep(3000);
	Alert a=driver.switchTo().alert();
	a.accept();
	Thread.sleep(3000);
	driver.close();
	driver.switchTo().window(parentid);
	//----------------------multiwtab...........
	
	WebElement mtabbtnElement=driver.findElement(By.xpath("//button[@id='newTabBtn']"));
	mtabbtnElement.click();
	Thread.sleep(3000);
	
	Set<String> malltabSet=driver.getWindowHandles();
	for(String t:malltabSet) {
		if(!parentid.equals(t)) {
		driver.switchTo().window(t)	;
		String windowtitle =driver.getTitle();
		
		if(windowtitle.contains("")) {
			System.out.println(windowtitle);
			
		}
		
		break ;
		}	
	}
	Thread.sleep(3000);
	Alert m=driver.switchTo().alert();
	m.accept();
	Thread.sleep(3000);
	driver.close();
	driver.switchTo().window(parentid);
	
	
}
}
