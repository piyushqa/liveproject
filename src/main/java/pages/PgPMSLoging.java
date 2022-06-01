package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;

public class PgPMSLoging {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(how = How.CSS, using = "iframe#frame-login")
	private WebElement clickOnFrame;

	@FindBy(how = How.XPATH, using = ".//input[@name=\"username\"]")
	private WebElement fillUserName;

	@FindBy(how = How.XPATH, using = ".//input[@name=\"password\"]")
	private WebElement fillPswd;

	@FindBy(how = How.XPATH, using = ".//input[@name=\"officeKey\"]")
	private WebElement fillOfficeKey;

	@FindBy(how = How.XPATH, using = ".//button[@type=\"submit\"]")
	private WebElement clickOnSubmit;

	public PgPMSLoging(WebDriver driver) {
		String pgTitle = "Login | AdvancedMD";
		this.driver = driver;
System.out.println(driver.getTitle());
		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);
			Reporter.log("%nPgLogin Instantiated");
		} else {
			Reporter.log("Incorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);
		}
	}

	// Function to login
	// public PgLanding validLogin(String username, String password) throws
	// Exception {
	public PgPMSLanding validLogin() throws Exception {
		PgPMSLanding pgPMSLanding = null;

		Thread.sleep(15000);
		driver.switchTo().frame(clickOnFrame);

		Thread.sleep(12000);
		fillUserName.sendKeys(ProjectSettings.PMSUserName);

		Thread.sleep(5000);
		fillPswd.sendKeys(ProjectSettings.PMSPasword);

		Thread.sleep(5000);
		fillOfficeKey.sendKeys(ProjectSettings.PMSOfficekey);

		Thread.sleep(5000);
		clickOnSubmit.submit();

		pgPMSLanding = new PgPMSLanding(driver);
		return pgPMSLanding;
		// Assert.assertEquals(driver.getTitle(), "Integrity EMR");
	}
}
