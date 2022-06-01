package utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	WebDriver driver;
	ExtentTestManager manager;
	static Map extentTestMap = new HashMap();
	static ExtentReports extent;

	public static void foo() throws Exception {
		extent = ExtentManager.getReporter();
	}
//	try {
//
//	}catch(IOException e) {e.printStackTrace();}

//	public static synchronized ExtentTest getTest() {
//		return (ExtentTest) extentTestMap.get((int) (Thread.currentThread().getId()));
//	}
//
//	public static synchronized void endTest() {
//		extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
//	}
//
//	public static synchronized ExtentTest startTest(String testName, String desc) {
//		ExtentTest test = extent.startTest(testName, desc);
//		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
//		return test;
//	}

	public ExtentTestManager(WebDriver driver, ExtentTestManager manager) {
		this.driver = driver;
		this.manager = manager;
		PageFactory.initElements(driver, this);
	}
}
