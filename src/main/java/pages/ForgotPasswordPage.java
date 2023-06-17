package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
WebDriver driver;
//page Elements
By username = By.name("username");
By cancelButton = By.xpath("//button[contains(@class,'cancel')]");
By resetPassButton = By.xpath("//button[contains(@class,'reset')]");
By resetPasswordText = By.tagName("h6");
//constructor for driver to use globally
public ForgotPasswordPage(WebDriver driver) {
	this.driver = driver;
	
}
	//Page Actions
public void enterUsername(String user)
{
	driver.findElement(username).sendKeys(user);
	
}
	public void clickButton(String button)
	{
		if(button.equals("cancel"))
		{
			driver.findElement(cancelButton).click();
		}
		else if(button.equals("reset"))
		{
			driver.findElement(resetPassButton).click();
		}
	}
	public boolean IsRestPasswordTextDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean flag=false;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(resetPasswordText));
			driver.findElement(resetPasswordText);
			flag=true;
		}
		catch(NoSuchElementException e)
		{
			flag = false;
		}
		catch(Exception e)
		{
			flag =false;
		}
		
		return flag;
	}
	
	
	public String getTitle()
	{
		return driver.findElement(resetPasswordText).getText();
	}
	public Boolean isResetPasswordTextDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}
	

}	
	
	