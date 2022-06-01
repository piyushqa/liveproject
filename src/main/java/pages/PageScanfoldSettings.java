package pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class PageScanfoldSettings {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatietSearch;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"root\"]/select")
	private WebElement selectIntegritySettings;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/section/div[19]/input")
	private WebElement fillValueInReconText;

	@FindBy(how = How.CSS, using = "input#USERNAME")
	private WebElement fillUserNameText;

	@FindBy(how = How.CSS, using = "input#PASSWORD")
	private WebElement fillUserPassword;

	@FindBy(how = How.CSS, using = "a.loginButton")
	private WebElement clickOnLogInBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-userdash-logout>a")
	private WebElement clickOnLogOutBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/section/div[15]/input")
	private WebElement fillValueInLogOutText;

	@FindBy(how = How.CSS, using = "div#gwt-debug-logoutandhold>a")
	private WebElement MatchLogOutAndHold;

	@FindBy(how = How.CSS, using = "a#gwt-debug-pdReturnToUserDashboard")
	private WebElement clickOnMyDashBoard;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"File Transfer Recon Dashboard\"]")
	private WebElement clickOnFileTransferReconDashBoard;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageScanfoldSettings(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageScanfoldSettings.this);
	}

	public void verifyScanfoldSettings(String fName, String lName) throws Exception {

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		driver.get("https://sandbox-prod.integritylogin.com/settings/");

		// perform recon operation
		performReconSettingOperation();

		// perform logOut and Hold operation
		performLogOutAndHoldSettingOperation(fName, lName);

		// perform
	}

	public void performReconSettingOperation() throws Exception {

		handleWindow();
		Thread.sleep(3000);

		Select select_IntegritySettings = new Select(selectIntegritySettings);
		select_IntegritySettings.selectByVisibleText("practice");

		Thread.sleep(4000);
		ensureElememtToBeClickable(fillValueInReconText);
		String reconValue = fillValueInReconText.getAttribute("value");
		fillValueInReconText.clear();
		if (reconValue.equalsIgnoreCase("true")) {
			fillValueInReconText.sendKeys("true");
		} else {
			fillValueInReconText.sendKeys("true");
		}

		logInFunction();

		matchReconDashBoard();

	}

	public void performLogOutAndHoldSettingOperation(String fName, String lName) throws Exception {

		driver.get("https://test.integritylogin.com/settings/");
		handleWindow();
		Select select_IntegritySettings = new Select(selectIntegritySettings);
		select_IntegritySettings.selectByVisibleText("practice");
		Thread.sleep(4000);
		ensureElememtToBeClickable(fillValueInLogOutText);
		String reconValue = fillValueInLogOutText.getAttribute("value");
		fillValueInLogOutText.clear();
		if (reconValue.equalsIgnoreCase("true")) {
			fillValueInLogOutText.sendKeys("false");
		} else {
			fillValueInLogOutText.sendKeys("true");
		}

		logInFunction();

		matchLogOutAndHoldBtn(fName, lName);
	}

	public void logInFunction() throws Exception {
		Thread.sleep(5000);
		driver.navigate().back();
		clickOnLogOutBtn.click();
		fillUserNameText.sendKeys(ProjectSettings.userName);
		fillUserPassword.sendKeys(ProjectSettings.password);
		clickOnLogInBtn.click();

	}

	public void matchReconDashBoard() throws Exception {
		Thread.sleep(3000);
		boolean check = clickOnFileTransferReconDashBoard.isEnabled();
		try {
			if (check) {
				boolean clickAbleOrNot = isClickable(clickOnFileTransferReconDashBoard);
				// System.out.println("File transfer is clickable"+" "+ clickAbleOrNot);
			}

		} catch (Exception e) {
			System.out.println("File transfer recon is  not clickable");
		}
	}

	public boolean isClickable(WebElement element) {

		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void matchLogOutAndHoldBtn(String fName, String lName) throws Exception {
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatietSearch = lclPgLanding.patientSearch();
		lclPgPatietSearch.searchPatient(fName, lName, "", editPatient);
		boolean check = MatchLogOutAndHold.isEnabled();
		System.out.println("Log Out and Hold btn is" + " " + check);
		try {
			if (check) {
				Thread.sleep(4000);
				MatchLogOutAndHold.click();
				System.out.println("Log Out and hold place btn gets displayed");
			}
		} catch (Exception e) {

			clickOnMyDashBoard.click();
			System.out.println("Log Out and hold place btn does not display");
		}
	}

	public void handleWindow() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

	}

	// fuction is used for visibility and clickAble of elements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
