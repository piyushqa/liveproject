package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ProjectSettings;

public class PageReconFin {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[4]/div[1]/table/tbody/tr[1]/td[1]/a")
	private WebElement clickOnUserMgt;

	@FindBy(how = How.LINK_TEXT, using = "File Transfer Recon Dashboard")
	private WebElement clickOnReconDashBoard;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"root\"]/select")
	private WebElement selectIntegritySettings;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/section/div[24]/input")
	private WebElement getValueOfReconClinicNoteOnSubmitToSupervision;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/section/div[26]/input")
	private WebElement getValueOfReconInternalMailId;

	@FindBy(how = How.CSS, using = "div#gwt-debug-userdash-logout>a")
	private WebElement clickOnLogOut;

	@FindBy(how = How.CSS, using = "input#USERNAME")
	private WebElement fillUserNameText;

	@FindBy(how = How.CSS, using = "input#PASSWORD")
	private WebElement fillUserPassword;

	@FindBy(how = How.CSS, using = "a.loginButton")
	private WebElement clickOnLogInBtn;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.CSS, using = "#gwt-debug-saveButton > a")
	private WebElement clickOnsaveBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[3]/div[2]/div/div[1]/div/div[3]")
	private WebElement slectValue;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div>div:nth-child(2)>div")
	private List<WebElement> select_SuperVisorValue;

	@FindBy(how = How.CSS, using = "div#gwt-debug-submit_to_supervisor>a")
	private WebElement clickOnsubmitToSuperVisor;
	
	@FindBy(how=How.CSS,using = "div#gwt-debug-overlay_content>div>div:nth-child(2)>div>textarea")
	private WebElement fillTheValueInText;
	
	@FindBy(how=How.XPATH,using = "//a[@id=\"gwt-debug-ok\" or text()=\"Continue\"]")
	private WebElement clickOnContinueBtn;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageReconFin(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageReconFin.this);
	}

	public void verifyRecoNFin(String providerName, String providerPswd, boolean mustHaveSuperVising,
			boolean superVisingDocterCanCloseEncounter, String fName, String lName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			boolean significantProblem, String visitType, boolean noCharges,String superVisingProvider) throws Exception {

		handleIntegritySettings();

		Thread.sleep(4000);
		String reconClinicNoteOnSubmitToSupervisorValue = new PageASCIntegration(wait, driver, builder).performASCSettingIntegrationOpertion("reconClinicNoteOnSubmitToSupervisor");
		System.out.println(reconClinicNoteOnSubmitToSupervisorValue);

		Thread.sleep(4000);
		String reconInternalidEnabledValue = new PageASCIntegration(wait, driver, builder).performASCSettingIntegrationOpertion("reconInternalidEnabled");
		System.out.println(reconInternalidEnabledValue);

		
		
		if (reconClinicNoteOnSubmitToSupervisorValue.equalsIgnoreCase("false") && reconInternalidEnabledValue.equalsIgnoreCase("true")) {

			Thread.sleep(5000);
			driver.navigate().back();

			ensureElementToBeClickable(clickOnUserMgt);
			clickOnUserMgt.click();

			Thread.sleep(3000);
			new PageResidentWorkflow(driver, wait, builder).editProvider(providerName);

			new PageResidentWorkflow(driver, wait, builder).performSuperVisingOperation(mustHaveSuperVising,
					superVisingDocterCanCloseEncounter);

			Thread.sleep(2000);
			ensureElementToBeClickable(clickOnsaveBtn);
			clickOnsaveBtn.click();

			logInFunction(providerName, providerPswd);

		}

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);
		
		performCloseEncounter(superVisingProvider);

	}

	public void handleIntegritySettings() throws Exception {
		Thread.sleep(3000);
		String storeUrl = driver.getCurrentUrl();
		 
		int v=storeUrl.indexOf(".com/");
		String val=storeUrl.substring(0,v+5);
		String newUrl=val.concat("settings/");
		System.out.println(newUrl);
		driver.get(newUrl);
		
		new PageReconDashBoard(driver, wait, builder).handleWindow();

		Thread.sleep(3000);
		Select select_IntegritySettings = new Select(selectIntegritySettings);
		select_IntegritySettings.selectByVisibleText("practice");
	}

	public void logInFunction(String providerName, String providerPswd) throws Exception {
		Thread.sleep(3000);
		clickOnLogOut.click();
		Thread.sleep(3000);
		fillUserNameText.sendKeys(providerName);
		fillUserPassword.sendKeys(providerPswd);
		clickOnLogInBtn.click();
	}

	public void performCloseEncounter(String superVisingProvider) throws Exception {
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnCodingTab);
		clickOnCodingTab.click();

		Thread.sleep(3000);
		slectValue.click();

		Thread.sleep(5000);
		for (WebElement select_Supervisor : select_SuperVisorValue) {
			if (select_Supervisor.getText().equalsIgnoreCase(superVisingProvider)) {
				select_Supervisor.click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnsubmitToSuperVisor);
		builder.moveToElement(clickOnsubmitToSuperVisor).click().perform();
		
		Thread.sleep(3000);
		ensureElementToBeClickable(fillTheValueInText);
		fillTheValueInText.sendKeys("12ddd");
		
		ensureElementToBeClickable(clickOnContinueBtn);
		clickOnContinueBtn.click();
	}

	// finction use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
