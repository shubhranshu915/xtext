package helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base {
	@Before
	  public  void setup() throws InterruptedException {
		  String browsername=prop.getProperty("broswer");
		  
		  if(browsername.equals("chrome")) {
		   WebDriverManager.chromedriver().setup();  // Update browser
		   ChromeOptions options=new ChromeOptions(); //hit chrome driver
		   options.addArguments("--incognato");
		   driver =new ChromeDriver(options);
		  }
		  else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();//public   -outside package we can call
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--incognito"); 
			driver =new FirefoxDriver(options);
			
		  }
		  else if(browsername.equals("edge")) {
				WebDriverManager.edgedriver().setup();//public   -outside package we can call
				driver =new EdgeDriver();  
			  }
			driver.get(prop.getProperty("url")); 
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage()	.timeouts().pageLoadTimeout(Duration.ofSeconds(10))	;
		//wait................  
	  }
	@After
	public void tearDown(Scenario s) {   //Scenario is predefined  class in cucumber .java
		if(s.isFailed()){
			TakesScreenshot ts=(TakesScreenshot)driver;
			File scrFile =ts.getScreenshotAs(OutputType.FILE); 
			try {
				FileUtils.copyFile(scrFile,new File ("Screenshots/"+s.getName()+System.currentTimeMillis()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
		}
}
