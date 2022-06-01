package pages;

import java.util.List;
import java.util.Set;

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
import org.testng.Reporter;

public class PgMedicationOcular {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	PgPatientSearch lclPgPatientSearch;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	public static String firstWinHandle;

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget > a")
	private WebElement clickOnJoinEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-eye-erx")
	private WebElement clickOnErx;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ErxDataPopUp\"]/a")
	private WebElement clickOnDrFirstLaunch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"status_bar_patient\"]/tbody/tr[2]/td[4]/a[1]/b")
	private WebElement clickOnPrescribe;

	@FindBy(how = How.CSS, using = "#control_panel > tbody>tr:nth-child(2)>td:nth-child(1)>a")
	private WebElement clickOnManageMedication;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"drug\"]")
	private WebElement getMedName;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"Find\"]")
	private WebElement clickOnFindBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"medication_selection_table\"]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/dl/dd[3]/a")
	private WebElement clickOnCapsolBtn;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_action\"]")
	private WebElement clickOnfoundTake;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_action\"]/option")
	private List<WebElement> selectfoundTake;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_pick_list\"]")
	private WebElement clickOnDrugsign2;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_pick_list\"]/option")
	private List<WebElement> selectDrugsign2;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_unit\"]")
	private WebElement clickOnDrugSign3;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_unit\"]/option")
	private List<WebElement> selectDrugSign3;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_timing\"]")
	private WebElement clickOnDrugSign4;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_timing\"]/option")
	private List<WebElement> selectDrugSign4;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_other\"]")
	private WebElement clickOnDrugSign5;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_dose_other\"]/option")
	private List<WebElement> selectDrugSign5;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_duration\"]")
	private WebElement clickOnDaySupply;

	@FindBy(how = How.XPATH, using = ".//select[@name=\"prescriptions_duration\"]/option")
	private List<WebElement> selectDaySupply;

	@FindBy(how = How.CSS, using = "#prescriptions_quantity_id")
	private WebElement sendQuntityId;

	@FindBy(how = How.CSS, using = "#review_prescription2")
	private WebElement clickOnContinueBtn;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"active_medication_table\"]/tbody/tr/td/a/b[text()=\"Stop\"]")
	private List<WebElement> selectStopBtn;

	@FindBy(how = How.CSS, using = "#stop_month")
	private WebElement clickOnMonth;

	@FindBy(how = How.CSS, using = "#stop_month > option")
	private List<WebElement> selectOnStopMonth;

	@FindBy(how = How.CSS, using = "#stop_day")
	private WebElement clickOnDay;

	@FindBy(how = How.CSS, using = "#stop_day > option")
	private List<WebElement> selectOnStopDay;

	@FindBy(how = How.CSS, using = "#stop_year")
	private WebElement clickOnyear;

	@FindBy(how = How.CSS, using = "#stop_year > option")
	private List<WebElement> selectOnStopYear;

	@FindBy(how = How.XPATH, using = ".//input[@value=\"Stop Medication\"]")
	private WebElement clickOnOkButton;

	@FindBy(how = How.CSS, using = "#pending_prescription_table > tbody > tr:nth-child(5) > td.dataValue > table > tbody > tr > td:nth-child(1) > table > tbody>tr:nth-child(1)>td:nth-child(1)>input")
	private WebElement sendpswdText;

	@FindBy(how = How.CSS, using = "#pending_prescription_table > tbody > tr:nth-child(5) > td> table > tbody > tr > td:nth-child(1) > table > tbody>tr:nth-child(3)>td>input:nth-child(1)")
	private WebElement clickOnSendButton;

	@FindBy(how = How.CSS, using = "#gwt-debug-close_overlay>a")
	private WebElement clickOnCancelBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody>tr>td:nth-child(3)>div")
	private WebElement clickOnOtherhistory;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-sys-meds-container\"]/div[1]/div[1]")
	private WebElement matchMedtext;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sys-meds-container\"]/div[1]/div[3]")
	private WebElement clickOnMedText;

	@FindBy(how = How.XPATH, using = ".//div[@id='gwt-debug-stopDate']")
	private WebElement matchStopDate;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-erxDone\"]/a")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	public PgMedicationOcular(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void verfiyMedicationOcular(String provider, String eyeHistory, String medName, String options,
			String number, String medicine, String byMonth, String day, String other, String supply, String quantity,
			String date, String month, String year, String password,String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem,String visitType, Boolean noCharges) throws Exception {

		// // click on dropDown
		// Thread.sleep(4000);
		// clickOnJoinEncounter.click();
		// // select prodier from dropDown
		// Thread.sleep(2000);
		// java.util.List<WebElement> openCounter = driver
		// .findElements(By.cssSelector("#gwt-debug-openEncounterTable > tbody > tr
		// >td:nth-child(3)>div"));
		// for (int i = 0; i < openCounter.size(); i++)
		// // System.out.println(openCounter.get(i).getText());
		// if (openCounter.get(i).getText().equalsIgnoreCase(provider)) {
		// openCounter.get(i).click();
		// break;
		// }

//		Thread.sleep(5000);
//		clickOnJoinEncounter.click();
//		int select_RowFromOpenEncounter = driver
//				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
//		//System.out.println(select_RowFromOpenEncounter);
//
//		// Thread.sleep(6000);
//		// if (select_RowFromOpenEncounter > 0) {
//
//		// Select_Provider
//		Thread.sleep(4000);
//		List<WebElement> select_Provider = driver
//				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
//		for (int i = 1; i <= select_Provider.size(); i++)
//			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
//				select_Provider.get(i).click();
//				break;
//			}

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability, significantProblem);

		// select eyeHistory
		Thread.sleep(4000);
		java.util.List<WebElement> eyeHiostoryClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < eyeHiostoryClick.size(); i++)
			if (eyeHiostoryClick.get(i).getText().equalsIgnoreCase(eyeHistory)) {
				eyeHiostoryClick.get(i).click();
				break;

			}

		// click on eRX
		Thread.sleep(2000);
		clickOnErx.click();

		// click on dr.FirstLaunch
		Thread.sleep(2000);
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

		// click on manage Medication
		Thread.sleep(6000);
		clickOnManageMedication.click();

		// provide Medicine
		Thread.sleep(5000);

		getMedName.sendKeys(medName);

		// after provide Medicine click onfind Button
		clickOnFindBtn.click();

		Thread.sleep(3000);

		clickOnCapsolBtn.click();

		// click on prescribeAnyways
		// Thread.sleep(6000);
		// By prescribedAnyways =
		// By.xpath("/html/body/table[4]/tbody/tr[2]/td[2]/form/div/input[2]");
		// driver.findElement(prescribedAnyways).click();

		// click on dropDown of Take
		Thread.sleep(3000);
		clickOnfoundTake.click();

		Thread.sleep(2000);
		for (WebElement select_foundTake : selectfoundTake) {
			if (select_foundTake.getText().equalsIgnoreCase(options)) {
				select_foundTake.click();
				break;
			}
		}
		// click on dropDown Number
		Thread.sleep(2000);
		clickOnDrugsign2.click();

		Thread.sleep(2000);
		for (WebElement select_Drugsign2 : selectDrugsign2) {
			if (select_Drugsign2.getText().equalsIgnoreCase(number)) {
				select_Drugsign2.click();
				break;
			}
		}

		// click on dropDown medicine

		Thread.sleep(2000);
		builder.moveToElement(clickOnDrugSign3).click().perform();
		// click on dropDown byMonth

		Thread.sleep(2000);
		for (WebElement select_DrugSign3 : selectDrugSign3) {
			if (select_DrugSign3.getText().equalsIgnoreCase(medicine)) {
				select_DrugSign3.click();
				break;
			}
		}

		// click on dropDown days
		Thread.sleep(2000);
		clickOnDrugSign4.click();

		Thread.sleep(2000);
		for (WebElement select_DrugSign4 : selectDrugSign4) {
			if (select_DrugSign4.getText().equalsIgnoreCase(day)) {
				select_DrugSign4.click();
				break;
			}
		}

		// click on dropDown other
		Thread.sleep(2000);
		clickOnDrugSign5.click();

		Thread.sleep(2000);
		for (WebElement select_DrugSign5 : selectDrugSign5) {
			if (select_DrugSign5.getText().equalsIgnoreCase(other)) {
				select_DrugSign5.click();
				break;
			}
		}

		// click on dropDown supply
		Thread.sleep(2000);
		clickOnDaySupply.click();

		Thread.sleep(2000);
		for (WebElement select_daySupply : selectDaySupply) {
			if (select_daySupply.getText().equalsIgnoreCase(supply)) {
				select_daySupply.click();
				break;
			}
		}

		// give the no for quantity
		Thread.sleep(2000);
		sendQuntityId.sendKeys(quantity);

		// click on contitune button
		Thread.sleep(3000);
		clickOnContinueBtn.click();

		// click on prescribeAnuways
		Thread.sleep(3000);
		for (WebElement select_StopButton : selectStopBtn) {
			if (select_StopButton.getText().equalsIgnoreCase("Stop")) {
				select_StopButton.click();
				break;
			}

		}

		// chose month from dropDown
		Thread.sleep(3000);
		clickOnMonth.click();
		//

		Thread.sleep(3000);
		for (WebElement select_Month : selectOnStopMonth) {
			if (select_Month.getText().equalsIgnoreCase(month)) {
				select_Month.click();
				break;
			}
		}
		// chose day from dropDown
		Thread.sleep(3000);
		clickOnDay.click();
		//
		Thread.sleep(3000);
		for (WebElement select_Day : selectOnStopDay) {
			if (select_Day.getText().equalsIgnoreCase(date)) {
				select_Day.click();
				break;
			}
		}
		// chose year from dropDown
		Thread.sleep(3000);
		clickOnyear.click();
		//
		Thread.sleep(3000);
		for (WebElement select_Year : selectOnStopYear) {
			if (select_Year.getText().equalsIgnoreCase(year)) {
				select_Year.click();
				break;
			}
		}
		// click on okButton
		Thread.sleep(3000);
		clickOnOkButton.click();

		// send password to textBox
		// Thread.sleep(3000);
		// sendpswdText.sendKeys(password);
		//
		// // click on sendButton
		// Thread.sleep(2000);
		// clickOnSendButton.click();

		// close driver
		Thread.sleep(3000);
		driver.close();

		// switch to CertificationSite
		driver.switchTo().window(firstWinHandle);

		// click on doctorFirst cancel button
		Thread.sleep(3000);
		clickOnCancelBtn.click();

		// click on otherHistory
//		Thread.sleep(3000);
//		clickOnOtherhistory.click();
//
//		Thread.sleep(3000);
//		// get medicine name from the medName
//		String getMedName = medName.substring(0, 6);
//		System.out.println(getMedName);
//		Thread.sleep(7000);
//		// get medicine name from the systemicMedications - Active page
//		String getMedNamme = matchMedtext.getText();
//		System.out.println(getMedNamme);
//		Thread.sleep(5000);
//		if (getMedNamme.startsWith(getMedName)) {
//
//			clickOnMedText.click();
//		}
//		// get stop date from the popup window
//		Thread.sleep(5000);
//		String getStorpDate = matchStopDate.getText();
//		System.out.println("getStorpDate==" + getStorpDate);
//		// split getStopDate
//		String[] split = getStorpDate.split("-");
//
//		String stopMonth = split[0];
//		String stopDate = split[1];
//		String stopYear = split[2];
//		String OriginalMonth = null;
//		System.out.println(stopMonth);
//		switch (stopMonth) {
//		case "01":
//			OriginalMonth = "Jan";
//			break;
//		case "02":
//			OriginalMonth = "Feb";
//			break;
//		case "03":
//			OriginalMonth = "Mar";
//			break;
//		case "04":
//			OriginalMonth = "Apr";
//			break;
//		case "05":
//			OriginalMonth = "May";
//			break;
//		case "06":
//			OriginalMonth = "Jun";
//			break;
//		case "07":
//			OriginalMonth = "Jul";
//			break;
//		case "08":
//			OriginalMonth = "Aug";
//			break;
//		case "09":
//			OriginalMonth = "Sep";
//			break;
//		case "10":
//			OriginalMonth = "Oct";
//			break;
//		case "11":
//			OriginalMonth = "Nov";
//			break;
//		case "12":
//			OriginalMonth = "Dec";
//			break;
//		default:
//			System.out.println("unknown month");
//
//		}
//
//		System.out.println(OriginalMonth);
//		// get original stop date
//		String GetOriginalStopDate = OriginalMonth + "-" + stopDate + "-" + stopYear;
//		// data get form excel sheet for getting the stop date
//		String getExcelDate = month + "-" + date + "-" + year;
//		 System.out.println("getExcelDate=="+ getExcelDate);
//		Thread.sleep(2 * 1000);
//		if (getExcelDate.equalsIgnoreCase(GetOriginalStopDate)) {
//			System.out.println("test successfully");
//			Reporter.log(GetOriginalStopDate + " and" + getExcelDate + "matched So test Successfully!");
//		}
//
//		Thread.sleep(5000);
//		clickOnDone.click();
//
		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);

		// Thread.sleep(5000);
		// clickOnMyDashBoard.click();
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
