package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import utils.Constants;

public class ForgotPasswordTest extends TestBase {
	
	@Test
	public void Verify_Reset_Password()
	{
		//open browser
		//open url
		// go to login page
		//click on forgot password link
		//enter username
		//click on reset password button
		//password successfully reset message is displayed - expected		
		LoginPage loginPage = new LoginPage(driver);
		ForgotPasswordPage forgotPage =loginPage.clickForgotPasswordLink();
		
		Assert.assertEquals(forgotPage.isResetPasswordTextDisplayed(),true);
		String title = forgotPage.getTitle();
		
		Assert.assertEquals(title, Constants.RESET_PASSWORD_PAGE_HEADER);
		forgotPage.enterUsername("test");
		forgotPage.clickButton("reset");
		Assert.assertEquals(forgotPage.isResetPasswordTextDisplayed(),true);
		title = forgotPage.getTitle();
		Assert.assertEquals(title, Constants.RESET_PASSWORD_TEXT);
		
	}

}




