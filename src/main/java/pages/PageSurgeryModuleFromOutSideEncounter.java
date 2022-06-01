package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageSurgeryModuleFromOutSideEncounter {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// define locater

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Surgeries and Procedures\"]")
	private WebElement clickOnSurgeriAndProcedures;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"popupContent\"]/div/div/div[2]/div")
	private List<WebElement> selectScheduledSurgery;

	@FindBy(how = How.CSS, using = "div#gwt-debug-newSurgeryLink>a")
	private WebElement clickScheduledNewSurgery;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Edit\"]")
	private WebElement clickOnEdit;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Surgery")
	private WebElement clickOnProcedure;

	@FindBy(how = How.CSS, using = "div#gwt-debug-prior_eye-categories-list>div>div")
	private List<WebElement> selectFavouriteCategroies;

	@FindBy(how = How.CSS, using = "#gwt-debug-codes-list > div:nth-child(1) > div > div:nth-child(3)")
	private List<WebElement> selectScheduledSurgeryFav;

	@FindBy(how = How.CSS, using = "#gwt-debug-eyeSide-container>div")
	private List<WebElement> selectWhichEyeorside;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryProblemList-container>div")
	private List<WebElement> selectAssociatedproblems;

	@FindBy(how = How.CSS, using = "div#gwt-debug-done>a")
	private WebElement clickOnDone;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryLocation")
	private WebElement lstbxCategoryOfSurgery;

	@FindBy(how = How.CSS, using = "#gwt-debug-duration")
	private WebElement proceduretimetext;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Comanaging\"]")
	private WebElement chckBoxComanging;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Staged procedure\"]")
	private WebElement chckBoxStagedProcedure;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Related surgery by same surgeon\"]")
	private WebElement chckBoxRelatedSurgeryBySurgonName;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Unrelated surgery by same surgeon\"]")
	private WebElement chckBoxUnrelatedSurgeryBySurgonName;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Repeat surgery by same surgeon\"]")
	private WebElement chckBoxRepeatSurgeryBySameSurgon;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Repeat surgery by different surgeon\"]")
	private WebElement chckBoxRepeatSurgeryByDiffertSurgeon;

	@FindBy(how = How.CSS, using = "#gwt-debug-planCompleteCheck-input")
	private WebElement chkBOxPreliminaryPlanningOfSurgeryComplete;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr > td > div > div > div:nth-child(1)>select")
	private WebElement lstBoxLocationOfsurgery;

	@FindBy(how = How.CSS, using = "select#gwt-debug-whenPlanned")
	private WebElement lstBoxWhenPlanned;

	@FindBy(how = How.CSS, using = "select#gwt-debug-anesthesia")
	private WebElement lstBoxAnesthesia;

	@FindBy(how = How.CSS, using = "select#gwt-debug-surgeon")
	private WebElement lstBoxSurgeon;

	@FindBy(how = How.CSS, using = "select#gwt-debug-assistantSurgeon")
	private WebElement lstBoxAssistantSurgeon;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryTimeStamp > table > tbody > tr > td:nth-child(1) > select")
	private WebElement lstbxHour;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryTimeStamp > table > tbody > tr>td:nth-child(3)>select")
	private WebElement lstbxminute;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryTimeStamp > table > tbody > tr>td:nth-child(4)>select")
	private WebElement lstbxFormat;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientNotified-input")
	private WebElement chkPatientNotified;

	@FindBy(how = How.XPATH, using = ".//label[text()='Scheduling Complete']")
	private WebElement chkSchedulingComplete;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Consent Form\"]")
	private WebElement chkConsentForm;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"IOL Selection\"]")
	private WebElement IOLSelction;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"LRI Selection\"]")
	private WebElement LRIslection;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Patient Instructions\"]")
	private WebElement patientInstruction;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Day Surgery Orders\"]")
	private WebElement daySurgeryorder;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Prescriptions Given\"]")
	private WebElement prescriptionGiven;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Sample Meds Given\"]")
	private WebElement sampleMedsGiven1;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Pre-op Orders\"]")
	private WebElement preOpOrders;

	@FindBy(how = How.XPATH, using = ".//label[text()=\"Pre-op Complete\"]")
	private WebElement preOpComplete;

	@FindBy(how = How.CSS, using = "#gwt-debug-Done>a")
	private WebElement clickOnScheduleSurgeryDone;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div:nth-child(2) > table> tbody > tr > td > div > div > div:nth-child(2) > div:nth-child(1) > div > div:nth-child(2) > select")
	private WebElement selectAppointment;

	@FindBy(how = How.CSS, using = "div#gwt-debug-closeSurgeriesLink>a")
	private WebElement closeSurgey;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Op Note\"]")
	private WebElement clickOnOpNote;

	@FindBy(how = How.CSS, using = "div#gwt-debug-selectCategory-list>div>div")
	private List<WebElement> selectOpNoteLiberary;

	@FindBy(how = How.CSS, using = "div#gwt-debug-selectItem-list>div>div")
	private List<WebElement> selectActractSurgery;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-libraryText")
	private WebElement fillTextInOpNoteLiberary;

	@FindBy(how = How.CSS, using = "div#gwt-debug-done>a")
	private WebElement clickOnOpNoteDoneBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Complete\"]")
	private WebElement clickOnCompleteBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Operative Note\"]")
	private WebElement clickOnOperativeNote;

	@FindBy(how = How.CSS, using = "div#gwt-debug-close_overlay>a.close")
	private WebElement clickOnCloseOfOperativeNote;

	// when setting's is false
	@FindBy(how = How.XPATH, using = ".//div[@class=\"textLibraryToolbar__button icon-editor-open\"]")
	private WebElement clickOnOpenfromLiberary;

	@FindBy(how = How.CSS, using = "div.datalist__container>div:nth-child(1)")
	private WebElement clickOnCataractSurgery;

	@FindBy(how = How.XPATH, using = "/html/body/div[12]/div[1]/div[2]/div[3]/div/div")
	private List<WebElement> clickOnSecondCataractSurgery;

	@FindBy(how = How.XPATH, using = "/html/body/div[12]/div[1]/div[2]/div[3]/div/div[1]")
	private WebElement clickOnSecondCataractSurgery1;

	@FindBy(how = How.XPATH, using = "/html/body/div[12]/div[1]/div[2]/div[4]/div/div")
	private List<WebElement> clickOnThirdCataractSurgery;

	@FindBy(how = How.XPATH, using = "/html/body/div[12]/div[1]/div[2]/div[4]/div/div[1]")
	private WebElement clickOnThirdCataractSurgery1;

	@FindBy(how = How.XPATH, using = ".//div[contains(text(),'Open this item')]")
	private WebElement clickOnOpenThisItem;

	@FindBy(how = How.XPATH, using = ".//div[contains(text(),'Done')]")
	private WebElement clikcOnDoneBtnOfOpNote;

	public PageSurgeryModuleFromOutSideEncounter(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageSurgeryModuleFromOutSideEncounter.this);
	}

	// verify surgery Module From Outside Encounter
	public void verifysurgeryModuleFromOutsideEncounter(String fName, String lName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges, String favCategories,
			String scheduleSurgery, String whichEye, String associateProWithProblem, String categoryOfSurgery,
			Boolean comanaging, Boolean stagedProcedure, Boolean relatedSurgeryBySameSurgeon,
			Boolean unRelatedSurgeryBySameSurgeon, Boolean repeatSurgeryBySameSurgeon,
			Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery, String when, String anesthesia,
			String surgeon, String assistantSurgeon, Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate,
			String surgeryTime, String selectLabTest, String comment, String associateLabWithProblem,
			String designateTime, Boolean patientNotify, String comment1, Boolean consentForm, Boolean iOLSelection,
			Boolean lRISelection, Boolean patientInstructions, Boolean daySurgeryOrders, Boolean prescriptionsGiven,
			Boolean sampleMedsGiven, Boolean preopOrders, Boolean preOpComplete, String yagLaser,
			String visibleLightLaser, String drug, String injection, String location, String needle, String shutRef,
			String iStentRef, String axilAcd, String impression, String axisPlacement, String methodK1, String radiusk1,
			String axisk1, String methodK2, String radiusk2, String axisk2, String IOLCalCulationFormula,
			String PlannedIOL) throws Exception {

		String strSurgeryAndProcedure = "Schedule Surgery";

		// invoke openEncounterWithProblem method of closeEncounter class
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		// invoke method
		selectSurgeryAndProcedures(strSurgeryAndProcedure);

		Thread.sleep(2000);
		clickScheduledNewSurgery.click();

		// invoke scheduledSurgery method
		scheduledSurgery(fName, lName, favCategories, scheduleSurgery, whichEye, associateProWithProblem,
				categoryOfSurgery, comanaging, stagedProcedure, relatedSurgeryBySameSurgeon,
				unRelatedSurgeryBySameSurgeon, repeatSurgeryBySameSurgeon, repeatSurgeryByDiffSurgeon,
				locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon, preliminaryPlanningOfSurgeryComplete,
				surgeryDate, surgeryTime, selectLabTest, comment, associateLabWithProblem, designateTime, patientNotify,
				comment1, consentForm, iOLSelection, lRISelection, patientInstructions, daySurgeryOrders,
				prescriptionsGiven, sampleMedsGiven, preopOrders, preOpComplete, yagLaser, visibleLightLaser, drug,
				injection, location, needle, shutRef, iStentRef, axilAcd, impression, axisPlacement, methodK1, radiusk1,
				axisk1, methodK2, radiusk2, axisk2, IOLCalCulationFormula, PlannedIOL);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	public void scheduledSurgery(String fName, String lName, String favCategories, String scheduleSurgery,
			String whichEye, String associateProWithProblem, String categoryOfSurgery, Boolean comanaging,
			Boolean stagedProcedure, Boolean relatedSurgeryBySameSurgeon, Boolean unRelatedSurgeryBySameSurgeon,
			Boolean repeatSurgeryBySameSurgeon, Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery,
			String when, String anesthesia, String surgeon, String assistantSurgeon,
			Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, Boolean patientNotify,
			String comment1, Boolean consentForm, Boolean iOLSelection, Boolean lRISelection,
			Boolean patientInstructions, Boolean daySurgeryOrders, Boolean prescriptionsGiven, Boolean sampleMedsGiven,
			Boolean preopOrders, Boolean preOpComplete, String yagLaser, String visibleLightLaser, String drug,
			String injection, String location, String needle, String shutRef, String iStentRef, String axilAcd,
			String impression, String axisPlacement, String methodK1, String radiusk1, String axisk1, String methodK2,
			String radiusk2, String axisk2, String IOLCalCulationFormula, String PlannedIOL) throws Exception {

		Select selectObject;

		Thread.sleep(2000);
		clickOnProcedure.click();

		// invoke Method editScheduleSurgeryProblem
		editScheduleSurgeryProblem(favCategories, scheduleSurgery, whichEye, associateProWithProblem,
				categoryOfSurgery);

//		selectObject = new Select(lstbxCategoryOfSurgery);
//		selectObject.selectByVisibleText(categoryOfSurgery);

		new PageScheduleSurgeryWithAllCondition(wait, driver, builder).categoryOfSurgery(categoryOfSurgery, yagLaser,
				visibleLightLaser, drug, injection, location, needle, shutRef, iStentRef, axilAcd, impression,
				axisPlacement, methodK1, radiusk1, axisk1, methodK2, radiusk2, axisk2, IOLCalCulationFormula,
				PlannedIOL);

		Thread.sleep(2000);
		proceduretimetext.click();
		proceduretimetext.clear();
		proceduretimetext.sendKeys("10");

		Thread.sleep(2000);
		if (!chckBoxComanging.isSelected() && comanaging) {
			chckBoxComanging.click();
		}

		Thread.sleep(1000);
		if (!chckBoxStagedProcedure.isSelected() && stagedProcedure) {
			chckBoxStagedProcedure.click();
		}

		Thread.sleep(1000);
		if (!chckBoxRelatedSurgeryBySurgonName.isSelected() && relatedSurgeryBySameSurgeon) {
			chckBoxRelatedSurgeryBySurgonName.click();
		}

		Thread.sleep(1000);
		if (!chckBoxUnrelatedSurgeryBySurgonName.isSelected() && unRelatedSurgeryBySameSurgeon) {
			chckBoxUnrelatedSurgeryBySurgonName.click();
		}

		Thread.sleep(1000);
		if (!chckBoxRepeatSurgeryBySameSurgon.isSelected() && repeatSurgeryBySameSurgeon) {
			chckBoxRepeatSurgeryBySameSurgon.click();
		}

		Thread.sleep(1000);
		if (!chckBoxRepeatSurgeryByDiffertSurgeon.isSelected() && repeatSurgeryByDiffSurgeon) {
			chckBoxRepeatSurgeryByDiffertSurgeon.click();
		}
		Thread.sleep(1000);
		if (!chkBOxPreliminaryPlanningOfSurgeryComplete.isSelected() && preliminaryPlanningOfSurgeryComplete) {
			chkBOxPreliminaryPlanningOfSurgeryComplete.click();
		}

		// Location of surgery
		Thread.sleep(4000);
		lstBoxLocationOfsurgery.click();
		selectObject = new Select(lstBoxLocationOfsurgery);
		selectObject.selectByVisibleText(locationOfSurgery);

		// When
		lstBoxWhenPlanned.click();
		selectObject = new Select(lstBoxWhenPlanned);
		selectObject.selectByVisibleText(when);

		// Anthesia
		lstBoxAnesthesia.click();
		selectObject = new Select(lstBoxAnesthesia);
		selectObject.selectByVisibleText(anesthesia);

		// Surgeaon
		lstBoxSurgeon.click();
		selectObject = new Select(lstBoxSurgeon);
		selectObject.selectByVisibleText(surgeon);

		// Assitant Surgon
		lstBoxAssistantSurgeon.click();
		selectObject = new Select(lstBoxAssistantSurgeon);
		selectObject.selectByVisibleText(assistantSurgeon);

		// select date from PgSurgery Class

		// new PgSurgery(driver, wait, builder).calenderMethod(surgeryDate);

		Thread.sleep(2000);
		String[] timeArray = surgeryTime.split("-");
		lstbxHour.sendKeys(timeArray[0]);
		lstbxminute.sendKeys(timeArray[1]);
		lstbxFormat.sendKeys(timeArray[2]);
		
		Thread.sleep(3000);
		linkWithAppointMent();

		// chech box forpatient notified and sechudling complete
		if (!chkPatientNotified.isSelected() && patientNotify) {
			chkPatientNotified.click();
		}

		Thread.sleep(1000);
		chkSchedulingComplete.click();

		Thread.sleep(2000);
		if (!chkConsentForm.isSelected() && consentForm) {
			chkConsentForm.click();
		}

		Thread.sleep(2000);
		if (!IOLSelction.isSelected() && iOLSelection) {
			IOLSelction.click();
		}

		Thread.sleep(2000);
		if (!LRIslection.isSelected() && lRISelection) {
			LRIslection.click();
		}

		Thread.sleep(2000);
		if (!patientInstruction.isSelected() && patientInstructions) {
			patientInstruction.click();
		}

		Thread.sleep(2000);
		if (!daySurgeryorder.isSelected() && daySurgeryOrders) {
			daySurgeryorder.click();
		}

		Thread.sleep(2000);
		if (!prescriptionGiven.isSelected() && prescriptionsGiven) {
			prescriptionGiven.click();
		}

		Thread.sleep(2000);
		if (!sampleMedsGiven1.isSelected() && sampleMedsGiven) {
			sampleMedsGiven1.click();
		}

		Thread.sleep(2000);
		if (!preOpOrders.isSelected() && preopOrders) {
			preOpOrders.click();
		}

		Thread.sleep(2000);
		this.preOpComplete.click();

		Thread.sleep(2000);
		clickOnScheduleSurgeryDone.click();

		// invoke method oPNoteAndOperativeNote
		// Thread.sleep(2000);
		// oPNoteAndOperativeNote();

		// oPNoteAndOperativeNoteWhenItOff(fName, lName);

//		Thread.sleep(4000);
//		closeSurgey.click();
	}

	// public void linkAppointment

	public void linkWithAppointMent() throws Exception {
		Select select = new Select(selectAppointment);
		select.selectByIndex(1);
	}

	// mehod for oPNote And OperativeNote
	public void oPNoteAndOperativeNote() throws Exception {
		// this script comment for checking some issue
//		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
//		clickOnOpNote.click();
//
//		Thread.sleep(1000);
//		for (WebElement select_OpNoteLiberary : selectOpNoteLiberary) {
//			if (select_OpNoteLiberary.getText().equalsIgnoreCase("Cataract Surgery")) {
//				select_OpNoteLiberary.click();
//				break;
//			}
//		}
//
//		Thread.sleep(1000);
//		for (WebElement select_ActractSurgery : selectActractSurgery) {
//			if (select_ActractSurgery.getText().equalsIgnoreCase("Standard Phaco with LRI")) {
//				select_ActractSurgery.click();
//				break;
//			}
//		}
//
//		Thread.sleep(1000);
//		fillTextInOpNoteLiberary.sendKeys("Ankit Text");
//
//		Thread.sleep(2000);
//		clickOnOpNoteDoneBtn.click();

		// comment due to supervision physican not given
		Thread.sleep(3000);
		clickOnCompleteBtn.click();

		Thread.sleep(2000);
		clickOnOperativeNote.click();

//		 Thread.sleep(3000);
//		 clickOnCloseOfOperativeNote.click();

	}

	// method for opNote when it's off in settings
	public void oPNoteAndOperativeNoteWhenItOff(String fName, String lName) throws Exception {
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		clickOnOpNote.click();

		Thread.sleep(4000);
		clickOnOpenfromLiberary.click();

		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		builder.moveToElement(clickOnCataractSurgery).click().build().perform();

		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		builder.moveToElement(clickOnSecondCataractSurgery1).click().build().perform();

//		Thread.sleep(4000);
//		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
//		for (WebElement select_CataractSurgery : clickOnSecondCataractSurgery) {
//			if (select_CataractSurgery.getText().equalsIgnoreCase("Cataract surgery - retrobulbar anesthesia")) {
//				select_CataractSurgery.click();
//				break;
//			}
//		}

		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		builder.moveToElement(clickOnThirdCataractSurgery1).click().build().perform();

//		Thread.sleep(4000);
//		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
//		for (WebElement select_CataractSurgery : clickOnThirdCataractSurgery) {
//			if (select_CataractSurgery.getText().equalsIgnoreCase("Standard phaco - Toric IOL")) {
//				select_CataractSurgery.click();
//				break;
//			}
//		}
		Thread.sleep(3000);
		clickOnOpenThisItem.click();

		Thread.sleep(3000);

		builder.sendKeys(Keys.ENTER).build().perform();

		builder.sendKeys(Keys.ENTER).release();
		Thread.sleep(3000);
		clikcOnDoneBtnOfOpNote.click();

		// comment due to supervision physican not given
		Thread.sleep(3000);
		clickOnCompleteBtn.click();

		Thread.sleep(2000);
		clickOnOperativeNote.click();

		// String addPatientName=fName.concat(lName);
		String OperativeNoteText = "Patient:" + " " + fName + " " + lName;
		System.out.println(OperativeNoteText);
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath(".//td/div/p[1]"));

		String storeOperativeNoteText = element.getText();
		System.out.println(storeOperativeNoteText);
		Thread.sleep(4000);
		if (storeOperativeNoteText.startsWith(OperativeNoteText)) {

			Thread.sleep(4000);
			clickOnCloseOfOperativeNote.click();

			Thread.sleep(3000);
			// ensureElememtToBeClickable(closeSurgey);
			closeSurgey.click();

			Reporter.log("Operative note text matched and all surgery operation succesfully done");
			System.out.println("All Surgery Operation successfully done");
		}

//		Thread.sleep(3000);
//		clickOnCloseOfOperativeNote.click();
//		Reporter.log("Operative note text matched and all surgery operation succesfully done");
//		System.out.println("All Surgery Operation successfully done");

	}

	// method for edit Schedule Surgery Problem
	public void editScheduleSurgeryProblem(String favCategories, String scheduleSurgery, String whichEye,
			String associateProWithProblem, String categoryOfSurgery) throws Exception {

		Thread.sleep(6000);

		for (WebElement select_Favcategories : selectFavouriteCategroies) {
			if (select_Favcategories.getText().equalsIgnoreCase(favCategories)) {
				select_Favcategories.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_ScheduleSurgery : selectScheduledSurgeryFav) {
			if (select_ScheduleSurgery.getText().equalsIgnoreCase(scheduleSurgery)) {
				select_ScheduleSurgery.click();
				break;
			}

		}
		Thread.sleep(3000);
		for (WebElement select_SelectWhichEyeorside : selectWhichEyeorside) {
			if (select_SelectWhichEyeorside.getText().equalsIgnoreCase(whichEye)) {
				select_SelectWhichEyeorside.click();
				break;
			}
		}
		Thread.sleep(2000);
		for (WebElement select_selectAssociatedproblems : selectAssociatedproblems) {
			if (select_selectAssociatedproblems.getText().equalsIgnoreCase(associateProWithProblem)) {
				select_selectAssociatedproblems.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickOnDone.click();
	}

	public void selectSurgeryAndProcedures(String strSurgeryAndProcedure) throws Exception {
		Thread.sleep(2000);
		clickOnSurgeriAndProcedures.click();

		Thread.sleep(2000);
		for (WebElement select_ScheduledSurgery : selectScheduledSurgery) {
			if (select_ScheduledSurgery.getText().equalsIgnoreCase(strSurgeryAndProcedure)) {
				select_ScheduledSurgery.click();
				break;
			}
		}
	}

}
