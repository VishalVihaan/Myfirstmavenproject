package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testbase.TestBase;

public class TestNGListener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("onTestStart : " + result.getMethod().getMethodName());	
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("onTestSuccesst");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");	
	TakesScreenshot takesScrenshot = (TakesScreenshot)driver;
	File file = takesScrenshot.getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(file, new File("C:\\Users\\HP\\eclipse-workspace\\myfirstmavenproject\\screen.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");		
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		System.out.println("onTestFailedWithTimeout(ITestResult result");
	}

	@Override
	public void onStart(ITestContext context) {
			
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
			
		System.out.println("onFinish");
	
	
	}

	
	
	
	
}