package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getText(By locator)
	{
		String text="";
		try {
			text = driver.findElement(locator).getText();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return text;
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	
	public boolean isElementDisplayed(By locator, int time)
	{
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try { 
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).isDisplayed();
			flag=true;
			}

			catch(TimeoutException  e)
			{
				e.printStackTrace();
				flag=false;
			}
			catch(NoSuchElementException e1)
			{
				e1.printStackTrace();
				flag=false;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				flag=false;
			}
		return flag;	
	}
	
	
	//waits

	public boolean waitForPresenceofElement(By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		}
		catch(TimeoutException e)
		{
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

