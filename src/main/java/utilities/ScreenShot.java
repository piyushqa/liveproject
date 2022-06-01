package utilities;

import java.awt.Point;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.ExtentReporterNG;
import config.ProjectSettings;

import org.apache.commons.io.FileUtils;

public class ScreenShot {
	// This class requires a third party JAR added to Build Path
	// commons-io-2.6-bin.jar
	// Function to take screenshot
	public static ExtentTest test;

	public static String screen(WebDriver driver) throws IOException {
	String	 fileName = ProjectSettings.screenShotLocation + GetTimeStampValue() + "_ScreenSHOT";
		File sourceFile;
		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			sourceFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(fileName));
			// test.log(LogStatus.PASS, test.addScreenCapture(fileName));

		} catch (IOException e) {
			fileName = "Failed to capture screenshot: " + e.getMessage();
			Reporter.log("Unable to capture screenshot. Exception Details: " + e.toString());
		}

		return fileName;
	}

	// Function for taking screenshot of an element on the screenshot
	public static void element(WebElement element) throws IOException {
		WrapsDriver wrapsDriver = (WrapsDriver) element;
		File screenshot = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
		Rectangle rectangle = new Rectangle(element.getSize().width, element.getSize().height);
		org.openqa.selenium.Point location = element.getLocation();
		BufferedImage bufferedImage = ImageIO.read(screenshot);
		BufferedImage destImage = bufferedImage.getSubimage(location.x, location.y, rectangle.width, rectangle.height);
		ImageIO.write(destImage, "png", screenshot);
		File file = new File("//path//to");
		FileUtils.copyFile(screenshot, file);
	}

	// Function returning unique timestamp value to be included in the filenames
	public static String GetTimeStampValue() throws IOException {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString();
		System.out.println(timestamp);
		String systime = timestamp.replace(":", "-");
		System.out.println(systime);
		return systime;
	}

}
