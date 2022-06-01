package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageOpenEncounterWithNewPatient {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String strMrn = null;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgpatientSrch;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.CLASS_NAME, using = "encounter_tab_bar_container")
	private WebElement encounterTabBarContainer;

	@FindBy(how = How.ID, using = "gwt-debug-addNewProblem")
	private WebElement clickOnAddNewProblem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]")
	private WebElement clickOnSignficantProblem;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-icd10popup--done\"]/a")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div")
	private List<WebElement> select_category;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div")
	private List<WebElement> select_category2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div")
	private List<WebElement> select_category3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div")
	private List<WebElement> select_eye;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div")
	private List<WebElement> select_severity;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div")
	private List<WebElement> select_stability;

	public PageOpenEncounterWithNewPatient(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageOpenEncounterWithNewPatient.this);
	}

	public void verifyOpenEncounterWithNewPatient(String enviorment, String PMSID, String MRN, String firstName,
			String lastName, String date, String ssn, String SexcualOrientation, String GenderIdentity, String gender,
			String Address1, String Address2, String City, String State, String ZipCode, String HomePhone,
			String WorkPhone, String cellPhone, String Ethnicity, String Race, String Detailedrace, String EmailAddress,
			String ContactMethod, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges) throws Exception {

		// invoke method for autoCreate patient with in encounter
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		strMrn = new PgAutoCreatePatient(driver, wait, builder).insertPatientDetails(PMSID, MRN, firstName, lastName,
				date, ssn, SexcualOrientation, GenderIdentity, gender, Address1, Address2, City, State, ZipCode,
				HomePhone, WorkPhone, cellPhone, Ethnicity, Race, Detailedrace, EmailAddress, ContactMethod);

		// call encounter mwthod of open and close encounter
		searchPatientWithNewEncounter(category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				significantProblem, visitType, noCharges);
	}

	public void searchPatientWithNewEncounter(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges) throws Exception {

		// method call for search patient
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgpatientSrch = lclPgLanding.patientSearch();
		lclPgpatientSrch.searchPatient("", "", strMrn, editPatient);

		// start new encounter
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		openEncounterForOnlyNewPatient(category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				significantProblem);

		// close encounter
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);

	}

	public void openEncounterForOnlyNewPatient(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem) throws Exception {
		// open encounter
		Thread.sleep(7000);
		ensureElememtToBeClickable(clickOnOpenEncounter);
		clickOnOpenEncounter.click();

		// select Imp and plan
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_EncounterTab : encounterTabBarContainer.findElements(By.xpath(".//*"))) {
			if (select_EncounterTab.getText().equalsIgnoreCase("Imp & Plan")) {
				select_EncounterTab.click();
				break;
			}
		}
		// click on add new problem
		Thread.sleep(9000);
		ensureElememtToBeClickable(clickOnAddNewProblem);
		builder.moveToElement(clickOnAddNewProblem).click().perform();

		// select_category Container
		Thread.sleep(7000);

		for (WebElement select_categoryContainer : select_category) {
			if (select_categoryContainer.getText().equalsIgnoreCase(category)) {
				select_categoryContainer.click();
				break;
			}
		}

		// select_SubCategory Container1
		Thread.sleep(5000);
		for (WebElement select_SubCategoryContainer1 : select_category2) {
			if (select_SubCategoryContainer1.getText().equalsIgnoreCase(subCategory1)) {
				select_SubCategoryContainer1.click();
				break;
			}
		}

		// select_subCategory Container2
		Thread.sleep(5000);

		for (WebElement select_subCategoryContainer2 : select_category3) {
			if (select_subCategoryContainer2.getText().equalsIgnoreCase(subCategory2)) {
				select_subCategoryContainer2.click();
				break;
			}
		}

		// select_Eye
		Thread.sleep(5000);

		for (WebElement select_Eye : select_eye) {
			if (select_Eye.getText().equalsIgnoreCase(eye)) {
				select_Eye.click();
				break;
			}
		}
		// select_galuocmaSeverity Container

		Thread.sleep(5000);
		for (WebElement select_galuocmaSeverityContainer : select_severity) {
			if (select_galuocmaSeverityContainer.getText().equalsIgnoreCase(galuocmaSeverity)) {
				select_galuocmaSeverityContainer.click();
				break;
			}
		}
		// select_galuocma Stability
		Thread.sleep(5000);
		for (WebElement select_galuocmaStability : select_stability) {
			if (select_galuocmaStability.getText().equalsIgnoreCase(galuocmaStability)) {
				select_galuocmaStability.click();
				break;
			}
		}

		// click On Signficant Problem
		if (!clickOnSignficantProblem.isSelected() && significantProblem) {
			clickOnSignficantProblem.click();
		}

		// click On Done Btn of add new problem
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnDoneBtn);
		builder.moveToElement(clickOnDoneBtn).click().perform();

	}

	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
