package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAddCCandHPI {
	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	@FindBy(how = How.CSS, using = "div.encounter_tab_bar_container>table>tbody>tr>td:nth-child(1)>div")
	private WebElement clickOnCCHPI;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[2]/span")
	private WebElement clickOnAddMoreHere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[2]/input")
	private WebElement clickOnInputText;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[3]/span")
	private WebElement clickOnSave;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-TabLayoutPanelTabInner\"]/div[contains(text(),'Sentences')]")
	private WebElement clickOnSentences;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div[3]/span[1]")
	private WebElement clickOnAddMoreSentences;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div[3]/input")
	private WebElement fillOnAddMoreSencentes;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[3]/div/div[1]/div[3]/span[2]")
	private WebElement clickOnSentencesSave;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-TabLayoutPanelTabInner\"]/div[contains(text(),'Paragraph')]")
	private WebElement clickOnParagraph;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[4]/div/div[2]/textarea")
	private WebElement clickOnFillTextArea;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-TabLayoutPanelTabInner\"]/div[contains(text(),'Add Outside Data')]")
	private WebElement clickOnAddOutsideData;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[5]/div/div[2]/div[1]/textarea")
	private WebElement clickOnMedicalRecords;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[5]/div/div[2]/div[2]/textarea")
	private WebElement clickOnLaborartyStudies;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[5]/div/div[2]/div[3]/textarea")
	private WebElement clickOnRadiologyReport;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[5]/div/div[2]/div[4]/textarea")
	private WebElement clickOnOtherRecords;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-TabLayoutPanelTabInner\"]/div[contains(text(),'HPI Elements')]")
	private WebElement clickOnHpiElements;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[6]/div/div[4]/span[1]/label")
	private WebElement chkBxLocation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[6]/div/div[5]/span[1]/label")
	private WebElement chkBxQuality;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[6]/div/div[6]/span[1]/label")
	private WebElement chkBxSeverity;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[6]/div/div[8]/span[1]/label")
	private WebElement chkBxTiming;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[6]/div/div[9]/span[1]/label")
	private WebElement chkBxContext;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div[3]/div/div[6]/div/div[10]/span[1]/label")
	private WebElement chkBxDuration;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Done')]")
	private WebElement clickOnDone;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageAddCCandHPI(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddCCandHPI.this);
	}

	public void verifyCCandHPI(String provider, String who, boolean location, Boolean quality, Boolean severity,
			Boolean timing, Boolean context, Boolean duration) throws Exception {

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnCCHPI);
		clickOnCCHPI.click();

		perfomBullets();
		performSentences();
		performPragraph();
		performOutSideData();
		performHpiElements(location, quality, severity, timing, context, duration);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();
	}

	public void perfomBullets() throws Exception {

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnAddMoreHere);
		clickOnAddMoreHere.click();

		clickOnInputText.sendKeys("Ankit");

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSave);
		clickOnSave.click();

	}

	public void performSentences() throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSentences);
		clickOnSentences.click();

		ensureElementToBeClickable(clickOnAddMoreSentences);
		clickOnAddMoreSentences.click();

		fillOnAddMoreSencentes.sendKeys("xyz");

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSentencesSave);
		clickOnSentencesSave.click();
	}

	public void performPragraph() throws Exception {

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnParagraph);
		clickOnParagraph.click();

		clickOnFillTextArea.sendKeys("Integrity");

	}

	public void performOutSideData() throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnAddOutsideData);
		clickOnAddOutsideData.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnMedicalRecords);
		clickOnMedicalRecords.sendKeys("Medical Records");

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnLaborartyStudies);
		clickOnLaborartyStudies.sendKeys("LaborartyStudies");

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnRadiologyReport);
		clickOnRadiologyReport.sendKeys("RadiologyReport");

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnOtherRecords);
		clickOnOtherRecords.sendKeys("clickonotherrecords");

	}

	public void performHpiElements(Boolean location, Boolean quality, Boolean severity, Boolean timing, Boolean context,
			Boolean duration) throws Exception {

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnHpiElements);
		clickOnHpiElements.click();

		if (!chkBxLocation.isSelected() && location) {
			chkBxLocation.click();
		}

		if (!chkBxQuality.isSelected() && quality) {
			chkBxQuality.click();
		}

		if (!chkBxSeverity.isSelected() && severity) {
			chkBxSeverity.click();
		}
		if (!chkBxTiming.isSelected() && timing) {
			chkBxTiming.click();
		}
		if (!chkBxContext.isSelected() && context) {
			chkBxContext.click();
		}
		if (!chkBxDuration.isSelected() && duration) {
			chkBxDuration.click();
		}
	}

	// function use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
