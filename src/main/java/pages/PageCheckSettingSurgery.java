package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageCheckSettingSurgery {

	WebDriver driver;
	WebDriverWait wait;
	PgLanding lclPgLanding = null;
	PgPatientSearch lclPgPatientSearch = null;;
	PgCreatePatient lclpgCreatePatient;
	boolean strVlaueTorF;
	Actions builder;
	// declare Locater

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/select")
	private WebElement clickOnIntegritysettings;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]")
	private WebElement clickForEnableElement;

	@FindBy(how = How.XPATH, using = "//*[@class=\"data-row\"][12]/input")
	private WebElement getElementOfEnableSurgicalFeatures;

	@FindBy(how = How.XPATH, using = ".//a[text()='Surgery Dashboard']")
	private WebElement getSurgeryDashBoard;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"textLibraryToolbar\"]/div[1]/div[1]")
	private WebElement clickOnTextLiberaryToolbar;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist__container\"]/div[1][text()=\"Cataract Surgery\"]")
	private WebElement clickOnCataractSurgery;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist__container\"]/div[1][text()=\"Cataract surgery - retrobulbar anesthesia\"]")
	private WebElement clickOnanesthesia;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Open this item\"]")
	private WebElement clickOpenItem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-libraryText\"]")
	private WebElement clickAddInformationOpNote;

	@FindBy(how = How.XPATH, using = ".//a[text()='Done']")
	private WebElement clickOnOpDoneBtn;

	@FindBy(how = How.XPATH, using = ".//*[text()='Edit']")
	private WebElement clickOnEditBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-preOpCompleteCheck-label\"]")
	private WebElement chkBoxPreOpComplete;

	@FindBy(how = How.XPATH, using = ".//a[text()='Complete']")
	private WebElement clickOnOpComplete;

	@FindBy(how = How.XPATH, using = ".//a[text()='Operative Note']")
	private WebElement clickOnOperativeNote;

	@FindBy(how = How.XPATH, using = ".//div[@id='report']")
	private WebElement checkOperativeNotePdf;

	@FindBy(xpath = "//*[@id=\"gwt-debug-selectCategory-list\"]/div[1]/div")
	private WebElement sel1;

	@FindBy(xpath = "//*[@id=\"gwt-debug-selectItem-list\"]/div[1]/div[3]")
	private WebElement sel2;

	public PageCheckSettingSurgery(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	// Function for checkSettingSurgery
	public void checkSettingsurgery(String Url, String integritySetting, String baseUrl, String fName, String lName,
			String favCategories, String scheduleSurgery, String whichEye, String associateProWithProblem,
			String categoryOfSurgery, String procedureTime, Boolean comanaging, Boolean stagedProcedure,
			Boolean relatedSurgeryBySameSurgeon, Boolean unRelatedSurgeryBySameSurgeon,
			Boolean repeatSurgeryBySameSurgeon, Boolean repeatSurgeryByDiffSurgeon, String locationOfSurgery,
			String when, String anesthesia, String surgeon, String assistantSurgeon,
			Boolean preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, boolean patientNotify,
			String comment1, boolean consentForm, boolean iOLSelection, boolean lRISelection,
			boolean patientInstructions, boolean daySurgeryOrders, boolean prescriptionsGiven, boolean sampleMedsGiven,
			boolean preopOrders, String opNoteText, String opNoteLiberary, String ContractSurgery,
			boolean preOpComplete, String dataListItem) throws Exception {

		// Navigate to setting URL
		Thread.sleep(4000);
		driver.navigate().to(Url);

		// click On Integrity Settings
		Thread.sleep(9000);
		wait = new WebDriverWait(driver, 20);
		clickOnIntegritysettings.click();

		// Select Integrity Settings
		Thread.sleep(5000);
		List<WebElement> select_Integritysetting = driver
				.findElements(By.xpath(".//div[@id=\"app\"]/div/select/option"));
		for (int i = 1; i <= select_Integritysetting.size(); i++)
			if (select_Integritysetting.get(i).getText().equalsIgnoreCase(integritySetting)) {
				select_Integritysetting.get(i).click();
				break;
			}

		// clic For EnableElement
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		clickForEnableElement.click();

		// GetVlaue Of True/False
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		String getValue = getElementOfEnableSurgicalFeatures.getAttribute("Value");

		System.out.println(getValue);
		Thread.sleep(3000);

		// check Condition is true /false
		if (getValue.equalsIgnoreCase("true")) {
			Thread.sleep(5000);

			// Navigate to BaseURL
			driver.navigate().to(baseUrl);
			Thread.sleep(3000);
			if (getSurgeryDashBoard.isDisplayed()) {
				Thread.sleep(5000);
				boolean editPatient = false;

				PgLanding lclPgLanding = new PgLanding(driver);
				lclPgPatientSearch = lclPgLanding.patientSearch();
				lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

				// call pgSurgery method
				Thread.sleep(5000);
				PgSurgery testSurgery=new PgSurgery(driver, wait, builder);
				testSurgery.surgeryPatient(favCategories, scheduleSurgery, whichEye, associateProWithProblem,
						categoryOfSurgery, procedureTime, comanaging, stagedProcedure, relatedSurgeryBySameSurgeon,
						unRelatedSurgeryBySameSurgeon, repeatSurgeryBySameSurgeon, repeatSurgeryByDiffSurgeon,
						locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon,
						preliminaryPlanningOfSurgeryComplete, surgeryDate, surgeryTime, selectLabTest, comment,
						associateLabWithProblem, designateTime, patientNotify, comment1, consentForm, iOLSelection,
						lRISelection, patientInstructions, daySurgeryOrders, prescriptionsGiven, sampleMedsGiven,
						preopOrders, opNoteText, opNoteLiberary, ContractSurgery, preOpComplete, dataListItem);

				// click On TextLiberary Toolbar
				Thread.sleep(4000);
				clickOnTextLiberaryToolbar.click();

				// click On CataractSurgery
				Thread.sleep(4000);
				clickOnCataractSurgery.click();

				// click On anesthesia
				Thread.sleep(4000);
				clickOnanesthesia.click();

				// Select List Item
				Thread.sleep(4000);
				List<WebElement> select_ListItem = driver.findElements(By.xpath(
						".//div[@class=\"datalist datalist--picklist datalist--striping datalist--singleSelect\"][3]/div[@class=\"datalist__container\"]/div"));
				for (int i = 1; i <= select_ListItem.size(); i++)
					if (select_ListItem.get(i).getText().equalsIgnoreCase(dataListItem)) {
						select_ListItem.get(i).click();
						break;
					}

				// click Open Item
				Thread.sleep(4000);
				clickOpenItem.click();
				Thread.sleep(4000);

			}

			// navigate Url
			driver.navigate().to(Url);
			// click On Integritysettings
			Thread.sleep(9000);
			wait = new WebDriverWait(driver, 20);
			clickOnIntegritysettings.click();

			// select_Integritysetting1
			Thread.sleep(5000);
			List<WebElement> select_Integritysetting1 = driver
					.findElements(By.xpath(".//div[@id=\"app\"]/div/select/option"));
			for (int i = 1; i <= select_Integritysetting1.size(); i++)
				if (select_Integritysetting1.get(i).getText().equalsIgnoreCase(integritySetting)) {
					select_Integritysetting1.get(i).click();
					break;
				}

			// click For Enable Element
			Thread.sleep(4000);
			wait = new WebDriverWait(driver, 20);
			clickForEnableElement.click();

			// getValue
			Thread.sleep(4000);
			wait = new WebDriverWait(driver, 20);
			getValue = getElementOfEnableSurgicalFeatures.getAttribute("Value");
		} // Apply Elsa condition
		else {
			// if value false
			if (getValue.equalsIgnoreCase("false"))
				// System.out.println("else condition print");
				driver.navigate().to(baseUrl);
			Thread.sleep(3000);

			// call patientSearch Function
			Thread.sleep(3000);
			boolean editPatient = false;

			lclPgLanding = new PgLanding(driver);
			lclPgPatientSearch = lclPgLanding.patientSearch();
			lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

			// call PgSurgery Method
			Thread.sleep(5000);
			PgSurgery testSurgery = null ;
			testSurgery.surgeryPatient(favCategories, scheduleSurgery, whichEye, associateProWithProblem,
					categoryOfSurgery, procedureTime, comanaging, stagedProcedure, relatedSurgeryBySameSurgeon,
					unRelatedSurgeryBySameSurgeon, repeatSurgeryBySameSurgeon, repeatSurgeryByDiffSurgeon,
					locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon,
					preliminaryPlanningOfSurgeryComplete, surgeryDate, surgeryTime, selectLabTest, comment,
					associateLabWithProblem, designateTime, patientNotify, comment1, consentForm, iOLSelection,
					lRISelection, patientInstructions, daySurgeryOrders, prescriptionsGiven, sampleMedsGiven,
					preopOrders, opNoteText, opNoteLiberary, ContractSurgery, preOpComplete, dataListItem);

			// click Select1
			Thread.sleep(4000);
			sel1.click();

			// Click Select2
			Thread.sleep(5000);
			sel2.click();

			// // clickOn Add Information OpNote if
			if (clickAddInformationOpNote.isDisplayed()) {

				Thread.sleep(3000);
				clickAddInformationOpNote.click();
				clickAddInformationOpNote.sendKeys(opNoteText);
			} // click On DoneBtn
			Thread.sleep(3000);
			clickOnOpDoneBtn.click();

			Thread.sleep(4000);
			clickOnEditBtn.click();

			// checkBox for PreOpComplete
			Thread.sleep(5000);
			if (!chkBoxPreOpComplete.isSelected() && preOpComplete)
				chkBoxPreOpComplete.click();

			// click on Done Button
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#gwt-debug-Done > a")).click();

			// click on OpComplete
			Thread.sleep(5000);
			clickOnOpComplete.click();

			// click on OperativeNote
			Thread.sleep(5000);
			clickOnOperativeNote.click();
			Thread.sleep(5000);
			if (checkOperativeNotePdf.isDisplayed()) {
				Reporter.log(" Document is visible case succesfull execute");
			} else {
				Reporter.log("Case fail");
			}

		}
	}
}
