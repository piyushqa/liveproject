package pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PgMedication {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	public static String firstWinHandle;

	// Element Locater
	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget > a")
	private WebElement clickOnJoinEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(xpath = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-eye-erx")
	private WebElement clickOneRX;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content>div>div>a")
	private WebElement clickOnDrFirstLaunch;

	@FindBy(how = How.CSS, using = "#control_panel > tbody>tr:nth-child(2)>td:nth-child(1)>a")
	private WebElement clickOnManageMedication;

	@FindBy(how = How.CSS, using = "#medication_report_table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody>tr:nth-child(2)>td:nth-child(2)>select")
	private WebElement clickOnFavourites;

	@FindBy(how = How.CSS, using = "#favorites_select_box_id > input[type=\"submit\"]:nth-child(2)")
	private WebElement clickOnAddButton;

	@FindBy(how = How.CSS, using = "#review_prescription2")
	private WebElement clickOnContinue;

	@FindBy(how = How.CSS, using = "#active_medication_table > tbody > tr:nth-child(1) > td:nth-child(15) > a:nth-child(2) > b")
	private WebElement clickOnStopButton;

	@FindBy(how = How.CSS, using = "#stop_month")
	private WebElement clickOnStopMonth;

	@FindBy(how = How.CSS, using = "#stop_day")
	private WebElement clickOnStopDate;

	@FindBy(how = How.CSS, using = "#stop_year")
	private WebElement clickOnStopYear;

	@FindBy(how = How.CSS, using = "body > table:nth-child(25) > tbody > tr:nth-child(13) > td:nth-child(2) > input[type=\"submit\"]:nth-child(1)")
	private WebElement clickOnStopMedication;

	@FindBy(how = How.CSS, using = "#gwt-debug-close_overlay>a")
	private WebElement clickOnCancelButton;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody>tr>td:nth-child(3)>div")
	private WebElement clickOnOtherHistory;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody>tr>td:nth-child(2)>div")
	private WebElement clickOneyeHistory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-eye-meds-item-0\"]/div[1]")
	private WebElement getMedicineText1;

	@FindBy(how = How.CSS, using = "#gwt-debug-sys-meds-item-0 > div:nth-child(1)")
	private WebElement getMedicineText;

	@FindBy(how = How.CSS, using = "#gwt-debug-sys-erx")
	private WebElement clickOnsystemicMedicationseRX;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[4]/div[1]/div[1]/div[1]/div[3]")
	private WebElement clickOnSytemicMedicationseHistrocial;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-headingPanel\"]/div/a")
	private WebElement clickOnCancelBtn;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	public PgMedication(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void verifyMedication(String provider, String eyeHistory, String medName) throws InterruptedException {

		// // click On Open Encounter
		// Thread.sleep(2000);
		// clickOpenEncounter.click();
		//
		// // select providre from dropDown
		// Thread.sleep(2000);
		// java.util.List<WebElement> openCounter = driver
		// .findElements(By.cssSelector("#gwt-debug-openEncounterTable > tbody > tr >
		// td:nth-child(3)>div"));
		// for (int i = 0; i < openCounter.size(); i++)
		// // System.out.println(openCounter.get(i).getText());
		// if (openCounter.get(i).getText().equalsIgnoreCase(provider)) {
		// openCounter.get(i).click();
		// break;
		// }

		Thread.sleep(5000);
		clickOnJoinEncounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(4000);
			List<WebElement> select_Provider = driver
					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
			for (int i = 1; i <= select_Provider.size(); i++)
				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
					select_Provider.get(i).click();
					break;
				}
		}
		// Thread.sleep(5000);
		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

			Thread.sleep(5000);
			wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(clickOnOkBtn));
			clickOnOkBtn.click();
		}

		// select eyeHistory
		Thread.sleep(2000);
		java.util.List<WebElement> eyeHiostoryClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < eyeHiostoryClick.size(); i++)
			if (eyeHiostoryClick.get(i).getText().equalsIgnoreCase(eyeHistory)) {
				eyeHiostoryClick.get(i).click();
				break;

			}

		// click On eRX
		Thread.sleep(2000);
		clickOneRX.click();

		// click On Dr first Launch
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnDrFirstLaunch));
		clickOnDrFirstLaunch.click();

		// code for enable dr.first
		Set handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle = (String) handles.iterator().next();

		if (winHandle != firstWinHandle) {

			// To retrieve the handle of second window, extracting the handle which does not
			// match to first window handle

			String secondWinHandle = winHandle; // Storing handle of second window handle

			// Switch control to new window

			driver.switchTo().window(secondWinHandle);
		}

		// click on manageMedicine
		Thread.sleep(6000);
		clickOnManageMedication.click();

		// click on favourites
		Thread.sleep(3000);
		clickOnFavourites.click();

		// select medicine
		Thread.sleep(2000);
		java.util.List<WebElement> clickOnMedicine = driver.findElements(By.cssSelector(
				"#medication_report_table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody>tr:nth-child(2)>td:nth-child(2)>select>option"));
		for (int i = 0; i < clickOnMedicine.size(); i++)
			if (clickOnMedicine.get(i).getText().equalsIgnoreCase(medName)) {
				clickOnMedicine.get(i).click();
				break;

			}

		// click on Add button
		Thread.sleep(3000);
		clickOnAddButton.click();

		// click On continue
		Thread.sleep(3000);
		clickOnContinue.click();

		// close driver
		Thread.sleep(3000);
		driver.close();

		// switch to CertificationSite
		driver.switchTo().window(firstWinHandle);

		// click on CalncelButton
		Thread.sleep(5000);
		clickOnCancelButton.click();

		// open otherHistory with sprinQa
		Thread.sleep(3000);
		clickOnOtherHistory.click();

//		// open eyeHistory with certification
//		Thread.sleep(3000);
//		clickOneyeHistory.click();

////		// Match Both String(Medicine) with sprinqa
//		Thread.sleep(20000);
//		String getMedText = getMedicineText.getText();
//		System.out.println(getMedText);
//		String getActualText = medName.substring(0, 17);
//		System.out.println(getActualText);
//		if (getActualText.equals(getMedText)) {
//
//			Reporter.log(getActualText + " same as" + " " + getMedText);
//
//		} else {
//			Reporter.log("Fail");
//		}
//		// Match Both String(Medicine) with Certification
//		Thread.sleep(20000);
//
//		String getMedText1 = getMedicineText1.getText();
//		System.out.println(getMedText1);
//		String getActualText1 = medName.substring(0, 17);
//		System.out.println(getActualText1);
//		if (getActualText1.startsWith(getMedText1)) {
//
//			Reporter.log(getActualText1 + " same as" + " " + getMedText1);
//
//		} else {
//			Reporter.log("Fail");
//		}
	}

	public void checkStopDate(String month, String date, String year, String sysmeticmedication)
			throws InterruptedException {




		// click on Systemic Medication eRX
		Thread.sleep(10000);
		clickOnsystemicMedicationseRX.click();

		// Click on Dr first Launch
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnDrFirstLaunch));
		clickOnDrFirstLaunch.click();

		// code for enable dr.first
		Thread.sleep(5000);
		Set handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle = (String) handles.iterator().next();

		if (winHandle != firstWinHandle) {

			// To retrieve the handle of second window, extracting the handle which does not
			// match to first window handle

			String secondWinHandle = winHandle; // Storing handle of second window handle

			// Switch control to new window

			driver.switchTo().window(secondWinHandle);
		}

		// click on manageMedicine
		Thread.sleep(6000);
		clickOnManageMedication.click();

		// click On Stop Button
		Thread.sleep(7000);
		clickOnStopButton.click();

		// click On Stop Month
		Thread.sleep(6000);
		clickOnStopMonth.click();

		// select Month
		Thread.sleep(3000);
		java.util.List<WebElement> dropDownMonth = driver.findElements(By.cssSelector("#stop_month > option"));
		for (int i = 0; i < dropDownMonth.size(); i++)
			if (dropDownMonth.get(i).getText().equalsIgnoreCase(month)) {
				dropDownMonth.get(i).click();
				break;
			}

		// click On Stop Date
		Thread.sleep(5000);
		clickOnStopDate.click();

		// select date
		Thread.sleep(5000);
		java.util.List<WebElement> dropDownDay = driver.findElements(By.cssSelector("#stop_day > option"));
		for (int i = 0; i < dropDownDay.size(); i++)
			if (dropDownDay.get(i).getText().equalsIgnoreCase(date)) {
				dropDownDay.get(i).click();
				break;
			}

		// click On Stop Year
		Thread.sleep(5000);
		clickOnStopYear.click();

		// select year
		Thread.sleep(5000);
		java.util.List<WebElement> dropDownYear = driver.findElements(By.cssSelector("#stop_year > option"));
		for (int i = 0; i < dropDownYear.size(); i++)
			if (dropDownYear.get(i).getText().equalsIgnoreCase(year)) {
				dropDownYear.get(i).click();

			}
		// click on Stop Medication
		Thread.sleep(5000);
		clickOnStopMedication.click();

		// close driver
		Thread.sleep(5000);
		driver.close();

		// switch to CertificationSite
		driver.switchTo().window(firstWinHandle);

		// click on CalncelButton
		Thread.sleep(5000);
		clickOnCancelButton.click();

		// click on SystemicMedication Histroical
		Thread.sleep(5000);
		clickOnSytemicMedicationseHistrocial.click();

		// select Systemic medication
		Thread.sleep(15000);
		WebElement element = driver
				.findElement(By.cssSelector("body > div.gwt-PopupPanel > div > div > div > div>div:nth-child(2)"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		// click on medcine
		try {
			Thread.sleep(10000);

			if (getMedicineText.isDisplayed()) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				getMedicineText.click();
			}

		} catch (StaleElementReferenceException ex) {
			ex.printStackTrace();
		}
		Thread.sleep(10000);
		String getStorpDate = driver
				.findElement(By.cssSelector(
						"#gwt-debug-overlay_content >div > table > tbody>tr:nth-child(6)>td:nth-child(2)>div"))
				.getText();
		System.out.println("getStorpDate==" + getStorpDate);
		// split getStopDate
		String[] split = getStorpDate.split("-");

		String stopMonth = split[0];
		String stopDate = split[1];
		String stopYear = split[2];
		String OriginalMonth = null;
		System.out.println(stopMonth);
		switch (stopMonth) {
		case "01":
			OriginalMonth = "Jan";
			break;
		case "02":
			OriginalMonth = "Feb";
			break;
		case "03":
			OriginalMonth = "Mar";
			break;
		case "04":
			OriginalMonth = "Apr";
			break;
		case "05":
			OriginalMonth = "May";
			break;
		case "06":
			OriginalMonth = "Jun";
			break;
		case "07":
			OriginalMonth = "Jul";
			break;
		case "08":
			OriginalMonth = "Aug";
			break;
		case "09":
			OriginalMonth = "Sep";
			break;
		case "10":
			OriginalMonth = "Oct";
			break;
		case "11":
			OriginalMonth = "Nov";
			break;
		case "12":
			OriginalMonth = "Dec";
			break;
		default:
			System.out.println("unknown month");

		}

		System.out.println(OriginalMonth);
		// get original stop date
		String GetOriginalStopDate = OriginalMonth + "-" + stopDate + "-" + stopYear;
		// data get form excel sheet for getting the stop date
		String getExcelDate = month + "-" + date + "-" + year;
		// System.out.println("getExcelDate=="+ getExcelDate);
		Thread.sleep(2 * 1000);
		if (getExcelDate.equalsIgnoreCase(GetOriginalStopDate)) {
			System.out.println("test successfully");
			Reporter.log(GetOriginalStopDate + " and " + getExcelDate + "matched So test Successfully!");

		}
		Thread.sleep(5000);
		clickOnCancelBtn.click();

		// Thread.sleep(5000);
		// clickOnMyDashBoard.click(); //
	}
}