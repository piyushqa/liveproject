package pages;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageExternalExam {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;

	@FindBy(how = How.CSS, using = "div.encounter_tab_bar_container>table>tbody>tr>td:nth-child(8)>div")
	WebElement clickOnExamTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listing17\"]/tbody//tr[2]/td[2]/div")
	WebElement clickOnConfronation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)>div>div:nth-child(1)>div>Div:nth-child(2)")
	private List<WebElement> select_ConfronationLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div>div")
	List<WebElement> select_ConfronationSeverity;

	@FindBy(how = How.CSS, using = "div#gwt-debug-copy-summary-right")
	private WebElement clickOnRightCopyBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-exam-data-done>a")
	private WebElement clickOnDoneBtn;

	// WebElement for Orbit

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div:nth-child(2)")
	private List<WebElement> select_OrbitPathlogy;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_OrbitLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_OrbitModifier;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_OrbitSeverity;

	// WebElement for Ocular Motility

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:first-child>div:nth-child(2)>div")
	private List<WebElement> select_OcularCornea;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)")
	private List<WebElement> select_OcularConjunctive;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_OcularLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_OcularModifiers;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_OcularSeverity;

	// WebElement for pupil

	@FindBy(how = How.CSS, using = "div#gwt-debug-OD-findings>table>tbody>tr:nth-child(2)>td>table>tbody>tr>td>div")
	private List<WebElement> select_BrightLight;

	@FindBy(how = How.CSS, using = "div#gwt-debug-OD-findings>table>tbody>tr:nth-child(3)>td>table>tbody>tr>td>div")
	private List<WebElement> select_DimLight;

	@FindBy(how = How.CSS, using = "div#gwt-debug-OD-findings>table>tbody>tr:nth-child(5)>td>div>div:nth-child(2)>div>div:nth-child(1)>div")
	private List<WebElement> select_PupilShape;

	@FindBy(how = How.CSS, using = "div#gwt-debug-OD-findings>table>tbody>tr:nth-child(7)>td>div>div:nth-child(2)>div>div:nth-child(1)>div")
	private List<WebElement> select_PupilReactivity;

	@FindBy(how = How.CSS, using = "div#gwt-debug-OD-findings>table>tbody>tr:nth-child(9)>td>div>div:nth-child(2)>div>div:nth-child(1)>div")
	private List<WebElement> select_RAPD;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageExternalExam(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageExternalExam.this);
	}

	public void checkExternalExam(String firstName, String lastName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			boolean significantProblem, String visitType, boolean noCharges, String confonationLocation,
			String confonationSeverity, String orbitPathlogy, String orbitLocation, String orbitModifier,
			String orbitSeverity, String ocularCategory, String ocularGlaucoma, String ocularLocation,
			String ocularModifier, String ocularSeverity, String pupilLight, String pupilShape, String pupilReactivity,
			String pupilRAPD) throws Exception {

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(firstName, lastName, "", editPatient);

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnExamTab);
		clickOnExamTab.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnConfronation);
		clickOnConfronation.click();

		performExamTabOperationForExternalExam(confonationLocation, confonationSeverity, orbitPathlogy, orbitLocation,
				orbitModifier, orbitSeverity, ocularCategory, ocularGlaucoma, ocularLocation, ocularModifier,
				ocularSeverity, pupilLight, pupilShape, pupilReactivity, pupilRAPD);
		
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();
		
		new PageInactiveMedicalProblemAndVerifyStatusWithJson(driver, wait, builder).closeEncounter(visitType,
				noCharges, true);

	}

	void performExamTabOperationForExternalExam(String confonationLocation, String confonationSeverity,
			String orbitPathlogy, String orbitLocation, String orbitModifier, String orbitSeverity,
			String ocularCategory, String ocularGlaucoma, String ocularLocation, String ocularModifier,
			String ocularSeverity, String pupilLight, String pupilShape, String pupilReactivity, String pupilRAPD)
			throws Exception {

		performConfronationOperation(confonationLocation, confonationSeverity);

		performOrbitOperation(orbitPathlogy, orbitLocation, orbitModifier, orbitSeverity);

		performOcularMobilityOperation(ocularCategory, ocularGlaucoma, ocularLocation, ocularModifier, ocularSeverity);

		performPupilOperation(pupilLight, pupilShape, pupilReactivity, pupilRAPD);
	}

	public void performConfronationOperation(String confonationLocation, String confonationSeverity) throws Exception {

		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Confrontation VF");

		try {
			for (WebElement selectLocation : select_ConfronationLocation) {
				if (selectLocation.getText().equalsIgnoreCase(confonationLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_ConfronationSeverity) {
				if (selectModifier.getText().equalsIgnoreCase(confonationSeverity)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performOrbitOperation(String orbitPathlogy, String orbitLocation, String orbitModifier,
			String orbitSeverity) throws Exception {

		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Orbit-Lids-Lacrimal");

		for (WebElement selectGalucomaValue : select_OrbitPathlogy) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(orbitPathlogy)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_OrbitLocation) {
				if (selectLocation.getText().equalsIgnoreCase(orbitLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_OrbitModifier) {
				if (selectModifier.getText().equalsIgnoreCase(orbitModifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_OrbitSeverity) {
				if (selectSeverity.getText().equalsIgnoreCase(orbitSeverity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performOcularMobilityOperation(String ocularCategory, String ocularGlaucoma, String ocularLocation,
			String ocularModifier, String ocularSeverity) throws Exception {

		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Ocular Motility");

		for (WebElement selectCategory : select_OcularCornea) {
			if (selectCategory.getText().equalsIgnoreCase(ocularCategory)) {
				selectCategory.click();
				break;
			}
		}

		for (WebElement selectGalucomaValue : select_OcularConjunctive) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(ocularGlaucoma)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_OcularLocation) {
				if (selectLocation.getText().equalsIgnoreCase(ocularLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_OcularModifiers) {
				if (selectModifier.getText().equalsIgnoreCase(ocularModifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_OcularSeverity) {
				if (selectSeverity.getText().equalsIgnoreCase(ocularSeverity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performPupilOperation(String pupilLight, String pupilShape, String pupilReactivity, String pupilRAPD)
			throws Exception {

		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Pupil");

		String[] splitLight = pupilLight.split("-");

		try {
			for (WebElement selectLocation : select_BrightLight) {
				if (selectLocation.getText().equalsIgnoreCase(splitLight[0])) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_DimLight) {
				if (selectModifier.getText().equalsIgnoreCase(splitLight[1])) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_PupilShape) {
				if (selectSeverity.getText().equalsIgnoreCase(pupilShape)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_PupilReactivity) {
				if (selectSeverity.getText().equalsIgnoreCase(pupilReactivity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_RAPD) {
				if (selectSeverity.getText().equalsIgnoreCase(pupilRAPD)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
