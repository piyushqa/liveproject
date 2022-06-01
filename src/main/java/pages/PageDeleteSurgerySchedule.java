package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageDeleteSurgerySchedule {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// Define locater

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div")
	private List<WebElement> selectProvider;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Surgeries and Procedures\"]")
	private WebElement clickOnSurgeriAndProcedures;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"popupContent\"]/div/div/div[2]/div")
	private List<WebElement> selectScheduledSurgery;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Edit\"]")
	private WebElement clickOnEdit;

	@FindBy(how = How.CSS, using = "#gwt-debug-Done>a")
	private WebElement clickOnScheduleSurgeryDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-closeSurgeriesLink>a")
	private WebElement closeSurgey;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Delete>a")
	private WebElement clickOnDelete;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok")
	private WebElement clickOnOk;

	public PageDeleteSurgerySchedule(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageDeleteSurgerySchedule.this);
	}

	public void verifyDeleteSurgerySchedule(String provider, String favCategories, String scheduleSurgery,
			String whichEye, String associateProWithProblem, String categoryOfSurgery, Boolean comanaging,
			Boolean stagedProcedure, Boolean relatedSurgeryBySameSurgeon, Boolean unRelatedSurgeryBySameSurgeon,
			Boolean repeatSurgeryBySameSurgeon, Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery,
			String when, String anesthesia, String surgeon, String assistantSurgeon,
			Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, Boolean patientNotify,
			String comment1, Boolean consentForm, Boolean iOLSelection, Boolean lRISelection,
			Boolean patientInstructions, Boolean daySurgeryOrders, Boolean prescriptionsGiven, Boolean sampleMedsGiven,
			Boolean preopOrders, Boolean preOpComplete) throws Exception {

		// click join encounter and select provider
		Thread.sleep(9000);
		clickJionOpenencounter.click();
		Thread.sleep(3000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(1000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
			for (WebElement select_JoinencounterProvider : selectProvider) {
				if (select_JoinencounterProvider.getText().equalsIgnoreCase(provider)) {
					select_JoinencounterProvider.click();
					break;
				}
			}
		}

		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

		}

		// invoke method for edit/add surgery

//		performDeleteSurgeyModuleOperation(favCategories, scheduleSurgery, whichEye, associateProWithProblem,
//				categoryOfSurgery, comanaging, stagedProcedure, relatedSurgeryBySameSurgeon,
//				unRelatedSurgeryBySameSurgeon, repeatSurgeryBySameSurgeon, repeatSurgeryByDiffSurgeon,
//				locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon, preliminaryPlanningOfSurgeryComplete,
//				surgeryDate, surgeryTime, selectLabTest, comment, associateLabWithProblem, designateTime, patientNotify,
//				comment1, consentForm, iOLSelection, lRISelection, patientInstructions, daySurgeryOrders,
//				prescriptionsGiven, sampleMedsGiven, preopOrders, preOpComplete);

	}

	// method for edit/add surgery
	public void performDeleteSurgeyModuleOperation(String favCategories, String scheduleSurgery, String whichEye,
			String associateProWithProblem, String categoryOfSurgery, Boolean comanaging, Boolean stagedProcedure,
			Boolean relatedSurgeryBySameSurgeon, Boolean unRelatedSurgeryBySameSurgeon,
			Boolean repeatSurgeryBySameSurgeon, Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery,
			String when, String anesthesia, String surgeon, String assistantSurgeon,
			Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, Boolean patientNotify,
			String comment1, Boolean consentForm, Boolean iOLSelection, Boolean lRISelection,
			Boolean patientInstructions, Boolean daySurgeryOrders, Boolean prescriptionsGiven, Boolean sampleMedsGiven,
			Boolean preopOrders, Boolean preOpComplete) throws Exception {

		// invoke surgery and procedure
		Thread.sleep(2000);
		selectSurgeryAndProcedure();

		// try blockused for edit the surgery if avilable
		try {

			boolean checkEdit = clickOnEdit.isDisplayed();
			System.out.println(checkEdit);
			if (checkEdit) {

				Thread.sleep(2000);
				clickOnEdit.click();
				new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).editScheduleSurgeryProblem(
						favCategories, scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery);

				Thread.sleep(2000);
				clickOnDelete.click();

				driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
				clickOnOk.click();

				Thread.sleep(2000);
				closeSurgey.click();
			}

		} catch (Exception e) {
			// catch block is used for add the surgery
//			new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).scheduledSurgery(favCategories,
//					scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery, comanaging, stagedProcedure,
//					relatedSurgeryBySameSurgeon, unRelatedSurgeryBySameSurgeon, repeatSurgeryBySameSurgeon,
//					repeatSurgeryByDiffSurgeon, locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon,
//					preliminaryPlanningOfSurgeryComplete, surgeryDate, surgeryTime, selectLabTest, comment,
//					associateLabWithProblem, designateTime, patientNotify, comment1, consentForm, iOLSelection,
//					lRISelection, patientInstructions, daySurgeryOrders, prescriptionsGiven, sampleMedsGiven,
//					preopOrders, preOpComplete);

		}

	}

	//select Surgery And Procedure method 
	private void selectSurgeryAndProcedure() throws Exception {
		Thread.sleep(2000);
		clickOnSurgeriAndProcedures.click();

		Thread.sleep(2000);
		for (WebElement select_ScheduledSurgery : selectScheduledSurgery) {
			if (select_ScheduledSurgery.getText().equalsIgnoreCase("Schedule Surgery")) {
				select_ScheduledSurgery.click();
				break;
			}
		}
	}

}
