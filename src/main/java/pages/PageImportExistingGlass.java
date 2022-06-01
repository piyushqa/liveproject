package pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
import pages.PgEncounter;

public class PageImportExistingGlass {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	public String getData;
	PgEncounter encounterOnGlass = null;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;

	PgPatientSearch patientsearch;

	// declare Locater
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickOnJoinEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(xpath = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[9]/div")
	private WebElement clickOnImpAndPlan;

	@FindBy(how = How.XPATH, using = ".//div[text()='Add New Problem']")
	private WebElement clickOnAddNewProblem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-icd10popup--done\"]/a")
	private WebElement doneBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVision;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-addNew\"]")
	private WebElement clickOnAddNew;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVisitType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-noCharge\"]")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-submit_and_close\"]/a")
	private WebElement clickOnSubmitAndClose;

	@FindBy(how = How.XPATH, using = ".//span[@id='gwt-debug-glasses-importOld']")
	private WebElement clickOnImport;

	// @FindBy(how=How.XPATH,using="//*[@id=\"gwt-debug-overlay_content\"]/div/div/div[1]/div/div[1]/div[2]/div/div/a")
	// private WebElement clickOnImport;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[5]/span")
	private WebElement getDeleteExistingGlass;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()='Yes']")
	private WebElement clickOnYesButton;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	public PageImportExistingGlass(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void importExistingGlass(String provider, String category, String subCategory, String subCategory1,
			String eye, String glaucomaSeverity, String glaucomaStability, String dominantEye, String distance,
			String near, String od, String odSphere, String odCyliender, String odAxis, String odAdd, String os,
			String osSphere, String osCyliender, String osAxis, String osAdd, String prism, String prism1,
			String prism2, String prism3, String odDistance, String osDistance, String odIntermediate,
			String osIntermediate, String odNear, String osNear, String OdComment, String osComment, String visitType,
			Boolean nocharges, String import1, String fName, String lName) throws Exception {

		// click on JoinEncounter
		// Thread.sleep(6000);
		// wait = new WebDriverWait(driver, 20);
		// clickOnJoinEncounter.click();
		//
		// // click on Provider
		// Thread.sleep(7000);
		// wait = new WebDriverWait(driver, 20);
		// List<WebElement> select_Provider = driver
		// .findElements(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		// for (int i = 0; i < select_Provider.size(); i++)
		// if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
		// select_Provider.get(i).click();
		// break;
		//
		// }

		Thread.sleep(9000);
		clickOnJoinEncounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(8000);

		// Select_Provider
		Thread.sleep(5000);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;
			}

		// call addNewExistingglass from PgEncounter class
		// encounterOnGlass = new PgEncounter(driver, wait, builder);
		//
		// encounterOnGlass.addNewExistingglass(od, odSphere, odCyliender, odAxis,
		// odAdd, os, osSphere, osCyliender,
		// osAxis, osAdd, prism, prism1, prism2, prism3, odDistance, osDistance,
		// odIntermediate, osIntermediate,
		// odNear, osNear, OdComment, osComment);
		//
		// // click on codingTab
		// Thread.sleep(6000);
		// wait=new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		// wait.until(ExpectedConditions.elementToBeClickable(clickOnCodingTab));
		// clickOnCodingTab.click();
		//
		// // click on visitType
		// Thread.sleep(4000);
		// wait = new WebDriverWait(driver, 20);
		// clickOnVisitType.click();
		//
		// // click on select visitType
		// Thread.sleep(6000);
		// java.util.List<WebElement> select_visitType = driver
		// .findElements(By.xpath("//*[@id=\"gwt-debug-visitType-container\"]/div"));
		// for (int i = 0; i < select_visitType.size(); i++)
		// if (select_visitType.get(i).getText().equalsIgnoreCase(visitType)) {
		// select_visitType.get(i).click();
		// break;
		//
		// }
		//
		// // click on Nocharges
		// Thread.sleep(4000);
		// if (!clickOnNoCharges.isSelected() && nocharges) {
		// clickOnNoCharges.click();
		// }
		//
		// // clickOnSubmitAndClose
		// Thread.sleep(5000);
		// clickOnSubmitAndClose.click();
		//
		// Thread.sleep(10000);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// lclPgLanding = new PgLanding(driver);
		// boolean editPatient = false;
		// lclPgPatientSearch = lclPgLanding.patientSearch();
		// lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		//
		// Thread.sleep(5000);
		// clickOnJoinEncounter.click();
		// int select_RowFromOpenEncounter1 = driver
		// .findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		// System.out.println(select_RowFromOpenEncounter1);
		// Thread.sleep(8000);
		// if (select_RowFromOpenEncounter1 > 0) {
		//
		// // Select_Provider
		// Thread.sleep(5000);
		// List<WebElement> select_Provider = driver
		// .findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		// for (int i = 1; i <= select_Provider.size(); i++)
		// if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
		// select_Provider.get(i).click();
		// break;
		// }
		// }
		// // click on vision tab
		Thread.sleep(5000);
		clickOnVision.click();

		// click on import
		Thread.sleep(15000);
		clickOnImport.click();

		// select import
		Thread.sleep(30000);
		wait = new WebDriverWait(driver, 20);
		List<WebElement> select_ImportData = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div/div[1]/div/div[1]/div/div/div/a"));
		for (WebElement selectImportData:select_ImportData) {
			if (selectImportData.getText().equalsIgnoreCase(import1)) {
				selectImportData.click();
				break;
			}
		}
		Thread.sleep(8000);
		String strDelete = "Delete";
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(getDeleteExistingGlass));
		String getValueOfdelete = getDeleteExistingGlass.getText();
		if (strDelete.equalsIgnoreCase(getValueOfdelete)) {
			wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(getDeleteExistingGlass)).click();
			wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(clickOnYesButton)).click();

		}

	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}