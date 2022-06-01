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
import org.testng.Reporter;

public class PageEditVitalSigns {

	WebDriverWait wait;
	Actions builder;
	WebDriver driver;

	// declare Locator
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()=\"Yes\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[6]/div")
	private WebElement clickOnTechExam;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-vitalSigns\" and text()='Vital Signs']")
	private WebElement clickOnVitalSigns;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-temperature\"]")
	private WebElement fillTemp;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[3]")
	private WebElement clickOnTableRow;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-done\"]/a[text()='Done']")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-thisClinicNoteLink\" and text()='This Clinic Note']")
	private WebElement clickOnClinicNote;

	public PageEditVitalSigns(WebDriverWait wait, Actions builder, WebDriver driver) {

		this.wait = wait;
		this.builder = builder;
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void verifyEditVitalSigns(String provider, String bloodPressure, String comments, String heartRate,
			String temp, String bldcOximetry, String inhaledOxygenConcentration, String respiratoryRate,
			String heightInch, String weight, String newComments, String creationDate) throws Exception {
		Thread.sleep(7000);
		clickJionOpenencounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		// if (select_RowFromOpenEncounter > 0) {

		// Select_Provider
		Thread.sleep(4000);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;
			}
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnTechExam)).click();

		// clickOnVitalSigns
		Thread.sleep(2000);
		ensureElementTobeClickable(clickOnVitalSigns);
		clickOnVitalSigns.click();

		Thread.sleep(6000);
		try {
		ensureElementTobeClickable(clickOnTableRow);
		clickOnTableRow.click();

		Thread.sleep(4000);
		editVitalSignData(temp);
		}catch(Exception ex) {
			new PageAddVitalSigns(driver, wait, builder).addVitalSignData(bloodPressure, comments, heartRate, temp, bldcOximetry, inhaledOxygenConcentration, respiratoryRate, heightInch, weight, newComments, creationDate);
		}

	}

	public void editVitalSignData(String temp) throws Exception {

		// Thread.sleep(2000);
		fillTemp.clear();
		Thread.sleep(2000);
		fillTemp.sendKeys(temp);

		Thread.sleep(2000);
		ensureElementTobeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();

		Thread.sleep(2000);
		ensureElementTobeClickable(clickOnClinicNote);
		clickOnClinicNote.click();

		// get the heart rate from clinic note
		Thread.sleep(9000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		By getClinicNoteData = By
				.xpath("//*[@id=\"report\"]/table/tbody/tr/td/div[text()=\"Temperature:" + " " + temp + ".00" + "\"]");

		String strData = driver.findElement(getClinicNoteData).getText();

		strData = strData.substring(0, strData.length() - 2);
		System.out.println(strData);

		// System.out.println(getClinicNoteData);

		// get the data from excel and match with clinic note
		Thread.sleep(2000);
		if (strData.endsWith(temp)) {
			Reporter.log(temp + " " + strData + " same ");
		}
	}

	public void ensureElementTobeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
