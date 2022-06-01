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
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCanSendNotifyProviderLettersOutsideTheEncounter {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSrch;
	JavascriptExecutor js;
	String strActualEncounterDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[4]/div[1]/table/tbody/tr[1]/td[1]/a")
	private WebElement clickOnUserMgt;

	@FindBy(how = How.CSS, using = "#gwt-debug-saveButton > a")
	private WebElement clickOnsaveBtn;

	@FindBy(how = How.CSS, using = "#content > div > div > div:nth-child(3) > div > div> div:nth-child(4) > a>img")
	private WebElement checkNotifyProviderImg;

	@FindBy(how = How.CSS, using = "a#gwt-debug-notifyProviderAnchor")
	private WebElement clickOnAddProvider;

	// WebElement for perfrom refferal report

	@FindBy(how = How.XPATH, using = "//*[@id='modal-popup-message']/div/div/div/div/div[3]/div/div[12]/div/div[2]/div[2]/div[1]/div[2]/div[2]")
	private WebElement clickRefferalTo;

	@FindBy(how = How.XPATH, using = ".//div[text()='Complete']")
	private WebElement clickOnComplete;

	@FindBy(how = How.XPATH, using = ".//a[text()='Notify Other Providers']")
	private WebElement clickOnNotifyOtherProvider;

	@FindBy(how = How.XPATH, using = ".//div[text()='External']")
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

	// select webelement for NPL

	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_content>div>div:nth-child(2)>div#gwt-debug-comanageList-button>div:nth-child(3)")
	private WebElement clickOnSendingProvider;

	@FindBy(how = How.CSS, using = "div#gwt-debug-comanageList-container>div")
	private List<WebElement> select_SendingProvider;

	@FindBy(how = How.CSS, using = "div.rightCol>div>div>svg>path")
	private WebElement clickOnSettingsBtn;

	@FindBy(how = How.XPATH, using = "//span[@class=\"templateNameSpan\"]/span[text()=\"Integrity - Referral\"]")
	private List<WebElement> clickOnRefferalTemplate;

	@FindAll({ @FindBy(how = How.CSS, using = "div.card-configurableTemplateFooter>div>div:nth-child(2)>button"),
			@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Save')]") })
	private WebElement clickOnSaveBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content > div > div> div > div > div:nth-child(3) > div > div > div > svg")
	private WebElement clickOnCancelBtnofTemplate;

	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'Get another template')]")
	private WebElement clickOnGetAnotherTemplate;

//	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[12]/div/div[2]/div[2]/div/div/div[1]/div/div/div/button")
//	private List<WebElement> select_Template;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[2]/div/div[3]/div/div/div[2]/div/div/div[2]/div/div/div/button[1]"),
			@FindBy(how = How.XPATH, using = "//button[contains(text(),'Integrity - Referral')]") })
	private WebElement selectTemplate;

	@FindBy(how = How.CSS, using = "div#gwt-debug-priorClinicVisits-container>table>tbody>tr:nth-child(1)>td:nth-child(1)>span")
	private WebElement getEncounterStartDate;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/table/tbody/tr/td[2]/div/a/div")
	private List<WebElement> getDocumentcenterDate;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageCanSendNotifyProviderLettersOutsideTheEncounter(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageCanSendNotifyProviderLettersOutsideTheEncounter.this);
	}

	public void verifyNotifyProviderLettersOutsideTheEncounter(String userName, String password, String fName,
			String lName, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, boolean significantProblem, String visitType,
			boolean noCharge) throws Exception {

		Thread.sleep(3000);
		clickOnUserMgt.click();

		new PageResidentWorkflow(driver, wait, builder).editProvider("ankitTestprovider01347");

		new PageResidentWorkflow(driver, wait, builder).performSuperVisingOperation(true, true);

		ensureElementToBeClickable(clickOnsaveBtn);
		clickOnsaveBtn.click();

		new PageResidentWorkflow(driver, wait, builder).logOutAndLogin(userName, password);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSrch = lclPgLanding.patientSearch();
		lclPgPatientSrch.searchPatient(fName, lName, "", editPatient);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		strActualEncounterDate = getEncounterStartDate.getText();
		System.out.println(strActualEncounterDate);

		try {
			// boolean checkValue = checkNotifyProviderImg.isDisplayed();
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkNotifyProviderImg);

			performNplTemplateOperation("Tom Crow, M.D.");
			performNplSettingsTemplateOperation();

			refferalReportForTestEnv("Gita2");

			performTemplateOperation(true, true, true);

			matchDataInDocumentcenter();
		} catch (Exception e) {

			new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
					eye, galuocmaSeverity, galuocmaStability, significantProblem);

			Thread.sleep(5000);
			clickOnAddProvider.click();

			performNplSettingsTemplateOperation();

			performNplSettingsTemplateOperation();

			refferalReportForTestEnv("Gita2");

			performTemplateOperation(true, true, true);

			new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharge);
		}

	}

	public void refferalReportForTestEnv(String name) throws Exception {

		Thread.sleep(2000);
		clickOnAddProviderTestEnv.click();

		Thread.sleep(3000);
		clickOnInternal.click();

		Thread.sleep(1000);
		ensureElementToBeClickable(fillTheFirstName);
		fillTheFirstName.sendKeys(name);

		// click On search;
		Thread.sleep(3000);

		ensureElementToBeClickable(clickOnSearch);
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
	}

	public void performNplTemplateOperation(String providerName) throws Exception {

		Thread.sleep(3000);
		clickOnSendingProvider.click();

		Thread.sleep(2000);
		for (WebElement selectSendingProvider : select_SendingProvider) {
			if (selectSendingProvider.getText().equalsIgnoreCase(providerName)) {
				selectSendingProvider.click();
				break;
			}
		}
	}

	public void performNplSettingsTemplateOperation() throws Exception {
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnSettingsBtn);
		builder.moveToElement(clickOnSettingsBtn).doubleClick().build().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSettingsBtn);
		clickOnRefferalTemplate.get(1).click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSaveBtn);
		clickOnSaveBtn.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnCancelBtnofTemplate);
		clickOnCancelBtnofTemplate.click();

	}

	public void performTemplateOperation(boolean refferal, boolean complete, boolean direct) throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnGetAnotherTemplate);
		clickOnGetAnotherTemplate.click();

		Thread.sleep(3000);
		builder.moveToElement(selectTemplate).click();
		// for (WebElement selectTemplate : select_Template) {
//			if (selectTemplate.getText().equalsIgnoreCase("Integrity - Referral")) {
//				selectTemplate.click();
//				break;
//			}
//		}

//		if (!clickOnRefferalToTestEnv.isSelected() && refferal) {
//			clickOnRefferalToTestEnv.click();
//		}
//
//		if (!clickOnCompleteTestEnv.isSelected() && complete) {
//			clickOnCompleteTestEnv.click();
//		}

		if (!clickOnDirectTestEnv.isSelected() && direct) {
			clickOnDirectTestEnv.click();
		}

		ensureElementToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();
	}

	public void matchDataInDocumentcenter() throws Exception {

		String[] splitDate = strActualEncounterDate.split("/");

		String day = splitDate[0];
		if (day.charAt(0) == '0')
			day = day.charAt(1) + "";
		System.out.println(day);

		String dateData = day + "/" + splitDate[1] + "/" + splitDate[2];
		System.out.println(dateData);

		Thread.sleep(3000);
		clickOnDocumentCenter.click();

		Thread.sleep(2000);
		List<WebElement> select_Documents = driver
				.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase("Referrals and Followups")) {
				select_Documents.get(i).click();
				break;
			}

		Thread.sleep(3000);
		for (WebElement getElementDate : getDocumentcenterDate) {
			if (getElementDate.getText().contains(dateData)) {
				System.out.println("Date Matched");
				break;
			}
		}

	}

	// finction use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
