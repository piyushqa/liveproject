package utilities;

import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.NetworkMode;

import utilities.ScreenShot;

public class ExtentRep 
{
	public static ExtentReports extent;
	public static ExtentTest test;
	public static void extReport() throws IOException
	{
		extent = new ExtentReports("test-output" + File.separator + ScreenShot.GetTimeStampValue()+"_ExtentReportTestNG.html", false, DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE);
		extent.loadConfig(new File("src\\config\\extent-config.xml"));
        //test = extent.startTest((this.getClass().getSimpleName() + "::"+ this.getClass().getEnclosingMethod().getName()), this.getClass().getEnclosingMethod().getName());

	}
}
