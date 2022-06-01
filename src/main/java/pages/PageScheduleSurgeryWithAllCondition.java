package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageScheduleSurgeryWithAllCondition {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	@FindBy(how = How.CSS, using = "div#gwt-debug-surgeryModule")
	private WebElement clickOnSurgeryModule;

	@FindBy(how = How.CSS, using = "div#gwt-debug-newSurgeryLink>a")
	private WebElement clickScheduledNewSurgery;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Surgery")
	private WebElement clickOnSelectProcedure;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Edit')]")
	private WebElement clickOnEdit1;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Edit\"]")
	private WebElement clickOnEditOnSurgeryDashboard;

	@FindBy(how = How.CSS, using = "#gwt-debug-duration")
	private WebElement proceduretimetext;

	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryLocation")
	private WebElement lstbxCategoryOfSurgery;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[1]/div[1]/input[1]")
	private WebElement fillMjshot;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[1]/div[1]/input[2]")
	private WebElement fillTotalEnergy;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[1]/div[1]/input[3]")
	private WebElement fillPluse;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[1]/div[2]/input[1]")
	private WebElement fillWaveLength;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[1]/div[2]/input[2]")
	private WebElement fillExposure;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[1]/div[2]/input[3]")
	private WebElement fillSpotSize;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[1]/div[2]/input[4]")
	private WebElement fillNumber;

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

	@FindBy(how = How.CSS, using = "#gwt-debug-planCompleteCheck-input")
	private WebElement chkBOxPreliminaryPlanningOfSurgeryComplete;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Done>a")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//td[starts-with(text(),'Plan')]")
	private WebElement getPlanText;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Edit\"]")
	private WebElement clickOnEdit;

	@FindBy(how = How.XPATH, using = ".//td[contains(text(),'Scheduling')]")
	private WebElement getScheduling;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientNotified-input")
	private WebElement chkPatientNotified;

	@FindBy(how = How.XPATH, using = ".//label[text()='Scheduling Complete']")
	private WebElement chkSchedulingComplete;

	@FindBy(how = How.XPATH, using = ".//td[contains(text(),'Sched Complete')]")
	private WebElement getSchedComplete;

	@FindBy(how = How.CSS, using = "label#gwt-debug-preOpCompleteCheck-label")
	private WebElement chkBxPreOpComplete;

	@FindBy(how = How.XPATH, using = ".//td[contains(text(),'Pre-op Complete')]")
	private WebElement getPreOpComplete;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"Consent Form\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[1]/div/span/label") })
	private WebElement chkConsentForm;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"IOL Selection\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[3]/div/span/label") })
	private WebElement IOLSelction;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"LRI Selection\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[5]/div/span/label") })
	private WebElement LRIslection;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"Patient Instructions\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[7]/div/span/label") })
	private WebElement patientInstruction;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"Day Surgery Orders\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[2]/div/span/label") })
	private WebElement daySurgeryorder;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"Prescriptions Given\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[4]/div/span/label") })
	private WebElement prescriptionGiven;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"Sample Meds Given\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[6]/div/span/label") })
	private WebElement sampleMedsGiven1;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//label[text()=\"Pre-op Orders\"]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div/table/tbody/tr[1]/td/div/div[8]/div/span/label") })
	private WebElement preOpOrders;

	@FindBy(how = How.CSS, using = "div#gwt-debug-close_overlay>a.close")
	private WebElement clickOnCloseOfOperativeNote;

	@FindBy(how = How.CSS, using = "div#gwt-debug-closeSurgeriesLink>a")
	private WebElement closeSurgey;

	// ========================================================================

	@FindBy(how = How.CSS, using = "select#gwt-debug-drug")
	private WebElement selectDrug;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[2]/div/div[3]/div[3]/input")
	private WebElement fillValueInSeries;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[2]/div/div[5]/div[2]/input")
	private WebElement fillTheValueInLocation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[2]/div/div[7]/div[2]/input")
	private WebElement fillTheValueLot;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[2]/div/div[3]/div[5]/input")
	private WebElement fillTheValueAmtGiven;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[2]/div/div[3]/div[5]/input")
	private WebElement FillOfValue;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[2]/div/div[5]/div[4]/input")
	private WebElement fillTheValueOfNeedle;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[2]/div/div[3]/div[7]/input")
	private WebElement fillTheValueOfTotal;

	// find WebElemnt for glucoma surgery

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[3]/div[1]/input")
	private WebElement fillValueInShuntRef;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[6]/div[3]/div[2]/input")
	private WebElement fillValueiStentRef;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/div/div[2]/div/ul/div/ul/li[2]/div[1]")
	private WebElement clickOnLeaserProcedureTemplate;

	@FindBy(how = How.XPATH, using = ".//button[text()=\"Save\"]")
	private WebElement clickOnSaveBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Op Note\"]")
	private WebElement clickOnOpNote;

	@FindBy(how = How.XPATH, using = "//td/a[text()=\"SxPlan Note\"]")
	private WebElement clickOnSxPlanNote;

	// find webElement for

	@FindBy(how = How.CSS, using = "div.cataract_sug>ul>li:nth-child(1)>div>input")
	private WebElement inputAxialLength;

	@FindBy(how = How.CSS, using = "div.cataract_sug>ul>li:nth-child(2)>div:nth-child(2)>input")
	private WebElement inputValueInACD;

	@FindBy(how = How.CSS, using = "select#gwt-debug-axialLengthList")
	WebElement selectAxisLength;

	@FindBy(how = How.CSS, using = "div.cataract_sug>ul>li:nth-child(2)>div:nth-child(4)>input")
	private WebElement inputValueInAxisPlaceMent;

	@FindBy(how = How.CSS, using = "div.cataract_sug>ul>li:nth-child(3)>div:nth-child(1)>button")
	private WebElement clickOnKButton;

	@FindBy(how = How.CSS, using = "select#gwt-debug-ksK1MethodDropdown")
	private WebElement selectK1;

	@FindBy(how = How.CSS, using = "select#gwt-debug-ksK2MethodDropdown")
	private WebElement selectK2;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div:nth-child(2)>table>tbody>tr:nth-child(2)>td:nth-child(3)>input")
	private WebElement fillValueOfRadiusK1;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div:nth-child(2)>table>tbody>tr:nth-child(3)>td:nth-child(3)>input")
	private WebElement fillValueOfRadiusK2;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div:nth-child(2)>table>tbody>tr:nth-child(2)>td:nth-child(4)>input")
	private WebElement clickPowerK1;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div:nth-child(2)>table>tbody>tr:nth-child(3)>td:nth-child(4)>input")
	private WebElement clickPowerK2;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div:nth-child(2)>table>tbody>tr:nth-child(2)>td:nth-child(5)>input")
	private WebElement filValueOfAxisK1;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div:nth-child(2)>table>tbody>tr:nth-child(3)>td:nth-child(5)>input")
	private WebElement filValueOfAxisK2;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div>div:nth-child(2)>a")
	private WebElement clikcOnDoneBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-headingPanel>div>a")
	private WebElement clickOnCancelBtnOfK;

	@FindBy(how = How.CSS, using = "select#gwt-debug-IOLCalculationList")
	private WebElement selectIOLCalculation;

	@FindBy(how = How.CSS, using = "div.cataract_sug>ul>li:nth-child(5)>div:nth-child(1)>button")
	private WebElement clickOnPlannedIOLBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_content>div>table>tbody>tr:nth-child(2)>td>input")
	private List<WebElement> handleThroughTableForRow;

	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_content>div>table>tbody>tr>td:nth-child(2)>input")
	private List<WebElement> handleThroughTableForCol;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div/div[2]/a")
	private WebElement clickOnDoneBtnOfPlannedIOL;

	@FindBy(how = How.CSS, using = "div.cataract_sug>ul>li:nth-child(6)>div:nth-child(1)>button")
	private WebElement clickOnTargetReffractionBtn;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageScheduleSurgeryWithAllCondition(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageScheduleSurgeryWithAllCondition.this);
	}

	public void verifyScheduleSurgeryWithAllCondition(String fName, String lName, String favCategories,
			String scheduleSurgery, String whichEye, String associateProWithProblem, String categoryOfSurgery,
			String yagLaser, String visibleLightLaser, String locationOfSurgery, String when, String anesthesia,
			String surgeon, String assistantSurgeon, String surgeryDate, Boolean preliminaryPlanningOfSurgeryComplete,
			Boolean patientNotify, Boolean preOpComplete, Boolean consentForm, Boolean iOLSelection,
			Boolean lRISelection, Boolean patientInstructions, Boolean daySurgeryOrders, Boolean prescriptionsGiven,
			Boolean sampleMedsGiven, Boolean preopOrders, String drug, String injection, String location, String needle,
			String shutRef, String iStentRef, String axilAcd, String impression, String axisPlacement, String methodK1,
			String radiusk1, String axisk1, String methodK2, String radiusk2, String axisk2,
			String IOLCalCulationFormula, String PlannedIOL) throws Exception {

		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnSurgeryModule);
		clickOnSurgeryModule.click();

		Thread.sleep(2000);
		ensureElememtToBeClickable(clickScheduledNewSurgery);
		clickScheduledNewSurgery.click();

		try {
			Thread.sleep(2000);
			clickOnEdit1.click();
		} catch (Exception e) {
			ensureElememtToBeClickable(clickOnSelectProcedure);
			clickOnSelectProcedure.click();
		}
		// select surgery problem
		new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).editScheduleSurgeryProblem(favCategories,
				scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery);

		// select category surgery
		categoryOfSurgery(categoryOfSurgery, yagLaser, visibleLightLaser, drug, injection, location, needle, shutRef,
				iStentRef, axilAcd, impression, axisPlacement, methodK1, radiusk1, axisk1, methodK2, radiusk2, axisk2,
				IOLCalCulationFormula, PlannedIOL);

		// fill all value in surgery drop down

		fillSurgeryDropDown(locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon);

//		Thread.sleep(1000);
//
//		// select date
//		// new PgSurgery(driver, wait, builder).calenderMethod(surgeryDate);

		ensureElememtToBeClickable(clickOnDone);
		clickOnDone.click();

		// match plan
		matchPlan(preliminaryPlanningOfSurgeryComplete);

		// match scheduling
		matchScheduling(patientNotify);

		// match scheComplte
		matchScheComplete(preOpComplete);

		// match preOp Complete
		// matchPreOpComplete(consentForm, iOLSelection, lRISelection,
		// patientInstructions, daySurgeryOrders,
		// prescriptionsGiven, sampleMedsGiven, preopOrders);

		// matchSxOpNote(categoryOfSurgery);

		// perform OpNote operation
		// new PageSurgeryModuleFromOutSideEncounter(driver, wait,
		// builder).oPNoteAndOperativeNote();

		// when opNote settings false
		new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).oPNoteAndOperativeNoteWhenItOff(fName, lName);

		// match operativeNote Data
		// matchOperativeNoteData();

	}

	public void categoryOfSurgery(String categoryOfSurgery, String yagLaser, String visibleLightLaser, String drug,
			String injection, String location, String needle, String shutRef, String iStentRef, String axilAcd,
			String impression, String axisPlacement, String methodK1, String radiusk1, String axisk1, String methodK2,
			String radiusk2, String axisk2, String IOLCalCulationFormula, String PlannedIOL) throws Exception {
		Thread.sleep(3000);
		Select selectCategory = new Select(lstbxCategoryOfSurgery);
		selectCategory.selectByValue(categoryOfSurgery);

		switch (categoryOfSurgery) {
		case "LASER Procedure":
			Thread.sleep(2000);
			proceduretimetext.click();
			proceduretimetext.clear();
			proceduretimetext.sendKeys("10");
			fillValueOfLaserProcedure(yagLaser, visibleLightLaser);
			break;
		case "Intraocular Injection":
			Thread.sleep(2000);
			proceduretimetext.click();
			proceduretimetext.clear();
			proceduretimetext.sendKeys("10");
			 fillValueOfIntrocularInjection(drug, injection, location, needle);
			break;
		case "Glaucoma Surgery":
			Thread.sleep(2000);
			proceduretimetext.click();
			proceduretimetext.clear();
			proceduretimetext.sendKeys("10");
			fillValueInGlaucomaSurgery(shutRef, iStentRef);
			break;

		case "Cataract Surgery":
			Thread.sleep(2000);
			proceduretimetext.click();
			proceduretimetext.clear();
			fillValueInCataractSurgery(axilAcd, impression, axisPlacement, methodK1, radiusk1, axisk1, methodK2,
					radiusk2, axisk2, IOLCalCulationFormula, PlannedIOL);
			proceduretimetext.sendKeys("10");
			break;
		case "":
			Thread.sleep(2000);
			proceduretimetext.click();
			proceduretimetext.clear();
			proceduretimetext.sendKeys("10");
			break;
		default:
			System.out.println("Not Match any condition");

		}

	}

	public void fillValueOfLaserProcedure(String yagLaser, String visibleLightLaser) throws Exception {

		Thread.sleep(5000);
		String[] strYagLaser = yagLaser.split("-");

		ensureElememtToBeClickable(fillMjshot);
		fillMjshot.sendKeys(strYagLaser[0]);

		ensureElememtToBeClickable(fillTotalEnergy);
		fillTotalEnergy.sendKeys(strYagLaser[1]);

		ensureElememtToBeClickable(fillPluse);
		fillPluse.sendKeys(strYagLaser[2]);

		Thread.sleep(2000);
		String[] strVisibleLightLaser = visibleLightLaser.split("-");

		ensureElememtToBeClickable(fillWaveLength);
		fillWaveLength.sendKeys(strVisibleLightLaser[0]);

		ensureElememtToBeClickable(fillExposure);
		fillExposure.sendKeys(strVisibleLightLaser[1]);

		ensureElememtToBeClickable(fillSpotSize);
		fillSpotSize.sendKeys(strVisibleLightLaser[2]);

		ensureElememtToBeClickable(fillNumber);
		fillNumber.sendKeys(strVisibleLightLaser[3]);
	}

	public void fillValueOfIntrocularInjection(String drug, String injection, String location, String needle)
			throws Exception {
		ensureElememtToBeClickable(selectDrug);

		Select select_Drug = new Select(selectDrug);
		select_Drug.selectByVisibleText(drug);

		String[] splitInjection = injection.split("-");

		fillValueInSeries.sendKeys(splitInjection[0]);

		FillOfValue.sendKeys(splitInjection[1]);

		fillTheValueOfTotal.sendKeys(splitInjection[2]);

		String[] splitLocation = location.split("-");

		fillTheValueInLocation.sendKeys(splitLocation[0]);

		fillTheValueLot.sendKeys(splitLocation[1]);

		fillTheValueAmtGiven.sendKeys(splitLocation[2]);

		fillTheValueOfNeedle.sendKeys(needle);

	}

	public void fillValueInGlaucomaSurgery(String shutRef, String iStentRef) throws Exception {

		Thread.sleep(3000);
		fillValueInShuntRef.sendKeys(shutRef);

		Thread.sleep(3000);
		fillValueiStentRef.sendKeys(iStentRef);

	}

	public void fillValueInCataractSurgery(String axilAcd, String impression, String axisPlacement, String methodK1,
			String radiusk1, String axisk1, String methodK2, String radiusk2, String axisk2,
			String IOLCalCulationFormula, String PlannedIOL) throws Exception {

		String[] strAxilAcd = axilAcd.split("-");

		inputAxialLength.sendKeys(strAxilAcd[0]);

		inputValueInACD.sendKeys(strAxilAcd[1]);

		Select sel_Impression = new Select(selectAxisLength);
		sel_Impression.selectByValue(impression);

		inputValueInAxisPlaceMent.sendKeys(axisPlacement);

		clickOnKButton.click();

		Select k1 = new Select(selectK1);
		k1.selectByValue(methodK1);

		fillValueOfRadiusK1.sendKeys(radiusk1);

		clickPowerK1.click();

		filValueOfAxisK1.sendKeys(axisk1);

		Select k2 = new Select(selectK2);
		k2.selectByValue(methodK2);

		fillValueOfRadiusK2.sendKeys(radiusk2);

		clickPowerK2.click();

		filValueOfAxisK2.sendKeys(axisk2);

		try {
			clikcOnDoneBtn.click();
		} catch (Exception e) {
			clickOnCancelBtnOfK.click();
		}

		Select select_IOLCalculation = new Select(selectIOLCalculation);
		select_IOLCalculation.selectByValue(IOLCalCulationFormula);

		clickOnPlannedIOLBtn.click();

		int totalNoOfRow = handleThroughTableForRow.size();
		System.out.println(totalNoOfRow);
		int totalNoOfCol = handleThroughTableForCol.size();
		System.out.println(totalNoOfCol);

		for (int i = 2; i <= 5; i++) {
			for (int j = 2; j <= 4; j++) {

				driver.findElement(By.xpath(
						"//div[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr[" + i + "]/td[" + j + "]/input"))
						.sendKeys("5");

			}
		}

		clickOnDoneBtnOfPlannedIOL.click();

	}

	public void fillSurgeryDropDown(String locationOfSurgery, String when, String anesthesia, String surgeon,
			String assistantSurgeon) throws Exception {// Location of surgery
		Select selectObject;

		Thread.sleep(2000);
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

		// Surgeon
		lstBoxSurgeon.click();
		selectObject = new Select(lstBoxSurgeon);
		selectObject.selectByVisibleText(surgeon);

		// Assistant Surgeon
		lstBoxAssistantSurgeon.click();
		selectObject = new Select(lstBoxAssistantSurgeon);
		selectObject.selectByVisibleText(assistantSurgeon);
	}

	public void matchPlan(Boolean preliminaryPlanningOfSurgeryComplete) throws Exception {
		String strPlan = "Plan";

		Thread.sleep(3000);
		String storePlanText = getPlanText.getText();
		if (strPlan.equalsIgnoreCase(storePlanText)) {
			ensureElememtToBeClickable(clickOnEdit);
			clickOnEdit.click();

			Thread.sleep(5000);
			if (!chkBOxPreliminaryPlanningOfSurgeryComplete.isSelected() && preliminaryPlanningOfSurgeryComplete) {
				chkBOxPreliminaryPlanningOfSurgeryComplete.click();
			}

			ensureElememtToBeClickable(clickOnDone);
			clickOnDone.click();
		}

		// Reporter.log("Surgery Plan completed");
	}

	public void matchScheduling(Boolean patientNotify) throws Exception {
		String strScheduling = "Scheduling";

		Thread.sleep(2000);
		String storeScheduling = getScheduling.getText();
		if (strScheduling.equalsIgnoreCase(storeScheduling)) {

			ensureElememtToBeClickable(clickOnEdit);
			clickOnEdit.click();

			Thread.sleep(5000);
			// check box for patient notified and sechudling complete
			// if (!chkPatientNotified.isSelected() && patientNotify) {
			chkPatientNotified.click();
			// }

			Thread.sleep(1000);
			chkSchedulingComplete.click();

			ensureElememtToBeClickable(clickOnDone);
			clickOnDone.click();
		}
		Reporter.log("Surgery Scheduling completed");
	}

	public void matchScheComplete(Boolean preOpComplete) throws Exception {
		String strScheComplete = "Sched Complete";

		Thread.sleep(2000);
		String storeScheComplete = getSchedComplete.getText();
		if (strScheComplete.equalsIgnoreCase(storeScheComplete)) {

			ensureElememtToBeClickable(clickOnEdit);
			clickOnEdit.click();

			// check box for preOp complete

			Thread.sleep(5000);
			if (!chkBxPreOpComplete.isSelected() && preOpComplete) {
				chkBxPreOpComplete.click();
			}
			ensureElememtToBeClickable(clickOnDone);
			clickOnDone.click();
		}

		Reporter.log("Surgery Schedu Complete");
	}

	public void matchPreOpComplete(Boolean consentForm, Boolean iOLSelection, Boolean lRISelection,
			Boolean patientInstructions, Boolean daySurgeryOrders, Boolean prescriptionsGiven, Boolean sampleMedsGiven,
			Boolean preopOrders) throws Exception {
		String strPreOpComplete = "Pre-op Complete";

		String storePreOpComplete = getPreOpComplete.getText();
		if (strPreOpComplete.equalsIgnoreCase(storePreOpComplete)) {

			ensureElememtToBeClickable(clickOnEdit);
			clickOnEdit.click();

			// check box for Consent form

			Thread.sleep(4000);
			if (!chkConsentForm.isSelected() && consentForm) {
				builder.moveToElement(chkConsentForm).click().build().perform();
			}

			Thread.sleep(1000);
			if (!IOLSelction.isSelected() && iOLSelection) {
				IOLSelction.click();
			}

			Thread.sleep(1000);
			if (!LRIslection.isSelected() && lRISelection) {
				LRIslection.click();
			}

			Thread.sleep(1000);
			if (!patientInstruction.isSelected() && patientInstructions) {
				patientInstruction.click();
			}

			Thread.sleep(1000);
			if (!daySurgeryorder.isSelected() && daySurgeryOrders) {
				daySurgeryorder.click();
			}

			Thread.sleep(1000);
			if (!prescriptionGiven.isSelected() && prescriptionsGiven) {
				prescriptionGiven.click();
			}

			Thread.sleep(1000);
			if (!sampleMedsGiven1.isSelected() && sampleMedsGiven) {
				sampleMedsGiven1.click();
			}

//			Thread.sleep(1000);
//			if (!preOpOrders.isSelected() && preopOrders) {
//				preOpOrders.click();
//			}

			ensureElememtToBeClickable(clickOnDone);
			clickOnDone.click();
		}
		Reporter.log("Surgery pre Op Completed");
	}

	public void matchOperativeNoteData() throws Exception {
		String OperativeNoteText = "Ankit Text";
		WebElement element = driver.findElement(By.xpath(".//td[contains(text(),'" + OperativeNoteText + "')]"));

		String storeOperativeNoteText = element.getText();
		if (storeOperativeNoteText.endsWith(OperativeNoteText)) {

			Thread.sleep(4000);
			clickOnCloseOfOperativeNote.click();

			Thread.sleep(3000);
			ensureElememtToBeClickable(closeSurgey);
			closeSurgey.click();

			Reporter.log("Operative note text matched and all surgery operation succesfully done");
			System.out.println("All Surgery Operation successfully done");
		}
	}

	public void matchSxOpNote(String categoryOfSurgery) throws Exception {
		Thread.sleep(4000);
		clickOnSxPlanNote.click();

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement selectMedicineTemplate = driver.findElement(By.xpath(
				"//div[@class=\"searchlst\"]/ul/div/ul/li/div/div[starts-with(text(),' Intraocular Injection')]"));
		System.out.println(selectMedicineTemplate.getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectMedicineTemplate);

//		Thread.sleep(7000);
//		clickOnLeaserProcedureTemplate.click();
//
//		Thread.sleep(8000);
//		clickOnSaveBtn.click();

	}

	// function is used for visibility and clickAble of WebElements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
