package pages;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import tests.LoginTest;

public class PgAdvancedMDPatient {
	private WebDriver driver;
	private WebDriverWait wait;

	WebElement element;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	public static String firstWinHandle;
	public static String secondWinHandle;
	public static String secondChildhandle;
	private static int n2 = 0;
	String strText = null;
	WebElement firstFrame;
	WebElement secondFrame;
	Actions builder;

	// private static final AtomicInteger count = new AtomicInteger(6);
	// Declare Locater
	@FindBy(how = How.CSS, using = "#content > div > div > div > table > tbody>tr:nth-child(6)>td:nth-child(1)>a")
	private WebElement clickOnIntegrityPm;

	@FindBy(how = How.XPATH, using = ".//button[@type=\"button\" and text()=\"Ask me later\"]")
	private WebElement checkPresentOfelement;

//	@FindBy(how = How.CSS, using = "body > div > header > div.row.pm-main-toolbar > amds-pm-main-toolbar > div > div:nth-child(1) > div.pm-main-toolbar-icons-patient>i:nth-child(1)")
//	private WebElement clickOnPatientCreation;

	@FindBy(xpath = ".//i[@title=\"Patient\"]")
	private WebElement clickOnPatientCreation;

	@FindBy(how = How.CSS, using = "#divPatient > div:nth-child(1) > fieldset:nth-child(1)>div:nth-child(2)>input")
	private WebElement fillPatientName;

	@FindBy(how = How.CSS, using = "#txtPtAddress1")
	private WebElement fillPatientAptSte;

	@FindBy(how = How.CSS, using = "#txtPtAddress2")
	private WebElement fillPatientAddress;

	@FindBy(how = How.CSS, using = "#ellPtZipCode_button > span")
	private WebElement clickOnZipButton;

	@FindBy(how = How.CSS, using = "#txtSearch")
	private WebElement searchZip;

	@FindBy(how = How.CSS, using = "#divOuter > fieldset:nth-child(2)>button:nth-child(1)")
	private WebElement clickOnOkButton;

	@FindBy(how = How.CSS, using = "#selPtGender")
	private WebElement selectGender;

	@FindBy(how = How.CSS, using = "#txtPtEmail")
	private WebElement selectEmail;

	@FindBy(how = How.CSS, using = "#selPtConfidential")
	private WebElement selectConfidential;

	@FindBy(how = How.CSS, using = "#txtPtCommunicationNote")
	private WebElement selectNote;

	@FindBy(how = How.CSS, using = "body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all > div.ui-dialog-buttonpane.ui-widget-content.ui-helper-clearfix > div > button:nth-child(1)>span")
	private WebElement selectNoteOkButton;

	@FindBy(how = How.CSS, using = "#selPtMarital")
	private WebElement clickOnMaterialStatus;

	@FindBy(how = How.CSS, using = "#btntxtPtDOB")
	private WebElement clickOnDobButton;

	@FindBy(how = How.CSS, using = "#divCalendar > table > tbody>tr:nth-child(1)>td:nth-child(4)>select:nth-child(1)")
	private WebElement clickOnDobMonth;

	@FindBy(how = How.CSS, using = "#divCalendar > table > tbody>tr:nth-child(1)>td:nth-child(4)>select:nth-child(2)")
	private WebElement clickOnDobyear;

	@FindBy(how = How.CSS, using = "#spnTabName")
	private WebElement clickforEnableElement;

	@FindBy(how = How.CSS, using = "#txtPtAge")
	private WebElement clickOnCalculateAge;

	@FindBy(how = How.XPATH, using = "//*[@id=\"txtPtSSN\"]")
	private WebElement selectSSN;

	@FindBy(how = How.CSS, using = "#txtPtAddtMRN")
	private WebElement selectMRN;

	@FindBy(how = How.CSS, using = "#btnPtSave")
	private WebElement selectSaveBtn;

	@FindBy(how = How.CSS, using = "#divPatient > div:nth-child(1) > fieldset:nth-child(1)>input:nth-child(4)")
	private WebElement getMrnText;

	@FindBy(how = How.CSS, using = "#content > div > div > div:nth-child(4) > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > a")
	private WebElement clickOnCodingIntegrationPatient;

	@FindBy(how = How.CSS, using = "#app > div > div.controls > div > div:nth-child(6) > div > span")
	private WebElement clickOnType;

	@FindBy(how = How.CSS, using = "#app > div > div.controls > div > div:nth-child(8) > div > span")
	private WebElement clickOnStatus;

	@FindBy(how = How.CSS, using = "#content > div > div> div> table > tbody>tr:nth-child(1)>td:nth-child(1)>a")
	private WebElement clickSearchPatient;

	@FindBy(how = How.CSS, using = "#gwt-debug-mrn")
	private WebElement enterMrnValue;

	@FindBy(how = How.CSS, using = "#gwt-debug-searchButton > a")
	private WebElement clickOnsearchBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-searchResultTable > tbody>tr>td:nth-child(6)")
	private WebElement clickOnPatientText;

	@FindBy(how = How.CSS, using = "#gwt-debug-editPatient")
	private WebElement clickOnEditDemographics;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-demographicsDone\"]/a[text()='Done']")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	public PgAdvancedMDPatient(WebDriver driver, WebDriverWait wait, Actions builder) {

		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void createPatientMd(String name, String aptSte, String address, String zip, String gender, String email,
			String confidential, String note, String materialStatus, String ssn, String mrn, String month, String year,
			String day, String type, String status) throws Exception {

		launchPMSPatientCreation();

		// send the value to fill Patientname
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(fillPatientName);

		fillPatientName.sendKeys(name);

		// send the value to fill PatientAptSte
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(fillPatientAptSte);
		fillPatientAptSte.sendKeys(aptSte);

		// send the value to fill PatientAddres
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(fillPatientAddress);
		fillPatientAddress.sendKeys(address);

		// click on Zip Button
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(clickOnZipButton);
		clickOnZipButton.click();

		// switch to window
		for (String windowName : driver.getWindowHandles())

		{

			driver.switchTo().window(windowName);

		}

		// select zip code
		Thread.sleep(10000);
		List<WebElement> list_AllZipcode = driver.findElements(By.tagName("td"));
		System.out.println(list_AllZipcode.size());
		for (int i = 0; i < list_AllZipcode.size(); i++) {

			if (list_AllZipcode.get(i).getText().equalsIgnoreCase(zip)) {

				// System.out.println(list_AllZipcode.get(i).getText().equalsIgnoreCase(zip));
				list_AllZipcode.get(i).click();
				break;

			}

		}

		// click on window ok button
		Thread.sleep(5000);
		clickOnOkButton.click();

		// Switch to window and frame
		Thread.sleep(5000);
		driver.switchTo().window(secondWinHandle);
		firstFrame = driver.findElement(By.cssSelector("iframe[class='pm-legacy']"));
		driver.switchTo().frame(firstFrame);
		secondFrame = driver.findElement(By.xpath(".//iframe[@ src='patientfiles/demo_main.asp?NewReferral=true']"));
		driver.switchTo().frame(secondFrame);
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectGender);
		selectGender.click();

		// select gender
		Thread.sleep(4000);

		List<WebElement> list_SelectGendet = driver.findElements(By.cssSelector("#selPtGender>option"));

		for (int i = 0; i < list_SelectGendet.size(); i++) {

			if (list_SelectGendet.get(i).getText().equalsIgnoreCase(gender)) {
				//
				// System.out.println(list_AllZipcode.get(i).getText().equalsIgnoreCase(zip));
				list_SelectGendet.get(i).click();
				break;

			}

		}

		// fill the email value
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectEmail);
		selectEmail.sendKeys(email);

		// select confidential

		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectConfidential);
		selectConfidential.click();

		// select Note
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectNote);
		selectNote.click();
		// Thread.sleep(4000);
		selectNote.sendKeys(note);
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectNote);
		selectNoteOkButton.click();

		// select confidential status
		// Thread.sleep(4000);

		List<WebElement> list_confidentialStatus = driver.findElements(By.cssSelector("#selPtConfidential>option"));

		for (int i = 0; i < list_confidentialStatus.size(); i++) {

			if (list_confidentialStatus.get(i).getText().equalsIgnoreCase(confidential)) {

				list_confidentialStatus.get(i).click();
				break;

			}

		}

		// click On MaterialStatus
		// Thread.sleep(3000);

		clickOnMaterialStatus.click();

		// select On MaterialStatus
		// Thread.sleep(4000);

		List<WebElement> list_materialStatus = driver.findElements(By.cssSelector("#selPtMarital>option"));

		for (int i = 0; i < list_materialStatus.size(); i++) {

			if (list_materialStatus.get(i).getText().equalsIgnoreCase(materialStatus)) {

				list_materialStatus.get(i).click();
				break;

			}

		}

		// select SSN

		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectSSN);
		// new Actions(driver).moveToElement(selectSSN).perform();
		selectSSN.click();
		// Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectSSN);
		Random random = new Random();
		int n = 10000000 + random.nextInt(277976677);
		ssn = Integer.toString(n);
		selectSSN.sendKeys(ssn);

		// select Mrn
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		// new Actions(driver).moveToElement(selectSSN).perform();
		selectMRN.click();

		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(selectMRN);
		selectMRN.sendKeys(mrn);

		// Click Dob Button
		Thread.sleep(4000);
		clickOnDobButton.click();

		// Switch Frame
		WebElement thirdFrame = driver.findElement(By.xpath(".//iframe[@src='../patientfiles/datepicker.asp']"));

		driver.switchTo().frame(thirdFrame);

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(clickOnDobMonth);
		clickOnDobMonth.click();

		// selct Month
		// Thread.sleep(4000);
		List<WebElement> list_selectMonth = driver.findElements(By.cssSelector("#divCalendar_selMonth>option"));

		for (int i = 0; i < list_selectMonth.size(); i++) {

			if (list_selectMonth.get(i).getText().equalsIgnoreCase(month)) {

				list_selectMonth.get(i).click();
				break;

			}
		}

		// click on year
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(clickOnDobyear);
		clickOnDobyear.click();

		// select Year
		// Thread.sleep(4000);
		List<WebElement> list_selectYear = driver.findElements(By.cssSelector("#divCalendar_selYear>option"));

		for (int i = 0; i < list_selectYear.size(); i++) {

			if (list_selectYear.get(i).getText().equalsIgnoreCase(year)) {

				list_selectYear.get(i).click();
				break;

			}
		}

		// select date
		Thread.sleep(2000);
		List<WebElement> list_selectDay = driver
				.findElements(By.cssSelector("#divCalendar_calendar > tbody > tr > td"));

		for (int i = 0; i < list_selectDay.size(); i++) {

			if (list_selectDay.get(i).getText().equalsIgnoreCase(day)) {

				list_selectDay.get(i).click();
				break;

			}
		}

		Thread.sleep(5000);

		// Thread.sleep(8000);

		// switch to window and frame

		driver.switchTo().window(secondWinHandle);

		driver.switchTo().frame(firstFrame);
		driver.switchTo().frame(secondFrame);
		// driver.switchTo().frame(thirdFrame);
		// click to calculate Age
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(clickOnCalculateAge);
		clickOnCalculateAge.click();

		// click POn save button
		driver.switchTo().window(secondWinHandle);
		driver.switchTo().frame(firstFrame);
		driver.switchTo().frame(secondFrame);
		wait = new WebDriverWait(driver, 20);
		try {
			ensureElementToBeClickable(selectSaveBtn);
			selectSaveBtn.click();
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert Data:" + alertText);
				alert.accept();
			} catch (NoAlertPresentException ex) {
				ex.printStackTrace();
			}
		}
		// Get mrn Text
		Thread.sleep(10000);

		try {

			strText = getMrnText.getAttribute("value");
			int l = strText.length();
			int Number = Integer.parseInt(strText);
			System.out.println(Number);
			System.out.println(l);

		} catch (NumberFormatException nfe) {
			System.out.println(strText);
			nfe.printStackTrace();

		}
		driver.close();

		// switch to window
		// switch window

		// performCodingIntegration(type, status);

		// matchPmsDataWithEMR(strText);

		launchDevForPMSpatient(type, status, strText);

	}

	public void launchPMSPatientCreation() throws Exception {
		// click On IntegrityPm
//		Thread.sleep(10000);
//		clickOnIntegrityPm.click();

		Thread.sleep(10000);
		// code for enable AdvancedMd
		Set handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle = (String) handles.iterator().next();

		if (winHandle != firstWinHandle) {

			// To retrieve the handle of second window, extracting the handle which does not
			// match to first window handle

			secondWinHandle = winHandle; // Storing handle of second window handle

			// Switch control to new window

			driver.switchTo().window(secondWinHandle);
		}

		// check availability of element
		// Thread.sleep(5000);
		// if (checkPresentOfelement.isDisplayed()) {
		// Thread.sleep(5000);
		// checkPresentOfelement.click();
		// }

		Thread.sleep(10000);
		driver.manage().window().maximize();

		// click On patient Creation

		Thread.sleep(15000);
		clickOnPatientCreation.click();
		// Move second Window Child handle
		Thread.sleep(15000);
		handles = driver.getWindowHandles();

		secondWinHandle = driver.getWindowHandle();

		handles.remove(secondWinHandle);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);

		// switch to first frame
		WebElement firstFrame = driver.findElement(By.cssSelector("iframe[class='pm-legacy']"));
		driver.switchTo().frame(firstFrame);

		// switch to second frame
		WebElement secondFrame = driver
				.findElement(By.xpath(".//iframe[@ src='patientfiles/demo_main.asp?NewReferral=true']"));
		driver.switchTo().frame(secondFrame);

	}

	public void performCodingIntegration(String type, String status) throws Exception {
		Thread.sleep(7000);
		for (String windowName : driver.getWindowHandles())

		{

			driver.switchTo().window(windowName);

		}

		// click On CodingIntegrationPatient
		Thread.sleep(7000);
		clickOnCodingIntegrationPatient.click();

		// switch window
		for (String windowName1 : driver.getWindowHandles())

		{

			driver.switchTo().window(windowName1);

		}

		// click on type
		Thread.sleep(5000);
		clickOnType.click();

		// select type
		Thread.sleep(3000);
		List<WebElement> list_selectType = driver
				.findElements(By.cssSelector("body > div:nth-child(4) > div > div > div > div>div"));

		for (int i = 0; i < list_selectType.size(); i++) {

			if (list_selectType.get(i).getText().equalsIgnoreCase(type)) {

				list_selectType.get(i).click();
				break;

			}
		}

		// click on status
		Thread.sleep(3000);
		clickOnStatus.click();

		// select status
		Thread.sleep(5000);
		List<WebElement> list_selectStatus = driver
				.findElements(By.cssSelector("body > div:nth-child(4) > div > div > div > div>div"));

		for (int i = 0; i < list_selectStatus.size(); i++) {

			if (list_selectStatus.get(i).getText().equalsIgnoreCase(status)) {

				list_selectStatus.get(i).click();
				break;

			}
		}

		// close driver
		driver.close();

	}

	public void matchPmsDataWithEMR(String strText) throws Exception {
		for (String windowName : driver.getWindowHandles())

		{

			driver.switchTo().window(windowName);

		}

		// click serach patient
		Thread.sleep(5000);
		clickSearchPatient.click();

		// enter mrn text and click search button
		Thread.sleep(5000);
		String mrnText = strText.toString();

		System.out.println("MRN Values" + mrnText);
		Thread.sleep(2000);
		enterMrnValue.sendKeys(mrnText);
		Thread.sleep(7000);
		Actions builder = new Actions(driver);
		builder.moveToElement(clickOnsearchBtn).doubleClick().build().perform();

		// click patient text
		Thread.sleep(5000);

		clickOnPatientText.click();

		// click On EditDemographics
		Thread.sleep(6000);
		clickOnEditDemographics.click();

		// match the MRN Number
		// String getMedicineText =
		// driver.findElement(By.cssSelector("#gwt-debug-mrn")).getText();
		// System.out.println(getMedicineText);
		// if (getMedicineText.equals(mrnText)) {
		// System.out.println("case Pass");
		// Reporter.log(
		// "AdvancedMdMrn" + " " + getMedicineText + " " + " Patient Mrn" + " " +
		// mrnText + " " + "Is same");
		//
		// }
		//
		// else {
		// Reporter.log("Fail");
		//
		// }
		//
		// Thread.sleep(5000);
		// clickOnDone.click();

		// Thread.sleep(5000);
		// clickOnMyDashBoard.click();
	}

	// This code is used for dev enviorment
	private void launchDevForPMSpatient(String type, String status, String strText) throws Exception {

		for (String windowName : driver.getWindowHandles())

		{

			driver.switchTo().window(windowName);

		}
		Thread.sleep(6000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		performCodingIntegration(type, status);

		matchPmsDataWithEMR(strText);
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
