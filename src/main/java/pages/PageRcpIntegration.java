package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;

public class PageRcpIntegration {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String strValue;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgpatientSrch;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[5]/table/tbody/tr[6]/td[2]/a"),
			@FindBy(how = How.LINK_TEXT, using = "RCP MIPS Dashboard") })
	private WebElement clickOnRcpMipsDashBoard;

	@FindBy(how = How.XPATH, using = ".//ul[@class=\"main-menu\"]/li[2]/a/i")
	private WebElement clickOnMenuIconOfRcp;

	@FindBy(how = How.XPATH, using = "//*[@id=\"main-menu\"]/li[2]/div/ul/li/a")
	private WebElement clickOnMuMeasureReport;

	@FindBy(how = How.CSS, using = "input#USERNAME")
	private WebElement fillUserNameText;

	@FindBy(how = How.CSS, using = "input#PASSWORD")
	private WebElement fillUserPassword;

	@FindBy(how = How.CSS, using = "a.loginButton")
	private WebElement clickOnLogInBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-pdLogout>a")
	private WebElement clickOnLogOutBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-patientEducation>a")
	private WebElement clickOnPatientEducation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-education-documents-container>div")
	private List<WebElement> selectEducationDocumentsContiner;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-\"]")
	private WebElement clickOnClose;

	@FindBy(how = How.XPATH, using = ".//a[text()='Add Provider']")
	private WebElement clickOnAddProvider;

	@FindBy(how = How.XPATH, using = ".//div[text()='Internal']")
	private WebElement clickOnInternal;

	@FindBy(how = How.XPATH, using = ".//input[@id='gwt-debug-firstName']")
	private WebElement fillTheFirstName;

	@FindBy(how = How.XPATH, using = ".//a[text()='Search']")
	private WebElement clickOnSearch;

	@FindBy(how = How.XPATH, using = ".//span[text()=\"Mail\"]")
	private WebElement clickOnMail;

	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][1]/button[2]/span")
	private WebElement clickOnRefferalToTestEnv;

	@FindBy(how = How.CSS, using = "div#gwt-debug-referPatientToDoctor>div>h4>svg")
	private WebElement clickOnAddProviderTestEnv;

	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][2]/button[1]/span")
	private WebElement clickOnCompleteTestEnv;

	@FindBy(how = How.CSS, using = "#gwt-debug-notifyProviderFooter > div.overlay_footer > div.float_right > div.btn_green>a")
	private WebElement clickOnDoneButton;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-emCodes-container\"]/div[1]/span[2]")
	private WebElement selectAnyCode;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	@FindBy(how = How.XPATH, using = ".//table//tbody//tr//th//*[text()=\"Portal Access:\"]")
	private WebElement clickOnPortalAccess;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-portal-generate\"]/a")
	private WebElement clickOnGeneratePortalAccount;

	@FindBy(how = How.CSS, using = "#gwt-debug-portal-resetPassword>a")
	private WebElement clickOnResetPassword;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageRcpIntegration(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageRcpIntegration.this);
	}

	public void verifyRcpIntegration(String PMSID, String MRN, String firstName, String lastName, String date,
			String ssn, String SexcualOrientation, String GenderIdentity, String gender, String address1,
			String address2, String city, String state, String zipCode, String homePhone, String workPhone,
			String cellPhone, String ethnicity, String race, String detailedrace, String emailAddress,
			String contactMethod, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges, String documents, String name1, String name2, String name3, boolean refferal,
			boolean tranisition, String comments) throws Exception {

		strValue = new PgAutoCreatePatient(driver, wait, builder).insertPatientDetails(PMSID, MRN, firstName, lastName,
				date, ssn, SexcualOrientation, GenderIdentity, gender, address1, address2, city, state, zipCode,
				homePhone, workPhone, cellPhone, ethnicity, race, detailedrace, emailAddress, contactMethod);

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgpatientSrch = lclPgLanding.patientSearch();
		lclPgpatientSrch.searchPatient("", "", strValue, editPatient);

		new PageOpenEncounterWithNewPatient(driver, wait, builder).openEncounterForOnlyNewPatient(category,
				subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability, significantProblem);
		
		addPatientEducationDoc(documents);

		new PageRefferalAndFollowUpReport(driver, wait, builder).refferalReportForTestEnv(name1, refferal, comments);

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		selectTransitionAndMail(name2, tranisition, comments);

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		selectRefferalAndMail(name3, refferal, comments);

		Thread.sleep(5000);
		closeEncounterWithcode(visitType);

		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgpatientSrch = lclPgLanding.patientSearch();
		lclPgpatientSrch.searchPatient("", "", strValue, editPatient);

		Thread.sleep(5000);
		openPortalAccount();

		Thread.sleep(5000);
		logInFunction();
		
		Thread.sleep(5000);
		matchDataWithRCP();
	}

	private void addPatientEducationDoc(String documents) throws Exception {
		Thread.sleep(4000);
		clickOnPatientEducation.click();

		Thread.sleep(6000);

		WebElement select_EducationDocuments = driver
				.findElement(By.xpath(".//div[contains(text(),'" + documents + "')]"));
		System.out.println(select_EducationDocuments.getText());
		select_EducationDocuments.click();

		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		By clickOnportal = By.xpath(".//*[@id=\"gwt-debug-sugDoc-view\"][1]/a[text()=\"Send to Portal\"]");
		driver.findElements(clickOnportal).get(1).click();

		Thread.sleep(3000);
		clickOnClose.click();

	}

	public void selectTransitionAndMail(String name2, boolean tranisition, String comments) throws Exception {
		System.out.println(name2);
		// click On AddProvider
		Thread.sleep(9000);
		clickOnAddProvider.click();

		Thread.sleep(2000);
		clickOnAddProviderTestEnv.click();

		Thread.sleep(3000);
		clickOnInternal.click();

		Thread.sleep(1000);

		fillTheFirstName.sendKeys(name2);

		// click On search;
		Thread.sleep(3000);
		clickOnSearch.click();

		Thread.sleep(4000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		java.util.List<WebElement> providerSearch = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-providerSearchResultTable\"]/tbody/tr/td"));
		for (int i = 0; i < providerSearch.size(); i++)

			if (providerSearch.get(i).getText().equalsIgnoreCase(name2)) {
				providerSearch.get(i).click();
				break;
			}

		Thread.sleep(2000);
		if (!clickOnRefferalToTestEnv.isSelected() && tranisition) {
			clickOnRefferalToTestEnv.click();
		}

		Thread.sleep(2000);
		clickOnCompleteTestEnv.click();

		Thread.sleep(3000);
		clickOnMail.click();

		Thread.sleep(2000);

		clickOnDoneButton.click();

	}

	public void selectRefferalAndMail(String name3, boolean refferal, String comments) throws Exception {
		System.out.println(name3);
		// click On AddProvider
		Thread.sleep(9000);
		clickOnAddProvider.click();

		Thread.sleep(2000);
		clickOnAddProviderTestEnv.click();

		Thread.sleep(3000);
		clickOnInternal.click();

		Thread.sleep(1000);

		fillTheFirstName.sendKeys(name3);

		// click On search;
		Thread.sleep(3000);
		clickOnSearch.click();

		Thread.sleep(4000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		java.util.List<WebElement> providerSearch = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-providerSearchResultTable\"]/tbody/tr/td"));
		for (int i = 0; i < providerSearch.size(); i++)

			if (providerSearch.get(i).getText().equalsIgnoreCase(name3)) {
				providerSearch.get(i).click();
				break;
			}

		Thread.sleep(2000);
		if (!clickOnRefferalToTestEnv.isSelected() && refferal) {
			clickOnRefferalToTestEnv.click();
		}

		Thread.sleep(2000);
		clickOnCompleteTestEnv.click();

		Thread.sleep(3000);
		clickOnMail.click();

		Thread.sleep(2000);

		clickOnDoneButton.click();

	}

	public void closeEncounterWithcode(String visitType) throws Exception {

		Thread.sleep(3000);
		clickOnCodingTab.click();

		// click On Visit Type
		Thread.sleep(5000);
		builder.moveToElement(clickOnVistType).click().perform();

		// select_VisitType
		Thread.sleep(5000);

		int select_VisitType = driver.findElements(By.xpath(".//div[@id=\"gwt-debug-visitType-container\"]/div"))
				.size();
		System.out.println(select_VisitType);
		for (int i = 1; i <= select_VisitType; i++)
			if (driver.findElement(By.xpath(".//div[@id=\"gwt-debug-visitType-container\"]/div[" + i + "]")).getText()
					.equalsIgnoreCase(visitType)) {
				driver.findElement(By.xpath(".//div[@id=\"gwt-debug-visitType-container\"]/div[" + i + "]")).click();
				break;
			}

		Thread.sleep(3000);
		selectAnyCode.click();

		Thread.sleep(2000);
		builder.moveToElement(clickOnsubmitandclose).click().perform();

	}

	public void openPortalAccount() throws Exception {
		Thread.sleep(4000);
		String matchAccount = null;

		WebElement storeHasAccAndNoAcc = driver
				.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td/div"));

		matchAccount = storeHasAccAndNoAcc.getAttribute("innerText");
		System.out.println("print which Kind of account" + matchAccount);
		switch (matchAccount) {
		case "No Account":
			Thread.sleep(3000);
			clickOnPortalAccess.click();
			Thread.sleep(3000);
			clickOnGeneratePortalAccount.click();

			Thread.sleep(4000);
			new PageErpPatientModification(driver, wait, builder).forHandlingWindow();
			driver.close();
			Thread.sleep(3000);
			new PageErpPatientModification(driver, wait, builder).forHandlingWindow();
			break;
		case "Has Portal Account":
			Thread.sleep(3000);
			clickOnPortalAccess.click();
			Thread.sleep(2000);
			clickOnResetPassword.click();

			Thread.sleep(4000);
			new PageErpPatientModification(driver, wait, builder).forHandlingWindow();
			driver.close();
			Thread.sleep(3000);
			new PageErpPatientModification(driver, wait, builder).forHandlingWindow();
			break;

		default:
			System.out.println("Did not match No account and has portal account");
			break;

		}
	}

	public void logInFunction() throws Exception {

		Thread.sleep(7000);
		clickOnLogOutBtn.click();
		Thread.sleep(2000);
		fillUserNameText.sendKeys(ProjectSettings.userName);
		Thread.sleep(2000);
		fillUserPassword.sendKeys(ProjectSettings.password);
		Thread.sleep(3000);
		clickOnLogInBtn.click();

	}

	public void matchDataWithRCP() throws Exception {
		Thread.sleep(7000);
		clickOnRcpMipsDashBoard.click();

		Thread.sleep(2000);
		new PageErpPatientModification(driver, wait, builder).forHandlingWindow();

		try {
		Thread.sleep(7000);
		clickOnMenuIconOfRcp.click();
		}catch(Exception e) {
			Thread.sleep(7000);
			clickOnMenuIconOfRcp.click();	
		}
		
		Thread.sleep(7000);
		clickOnMuMeasureReport.click();

	}
}
