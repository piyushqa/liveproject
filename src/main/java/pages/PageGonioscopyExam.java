package pages;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
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

public class PageGonioscopyExam {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.CSS, using = ".encounter_tab_bar_container>table>tbody>tr>td:nth-child(8)>div")
	private WebElement clickOnExam;

	@FindBy(how = How.CSS, using = "#gwt-debug-supplementalExams-button>div:last-child")
	private WebElement clickOnSupplimentExam;

	@FindBy(how = How.CSS, using = "#gwt-debug-supplementalExams-container>div")
	private List<WebElement> clickOnGonioscopyExam;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-rightInferior\"]/table/tbody/tr/td//div[text()=\"Angle:\"]")
	private WebElement clickOnInferior;

	@FindBy(how = How.CSS, using = "input#gwt-debug-rightComments")
	private WebElement fillTheRightsComments;

	@FindBy(how = How.CSS, using = "input#gwt-debug-leftComments")
	private WebElement fillTheLeftComments;

	@FindBy(how = How.CSS, using = "#gwt-debug-angleApproachWidget-container>table>tbody>tr>td>div")
	private List<WebElement> clickOnAngleApproach;

	@FindBy(how = How.CSS, using = "#gwt-debug-pigmentWidget-container>div")
	private List<WebElement> clickOnPigment;

	@FindBy(how = How.CSS, using = "#gwt-debug-irisContourWidget-container>div")
	private List<WebElement> clickOnIrisContourWidget;

	@FindBy(how = How.CSS, using = "#gwt-debug-structuresWidget-container>div")
	private List<WebElement> clickOnStructuresWidget;

	@FindBy(how = How.CSS, using = "#gwt-debug-abnormalitiesWidget-container>table>tbody>tr>td>div")
	private List<WebElement> clickOnAbnormalitiesWidget;

	@FindBy(how = How.XPATH, using = ".//a[contains(@id,'gwt-debug-doneButton') and (contains(text(),'Done'))]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-supplementalExams\"]/div[2]/div[2]")
	private WebElement matchGonioscopyExam;

	public PageGonioscopyExam(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageGonioscopyExam.this);
	}

	public void verfiryGonioscopyExam(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges, String selectExam, String angleApproach, String pigment, String irisContourWidget,
			String structuresWidget, String abnormalities) throws Exception {

		Thread.sleep(2000);
		PageCloseEncounter openEncounter = new PageCloseEncounter(wait, driver, builder);
		openEncounter.openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, significantProblem);

		Thread.sleep(2000);
		gonioscopyExam(selectExam, angleApproach, pigment, irisContourWidget, structuresWidget, abnormalities);

		Thread.sleep(2000);
		openEncounter.closeEncounter(visitType, noCharges);
	}

	public void gonioscopyExam(String selectExam, String angleApproach, String pigment, String irisContourWidget,
			String structuresWidget, String abnormalities) throws Exception {
		Thread.sleep(2000);
		ensureElementToBeClickAble(clickOnExam);
		clickOnExam.click();

		Thread.sleep(2000);
		ensureElementToBeClickAble(clickOnSupplimentExam);
		clickOnSupplimentExam.click();

		Thread.sleep(3000);
		for (WebElement select_Exam : clickOnGonioscopyExam) {
			if (select_Exam.getText().equalsIgnoreCase(selectExam)) {
				select_Exam.click();
				break;
			}

		}

		Thread.sleep(2000);
		ensureElementToBeClickAble(clickOnInferior);
		clickOnInferior.click();

		Thread.sleep(1000);
		ensureElementToBeClickAble(fillTheRightsComments);
		fillTheRightsComments.sendKeys("check the data from Right eye inferor");

		Thread.sleep(1000);
		ensureElementToBeClickAble(fillTheLeftComments);
		fillTheLeftComments.sendKeys("fill the comments of left eye ");

		Thread.sleep(2000);
		for (WebElement select_AngleApproach : clickOnAngleApproach) {
			if (select_AngleApproach.getText().equalsIgnoreCase(angleApproach)) {
				select_AngleApproach.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_Pigment : clickOnPigment) {
			if (select_Pigment.getText().equalsIgnoreCase(pigment)) {
				select_Pigment.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_IrisContourWidget : clickOnIrisContourWidget) {
			if (select_IrisContourWidget.getText().equalsIgnoreCase(irisContourWidget)) {
				select_IrisContourWidget.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_StructuresWidget : clickOnStructuresWidget) {
			if (select_StructuresWidget.getText().equalsIgnoreCase(structuresWidget)) {
				select_StructuresWidget.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_AbnormalitiesWidget : clickOnAbnormalitiesWidget) {
			if (select_AbnormalitiesWidget.getText().equalsIgnoreCase(abnormalities)) {
				select_AbnormalitiesWidget.click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickAble(clickOnDoneBtn);
		clickOnDoneBtn.click();

		Thread.sleep(2000);
		ensureElementToBeClickAble(clickOnSupplimentExam);
		clickOnSupplimentExam.click();

		Thread.sleep(4000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid blue;');",
				matchGonioscopyExam);

		Thread.sleep(4000);
		String storeHeighlitedText = matchGonioscopyExam.getText();

		Assert.assertEquals(storeHeighlitedText, selectExam);
		{
			Reporter.log(storeHeighlitedText + " " + "match with" + " " + selectExam);
		}

	}

	public void ensureElementToBeClickAble(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
