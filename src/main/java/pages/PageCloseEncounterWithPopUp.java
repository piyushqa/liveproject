package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;

public class PageCloseEncounterWithPopUp {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"root\"]/select")
	private WebElement selectIntegritySettings;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/section/div[16]/input")
	private WebElement getValueOfInternalId;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/section/div[18]/input")
	private WebElement getValueOfReconDocument;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody > tr > td> div")
	private List<WebElement> selectOtherHistory;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content > div > div:nth-child(3) > div > div:nth-child(2) > div> div.datalist-item")
	private List<WebElement> checkPopUpRadionBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content > div > div:nth-child(3) > div > div:nth-child(2) > div> div.datalist-selected")
	private WebElement chckBoxConsultNote;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content > div > div:nth-child(3) > div > div:nth-child(2) > div> div.datalist-item:nth-child(2)")
	private WebElement chckBoxHistoryAndPhysical;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content > div > div:nth-child(3) > div > div:nth-child(2) > div> div.datalist-item:nth-child(3)")
	private WebElement chckBoxProgressNote;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok")
	private WebElement clickOnContinueBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_content>div>div:nth-child(2)>div>textarea")
	private WebElement checkTextBox;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageCloseEncounterWithPopUp(WebDriverWait wait, WebDriver driver, Actions builder) {
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageCloseEncounterWithPopUp.this);
	}

	public void verifyCloseEncounterWithPopUp(String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges, boolean ConsultNote,
			boolean HistoryAndPhysical, boolean ProgressNote) throws Exception {

		new PageReconFin(driver, wait, builder).handleIntegritySettings();

		Thread.sleep(4000);
		String reconDocumentSelectValue = new PageASCIntegration(wait, driver, builder).performASCSettingIntegrationOpertion("reconDocumentSelect");
		System.out.println(reconDocumentSelectValue);

		Thread.sleep(4000);
		String reconInternalidEnabledValue = new PageASCIntegration(wait, driver, builder).performASCSettingIntegrationOpertion("reconInternalidEnabled");
		System.out.println(reconInternalidEnabledValue);

		if (reconDocumentSelectValue.equalsIgnoreCase("true") && reconInternalidEnabledValue.equalsIgnoreCase("true")) {

			performCommonOpertionForAllContion(fName, lName, category, subCategory1, subCategory2, eye,
					galuocmaSeverity, galuocmaStability, significantProblem);

			closeEncounter(visitType, noCharges);

			performCodingPopUpOperation(ConsultNote, HistoryAndPhysical, ProgressNote);
		} else if (reconDocumentSelectValue.equalsIgnoreCase("false") && reconInternalidEnabledValue.equalsIgnoreCase("true")) {

			performCommonOpertionForAllContion(fName, lName, category, subCategory1, subCategory2, eye,
					galuocmaSeverity, galuocmaStability, significantProblem);

			closeEncounter(visitType, noCharges);

			performCodingPopUpOperation(ConsultNote, HistoryAndPhysical, ProgressNote);
		}

		else if (reconDocumentSelectValue.equalsIgnoreCase("true") && reconInternalidEnabledValue.equalsIgnoreCase("false")) {

			performCommonOpertionForAllContion(fName, lName, category, subCategory1, subCategory2, eye,
					galuocmaSeverity, galuocmaStability, significantProblem);

			closeEncounter(visitType, noCharges);

			performCodingPopUpOperation(ConsultNote, HistoryAndPhysical, ProgressNote);

		} else if (reconDocumentSelectValue.equalsIgnoreCase("false") && reconInternalidEnabledValue.equalsIgnoreCase("false")) {

			performCommonOpertionForAllContion(fName, lName, category, subCategory1, subCategory2, eye,
					galuocmaSeverity, galuocmaStability, significantProblem);

			new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
		} else {
			System.out.println("No match");
		}

	}

	public void serchPatient(String fName, String lName) throws Exception {

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
	}

	public void performCommonOpertionForAllContion(String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem) throws Exception {

		Thread.sleep(5000);
		driver.navigate().back();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new PageReconFin(driver, wait, builder).logInFunction(ProjectSettings.userName, ProjectSettings.password);

		serchPatient(fName, lName);

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

	}

	public void closeEncounter(String visitType, Boolean noCharges) throws Exception {

		Thread.sleep(9000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_EyeHistorty : selectOtherHistory) {
			if (select_EyeHistorty.getText().equalsIgnoreCase("Coding")) {
				select_EyeHistorty.click();
				break;
			}
		}

		// click On Visit Type
		Thread.sleep(5000);
		builder.moveToElement(clickOnVistType).click().perform();

		// select_VisitType
		Thread.sleep(5000);

		int select_VisitType = driver.findElements(By.xpath(".//div[@id=\"gwt-debug-visitType-container\"]/div"))
				.size();
		System.out.println(select_VisitType);
		for (int i = 1; i <= select_VisitType; i++)
			if (driver.findElement(By.xpath(".//div[@id=\"gwt-debug-visitType-container\"]/div[" + i + "]")).getText()
					.equalsIgnoreCase(visitType)) {
				driver.findElement(By.xpath(".//div[@id=\"gwt-debug-visitType-container\"]/div[" + i + "]")).click();
				break;
			}

		// clickOnNoCharges
		Thread.sleep(4000);
		if (!clickOnNoCharges.isSelected() && noCharges) {
			builder.moveToElement(clickOnNoCharges).click().perform();
		}

		// click On submit and close
		Thread.sleep(2000);
		builder.moveToElement(clickOnsubmitandclose).click().perform();

	}

	public void performCodingPopUpOperation(boolean ConsultNote, boolean HistoryAndPhysical, boolean ProgressNote)
			throws Exception {
		boolean value = false;
		// int count = 0;

		// count = checkPopUpRadionBtn.size();

		if ((chckBoxConsultNote.isDisplayed()) && (chckBoxHistoryAndPhysical.isDisplayed())
				&& (chckBoxProgressNote.isDisplayed()) && (checkTextBox.isDisplayed()) == true) {
			// checkTextBox.sendKeys(" InternalID as TRUE AND ReconDocument set as True");
			// performCodingPopUpOperation(ConsultNote, HistoryAndPhysical, ProgressNote);
			System.out.println("ConsultNote" + "," + "HistoryAndPhysical" + "," + "ProgressNote" + "," + "TextBox" + ","
					+ "are display");
			clickOnContinueBtn.click();
		}

		else if ((chckBoxConsultNote.isDisplayed()) && (chckBoxHistoryAndPhysical.isDisplayed())
				&& (chckBoxProgressNote.isDisplayed()) == true) {
			// performCodingPopUpOperation(ConsultNote, HistoryAndPhysical, ProgressNote);
			System.out.println("ConsultNote" + "," + "HistoryAndPhysical" + "," + "ProgressNote" + "," + "are display");
			clickOnContinueBtn.click();
		}

		else if (checkTextBox.isDisplayed() == true) {
			// checkTextBox.sendKeys(" InternalID as TRUE AND ReconDocument set as FALSE");
			System.out.println("TextBox" + " " + "display");
			clickOnContinueBtn.click();

		}

	}

	public void perfromRadiobuttonOpertion(boolean ConsultNote, boolean HistoryAndPhysical, boolean ProgressNote)
			throws Exception {

		if (!chckBoxConsultNote.isSelected() && ConsultNote) {
			chckBoxConsultNote.click();
		}

		if (!chckBoxHistoryAndPhysical.isSelected() && HistoryAndPhysical) {
			chckBoxHistoryAndPhysical.click();
		}

		if (!chckBoxProgressNote.isSelected() && ProgressNote) {
			chckBoxProgressNote.click();
		}
	}
}
