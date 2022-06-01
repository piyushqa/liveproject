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

public class PageAnteriorSegment {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;

	@FindBy(how = How.CSS, using = "div.encounter_tab_bar_container>table>tbody>tr>td:nth-child(8)>div")
	WebElement clickOnExamTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listing17\"]/tbody//tr[7]/td[2]/div")
	WebElement clickOnConjunctiveAndSclera;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:first-child>div:nth-child(2)>div")
	private List<WebElement> select_CategoryConjunctiveAndSclera;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)")
	private List<WebElement> select_CategoryConjunctive;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_ConjunctiveLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>Div>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_ConjunctiveModifiers;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_ConjunctiveSeverity;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-right-comments")
	private WebElement fillText;

	@FindBy(how = How.CSS, using = "div#gwt-debug-copy-summary-right")
	private WebElement clickOnRightCopyBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-exam-data-done>a")
	private WebElement clickOnDoneBtn;

	// WebElement for Cornea,Anterior Chamber,Lens

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:first-child>div:nth-child(2)>div")
	private List<WebElement> select_CategoryCornea;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)")
	private List<WebElement> select_CorneaConjunctive;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_CorneaLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_CorneaModifiers;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_CorneaSeverity;

	// WebElement for Iris

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div:nth-child(2)")
	private List<WebElement> select_IrisPathlogy;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_IrisLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_IrisModifier;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_IrisSeverity;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageAnteriorSegment(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAnteriorSegment.this);
	}

	public void checkAnteriorSegment(String firstName, String lastName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			boolean significantProblem, String visitType, boolean noCharges, String ConjunctiveCategory,
			String ConjunctiveOther, String ConjunctiveLocation, String ConjunctiveModifier, String ConjunctiveSeverity,
			String CorneaCategory, String CorneaOther, String CorneaLocation, String CorneaModifier,
			String CorneaSeverity, String anteriorOther, String anteriorLocation, String anteriorModifier,
			String anteriorSeverity, String irisOther, String irisLocation, String irisModifier, String irisSeverity,
			String lensCategory, String lensOther, String lensLocation, String lensModifier, String lensSeverity)
			throws Exception {

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
		ensureElementToBeClickable(clickOnConjunctiveAndSclera);
		clickOnConjunctiveAndSclera.click();

		performExamTabOperationForAnteriorSegment(ConjunctiveCategory, ConjunctiveOther, ConjunctiveLocation,
				ConjunctiveModifier, ConjunctiveSeverity, CorneaCategory, CorneaOther, CorneaLocation, CorneaModifier,
				CorneaSeverity, anteriorOther, anteriorLocation, anteriorModifier, anteriorSeverity, irisOther,
				irisLocation, irisModifier, irisSeverity, lensCategory, lensOther, lensLocation, lensModifier,
				lensSeverity);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();

		new PageInactiveMedicalProblemAndVerifyStatusWithJson(driver, wait, builder).closeEncounter(visitType,
				noCharges, true);

	}

	void performExamTabOperationForAnteriorSegment(String ConjunctiveCategory, String ConjunctiveOther,
			String ConjunctiveLocation, String ConjunctiveModifier, String ConjunctiveSeverity, String CorneaCategory,
			String CorneaOther, String CorneaLocation, String CorneaModifier, String CorneaSeverity,
			String anteriorOther, String anteriorLocation, String anteriorModifier, String anteriorSeverity,
			String irisOther, String irisLocation, String irisModifier, String irisSeverity, String lensCategory,
			String lensOther, String lensLocation, String lensModifier, String lensSeverity) throws Exception {

		performConjunctiveSclera(ConjunctiveCategory, ConjunctiveOther, ConjunctiveLocation, ConjunctiveModifier,
				ConjunctiveSeverity);

		performCornea(CorneaCategory, CorneaOther, CorneaLocation, CorneaModifier, CorneaSeverity);

		performAnteriorChamber(anteriorOther, anteriorLocation, anteriorModifier, anteriorSeverity);

		performIrisOperation(irisOther, irisLocation, irisModifier, irisSeverity);

		performLensOperation(lensCategory, lensOther, lensLocation, lensModifier, lensSeverity);

	}

	public void performConjunctiveSclera(String ConjunctiveCategory, String ConjunctiveOther,
			String ConjunctiveLocation, String ConjunctiveModifier, String ConjunctiveSeverity) throws Exception {

		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Conjunctiva & Sclera");

		for (WebElement selectCategory : select_CategoryConjunctiveAndSclera) {
			if (selectCategory.getText().equalsIgnoreCase(ConjunctiveCategory)) {
				selectCategory.click();
				break;
			}
		}

		for (WebElement selectGalucomaValue : select_CategoryConjunctive) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(ConjunctiveOther)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_ConjunctiveLocation) {
				if (selectLocation.getText().equalsIgnoreCase(ConjunctiveLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_ConjunctiveModifiers) {
				if (selectModifier.getText().equalsIgnoreCase(ConjunctiveModifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_ConjunctiveSeverity) {
				if (selectSeverity.getText().equalsIgnoreCase(ConjunctiveSeverity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(fillText);
		fillText.sendKeys("Optic Disk Vaue");

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performCornea(String CorneaCategory, String CorneaOther, String CorneaLocation, String CorneaModifier,
			String CorneaSeverity) throws Exception {

		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Cornea");

		for (WebElement selectCategory : select_CategoryCornea) {
			if (selectCategory.getText().equalsIgnoreCase(CorneaCategory)) {
				selectCategory.click();
				break;
			}
		}

		for (WebElement selectGalucomaValue : select_CorneaConjunctive) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(CorneaOther)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_CorneaLocation) {
				if (selectLocation.getText().equalsIgnoreCase(CorneaLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_CorneaModifiers) {
				if (selectModifier.getText().equalsIgnoreCase(CorneaModifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_CorneaSeverity) {
				if (selectSeverity.getText().equalsIgnoreCase(CorneaSeverity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(fillText);
		fillText.sendKeys("Optic Disk Vaue");

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performAnteriorChamber(String AnteriorOther, String AnteriorLocation, String AnteriorModifier,
			String AnteriorSeverity) throws Exception {

		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Anterior Chamber");

		for (WebElement selectGalucomaValue : select_CorneaConjunctive) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(AnteriorOther)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_CorneaLocation) {
				if (selectLocation.getText().equalsIgnoreCase(AnteriorLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_CorneaModifiers) {
				if (selectModifier.getText().equalsIgnoreCase(AnteriorModifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_CorneaSeverity) {
				if (selectSeverity.getText().equalsIgnoreCase(AnteriorSeverity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(fillText);
		fillText.sendKeys("Optic Disk Vaue");

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performIrisOperation(String irisOther, String irisLocation, String irisModifier, String irisSeverity)
			throws Exception {
		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Iris");

		for (WebElement selectGalucomaValue : select_IrisPathlogy) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(irisOther)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_IrisLocation) {
				if (selectLocation.getText().equalsIgnoreCase(irisLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_IrisModifier) {
				if (selectModifier.getText().equalsIgnoreCase(irisModifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_IrisSeverity) {
				if (selectSeverity.getText().equalsIgnoreCase(irisSeverity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(fillText);
		fillText.sendKeys("Optic Disk Vaue");

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performLensOperation(String lensCategory, String lensOther, String lensLocation, String lensModifier,
			String lensSeverity) throws Exception {
		new PagePosteriorSegment(driver, wait, builder).selectSegmentValue("Lens");

		for (WebElement selectCategory : select_CategoryCornea) {
			if (selectCategory.getText().equalsIgnoreCase(lensCategory)) {
				selectCategory.click();
				break;
			}
		}

		for (WebElement selectGalucomaValue : select_CorneaConjunctive) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(lensOther)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_CorneaLocation) {
				if (selectLocation.getText().equalsIgnoreCase(lensLocation)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_CorneaModifiers) {
				if (selectModifier.getText().equalsIgnoreCase(lensModifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_CorneaSeverity) {
				if (selectSeverity.getText().equalsIgnoreCase(lensSeverity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(fillText);
		fillText.sendKeys("Optic Disk Vaue");

		ensureElementToBeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
