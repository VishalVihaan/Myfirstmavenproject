package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utils.Constants;

public class HomePageTest extends TestBase{
	
	
	//Assert vs SoftAssert(both are classes)
	//if any assertion in "Assert" class is failed, next code will not be executed -so we assert as hard assert.
	//Soft Assert, checks all the assertion at the end, so all the code will be executed even if any assertion is failing
	//all the methods in assert class are static in nature - so we need to create the object
	
	
	@Test
	public void verify_username() throws InterruptedException
	{
		LoginPage page = new LoginPage(driver);
		HomePage hp = page.doLogin("Admin", "admin123");
		String actualHeader = hp.getHeader();
		
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_HEADER);
		String username = hp.getUsername();
		Thread.sleep(5000);
		Assert.assertEquals(username, Constants.USERNAME);
		
	}
	
	
	@Test
	public void Verify_Links()
	{
		LoginPage page = new LoginPage(driver);
		HomePage hp = page.doLogin("Admin", "admin123");
		String actualHeader = hp.getHeader();
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_HEADER);
		
		List<String> actualList = hp.getMenuList();
		
		//Assert.assertEquals(actualList, Constants.HOME_PAGE_MENU_LIST);
	SoftAssert softAssert = new SoftAssert();
	
	for (int i=0; i<actualList.size();i++) {
		
		String actual = actualList.get(i);
		String expected = Constants.HOME_PAGE_MENU_LIST.get(i);
		System.out.println("Expected : " + i + " " + expected);
		System.out.println("Actual : "  + i + actual );
		//Assert.assertEquals(actualList.get(i), Constants.HOME_PAGE_MENU_LIST.get(i));
	    softAssert.assertEquals(actual, expected);
	}
	softAssert.assertAll();
	}
	
}
	


