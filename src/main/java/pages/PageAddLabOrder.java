package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageAddLabOrder {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// declare Locater
	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget>a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[9]/div")
	private WebElement clickOnImpandPlan;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-addNewPlan\" and text()='Add New Plan']")
	private WebElement clickOnAddNewPlan;

	@FindBy(xpath = ".//*[@class=\"gwt-TabBarItem\"]//div[text()='Order Lab Tests']")
	private WebElement clickOnLabOrdertest;

	@FindBy(xpath = ".//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div")
	private WebElement getSelectLabTest;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td")
	private List<WebElement> selectLabTest;

	@FindBy(xpath = ".//textarea[@id=\"gwt-debug-orderComments\"]")
	private WebElement fillComments;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-thisClinicNoteLink\" and text()='This Clinic Note']")
	private WebElement clickOnClinicNote;

	public PageAddLabOrder(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;

		PageFactory.initElements(driver, PageAddLabOrder.this);
	}

	public void verifyAddLabOrder(String provider, String selectlabTest, String comments,
			String associatesLabWithProblem, String designateTime, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges) throws Exception

	{
		Thread.sleep(7000);

		// invoke pageCloseEncounter class for open encounter
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		// call lab order method
		LabOrderTask(selectlabTest, comments, associatesLabWithProblem, designateTime, visitType, noCharges);

		 //close encounter
		 new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType,
		 noCharges);

	}

	public void LabOrderTask(String selectlabTest, String comments, String associatesLabWithProblem,
			String designateTime,String visitType, Boolean noCharges) throws Exception {
		Thread.sleep(6000);
		clickOnAddNewPlan.click();

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnLabOrdertest));
		clickOnLabOrdertest.click();

		int l = driver.findElements(By.xpath(".//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div"))
				.size();
		System.out.println("Length" + l);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		try {

			WebElement select_LabTest = driver
					.findElement(By.xpath(".//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div[text()="
							+ "\"" + selectlabTest + "\"" + "]"));

			wait.until(ExpectedConditions.elementToBeClickable(select_LabTest));
			wait.until(ExpectedConditions.visibilityOf(select_LabTest));

			builder = new Actions(driver);
			builder.moveToElement(select_LabTest).click().perform();
		} catch (Exception e) {
			e.getMessage();
		}

		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(fillComments)).sendKeys(comments);

		By clickOnProblem = By.xpath("//*[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr[1]/td/div[text()=" + "\""
				+ associatesLabWithProblem + "\"" + "]");
		driver.findElements(clickOnProblem).get(0).click();

		By selectdesignateTime = By.xpath("//*[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr[2]/td/div[text()="
				+ "\"" + designateTime + "\"" + "]");
		driver.findElements(selectdesignateTime).get(0).click();

		Thread.sleep(8000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement clickOnDone = driver.findElement(By.cssSelector("a#gwt-debug-Done.gwt-Anchor"));

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By clickOnDone1 = By.cssSelector("a#gwt-debug-Done.gwt-Anchor");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		Thread.sleep(6000);

		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElements(clickOnDone1).get(2).click();

//		Thread.sleep(5000);
//		String getElementOfLabTest = driver.findElement(By.xpath(".//div[text()='" + selectlabTest + "']")).getText();
//		System.out.println(getElementOfLabTest);
//
//		if (selectlabTest.equalsIgnoreCase(getElementOfLabTest.substring(0, 2))) {
//			new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
//		}

	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void ensureElementBeClickable(By element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
