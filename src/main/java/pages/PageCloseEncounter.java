package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ProjectSettings;

public class PageCloseEncounter {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	// Define Locater
	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok.gwt-Anchor")
	private WebElement clickOnYesButton;

	@FindBy(how = How.CLASS_NAME, using = "encounter_tab_bar_container")
	private WebElement encounterTabBarContainer;

	@FindBy(how = How.ID, using = "gwt-debug-addNewProblem")
	private WebElement clickOnAddNewProblem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]")
	private WebElement clickOnSignficantProblem;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-icd10popup--done\"]/a")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.ID, using = "gwt-debug-addNewPlan")
	private WebElement clickOnAddNewPlan;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div")
	private List<WebElement> categoryContainer;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div")
	private List<WebElement> subCategoryContainer1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div")
	private List<WebElement> subCategoryContainer2;

	@FindBy(how = How.ID, using = "gwt-debug-libraryText")
	private WebElement fillSendKeys;
	
	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[3]/div[2]/div/div[1]/div/div[3]")
	private WebElement slectValue;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div/div[2]/div")
	private List<WebElement> select_SuperVisorValue;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div")
	private List<WebElement> select_category;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div")
	private List<WebElement> select_category2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div")
	private List<WebElement> select_category3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div")
	private List<WebElement> select_eye;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div")
	private List<WebElement> select_severity;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div")
	private List<WebElement> select_stability;

	public PageCloseEncounter(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageCloseEncounter.this);
	}

	// function for verifyCloseEncounter
	public void verifyCloseEncounter(String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String planLiberay, String subPlanLiberay, String visitType, Boolean noCharges)
			throws Exception {

		// function is used for open encounter
		Thread.sleep(2000);
		openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				significantProblem);

		// click On AddNew Plan
		Thread.sleep(6000);
		ensureElememtToBeClickable(clickOnAddNewPlan);
		clickOnAddNewPlan.click();

		// select_PlanLiberay
		Thread.sleep(8000);
		By LiberaryPlanContainer = By.xpath(".//*[@id=\"gwt-debug-selectCategory-list\"]/div/div");
		List<WebElement> select_PlanLiberay = driver.findElements(LiberaryPlanContainer);
		// ensureElementsToBeClickable(select_PlanLiberay);
		try {
			for (int i = 1; i <= select_PlanLiberay.size(); i++)
				if (select_PlanLiberay.get(i).getText().equalsIgnoreCase(planLiberay)) {
					select_PlanLiberay.get(i).click();
					break;
				}
		} catch (TimeoutException e) {
			System.out.println(e.getMessage());
		}

		// sub PlanLiberary Container
		Thread.sleep(8000);
		By subPlanLiberaryContainer = By.xpath(".//*[@id=\"gwt-debug-selectItem-list\"]/div/div");
		List<WebElement> select_SubPlanLiberaryContainer = driver.findElements(subPlanLiberaryContainer);
		// ensureElementsToBeClickable(select_SubPlanLiberaryContainer);
		try {
			for (int i = 1; i <= select_SubPlanLiberaryContainer.size(); i++)
				if (select_SubPlanLiberaryContainer.get(i).getText().equalsIgnoreCase(subPlanLiberay)) {
					select_SubPlanLiberaryContainer.get(i).click();
					break;
				}
		} catch (TimeoutException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}

		Thread.sleep(2000);
		ensureElememtToBeClickable(fillSendKeys);
		builder.moveToElement(fillSendKeys).sendKeys("Add New Plan").perform();

		// click On Done Plan Liberary
		By clickOnDonePlanLiberary = By.xpath("//*[@id=\"gwt-debug-done\"]/a");
		driver.findElements(clickOnDonePlanLiberary).get(0).click();

		// function for close encounter
		Thread.sleep(2000);
		closeEncounter(visitType, noCharges);

	}

	// fuction is used for open encounter and add problem
	public void openEncounterWithProblem(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem) throws Exception {

		// open encounter
		Thread.sleep(7000);
		ensureElememtToBeClickable(clickOnOpenEncounter);
		clickOnOpenEncounter.click();

		// click On Yes button
		Thread.sleep(8000);
		ensureElememtToBeClickable(clickOnYesButton);
		builder.moveToElement(clickOnYesButton).click().perform();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", clickOnYesButton);

		// select Imp and plan
		Thread.sleep(6000);
		for (WebElement select_EncounterTab : encounterTabBarContainer.findElements(By.xpath(".//*"))) {
			if (select_EncounterTab.getText().equalsIgnoreCase("Imp & Plan")) {
				select_EncounterTab.click();
				break;
			}
		}
		// click on add new problem
		Thread.sleep(9000);
		ensureElememtToBeClickable(clickOnAddNewProblem);
		builder.moveToElement(clickOnAddNewProblem).click().perform();

		// select_category Container
		Thread.sleep(7000);

		for (WebElement select_categoryContainer : select_category) {
			if (select_categoryContainer.getText().equalsIgnoreCase(category)) {
				select_categoryContainer.click();
				break;
			}
		}

		// select_SubCategory Container1
		Thread.sleep(5000);
		for (WebElement select_SubCategoryContainer1 : select_category2) {
			if (select_SubCategoryContainer1.getText().equalsIgnoreCase(subCategory1)) {
				select_SubCategoryContainer1.click();
				break;
			}
		}

		// select_subCategory Container2
		Thread.sleep(5000);

		for (WebElement select_subCategoryContainer2 : select_category3) {
			if (select_subCategoryContainer2.getText().equalsIgnoreCase(subCategory2)) {
				select_subCategoryContainer2.click();
				break;
			}
		}

		// select_Eye
		Thread.sleep(5000);

		for (WebElement select_Eye : select_eye) {
			if (select_Eye.getText().equalsIgnoreCase(eye)) {
				select_Eye.click();
				break;
			}
		}
		// select_galuocmaSeverity Container

		Thread.sleep(5000);
		for (WebElement select_galuocmaSeverityContainer : select_severity) {
			if (select_galuocmaSeverityContainer.getText().equalsIgnoreCase(galuocmaSeverity)) {
				select_galuocmaSeverityContainer.click();
				break;
			}
		}
		// select_galuocma Stability
		Thread.sleep(5000);
		for (WebElement select_galuocmaStability : select_stability) {
			if (select_galuocmaStability.getText().equalsIgnoreCase(galuocmaStability)) {
				select_galuocmaStability.click();
				break;
			}
		}

		// click On Signficant Problem
		if (!clickOnSignficantProblem.isSelected() && significantProblem) {
			clickOnSignficantProblem.click();
		}

		// click On Done Btn of add new problem
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnDoneBtn);
		builder.moveToElement(clickOnDoneBtn).click().perform();
	}

	// function is used for closed Encounter
	public void closeEncounter(String visitType, Boolean noCharges) throws Exception {
		// click On Coding Tab
		Thread.sleep(3000);
		clickOnCodingTab.click();

		// click On Visit Type
		Thread.sleep(5000);
		ensureElememtToBeClickable(clickOnVistType);
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


		// script used only for dev-------------------------------------
//		Thread.sleep(3000);
//		slectValue.click();
//
//		Thread.sleep(5000);
//		for (WebElement select_Supervisor : select_SuperVisorValue) {
//			if (select_Supervisor.getText().equalsIgnoreCase("Tom Crow, M.D.")) {
//				select_Supervisor.click();
//				break;
//			}
//		}

		// ----------------------------------

		// click On submit and close
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnsubmitandclose);
		builder.moveToElement(clickOnsubmitandclose).click().perform();

	}

	// function foer webElement
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// function for List<WebElement>
	public void ensureElementsToBeClickable(List<WebElement> elements) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}
}
