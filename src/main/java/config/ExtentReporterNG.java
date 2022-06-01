package config;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import utilities.ScreenShot;

public class ExtentReporterNG implements IReporter {
	public ExtentReports extent;
	WebDriver driver;

	// public ExtentTest test;
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		ScreenShot scrnsht = new ScreenShot();
		String dateTime = "";
		try {
			dateTime = scrnsht.GetTimeStampValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// File.separator + dateTime +
		extent = new ExtentReports(outputDirectory + File.separator + dateTime + "_ExtentReportTestNG.html", true,
				DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE);
		Map sysInfo = new HashMap();
		sysInfo.put("AUT URL", ProjectSettings.baseURL);
		sysInfo.put("Build No. ", ProjectSettings.buildNumber);
		sysInfo.put("ACIConnector No.", ProjectSettings.aciConnectorNumber);
		sysInfo.put("Report Location", ProjectSettings.reportLocation);
		sysInfo.put("Screenshot Location", ProjectSettings.screenShotLocation);
		sysInfo.put("Page Load Timeout", ProjectSettings.pageLoadTimeOut);
		sysInfo.put("Element Wait Timeout", ProjectSettings.elementWaitTimeOut);
		extent.addSystemInfo(sysInfo);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());
				test.getTest().setStartedTime(getTime(result.getStartMillis()));
				test.getTest().setEndedTime(getTime(result.getEndMillis()));
				
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = "Test " + status.toString().toLowerCase() + "ed";

				if (result.getThrowable() != null)
					test.log(status, result.getThrowable());
				test.log(status, message);
				

				extent.endTest(test);
			}

		}

	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}