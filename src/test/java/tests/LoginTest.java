package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import testbase.TestBase;

public class LoginTest extends TestBase {
	@Test
	public void Verify_Login_Page_Header()
	{
		//expected result
		String expectedText = "Login";
		LoginPage page = new LoginPage(driver);
		
		String actualText = page.getTitle();
		//Assertion
		Assert.assertEquals(actualText, expectedText);
	
	}
	
	
	@Test
	public void Verify_Username_Field_Present()
	{
		LoginPage page =new LoginPage(driver);
		boolean actual = page.isElementPresent("username");
		Assert.assertEquals(actual, true, "Username field is not displayed");
		
	}
	
	
	@Test
	public void Verify_Error_on_Incorrect_Credentials()
	{
		String expected = "Invalid credentials";
		LoginPage page =new LoginPage(driver);
		page.doLogin("test", "test");
	
		boolean actual = page.is_invalid_cred_msg_displayed();
		Assert.assertEquals(actual, true);

		String msg = page.getInvalidCredMessage();
		
		Assert.assertEquals(msg, expected, "Error message is not matched");
	}
	
	

}	


