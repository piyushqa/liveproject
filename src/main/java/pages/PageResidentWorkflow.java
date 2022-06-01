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
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PageResidentWorkflow {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPglanding;
	PgPatientSearch lclPgPatientSrch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[4]/div[1]/table/tbody/tr[1]/td[1]/a")
	private WebElement clickOnUserMgt;

	@FindBy(how = How.CSS, using = "a#gwt-debug-addNewUserLinkAnchor.gwt-Anchor")
	private WebElement clickOnAddNewUser;

	@FindBy(how = How.XPATH, using = ".//span/label[text()=\"Must Have Supervising Doctor?\"]")
	private List<WebElement> clickOnMustHaveSupervisingDoctor1;

	@FindBy(how = How.XPATH, using = ".//span/label[text()=\"Must Have Supervising Doctor?\"]")
	private WebElement clickOnMustHaveSupervisingDoctor;

	@FindBy(how = How.XPATH, using = ".//span/label[text()=\"Only Supervising Doctor Can Close Encounters\"]")
	private List<WebElement> clickOnOnlySupervisingDoctorCanCloseEncounters1;

	@FindBy(how = How.XPATH, using = ".//span/label[text()=\"Only Supervising Doctor Can Close Encounters\"]")
	private WebElement clickOnOnlySupervisingDoctorCanCloseEncounters;

	@FindBy(how = How.CSS, using = "#gwt-debug-saveButton > a")
	private WebElement clickOnsaveBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-userdash-logout>a")
	private WebElement clickOnLogOut;

	@FindBy(how = How.CSS, using = "input#USERNAME")
	private WebElement inputUserName;

	@FindBy(how = How.CSS, using = "input#PASSWORD")
	private WebElement inputPassword;

	@FindBy(how = How.CSS, using = "a.loginButton")
	private WebElement clickOnLoginBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[3]/div[2]/div/div[1]/div/div[3]")
	private WebElement clickOnSupervising;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-PopupPanel\"]/div/div/div/div[2]/div")
	private List<WebElement> selectSuperVising;

	@FindBy(how = How.CSS, using = "div#gwt-debug-submit_to_supervisor>a")
	private WebElement clickOnsupervisior;

	@FindBy(how = How.CSS, using = "table#gwt-debug-encounterTabBar>tbody>tr>td:nth-child(10)>div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.LINK_TEXT, using = "Tasks")
	private WebElement clickOnTask;

	@FindBy(how = How.CSS, using = "div#gwt-debug-submit_and_close>a")
	private WebElement clickOnSubmitAndCloseBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-priorClinicVisits-container>table>tbody>tr>td>span")
	private List<WebElement> selectReports;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Clinic Note\"]")
	private WebElement clickOnClinicNote;
	
	@FindBy(how=How.XPATH,using=".//span[@class=\"gwt-CheckBox gwt-CheckBox-disabled\"]/input")
	private WebElement getProviderSign;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageResidentWorkflow(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageResidentWorkflow.this);
	}

	public void verifyResidentWorkflow(String providerName, String providerPswd, Boolean mustHaveSuperVising,
			Boolean superVisingDocterCanCloseEncounter, String fName, String lName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges) throws Exception {
		String provider = "ankitTest107 provider01";

		// Thread.sleep(3000);
		ensureElementToBeClickable(clickOnUserMgt);
		clickOnUserMgt.click();

		editProvider(providerName);

		performSuperVisingOperation(mustHaveSuperVising, superVisingDocterCanCloseEncounter);

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnsaveBtn);
		clickOnsaveBtn.click();

		logOutAndLogin(providerName, providerPswd);

		Thread.sleep(2000);
		boolean editPatient = false;
		lclPglanding = new PgLanding(driver);
		lclPgPatientSrch = lclPglanding.patientSearch();
		lclPgPatientSrch.searchPatient(fName, lName, "", editPatient);

		PageCloseEncounter encounter = new PageCloseEncounter(wait, driver, builder);
		encounter.openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, significantProblem);

		closeEncounter(visitType, noCharges);

		addSuperVising();

		logOutAndLogin("dec18provider01150", "Apple@123");

		openTaskAndMatchPatient(fName, lName, provider);

		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		editPatient = false;
		lclPglanding = new PgLanding(driver);
		lclPgPatientSrch = lclPglanding.patientSearch();
		lclPgPatientSrch.searchPatient(fName, lName, "", editPatient);

		Thread.sleep(3000);
		for (WebElement select_Reports : selectReports) {
			if (select_Reports.getText().equalsIgnoreCase("Reports")) {
				select_Reports.click();
				break;
			}
		}

		Thread.sleep(3000);
		clickOnClinicNote.click();
		
		matchClinicNotaData();
	}

	public void editProvider(String providerName) throws Exception {
		WebElement getProviderText = driver.findElement(By.xpath(".//div[contains(text(),'" + providerName + "')]"));
		//System.out.println(getProviderText);
		getProviderText.click();

	}

	public void performSuperVisingOperation(Boolean mustHaveSuperVising, Boolean superVisingDocterCanCloseEncounter)
			throws Exception {

		Thread.sleep(6000);
		boolean checkValue = clickOnMustHaveSupervisingDoctor.isSelected();
		if (checkValue != false) {
			ensureElementToBeClickable(clickOnMustHaveSupervisingDoctor);
			if (!clickOnMustHaveSupervisingDoctor.isSelected() && mustHaveSuperVising) {
				clickOnMustHaveSupervisingDoctor.click();
			}
		}
		 else {
			//clickOnMustHaveSupervisingDoctor1.get(0).click();
			 clickOnMustHaveSupervisingDoctor.click();
			 Thread.sleep(3000);
			 clickOnMustHaveSupervisingDoctor.click();
		}
		
		checkValue = clickOnOnlySupervisingDoctorCanCloseEncounters.isSelected();
		if (checkValue != false) {
			Thread.sleep(2000);
			ensureElementToBeClickable(clickOnOnlySupervisingDoctorCanCloseEncounters);
			if (!clickOnOnlySupervisingDoctorCanCloseEncounters.isSelected() && superVisingDocterCanCloseEncounter) {
				builder.moveToElement(clickOnOnlySupervisingDoctorCanCloseEncounters).click();
			}
		}
		 else {
			//clickOnOnlySupervisingDoctorCanCloseEncounters1.get(1).click();
			 Thread.sleep(3000);
			 clickOnOnlySupervisingDoctorCanCloseEncounters.click();
			 Thread.sleep(3000);
			// clickOnOnlySupervisingDoctorCanCloseEncounters.click();
		}
	}

	public void logOutAndLogin(String providerName, String providerPswd) throws Exception {

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnLogOut);
		clickOnLogOut.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(inputUserName);
		inputUserName.sendKeys(providerName);

		Thread.sleep(1000);
		ensureElementToBeClickable(inputPassword);
		inputPassword.sendKeys(providerPswd);

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLoginBtn);
		clickOnLoginBtn.click();
	}

	public void addSuperVising() throws Exception {

		Thread.sleep(5000);
		builder.moveToElement(clickOnSupervising).click().build().perform();

		Thread.sleep(3000);
		for (WebElement select_Supervisior : selectSuperVising) {
			if (select_Supervisior.getText().equalsIgnoreCase("Geetha provider1, D.O.")) {
				select_Supervisior.click();
				break;
			}
		}

		Thread.sleep(3000);
		clickOnsupervisior.click();
	}

	public void closeEncounter(String visitType, Boolean noCharges) throws Exception {
		// click On Coding Tab
		Thread.sleep(3000);
		clickOnCodingTab.click();

		// click On Visit Type
		Thread.sleep(5000);
		// ensureElememtToBeClickable(clickOnVistType);
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

		// clickOnNoCharges
		Thread.sleep(4000);
		if (!clickOnNoCharges.isSelected() && noCharges) {
			builder.moveToElement(clickOnNoCharges).click().perform();
		}

	}

	public void openTaskAndMatchPatient(String fName, String lName, String provider) throws Exception {
		Thread.sleep(5000);
		clickOnTask.click();
		Thread.sleep(5000);
		String fullName = fName + " " + lName;
		WebElement clickOnPatientTask = driver.findElement(
				By.xpath("//*[@id=\"gwt-debug-contentPanel\"]/div[3]/div/div[4]/div/table/tbody/tr/td[4]/div[text()='"
						+ fullName + "']"));
		clickOnPatientTask.click();

		Thread.sleep(3000);
		WebElement clickOnPatient = driver
				.findElement(By.xpath(".//div[@id=\"gwt-debug-patientName\" and text()='" + fullName + "']"));
		clickOnPatient.click();

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnCodingTab);
		clickOnCodingTab.click();

		Thread.sleep(4000);
		clickOnSubmitAndCloseBtn.click();
		
	
	}

	public void matchClinicNotaData() throws Exception {
		Thread.sleep(5000);
		boolean getSignature=getProviderSign.isEnabled();
		Thread.sleep(2000);
		Assert.assertEquals(getSignature, false);{
			Reporter.log("Provider sign Matched");
			System.out.println("Provider sign Matched");
		}
	}

	// finction use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
