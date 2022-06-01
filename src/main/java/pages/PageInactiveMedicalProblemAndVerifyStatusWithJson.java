package pages;

import java.awt.Color;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.ProjectSettings;

public class PageInactiveMedicalProblemAndVerifyStatusWithJson {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.CSS, using = "div#gwt-debug-startNewEncounter>a")
	private WebElement clickOnStartNewEncounter;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok.gwt-Anchor")
	private WebElement clickOnYes;

	@FindBy(how = How.CSS, using = "div#gwt-debug-medicalHistory>div>div>div>div:nth-child(1)>div:nth-child(2)")
	private WebElement clickOnMedicalHistory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-medicalHistory\"]/div[1]/div[1]/div/div[2]/div")
	private List<WebElement> selectMedicalHistory;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody > tr > td> div")
	private List<WebElement> selectOtherHistory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[1]/span")
	private WebElement clickOnAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div")
	private List<WebElement> selectCategory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div")
	private List<WebElement> selectSecondCategory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div")
	private List<WebElement> selectThirdCategory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div")
	private List<WebElement> selectEye;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div")
	private List<WebElement> selectInjuryhistory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div")
	private List<WebElement> selectStability;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Significant Problem\"]")
	private WebElement clickOnSignificantProblem;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Inactive\"]")
	private WebElement clickOnInactive;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Done\"]")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//input[@class=\"datepicker endDate hasDatepicker\"]")
	private WebElement clickOnDatePicker;

	@FindBy(how = How.CSS, using = "select.ui-datepicker-month")
	private WebElement selectMonth;

	@FindBy(how = How.CSS, using = "select.ui-datepicker-year")
	private WebElement selectYear;

	@FindBy(how = How.CSS, using = "table.ui-datepicker-calendar>tbody>tr>td>a")
	private List<WebElement> selectdate;

	@FindBy(how = How.CSS, using = "select.batchStatusDropdown")
	private WebElement selectStatus;

	@FindBy(how = How.CSS, using = "select.PatientSearchOption")
	private WebElement selectExam;

	@FindBy(how = How.CSS, using = "input#pFirstName")
	private WebElement inputPatientName;

	@FindBy(how = How.CSS, using = "input#searchPatinet")
	private WebElement clickOnsearch;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"table table-striped table-bordered dataTable\"]/tbody/tr[1]/td/i")
	private WebElement clickOnPlusSymbol;

	// =======================================================================================
	@FindBy(how = How.XPATH, using = ".//span[@class=\"gwt-RadioButton\"][1]/input[@name=\"MEDS_VERIFIED\"]")
	private WebElement clickOnYesBtnOfMedicine;

	@FindBy(how = How.XPATH, using = "//span[@class=\"gwt-InlineLabel\"]")
	private WebElement getCssValueOfMedicineText;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[3]/div[2]/div/div[1]/div/div[3]")
	private WebElement slectValue;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div/div[2]/div")
	private List<WebElement> select_SuperVisorValue;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageInactiveMedicalProblemAndVerifyStatusWithJson(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageInactiveMedicalProblemAndVerifyStatusWithJson.this);
	}

	public void verifyInactiveMedicalProblemAndVerifyStatusWithJson(String mrn, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges, Boolean inactive, String date,
			Boolean medicineStatus) throws Exception {

		// addMedicalProblems(significantProblem, inactive);
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		closeEncounter(visitType, noCharges, medicineStatus);
	}

	public void inactiveTheMedicalProblems() throws Exception {
		ensureElementToBeClickable(clickOnMedicalHistory);
		clickOnMedicalHistory.click();

		for (WebElement select_MedicalHistory : selectMedicalHistory) {
			if (select_MedicalHistory.getText().equalsIgnoreCase("Medical Problems - Inactive/Resolved")) {
				select_MedicalHistory.click();
				break;
			}
		}

	}

	public void addMedicalProblems(Boolean significantProblem, Boolean inactive) throws Exception {
		Thread.sleep(9000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_EyeHistorty : selectOtherHistory) {
			if (select_EyeHistorty.getText().equalsIgnoreCase("Other History")) {
				select_EyeHistorty.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnAdd);
		clickOnAdd.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(selectCategory);
		for (WebElement select_Category : selectCategory) {
			if (select_Category.getText().equalsIgnoreCase("Injury and Poisoning")) {
				select_Category.click();
				break;
			}
		}
		Thread.sleep(3000);
		ensureElementToBeClickable(selectSecondCategory);
		for (WebElement select_SecondCategory : selectSecondCategory) {
			if (select_SecondCategory.getText().equalsIgnoreCase("Eye")) {
				select_SecondCategory.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(selectThirdCategory);
		for (WebElement select_ThirdCategory : selectThirdCategory) {
			if (select_ThirdCategory.getText()
					.equalsIgnoreCase("Avulsion of eye, unspecified eye, initial encounter")) {
				select_ThirdCategory.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(selectEye);
		for (WebElement select_Eye : selectEye) {
			if (select_Eye.getText().equalsIgnoreCase("left eye")) {
				select_Eye.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(selectInjuryhistory);
		for (WebElement select_InjuryHistory : selectInjuryhistory) {
			if (select_InjuryHistory.getText().equalsIgnoreCase("sequela")) {
				select_InjuryHistory.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(selectStability);
		for (WebElement select_Stability : selectStability) {
			if (select_Stability.getText().equalsIgnoreCase("slowly worsening")) {
				select_Stability.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnSignificantProblem);
		if (!clickOnSignificantProblem.isSelected() && significantProblem) {
			clickOnSignificantProblem.click();
		}

//		ensureElementToBeClickable(clickOnInactive);
//		if (!clickOnInactive.isSelected() && inactive) {
//			clickOnInactive.click();
//		}

		ensureElementToBeClickable(clickOnDone);
		builder.moveToElement(clickOnDone).click().build().perform();
	}

	public void closeEncounter(String visitType, Boolean noCharges, boolean medicineStatus) throws Exception {

		Thread.sleep(9000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_EyeHistorty : selectOtherHistory) {
			if (select_EyeHistorty.getText().equalsIgnoreCase("Coding")) {
				select_EyeHistorty.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnYesBtnOfMedicine);
		if (!clickOnYesBtnOfMedicine.isSelected() && medicineStatus) {
			clickOnYesBtnOfMedicine.click();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getValueOfExceptionTest();

		// click On Visit Type
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnVistType);
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
		ensureElementToBeClickable(clickOnsubmitandclose);
		builder.moveToElement(clickOnsubmitandclose).click().perform();

	}

	public void getValueOfExceptionTest() throws Exception {
		String expected = "Eligible Not Satisfied";
		String getValue = getCssValueOfMedicineText.getText();
		System.out.println(getValue);
		try {
			Assert.assertEquals(getValue, expected);
		} catch (Exception e) {
			System.out.println("When we click on yes button it give wrong exception");
		}

	}

//	public void perFormRcpConnecterOpertaion(String date, String mrn) throws Exception {
//
//		driver.get(ProjectSettings.rcpCoonecter);
//
//		new PageMatchMedicationAndAllergieWithPatientEducation(driver, wait, builder).handleWindow();
//
//		ensureElementToBeClickable(clickOnDatePicker);
//		clickOnDatePicker.click();
//
//		String[] strDate = date.split("-");
//
//		Select select_Date = new Select(selectMonth);
//		select_Date.selectByVisibleText(strDate[0]);
//
//		select_Date = new Select(selectYear);
//		select_Date.selectByVisibleText(strDate[2]);
//
//		for (WebElement select_date : selectdate) {
//			if (select_date.getText().equalsIgnoreCase(strDate[1])) {
//				select_date.click();
//				break;
//			}
//		}
//
//		Select select_Status = new Select(selectStatus);
//		select_Status.selectByVisibleText("Success(DEP)");
//
//		Select select_Exam = new Select(selectExam);
//		select_Exam.selectByVisibleText("Patient");
//
//		Thread.sleep(5000);
//		ensureElementToBeClickable(inputPatientName);
//		inputPatientName.sendKeys(mrn);
//
//		Thread.sleep(4000);
//		builder.moveToElement(clickOnsearch).click().build().perform();

//		Thread.sleep(15000);
//		ensureElementToBeClickable(clickOnPlussymbol);
//		clickOnPlussymbol.click();
//	}

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
