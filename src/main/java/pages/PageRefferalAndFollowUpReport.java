package pages;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageRefferalAndFollowUpReport {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;

	PgPatientSearch lclPgPatientSearch;

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

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	// Locater for perform follow referral operation

	@FindBy(how = How.XPATH, using = ".//a[text()='Add Provider']")
	private WebElement clickOnAddProvider;

	@FindBy(how = How.XPATH, using = "//*[@id='modal-popup-message']/div/div/div/div/div[3]/div/div[12]/div/div[2]/div[2]/div[1]/div[2]/div[2]")
	private WebElement clickRefferalTo;

	@FindBy(how = How.XPATH, using = ".//div[text()='Complete']")
	private WebElement clickOnComplete;

	@FindBy(how = How.XPATH, using = ".//a[text()='Notify Other Providers']")
	private WebElement clickOnNotifyOtherProvider;

	@FindBy(how = How.XPATH, using = ".//div[text()='Internal']")
	private WebElement clickOnInternal;

	@FindBy(how = How.XPATH, using = ".//input[@id='gwt-debug-firstName']")
	private WebElement fillTheFirstName;

	@FindBy(how = How.XPATH, using = ".//a[text()='Search']")
	private WebElement clickOnSearch;

	@FindBy(how = How.XPATH, using = ".//div[text()='Direct']")
	private WebElement clickOnDirect;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder=\"comments\"]")
	private WebElement fillComments;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-referPatientToDoctor\"]/div[2]/textarea")
	private WebElement fillCommentsForMatch;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder='reason for referral']")
	private WebElement fillTextInput;

	@FindBy(how = How.CSS, using = "#gwt-debug-notifyProviderFooter > div.overlay_footer > div.float_right > div.btn_green>a")
	private WebElement clickOnDoneButton;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;

	// =========================================================================
	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][1]/button[2]/span")
	private WebElement clickOnRefferalToTestEnv;

	@FindBy(how = How.CSS, using = "div#gwt-debug-referPatientToDoctor>div>h4>svg")
	private WebElement clickOnAddProviderTestEnv;

	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][2]/button[1]/span")
	private WebElement clickOnCompleteTestEnv;

	@FindBy(how = How.XPATH, using = ".//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][3]/button[1]/span")
	private WebElement clickOnDirectTestEnv;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder=\"Comments\"]")
	private WebElement fillCommentTestEnv;

	@FindBy(how = How.XPATH, using = " .//div[@class=\"ql-container ql-snow\"]/div[1]")
	private WebElement fillLetterPreviewComment;

	@FindBy(how = How.XPATH, using = ".//span[text()=\"Mail\"]")
	private WebElement clickOnMail;

	public PageRefferalAndFollowUpReport(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageRefferalAndFollowUpReport.this);
	}

	// function for verify and refferal report
	public void verifyRefferalAndFollowUpreport(String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges, String name, Boolean refferal,
			String comments, String documents) throws Exception {

		// function to open the encounter and the problem
		Thread.sleep(2000);
		PageCloseEncounter closeEncounter = new PageCloseEncounter(wait, driver, builder);
		closeEncounter.openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, significantProblem);

		// function is used for refferal and followUp Operation
		Thread.sleep(2000);
		// refferalAndFollowUp(name, refferal, comments);

		refferalReportForTestEnv(name, refferal, comments);

		//matchCommentData(name, comments);

		// this function is used for close Encounter
		Thread.sleep(2000);
		closeEncounter = new PageCloseEncounter(wait, driver, builder);
		closeEncounter.closeEncounter(visitType, noCharges);

		// function is used for search and select same patient
		Thread.sleep(2000);
		searchAndSelectSamePatient(fName, lName, documents, name);
	}

	// function is used perform refferal and follow up operation
	public void refferalAndFollowUp(String name, Boolean refferal, String comments) throws Exception {

		// click On AddProvider
		Thread.sleep(1000);
		ensureElememtToBeClickable(clickOnAddProvider);
		clickOnAddProvider.click();

		// click On Refferal To
		Thread.sleep(1000);
		ensureElememtToBeClickable(clickRefferalTo);
		if (!clickRefferalTo.isSelected() && refferal) {
			clickRefferalTo.click();
		}

		// click On Complete
		Thread.sleep(1000);
		ensureElememtToBeClickable(clickOnComplete);
		clickOnComplete.click();

		// click On NotifyOther Provider
		Thread.sleep(1000);
		ensureElememtToBeClickable(clickOnNotifyOtherProvider);
		clickOnNotifyOtherProvider.click();

		// click On Internal
		Thread.sleep(1000);
		ensureElememtToBeClickable(clickOnInternal);
		clickOnInternal.click();

		// click On Fill The FirstName
		Thread.sleep(1000);
		ensureElememtToBeClickable(fillTheFirstName);
		fillTheFirstName.sendKeys(name);

		// click On search;
		Thread.sleep(3000);

		ensureElememtToBeClickable(clickOnSearch);
		clickOnSearch.click();

		Thread.sleep(8000);
		java.util.List<WebElement> providerSearch = driver
				.findElements(By.cssSelector("table#gwt-debug-providerSearchResultTable>tbody>tr>td>div"));
		for (WebElement serach_Provider : providerSearch)
			if (serach_Provider.getText().equalsIgnoreCase(name)) {
				builder.moveToElement(serach_Provider).click().build().perform();
				break;
			}

		// click On Complete
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnComplete);
		clickOnComplete.click();

		// click On Direct
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnDirect);
		clickOnDirect.click();

//		Thread.sleep(4000);
//		ensureElememtToBeClickable(fillCommentsForMatch);
//		fillCommentsForMatch.sendKeys(comments);

		// click on Done Button
		Thread.sleep(5000);

		ensureElememtToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();

	}

	public void refferalReportForTestEnv(String name, Boolean refferal, String comments) throws Exception {
		System.out.println(name);
		// click On AddProvider
		Thread.sleep(1000);
		ensureElememtToBeClickable(clickOnAddProvider);
		clickOnAddProvider.click();

		Thread.sleep(2000);
		clickOnAddProviderTestEnv.click();

		Thread.sleep(3000);
		clickOnInternal.click();

		Thread.sleep(1000);
		ensureElememtToBeClickable(fillTheFirstName);
		fillTheFirstName.sendKeys(name);

		// click On search;
		Thread.sleep(3000);

		ensureElememtToBeClickable(clickOnSearch);
		clickOnSearch.click();

		Thread.sleep(4000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		java.util.List<WebElement> providerSearch = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-providerSearchResultTable\"]/tbody/tr/td"));
		for (int i = 0; i < providerSearch.size(); i++)

			if (providerSearch.get(i).getText().equalsIgnoreCase(name)) {
				providerSearch.get(i).click();
				break;
			}

		Thread.sleep(2000);
		if (!clickOnRefferalToTestEnv.isSelected() && refferal) {
			clickOnRefferalToTestEnv.click();
		}

		Thread.sleep(2000);
		clickOnCompleteTestEnv.click();

		try {
			Thread.sleep(3000);
			ensureElememtToBeClickable(clickOnDirectTestEnv);
			clickOnDirectTestEnv.click();
		} catch (Exception ex) {
			clickOnMail.click();
		}

//		Thread.sleep(3000);
//		fillCommentTestEnv.sendKeys("Test Enviorment reffreal report");
//
//		Thread.sleep(3000);
//		fillLetterPreviewComment.sendKeys("Test enviorment refferal report");

		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();

	}

	public void matchCommentData(String name, String comments) throws Exception {
		Thread.sleep(5000);
		WebElement strSelectNameFromAddProvider = driver
				.findElement(By.xpath(".//div[starts-with(text(),'" + name + "')]"));
		ensureElememtToBeClickable(strSelectNameFromAddProvider);
		strSelectNameFromAddProvider.click();

		Thread.sleep(5000);
		String strCommentForMatch = fillCommentsForMatch.getAttribute("value");
		if (comments.endsWith(strCommentForMatch)) {
			System.out.println("Comment successfully match");
		} else {
			Reporter.log(comments + " " + "Same as" + " " + strCommentForMatch);
			System.out.println("Comment not matched");
		}
		Thread.sleep(5000);

		ensureElememtToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();

	}

	public void searchAndSelectSamePatient(String fName, String lName, String documents, String name) throws Exception {
		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		// click on Document center
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnDocumentCenter);
		clickOnDocumentCenter.click();

		// select_Documents
		Thread.sleep(2000);
		List<WebElement> select_Documents = driver
				.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase(documents)) {
				select_Documents.get(i).click();
				break;
			}
		// click On Provider name for view
		Thread.sleep(3000);
		WebElement clickOnProviderNameForView = driver
				.findElement(By.xpath(".//div[starts-with(text(),'" + name + "')]"));
		ensureElememtToBeClickable(clickOnProviderNameForView);
		clickOnProviderNameForView.click();

	}

	// fuction is used for visibility and clickAble of elements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
