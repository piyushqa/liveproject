package pages;

import java.util.List;

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

import org.testng.Reporter;

public class PageSensoromotorExam {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;

	// declare Locator
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-listing17\"]/tbody/tr/td[text()='Vitreous'][1]")
	private WebElement getViterousValue;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listing17\"]/tbody/tr[17]/td[2]/div")
	private WebElement clickViterousText;

	@FindBy(how = How.XPATH, using = ".//a[text()='Add Sensorimotor Exam']")
	private WebElement clickSensorimotorExam;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div[3]")
	private WebElement clickMotilityDropDown;

	@FindBy(how = How.XPATH, using = ".//span[@id=\"gwt-debug-sensorimotor-motility-zeroGazes\"]")
	private WebElement clickAllGazes;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-sensorimotor-alignment-method-button\"]/div[3]")
	private WebElement clickOnAlignmentmMethod;

	@FindBy(how = How.XPATH, using = ".//span[@id=\"gwt-debug-sensorimotor-alignment-orthoInEleven\"][text()='in all 11 Gazes']")
	private WebElement clickInAllGazes;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sensorimotor-otherAlignment-methodA-button\"]/div[3]")
	private WebElement clickOnOtherAlignment;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sensorimotor-otherAlignment-methodB-button\"]/div[3]")
	private WebElement clickOnOtherAlignment2;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-otherAlignment-methodC\"]")
	private WebElement clickAlignmentText;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-otherAlignment-distanceA\"]")
	private WebElement clickOnDistBox1;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-otherAlignment-nearA\"]")
	private WebElement clickOnNearBox1;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-otherAlignment-distanceB\"]")
	private WebElement clickOnDistBox2;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-otherAlignment-nearB\"]")
	private WebElement clickOnNearBox2;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-otherAlignment-distanceC\"]")
	private WebElement clickOnDistBox3;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-otherAlignment-nearC\"]")
	private WebElement clickOnNearBox3;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-amplitudes-convergenceOver")
	private WebElement clickOnConvergenceBox1;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-amplitudes-convergenceUnder")
	private WebElement clickOnConvergenceBox2;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-amplitudes-divergenceOver")
	private WebElement ClickOnDivergenceBox1;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-amplitudes-divergenceUnder")
	private WebElement ClickOnDivergenceBox2;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-amplitudes-nearPoint")
	private WebElement clickOnNearpointOfConvergence;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-amplitudes-accomodativeOd")
	private WebElement clickOnOD;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-amplitudes-accomodativeOs")
	private WebElement clickOnOS;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-sensoryTesting-unable")
	private WebElement clickOnCoOperationCheckBox;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sensorimotor-stereoTesting-titmusFly-button\"]/div[3]")
	private WebElement clickOnFly;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sensorimotor-stereoTesting-titmusCircles-button\"]/div[3]")
	private WebElement clickOnCircles;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sensorimotor-stereoTesting-titmusAnimals-button\"]/div[3]")
	private WebElement clickOnAnimals;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sensorimotor-stereoTesting-lang-button\"]/div[3]")
	private WebElement clickOnlang;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-sensorimotor-stereoTesting-otherResult-button\"]/div[3]")
	private WebElement clickOnDropdown;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-stereoTesting-otherTest")
	private WebElement fillvalueInOtherText;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-worthDistance-button>div:nth-child(3)")
	private WebElement clickOnDistance;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-worthNear-button>div:nth-child(3)")
	private WebElement clickOnNear;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-fixationPreference-button>div:nth-child(3)")
	private WebElement clickOnFixationPrefrences;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-nystagmus-button>div:nth-child(3)")
	private WebElement clickOnNystagmus;

	@FindBy(how = How.XPATH, using = ".//span[@id=\"gwt-debug-sensorimotor-editColorVision\"]")
	public WebElement clickOnEdit;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder=\"Enter text here...\"]")
	public WebElement clickOnTextOther;

	@FindBy(how = How.XPATH, using = ".//textarea[@id=\"gwt-debug-comments\"]")
	private WebElement clickOnTextComments;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-Done\"]")
	public WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-fixationComment\"]")
	private WebElement clickOncomment1;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"gwt-debug-sensorimotor-nystagmusComment\"]")
	private WebElement clickOnComment2;

	@FindBy(how = How.XPATH, using = ".//textarea[@id=\"gwt-debug-sensorimotor-comments\"]")
	private WebElement clickOncomment3;

	@FindBy(how = How.XPATH, using = ".//textarea[@id=\"gwt-debug-sensorimotor-interpretation\"]")
	private WebElement clickOnInterpretation;

	@FindBy(how = How.CSS, using = "#gwt-debug-sensorimotor-headTilt-position-button>div:nth-child(3)")
	private WebElement clickOnHeadPosition;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-sensorimotor-done\"]/a")
	private WebElement closeTheFillwindow;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-exam-data-done\"]/a")
	private WebElement closeSensoromotorExam;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-supplementalExams-button\"]/div[3]")
	private WebElement clickOnSupplementalExam;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-supplementalExams\"]/div[2]/div[3]")
	private WebElement clickOnHighlatedSupplemetalexam;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-supplementalExams\"]/div[2]/div[3]")
	private WebElement matchSensorimotor;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody > tr >td:nth-child(10)>div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.CSS, using = "#gwt-debug-procsAndTests>div>div:nth-child(1)>span:nth-child(1)")
	private WebElement codingSensorimotor;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-thisClinicNoteLink\"][text()='This Clinic Note']")
	private WebElement clickOnCliniNote;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-sensorimotor-delete\"]/a[text()='Delete']")
	private WebElement clickOndelete;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-ok\"][text()='OK']")
	private WebElement clickonOk;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-Delete\"][text()='Clear All']")
	private WebElement clickOnClerall;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()=\"Yes\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;
	
	@FindBy(how=How.XPATH,using = ".//div[contains(text(),'View')]")
	private WebElement clickOnViewBtn;

	// declare constructor
	public PageSensoromotorExam(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	// method for SensormotorExam
	public void fillSensormotorExam(String provider, String exam, String expectedValue, Integer motility,
			String alignment, String otherAlignment, String otherAlignMent2, String alignmentText, String convergence,
			String divergence, String nearPoint, Boolean Operation, String fly, String circles, String animals,
			String lang, String dropdown, String other, String distance, String near, String fixation, String nystagmus,
			String comment1, String comment2, String comment3, String interpretation, String quries, String rightEye,
			String leftEye, String headPosition) throws Exception {

		// // click on JionOpenencounter
		// Thread.sleep(5000);
		// clickJionOpenencounter.click();
		//
		// // select_Provider
		// Thread.sleep(2000);
		// List<WebElement> select_Provider = driver
		// .findElements(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		// for (int i = 1; i <= select_Provider.size(); i++)
		// if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
		// select_Provider.get(i).click();
		// break;
		//
		// }

		Thread.sleep(6000);
		clickJionOpenencounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		// if (select_RowFromOpenEncounter > 0) {

		// Select_Provider
		Thread.sleep(7000);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;
			}
		// }
		// Thread.sleep(5000);
		// else if (select_RowFromOpenEncounter <= 0) {
		// Thread.sleep(7000);
		// clickStartNewEncounter.click();
		//
		// Thread.sleep(5000);
		// wait.until(ExpectedConditions.elementToBeClickable(clickOnOkBtn)).click();
		// }

		// select Exam
		Thread.sleep(5000);
		List<WebElement> examClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i <= examClick.size(); i++)
			if (examClick.get(i).getText().equalsIgnoreCase(exam)) {
				examClick.get(i).click();
				break;

			}

		// get value of viterous and then click
		Thread.sleep(8000);
		String actualValue = getViterousValue.getText();
		System.out.println(actualValue);
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		if (actualValue.equals(expectedValue)) {
			clickViterousText.click();
		}

		// click on SensorimotorExam
		Thread.sleep(4000);
		String sensorimotorExamText = clickSensorimotorExam.getText();
		System.out.println(sensorimotorExamText);
		clickSensorimotorExam.click();

		Boolean isPresent = (driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-sensorimotor-motility-od-0-button\"]/div[3]")).size() > 0);
		System.out.println(isPresent);

		if (true) {
			Thread.sleep(6000);
			clickOndelete.click();

			Thread.sleep(5000);
			clickonOk.click();
		}
		// click on MotilityDropDown
		Thread.sleep(5000);
		clickSensorimotorExam.click();
		Thread.sleep(5000);
		clickMotilityDropDown.click();
		String strVlaue = motility.toString();
		List<WebElement> motility_value = driver
				.findElements(By.xpath(".//div[@class=\"gwt-PopupPanel\"]/div/div/div/div[2]/div"));
		for (int i = 1; i <= motility_value.size(); i++)
			if (motility_value.get(i).getText().equalsIgnoreCase(strVlaue)) {
				motility_value.get(i).click();
				break;
			}

		// click on AllGazes
		Thread.sleep(4000);
		clickAllGazes.click();

		// click on AlignmentmMethod and select value
		Thread.sleep(4000);
		clickOnAlignmentmMethod.click();

		List<WebElement> alignment_Value = driver
				.findElements(By.xpath("//div[@id=\"gwt-debug-sensorimotor-alignment-method\"]/div[2]/div"));
		for (int i = 1; i <= alignment_Value.size(); i++)
			if (alignment_Value.get(i).getText().equalsIgnoreCase(alignment)) {
				alignment_Value.get(i).click();
				break;
			}

		// click on AllGazes
		Thread.sleep(5000);
		clickInAllGazes.click();

		// click on OtherAlignment and select value
		Thread.sleep(5000);
		clickOnOtherAlignment.click();

		List<WebElement> otherAlignment_Value = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-sensorimotor-otherAlignment-methodA\"]/div[2]/div"));
		for (int i = 1; i <= otherAlignment_Value.size(); i++)
			if (otherAlignment_Value.get(i).getText().equalsIgnoreCase(otherAlignment)) {
				otherAlignment_Value.get(i).click();
				break;
			}

		// click on OtherAlignment2 and select value
		Thread.sleep(4000);
		clickOnOtherAlignment2.click();

		Thread.sleep(6000);
		try {

			WebElement element = driver
					.findElement(By.xpath(".//*[@id=\"gwt-debug-sensorimotor-otherAlignment-methodB\"]/div[2]/div[2]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			System.out.println(ex.getMessage());
		}

		// click on AlignmentText
		Thread.sleep(2000);
		clickAlignmentText.clear();
		clickAlignmentText.sendKeys(alignmentText);

		// click on DistBox1
		Thread.sleep(2000);
		clickOnDistBox1.clear();
		clickOnDistBox1.sendKeys(alignmentText);

		// click On NearBox1
		Thread.sleep(2000);
		clickOnNearBox1.clear();
		clickOnNearBox1.sendKeys(alignmentText);

		// click On DistBox2
		Thread.sleep(2000);
		clickOnDistBox2.clear();
		clickOnDistBox2.sendKeys(alignmentText);

		// click On NearBox2
		Thread.sleep(4000);
		clickOnNearBox2.clear();
		clickOnNearBox2.sendKeys(alignmentText);

		// click On DistBox3
		Thread.sleep(2000);
		clickOnDistBox3.clear();
		clickOnDistBox3.sendKeys(alignmentText);

		// click On NearBox3
		Thread.sleep(2000);
		clickOnNearBox3.clear();
		clickOnNearBox3.sendKeys(alignmentText);

		// fill ConvergenceBox 1 and 2
		String[] convergence_value = convergence.split("/");
		clickOnConvergenceBox1.clear();
		clickOnConvergenceBox1.sendKeys(convergence_value[0]);
		Thread.sleep(5000);
		clickOnConvergenceBox2.clear();
		clickOnConvergenceBox2.sendKeys(convergence_value[1]);

		// fill DivergenceBox 1 and 2
		String[] dievergence_value = divergence.split("/");
		ClickOnDivergenceBox1.clear();
		ClickOnDivergenceBox1.sendKeys(dievergence_value[0]);
		ClickOnDivergenceBox2.clear();
		ClickOnDivergenceBox2.sendKeys(dievergence_value[1]);

		// click On NearpointOfConvergence
		Thread.sleep(2000);
		clickOnNearpointOfConvergence.clear();
		clickOnNearpointOfConvergence.sendKeys(nearPoint);

		// click On OD
		Thread.sleep(2000);
		clickOnOD.clear();
		clickOnOD.sendKeys(convergence);

		// click On OS
		Thread.sleep(2000);
		clickOnOS.clear();
		clickOnOS.sendKeys(divergence);

		if (!clickOnCoOperationCheckBox.isSelected() && Operation) {
			clickOnCoOperationCheckBox.click();
		}

		// click On Fly and select fly value
		Thread.sleep(2000);
		clickOnFly.click();

		Thread.sleep(2000);
		List<WebElement> fly_Value = driver
				.findElements(By.cssSelector("#gwt-debug-sensorimotor-stereoTesting-titmusFly>div:nth-child(2)>div"));
		for (int i = 1; i <= fly_Value.size() - 1; i++)
			if (fly_Value.get(i).getText().equalsIgnoreCase(fly)) {
				fly_Value.get(i).click();
				break;
			}

		// click On Circles and select circles value
		Thread.sleep(2000);
		clickOnCircles.click();

		Thread.sleep(2000);
		List<WebElement> circles_Value = driver.findElements(
				By.cssSelector("#gwt-debug-sensorimotor-stereoTesting-titmusCircles>div:nth-child(2)>div"));
		for (int i = 1; i <= circles_Value.size() - 1; i++)
			if (circles_Value.get(i).getText().equalsIgnoreCase(circles)) {
				circles_Value.get(i).click();
				break;
			}

		// click On Animals and select animal value
		Thread.sleep(2000);
		clickOnAnimals.click();

		Thread.sleep(2000);
		List<WebElement> animals_Value = driver.findElements(
				By.cssSelector("#gwt-debug-sensorimotor-stereoTesting-titmusAnimals>div:nth-child(2)>div"));
		for (int i = 1; i <= animals_Value.size() - 1; i++)
			if (animals_Value.get(i).getText().equalsIgnoreCase(animals)) {
				animals_Value.get(i).click();
				break;
			}
		// click On lang
		Thread.sleep(2000);
		clickOnlang.click();

		// select lang_Value
		Thread.sleep(2000);

		WebElement lang_Value = driver.findElement(
				By.cssSelector("#gwt-debug-sensorimotor-stereoTesting-lang>div:nth-child(2)>div:nth-child(2)"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lang_Value);

		// click On Dropdown and select drop down value
		Thread.sleep(2000);
		clickOnDropdown.click();

		Thread.sleep(2000);
		List<WebElement> dropdown_Value = driver
				.findElements(By.cssSelector("#gwt-debug-sensorimotor-stereoTesting-otherResult>div:nth-child(2)>div"));
		for (int i = 1; i <= dropdown_Value.size() - 1; i++)
			if (dropdown_Value.get(i).getText().equalsIgnoreCase(dropdown)) {
				dropdown_Value.get(i).click();
				break;
			}

		// fill value In OtherText
		Thread.sleep(2000);
		fillvalueInOtherText.sendKeys(other);

		// click On Distance and selct distance value
		Thread.sleep(2000);
		clickOnDistance.click();

		Thread.sleep(2000);
		List<WebElement> distance_Value = driver
				.findElements(By.cssSelector("#gwt-debug-sensorimotor-worthDistance>div:nth-child(2)>div"));
		for (int i = 1; i <= distance_Value.size() - 1; i++)
			if (distance_Value.get(i).getText().equalsIgnoreCase(distance)) {
				distance_Value.get(i).click();
				break;
			}

		// click On Near and select near value
		Thread.sleep(2000);
		clickOnNear.click();

		Thread.sleep(2000);
		List<WebElement> near_Value = driver
				.findElements(By.cssSelector("#gwt-debug-sensorimotor-worthNear>div:nth-child(2)>div"));
		for (int i = 1; i <= near_Value.size() - 1; i++)
			if (near_Value.get(i).getText().equalsIgnoreCase(near)) {
				near_Value.get(i).click();
				break;
			}

		// click On FixationPrefrences and select value
		Thread.sleep(2000);
		clickOnFixationPrefrences.click();

		Thread.sleep(2000);
		List<WebElement> fixation_Value = driver
				.findElements(By.cssSelector("#gwt-debug-sensorimotor-fixationPreference>div:nth-child(2)>div"));
		for (int i = 1; i <= fixation_Value.size() - 1; i++)
			if (fixation_Value.get(i).getText().equalsIgnoreCase(fixation)) {
				fixation_Value.get(i).click();
				break;
			}

		// click On Nystagmus and selct value
		Thread.sleep(2000);
		clickOnNystagmus.click();

		Thread.sleep(2000);
		List<WebElement> nystagmus_Value = driver
				.findElements(By.cssSelector("#gwt-debug-sensorimotor-nystagmus>div:nth-child(2)>div"));
		for (int i = 1; i <= nystagmus_Value.size() - 1; i++)
			if (nystagmus_Value.get(i).getText().equalsIgnoreCase(nystagmus)) {
				nystagmus_Value.get(i).click();
				break;
			}
		//
		// Thread.sleep(5000);
		// clickOnClerall.click();
		// click On Edit

		// call method
		Thread.sleep(2000);
		clickOnEdit.click();

		Thread.sleep(2000);
		colorVision(comment1, comment2, quries, rightEye, leftEye);

		// click On comment1
		Thread.sleep(2000);
		clickOncomment1.clear();
		clickOncomment1.sendKeys(comment1);

		// click On comment2
		Thread.sleep(2000);
		clickOnComment2.clear();
		clickOnComment2.sendKeys(comment2);

		// click On comment3
		Thread.sleep(2000);
		clickOncomment3.clear();
		clickOncomment3.sendKeys(comment3);

		// click On Interpretation
		Thread.sleep(2000);
		clickOnInterpretation.clear();
		clickOnInterpretation.sendKeys(interpretation);

		// click On HeadPosition
		Thread.sleep(2000);
		clickOnHeadPosition.click();

		// select headPosition_Value
		Thread.sleep(2000);
		Thread.sleep(2000);
		List<WebElement> headPosition_Value = driver
				.findElements(By.cssSelector("#gwt-debug-sensorimotor-headTilt-position>div:nth-child(2)>div"));
		for (int i = 1; i <= headPosition_Value.size() - 1; i++)
			if (headPosition_Value.get(i).getText().equalsIgnoreCase(headPosition)) {
				headPosition_Value.get(i).click();
				break;
			}
		// close The Fillwindow
		Thread.sleep(5000);
		closeTheFillwindow.click();

		// close SensoromotorExam
		Thread.sleep(5000);
		closeSensoromotorExam.click();

		// click On SupplementalExam
		Thread.sleep(5000);
		clickOnSupplementalExam.click();

		// match all given and pdf of SensorimotorExam
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				matchSensorimotor);
		System.out.println(matchSensorimotor);
		Thread.sleep(5000);
		String coloredsensorimotorExamText = matchSensorimotor.getText();
		int l = sensorimotorExamText.length();
		System.out.println(l);
		String actualExamvalue = sensorimotorExamText.substring(4, 21);
		System.out.println(actualExamvalue);
		Thread.sleep(8000);
		if (actualExamvalue.equalsIgnoreCase(coloredsensorimotorExamText)) {
			//JavascriptExecutor js3 = (JavascriptExecutor) driver;
			//js3.executeScript(" arguments[0].click() ", clickOnCodingTab);

			Reporter.log(sensorimotorExamText + " " + "Match" + " " + coloredsensorimotorExamText);
		}
		// Thread.sleep(5000);
		// String strCodingSensorimotor = codingSensorimotor.getText();
		// if (actualExamvalue.equalsIgnoreCase(strCodingSensorimotor)) {
		// JavascriptExecutor js4 = (JavascriptExecutor) driver;
		// js4.executeScript(" arguments[0].click() ", clickOnCliniNote);
		// Reporter.log("Successfully open Clinic note page");
		//
		// }
		// clickOnMyDashBoard.click();
		viewDocumentInDocumentCenter();

	}

	public void colorVision(String comment1, String comment2, String quries, String rightEye, String leftEye)
			throws Exception {

		// click On TextOther
		Thread.sleep(2000);
		clickOnTextOther.clear();
		Thread.sleep(2000);
		clickOnTextOther.sendKeys(comment1);

		// click On TextComments
		Thread.sleep(2000);
		clickOnTextComments.clear();
		Thread.sleep(2000);
		clickOnTextComments.sendKeys(comment2);

		// selct quries value
		Thread.sleep(6000);
		List<WebElement> quries_Value = driver.findElements(By.xpath(
				"//table[@id=\"# Queries\"]/tbody/tr/td/div//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= quries_Value.size() - 1; i++)
			if (quries_Value.get(i).getText().equalsIgnoreCase(quries)) {
				quries_Value.get(i).click();
				break;
			}

		// selct rightEye_Value
		Thread.sleep(7000);
		List<WebElement> rightEye_Value = driver.findElements(By.xpath(
				"//div[@id=\"gwt-debug-rightCorrectAnswers\"]/table/tbody/tr[2]/td/div//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= rightEye_Value.size() - 1; i++)
			if (rightEye_Value.get(i).getText().equalsIgnoreCase(rightEye)) {
				rightEye_Value.get(i).click();
				break;
			}

		// select leftEye_Value
		Thread.sleep(7000);
		List<WebElement> leftEye_Value = driver.findElements(By.xpath(
				"//div[@id=\"gwt-debug-leftCorrectAnswers\"]/table/tbody/tr[2]/td/div//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= leftEye_Value.size() - 1; i++)
			if (leftEye_Value.get(i).getText().equalsIgnoreCase(leftEye)) {
				leftEye_Value.get(i).click();
				break;
			}

		// click On Done
		Thread.sleep(5000);
		clickOnDone.click();

	}

	public void viewDocumentInDocumentCenter() throws Exception {
		// click on Document center
		Thread.sleep(5000);
		clickOnDocumentCenter.click();

		// select_Documents
		Thread.sleep(2000);
		List<WebElement> select_Documents = driver
				.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase("Sensorimotor Reports")) {
				select_Documents.get(i).click();
				break;
			}
		
		Thread.sleep(2000);
		clickOnViewBtn.click();
	}
}
