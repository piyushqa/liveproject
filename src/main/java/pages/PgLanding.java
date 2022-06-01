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

public class PgLanding {
	private WebDriver driver;
	// Page elements
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Patient Search")
	private WebElement lnkPatientSearch;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Patient")
	private WebElement lnkCreatePatient;

	WebDriverWait wait = null;

	// Initillizing page
	public PgLanding(WebDriver driver) {
		String pgTitle = "Integrity EMR";
		this.driver = driver;
		// Checking for page title
		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);

		} else {
			Reporter.log("\nIncorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);

		}
	}

	// Function to Click on page link Search Patient which in turn calls the
	// function to search for patient
	public PgPatientSearch patientSearch() throws Exception {

		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		// Waiting Patient Search link to be Clickable
		Thread.sleep(10 * 1000);
		wait.until(ExpectedConditions.elementToBeClickable(lnkPatientSearch));
		// System.out.println("Page Loaded");
		Reporter.log(ProjectSettings.eol + "Extracted Patient Link Text: " + lnkPatientSearch.getText());
		lnkPatientSearch.click();
		// Returning next page which is Patient Search page in flow
		return new PgPatientSearch(driver);
	}

	// Function to Click on link Create Patient which in turn calls the function to
	// create new patient
	public PgCreatePatient createPatient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		Thread.sleep(10 * 1000);
		// Waiting for link Create Patient to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(lnkCreatePatient));
		Reporter.log(ProjectSettings.eol + "Clicking on Create Patient link");
		lnkCreatePatient.click();
		// Returning next page Create Patient in the flow
		return new PgCreatePatient(driver);
	}

	public PgCreatePatient modifyPatient() throws Exception {
		return new PgCreatePatient(driver);
	}
}