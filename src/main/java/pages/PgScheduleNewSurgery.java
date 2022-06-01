
package pages;

import static org.testng.Assert.assertEquals;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PgScheduleNewSurgery {

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryModule")
	private WebElement ClickOnSurgeryModuleBtn;
	@FindBy(how = How.CSS, using = "#gwt-debug-newSurgeryLink > a")
	private WebElement ClickOnScheduleNewSurgery;
	@FindBy(how = How.XPATH, using = ".//*[text()='Edit']")
	private WebElement clickOnEditBtn;
	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryLocation")
	private WebElement lstbxCategoryOfSurgery;

	@FindBy(how = How.CSS, using = "#gwt-debug-duration")
	private WebElement proceduretimetext;
	// for checkbox
	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(3)>input")
	private WebElement chkbxComanaging;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(4)>input")
	private WebElement chkbxStagedProcedure;
	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(5)>input")
	private WebElement chkbxRelatedSurgeryBySameSurgeon;
	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(6)>input")
	private WebElement chkbxUnrelatedSurgeryBySameSurgeon;
	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(7)>input")
	private WebElement chkbxRepeatSurgeryBySameSurgeon;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(8)>input")
	private WebElement chkbxRepeatSurgeryByDifferentSurgeon;

	@FindBy(how = How.CSS, using = "#gwt-debug-planCompleteCheck-input")
	private WebElement chkbxPreliminaryPlanningOfSurgeryComplete;

	// For selection of Surgery time
	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryTimeStamp > table > tbody > tr > td:nth-child(1) > select")
	private WebElement lstbxHour;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryTimeStamp > table > tbody > tr>td:nth-child(3)>select")
	private WebElement lstbxminute;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryTimeStamp > table > tbody > tr>td:nth-child(4)>select")
	private WebElement lstbxFormat;
	// patient notified

	@FindBy(how = How.CSS, using = "#gwt-debug-patientNotified-input")
	private WebElement chkPatientNotified;

	// Pre-op Visit
	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(1) > div>span>input")
	private WebElement chkBoxConsentForm;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(2) > div>span>input")
	private WebElement chkBoxSurgeryOrders;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(3) > div>span>input")
	private WebElement chkBoxIOLSelection;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(4) > div>span>input")
	private WebElement chkBoxPrescriptionsGiven;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(5) > div>span>input")
	private WebElement chkBoxLRISelection;
	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(6) > div>span>input")
	private WebElement chkBoxSampleMedsGiven;
	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(7) > div>span>input")
	private WebElement chkBoxPatientInstructions;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(3) > table > tbody > tr > td > div > div > div > table > tbody > tr:nth-child(1) > td > div > div:nth-child(8) > div>span>input")
	private WebElement chkBoxPreOpOrders;

	private WebDriver driver;
	private WebDriverWait wait;
	@SuppressWarnings("unused")
	private Actions actions;
	PgPatientSearch lclPgPatientSearch;

	public PgScheduleNewSurgery(WebDriver driver, WebDriverWait wait, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Select Procedure
	private void selectProcedure(String favCategories, String scheduleSurgery, String whichEye,
			String associateProWithProblem) throws InterruptedException {
		// Select Favorites Categories

		Thread.sleep(4000);
		By favCategoryRows = By.cssSelector("#gwt-debug-prior_eye-categories-list > div:nth-child(1) > div");
		List<WebElement> rows = driver.findElements(favCategoryRows);
		for (WebElement row : rows) {

			if (row.getText().equalsIgnoreCase(favCategories)) {
				row.click();
				break;

			}
		}
		// select Schedule Surgery
		Thread.sleep(4 * 1000);

		By scheduleSurgeryRows = By.cssSelector("#gwt-debug-codes-list > div:nth-child(1) > div > div:nth-child(3)");
		List<WebElement> rowOfScheduleSurgery = driver.findElements(scheduleSurgeryRows);
		for (WebElement row1 : rowOfScheduleSurgery) {

			if (row1.getText().equalsIgnoreCase(scheduleSurgery)) {
				row1.click();
				break;

			}
		}
		// select Which Eye or Side?
		Thread.sleep(2 * 1000);
		By selectWhichEyeOrSideRows = By.cssSelector("#gwt-debug-eyeSide-container>div");
		List<WebElement> selectWhichEyeOrSide = driver.findElements(selectWhichEyeOrSideRows);
		for (WebElement row2 : selectWhichEyeOrSide) {

			if (row2.getText().equalsIgnoreCase(whichEye)) {
				row2.click();
				break;

			}
		}
		// select Associate Procedure with a Problem

		Thread.sleep(2 * 1000);
		By selectAssociateProcedureRows = By.cssSelector("#gwt-debug-surgeryProblemList-container>div");
		List<WebElement> AssociateProcedureRows = driver.findElements(selectAssociateProcedureRows);
		for (WebElement row3 : AssociateProcedureRows) {

			if (row3.getText().equalsIgnoreCase(associateProWithProblem)) {
				row3.click();
				break;

			}
		}

		driver.findElement(By.cssSelector("#gwt-debug-done > a")).click();

	}

	// Surgery Scheduling method
	private void calenderMethod(String surgeryDate) throws InterruptedException {
		// click on calendar
		driver.findElement(By.cssSelector("#gwt-debug-surgeryDate")).click();

		String SelectDate = surgeryDate;

		String[] sp = SelectDate.split("/");

		Date d = new Date(SelectDate);

		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		String date = dt.format(d);

		String[] split = date.split("/");

		String month = split[0];
		String day = split[1];
		if (day.charAt(0) == '0')
			day = day.charAt(1) + "";

		String monthName = month.substring(0, 3);

		String monthYear = monthName + " " + split[2];

		Thread.sleep(2 * 1000);
		String currentdate = driver
				.findElement(By.xpath("/html/body/div[9]/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).getText();
		// current month
		String mm = currentdate.substring(0, 3);
		// current year
		String year = currentdate.substring(4, 8);

		int monthdateinteger = 0;
		// current year convert to integer
		int yearinteger = Integer.parseInt(year);
		// Exel readed month convert to integer
		int monthDateReadFromExel = Integer.parseInt(sp[0]);
		// Exel readed year convert to integer
		int yearDateReadFromExel = Integer.parseInt(split[2]);

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
		int monthdiff = monthDateReadFromExel - monthdateinteger;
		int yeardiff = yearDateReadFromExel - yearinteger;
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
							"body > div > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > div"))
							.click();
				}

			}
		}
		// Select the day of the month
		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath(
				"/html/body/div[9]/div/table/tbody/tr[2]/td/table/tbody/tr/td[not(contains(@class,'datePickerDay datePickerDayIsFiller')) and not(contains(@class,'datePickerDay datePickerDayIsWeekend datePickerDayIsFiller ')) ]"));

		for (int i = 0; i < list_AllMonthToBook.size(); i++) {

			if (list_AllMonthToBook.get(i).getText().equalsIgnoreCase(day)) {
				list_AllMonthToBook.get(i).click();
				break;

			}

		}
	}

	// Order Lab Studies method
	private void orderLabStudiesmethod(String selectLabTest, String comment, String associateLabWithProblem,
			String designateTime) throws InterruptedException {

		String selectLTest = selectLabTest.trim();
		// click on Order Lab Studies link
		driver.findElement(By.cssSelector("#gwt-debug-orderLabTest")).click();
		Thread.sleep(5 * 1000);
		// Select Lab Tests
		List<WebElement> list_orderLabTest = driver
				.findElements(By.xpath("//*[@id=\"Select Lab Tests\"]/tbody/tr[2]/td/div/table/tbody/tr/td[1]"));

		int sizecount = list_orderLabTest.size();

		for (int i = 1; i <= sizecount; i++) {

			if (driver
					.findElement(By
							.xpath("//*[@id=\"Select Lab Tests\"]/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td[1]"))
					.getText().trim().equalsIgnoreCase(selectLTest)) {
				driver.findElement(
						By.xpath("//*[@id=\"Select Lab Tests\"]/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td[1]"))
						.click();

				break;

			}
		}
		// Send Text to comment Box
		driver.findElement(By.cssSelector("#gwt-debug-orderComments")).sendKeys(comment);

		// Associate Lab with a Problem
		Thread.sleep(2 * 1000);
		List<WebElement> list_AssociateLabWithProblem = driver.findElements(
				By.xpath("//*[@id=\"Associate Lab with a Problem\"]/tbody/tr[2]/td/div/table/tbody/tr/td[1]"));
		int sizeCountOfAssociateLabWithProblem = list_AssociateLabWithProblem.size();

		for (int i = 1; i <= sizeCountOfAssociateLabWithProblem; i++) {

			if (driver.findElement(By.xpath(
					"//*[@id=\"Associate Lab with a Problem\"]/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td[1]"))
					.getText().equals(associateLabWithProblem)) {
				driver.findElement(By.xpath(
						"//*[@id=\"Associate Lab with a Problem\"]/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td[1]"))
						.click();
				break;

			}
		}
		// Select Designate a Time

		Thread.sleep(2 * 1000);
		List<WebElement> list_DesignateTime = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-labTestTime\"]/table/tbody/tr[2]/td/div/table/tbody/tr/td"));
		int sizeDesignateTime = list_DesignateTime.size();

		for (int i = 1; i <= sizeDesignateTime; i++) {
			if (driver
					.findElement(By.xpath(
							"//*[@id=\"gwt-debug-labTestTime\"]/table/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td"))
					.getText().equals(designateTime)) {
				driver.findElement(By.xpath(
						"//*[@id=\"gwt-debug-labTestTime\"]/table/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td"))
						.click();
				break;
			}
		}
		// click on done button
		By doneButton = By.cssSelector("#gwt-debug-Done");
		WebElement selectDoneButton = driver.findElements(doneButton).get(1);
		ensureElementToBeClickable(selectDoneButton);
		selectDoneButton.click();

	}

	// ScheduleNewSurgeryMethod

	public void scheduleNewSurgeryMethod(String favCategories, String scheduleSurgery, String whichEye,
			String associateProWithProblem, String categoryOfSurgery, String procedureTime, Boolean comanaging,
			Boolean stagedProcedure, Boolean relatedSurgeryBySameSurgeon, Boolean unRelatedSurgeryBySameSurgeon,
			Boolean repeatSurgeryBySameSurgeon, Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery,
			String when, String anesthesia, String surgeon, String assistantSurgeon,
			Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, boolean patientNotify,
			String comment1, boolean consentForm, boolean iOLSelection, boolean lRISelection,
			boolean patientInstructions, boolean daySurgeryOrders, boolean prescriptionsGiven, boolean sampleMedsGiven,
			boolean preopOrders) throws InterruptedException {
		// click on SurgeryModuleLInk
		System.out.println(comanaging);
		driver.close();

		Thread.sleep(5 * 1000);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSurgeryModuleBtn));
		ClickOnSurgeryModuleBtn.click();
		// Schedule Sergery Count
		int scheduleSergeryCount1 = ScheduledSurgeriesCount();

		Thread.sleep(2 * 1000);
		// click on scheduleNewSurgeryButton
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnScheduleNewSurgery));
		ClickOnScheduleNewSurgery.click();
		// click on EditBtn
		Thread.sleep(2 * 1000);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnEditBtn));
		clickOnEditBtn.click();
		// call selectProcedure Method
		Thread.sleep(2 * 1000);
		selectProcedure(favCategories, scheduleSurgery, whichEye, associateProWithProblem);

		Thread.sleep(2 * 1000);
		// Select Category Of surgery

		Select selectcCategory = new Select(lstbxCategoryOfSurgery);
		selectcCategory.selectByVisibleText(categoryOfSurgery);
		// fill the Procedure time
		wait.until(ExpectedConditions.elementToBeClickable(proceduretimetext));
		proceduretimetext.clear();
		proceduretimetext.sendKeys(procedureTime);
		// for Selecting checkbox
		Thread.sleep(2 * 1000);
		if (!chkbxComanaging.isSelected() && comanaging)
			chkbxComanaging.click();
		if (!chkbxStagedProcedure.isSelected() && stagedProcedure)
			chkbxStagedProcedure.click();

		if (!chkbxRelatedSurgeryBySameSurgeon.isSelected() && relatedSurgeryBySameSurgeon)
			chkbxRelatedSurgeryBySameSurgeon.click();

		if (!chkbxUnrelatedSurgeryBySameSurgeon.isSelected() && unRelatedSurgeryBySameSurgeon)
			chkbxUnrelatedSurgeryBySameSurgeon.click();

		if (!chkbxRepeatSurgeryBySameSurgeon.isSelected() && repeatSurgeryBySameSurgeon)
			chkbxRepeatSurgeryBySameSurgeon.click();

		if (!chkbxRepeatSurgeryByDifferentSurgeon.isSelected() && repeatSurgeryByDiffSurgeon)
			chkbxRepeatSurgeryByDifferentSurgeon.click();

		Thread.sleep(2 * 1000);
		// Location of surgery
		Select dropDown = new Select(driver.findElement(By.cssSelector(
				"#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr > td > div > div > div:nth-child(1)>select")));
		List<WebElement> elementCount = dropDown.getOptions();
		int itemSize = elementCount.size();

		if (itemSize > 1) {
			for (int i = 0; i < itemSize; i++) {

				if (elementCount.get(i).getText().equalsIgnoreCase(locationOfSurgery)) {
					elementCount.get(i).click();
					break;
				}

			}

		}

		// select the item from the "when " dropdown box

		Select dropDownwhenDetail = new Select(driver.findElement(By.cssSelector("#gwt-debug-whenPlanned ")));
		List<WebElement> elementCount1 = dropDownwhenDetail.getOptions();
		int itemSize1 = elementCount1.size();

		if (itemSize1 > 1) {
			for (int i = 0; i < itemSize1; i++) {

				if (elementCount1.get(i).getText().equalsIgnoreCase(when)) {
					elementCount1.get(i).click();
					break;
				}

			}

		}
		// Select item from Anesthesia dropDownBox

		Select dropDownAnesthesiaDetail = new Select(driver.findElement(By.cssSelector("#gwt-debug-anesthesia")));
		List<WebElement> elementCountAnesthesia = dropDownAnesthesiaDetail.getOptions();
		int itemSizeAnesthesia = elementCountAnesthesia.size();

		if (itemSizeAnesthesia > 1) {
			for (int i = 0; i < itemSizeAnesthesia; i++) {

				if (elementCountAnesthesia.get(i).getText().equalsIgnoreCase(anesthesia)) {
					elementCountAnesthesia.get(i).click();
					break;
				}

			}

		}

		// Select item from Surgeon dropDownBox

		Select dropDownSurgeonDetail = new Select(driver.findElement(By.cssSelector("#gwt-debug-surgeon")));
		List<WebElement> elementCountSurgeon = dropDownSurgeonDetail.getOptions();
		int itemSizeSurgeon = elementCountSurgeon.size();
		if (itemSizeSurgeon > 1) {
			for (int i = 0; i < itemSizeSurgeon; i++) {

				if (elementCountSurgeon.get(i).getText().equalsIgnoreCase(surgeon)) {
					elementCountSurgeon.get(i).click();
					break;
				}

			}

		}
		Thread.sleep(2 * 1000);

		// Select item from AssistantSurgeon dropDownBox

		Select dropDownAssistantSurgeonDetail = new Select(
				driver.findElement(By.cssSelector("#gwt-debug-assistantSurgeon")));
		List<WebElement> elementCountAssistantSurgeon = dropDownAssistantSurgeonDetail.getOptions();
		int itemSizeAssistantSurgeon = elementCountAssistantSurgeon.size();

		if (itemSizeAssistantSurgeon > 1) {
			for (int i = 0; i < itemSizeAssistantSurgeon; i++) {

				if (elementCountAssistantSurgeon.get(i).getText().equalsIgnoreCase(assistantSurgeon)) {
					elementCountAssistantSurgeon.get(i).click();
					break;
				}

			}

		}

		// Preliminary planning of surgery complete
		if (!chkbxPreliminaryPlanningOfSurgeryComplete.isSelected() && preliminaryPlanningOfSurgeryComplete)
			chkbxPreliminaryPlanningOfSurgeryComplete.click();

		// call Calendar method

		Thread.sleep(2000);
		calenderMethod(surgeryDate);
		// Select time
		Thread.sleep(2 * 1000);
		String[] timeArray = surgeryTime.split("-");
		String hour = timeArray[0];
		String minute = timeArray[1];
		String format = timeArray[2];

		// Select hour
		Select selectHour = new Select(lstbxHour);
		selectHour.selectByVisibleText(hour);
		// Select minutes
		Select selectMinutes = new Select(lstbxminute);
		selectMinutes.selectByVisibleText(minute);
		// Select AM Or Pm

		Select selectAMOrPM = new Select(lstbxFormat);
		selectAMOrPM.selectByVisibleText(format);

		// call order Lab Studies method
		Thread.sleep(1000);
		orderLabStudiesmethod(selectLabTest, comment, associateLabWithProblem, designateTime);

		// patient notify
		Thread.sleep(2000);
		if (!chkPatientNotified.isSelected() && patientNotify)
			chkPatientNotified.click();
		// comment
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#gwt-debug-scheduleComments")).sendKeys(comment1);

		// Pre-op Visit
		Thread.sleep(2 * 1000);
		if (!chkBoxConsentForm.isSelected() && consentForm)
			chkBoxConsentForm.click();
		Thread.sleep(1000);
		if (!chkBoxSurgeryOrders.isSelected() && daySurgeryOrders)
			chkBoxSurgeryOrders.click();
		Thread.sleep(1000);
		if (!chkBoxIOLSelection.isSelected() && iOLSelection)
			chkBoxIOLSelection.click();
		Thread.sleep(1000);
		if (!chkBoxPrescriptionsGiven.isSelected() && prescriptionsGiven)
			chkBoxPrescriptionsGiven.click();
		Thread.sleep(1000);
		if (!chkBoxLRISelection.isSelected() && lRISelection)
			chkBoxLRISelection.click();
		Thread.sleep(1000);
		if (!chkBoxSampleMedsGiven.isSelected() && sampleMedsGiven)
			chkBoxSampleMedsGiven.click();
		Thread.sleep(1000);
		if (!chkBoxPatientInstructions.isSelected() && patientInstructions)
			chkBoxPatientInstructions.click();
		Thread.sleep(1000);
		if (!chkBoxPreOpOrders.isSelected() && preopOrders)
			chkBoxPreOpOrders.click();
		// click on done button
		driver.findElement(By.cssSelector("#gwt-debug-Done > a")).click();
		Thread.sleep(3 * 1000);
		int scheduleSergeryCount2 = ScheduledSurgeriesCount();
		assertEquals(scheduleSergeryCount1 + 1, scheduleSergeryCount2);
		Reporter.log("Schedule New Surgery Test Successfully");
		Thread.sleep(2 * 1000);
		By clickOnCloseSurgery = By.cssSelector("#gwt-debug-closeSurgeriesLink > a");
		ensureElementToBeClickable(clickOnCloseSurgery);
		driver.findElement(clickOnCloseSurgery).click();
		// click on MyDashBoard link
		Thread.sleep(5 * 1000);
		By clickOnMyDashBoard = By.xpath(".//*[text()='My Dashboard']");
		ensureElementToBeClickable(clickOnMyDashBoard);
		driver.findElement(clickOnMyDashBoard).click();
		Thread.sleep(2 * 1000);

	}

	int ScheduledSurgeriesCount() throws InterruptedException {
		Thread.sleep(3 * 1000);
		List<WebElement> list_ScheduledSurgeries = driver.findElements(By.xpath(
				"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div"));

		int countSchedule = list_ScheduledSurgeries.size();

		return countSchedule;

	}

}
