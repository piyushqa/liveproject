package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.Factory;

public class PgSurgery {
	WebDriver driver;
	WebElement element = null;;
	WebDriverWait wait;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;

	// Declare Locator
	@FindBy(how = How.XPATH, using = ".//div[text()='Surgery Module']")
	private WebElement clickOnSurgerModule;

	@FindBy(how = How.XPATH, using = ".//a[text()='Schedule New Surgery']")
	private WebElement clickOnNewSurgeryPatient;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"textLibraryToolbar\"]/div[1]/div[1]")
	private WebElement clickOnTextLiberaryToolbar;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist__container\"]/div[1][text()=\"Cataract Surgery\"]")
	private WebElement clickOnCataractSurgery;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist__container\"]/div[1][text()=\"Cataract surgery - retrobulbar anesthesia\"]")
	private WebElement clickOnanesthesia;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Open this item\"]")
	private WebElement clickOpenItem;

	@FindBy(how = How.XPATH, using = ".//*[text()='Edit']")
	private WebElement clickOnEditBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryLocation")
	private WebElement lstbxCategoryOfSurgery;

	@FindBy(how = How.CSS, using = "#gwt-debug-duration")
	private WebElement proceduretimetext;

	@FindBy(how = How.XPATH, using = ".//label[text()='Comanaging']")
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

	@FindBy(how = How.XPATH, using = ".//label[text()='Scheduling Complete']")
	private WebElement chkSchedulingComplete;

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

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-preOpCompleteCheck-label\"]")
	private WebElement chkBoxPreOpComplete;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(3) > table> tbody > tr > td> div > div > div:nth-child(2) > div > div:nth-child(1) > div > table > tbody>tr>td>a:nth-child(2)")
	private WebElement clickOnOpNote;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-libraryText\"]")
	private WebElement clickAddInformationOpNote;

	@FindBy(how = How.XPATH, using = ".//a[text()='Done']")
	private WebElement clickOnOpDoneBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()='Edit']")
	private WebElement clickOnOpEdit;

	@FindBy(how = How.XPATH, using = ".//a[text()='Complete']")
	private WebElement clickOnOpComplete;

	@FindBy(how = How.XPATH, using = ".//a[text()='Operative Note']")
	private WebElement clickOnOperativeNote;

	@FindBy(how = How.XPATH, using = ".//div[@id='report']")
	private WebElement checkOperativeNotePdf;

	@FindBy(xpath = ".//div[@class=\"popup__done idsButton--green\"]")
	private WebElement clickOnDone;




	public PgSurgery(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder=builder;
		PageFactory.initElements(driver, this);
	}



	// function for surgery patient
	public void surgeryPatient(String favCategories, String scheduleSurgery, String whichEye,
			String associateProWithProblem, String categoryOfSurgery, String procedureTime, Boolean comanaging,
			Boolean stagedProcedure, Boolean relatedSurgeryBySameSurgeon, Boolean unRelatedSurgeryBySameSurgeon,
			Boolean repeatSurgeryBySameSurgeon, Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery,
			String when, String anesthesia, String surgeon, String assistantSurgeon,
			Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, boolean patientNotify,
			String comment1, boolean consentForm, boolean iOLSelection, boolean lRISelection,
			boolean patientInstructions, boolean daySurgeryOrders, boolean prescriptionsGiven, boolean sampleMedsGiven,
			boolean preopOrders, String opNoteText, String opNoteLiberary, String ContractSurgery,
			boolean preOpComplete, String dataListItem) throws InterruptedException, AWTException {

		// click On surgery Module
		Thread.sleep(3000);
		clickOnSurgerModule.click();

		// click On new surgeryPatient
		Thread.sleep(3000);
		clickOnNewSurgeryPatient.click();

		// click on Edit Button
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnEditBtn));
		clickOnEditBtn.click();

		// select fav categories
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

		// click on Done Button
		driver.findElement(By.cssSelector("#gwt-debug-done > a")).click();

		// select text from Selectcategory
		Select selectcCategory = new Select(lstbxCategoryOfSurgery);
		selectcCategory.selectByVisibleText(categoryOfSurgery);
		// fill the Procedure time
		Thread.sleep(4000);
		// wait.until(ExpectedConditions.elementToBeClickable(proceduretimetext));
		proceduretimetext.click();
		proceduretimetext.clear();
		proceduretimetext.sendKeys(procedureTime);
		// for Selecting checkbox
		Thread.sleep(6 * 1000);
		if (!chkbxComanaging.isSelected() && comanaging)
			chkbxComanaging.click();
		// chkbxComanaging.click();

		// checkBox for StagedProcedure
		Thread.sleep(4 * 1000);
		if (!chkbxStagedProcedure.isSelected() && stagedProcedure)
			chkbxStagedProcedure.click();

		// checkBox for Related Surgery By SameSurgeon
		Thread.sleep(4 * 1000);
		if (!chkbxRelatedSurgeryBySameSurgeon.isSelected() && relatedSurgeryBySameSurgeon)
			chkbxRelatedSurgeryBySameSurgeon.click();

		// checkBox for Unrelated Surgery By SameSurgeon
		Thread.sleep(4 * 1000);
		if (!chkbxUnrelatedSurgeryBySameSurgeon.isSelected() && unRelatedSurgeryBySameSurgeon)
			chkbxUnrelatedSurgeryBySameSurgeon.click();

		// checkBox for Repeat Surgery By SameSurgeon
		Thread.sleep(4 * 1000);
		if (!chkbxRepeatSurgeryBySameSurgeon.isSelected() && repeatSurgeryBySameSurgeon)
			chkbxRepeatSurgeryBySameSurgeon.click();

		// checkBox for Repeat Surgery By DifferentSurgeon
		Thread.sleep(4 * 1000);
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

		// check Box for PreliminaryPlanningOfSurgeryComplete
		Thread.sleep(3000);
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

		Thread.sleep(2000);
		if (!chkPatientNotified.isSelected() && patientNotify)
			chkPatientNotified.click();
		// comment
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#gwt-debug-scheduleComments")).sendKeys(comment1);

		Thread.sleep(4000);

		chkSchedulingComplete.click();
		// Pre-op Visit
		Thread.sleep(2 * 1000);
		if (!chkBoxConsentForm.isSelected() && consentForm)
			chkBoxConsentForm.click();

		// CheckBox for SurgeryOrders
		Thread.sleep(1000);
		if (!chkBoxSurgeryOrders.isSelected() && daySurgeryOrders)
			chkBoxSurgeryOrders.click();

		// CheckBox for IOLSelection
		Thread.sleep(1000);
		if (!chkBoxIOLSelection.isSelected() && iOLSelection)
			chkBoxIOLSelection.click();

		// CheckBox for PrescriptionsGiven
		Thread.sleep(1000);
		if (!chkBoxPrescriptionsGiven.isSelected() && prescriptionsGiven)
			chkBoxPrescriptionsGiven.click();

		// CheckBox for LRISelection
		Thread.sleep(1000);
		if (!chkBoxLRISelection.isSelected() && lRISelection)
			chkBoxLRISelection.click();

		// CheckBox for SampleMedsGiven
		Thread.sleep(1000);
		if (!chkBoxSampleMedsGiven.isSelected() && sampleMedsGiven)
			chkBoxSampleMedsGiven.click();

		// CheckBox for PatientInstructions
		Thread.sleep(1000);
		if (!chkBoxPatientInstructions.isSelected() && patientInstructions)
			chkBoxPatientInstructions.click();

		// CheckBox for PreOpOrders
		Thread.sleep(1000);
		if (!chkBoxPreOpOrders.isSelected() && preopOrders)

			chkBoxPreOpOrders.click();

		// click on done button
		driver.findElement(By.cssSelector("#gwt-debug-Done > a")).click();

		 //====click on OpNote
//		Thread.sleep(6 * 1000);
//		clickOnOpNote.click();
//================
		// // select variable

//		 Thread.sleep(4000);
//		 WebElement sel1 =
//		 driver.findElement(By.xpath("//*[@id=\"gwt-debug-selectCategory-list\"]/div[1]/div"));
//		 sel1.click();
//		 Thread.sleep(5000);
//		 WebElement sel2 =
//		 driver.findElement(By.xpath("//*[@id=\"gwt-debug-selectItem-list\"]/div[1]/div[3]"));
//		 sel2.click();
//
//		 // clickOn Add Information OpNote
//		 if
//		 (clickAddInformationOpNote.isDisplayed())
//		 {
//
//		 Thread.sleep(3000);
//		 clickAddInformationOpNote.click();
//		 clickAddInformationOpNote.sendKeys(opNoteText);
//		 } // click On DoneBtn
//		Thread.sleep(3000);
//		clickOnOpDoneBtn.click();

		// =====new script
//	======	Thread.sleep(4000);
//		clickOnTextLiberaryToolbar.click();
//
//		Thread.sleep(4000);
//		clickOnCataractSurgery.click();
//
//		Thread.sleep(4000);
//		clickOnanesthesia.click();
//
//		Thread.sleep(4000);
//		List<WebElement> select_ListItem = driver.findElements(By.xpath(
//				".//div[@class=\"datalist datalist--picklist datalist--striping datalist--singleSelect\"][3]/div[@class=\"datalist__container\"]/div"));
//		for (int i = 1; i <= select_ListItem.size(); i++)
//			if (select_ListItem.get(i).getText().equalsIgnoreCase(dataListItem)) {
//				select_ListItem.get(i).click();
//				break;
//			}
//
//		Thread.sleep(4000);
//=======		clickOpenItem.click();

//		Thread.sleep(5000);
//		clickOnDone.click();
		// Thread.sleep(4000);
		// WebElement switchFrame =
		// driver.findElement(By.xpath(".//iframe[@class='cke_wysiwyg_framcke_reset']"));
		// driver.switchTo().frame(switchFrame);
		//
		// Thread.sleep(8000);
		// // hit enter
		// Robot r = new Robot();
		//
		// r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		// r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		// r.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		// r.keyPress(java.awt.event.KeyEvent.VK_V);
		// r.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		// Thread.sleep(3000);
		// r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		// Thread.sleep(4000);
		// // switch back
		// driver.switchTo().activeElement();
		//
		// clickOnEditBtn
//====		Thread.sleep(4000);
//		clickOnEditBtn.click();
//
//		// checkBox for PreOpComplete
//		Thread.sleep(5000);
//		if (!chkBoxPreOpComplete.isSelected() && preOpComplete)
//			chkBoxPreOpComplete.click();
//
//		// click on Done Button
//		Thread.sleep(5000);
//		driver.findElement(By.cssSelector("#gwt-debug-Done > a")).click();

//		 //click on OpComplete
//		 Thread.sleep(5000);
//		 clickOnOpComplete.click();
//
//		// click on OperativeNote
//		 Thread.sleep(5000);
//		 clickOnOperativeNote.click();
//		 Thread.sleep(5000);
//		 if (checkOperativeNotePdf.isDisplayed()) {
//		 Reporter.log(" Document is visible case succesfull execute");
//		 } else {
//		 Reporter.log("Case fail");
//		 }
	}

	//
	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// method for handle calaender
	public void calenderMethod(String surgeryDate) throws InterruptedException {
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

}
