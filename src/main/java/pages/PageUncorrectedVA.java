package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
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



public class PageUncorrectedVA {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

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

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[2]")
	private WebElement getSellenvalue;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-normal-od-distance")
	private WebElement clickOnOdDistanceBox;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> select_OdDistance;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-normal-od-intermediate")
	private WebElement clickOnOdIntermediateBox;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> select_OdIntermediate;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-normal-od-near")
	private WebElement clickOnOdNearBox;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> select_OdNear;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-normal-os-distance")
	private WebElement clickOnOsDistanceBox;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> select_OsDistance;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-normal-os-intermediate")
	private WebElement clickOnOsIntermediate;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> select_OsIntermediate;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-normal-os-near")
	private WebElement clickOnOsNear;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> select_OsNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div/div[1]/div[4]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/span")
	private WebElement clickOnComment1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div/div[1]")
	private WebElement clickOnEnableElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[2]/div/div[1]/div[4]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/span")
	private WebElement clickOnComment2;

	@FindBy(how = How.CSS, using = "div.popupContent>textarea.gwt-TextArea")
	private WebElement fillComments;

	@FindBy(how = How.CSS, using = "span#gwt-debug-uncorrected-delete")
	private WebElement clickOnDeleteBtn;

	@FindBy(how = How.XPATH, using = ".//div[@title=\"Binocular VA\"]")
	private WebElement getBinocularValue;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-binocular-od-distance")
	private WebElement clickOnBinocularDistance;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> selectBinocularDistance;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-binocular-od-intermediate")
	private WebElement clickOnBinocularIntermideate;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> selectBinocularIntermediate;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-binocular-od-near")
	private WebElement clickOnBinocularNear;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> selectBinocularNear;

	@FindBy(how = How.XPATH, using = ".//div[@title=\"Pinhole VA\"]")
	private WebElement getPinholeValue;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-pinhole-od-distance")
	private WebElement clickOnPinholeDistance;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> selectPinholeDistance;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-pinhole-od-intermediate")
	private WebElement clickOnPinHoleIntermediate;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> selectPinholeIntermediate;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-pinhole-od-near")
	private WebElement clickOnPinholeNear;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> selectPinholeNear;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-pinhole-os-distance")
	private WebElement clickOnPinholeOSDistance;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> selectPinholeOSDistance;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-pinhole-os-intermediate")
	private WebElement clickOnPinHoleOSIntermediate;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> selectPinholeOSIntermediate;

	@FindBy(how = How.CSS, using = "input#gwt-debug-acuity-pinhole-os-near")
	private WebElement clickOnPinholeOSNear;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/div")
	private List<WebElement> selectPinholeOSNear;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickONClinicNote;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private WebElement clickOnClinicNoteCloseBtn;

	@FindBy(how = How.XPATH, using = ".//td[text()=\"Vision Without Correction:\"]")
	private WebElement getVisionText;

	public PageUncorrectedVA(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageUncorrectedVA.this);
	}

	public void verifyUCVAData(String provider, String OdDistance, String OdIntermediate, String OdNear,
			String OsDistance, String OsIntermediate, String OsNear, String BinDistance, String BinIntermediate,
			String BinNear, String PinOdDistance, String PinOdIntermediate, String PinOdNear, String PinOsDistance,
			String PinOsIntermediate, String PinOsNear, String visitType, Boolean noCharges) throws Exception {

		// click join encounter and select provider
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

		Thread.sleep(2000);
		clickVisonTab.click();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		// invoke method UCVA
		addUCVAData(OdDistance, OdIntermediate, OdNear, OsDistance, OsIntermediate, OsNear, BinDistance,
				BinIntermediate, BinNear, PinOdDistance, PinOdIntermediate, PinOdNear, PinOsDistance, PinOsIntermediate,
				PinOsNear);

		// new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType,
		// noCharges);

	}

	public void addUCVAData(String OdDistance, String OdIntermediate, String OdNear, String OsDistance,
			String OsIntermediate, String OsNear, String BinDistance, String BinIntermediate, String BinNear,
			String PinOdDistance, String PinOdIntermediate, String PinOdNear, String PinOsDistance,
			String PinOsIntermediate, String PinOsNear) throws Exception {
		Thread.sleep(5000);

		String strAddVision = clickOnAddVision.getText();
		try {
			if (strAddVision.contains("Add Vision")) {
				ensureElementToBeClickable(clickOnAddVision);
				clickOnAddVision.click();
			}
		} catch (Exception e) {
			Thread.sleep(3000);
			clickOnDeleteVision.click();
			Thread.sleep(4000);
			ensureElementToBeClickable(clickOnAddVision);
			clickOnAddVision.click();
		}

		// invoke od/os (Distance method)
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		OdOsDistance(PinOdDistance, PinOsDistance);

		// invoke od/os(Intermediate method)
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		OdOsIntermediate(PinOdIntermediate, PinOsIntermediate);

		// invoke od/os(Near method)
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		OdOsNear(PinOdNear, PinOsNear);

		Thread.sleep(2000);
		clickOnComment1.click();

		Thread.sleep(1000);
		fillComments.sendKeys("UCVA OD");

		Thread.sleep(3000);
		binocularOperation(BinDistance, BinIntermediate, BinNear);

		Thread.sleep(3000);
		pinholeOperations(PinOdDistance, PinOdIntermediate, PinOdNear, PinOsDistance, PinOsIntermediate, PinOsNear);
		// driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut,
		// TimeUnit.SECONDS);
		// clickOnEnableElement.click();

		// Thread.sleep(3000);
		// clickOnComment2.click();
		//
		// Thread.sleep(1000);
		// fillComments.sendKeys("UCVA OS");

		Thread.sleep(4000);
		matchClinicNoteData();

		Thread.sleep(2000);
		clickOnDeleteBtn.click();

	}

	public void OdOsDistance(String OdDistance, String OsDistance) throws Exception {

		Thread.sleep(2000);
		clickOnOdDistanceBox.click();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		String str = "Snellen";
		String getValue = getSellenvalue.getText();

		Thread.sleep(3000);
		if (str.equalsIgnoreCase(getValue)) {

			for (WebElement select_OdDistanceValue : select_OdDistance) {
				if (select_OdDistanceValue.getText().equalsIgnoreCase(OdDistance)) {
					select_OdDistanceValue.click();
					break;
				}
			}
			Thread.sleep(2000);
			clickOnOsDistanceBox.click();

			for (WebElement select_OsDistanceValue : select_OsDistance) {
				if (select_OsDistanceValue.getText().equalsIgnoreCase(OsDistance)) {
					select_OsDistanceValue.click();
					break;
				}
			}
		}
	}

	public void OdOsIntermediate(String OdIntermediate, String OsIntermediate) throws Exception {

		Thread.sleep(2000);
		clickOnOdIntermediateBox.click();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		String str = "Snellen";
		String getValue = getSellenvalue.getText();
		Thread.sleep(3000);
		if (str.equalsIgnoreCase(getValue)) {
			System.out.println(str.equalsIgnoreCase(getValue));
			for (WebElement select_OdIntermediateValue : select_OdIntermediate) {
				if (select_OdIntermediateValue.getText().equalsIgnoreCase(OdIntermediate)) {
					select_OdIntermediateValue.click();
					break;
				}
			}

			try {
				Thread.sleep(2000);
				clickOnOdIntermediateBox.click();

				for (WebElement select_OdIntermediateValue : select_OdIntermediate) {
					if (select_OdIntermediateValue.getText().equalsIgnoreCase("20/12")) {
						select_OdIntermediateValue.click();
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("we don't rechange the value");
			}

			Thread.sleep(2000);
			clickOnOsIntermediate.click();

			for (WebElement select_OsIntermediateValue : select_OsIntermediate) {
				if (select_OsIntermediateValue.getText().equalsIgnoreCase(OsIntermediate)) {
					select_OsIntermediateValue.click();
					break;
				}
			}

		}
	}

	public void OdOsNear(String OdNear, String OsNear) throws Exception {
		Thread.sleep(2000);
		clickOnOdNearBox.click();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		String str = "Jaeger";
		String getValue = getSellenvalue.getText();

		Thread.sleep(3000);
		if (str.equalsIgnoreCase(getValue)) {
			for (WebElement select_OdNearValue : select_OdNear) {
				if (select_OdNearValue.getText().equalsIgnoreCase(OdNear)) {
					select_OdNearValue.click();
					break;
				}
			}

			Thread.sleep(2000);
			clickOnOsNear.click();

			for (WebElement select_OsNearValue : select_OsNear) {
				if (select_OsNearValue.getText().equalsIgnoreCase(OsNear)) {
					select_OsNearValue.click();
					break;
				}
			}
		}

	}

	public void binocularOperation(String BinDistance, String BinIntermediate, String BinNear) throws Exception {
		try {
			boolean strBincoularValue = getBinocularValue.isEnabled();
			System.out.println(strBincoularValue);
			if (true == strBincoularValue) {
				ensureElementToBeClickable(clickOnBinocularDistance);
				clickOnBinocularDistance.click();

				Thread.sleep(3000);
				for (WebElement select_BinocularDistance : selectBinocularDistance) {
					if (select_BinocularDistance.getText().equalsIgnoreCase(BinDistance)) {
						select_BinocularDistance.click();
						break;
					}
				}

				ensureElementToBeClickable(clickOnBinocularIntermideate);
				clickOnBinocularIntermideate.click();

				for (WebElement select_BinocularIntermediate : selectBinocularIntermediate) {
					if (select_BinocularIntermediate.getText().equalsIgnoreCase(BinIntermediate)) {
						select_BinocularIntermediate.click();
						break;
					}
				}

				ensureElementToBeClickable(clickOnBinocularNear);
				clickOnBinocularNear.click();

				for (WebElement select_BinocularNear : selectBinocularNear) {
					if (select_BinocularNear.getText().equalsIgnoreCase(BinNear)) {
						select_BinocularNear.click();
						break;
					}
				}
			}
		} catch (Exception e) {

			System.out.println("Bincoular value not exist");

		}
	}

	public void pinholeOperations(String PinOdDistance, String PinOdIntermediate, String PinOdNear,
			String PinOsDistance, String PinOsIntermediate, String PinOsNear) throws Exception {
		try {
			boolean strPinholeValue = getPinholeValue.isEnabled();
			if (true == strPinholeValue) {

				ensureElementToBeClickable(clickOnPinholeDistance);
				clickOnPinholeDistance.click();

				for (WebElement select_PinholeDistance : selectPinholeDistance) {
					if (select_PinholeDistance.getText().equalsIgnoreCase(PinOdDistance)) {
						select_PinholeDistance.click();
						break;
					}
				}

				ensureElementToBeClickable(clickOnPinHoleIntermediate);
				clickOnPinHoleIntermediate.click();

				for (WebElement select_PinHoleIntermediate : selectPinholeIntermediate) {
					if (select_PinHoleIntermediate.getText().equalsIgnoreCase(PinOdIntermediate)) {
						select_PinHoleIntermediate.click();
						break;
					}
				}

				ensureElementToBeClickable(clickOnPinholeNear);
				clickOnPinholeNear.click();

				for (WebElement select_PinholeDistance : selectPinholeNear) {
					if (select_PinholeDistance.getText().equalsIgnoreCase(PinOdNear)) {
						select_PinholeDistance.click();
						break;
					}
				}

				// pinhole OS

				ensureElementToBeClickable(clickOnPinholeOSDistance);
				clickOnPinholeOSDistance.click();

				for (WebElement select_PinholeOSDistance : selectPinholeOSDistance) {
					if (select_PinholeOSDistance.getText().equalsIgnoreCase(PinOdDistance)) {
						select_PinholeOSDistance.click();
						break;
					}
				}

				ensureElementToBeClickable(clickOnPinHoleOSIntermediate);
				clickOnPinHoleOSIntermediate.click();

				for (WebElement select_PinHoleOSIntermediate : selectPinholeOSIntermediate) {
					if (select_PinHoleOSIntermediate.getText().equalsIgnoreCase(PinOdIntermediate)) {
						select_PinHoleOSIntermediate.click();
						break;
					}
				}

				ensureElementToBeClickable(clickOnPinholeOSNear);
				clickOnPinholeOSNear.click();

				for (WebElement select_PinholeOSDistance : selectPinholeOSNear) {
					if (select_PinholeOSDistance.getText().equalsIgnoreCase(PinOdNear)) {
						select_PinholeOSDistance.click();
						break;
					}
				}

			}
		} catch (Exception e) {

			System.out.println("pinhole value not exists");
		}

	}

	private void matchClinicNoteData() throws Exception {
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
