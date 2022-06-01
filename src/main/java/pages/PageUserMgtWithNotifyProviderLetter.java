package pages;

import java.util.List;

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

public class PageUserMgtWithNotifyProviderLetter {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	boolean checkValue;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSrch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[4]/div[1]/table/tbody/tr[1]/td[1]/a")
	private WebElement clickOnUserMgt;

	@FindAll({
			@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-userDetailsPanel\"]/div/div[4]/div[3]/span/input"),
			@FindBy(how = How.XPATH, using = ".//label[text()=\"Can Edit Notify Provider Letter Templates\"]") })
	private WebElement clickOnNotifyProviderTemplate;

	@FindBy(how = How.CSS, using = "#gwt-debug-saveButton > a")
	private WebElement clickOnsaveBtn;

	@FindBy(how = How.LINK_TEXT, using = "Configuration")
	private WebElement clickOnConfigurationLink;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	private List<WebElement> selectNotifyProvider;

	@FindBy(how = How.XPATH, using = ".//button[@class=\"configurableTemplateBtn configurableTemplateBtn-border\" and text()=\"Template\"]")
	private WebElement clickOnTemplateButton;

	@FindBy(how = How.CSS, using = "aside#sidebar>div:nth-child(2)>ul>li>span>span")
	private List<WebElement> selectTemplate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/div/ul/li/span/input")
	private WebElement fillValueInTemplate;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li:nth-child(1)>a")
	private WebElement clickOnPatientLink;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li>div>ul>li>a")
	private List<WebElement> selectPatientSearch;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul")
	private WebElement scorllSideBar;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li:nth-child(2)>a")
	private WebElement clickOnProviderLink;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li:nth-child(3)>a")
	private WebElement clickOnEncounterLink;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li:nth-child(4)>a")
	private WebElement clickOnVisionLink;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li:nth-child(5)>a")
	private WebElement clickOnTechExamLink;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li:nth-child(6)>a")
	private WebElement clickOnExamLink;

	@FindBy(how = How.CSS, using = ".sidebar-right>div>ul>li:nth-child(7)>a")
	private WebElement clickOnImpAndPlanLink;

	@FindBy(how = How.XPATH, using = ".//button[text()=\"Save\"]")
	private WebElement clickOnSaveBtnOfNPLT;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.CSS, using = "a#gwt-debug-notifyProviderAnchor")
	private WebElement clickOnAddProviderBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-referPatientToDoctor>div>h4>svg")
	private WebElement clickOnAddProviderTestEnv;

	@FindBy(how = How.XPATH, using = ".//div[text()='Internal']")
	private WebElement clickOnInternal;

	@FindBy(how = How.XPATH, using = ".//input[@id='gwt-debug-firstName']")
	private WebElement fillTheFirstName;

	@FindBy(how = How.XPATH, using = ".//a[text()='Search']")
	private WebElement clickOnSearch;

	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'Get another template')]")
	private WebElement clickOnGetAnotherTemplate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[12]/div/div[2]/div[2]/div/div/div[1]/div/div/div/button")
	private List<WebElement> select_Template;

	// =========================================================================================================================
	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][1]/button[2]/span")
	private WebElement clickOnRefferalToTestEnv;

	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][2]/button[1]/span")
	private WebElement clickOnCompleteTestEnv;

	@FindBy(how = How.XPATH, using = ".//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][3]/button[1]/span")
	private WebElement clickOnDirectTestEnv;

	@FindBy(how = How.CSS, using = "#gwt-debug-notifyProviderFooter > div.overlay_footer > div.float_right > div.btn_green>a")
	private WebElement clickOnDoneButton;
	
	@FindBy(how=How.CSS,using="div#gwt-debug-documentCenter")
	private WebElement clickOnDocumentCenter;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageUserMgtWithNotifyProviderLetter(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageUserMgtWithNotifyProviderLetter.this);
	}

	public void verifyUserMgtWithNotifyProviderLetter(String providerName, boolean notifyProviderTemplate,
			String patientLink, String providerLink, String encounterLink, String visionLink, String techExamLink,
			String examLink, String impAndPlanLink, String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			boolean significantProblem, String visitType, boolean noCharges, String name, boolean refferal,
			boolean complete, boolean direct) throws Exception {

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnUserMgt);
		clickOnUserMgt.click();

		Thread.sleep(2000);
		new PageResidentWorkflow(driver, wait, builder).editProvider(providerName);

		performNotifyProviderOperation(notifyProviderTemplate);

		Thread.sleep(3000);
		clickOnConfigurationLink.click();

		matchNotifyTemplateOnConfiguration();

		createTemplateInNotifyProvider();

		variableSearchOperation(patientLink, providerLink, encounterLink, visionLink, techExamLink, examLink,
				impAndPlanLink);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSrch = lclPgLanding.patientSearch();
		lclPgPatientSrch.searchPatient(fName, lName, "", editPatient);

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnAddProviderBtn);
		clickOnAddProviderBtn.click();

		performRefferalReportOperation(name);
		
		performTemplateOperation(refferal, complete, direct);
		
		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
		
		editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSrch = lclPgLanding.patientSearch();
		lclPgPatientSrch.searchPatient(fName, lName, "", editPatient);
		
		performDocumentCenterOperation();
	}

	public boolean performNotifyProviderOperation(boolean notifyProviderTemplate) throws Exception {
		checkValue = clickOnNotifyProviderTemplate.isSelected();
		if (checkValue == false) {
			Thread.sleep(3000);
			if (!clickOnNotifyProviderTemplate.isSelected() && notifyProviderTemplate) {
				clickOnNotifyProviderTemplate.click();
			}
		} else {
			clickOnNotifyProviderTemplate.click();
			Thread.sleep(3000);
			clickOnNotifyProviderTemplate.click();
		}

		Thread.sleep(3000);
		clickOnsaveBtn.click();

		return checkValue;
	}

	public void matchNotifyTemplateOnConfiguration() throws Exception {
		System.out.println(checkValue);
		Thread.sleep(3000);
		if (checkValue) {
			for (WebElement select_NotifyProvider : selectNotifyProvider) {
				if (select_NotifyProvider.getText().equalsIgnoreCase("Notify Provider Letter Templates")) {
					select_NotifyProvider.click();
					System.out.println("NotifyProvider Template Display");
					break;
				}
			}

		} else {
			System.out.println("Notifyprovider Template Not Display");
		}
	}

	// function used for create template
	public void createTemplateInNotifyProvider() throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnTemplateButton);
		clickOnTemplateButton.click();

		try {
			Thread.sleep(8000);

			for (WebElement select_Template : selectTemplate) {
				if (select_Template.getAttribute("innerHTML").startsWith("Template-")) {
					// if(value==true){

					// builder.moveToElement(fillValueInTemplate).perform();
					Thread.sleep(2000);
					fillValueInTemplate.clear();
					Thread.sleep(2000);
					fillValueInTemplate.sendKeys("NPL-Template");
					break;
				}

			}

		} catch (Exception ex) {
			System.out.println("Not Found Locater");
		}
	}

	public void variableSearchOperation(String patientLink, String providerLink, String encounterLink,
			String visionLink, String techExamLink, String examLink, String impAndPlanLink) throws Exception {
		ensureElementToBeClickable(clickOnPatientLink);
		clickOnPatientLink.click();

		Thread.sleep(3000);
		selectVariableSearch(patientLink);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scorllSideBar);

		ensureElementToBeClickable(clickOnProviderLink);
		clickOnProviderLink.click();

		Thread.sleep(3000);
		selectVariableSearch(providerLink);

		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scorllSideBar);

		ensureElementToBeClickable(clickOnEncounterLink);
		clickOnEncounterLink.click();

		selectVariableSearch(encounterLink);

		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scorllSideBar);

		ensureElementToBeClickable(clickOnVisionLink);
		clickOnVisionLink.click();

		selectVariableSearch(visionLink);

		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scorllSideBar);

		ensureElementToBeClickable(clickOnTechExamLink);
		clickOnTechExamLink.click();

		selectVariableSearch(techExamLink);

		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scorllSideBar);

		ensureElementToBeClickable(clickOnExamLink);
		clickOnExamLink.click();

		selectVariableSearch(examLink);

		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scorllSideBar);

		ensureElementToBeClickable(clickOnImpAndPlanLink);
		clickOnImpAndPlanLink.click();

		selectVariableSearch(impAndPlanLink);

		ensureElementToBeClickable(clickOnSaveBtnOfNPLT);
		clickOnSaveBtnOfNPLT.click();

		ensureElementToBeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();
	}

	public void selectVariableSearch(String value) throws Exception {
		Thread.sleep(3000);
		for (WebElement select_PatientLink : selectPatientSearch) {
			if (select_PatientLink.getText().equalsIgnoreCase(value)) {
				builder.moveToElement(select_PatientLink).perform();
				builder.moveToElement(select_PatientLink).doubleClick().perform();
				break;
			}
		}
	}

	public void performRefferalReportOperation(String name) throws Exception {

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

	public void performTemplateOperation(boolean refferal, boolean complete, boolean direct) throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnGetAnotherTemplate);
		clickOnGetAnotherTemplate.click();

		Thread.sleep(3000);
		for (WebElement selectTemplate : select_Template) {
			if (selectTemplate.getText().equalsIgnoreCase("Ankit")) {
				selectTemplate.click();
				break;
			}
		}

		if (!clickOnRefferalToTestEnv.isSelected() && refferal) {
			clickOnRefferalToTestEnv.click();
		}

		if (!clickOnCompleteTestEnv.isSelected() && complete) {
			clickOnCompleteTestEnv.click();
		}

		if (!clickOnDirectTestEnv.isSelected() && direct) {
			clickOnDirectTestEnv.click();
		}

		ensureElementToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();
	}
	
	public void performDocumentCenterOperation()throws Exception{
		Thread.sleep(3000);
		clickOnDocumentCenter.click();
		
		// select_Documents
				Thread.sleep(2000);
				List<WebElement> select_Documents = driver
						.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
				for (int i = 1; i <= select_Documents.size(); i++)
					if (select_Documents.get(i).getText().equalsIgnoreCase("Referrals and Followups")) {
						select_Documents.get(i).click();
						break;
					}
	}

	// function use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
