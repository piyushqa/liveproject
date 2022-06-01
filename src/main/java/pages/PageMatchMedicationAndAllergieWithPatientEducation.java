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
import org.testng.Reporter;


public class PageMatchMedicationAndAllergieWithPatientEducation {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody > tr > td> div")
	private List<WebElement> selectEyeHistory;
	
	@FindBy(how=How.CSS,using="table#gwt-debug-encounterTabBar>tbody>tr>td:nth-child(3)>div")
	private WebElement clickOnOtherHistory;

	@FindBy(how = How.CSS, using = "#gwt-debug-eye-erx")
	private WebElement clickOnErx;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ErxDataPopUp\"]/a")
	private WebElement clickOnDrFirstLaunch;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Manage Medications\"]")
	private WebElement matchManageMedication;

	@FindBy(how = How.CSS, using = "td#favorites_select_box_id>select#favorites_select_box")
	private WebElement clickOnFaviourties;

	@FindBy(how = How.CSS, using = "select#favorites_select_box>option:nth-child(2)")
	private WebElement selectMedicine;

	@FindBy(how = How.CSS, using = "#favorites_select_box_id > input[type=\"submit\"]:nth-child(2)")
	private WebElement clickOnUse;

	@FindBy(how = How.XPATH, using = ".//input[@value=\" Add \"]")
	private WebElement clickOnAdd;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"review_prescription2\"]")
	private WebElement clickOnContinue;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Manage Allergies\"]")
	private WebElement clickOnManageAllergies;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-close_overlay\"]/a[contains(@class,'close')]")
	private WebElement clickOnClose;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-eye-meds-item-0\"]/div[2]/img")
	private WebElement clickOnAlwayesFirstIinMed;

	@FindBy(how = How.CSS, using = "div#gwt-debug-eye-meds-container>div:nth-child(1)>div:nth-child(1)")
	private WebElement getMedNameFromOtherHistory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div")
	private WebElement hoverOnMedData;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-Done\"]")
	private WebElement clickOnMedDone;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/img")
	private WebElement clickOnAlwayesFirstIinAllergie;

	@FindBy(how = How.CSS, using = "div#gwt-debug-patientEducation>a")
	private WebElement clickOnPatientEducation;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-\"]")
	private WebElement clickOnClosePatientEducation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-suggestedDocs-container>div")
	private List<WebElement> selectPatientEducationData;

	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_content>div>div>div:nth-child(2)>div")
	private WebElement getMedicineHoverData;

	public PageMatchMedicationAndAllergieWithPatientEducation(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageMatchMedicationAndAllergieWithPatientEducation.this);
	}

	public void verifyMatchMedicationAndAllergieWithPatientEducation(String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges, String medicene, String allergies,
			String recation, String severity, String Date) throws Exception {

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		prescribeMedicine(medicene);

		prescribeAllergie(allergies, recation, severity, Date);

		matchMedData();

		Thread.sleep(3000);
		performImpAndPlanOperation();

		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	public void prescribeMedicine(String medicene) throws Exception {

		// ensureElementToBeClickable(selectEyeHistory);
		Thread.sleep(9000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_EyeHistorty : selectEyeHistory) {
			if (select_EyeHistorty.getText().equalsIgnoreCase("Eye History")) {
				select_EyeHistorty.click();
				break;
			}
		}

		// click on eRX
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnErx);
		clickOnErx.click();

		// click on dr.FirstLaunch
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDrFirstLaunch);
		clickOnDrFirstLaunch.click();

		Thread.sleep(3000);
		handleWindow();

		Thread.sleep(3000);
		addMedicine(medicene);
	}

	public void addMedicine(String medicene) throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(matchManageMedication);
		matchManageMedication.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnFaviourties);
		clickOnFaviourties.click();

		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		// for (WebElement select_Medicine : selectMedicine) {
		// if (select_Medicine.getText().startsWith(medicene)) {
		// builder.moveToElement(select_Medicine).click().perform();
		// break;
		// }
		// }
		String storeMedicine = selectMedicine.getText();
		selectMedicine.click();

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnAdd);
		clickOnAdd.click();

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnContinue);
		clickOnContinue.click();

	}

	public void prescribeAllergie(String allergies, String recation, String severity, String Date) throws Exception {

		// click on manage allergies
		Thread.sleep(6000);
		clickOnManageAllergies.click();

		new PageAddAllergies(driver, wait, builder).addAllergie(allergies, recation, severity, Date);

		// close Dr First window
		Thread.sleep(2000);
		driver.close();

		Thread.sleep(2000);
		handleWindow();

		Thread.sleep(2000);
		builder.moveToElement(clickOnClose).click().perform();
	}

	public String matchMedData() throws Exception {
		String getMedName = null;
		
//		Thread.sleep(3000);
//		clickOnOtherHistory.click();
		
		Thread.sleep(6000);
		getMedName = getMedNameFromOtherHistory.getText();
		// getMedName.endsWith("timolol");

		Thread.sleep(5000);
		clickOnAlwayesFirstIinMed.click();

		Thread.sleep(4000);
		String hoverData = hoverOnMedData.getText();
		builder.moveToElement(hoverOnMedData);
		builder.click();

		Thread.sleep(4000);
		String matchHoverData = getMedicineHoverData.getText();

		Thread.sleep(4000);
		if (matchHoverData.endsWith(hoverData)) {
			Reporter.log(matchHoverData + " " + "same as" + " " + hoverData);
			System.out.println((matchHoverData + " " + "same as" + " " + hoverData));

		}
		Thread.sleep(5000);
		builder.perform();

		Thread.sleep(3000);
		clickOnMedDone.click();
		return getMedName;
	}

	public void metchAllergieData() throws Exception {

		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_EyeHistorty : selectEyeHistory) {
			if (select_EyeHistorty.getText().equalsIgnoreCase("Other History")) {
				select_EyeHistorty.click();
				break;
			}
		}

	}

	public void performImpAndPlanOperation() throws Exception {
		String strPatientEducationData = null;

		String getMedName = matchMedData();
		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_EyeHistorty : selectEyeHistory) {
			if (select_EyeHistorty.getText().equalsIgnoreCase("Imp & Plan")) {
				select_EyeHistorty.click();
				break;
			}
		}

		Thread.sleep(5000);
		clickOnPatientEducation.click();

		try {
			driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
			for (WebElement select_PatientEducationData : selectPatientEducationData) {
				if (select_PatientEducationData.getText().equalsIgnoreCase("Timolol Ophthalmic")) {
					strPatientEducationData = select_PatientEducationData.getText();
					System.out.println(strPatientEducationData);
					break;
				}
			}
			Thread.sleep(6000);
			if (getMedName.endsWith(strPatientEducationData)) {
				System.out.println(getMedName.endsWith(strPatientEducationData));
				Reporter.log(strPatientEducationData + " " + "Same as" + getMedName);
			}

			Thread.sleep(3000);
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(clickOnClosePatientEducation)).click();
		} catch (Exception e) {

			Thread.sleep(3000);
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(clickOnClosePatientEducation)).click();
		}
	}

	public void handleWindow() {
		for (String controlWindowhandle : driver.getWindowHandles()) {
			driver.switchTo().window(controlWindowhandle);
		}

	}

	// finction use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	private void ensureElementToBeClickable(List<WebElement> element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}
}
