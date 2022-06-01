package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class PageAddVitalSigns {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// declare Locator
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()=\"Yes\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[6]/div")
	private WebElement clickOnTechExam;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-vitalSigns\" and text()='Vital Signs']")
	private WebElement clickOnVitalSigns;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-systolic\"]")
	private WebElement fillDataOfSys;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-diastolic\"]")
	private WebElement fillDataOfDias;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[3]/td/textarea")
	private WebElement fillComments;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-heartrate\"]")
	private WebElement fillHeartRate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-temperature\"]")
	private WebElement fillTemp;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-height-feet\"]")
	private WebElement fillHt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-height-inches\"]")
	private WebElement fillInch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[14]/td/textarea")
	private WebElement fillNewComments;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[15]/td/input")
	private WebElement clickOnClanderButton;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-done\"]/a[text()='Done']")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-thisClinicNoteLink\" and text()='This Clinic Note']")
	private WebElement clickOnClinicNote;

	public PageAddVitalSigns(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void verifyVitalSigns(String provider, String bloodPressure, String comments, String heartRate, String temp,
			String bldcOximetry, String inhaledOxygenConcentration, String respiratoryRate, String heightInch,
			String weight, String newComments, String creationDate) throws Exception {
		Thread.sleep(6000);
		clickJionOpenencounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		// if (select_RowFromOpenEncounter > 0) {

		// Select_Provider
		Thread.sleep(6000);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;
			}
		// }
		// // Thread.sleep(5000);
		// else if (select_RowFromOpenEncounter <= 0) {
		// Thread.sleep(7000);
		// clickStartNewEncounter.click();
		//
		// Thread.sleep(5000);
		// wait.until(ExpectedConditions.elementToBeClickable(clickOnOkBtn)).click();
		// }

		// clickOnTechExam
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnTechExam)).click();

		// clickOnVitalSigns
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVitalSigns));
		wait.until(ExpectedConditions.visibilityOf(clickOnVitalSigns));
		clickOnVitalSigns.click();

		// invoke method addVitalSignData
		addVitalSignData(bloodPressure, comments, heartRate, temp, bldcOximetry, inhaledOxygenConcentration,
				respiratoryRate, heightInch, weight, newComments, creationDate);
	}

	public void addVitalSignData(String bloodPressure, String comments, String heartRate, String temp,
			String bldcOximetry, String inhaledOxygenConcentration, String respiratoryRate, String heightInch,
			String weight, String newComments, String creationDate) throws Exception {
		// fill the value of bloodPressure
		Thread.sleep(12000);
		String bPresseure[] = bloodPressure.split("-");
		fillDataOfSys.sendKeys(bPresseure[0]);
		Thread.sleep(2000);
		fillDataOfDias.sendKeys(bPresseure[1]);

		// fill the values of comments
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(fillComments)).sendKeys(comments);

		// fill the value of HeartRate
		// Thread.sleep(1000);
		fillHeartRate.sendKeys(heartRate);

		// fill the value of temprature
		// Thread.sleep(2000);
		fillTemp.sendKeys(temp);

		// fill the value of bldcOximetry,inhaledOxygenConcentration and respiratoryRate
		// Thread.sleep(2000);
		By rate = By.xpath("//*[@id=\"gwt-debug-weight-lbs\"]");
		driver.findElements(rate).get(0).sendKeys(bldcOximetry);

		driver.findElements(rate).get(1).sendKeys(inhaledOxygenConcentration);

		driver.findElements(rate).get(2).sendKeys(respiratoryRate);

		// fill the value of heightInch
		// Thread.sleep(2000);
		String ht[] = heightInch.split("-");
		fillHt.sendKeys(ht[0]);
		fillInch.sendKeys(ht[1]);

		// fill the value of weight
		// Thread.sleep(2000);
		driver.findElements(rate).get(3).sendKeys(weight);

		// fill the values of newComments
		// Thread.sleep(3000);
		fillNewComments.sendKeys(newComments);

		// click on calender
		Thread.sleep(1000);
		clickOnClanderButton.click();

		String selectDate = creationDate;

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
				.findElement(By.xpath("/html/body/div[11]/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).getText();

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
							"body > div > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr> td:nth-child(1) > div"))
							.click();
				}

			}
		}
		// Select the day of the month
		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath(
				"/html/body/div[11]/div/table/tbody/tr[2]/td/table/tbody/tr/td[not(contains(@class,'datePickerDaydatePickerDayIsFiller'))and not(contains(@class,'datePickerDaydatePickerDayIsWeekend datePickerDayIsFiller '))]"));

		for (int i = 0; i < list_AllMonthToBook.size(); i++) {

			if (list_AllMonthToBook.get(i).getText().equalsIgnoreCase(day)) {
				list_AllMonthToBook.get(i).click();
				break;

			}

		}

		// click On Done Btn
		Thread.sleep(2000);
		clickOnDoneBtn.click();

		// click On Clinic Note
		Thread.sleep(3000);

		clickOnClinicNote.click();

		// get the heart rate from clinic note
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		By getClinicNoteData = By
				.xpath("//*[@id=\"report\"]/table/tbody/tr/td/div[text()=\"Heart rate:" + " " + heartRate + "\"]");

		String strData = driver.findElement(getClinicNoteData).getText();
		System.out.println(strData);

		System.out.println(getClinicNoteData);

		// get the data from excel and match with clinic note
		Thread.sleep(1000);
		if (strData.endsWith(heartRate)) {
			Reporter.log(heartRate + " " + strData + " same ");
		}

	}

}
