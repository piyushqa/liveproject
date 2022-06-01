package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;

public class PageLogOutAndHold {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	boolean check;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;

	@FindBy(how = How.CSS, using = "a#gwt-debug-medsAndAllergies")
	private WebElement clickOnMedsAndAllergies;

	@FindBy(how = How.CSS, using = "a#gwt-debug-socialFamilyHistory")
	private WebElement clickOnSocialFamilyHistory;

	@FindBy(how = How.CSS, using = "a#gwt-debug-glaucomaSummary")
	private WebElement clickOnGlaucomaSummary;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private WebElement clickOnClose;

	@FindBy(how = How.CSS, using = "a#gwt-debug-visionSummary")
	private WebElement clickOnVisionSummary;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-integriView\"]")
	private WebElement clickOnIntegriview;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Close IntegriView\"]")
	private WebElement clickOnCloseIntegriview;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Log out & Hold Place\"]")
	private WebElement clickOnHoldAndWait;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Log Out & Hold Place\"]")
	private WebElement clickOnHoldAndWaitUserDashBoard;

	@FindBy(how = How.CSS, using = "a#loginWithHeld.loginWithHeldButton")
	private WebElement clickOnLoginWithHeldBtn;

	@FindBy(how = How.CSS, using = "input#USERNAME")
	private WebElement inputUsername;

	@FindBy(how = How.CSS, using = "input#PASSWORD")
	private WebElement inputPassword;

	@FindBy(how = How.CSS, using = "#gwt-debug-supplementalExams-button>div:nth-child(3)")
	private WebElement clickOnSurgeryAndProcedureDropDown;

	@FindBy(how = How.CSS, using = "#gwt-debug-supplementalExams-container>div")
	private List<WebElement> selectScheduledSurgery;

	@FindAll({ @FindBy(how = How.CSS, using = "div#gwt-debug-logoutandhold>a"),
			@FindBy(how = How.XPATH, using = ".//a[text()=\"Log Out & Hold Place\"]") })
	private WebElement selectLogOutAndHoldGonioscopy;

	@FindBy(how = How.CSS, using = "a#gwt-debug-cancelButton.gwt-Anchor")
	private WebElement clickOnCancelBtnOfGonioscopy;

	@FindAll({ @FindBy(how = How.CSS, using = "div#gwt-debug-logoutandhold>a"),
			@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Log Out & Hold Place')]") })
	private WebElement selectLogOutAndHoldSensorimotor;

	@FindBy(how = How.CSS, using = "div#gwt-debug-sensorimotor-cancel>a")
	private WebElement clickOnCancelBtnOfSensorimotor;

	@FindBy(how = How.ID, using = "gwt-debug-returnToUserDashboard")
	private WebElement clickOnMydashBoard;
	
	@FindBy(how=How.CSS,using="table#gwt-debug-encounterTabBar>tbody>tr>td:nth-child(8)>div")
	private WebElement clickOnExam;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Configure Session Timeout')]")
	private WebElement clickOnSessionTimeOut;

	@FindBy(how = How.ID, using = "gwt-debug-logoutHoldInactivityPeriod")
	private WebElement fillLogOutAndHoldTextBox;

	@FindBy(how = How.CSS, using = "a#gwt-debug-saveAnchor.gwt-Anchor")
	private WebElement clickOnSaveBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-userdash-logout>a")
	private WebElement clickOnLogOut;

	@FindBy(how = How.CSS, using = "a.loginButton")
	private WebElement clickOnLoginBtn;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageLogOutAndHold(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageLogOutAndHold.this);
	}

	public void verfiyPageLogOutAndHold(String provider, String text1, String text2, String text3, String fName,
			String lName) throws Exception {
		medAndAllergie(text1);

		socialFamilyHistory(text2);

		glaucomasummary();

		visionSummary();

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		// Integriview(text3);

		Thread.sleep(3000);
		clickOnHoldAndWaitUserDashBoard.click();

		Thread.sleep(2000);
		reaginLogin();

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);
		
		Thread.sleep(3000);
		clickOnExam.click();
		
		testGonioscopyExam();

		testSeniosorometer();

		Thread.sleep(3000);
		clickOnMydashBoard.click();

		sessionTimeOut();

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		Thread.sleep(3000);
		clickOnHoldAndWaitUserDashBoard.click();
		
		//logOutAndHoldAfterSetiingsSessions();

	}

	public void medAndAllergie(String text1) throws Exception {
		Thread.sleep(5000);
		String storeAllergie = clickOnMedsAndAllergies.getText();
		if (storeAllergie.equalsIgnoreCase(text1)) {
			Thread.sleep(2000);
			clickOnMedsAndAllergies.click();
			checkLogOutHoldBtnEnabled();
		} else {
			System.out.println("Logout Hold Button Not Appaer");
			Reporter.log("Logout Hold Button Not Appaer");
		}
	}

	public void socialFamilyHistory(String text2) throws Exception {
		Thread.sleep(5000);
		String storeAllergie = clickOnSocialFamilyHistory.getText();
		if (storeAllergie.equalsIgnoreCase(text2)) {
			Thread.sleep(2000);
			clickOnSocialFamilyHistory.click();
			checkLogOutHoldBtnEnabled();
		} else {
			System.out.println("Logout Hold Button Not Appaer");
			Reporter.log("Logout Hold Button Not Appaer");
		}
	}

	public void glaucomasummary() throws Exception {
		String glaucomasummary = "Glaucoma Summary";
		Thread.sleep(5000);
		String storeAllergie = clickOnGlaucomaSummary.getText();
		if (storeAllergie.equalsIgnoreCase(glaucomasummary)) {
			Thread.sleep(2000);
			clickOnGlaucomaSummary.click();
			checkLogOutHoldBtnEnabled();
			Thread.sleep(3000);
			clickOnClose.click();
		} else {
			System.out.println("Logout Hold Button Not Appaer");
			Reporter.log("Logout Hold Button Not Appaer");
		}
	}

	public void visionSummary() throws Exception {
		String visionSummary = "Vision Summary";
		Thread.sleep(5000);
		String storeAllergie = clickOnVisionSummary.getText();
		if (storeAllergie.equalsIgnoreCase(visionSummary)) {
			Thread.sleep(2000);
			clickOnVisionSummary.click();
			checkLogOutHoldBtnEnabled();
			Thread.sleep(3000);
			clickOnClose.click();
		} else {
			System.out.println("Logout Hold Button Not Appaer");
			Reporter.log("Logout Hold Button Not Appaer");
		}
	}

	public void Integriview(String text3) throws Exception {
		text3 = "IntegriView ";
		Thread.sleep(9000);
		String storeAllergie = clickOnIntegriview.getText();
		if (storeAllergie.startsWith(text3)) {
			Thread.sleep(4000);
			clickOnIntegriview.click();
			checkLogOutHoldBtnEnabledOfIntegriview();
			Thread.sleep(4000);
			clickOnCloseIntegriview.click();
		} else {
			System.out.println("Logout Hold Button Not Appaer");
			Reporter.log("Logout Hold Button Not Appaer");
		}
	}

	public void reaginLogin() throws Exception {
		Thread.sleep(3000);
		inputUsername.sendKeys(ProjectSettings.userName);

		Thread.sleep(2000);
		inputPassword.sendKeys(ProjectSettings.password);

		Thread.sleep(2000);
		clickOnLoginWithHeldBtn.click();

	}

	public void checkLogOutHoldBtnEnabled() throws Exception {
		Thread.sleep(4000);
		ensureElememtToBeClickable(clickOnHoldAndWaitUserDashBoard);
		check = clickOnHoldAndWaitUserDashBoard.isDisplayed();
		System.out.println("Hold and wait button appaer" + check);
	}

	public void checkLogOutHoldBtnEnabledOfIntegriview() throws Exception {
		Thread.sleep(4000);
		ensureElememtToBeClickable(clickOnHoldAndWait);
		check = clickOnHoldAndWait.isDisplayed();
		System.out.println("Hold and wait button appaer" + check);
	}

	public void testGonioscopyExam() throws Exception {
		String strSurgeryAndProcedure = "Gonioscopy Exam";
		selectModule(strSurgeryAndProcedure);
		boolean checkCondition = isPresentAndClickAble(selectLogOutAndHoldGonioscopy);
		System.out.println("Check Condition of Gonioscopy" + " " + checkCondition);
		if (checkCondition == true) {
			clickOnCancelBtnOfGonioscopy.click();
		}
	}

	public void testSeniosorometer() throws Exception {
		String strSurgeryAndProcedure = "Sensorimotor Exam";
		selectModule(strSurgeryAndProcedure);
		boolean checkCondition = isPresentAndClickAble(selectLogOutAndHoldSensorimotor);
		System.out.println("Check Condition of Seniosormeter" + " " + checkCondition);
		if (checkCondition == true) {
			clickOnCancelBtnOfSensorimotor.click();
		}
	}

	public void selectModule(String strSurgeryAndProcedure) throws Exception {
		Thread.sleep(2000);
		Thread.sleep(2000);
		clickOnSurgeryAndProcedureDropDown.click();

		for (WebElement select_ScheduledSurgery : selectScheduledSurgery) {
			if (select_ScheduledSurgery.getText().equalsIgnoreCase(strSurgeryAndProcedure)) {
				select_ScheduledSurgery.click();
				break;
			}
		}
	}

	public boolean isPresentAndClickAble(WebElement element) throws Exception {
		try {
			element.isDisplayed();
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("element click");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public void sessionTimeOut() throws Exception {
		clickOnSessionTimeOut.click();

		Thread.sleep(3000);
		fillLogOutAndHoldTextBox.clear();
		Thread.sleep(2000);
		fillLogOutAndHoldTextBox.sendKeys("1");

		Thread.sleep(3000);
		clickOnSaveBtn.click();

		Thread.sleep(3000);
		clickOnLogOut.click();

		Thread.sleep(3000);
		inputUsername.sendKeys(ProjectSettings.userName);

		Thread.sleep(2000);
		inputPassword.sendKeys(ProjectSettings.password);

		Thread.sleep(2000);
		clickOnLoginBtn.click();
	}

	public void logOutAndHoldAfterSetiingsSessions() throws Exception {
		Thread.sleep(62 * 1000);
		boolean checkLogOutAndHold = isPresentAndClickAble(clickOnLoginWithHeldBtn);
		try {
			if (checkLogOutAndHold == true) {
				clickOnLoginWithHeldBtn.click();
				System.out.println("Log Out and Held button is display");
			}
		} catch (Exception e) {

			System.out.println("Log Out and Held button is not display");

		}
	}

	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
