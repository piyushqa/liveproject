package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLinkAppointmentWithSurgery {
	WebDriver driver;
	Actions builder;
	WebDriverWait wait;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSrch;

	@FindBy(how = How.CSS, using = "div#gwt-debug-addAppointment>a")
	private WebElement clickOnAddAppointment;

	@FindBy(how = How.LINK_TEXT, using = "search")
	private WebElement clickOnSearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[1]")
	private List<WebElement> select_Date;

	@FindBy(how = How.CSS, using = "div#gwt-debug-surgeryModule")
	private WebElement clickOnSurgeryModule;

	@FindBy(how = How.CSS, using = "div#gwt-debug-newSurgeryLink>a")
	private WebElement clickScheduledNewSurgery;

	@FindAll({
			@FindBy(how = How.CSS, using = "div.gwt-TabLayoutPanelContentContainer>div:nth-child(2)>div>div:nth-child(3)>img"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[3]/img") })
	private WebElement clickOnImgSurgeryPlanning;

	@FindBy(how = How.XPATH, using = "//button[text()=\"Save\"]")
	private WebElement clickOnSaveBtn;

	@FindBy(how = How.XPATH, using = "//a[text()=\"Send to ASC\"]")
	private WebElement clickOnSendASC;

	@FindBy(how = How.CSS, using = "div.tempcatlist>ul>li:nth-child(2)>div>div:nth-child(1)")
	private WebElement clickOnDocument;

	@FindBy(how = How.CSS, using = "#gwt-debug-Done>a")
	private WebElement clickOnScheduleSurgeryDone;

	@FindBy(how = How.CSS, using = "div.tempcatlist>ul>li:nth-child(2)>div:nth-child(1)")
	private WebElement clickOnOpNoteDocument;

	/**
	 * @param driver
	 * @param action
	 * @param wait
	 */
	public PageLinkAppointmentWithSurgery(WebDriver driver, Actions builder, WebDriverWait wait) {
		this.driver = driver;
		this.builder = builder;
		this.wait = wait;
		PageFactory.initElements(driver, PageLinkAppointmentWithSurgery.this);
	}

	public void verifyLinkAppointmentWithSurgery(String mrn, String visitType, String date, String appointment,
			String fName, String lName, String favCategories, String scheduleSurgery, String whichEye,
			String associateProWithProblem, String categoryOfSurgery, Boolean comanaging, Boolean stagedProcedure,
			Boolean relatedSurgeryBySameSurgeon, Boolean unRelatedSurgeryBySameSurgeon,
			Boolean repeatSurgeryBySameSurgeon, Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery,
			String when, String anesthesia, String surgeon, String assistantSurgeon,
			Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, Boolean patientNotify,
			String comment1, Boolean consentForm, Boolean iOLSelection, Boolean lRISelection,
			Boolean patientInstructions, Boolean daySurgeryOrders, Boolean prescriptionsGiven, Boolean sampleMedsGiven,
			Boolean preopOrders, Boolean preOpComplete, String yagLaser, String visibleLightLaser, String drug,
			String injection, String location, String needle, String shutRef, String iStentRef, String axilAcd,
			String impression, String axisPlacement, String methodK1, String radiusk1, String axisk1, String methodK2,
			String radiusk2, String axisk2, String IOLCalCulationFormula, String PlannedIOL, String documents)
			throws Exception {

		// new PageASCIntegration(wait, driver, builder).verifyASCIntegration(fName,
		// lName);

		forAppointMentCreation(mrn, visitType, date, appointment);

		searchPatient(fName, lName);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		clickOnSurgeryModule.click();

		Thread.sleep(4000);
		clickScheduledNewSurgery.click();

		new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).scheduledSurgery(fName, lName, favCategories,
				scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery, comanaging, stagedProcedure,
				relatedSurgeryBySameSurgeon, unRelatedSurgeryBySameSurgeon, repeatSurgeryBySameSurgeon,
				repeatSurgeryByDiffSurgeon, locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon,
				preliminaryPlanningOfSurgeryComplete, surgeryDate, surgeryTime, selectLabTest, comment,
				associateLabWithProblem, designateTime, patientNotify, comment1, consentForm, iOLSelection,
				lRISelection, patientInstructions, daySurgeryOrders, prescriptionsGiven, sampleMedsGiven, preopOrders,
				preOpComplete, yagLaser, visibleLightLaser, drug, injection, location, needle, shutRef, iStentRef,
				axilAcd, impression, axisPlacement, methodK1, radiusk1, axisk1, methodK2, radiusk2, axisk2,
				IOLCalCulationFormula, PlannedIOL);

		editTheSurgeryModule(select_Date, date, "Edit");

		performSurgeryDocumentOperation(categoryOfSurgery);

		editTheSurgeryModule(select_Date, date, "Edit");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		clickOnSendASC.click();

		Thread.sleep(4000);
		clickOnScheduleSurgeryDone.click();

		editTheSurgeryModule(select_Date, date, "Op Note");

		performOpNoteOperation(categoryOfSurgery);
	}

	public void forAppointMentCreation(String mrn, String visitType, String date, String appointment) throws Exception {

		Thread.sleep(3000);
		clickOnAddAppointment.click();

		Thread.sleep(3000);
		clickOnSearch.click();

		new PageAddAppointment(driver, wait, builder).addAppointMent(mrn, visitType, date, appointment);
	}

	public void searchPatient(String fName, String lName) throws Exception {

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSrch = lclPgLanding.patientSearch();
		lclPgPatientSrch.searchPatient(fName, lName, "", editPatient);

	}

	public void editTheSurgeryModule(List<WebElement> select_WebElement, String date, String value) throws Exception {

		int length = select_WebElement.size();

		for (int i = 1; i <= length; i++) {
			String actualDate = driver.findElement(By.xpath(
					"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div["
							+ i + "]/table/tbody/tr/td[1]"))
					.getText();

			if (actualDate.equals(formatDate(date))) {

				driver.findElement(By.xpath(
						"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div["
								+ i + "]/table/tbody/tr/td[9]/a[text()='" + value + "']"))
						.click();

				break;
			}

		}

	}

	public String formatDate(String date) throws Exception {

		String[] splitDate = date.split("-");
		String expectedDate = splitDate[1] + "/" + splitDate[0] + "/" + splitDate[2];

		splitDate[2] = splitDate[2].replaceFirst("20", "");

		System.out.println(splitDate[1] + "/" + splitDate[0] + "/" + splitDate[2]);
		String day = splitDate[0];
		if (day.charAt(0) == '0')
			day = day.charAt(1) + "";
		String value = null;
		switch (splitDate[1]) {
		case "Jan":
			value = "01";
			break;
		case "Feb":
			value = "02";
			break;
		case "Mar":
			value = "03";
			break;
		case "Apr":
			value = "04";
			break;
		case "May":
			value = "05";
			break;
		case "Jun":
			value = "06";
			break;
		case "Jul":
			value = "07";
			break;
		case "Aug":
			value = "08";
			break;
		case "Sep":
			value = "09";
			break;
		case "Oct":
			value = "10";
			break;
		case "Nov":
			value = "11";
			break;
		case "Dec":
			value = "12";
			break;
		default:
			System.out.println("Not matched the value");
			break;
		}

		String actualDate = value + "/" + day + "/" + splitDate[2];
		System.out.println(actualDate);
		return actualDate;

	}

	public void performSurgeryDocumentOperation(String categoryOfSurgery) throws Exception {

		Thread.sleep(5000);
		clickOnImgSurgeryPlanning.click();
		try {
			Thread.sleep(3000);
			clickOnDocument.click();
		} catch (InvalidSelectorException e) {
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//div[starts-with(text(),'" + categoryOfSurgery + "')]"));
			Thread.sleep(3000);
			System.out.println(element.getText());
			Thread.sleep(3000);
			element.click();

		}
		Thread.sleep(2000);
		clickOnSaveBtn.click();

		Thread.sleep(4000);
		clickOnScheduleSurgeryDone.click();

	}

	public void performOpNoteOperation(String categoryOfSurgery) throws Exception {

		try {
			Thread.sleep(3000);
			clickOnOpNoteDocument.click();
		} catch (InvalidSelectorException e) {
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//div[starts-with(text(),'" + categoryOfSurgery + "')]"));
			Thread.sleep(3000);
			System.out.println(element.getText());
			Thread.sleep(3000);
			element.click();

		}
		Thread.sleep(2000);
		clickOnSaveBtn.click();

	}
}
