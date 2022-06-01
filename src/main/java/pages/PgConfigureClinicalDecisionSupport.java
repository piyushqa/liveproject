package pages;

import static org.testng.Assert.assertEquals;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//create Class
public class PgConfigureClinicalDecisionSupport {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	@FindBy(how = How.CSS, using = "#gwt-debug-dlc-documents-container>div:nth-child(10)")
	public WebElement chkDocuments;
	@FindBy(how = How.CSS, using = "#gwt-debug-dlc-education")
	public WebElement chkeducation;

	// create Constructor
	public PgConfigureClinicalDecisionSupport(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void addClinicalDecisionSupport(String configure, String Cds, boolean allDocuments, boolean education,
			String fName, String lName) throws Exception {

		Thread.sleep(4000);
		java.util.List<WebElement> openConfigration = driver
				.findElements(By.cssSelector("#content > div > div> div > table > tbody>tr>td>a"));
		for (int i = 0; i < openConfigration.size(); i++)
			// System.out.println(openCounter.get(i).getText());
			if (openConfigration.get(i).getText().equalsIgnoreCase(configure)) {
				openConfigration.get(i).click();

			}
		Thread.sleep(4000);
		java.util.List<WebElement> openCds = driver
				.findElements(By.cssSelector("#gwt-debug-tabbedPopup-tabContainer>div>div"));
		for (int i = 0; i < openCds.size(); i++)
			// System.out.println(openCounter.get(i).getText());
			if (openCds.get(i).getText().equalsIgnoreCase(Cds)) {
				openCds.get(i).click();

			}
		Thread.sleep(2 * 1000);
		if (!chkDocuments.isSelected() && allDocuments)
			chkDocuments.click();

		// Thread.sleep(4* 1000);
		// if (!chkeducation.isSelected() && education)
		// chkeducation.click();

		// Click On Done Button
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > div > div > div > div> div > div > div>a")).click();

		 patientSearch(fName,lName);

	}
	void patientSearch(String fName,String lName) throws Exception {
		Thread.sleep(2000);
	boolean editPatient = false;
	lclPgPatientSearch = lclPgLanding.patientSearch();
	lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
	}
}
