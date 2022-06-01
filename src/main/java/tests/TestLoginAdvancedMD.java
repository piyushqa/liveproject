package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import config.ProjectSettings;
import pages.PgPMSLoging;

public class TestLoginAdvancedMD {
	WebDriver driver;

	@Test(enabled=true)
	public  void logInAdvacedMDPatient() throws Exception {

		Thread.sleep(5000);
		driver.get(ProjectSettings.AdvancedMDPMS);
		Thread.sleep(5000);

		PgPMSLoging pmsLog=new PgPMSLoging(driver);
		pmsLog.validLogin();
	}

	public TestLoginAdvancedMD(WebDriver driver) {

		this.driver = driver;
	}

}
