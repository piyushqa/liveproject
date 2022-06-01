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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageOpenPortalAccountWithAddReprestative {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	String strMrn = null;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgpatientSrch;
	String matchAccount = null;

	// @FindBy(how = How.XPATH, using =
	// "//*[@id=\"content\"]/div/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td/div")
	// private WebElement storeHasAccAndNoAcc;

	@FindBy(how = How.XPATH, using = ".//table//tbody//tr//th//*[text()=\"Portal Access:\"]")
	private WebElement clickOnPortalAccess;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-portal-generate\"]/a")
	private WebElement clickOnGeneratePortalAccount;

	@FindBy(how = How.CSS, using = "#gwt-debug-portal-resetPassword>a")
	private WebElement clickOnResetPassword;

	@FindBy(how = How.XPATH, using = "//*[@id=\"navbar-container\"]/div[2]/ul/li[2]/a/span")
	private WebElement clickOnLogOffTag;

	@FindBy(how = How.XPATH, using = "//*[@id=\"navbar-container\"]/div[2]/ul/li[2]/ul/li[2]/a")
	private WebElement clickOnLogOffBtn;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-portal-addRep\"]/a[text()=\"Add Representative\"]")
	private WebElement clickOnAddRepresentative;

	@FindBy(how = How.CSS, using = "input#gwt-debug-authRep-name")
	private WebElement fillFirstName;

	@FindBy(how = How.CSS, using = "input#gwt-debug-authRep-phone")
	private WebElement fillPhoneNumber;

	@FindBy(how = How.CSS, using = "input#gwt-debug-authRep-email")
	private WebElement fillEmail;

	@FindBy(how = How.CSS, using = "div#gwt-debug-patient-relationship-button>div:nth-child(3)")
	private WebElement clickRelationshipToPatient;

	@FindBy(how = How.CSS, using = "div#gwt-debug-patient-relationship-container>div")
	private List<WebElement> selectRelationshipToPatient;

	@FindBy(how = How.CSS, using = "div#gwt-debug-authRep-done>a")
	private WebElement clickOnDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-portal-representatives-container>div")
	private List<WebElement> selectAuthrosiedRepresentative;

	public PageOpenPortalAccountWithAddReprestative(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageOpenPortalAccountWithAddReprestative.this);
	}

	public void verifyOpenPortalAccountWithAddReprestative(String enviorment, String PMSID, String MRN,
			String firstName, String lastName, String date, String ssn, String SexcualOrientation,
			String GenderIdentity, String gender, String Address1, String Address2, String City, String State,
			String ZipCode, String HomePhone, String WorkPhone, String cellPhone, String Ethnicity, String Race,
			String Detailedrace, String EmailAddress, String ContactMethod, String Zipcode, String newUserName,
			String newPswd, String ConfirmNewPswd, String calenderDate, String addRepName, String phoneNumber,
			String relationShipToPatient) throws Exception {

		// invoke method for autoCreate patient with in encounter
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		strMrn = new PgAutoCreatePatient(driver, wait, builder).insertPatientDetails(PMSID, MRN, firstName, lastName,
				date, ssn, SexcualOrientation, GenderIdentity, gender, Address1, Address2, City, State, ZipCode,
				HomePhone, WorkPhone, cellPhone, Ethnicity, Race, Detailedrace, EmailAddress, ContactMethod);

		// Thread.sleep(3000);
		searchPatient();

//		Thread.sleep(3000);
//		new PageOpenPortalAccountWithAddReprestative(driver, wait, builder)
//				.matchPortalAccountAndGenerateOrResetPassword(Zipcode, newUserName, newPswd, ConfirmNewPswd,
//						calenderDate, addRepName, phoneNumber, EmailAddress, relationShipToPatient);
	}

	public void searchPatient() throws Exception {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgpatientSrch = lclPgLanding.patientSearch();
		lclPgpatientSrch.searchPatient("", "", strMrn, editPatient);

	}

	public void addRepresentative(String addRepName, String phoneNumber, String EmailAddress,
			String relationShipToPatient) throws Exception {

		ensureElementToBeClickable(clickOnAddRepresentative);
		clickOnAddRepresentative.click();

		ensureElementToBeClickable(fillFirstName);
		fillFirstName.sendKeys(addRepName);

		ensureElementToBeClickable(fillPhoneNumber);
		fillPhoneNumber.sendKeys(phoneNumber);

		ensureElementToBeClickable(fillEmail);
		fillEmail.sendKeys(EmailAddress);

		ensureElementToBeClickable(clickRelationshipToPatient);
		clickRelationshipToPatient.click();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_RelationShipToPatient : selectRelationshipToPatient) {
			if (select_RelationShipToPatient.getText().equalsIgnoreCase(relationShipToPatient)) {
				select_RelationShipToPatient.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();

		for (WebElement select_AuthrosiedRepresentative : selectAuthrosiedRepresentative) {
			if (select_AuthrosiedRepresentative.getText().startsWith(relationShipToPatient)) {
				select_AuthrosiedRepresentative.click();
				break;
			}
		}
	}

	private void matchPortalAccountAndGenerateOrResetPassword(String Zipcode, String newUserName, String newPswd,
			String ConfirmNewPswd, String calenderDate, String addRepName, String phoneNumber, String EmailAddress,
			String relationShipToPatient) throws Exception {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// chechk Condition
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
			Thread.sleep(2000);
			new PageErpPatientModification(driver, wait, builder).forHandlingWindow();
			Thread.sleep(5000);
			new PageErpPatientModification(driver, wait, builder).generatePortalAccount(addRepName, Zipcode,
					newUserName, newPswd, ConfirmNewPswd, calenderDate);
			logOffERP();
			new PageErpPatientModification(driver, wait, builder).forHandlingWindow();

		case "Has Portal Account":
			Thread.sleep(3000);
			clickOnPortalAccess.click();
			driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
			addRepresentative(addRepName, phoneNumber, EmailAddress, relationShipToPatient);
			Thread.sleep(2000);
			clickOnResetPassword.click();
			Thread.sleep(4000);
			new PageErpPatientModification(driver, wait, builder).forHandlingWindow();
			Thread.sleep(4000);
			new PageErpPatientModification(driver, wait, builder).forResetPassword();
			break;

		default:
			System.out.println("Did not match No account and has portal account");
			break;

		}
	}

	private void logOffERP() throws Exception {
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLogOffTag);
		clickOnLogOffTag.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLogOffBtn);
		clickOnLogOffBtn.click();

		driver.close();
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
