package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PgPatientSearch {
	private WebDriver driver;
	// Search page elements
	@FindBy(how = How.CSS, using = "#gwt-debug-patientFirstName")
	private WebElement edtbxFirstName;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientLastName")
	private WebElement edtbxLastName;

	@FindBy(how = How.CSS, using = "#gwt-debug-mrn")
	private WebElement edtbxMRN;

	@FindBy(how = How.CSS, using = "div.GD223AHB0B:nth-child(3) > a:nth-child(3)")
	private WebElement btnClearAllFields;

	@FindBy(how = How.CSS, using = "#gwt-debug-searchButton > a:nth-child(3)")
	private WebElement btnSearch;

	@FindBy(how = How.CSS, using = "#gwt-debug-searchResultTable > tbody:nth-child(2) > tr:nth-child(1)")
	private WebElement rowSearchResults;

	@FindBy(how = How.CSS, using = "table#gwt-debug-searchResultTable>tbody>tr>td:nth-child(10)>div")
	private WebElement searchResultEdit;

	// Initiallizing Search page
	public PgPatientSearch(WebDriver driver) {
		this.driver = driver;
		String pgTitle = "Integrity EMR";
		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);
		} else {
			Reporter.log("\nIncorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);
		}
	}

	// Function to search for patient using firstname, lastname or MRN. This
	// function carries a boolean flag editpatient
	// which when true will click on edit link of listed records else wiil click on
	// listed record to open the patient details
	public void searchPatient(String firstName, String lastName, String MRN, boolean editPatient) throws Exception {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		Reporter.log("\nSearching for patient with Name: " + firstName + " " + lastName + ", MRN No: " + MRN);
		if (!firstName.isEmpty()) {
			wait.until(ExpectedConditions.elementToBeClickable(edtbxFirstName));
			edtbxFirstName.sendKeys(firstName);
		}
		if (!lastName.isEmpty()) {
			wait.until(ExpectedConditions.elementToBeClickable(edtbxLastName));
			edtbxLastName.sendKeys(lastName);
		}
		if (!MRN.isEmpty()) {
			wait.until(ExpectedConditions.elementToBeClickable(edtbxMRN));
			edtbxMRN.sendKeys(MRN);
		}
		if (!lastName.isEmpty() || !firstName.isEmpty() || !MRN.isEmpty()) {
			wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
			btnSearch.click();
		}
		// Checking if editpatient flag is set to true or not
		if (editPatient) {
			wait.until(ExpectedConditions.elementToBeClickable(searchResultEdit));
			Reporter.log("\nMoving to EDIT Patient Details.");
			// clicking on Edit patient link to open patient in edit mode
			searchResultEdit.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(rowSearchResults));
			Reporter.log("\nMoving to DISPLAY Patient Details");
			// Clicking on search results to open patient details
			rowSearchResults.click();
		}
	}
}