package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	//to read-property.file...........
	static {
	try {
		FileInputStream file=new FileInputStream("testdata/testdata.properties");
	    prop=new Properties();
		prop.load(file);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	

  public void waitforvisibility(WebElement ele,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.visibilityOf(ele));
  }
  public void waitforclickable(WebElement ele,int timeout) {
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	  wait.until(ExpectedConditions.elementToBeClickable(ele));
  }
  public void waitforalert(int timeout){
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	  wait.until(ExpectedConditions.alertIsPresent()); 
  }
  //mousehover..............
  public void mousehover(WebElement ele) {
  Actions a=new Actions(driver);
  a.moveToElement(ele);
  }
  //alert...........
  public void alertaccept(int timeout) {
	  waitforalert(timeout);
	  Alert a=driver.switchTo().alert();
	  a.accept();
  }
  public void alertdismiss(int timeout) {
	  waitforalert(timeout);
	  Alert a=driver.switchTo().alert();
	  a.dismiss();
  }
  public void alertsendkeys(int timeout, String keys) {
	  waitforalert(timeout);
	  Alert a=driver.switchTo().alert();
	  a.sendKeys(keys);
  }
  //dropdown-----------------
  public void selectdropdownbyvisibletext(WebElement ele,String value) {
	Select s=new Select(ele);
    s.selectByVisibleText(value); 
  }
  public void selectdropdownbyvalue(WebElement ele,String value) {
		Select s=new Select(ele);
	    s.selectByValue(value); 
  }
  public void selectdropdownbyindex(WebElement ele,int value) {
		Select s=new Select(ele);
	    s.selectByIndex(value); 
}
//Screenshots
		public void takeScreenshot() {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File scrFile =ts.getScreenshotAs(OutputType.FILE); 
			try {
				FileUtils.copyFile(scrFile,new File ("Screenshots/"+System.currentTimeMillis()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			}



}
  

