package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageASCIntegrationForPopUpWindow {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[1]")
	private List<WebElement> select_Date;

	@FindAll({ @FindBy(how = How.XPATH, using = "//div[starts-with(text(),'Preview ASC documents')]"),
			@FindBy(how = How.CSS, using = "#content > div > div > div> div > div:nth-child(4) > div> div:nth-child(7) > div > div.gwt-Label") })
	private WebElement checkAvalibilityOfPreviewASCDocuments;

	@FindBy(how = How.CSS, using = "body > div.gwt-PopupPanel > div > div > div > div > div.datalist-item")
	private List<WebElement> checkAvalibilityOfListItem;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private WebElement clickOnClose;

	@FindBy(how = How.CSS, using = "#gwt-debug-Done>a")
	private WebElement clickOnScheduleSurgeryDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-closeSurgeriesLink>a")
	private WebElement closeSurgey;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;

	@FindBy(how = How.ID, using = "gwt-debug-tabbedPopup-tabContainer")
	private WebElement clickOnRemoveDocument;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div")
	private List<WebElement> select_SessionDate;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div")
	private List<WebElement> select_Documents;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageASCIntegrationForPopUpWindow(WebDriverWait wait, WebDriver driver, Actions builder) {
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageASCIntegrationForPopUpWindow.this);
	}

	public void verifyASCIntegrationForPopUpWindow(String fName, String lName, String favCategories,
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
			String PlannedIOL, String documents) throws Exception {

		new PageASCIntegration(wait, driver, builder).verifyASCIntegration(fName, lName);

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

		editTheSurgeryModule(select_Date);

		generatePopUpWindow(checkAvalibilityOfListItem, fName, lName, documents);
	}

	public void editTheSurgeryModule(List<WebElement> select_WebElement) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date currentDate = new Date();
		String todayDate = dateFormat.format(currentDate);
		String[] splitDate = todayDate.split("/");
		String expectedDate = splitDate[1] + "/" + splitDate[0] + "/" + splitDate[2];

		int length = select_WebElement.size();

		for (int i = 1; i <= length; i++) {
			String actualDate = driver.findElement(By.xpath(
					"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div["
							+ i + "]/table/tbody/tr/td[1]"))
					.getText();

			if (actualDate.equals(expectedDate)) {

				driver.findElement(By.xpath(
						"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/table[1]/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div["
								+ i + "]/table/tbody/tr/td[9]/a[text()=\"Edit\"]"))
						.click();

				break;
			}

		}

	}

	public void generatePopUpWindow(List<WebElement> element, String fName, String lName, String documents)
			throws Exception {

		Thread.sleep(3000);
		checkAvalibilityOfPreviewASCDocuments.click();

		selectFaceSheet(element, documents, fName, lName);

		Thread.sleep(2000);
		clickOnScheduleSurgeryDone.click();

		Thread.sleep(3000);
		closeSurgey.click();

		Thread.sleep(2000);
		clickOnDocumentCenter.click();

		Thread.sleep(4000);
		List<WebElement> select_RemoveDocument = clickOnRemoveDocument.findElements(By.xpath(".//*"));
		for (WebElement removeDocument : select_RemoveDocument) {
			if (removeDocument.getText().equalsIgnoreCase("Surgery Documents")) {
				removeDocument.click();
				break;
			}
		}

//		Thread.sleep(4000);
//		for (WebElement selectSessionDate : select_SessionDate) {
//			if (selectSessionDate.getText().endsWith(formatDate())) {
//				selectSessionDate.click();
//				break;
//			}
//		}

		//selectFaceSheet(select_Documents, documents, fName, lName);
	}

	public void selectFaceSheet(List<WebElement> element, String value, String fName, String lName) throws Exception {

		String storeName = fName + " " + lName;
		for (WebElement check_AvalibilityOfListItem : element) {
			if (check_AvalibilityOfListItem.getText().equalsIgnoreCase(value)) {
				check_AvalibilityOfListItem.click();
				break;
			}
		}

		Thread.sleep(5000);
		String getTextOfPopUpName = driver.findElement(By.xpath(".//td[text()='" + fName + " " + lName + "']"))
				.getText();

		if (getTextOfPopUpName.equalsIgnoreCase(storeName)) {
			Thread.sleep(3000);
			clickOnClose.click();
		}
	}

//	public String formatDate() throws Exception {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date currentDate = new Date();
//		String todayDate = dateFormat.format(currentDate);
//		String[] splitDate = todayDate.split("/");
//		String day = splitDate[0];
//		if (day.charAt(0) == '0')
//			day = day.charAt(1) + "";
//		String value = null;
//		switch (splitDate[1]) {
//		case "01":
//			value = "Jan";
//			break;
//		case "02":
//			value = "Feb";
//			break;
//		case "03":
//			value = "Mar";
//			break;
//		case "04":
//			value = "Apr";
//			break;
//		case "05":
//			value = "May";
//			break;
//		case "06":
//			value = "Jun";
//			break;
//		case "07":
//			value = "Jul";
//			break;
//		case "08":
//			value = "Aug";
//			break;
//		case "09":
//			value = "Sep";
//			break;
//		case "10":
//			value = "Oct";
//			break;
//		case "11":
//			value = "Nov";
//			break;
//		case "12":
//			value = "Dec";
//			break;
//		default:
//			System.out.println("Not matched the value");
//			break;
//		}
//
//		String actualDate = value + " " + day + " " + splitDate[2];
//		System.out.println(actualDate);
//		return actualDate;
//
//	}

}
