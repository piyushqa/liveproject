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

public class PagePosteriorSegment {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;

	@FindBy(how = How.CSS, using = "div.encounter_tab_bar_container>table>tbody>tr>td:nth-child(8)>div")
	WebElement clickOnExamTab;

	@FindBy(how = How.XPATH, using = "//span[@class=\"gwt-InlineLabel\" and starts-with(text(),'optic disc')]")
	List<WebElement> clickOnOpticDisk;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listing17\"]/tbody/tr[17]/td[2]/div")
	private WebElement clickOnOpticDisc;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	List<WebElement> select_PosteriorSegment;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:first-child>div>div:nth-child(1)>div:nth-child(2)>div")
	List<WebElement> select_categroy;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div")
	private List<WebElement> select_GalucomaValue;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_Location;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(3)>div>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_Modifiers;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(2)>div>div:last-child>div:first-child>div>div")
	private List<WebElement> select_Severity;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-right-comments")
	private WebElement fillText;

	@FindBy(how = How.CSS, using = "div#gwt-debug-copy-summary-right")
	private WebElement clickOnRightCopyBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-exam-data-done>a")
	private WebElement clickOnDoneBtn;

	// WebElement for Vassel

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div>div>div:nth-child(2)")
	private List<WebElement> select_VasselPathlogy;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_VasselLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_VasselModidfier;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	List<WebElement> select_VasselSeverity;

	// WebElement for Macula

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:first-child>div:nth-child(2)>div")
	private List<WebElement> select_MaculaCategory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)")
	private List<WebElement> select_MaculaDegenration;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_MaculaLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_MaculaModifiers;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_MaculaSeverity;

	// WebElement for Peripheral

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:first-child>div:nth-child(2)>div")
	private List<WebElement> select_PeripheralCategory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)")
	private List<WebElement> select_PeripheralOther;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_PeripheralLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_PeripheralModifiers;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_PeripheralSeverity;

	// WebElement for Vitreous

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)")
	private List<WebElement> select_vitreousPathlogy;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_vitreousLocation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(3)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_vitreousModifiers;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_vitreousSeverity;

	// WebElement for View

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:first-child>div>div:nth-child(2)>div>div:first-child>div>div:nth-child(2)")
	private List<WebElement> select_viewPathlogy;

	@FindBy(how = How.CSS, using = "div#gwt-debug-right-container>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(1)>div>div")
	private List<WebElement> select_vieWModifier;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */

	public PagePosteriorSegment(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PagePosteriorSegment.this);
	}

	public void verifyPosteriorSegment(String firstName, String lastName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			boolean significantProblem, String visitType, boolean noCharges, String Category, String Galucoma,
			String Location, String Modifier, String Severity, String vasselPathlogy, String vasselLocation,
			String vasselModifier, String vasselSeverity, String maculaCategory, String maculaDegeneration,
			String maculaLocation, String maculaModifier, String maculaSeverity, String peripheralCategory,
			String peripheralOther, String peripheralLocation, String peripheralModifiers, String peripheralSeverity,
			String vitreousPathology, String vitreousLocation, String vitreousModifier, String viterousSeverity,
			String viewPathology, String viewModifier, boolean medicineStatus) throws Exception {

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(firstName, lastName, "", editPatient);

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		Thread.sleep(3000);
		ensureElementTobeClickable(clickOnExamTab);
		clickOnExamTab.click();

		Thread.sleep(3000);
		try {
			Thread.sleep(6000);
			clickOnOpticDisc.click();
		} catch (Exception e) {
			clickOnOpticDisk.get(0).click();
		}

		performExamtabOperation(Category, Galucoma, Location, Modifier, Severity, vasselPathlogy, vasselLocation,
				vasselModifier, vasselSeverity, maculaCategory, maculaDegeneration, maculaLocation, maculaModifier,
				maculaSeverity, peripheralCategory, peripheralOther, peripheralLocation, peripheralModifiers,
				peripheralSeverity, vitreousPathology, vitreousLocation, vitreousModifier, viterousSeverity,
				viewPathology, viewModifier);

		Thread.sleep(3000);
		ensureElementTobeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();

		new PageInactiveMedicalProblemAndVerifyStatusWithJson(driver, wait, builder).closeEncounter(visitType,
				noCharges, medicineStatus);
	}

	public void performExamtabOperation(String Category, String Galucoma, String Location, String Modifier,
			String Severity, String vasselPathlogy, String vasselLocation, String vasselModifier, String vasselSeverity,
			String maculaCategory, String maculaDegeneration, String maculaLocation, String maculaModifier,
			String maculaSeverity, String peripheralCategory, String peripheralOther, String peripheralLocation,
			String peripheralModifiers, String peripheralSeverity, String vitreousPathology, String vitreousLocation,
			String vitreousModifier, String viterousSeverity, String viewPathology, String viewModifier)
			throws Exception {

		performOpticDiskOperation(Category, Galucoma, Location, Modifier, Severity);

		performVesselOperation(vasselPathlogy, vasselLocation, vasselModifier, vasselSeverity);

		performMaculaOperation(maculaCategory, maculaDegeneration, maculaLocation, maculaModifier, maculaSeverity);

		performPeripheralRetinaOperation(peripheralCategory, peripheralOther, peripheralLocation, peripheralModifiers,
				peripheralSeverity);

		performVitreousOperation(vitreousPathology, vitreousLocation, vitreousModifier, viterousSeverity);

		performViewOperation(viewPathology, viewModifier);

	}

	public void selectSegmentValue(String segementValue) throws Exception {
		for (WebElement selectPosteriorSegment : select_PosteriorSegment) {
			if (selectPosteriorSegment.getText().equalsIgnoreCase(segementValue)) {
				selectPosteriorSegment.click();
				break;
			}
		}
	}

	public void performOpticDiskOperation(String Category, String Galucoma, String Location, String Modifier,
			String Severity) throws Exception {

		selectSegmentValue("Optic Disc");

		for (WebElement selectCategory : select_categroy) {
			if (selectCategory.getText().equalsIgnoreCase(Category)) {
				selectCategory.click();
				break;
			}
		}

		for (WebElement selectGalucomaValue : select_GalucomaValue) {
			if (selectGalucomaValue.getText().equalsIgnoreCase(Galucoma)) {
				selectGalucomaValue.click();
				break;
			}
		}

		try {
			for (WebElement selectLocation : select_Location) {
				if (selectLocation.getText().equalsIgnoreCase(Location)) {
					selectLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Location drop down not visible");
		}

		try {
			for (WebElement selectModifier : select_Modifiers) {
				if (selectModifier.getText().equalsIgnoreCase(Modifier)) {
					selectModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Modifier drop down not visible");
		}

		try {
			for (WebElement selectSeverity : select_Severity) {
				if (selectSeverity.getText().equalsIgnoreCase(Severity)) {
					selectSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException ex) {
			System.out.println("Optic Disc Severity drop down not visible");
		}

		Thread.sleep(3000);
		ensureElementTobeClickable(fillText);
		fillText.sendKeys("Optic Disk Vaue");

		ensureElementTobeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();
	}

	public void performVesselOperation(String vasselPathlogy, String vasselLocation, String vasselModifier,
			String vasselSeverity) throws Exception {

		selectSegmentValue("Vessels");

		for (WebElement selectVasselPathlogy : select_VasselPathlogy) {
			if (selectVasselPathlogy.getText().equalsIgnoreCase(vasselPathlogy)) {
				selectVasselPathlogy.click();
				break;
			}
		}

		try {
			for (WebElement selectVasselLocation : select_VasselLocation) {
				if (selectVasselLocation.getText().equalsIgnoreCase(vasselLocation)) {
					selectVasselLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Vessels Location drop down not visible");
		}

		try {
			for (WebElement selectVasselModifier : select_VasselModidfier) {
				if (selectVasselModifier.getText().equalsIgnoreCase(vasselModifier)) {
					selectVasselModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Vessels Modidfier drop down not visible");
		}

		try {
			for (WebElement selectVasselSeverity : select_VasselSeverity) {
				if (selectVasselSeverity.getText().equalsIgnoreCase(vasselSeverity)) {
					selectVasselSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Vessels Severity drop down not visible");
		}

		ensureElementTobeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();
	}

	public void performMaculaOperation(String maculaCategory, String maculaDegeneration, String maculaLocation,
			String maculaModifier, String maculaSeverity) throws Exception {

		selectSegmentValue("Macula");

		for (WebElement selectmaculaCategory : select_MaculaCategory) {
			if (selectmaculaCategory.getText().equalsIgnoreCase(maculaCategory)) {
				selectmaculaCategory.click();
				break;
			}
		}

		for (WebElement selectMaculaDegenration : select_MaculaDegenration) {
			if (selectMaculaDegenration.getText().equalsIgnoreCase(maculaDegeneration)) {
				selectMaculaDegenration.click();
				break;
			}
		}

		try {
			for (WebElement selectMaculaLocation : select_MaculaLocation) {
				if (selectMaculaLocation.getText().equalsIgnoreCase(maculaLocation)) {
					selectMaculaLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Macula Location drop down not visible");
		}

		try {
			for (WebElement selectMaculaModifier : select_MaculaModifiers) {
				if (selectMaculaModifier.getText().equalsIgnoreCase(maculaModifier)) {
					selectMaculaModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Macula Modidfier drop down not visible");
		}

		try {
			for (WebElement selectMaculaSeverity : select_MaculaSeverity) {
				if (selectMaculaSeverity.getText().equalsIgnoreCase(maculaSeverity)) {
					selectMaculaSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Macula Severity drop down not visible");
		}
		ensureElementTobeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performPeripheralRetinaOperation(String peripheralCategory, String peripheralOther,
			String peripheralLocation, String peripheralModifiers, String peripheralSeverity) throws Exception {

		selectSegmentValue("Peripheral Retina");

		for (WebElement selectPeripheralCategory : select_PeripheralCategory) {
			if (selectPeripheralCategory.getText().equalsIgnoreCase(peripheralCategory)) {
				selectPeripheralCategory.click();
				break;
			}
		}

		for (WebElement selectPeripheralOther : select_PeripheralOther) {
			if (selectPeripheralOther.getText().equalsIgnoreCase(peripheralOther)) {
				selectPeripheralOther.click();
				break;
			}
		}

		try {
			for (WebElement selectPeripheralLocation : select_PeripheralLocation) {
				if (selectPeripheralLocation.getText().equalsIgnoreCase(peripheralLocation)) {
					selectPeripheralLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Peripheral Location drop down not visible");
		}

		try {
			for (WebElement selectPeripheralModifiers : select_PeripheralModifiers) {
				if (selectPeripheralModifiers.getText().equalsIgnoreCase(peripheralModifiers)) {
					selectPeripheralModifiers.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Peripheral Modifier drop down not visible");
		}

		try {
			for (WebElement selectPeripheralSeverity : select_PeripheralSeverity) {
				if (selectPeripheralSeverity.getText().equalsIgnoreCase(peripheralSeverity)) {
					selectPeripheralSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Peripheral Severity drop down not visible");
		}

		ensureElementTobeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performVitreousOperation(String vitreousPathology, String vitreousLocation, String vitreousModifier,
			String viterousSeverity) throws Exception {

		selectSegmentValue("Vitreous");

		for (WebElement selectVitreousPathlogy : select_vitreousPathlogy) {
			if (selectVitreousPathlogy.getText().equalsIgnoreCase(vitreousPathology)) {
				selectVitreousPathlogy.click();
				break;
			}
		}

		try {
			for (WebElement selectvitreousLocation : select_vitreousLocation) {
				if (selectvitreousLocation.getText().equalsIgnoreCase(vitreousLocation)) {
					selectvitreousLocation.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Vitreous Location drop down not visible");
		}

		try {
			for (WebElement selectVitreousModifiers : select_vitreousModifiers) {
				if (selectVitreousModifiers.getText().equalsIgnoreCase(vitreousModifier)) {
					selectVitreousModifiers.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Vitreous Modifier drop down not visible");
		}

		try {
			for (WebElement selectVitreousSeverity : select_vitreousSeverity) {
				if (selectVitreousSeverity.getText().equalsIgnoreCase(viterousSeverity)) {
					selectVitreousSeverity.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("Vitreous Severity drop down not visible");
		}
		ensureElementTobeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void performViewOperation(String viewPathology, String viewModifier) throws Exception {

		selectSegmentValue("View");

		for (WebElement selectViewPathlogy : select_viewPathlogy) {
			if (selectViewPathlogy.getText().equalsIgnoreCase(viewPathology)) {
				selectViewPathlogy.click();
				break;
			}
		}

		try {
			for (WebElement selectVieWModifier : select_vieWModifier) {
				if (selectVieWModifier.getText().equalsIgnoreCase(viewModifier)) {
					selectVieWModifier.click();
					break;
				}
			}
		} catch (ElementNotVisibleException e) {

			System.out.println("View Modifier drop down not visible");
		}
		ensureElementTobeClickable(clickOnRightCopyBtn);
		clickOnRightCopyBtn.click();

	}

	public void ensureElementTobeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
