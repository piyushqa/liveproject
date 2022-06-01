package pages;

import static org.testng.Assert.assertEquals;

import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EmptyFileException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PageSendingPatientEduaction {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	// define Locater

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget>a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()=\"Yes\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"encounter_tab_bar_container\"]/table/tbody/tr/td[9]/div")
	private WebElement clickOnImpAndPlan;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-patientEducation\"]/a[text()='Patient Education']")
	private WebElement clickOnPatientEducation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-suggestedDocs-container>div:nth-child(1)")
	private WebElement clickOnDoc;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-\"]")
	private WebElement clickOnClose;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickOnTheClinicNote;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-headingPanel\"]/div/a")
	private WebElement clickOnCancelBtn;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	// @FindBy(xpath = "//*[@id=\"report\"]/div[29]/div[2]")
	// private WebElement editPdf;

	// @FindBy(xpath = ".//div[text()='The patient is given the patient education
	// document: \"Eye Diseases\", via Patient Portal.']")
	// private WebElement editPdf;

	@FindBy(xpath = "//*[@id=\"gwt-debug-overlay_content\"]/table/tbody/tr[2]/td/div/div")
	private WebElement clickOnElement;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-overlay_body\"]")
	private WebElement clickOnText;

	public PageSendingPatientEduaction(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void verifyPatientEducation(String provider, String suggestedDoc, String actualText, String visitType,
			Boolean noCharges, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem)
			throws Exception, IOException {

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		// Thread.sleep(2000);
		// wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOf(clickOnImpAndPlan)).click();

		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickOnPatientEducation)).click();

		// select suggested documents

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		List<WebElement> select_Documents = driver
				.findElements(By.cssSelector("#gwt-debug-suggestedDocs-container>div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase(suggestedDoc)) {
				select_Documents.get(i).click();
				break;
			}
		//clickOnDoc.click();

		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		By clickOnportal = By.xpath(".//*[@id=\"gwt-debug-sugDoc-view\"][1]/a[text()=\"Send to Portal\"]");
		driver.findElements(clickOnportal).get(0).click();

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickOnClose)).click();

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickOnTheClinicNote)).click();
		Thread.sleep(5000);

		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		WebElement editPdf = driver.findElement(By.xpath(".//div[text()='" + actualText + "']" + "[1]" + ""));

		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		String strText = editPdf.getText();
		assertEquals(strText, actualText);
		{
			Reporter.log("fail");
		}
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		clickOnCancelBtn.click();

		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}
}