package pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;

public class PageRadiologyReport {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// Define Locater
	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ok\" and text()='Yes']")
	private WebElement clickOnYesButton;

	@FindBy(how = How.CLASS_NAME, using = "encounter_tab_bar_container")
	private WebElement encounterTabBarContainer;

	@FindBy(how = How.ID, using = "gwt-debug-addNewPlan")
	private WebElement clickOnAddNewPlan;

	@FindBy(how = How.XPATH, using = "//td[@class=\"gwt-TabBarItem-wrapper\"]/div/div/div[text()=\"Order Radiology\"]")
	private WebElement clickOnAddRadioLogy;

	@FindBy(how = How.ID, using = "gwt-debug-addNewProblem")
	private WebElement clickOnAddNewProblem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]")
	private WebElement clickOnSignficantProblem;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-icd10popup--done\"]/a")
	private WebElement clickOnDoneBtn;

	@FindBy(xpath = ".//textarea[@id=\"gwt-debug-comments\"]")
	private WebElement fillComments;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickOnTheClinicNote;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-headingPanel\"]/div/a")
	private WebElement clickOnCancelBtn;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-orderRadiologyTest\"]/div[2]/div/div[1]/div[2]/input")
	private WebElement clickOnDateBox;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Download\"]")
	private WebElement clickOnDownload;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/div[1]/img")
	private WebElement clickOnCancelButtonOfDownloadPage;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;
	
	@FindBy(how=How.XPATH,using=".//div[text()=\"View\"]")
	private WebElement clickOnView;

	public PageRadiologyReport(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageRadiologyReport.this);
	}

	public void verifyRadiologyReport(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String radioLogyTest,
			String comments, String associatesLabWithProblem, String designateTime, String date, String clinicNoteData,
			String savedDocuments, String downloadPath, String fileName, String visitType, Boolean noCharges)
			throws Exception {

		//Function is used for open encounter
		PageCloseEncounter closeEncounter = new PageCloseEncounter(wait, driver, builder);
		closeEncounter.openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, significantProblem);

		// click On AddNew Plan
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnAddNewPlan);
		clickOnAddNewPlan.click();

		// click on RadioLogy
		Thread.sleep(7000);
		// ensureElememtToBeClickable(clickOnAddRadioLogy);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickOnAddRadioLogy);

		// Select RadioLogy Test
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		try {
			Thread.sleep(5000);
			WebElement select_LabTest = driver
					.findElement(By.xpath(".//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div[text()="
							+ "\"" + radioLogyTest + "\"" + "]"));

			wait.until(ExpectedConditions.elementToBeClickable(select_LabTest));
			wait.until(ExpectedConditions.visibilityOf(select_LabTest));

			builder = new Actions(driver);
			builder.moveToElement(select_LabTest).click().perform();
		} catch (Exception e) {
			e.getMessage();
		}

		// Fill Comments
		Thread.sleep(3000);
		ensureElememtToBeClickable(fillComments);
		wait.until(ExpectedConditions.elementToBeClickable(fillComments)).sendKeys(comments);

		// select problem
		By clickOnProblem = By.xpath("//*[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr[1]/td/div[text()=" + "\""
				+ associatesLabWithProblem + "\"" + "]");
		driver.findElements(clickOnProblem).get(1).click();

		// select designiate Time
		By selectdesignateTime = By.xpath("//*[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr[2]/td/div[text()="
				+ "\"" + designateTime + "\"" + "]");
		driver.findElements(selectdesignateTime).get(1).click();

		// call Date Function
		Thread.sleep(3000);
		selectDate(date);

		// click On done Btn
		WebElement clickOnDone = driver.findElement(By.xpath(
				".//div[@id=\"gwt-debug-orderRadiologyTestFooter\"]/div[2]/div/div[3]/a[@id=\"gwt-debug-Done\" and text()=\"Done\"]"));
		String str = clickOnDone.getAttribute("innerText");
		System.out.println(str);
		ensureElememtToBeClickable(clickOnDone);
		builder = new Actions(driver);
		builder.moveToElement(clickOnDone).doubleClick().perform();

		// click On ClinicNote
		Thread.sleep(3000);
		clickOnTheClinicNote.click();
		Thread.sleep(6000);

		WebElement getClinicNoteData = driver
				.findElement(By.xpath(".//div[starts-with(text(),'" + radioLogyTest + "')]"));
		String strClinicNoteData = getClinicNoteData.getText();
		System.out.println(strClinicNoteData);

		if (strClinicNoteData.startsWith(radioLogyTest)) {
			clickOnCancelBtn.click();
		}

		// click on Document center
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnDocumentCenter);
		clickOnDocumentCenter.click();

		// select_Documents
		List<WebElement> select_Documents = driver
				.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase(savedDocuments)) {
				select_Documents.get(i).click();
				break;
			}
		// click On Download
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickOnDownload.click();

		// check file exist are not if exist then delete
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		isFileDownloaded(downloadPath, fileName);

		// cancel the button of download
		Thread.sleep(6000);

		clickOnCancelButtonOfDownloadPage.click();

		// function used for close encounter
		closeEncounter = new PageCloseEncounter(wait, driver, builder);
		closeEncounter.closeEncounter(visitType, noCharges);

	}

	// Function for select Date

	public void selectDate(String YourDate) throws Exception {
		driver.manage().timeouts().implicitlyWait(ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		Thread.sleep(1000);
		clickOnDateBox.click();
		//Thread.sleep(3000);
		String selectDate = YourDate;

		String sp[] = selectDate.split("/");
		// System.out.println(sp[0]);
		// System.out.println(sp[1]);
		// System.out.println(sp[2]);

		Date d = new Date(selectDate);
		// System.out.println("Date" + d);
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/YYYY");
		// System.out.println("dt" + dt);
		String date = dt.format(d);
		// System.out.println("date" + date);

		String split[] = date.split("/");
		String month = split[0];
		// System.out.println("month" + month);
		String day = split[1];
		// System.out.println("day" + day);
		if (day.charAt(0) == '0')
			day = day.charAt(1) + " ";
		String monthName = month.substring(0, 3);
		// System.out.println("monthName" + monthName);

		String monthYear = monthName + " " + split[2];

		// System.out.println("monthYear" + monthYear);

		Thread.sleep(2000);
		String currentdate = driver
				.findElement(By.xpath("/html/body/div[12]/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).getText();

		// Current Month
		String mm = currentdate.substring(0, 3);
		// Current Year

		String year = currentdate.substring(4, 8);
		// System.out.println("year" + year);

		int monthdateinteger = 0;

		int yearInteger = Integer.parseInt(year);

		// System.out.println("yearInteger" + yearInteger);

		int monthDateReadFromExcel = Integer.parseInt(sp[0]);

		// System.out.println("monthDateReadFromExcel" + monthDateReadFromExcel);

		int yearDateReadFromExcel = Integer.parseInt(split[2]);

		// System.out.println("yearDateReadFromExcel" + yearDateReadFromExcel);

		if (mm.equals("Jan")) {
			monthdateinteger = 1;

		}
		if (mm.equals("Feb")) {
			monthdateinteger = 2;
		}
		if (mm.equals("Mar")) {
			monthdateinteger = 3;
		}
		if (mm.equals("Apr")) {
			monthdateinteger = 4;
		}
		if (mm.equals("May")) {
			monthdateinteger = 5;
		}
		if (mm.equals("Jun")) {
			monthdateinteger = 6;
		}
		if (mm.equals("Jul")) {
			monthdateinteger = 7;
		}
		if (mm.equals("Aug")) {
			monthdateinteger = 8;
		}
		if (mm.equals("Sep")) {
			monthdateinteger = 9;
		}
		if (mm.equals("Oct")) {
			monthdateinteger = 10;
		}
		if (mm.equals("Nov")) {
			monthdateinteger = 11;
		}
		if (mm.equals("Dec")) {
			monthdateinteger = 12;
		}

		int monthdiff = monthDateReadFromExcel - monthdateinteger;

		// System.out.println("MonthDiff" + monthdiff);

		int yeardiff = yearDateReadFromExcel - yearInteger;
		// System.out.println("yearDiff" + yeardiff);
		// Select The Year
		if (monthdiff >= 0 && yeardiff >= 0) {
			while (true) {

				try {
					Thread.sleep(1000);
					if (driver.findElement(By.xpath("//*[text()='" + monthYear + "']")).isDisplayed()) {

						break;
					}

				} catch (Exception e) {
					driver.findElement(By.cssSelector(
							"body > div > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(3) > div > div"))
							.click();
				}

			}
		} else {

			while (true) {

				try {
					Thread.sleep(1000);
					if (driver.findElement(By.xpath("//*[text()='" + monthYear + "']")).isDisplayed()) {

						break;
					}

				} catch (Exception e) {
					driver.findElement(By.cssSelector(
							"body > div.dateBoxPopup > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > div > div"))
							.click();
				}

			}
		}
		// Select the day of the month
		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("/html/body/div[12]/div/table/tbody/tr[2]/td/table/tbody/tr/td[not(contains(@class,'datePickerDay datePickerDayIsFiller'))and not(contains(@class,'datePickerDay datePickerDayIsWeekend datePickerDayIsFiller '))]"));

		for (int i = 0; i < list_AllMonthToBook.size(); i++) {

			if (list_AllMonthToBook.get(i).getText().equalsIgnoreCase(day)) {
				list_AllMonthToBook.get(i).click();
				break;

			}
		}

	}

	// If file download then delete
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				dirContents[i].delete();
				Reporter.log("File Exist and delete");
				return true;
			}
		}
		return false;
	}
	
//	public void performViewDocumentOperations()throws Exception{
//		
//		Thread.sleep(3000);
//		ensureElememtToBeClickable(clickOnView);
//	clickOnView.click();
//	}

	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
