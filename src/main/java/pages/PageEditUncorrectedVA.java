package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
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

public class PageEditUncorrectedVA {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div")
	private List<WebElement> selectProvider;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.CSS, using = "table#gwt-debug-encounterTabBar>tbody>tr>td:nth-child(5)>div")
	private WebElement clickVisonTab;

	@FindBy(how = How.CSS, using = "span#gwt-debug-uncorrected-addNew")
	private WebElement clickOnAddVision;

	@FindBy(how = How.CSS, using = "span#gwt-debug-uncorrected-delete")
	private WebElement clickOnDeleteVision;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickONClinicNote;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private WebElement clickOnClinicNoteCloseBtn;

	@FindBy(how = How.XPATH, using = ".//td[text()=\"Vision Without Correction:\"]")
	private WebElement getVisionText;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageEditUncorrectedVA(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageEditUncorrectedVA.this);
	}

	public void checkEditUncorrectedVA(String provider, String OdDistance, String OdIntermediate, String OdNear,
			String OsDistance, String OsIntermediate, String OsNear, String BinDistance, String BinIntermediate,
			String BinNear, String PinOdDistance, String PinOdIntermediate, String PinOdNear, String PinOsDistance,
			String PinOsIntermediate, String PinOsNear, String editOdDistance, String editOdIntermediate,
			String editOdNear, String editOsDistance, String editOsIntermediate, String editOsNear) throws Exception {

		joinOpenEncounter(provider);

		ensureElementToBeClickable(clickVisonTab);
		clickVisonTab.click();

		checkAddOrEditUCVAdata(OdDistance, OdIntermediate, OdNear, OsDistance, OsIntermediate, OsNear, BinDistance,
				BinIntermediate, BinNear, PinOdDistance, PinOdIntermediate, PinOdNear, PinOsDistance, PinOsIntermediate,
				PinOsNear, editOdDistance, editOdIntermediate, editOdNear, editOsDistance, editOsIntermediate,
				editOsNear);

		generateClinicNote();

		 Thread.sleep(2000);
		 clickOnDeleteVision.click();
	}

	public void joinOpenEncounter(String provider) throws Exception {
		Thread.sleep(9000);
		clickJionOpenencounter.click();
		Thread.sleep(3000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		// System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(1000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
			for (WebElement select_JoinencounterProvider : selectProvider) {
				if (select_JoinencounterProvider.getText().equalsIgnoreCase(provider)) {
					select_JoinencounterProvider.click();
					break;
				}
			}
		}

		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

		}

	}

	private void checkAddOrEditUCVAdata(String OdDistance, String OdIntermediate, String OdNear, String OsDistance,
			String OsIntermediate, String OsNear, String BinDistance, String BinIntermediate, String BinNear,
			String PinOdDistance, String PinOdIntermediate, String PinOdNear, String PinOsDistance,
			String PinOsIntermediate, String PinOsNear, String editOdDistance, String editOdIntermediate,
			String editOdNear, String editOsDistance, String editOsIntermediate, String editOsNear) throws Exception {

		String strAddVision = clickOnAddVision.getText();
		try {
			if (strAddVision.contains("Add Vision")) {
				ensureElementToBeClickable(clickOnAddVision);
				// builder.doubleClick(clickOnAddVision).build().perform();
				Thread.sleep(7000);
				clickOnAddVision.click();

				new PageUncorrectedVA(driver, wait, builder).OdOsDistance(OdDistance, OsDistance);
				new PageUncorrectedVA(driver, wait, builder).OdOsIntermediate(OdIntermediate, OsIntermediate);
				new PageUncorrectedVA(driver, wait, builder).OdOsNear(OdNear, OsNear);
				new PageUncorrectedVA(driver, wait, builder).binocularOperation(BinDistance, BinIntermediate, BinNear);
				new PageUncorrectedVA(driver, wait, builder).pinholeOperations(PinOdDistance, PinOdIntermediate,
						PinOdNear, PinOsDistance, PinOsIntermediate, PinOsNear);
				new PageUncorrectedVA(driver, wait, builder).OdOsDistance(editOdDistance, editOsDistance);
				new PageUncorrectedVA(driver, wait, builder).OdOsIntermediate(editOdIntermediate, editOsIntermediate);
				new PageUncorrectedVA(driver, wait, builder).OdOsNear(editOdNear, editOsNear);
			}
		} catch (Exception e) {
			// Thread.sleep(3000);
			// clickOnDeleteVision.click();
			// Thread.sleep(4000);
			// ensureElementToBeClickable(clickOnAddVision);
			// clickOnAddVision.click();
			new PageUncorrectedVA(driver, wait, builder).OdOsDistance(editOdDistance, editOsDistance);
			new PageUncorrectedVA(driver, wait, builder).OdOsIntermediate(editOdIntermediate, editOsIntermediate);
			new PageUncorrectedVA(driver, wait, builder).OdOsNear(editOdNear, editOsNear);
		}
	}

	public void generateClinicNote() throws Exception {
		Thread.sleep(4000);
		ensureElementToBeClickable(clickONClinicNote);
		clickONClinicNote.click();
		Thread.sleep(2000);
		String strVisionText = getVisionText.getText();
		System.out.println(strVisionText);
		Thread.sleep(3000);
		if (strVisionText.equalsIgnoreCase("Vision Without Correction:")) {
			Reporter.log("clinic note data matched");
			System.out.println("clinic note data matched");
		}

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnClinicNoteCloseBtn);
		clickOnClinicNoteCloseBtn.click();
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
