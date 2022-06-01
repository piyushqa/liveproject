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

public class PageImportEncounter {

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

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	public PageImportEncounter(WebDriver driver, WebDriverWait wait, Actions builder) {

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
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		clickOnJoinEncounter.click();

		// click on Provider
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 0; i < select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;

			}

		// Thread.sleep(5000);
		// clickOnJoinEncounter.click();
		// int select_RowFromOpenEncounter = driver
		// .findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		// System.out.println(select_RowFromOpenEncounter);
		// Thread.sleep(8000);
		// if (select_RowFromOpenEncounter > 0) {
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
		// // Thread.sleep(5000);
		// else if (select_RowFromOpenEncounter <= 0) {
		// Thread.sleep(7000);
		// clickStartNewEncounter.click();
		//
		//
		// }
		//

		// click on Imp And plan
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickOnImpAndPlan.click();

		// Click On addNewProblem
		wait = new WebDriverWait(driver, 20);
		clickOnAddNewProblem.click();

		// select category Glaucoma
		Thread.sleep(2000);
		java.util.List<WebElement> gulcomaCategoryClick = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaCategoryClick.size(); i++)
			if (gulcomaCategoryClick.get(i).getText().equalsIgnoreCase(category)) {
				gulcomaCategoryClick.get(i).click();
				break;
			}

		// select subCategory Glaucoma with Other Disorders
		Thread.sleep(2000);
		java.util.List<WebElement> gulcomaSubCategoryClick = driver.findElements(
				By.xpath("//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategoryClick.size(); i++)
			if (gulcomaSubCategoryClick.get(i).getText().equalsIgnoreCase(subCategory)) {
				gulcomaSubCategoryClick.get(i).click();
				break;

			}

		// select subCategory1 Glaucoma
		Thread.sleep(2000);
		java.util.List<WebElement> gulcomaSubCategory1Click = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategory1Click.size(); i++)
			if (gulcomaSubCategory1Click.get(i).getText().equalsIgnoreCase(subCategory1)) {
				gulcomaSubCategory1Click.get(i).click();
				break;

			}

		// select Glaucoma Eye
		Thread.sleep(2000);
		java.util.List<WebElement> gulcomaEyeClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaEyeClick.size(); i++)
			if (gulcomaEyeClick.get(i).getText().equalsIgnoreCase(eye)) {
				gulcomaEyeClick.get(i).click();
				break;

			}

		// select Glaucoma Severity
		Thread.sleep(2000);
		java.util.List<WebElement> gulcomaSeverityClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaSeverityClick.size(); i++)
			if (gulcomaSeverityClick.get(i).getText().equalsIgnoreCase(glaucomaSeverity)) {
				gulcomaSeverityClick.get(i).click();
				break;

			}

		// select Glaucoma Stability
		Thread.sleep(2000);
		java.util.List<WebElement> gulcomaStabilityClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div"));
		for (int i = 0; i < gulcomaStabilityClick.size(); i++)
			if (gulcomaStabilityClick.get(i).getText().equalsIgnoreCase(glaucomaStability)) {
				gulcomaStabilityClick.get(i).click();
				break;

			}

		// Click on Done Button
		Thread.sleep(3000);
		doneBtn.click();

		// click on vision
		Thread.sleep(4000);
		clickOnVision.click();

		// call addNewExistingglass from PgEncounter class
		encounterOnGlass = new PgEncounter(driver, wait, builder);

		encounterOnGlass.addNewExistingglass(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender,
				osAxis, osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate,
				odNear, osNear, OdComment, osComment);

		// click on codingTab
		Thread.sleep(6000);
		ensureElementToBeClickable(clickOnCodingTab);
		clickOnCodingTab.click();

		// click on visitType
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		clickOnVisitType.click();

		// click on select visitType
		Thread.sleep(6000);
		java.util.List<WebElement> select_visitType = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-visitType-container\"]/div"));
		for (int i = 0; i < select_visitType.size(); i++)
			if (select_visitType.get(i).getText().equalsIgnoreCase(visitType)) {
				select_visitType.get(i).click();
				break;

			}

		// click on Nocharges
		Thread.sleep(4000);
		if (!clickOnNoCharges.isSelected() && nocharges) {
			clickOnNoCharges.click();
		}

		// clickOnSubmitAndClose
		Thread.sleep(5000);
		clickOnSubmitAndClose.click();

		// select Patient
		//
		//
		// java.util.List<WebElement> select_patientType = driver.findElements(
		// By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[1]/div/table/tbody/tr/td/div"));
		// for (int i = 0; i < select_patientType.size(); i++)
		// if (select_patientType.get(i).getText().equalsIgnoreCase(patientName)) {
		// select_patientType.get(i).click();
		// break;
		//
		// }
		Thread.sleep(15000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lclPgLanding = new PgLanding(driver);
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		// click on JoinEncounter

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickStartNewEncounter.click();

//		Thread.sleep(5000);
//		wait=new WebDriverWait(driver, 30);
//		clickOnOkBtn.click();


		// click on vision tab
		Thread.sleep(4000);
		clickOnVision.click();

		// click on import
		Thread.sleep(10000);
		clickOnImport.click();

		// select import
		Thread.sleep(18000);
		wait = new WebDriverWait(driver, 20);
		List<WebElement> select_ImportProvider = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div/div[1]/div/div[1]/div/div/div/a"));
		for (int i = 0; i < select_ImportProvider.size(); i++) {
			if (select_ImportProvider.get(i).getText().equalsIgnoreCase(import1)) {
				select_ImportProvider.get(i).click();
				break;
			}
		}
		// F
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}