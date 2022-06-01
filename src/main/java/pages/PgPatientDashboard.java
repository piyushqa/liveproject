package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PgPatientDashboard {
	private WebDriver driver;

	// Patient Dashboard page elements
	@FindBy(how = How.CSS, using = "#gwt-debug-backToSearchResults")
	private WebElement lnkReturnToSearchResults;

	@FindBy(how = How.CSS, using = "#gwt-debug-pdReturnToUserDashboard")
	private WebElement lnkMyDashboard;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientName")
	private WebElement divPatientName;

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget")
	private WebElement btnJoinEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-openEncounterTable")
	private WebElement lstOpenEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-startNewEncounter > a:nth-child(3)")
	private WebElement btnStartEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-correspondence > a:nth-child(3)")
	private WebElement btnCorrespondence;

	@FindBy(how = How.CSS, using = "#gwt-debug-openEncounterTable")
	private WebElement lstOpenEncounterList;

	@FindBy(how = How.CSS, using = ".GFEO3AODK1D > table:nth-child(9) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > div:nth-child(1)")
	private WebElement lnkPortalAccess;

	@FindBy(how = How.CSS, using = ".GFEO3AODK1D > table:nth-child(16) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > div:nth-child(1)")
	private WebElement lnkPCP;

	@FindBy(how = How.CSS, using = "#gwt-debug-editPatient")
	private WebElement lnkEditPatient;

	// IntegriView links
	@FindBy(how = How.CSS, using = "#gwt-debug-documentCenter")
	private WebElement lnkDocumentCenter;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryModule")
	private WebElement lnkSurgeryModule;

	@FindBy(how = How.CSS, using = "#gwt-debug-uploadDocument")
	private WebElement lnkUploadDocuments;

	// Summaries dropdown and its list
	@FindBy(how = How.CSS, using = "#gwt-debug-summaries-button > div:nth-child(3)")
	private WebElement drpdwnSummaries;

	@FindBy(how = How.CSS, using = "#gwt-debug-summaries-container")
	private WebElement lstSummaries;

	// Other Links drop downs along with their lists
	@FindBy(how = How.CSS, using = "#gwt-debug-otherLinks-button > div:nth-child(3)")
	private WebElement drpdwnOtherLinks;

	@FindBy(how = How.CSS, using = "#gwt-debug-otherLinks-container")
	private WebElement lstOtherLinks;

	// Page bottom links
	@FindBy(how = How.CSS, using = "#gwt-debug-glaucomaSummary")
	private WebElement lnkMedsAndAllergies;

	@FindBy(how = How.CSS, using = "#gwt-debug-socialFamilyHistory")
	private WebElement lnkSocialAndFamilyHistory;

	@FindBy(how = How.CSS, using = "#gwt-debug-glaucomaSummary")
	private WebElement lnkGlaucomaSummary;

	@FindBy(how = How.CSS, using = "#gwt-debug-visionSummary")
	private WebElement lnkVisionSummary;

	@FindBy(how = How.CSS, using = "#gwt-debug-pdLogout > a:nth-child(3)")
	private WebElement btnLogout;

	// Popup parent iframe
	@FindBy(how = How.CSS, using = "iframe#com\\.ids\\.emr\\.Emr")
	private WebElement ifrmPopUpParent;

	// Open encounter warning pop-up box
	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_large_popup")
	private WebElement popupExitingEncounter;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok")
	private WebElement btnStartEncounterYes;

	@FindBy(how = How.CSS, using = "a#gwt-debug-Cancel")
	private WebElement btnStartEncounterNo;

	// Initializing patient creation page
	public PgPatientDashboard(WebDriver driver) {
		String pgTitle = "Integrity EMR";
		this.driver = driver;
		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);
		} else {
			Reporter.log("Incorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);
		}
	}

	// Function to begin encounter for opened patient
	public PgPatientEncounter startEncounter() {
		String subWindowHandler = null;
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(btnStartEncounter));
		btnStartEncounter.click();
		if (btnJoinEncounter.getText() != "Join Open Encounter(0)") {
			Reporter.log(btnJoinEncounter.getText().substring(4) + " already exists for the patient", 1);
			String parentWindowHandler = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler);
			wait.until(ExpectedConditions.elementToBeClickable(btnStartEncounterYes));
			btnStartEncounterYes.click();
			driver.switchTo().window(parentWindowHandler);
		}
		return new PgPatientEncounter(driver);
	}

	// Function to join already existing encounter for opened patient takes serial
	// number of the encounter to join
	public PgPatientEncounter joinOpenEncounter(int encounterSerial) {
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		// Since this link is created dynamically, thus concatinating the link with
		// encounter serial in locator itself
		// Checking exiting encounters to not to be zero
		wait.until(ExpectedConditions.visibilityOf(btnJoinEncounter));
		if (btnJoinEncounter.getText() != "Join Open Encounter(0)") {
			act.moveToElement(btnJoinEncounter).click().build().perform();
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.elementToBeClickable(lstOpenEncounterList));
			WebElement encounterRow = driver.findElement(
					By.cssSelector("#gwt-debug-openEncounterTable>tbody>tr:nth-child(" + encounterSerial + ")"));
			wait.until(ExpectedConditions.elementToBeClickable(encounterRow));
			act.moveToElement(encounterRow).click().build().perform();
		} else {
			Reporter.log("No Patient Encounter/Patient Encounter Serial out of Index");
		}
		return new PgPatientEncounter(driver);
	}
}