package pages;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import tests.TestErpPatientModification;

public class PageErpPatientModification {
	private WebDriver driver = null;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;

	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	public static String firstWinHandle;

	@FindBy(how = How.CSS, using = "input#gwt-debug-pmFirstName")
	private WebElement emrPatientFirstTextBox;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(1)")
	private WebElement clickbxDobMonth;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(1)>option")
	private List<WebElement> selectMonth;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(2)")
	private WebElement clickbxDobDay;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(2)>option")
	private List<WebElement> selectday;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(3)")
	private WebElement clickbxDobYear;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(3)>option")
	private List<WebElement> selectYear;

	@FindBy(how = How.CSS, using = "#gwt-debug-zipCode")
	private WebElement clickZipCode;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-patientEmail\"]")
	private WebElement emrPatientEmailBox;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-pmv-preferredmethodofcontact-button\"]/div[3]")
	private WebElement clickOnPrefferdOfContact;

	@FindBy(how = How.ID, using = "gwt-debug-pmv-preferredmethodofcontact-container")
	private WebElement select_PerreferdOfContact;

	@FindBy(how = How.XPATH, using = "//*[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Clear All Fields\"]")
	private WebElement clickOnClearAllFieldsBtn;

	@FindBy(how = How.CSS, using = "input#gwt-debug-patientFirstName")
	private WebElement filltheFirstName;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-searchButton\"]/a")
	private WebElement clickonSearchBtn;

	@FindBy(how = How.XPATH, using = "//table[@id=\"gwt-debug-searchResultTable\"]/tbody/tr/td/div")
	private WebElement containerOfPatientTable;

	@FindBy(how = How.XPATH, using = ".//table//tbody//tr//th//*[text()=\"Portal Access:\"]")
	private WebElement clickOnPortalAccess;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-portal-generate\"]/a")
	private WebElement clickOnGeneratePortalAccount;

	@FindBy(how = How.CSS, using = "#gwt-debug-portal-resetPassword>a")
	private WebElement clickOnResetPassword;

	@FindBy(how = How.CSS, using = "#Username")
	private WebElement fillErpFirstName;

	@FindBy(how = How.CSS, using = "#Password")
	private WebElement fillErpPswdName;

	@FindBy(how = How.XPATH, using = ".//button[@type=\"submit\"]")
	private WebElement clickOnLoginBtn;
	
	@FindBy(how=How.CSS,using = "button#OK")
	private WebElement clickOnAgreeBtn;

	@FindBy(how = How.CSS, using = "#DateOfBirth")
	private WebElement clickOnDateTextBox;

	@FindBy(how = How.CSS, using = "#ui-datepicker-div > div > div >select.ui-datepicker-month")
	private WebElement clickOncalenderMonthbox;

	@FindBy(how = How.CSS, using = "#ui-datepicker-div > div > div >select.ui-datepicker-month > option")
	private List<WebElement> selectCalenderMonth;

	@FindBy(how = How.CSS, using = "#ui-datepicker-div > div > div > select.ui-datepicker-year")
	private WebElement clickOncalenderYearBox;

	@FindBy(how = How.CSS, using = "#ui-datepicker-div > div > div > select.ui-datepicker-year>option")
	private List<WebElement> selectCalenderYear;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td[not(contains(@class,' ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled'))]")
	private WebElement clickOnDayBox;

	@FindBy(how = How.CSS, using = "#ZipCode")
	private WebElement fillZipCode;

	@FindBy(how = How.CSS, using = "#NewUsername")
	private WebElement fillErpUserName;

	@FindBy(how = How.CSS, using = "#NewPassword")
	private WebElement fillErpPassword;

	@FindBy(how = How.CSS, using = "#NewPasswordConfirmation")
	private WebElement fillErpConfirmPassword;

	@FindBy(how = How.CSS, using = "#OK")
	private WebElement clickOnErpOk;

	@FindBy(how = How.XPATH, using = "/html/body/p[1]")
	private WebElement getURl;

	@FindBy(how = How.XPATH, using = "/html/body/p[2]")
	private WebElement getUserNameText;

	@FindBy(how = How.XPATH, using = "/html/body/p[7]")
	private WebElement getUserPaswword;

	public PageErpPatientModification(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void modifyPatientRecord(String modifyFname, String date, String email, String methodOfContact,
			String account, String Zipcode, String newUserName, String newPswd, String ConfirmNewPswd,
			String calenderDate) throws Exception {

		// modifyFirstName
		Thread.sleep(2000);
		emrPatientFirstTextBox.clear();
		emrPatientFirstTextBox.sendKeys(modifyFname);

		Thread.sleep(2000);
		String[] strDate = date.split("-");

		Thread.sleep(2000);
		clickbxDobMonth.click();
		for (WebElement select_Month : selectMonth) {
			if (select_Month.getText().equalsIgnoreCase(strDate[0])) {
				select_Month.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickbxDobDay.click();
		Thread.sleep(2000);

		for (WebElement select_day : selectday) {
			if (select_day.getText().equalsIgnoreCase(strDate[1])) {
				select_day.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickbxDobYear.click();
		for (WebElement select_Year : selectYear) {

			if (select_Year.getText().equalsIgnoreCase(strDate[2])) {
				select_Year.click();
				break;
			}
		}
		clickZipCode.clear();
		clickZipCode.sendKeys(Zipcode);

		// enter the values in email
		Thread.sleep(2000);
		emrPatientEmailBox.clear();
		emrPatientEmailBox.sendKeys(email);

		// click perferd of contact
		// Thread.sleep(2000);
		// clickOnPrefferdOfContact.click();
		//
		// Thread.sleep(2000);
		// java.util.List<WebElement> dropDownContact =
		// select_PerreferdOfContact.findElements(By.xpath(".//*"));
		// for (int i = 0; i <= dropDownContact.size(); i++)
		// if (dropDownContact.get(i).getText().equalsIgnoreCase(methodOfContact)) {
		// dropDownContact.get(i).click();
		// break;
		//
		// }

		// click on save button
		Thread.sleep(2000);
		clickOnDoneBtn.click();
		// clear the patientSearch Field
		Thread.sleep(2000);
		clickOnClearAllFieldsBtn.click();

		// enter the firstModifyname
		Thread.sleep(2000);
		filltheFirstName.sendKeys(modifyFname);

		// click on searchBtn
		Thread.sleep(2000);
		clickonSearchBtn.click();

		Thread.sleep(3000);
		WebElement select_FirstPatient = driver.findElement(
				By.xpath("//*[@id=\"gwt-debug-searchResultTable\"]/tbody/tr/td/div[text()='" + modifyFname + "']"));
		builder.moveToElement(select_FirstPatient).click().build().perform();

		// click on has a account
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// chechk Condition
		Thread.sleep(4000);
		String matchAccount = null;
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// String script="return
		// document.evaluate('//*[@id=\"content\"]/div/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td/div').getText();";
		// matchAccount=((JavascriptExecutor)driver).executeScript(script).toString();

		WebElement storeHasAccAndNoAcc = driver
				.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td/div"));

		matchAccount = storeHasAccAndNoAcc.getAttribute("innerText");
		System.out.println("print which Kind of account" + matchAccount);
		switch (matchAccount) {
		case "No Account":
			Thread.sleep(2000);
			clickOnPortalAccess.click();

			Thread.sleep(3000);
			clickOnGeneratePortalAccount.click();
			Thread.sleep(2000);
			forHandlingWindow();
			Thread.sleep(4000);
			generatePortalAccount(modifyFname, Zipcode, newUserName, newPswd, ConfirmNewPswd, calenderDate);
			break;
		case "Has Portal Account":
			Thread.sleep(2000);
			clickOnPortalAccess.click();
			Thread.sleep(2000);
			clickOnResetPassword.click();

			Thread.sleep(4000);
			forHandlingWindow();
			Thread.sleep(4000);
			forResetPassword();
			break;

		default:
			System.out.println("Did not match No account and has portal account");
			break;
		}

		// Set handles = driver.getWindowHandles();
		// firstWinHandle = driver.getWindowHandle();
		// handles.remove(firstWinHandle);
		// String winHandle = (String) handles.iterator().next();
		//
		// if (winHandle != firstWinHandle) {
		//
		// // To retrieve the handle of second window, extracting the handle which
		// doesnot
		// // match to first window handle
		//
		// String secondWinHandle = winHandle;
		// // Storing handle of second window handle
		//
		// // Switch control to new window
		//
		// driver.switchTo().window(firstWinHandle);
		// }

	}

	public void generatePortalAccount(String modifyFname, String Zipcode, String newUserName, String newPswd,
			String ConfirmNewPswd, String calenderDate) throws Exception {
		//driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		Thread.sleep(8000);
		ensureElementToBeClickable(getUserNameText);
		String storeUserName = getUserNameText.getText();
		StringBuffer userName = new StringBuffer();
		StringBuffer strUserName = userName.append(storeUserName);
		strUserName.delete(0, 10);
		storeUserName = strUserName.toString();
		System.out.println(storeUserName);

		//driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		Thread.sleep(5000);
		ensureElementToBeClickable(getUserPaswword);
		String storePassword = getUserPaswword.getText();
		StringBuffer password = new StringBuffer();
		StringBuffer strPassword = password.append(storePassword);
		strPassword.delete(0, 10);
		storePassword = strPassword.toString();
		System.out.println(storePassword);

		// open the ERP Url
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String storeURL = getURl.getText();
		driver.get(storeURL.substring(8));

		// enter the userName
		Thread.sleep(5000);
		fillErpFirstName.sendKeys(storeUserName);

		// enter the password
		Thread.sleep(5000);
		fillErpPswdName.sendKeys(storePassword);

		// click on log on button
		Thread.sleep(3000);
		clickOnLoginBtn.submit();
		
		Thread.sleep(3000);
		clickOnAgreeBtn.click();

		// click on calenderText
		Thread.sleep(3000);
		clickOnDateTextBox.click();

		// Select month from calender
		Thread.sleep(5000);
		String[] strCalenderDate = calenderDate.split("-");

		Thread.sleep(3000);

		clickOncalenderMonthbox.click();

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_calendermonth : selectCalenderMonth) {
			if (select_calendermonth.getText().equalsIgnoreCase(strCalenderDate[0])) {
				select_calendermonth.click();
				break;

			}

		}

		// select year from calenderYear

		Thread.sleep(3000);
		clickOncalenderYearBox.click();

		Thread.sleep(3000);
		for (WebElement select_CalenderYear : selectCalenderYear) {
			if (select_CalenderYear.getText().equalsIgnoreCase(strCalenderDate[2])) {
				select_CalenderYear.click();
				break;

			}
		}
		// click on date
		Thread.sleep(5000);
		// for (WebElement select_Date : clickOnDayBox.findElements(By.xpath(".//*"))) {
		// if (select_Date.getText().equalsIgnoreCase(calenderDate)) {
		// select_Date.click();
		// break;
		// }
		// }

		List<WebElement> select_DateFromErp = driver.findElements(By.xpath(
				".//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td[not(contains(@class,' ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled'))]"));
		for (WebElement select_Date : select_DateFromErp) {
			if (select_Date.getText().equalsIgnoreCase(strCalenderDate[1])) {
				select_Date.click();
				break;
			}
		}
		// zipcode of patient
		Thread.sleep(2000);
		fillZipCode.sendKeys(Zipcode);

		// fillUserfirstname
		Thread.sleep(2000);
		fillErpUserName.sendKeys(newUserName.concat(modifyFname));
		System.out.println(newUserName.concat(modifyFname));
		// fillUserPswd
		Thread.sleep(2000);
		fillErpPassword.sendKeys(newPswd);

		// filluserConfirmPswd
		Thread.sleep(3000);
		fillErpConfirmPassword.sendKeys(ConfirmNewPswd);

		// click on OkBtn
		Thread.sleep(2000);
		clickOnErpOk.click();

	}

	public void forResetPassword() throws Exception {
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String storeUserName = getUserNameText.getText();
		StringBuffer userName = new StringBuffer();
		StringBuffer strUserName = userName.append(storeUserName);
		strUserName.delete(0, 10);
		storeUserName = strUserName.toString();
		System.out.println(storeUserName);

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String storePassword = getUserPaswword.getText();
		StringBuffer password = new StringBuffer();
		StringBuffer strPassword = password.append(storePassword);
		strPassword.delete(0, 10);
		storePassword = strPassword.toString();
		System.out.println(storePassword);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String storeURL = getURl.getText();

		driver.get(storeURL.substring(8));

		// enter the userName
		Thread.sleep(5000);
		fillErpFirstName.sendKeys(storeUserName);

		// enter the password
		Thread.sleep(5000);
		fillErpPswdName.sendKeys(storePassword);

		// click on log on button
		Thread.sleep(3000);
		clickOnLoginBtn.submit();

	}

	public void forHandlingWindow() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
