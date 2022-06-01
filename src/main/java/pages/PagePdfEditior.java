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

public class PagePdfEditior {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	// define Locater

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget>a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"encounter_tab_bar_container\"]/table/tbody/tr/td[9]/div")
	private WebElement clickOnImpAndPlan;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-patientEducation\"]/a[text()='Patient Education']")
	private WebElement clickOnPatientEducation;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-suggestedDocs-container\"]/div[3]")
	private WebElement clickOnDoc;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-\"]")
	private WebElement clickOnClose;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickOnTheClinicNote;

	 @FindBy(xpath = "//*[@id=\"report\"]/div[30]/div[2]")
	 private WebElement editPdf;

//	@FindBy(xpath = ".//div[text()='The patient is given the patient education document: \"Eye Diseases\", via Patient Portal.']")
//	private WebElement editPdf;

	@FindBy(xpath = "//*[@id=\"gwt-debug-overlay_content\"]/table/tbody/tr[2]/td/div/div")
	private WebElement clickOnElement;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-overlay_body\"]")
	private WebElement clickOnText;

	public PagePdfEditior(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void editPdf(String provider, String suggestedDoc, String actualText) throws Exception, IOException {

		Thread.sleep(7000);
		clickOnOpenEncounter.click();
		Thread.sleep(7000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(5000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(4000);
			List<WebElement> select_Provider = driver
					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
			for (int i = 1; i <= select_Provider.size(); i++)
				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
					select_Provider.get(i).click();
					break;
				}
		}

		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

		}

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickOnImpAndPlan)).click();

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickOnPatientEducation)).click();

		// select suggested documents

		Thread.sleep(8000);
		Thread.sleep(4000);
		List<WebElement> select_Documents = driver
				.findElements(By.cssSelector("#gwt-debug-suggestedDocs-container>div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase(suggestedDoc)) {
				select_Documents.get(i).click();
				break;
			}




		Thread.sleep(5000);
		By clickOnportal = By.xpath(".//*[@id=\"gwt-debug-sugDoc-view\"][1]/a[text()=\"Send to Portal\"]");
		driver.findElements(clickOnportal).get(0).click();

		Thread.sleep(6000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickOnClose)).click();


		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickOnTheClinicNote)).click();
		Thread.sleep(2000);

		Thread.sleep(15000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		String strText = editPdf.getText();
		assertEquals(strText, actualText);
		{
			Reporter.log("fail");
		}

	}
}