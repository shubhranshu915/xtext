package vuse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Userlogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.vuse.com/gb/en/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	    WebElement cookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
	    Thread.sleep(3000);
	    cookies.click();
		WebElement age18plus=driver.findElement(By.xpath("//div[@class='dialog-buttonWrap-3xa']/button[2]"));
		Thread.sleep(2000);
		
		String options=age18plus.getText();
	    System.out.println(options);
	    
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", age18plus);
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    Thread.sleep(3000);
	    try {
	    	age18plus.click();
	    	}
	    	catch (Exception e) {
	    		executor.executeScript("arguments[0].click();", age18plus);  //haha
	    	}
	    WebElement loginbutton=driver.findElement(By.xpath("//span[@class='accountChip-root-2kC']/span[2]"));
		Thread.sleep(3000);
		loginbutton.click();
		//haha
		
		
	    WebElement ihaveaccount=driver.findElement(By.xpath("//li[@class='signInSocial-tab-1vZ signInSocial-selectedTab-248']"));     
	    
	    	ihaveaccount.click();
	    	
	    Thread.sleep(3000);
	   
	    System.out.println("great");
	    Thread.sleep(3000);
        WebElement usernamElement=driver.findElement(By.xpath("//span[@class='fieldIcons-input-2we']/input[@autocomplete='email']"));
        Thread.sleep(8000);
        usernamElement.sendKeys("shardendu915@gmail.com");
	    WebElement userpassElement=driver.findElement(By.xpath("//input[@type='password']"));
	    userpassElement.sendKeys("Ss00000000@");
	    WebElement loginbuttonElement=driver.findElement(By.xpath("//div[@class='signInSocial-buttonsContainer-2mE']"));
	    loginbuttonElement.click();
	
	}

}
