package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import config.ProjectSettings;

public class PageErpLogin {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"Username\"]")
	private WebElement fillUserName;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"Password\"]")
	private WebElement fillPswd;

	@FindBy(how=How.XPATH,using=".//span[text()=\"Login\"]")
	private WebElement clickOnLogin;

	public PageErpLogin(WebDriver driver) {
		String pgTitle = "Log on";
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
	public PgErpLanding validLogin() throws Exception {
		PgErpLanding pgErpLanding = null;


		Thread.sleep(12000);
		fillUserName.sendKeys(ProjectSettings.erpUserName);

		Thread.sleep(5000);
		fillPswd.sendKeys(ProjectSettings.erpPassword);


		Thread.sleep(5000);
		clickOnLogin.click();

		pgErpLanding = new PgErpLanding(driver);
		return pgErpLanding;
		// Assert.assertEquals(driver.getTitle(), "Integrity EMR");
	}

}
