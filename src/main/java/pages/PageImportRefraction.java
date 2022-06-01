package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageImportRefraction {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// Define Locater

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refraction-importOld\"]")
	private WebElement clickOnImportRefraction;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[5]/span")
	private WebElement getDeleteRefractionData;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()='Yes']")
	private WebElement clickOnYesButton;

	public PageImportRefraction(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void verifyImportRefraction(String provider, String importData, String deleteData) throws Exception {

		// click On Open encounter
		Thread.sleep(7000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickJionOpenencounter));
		clickJionOpenencounter.click();

		// check encounter contain any provider then join otherwise start new encounter
		Thread.sleep(5000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(5000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(7000);
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
		// click on visionTab
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVisonTab)).click();

		// click on Import Refraction
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnImportRefraction)).click();

		// select imported Data
		Thread.sleep(15000);
		List<WebElement> select_Importdata = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div/div[1]/div/div/div/div/div/a"));
		int size = select_Importdata.size();
		for (WebElement selectImportData:select_Importdata)
			if (selectImportData.getText().equalsIgnoreCase(importData)) {
				selectImportData.click();
				break;
			}

		// deleteImported Data
		Thread.sleep(5000);
		String strDelete = "Delete";
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(getDeleteRefractionData));
		String getValueOfdelete = getDeleteRefractionData.getText();
		if (strDelete.equalsIgnoreCase(getValueOfdelete)) {
			wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(getDeleteRefractionData)).click();
			wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(clickOnYesButton)).click();
		}
	}

}
