package testbase;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropConfig;

public class TestBase {

protected static WebDriver driver;
protected static Properties prop;
	
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(); 
					

		driver.manage().window().maximize();
		//launch login url
		prop = PropConfig.init_prop("SIT");
		String url = prop.get("url").toString();
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(@class,'orangehrm-login-title')]")));
	}
	
	
	@AfterMethod
	
	public void afterMethod(ITestResult result) {
		// TODO Auto-generated method stub
		
			String testcaseName = result.getMethod().getMethodName();
			
			String path = System.getProperty("user.dir");
			
			if(result.getStatus() == ITestResult.FAILURE)
			{
				TakesScreenshot takesScrenshot = (TakesScreenshot)driver;
				File file = takesScrenshot.getScreenshotAs(OutputType.FILE);
				try {
					FileHandler.copy(file, new File(path +"\\"+ testcaseName +".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
			driver.quit();
		}
	}


	
	
	
	
	
	
	
	
	

