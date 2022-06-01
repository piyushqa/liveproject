package pages;

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

public class PageAddProcedures {
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

	@FindBy(how = How.ID, using = "gwt-debug-addNewProblem")
	private WebElement clickOnAddNewProblem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]")
	private WebElement clickOnSignficantProblem;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-icd10popup--done\"]/a")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.ID, using = "gwt-debug-addNewPlan")
	private WebElement clickOnAddNewPlan;

	@FindBy(how = How.XPATH, using = ".//td[@class=\"gwt-TabBarItem-wrapper\"]/div//div[text()=\"Procedures\"]")
	private WebElement clickOnAddProcedures;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[2]/div[1]/select")
	private WebElement clickOnAssociatedDiagonosis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[1]/div[2]")
	private WebElement clickOnLessarSettings;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[2]/div/div[1]/input[1]")
	private WebElement clickOnYagLaser1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[2]/div/div[1]/input[2]")
	private WebElement clickOnYagLaser2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[2]/div/div[1]/input[3]")
	private WebElement clickOnYagLaser3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[2]/div/div[2]/input[1]")
	private WebElement ClickOnWaveLength;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[2]/div/div[2]/input[2]")
	private WebElement ClickOnExposure;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[2]/div/div[2]/input[3]")
	private WebElement ClickOnSpotsize;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[3]/div[2]/div/div[2]/input[4]")
	private WebElement ClickOnNumber;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[1]/div[1]/div[4]/div/div[2]")
	private WebElement getFacialNerveData;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-thisClinicNoteLink\" and text()='This Clinic Note']")
	private WebElement clickOnClinicNote;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-headingPanel\"]/div/a")
	private WebElement clickOnCancelBtn;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	public PageAddProcedures(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddProcedures.this);
	}

	public void verifyAddProcedurs(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String procedureLiberay,
			String botox, String associatedDiagnosis, String eyeOrSide, String yagLaser, String visibleLightsLeaser,
			String visitType, Boolean noCharges) throws Exception {

		//invoke method of open Encounter of pageCloseEncounterClass
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eyeOrSide, galuocmaSeverity, galuocmaStability, significantProblem);

		//invoke add procedures method
		performAddProcedures(procedureLiberay, botox, associatedDiagnosis, eyeOrSide, yagLaser, visibleLightsLeaser);

		//invoke method of close Encounter of pageCloseEncounterClass
		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	public void performAddProcedures(String procedureLiberay, String botox, String associatedDiagnosis,
			String eyeOrSide, String yagLaser, String visibleLightsLeaser) throws Exception {
		// click On AddNew Plan
		Thread.sleep(4000);
		ensureElememtToBeClickable(clickOnAddNewPlan);
		clickOnAddNewPlan.click();

		// click On AddProcedures
		Thread.sleep(4000);
		ensureElememtToBeClickable(clickOnAddProcedures);
		builder.moveToElement(clickOnAddProcedures).click().perform();

		// select_ProcedureLiberary
		Thread.sleep(3000);
		By procedureLiberary = By.xpath("//*[@id=\"gwt-debug-selectCategory-list\"]/div[1]/div");
		List<WebElement> select_ProcedureLiberary = driver.findElements(procedureLiberary);
		for (int i = 1; i <= select_ProcedureLiberary.size(); i++)
			if (select_ProcedureLiberary.get(i).getText().equalsIgnoreCase(procedureLiberay)) {
				select_ProcedureLiberary.get(i).click();
				break;
			}
		// select_botoxData

		Thread.sleep(2000);
		By botoxData = By.xpath("//*[@id=\"gwt-debug-selectItem-list\"]/div[1]/div");
		List<WebElement> select_botoxData = driver.findElements(botoxData);
		for (int i = 1; i <= select_botoxData.size(); i++)
			if (select_botoxData.get(i).getText().equalsIgnoreCase(botox)) {
				select_botoxData.get(i).click();
				break;
			}

		// click On Associated Diagonosis
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnAssociatedDiagonosis);
		clickOnAssociatedDiagonosis.click();

		// select_associated Diagonosis Data
		Thread.sleep(2000);
		By associatedDiagonosisData = By.xpath(
				"//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[2]/div[1]/select/option");
		List<WebElement> select_associatedDiagonosisData = driver.findElements(associatedDiagonosisData);
		for (WebElement selectAssociatedDiagonosisData:select_associatedDiagonosisData )
			if (selectAssociatedDiagonosisData.getText().equalsIgnoreCase(associatedDiagnosis)) {
				selectAssociatedDiagonosisData.click();
				break;
			}

		// select_Eye Or Side Data
		Thread.sleep(3000);
		By eyeOrSideData = By.xpath(
				"//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[9]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[1]/div");
		List<WebElement> select_EyeOrSideData = driver.findElements(eyeOrSideData);
		for(WebElement selectEyeOrSideData:select_EyeOrSideData) {
			if (selectEyeOrSideData.getText().equalsIgnoreCase(eyeOrSide)) {

				selectEyeOrSideData.click();
				break;
			}
		}
		// click On Lessar Settings
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnLessarSettings);
		builder.moveToElement(clickOnLessarSettings).click().perform();

		// clickOnYagLaser
		Thread.sleep(2000);
		String yagLaserData[] = yagLaser.split("-");
		clickOnYagLaser1.sendKeys(yagLaserData[0]);
		clickOnYagLaser2.sendKeys(yagLaserData[1]);
		clickOnYagLaser3.sendKeys(yagLaserData[2]);

		// visible Light Leaser Data
		Thread.sleep(2000);
		String[] visibleLightLeaserData = visibleLightsLeaser.split("-");
		ClickOnWaveLength.sendKeys(visibleLightLeaserData[0]);
		ClickOnExposure.sendKeys(visibleLightLeaserData[1]);
		ClickOnSpotsize.sendKeys(visibleLightLeaserData[2]);
		ClickOnNumber.sendKeys(visibleLightLeaserData[3]);

		// getFacialNerveData
		Thread.sleep(3000);
		String storeDataOfBotoxFacialNerve = getFacialNerveData.getText();
		System.out.println(storeDataOfBotoxFacialNerve);

		// clicK On Done Btn Of Procedures
		Thread.sleep(2000);
		By clicKOnDoneBtnOfProcedures = By.xpath("//*[@id=\"gwt-debug-done\"]/a");
		driver.findElements(clicKOnDoneBtnOfProcedures).get(2).click();

		// click On Clinic Note
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnClinicNote);
		clickOnClinicNote.click();

		// match Procedures Data
		Thread.sleep(5000);
		By matchProceduresData = By
				.xpath(".//div[text()='" + storeDataOfBotoxFacialNerve.concat(":" + " " + eyeOrSide) + "']");

		String storeClinicNoteData = driver.findElement(matchProceduresData).getText();
		System.out.println();
		System.out.println(matchProceduresData);

		Thread.sleep(3000);
		if (storeClinicNoteData.endsWith(eyeOrSide)) {
			Reporter.log(storeClinicNoteData.trim() + " " + "Same as" + " " + storeDataOfBotoxFacialNerve);
		}
		// click On Cancel Btn
		Thread.sleep(2000);
		builder.moveToElement(clickOnCancelBtn).click().perform();

	}

	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
