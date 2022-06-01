package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageImportCCDA {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.CSS, using = "span#gwt-debug-importRecs")
	private WebElement getColorOfImportCCDA;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok.gwt-Anchor")
	private WebElement clickOnCCDAYesBtn;

	@FindBy(how = How.CSS, using = "a#gwt-debug-importCCDA")
	private WebElement clickOnImportCCDA;

	@FindBy(how = How.XPATH, using = ".//span[text()=\"View entire CCDA\"]")
	private WebElement clickOnViewEntierCCDA;

	@FindBy(how = How.CSS, using = "Button#gwt-debug-selectCcda.gwt-Button")
	private WebElement clickONSelectOption;

	@FindBy(how = How.CSS, using = "div#gwt-debug-sectionCompleted>a")
	private WebElement clickOnSectionCompleted;

	@FindBy(how = How.CSS, using = "div#gwt-debug-saveMerged>a")
	private WebElement clickOnsaveMerged;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Manage Allergies\"]")
	private WebElement clickOnManageAllergies;

	@FindBy(how = How.XPATH, using = ".//iframe[@class=\"gwt-Frame\"]")
	private WebElement swithToFrame;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"+ Merged Meds\"]")
	private WebElement clickONMergedMed;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-mergedMeds-container\"]/div/img[@class=\"gwt-Image rejectSuggestionIcon\"]")
	private WebElement delMedicine;

	@FindBy(how = How.XPATH, using = ".//div[text()=\" + Merged Allergies\"]")
	private WebElement clickOnMergedAllergies;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-mergedAllergies-container\"]/div/img[@class=\"gwt-Image rejectSuggestionIcon\"]")
	private WebElement delAllergies;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Done\"]")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[2]/div")
	private WebElement clickOnOtherHistory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-eye-meds-container>div>div:nth-child(1)")
	private WebElement getMedicine;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageImportCCDA(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageImportCCDA.this);
	}

	public void verifyImportCCDA(String provider, String documentCategory, String fileName, String allergies,
			String recation, String severity, String Date, String medicationName) throws Exception {

		new PageInterpretationOfOpthalmoscopy(driver, wait, builder).uploadDocument(provider, documentCategory,
				fileName);

		performCCDAoperation(provider);

		performImportCCDAdataOperation(allergies, severity, recation, Date, medicationName);

		performMergedMedicine();

		performMergedAllergie();

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();

		matchCCDAData(medicationName);
	}

	public void performCCDAoperation(String provider) throws Exception {

		String getColorOfCCDA = getColorOfImportCCDA.getCssValue("color");
		String hex = Color.fromString(getColorOfCCDA).asHex();
		System.out.println(hex);

		ensureElementToBeClickable(getColorOfImportCCDA);
		getColorOfImportCCDA.click();

		ensureElementToBeClickable(clickOnCCDAYesBtn);
		clickOnCCDAYesBtn.click();

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);
	}

	public void performImportCCDAdataOperation(String allergies, String recation, String severity, String Date,
			String medicationName) throws Exception {

		ensureElementToBeClickable(clickOnImportCCDA);
		clickOnImportCCDA.click();

		ensureElementToBeClickable(clickONSelectOption);
		clickONSelectOption.click();

		Thread.sleep(6000);
		for (int i = 0; i < 3; i++) {
			// click the button
			clickOnSectionCompleted.click();
			// wait 2 seconds
			Thread.sleep(2000);
			// check that data is being generated correctly

		}
		ensureElementToBeClickable(clickOnsaveMerged);
		clickOnsaveMerged.click();

		Thread.sleep(3000);
		driver.switchTo().frame(swithToFrame);

		Thread.sleep(7000);
		ensureElementToBeClickable(clickOnManageAllergies);
		clickOnManageAllergies.click();

		Thread.sleep(6000);
		new PageAddAllergies(driver, wait, builder).addAllergie(allergies, recation, severity, Date);

		// Thread.sleep(8000);
		// ensureElementToBeClickable(swithToFrame);
		// driver.switchTo().frame(swithToFrame);

		Thread.sleep(6000);
		new PageMatchMedicationAndAllergieWithPatientEducation(driver, wait, builder).addMedicine(medicationName);

	}

	private void performMergedMedicine() throws Exception {
		// for (String handelWindow : driver.getWindowHandles()) {
		// driver.switchTo().window(handelWindow);
		// }

		Thread.sleep(6000);
		driver.switchTo().defaultContent();

		Thread.sleep(6000);
		ensureElementToBeClickable(clickONMergedMed);
		clickONMergedMed.click();

//		 Thread.sleep(4000);
//		 ensureElementToBeClickable(delMedicine);
//		 delMedicine.click();

	}

	private void performMergedAllergie() throws Exception {

		Thread.sleep(6000);
		ensureElementToBeClickable(clickOnMergedAllergies);
		clickOnMergedAllergies.click();

//		 Thread.sleep(4000);
//		 ensureElementToBeClickable(delAllergies);
//		 delAllergies.click();

	}

	public void matchCCDAData(String medicationName) throws Exception {

		Thread.sleep(6000);
		ensureElementToBeClickable(clickOnOtherHistory);
		clickOnOtherHistory.click();

		Thread.sleep(6000);
		ensureElementToBeClickable(getMedicine);

		String getMedicineText = getMedicine.getText();
		System.out.println(getMedicineText);
		if (medicationName.startsWith(getMedicineText)) {
			Reporter.log(getMedicineText + " " + "same as" + " " + medicationName);
			System.out.println("PASS Secanoiro");
		}
	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void ensureElementsToBeClickable(List<WebElement> elements) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
}
