package utilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;
import org.testng.Reporter;

import config.ProjectSettings;

public class SetUp {
	public WebDriver instBrowser(ProjectSettings.browserType brType) {
		WebDriver driver = null;
		if (brType != null) {
			switch (brType) {
			case IE: {
				driver = new InternetExplorerDriver();
				Reporter.log("Internet Explorer Browser Instantiated");
				break;
			}
			case FIREFOX: {
				driver = new FirefoxDriver();
				Reporter.log("Firefox Browser Instantiated");
				break;
			}
			case CHROME: {
				driver = new ChromeDriver();
				Reporter.log("Google Chrome Browser Instantiated");
				break;
			}
			case EDGE: {
				driver = new EdgeDriver();
				Reporter.log("Microsoft Edge Browser Instantiated");
				break;
			}

			default:
				Reporter.log("Incorrect Browser Type!");
			}
		}
		return driver;
	}

	public boolean getPage(WebDriver driver, String openURL) {
		// openURL=ProjectSettings.baseURL;
		// System.out.println(openURL);
		driver.navigate().to(openURL);
		if (driver.getTitle() != "") {
			Reporter.log("\nPage Opened " + driver.getTitle());
			return true;
		} else {
			Reporter.log("\nCouldn't not open page " + openURL);
			return false;
		}
	}
}
