package autox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mousehover {

	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
		WebElement windowbtnElement=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		
		Actions action=new Actions(driver);
        action.moveToElement(windowbtnElement).build().perform();
        Thread.sleep(3000);
        action.click();
        //java click/sure click
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", windowbtnElement);
        Thread.sleep(3000);
        //------------------
        
        action.sendKeys(Keys.ENTER).build().perform();
        windowbtnElement.sendKeys("username");
        action.dragAndDrop(null, null);
    }
}