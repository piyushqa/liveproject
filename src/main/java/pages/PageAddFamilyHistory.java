package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAddFamilyHistory {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	@FindBy(how = How.CSS, using = "div.encounter_tab_bar_container>table>tbody>tr>td:nth-child(3)>div")
	private WebElement clickOnOtherHistory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-familyHistoryaddFamilyHistory")
	private WebElement clickOnAddFamilyHistory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-relationships-container>div")
	private List<WebElement> select_RelationShip;

	@FindBy(how = How.CSS, using = "div#gwt-debug-eyeProblem-container>div")
	private List<WebElement> select_EyeProblems;

	@FindBy(how = How.CSS, using = "div#gwt-debug-medicalProblem-container>div")
	private List<WebElement> select_MedicalProblems;

	@FindBy(how = How.CSS, using = "a#gwt-debug-Done.gwt-Anchor")
	private WebElement clickOnDone;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageAddFamilyHistory(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddFamilyHistory.this);
	}

	public void performFamilyHistory(String provider, String relationship, String eyeProblems, String medicalProblems)
			throws Exception {
		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		ensureElementToBeClickable(clickOnOtherHistory);
		clickOnOtherHistory.click();

		familyHistoryOperation(relationship, eyeProblems, medicalProblems);

	}

	public void familyHistoryOperation(String relationship, String eyeProblems, String medicalProblems)
			throws Exception {

		ensureElementToBeClickable(clickOnAddFamilyHistory);
		clickOnAddFamilyHistory.click();

		Thread.sleep(4000);
		for (WebElement selectRelationship : select_RelationShip) {
			if (selectRelationship.getText().equalsIgnoreCase(relationship)) {
				selectRelationship.click();
				break;
			}
		}

		Thread.sleep(4000);
		for (WebElement selecteyeProblems : select_EyeProblems) {
			if (selecteyeProblems.getText().equalsIgnoreCase(eyeProblems)) {
				selecteyeProblems.click();
				break;
			}
		}
		Thread.sleep(4000);
		for (WebElement selectMedicalProblems : select_MedicalProblems) {
			if (selectMedicalProblems.getText().equalsIgnoreCase(medicalProblems)) {
				selectMedicalProblems.click();
				break;
			}
		}
		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();

	}

	// function use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
