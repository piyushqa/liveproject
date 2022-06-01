package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager {
	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() throws Exception   {
		if (extent == null) {
			// Set HTML reporting file location
			// String workingDir = System.getProperty("user.dir");

				extent = new ExtentReports(
						"test-output" + File.separator + ScreenShot.GetTimeStampValue()+"_ExtentReportTestNG.html", false);

		}
		return extent;
	}

}
