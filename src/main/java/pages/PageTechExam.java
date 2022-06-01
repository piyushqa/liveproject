package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTechExam {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.CSS, using = "div.encounter_tab_bar_container>table>tbody>tr>td:nth-child(6)>div")
	private WebElement clickOnTechExam;

	@FindBy(how = How.CSS, using = "input#gwt-debug-rightEye_reading")
	private WebElement clickOnAddSetOd;

	@FindBy(how = How.CSS, using = "table#gwt-debug-rightEye-IOP-Reading-Table>tbody>tr>td>div")
	private List<WebElement> select_AddSetOd;

	@FindBy(how = How.CSS, using = "input#gwt-debug-leftEye_reading")
	private WebElement clickOnAddSetOs;

	@FindBy(how = How.CSS, using = "table#gwt-debug-rightEye-IOP-Reading-Table>tbody>tr>td>div")
	private List<WebElement> select_AddSetOs;

	@FindBy(how = How.CSS, using = "div#gwt-debug-lblExamResults")
	private WebElement clickOnMoodAndOrientation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Mood-container>div")
	private List<WebElement> select_Mood;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Orientation-container>div")
	private List<WebElement> select_Orientation;

	@FindBy(how = How.CSS, using = "a#gwt-debug-Done.gwt-Anchor")
	private WebElement clickOnDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-OD-color-vision")
	private WebElement clickOnOdVision;

	@FindBy(how = How.CSS, using = "table#gwt-debug-rightReading>tbody>tr>td:nth-child(1)")
	private WebElement lowOD;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> selectLowAndMidumData;

	@FindBy(how = How.CSS, using = "table#gwt-debug-rightReading>tbody>tr>td:nth-child(3)")
	private WebElement mediumOD;

	@FindBy(how = How.CSS, using = "table#gwt-debug-rightReading>tbody>tr>td:nth-child(5)")
	private WebElement highOD;

	@FindBy(how = How.CSS, using = "table#gwt-debug-leftReading>tbody>tr>td:nth-child(1)")
	private WebElement lowOS;

	@FindBy(how = How.CSS, using = "table#gwt-debug-leftReading>tbody>tr>td:nth-child(3)")
	private WebElement mediumOS;

	@FindBy(how = How.CSS, using = "table#gwt-debug-leftReading>tbody>tr>td:nth-child(5)")
	private WebElement highOS;

	@FindBy(how = How.CSS, using = "input#gwt-debug-rightCentral")
	private WebElement centeralOD;

	@FindBy(how = How.CSS, using = "input#gwt-debug-rightPeripheral")
	private WebElement peripheralOD;

	@FindBy(how = How.CSS, using = "input#gwt-debug-leftCentral")
	private WebElement CenteralOS;

	@FindBy(how = How.CSS, using = "input#gwt-debug-leftPeripheral")
	private WebElement peropheralOS;

	@FindBy(how = How.CSS, using = "td>div#gwt-debug-OD-color-vision")
	private WebElement clickOnOdColorVision;
	
	@FindBy(how=How.XPATH,using=".//span[contains(text(),'Test type:')]")
	private WebElement clickOnWindowForActiveElement;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageTechExam(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageTechExam.this);
	}

	public void verifyTechExam(String provider, String iopOD, String iopOS, String mood, String orientation,
			String comment1, String comment2, String quries, String rightEye, String leftEye, String ValueODAndOS,
			String centeral, String peripheral) throws Exception {

		openEncounter(provider);

		Thread.sleep(5000);
		clickOnTechExam.click();

		// performIOPOperation(iopOD, iopOS);

		// performMoodOrientationOperation(mood, orientation);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnOdColorVision);
		clickOnOdColorVision.click();
		new PageSensoromotorExam(driver, wait, builder).colorVision(comment1, comment2, quries, rightEye, leftEye);

		performMediumAndLowOperation(ValueODAndOS);

		 performCenteralAndPeriPheraldate(centeral, peripheral);
	}

	// join encounter
	public void openEncounter(String provider) throws Exception {
		Thread.sleep(9000);
		clickJionOpenencounter.click();

		// Select_Provider
		Thread.sleep(8000);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;
			}
	}

	public void performIOPOperation(String iopOD, String iopOS) throws Exception {

		ensureElementToBeClickable(clickOnAddSetOd);
		clickOnAddSetOd.click();

		ensureElementToBeClickable(select_AddSetOd);
		for (WebElement selectAddSetOd : select_AddSetOd) {
			if (selectAddSetOd.getText().equalsIgnoreCase(iopOD)) {
				selectAddSetOd.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnAddSetOs);
		clickOnAddSetOs.click();

		ensureElementToBeClickable(select_AddSetOs);
		for (WebElement selectAddSetOs : select_AddSetOs) {
			if (selectAddSetOs.getText().equalsIgnoreCase(iopOS)) {
				selectAddSetOs.click();
				break;
			}
		}
	}

	private void performMoodOrientationOperation(String mood, String orientation) throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnMoodAndOrientation);
		clickOnMoodAndOrientation.click();

		ensureElementToBeClickable(select_Mood);
		for (WebElement selectMood : select_Mood) {
			if (selectMood.getText().equalsIgnoreCase(mood)) {
				if (!selectMood.isSelected()) {
					selectMood.click();
					break;
				}

			}
		}

		ensureElementToBeClickable(select_Orientation);
		for (WebElement selectOrientation : select_Orientation) {
			if (selectOrientation.getText().equalsIgnoreCase(orientation)) {
				if (!selectOrientation.isSelected()) {
					selectOrientation.click();
					break;
				}

			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();
	}

	private void performMediumAndLowOperation(String ValueODAndOS) throws Exception {
		Thread.sleep(3000);

		//ensureElementToBeClickable(lowOD);
		String lowOdText = lowOD.getAttribute("value");
		if (lowOdText !=null) {
			System.out.println("OD Value");
			//lowOD.clear();
			lowOD.click();
			selectMediumAndLowOperation(ValueODAndOS);
		} else {
			lowOD.click();
			selectMediumAndLowOperation(ValueODAndOS);
			selectMediumAndLowOperation(ValueODAndOS);
		}

		Thread.sleep(3000);
		
		clickOnWindowForActiveElement.click();
		ensureElementToBeClickable(mediumOD);
		Thread.sleep(5000);
		String mediumODText = mediumOD.getText();
		System.out.println(mediumODText);
		if (mediumODText != null) {
			//mediumOD.clear();
			System.out.println("Od and OS value");
			mediumOD.click();
			
			selectMediumAndLowOperation(ValueODAndOS);
		} else {
			mediumOD.click();
			selectMediumAndLowOperation(ValueODAndOS);
			selectMediumAndLowOperation(ValueODAndOS);
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(highOD);
		String highODText = highOD.getText();
		if (highODText != null) {
			//highOD.clear();
			highOD.click();
			
			selectMediumAndLowOperation(ValueODAndOS);
		} else {
			highOD.clear();
			selectMediumAndLowOperation(ValueODAndOS);
			selectMediumAndLowOperation(ValueODAndOS);
		}

		Thread.sleep(4000);

		//ensureElementToBeClickable(lowOS);
		String lowOSText = lowOS.getText();
		if (lowOSText != null) {
			//lowOD.sendKeys(Keys.DELETE);
			lowOS.click();
			
			selectMediumAndLowOperation(ValueODAndOS);
		} else {
			lowOS.click();
			selectMediumAndLowOperation(ValueODAndOS);
			selectMediumAndLowOperation(ValueODAndOS);
		}

		Thread.sleep(4000);

		//ensureElementToBeClickable(mediumOS);
		String mediumOSText = mediumOS.getText();
		if (mediumOSText != null) {
			//mediumOS.sendKeys(Keys.DELETE);
			mediumOS.click();
			
			selectMediumAndLowOperation(ValueODAndOS);
		} else {
			mediumOS.click();
			selectMediumAndLowOperation(ValueODAndOS);
			selectMediumAndLowOperation(ValueODAndOS);
		}

		Thread.sleep(4000);

		ensureElementToBeClickable(highOS);
		String highOSText = highOS.getText();
		if (highOSText != null) {
			//highOS.clear();
			highOS.click();
			selectMediumAndLowOperation(ValueODAndOS);
			
		} else {
			highOS.click();
			selectMediumAndLowOperation(ValueODAndOS);
			selectMediumAndLowOperation(ValueODAndOS);
		}

	}

	private void performCenteralAndPeriPheraldate(String centeral, String peripheral) throws Exception {
		String[] strCenteral = centeral.split("-");

		ensureElementToBeClickable(centeralOD);
		centeralOD.clear();
		centeralOD.sendKeys(strCenteral[0]);

		ensureElementToBeClickable(CenteralOS);
		CenteralOS.clear();
		CenteralOS.sendKeys(strCenteral[1]);

		String strPeriPheral[] = peripheral.split("-");
		ensureElementToBeClickable(peripheralOD);
		peripheralOD.clear();
		peripheralOD.sendKeys(strPeriPheral[0]);

		ensureElementToBeClickable(peropheralOS);
		peropheralOS.clear();
		peropheralOS.sendKeys(strPeriPheral[1]);
	}

	private void selectMediumAndLowOperation(String ValueODAndOS) throws Exception {
		ensureElementToBeClickable(selectLowAndMidumData);
		Thread.sleep(3000);
		for (WebElement select_MediumAndLowOpeartion : selectLowAndMidumData) {
			if (select_MediumAndLowOpeartion.getText().equalsIgnoreCase(ValueODAndOS)) {
				select_MediumAndLowOpeartion.click();
				break;
			}
		}
	}

	// function use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	private void ensureElementToBeClickable(List<WebElement> element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}
}
