package pages;

import static org.testng.Assert.assertEquals;

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

public class PgAddEyeHistoryValues {

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget > a")
	private WebElement joinOpenEncounterBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-openEncounterTable > tbody")
	private WebElement encounterContainer;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody > tr > td:nth-child(2) > div")
	private WebElement eyeHistoryLink;

	private WebDriver driver;
	private WebDriverWait wait;
	@SuppressWarnings("unused")
	private Actions actions;

	public PgAddEyeHistoryValues(WebDriver driver, WebDriverWait wait, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}

	public void addPastEyeProblem(String encounterDate, String historyCatagory1, String historyCatagory2,
			String historyCatagory3, String historyCatagory4, String time, String timeType)
			throws InterruptedException {
		String lastHistoryCatagory = "";

		WebElement encounter = getEncounter(encounterDate);
		ensureElementToBeClickable(encounter);
		encounter.click();
		ensureElementToBeClickable(eyeHistoryLink);
		eyeHistoryLink.click();

		// Start adding past eye history

		By addPastEyeLink = By.cssSelector(
				"#gwt-debug-eyeHistory-pastProblemsWidget > div > div > div > div:nth-child(1) > .gwt-InlineLabel");
		ensureElementToBeClickable(addPastEyeLink);
		driver.findElement(addPastEyeLink).click();

		Thread.sleep(5 * 1000);

		if (historyCatagory1 != null && !historyCatagory1.equals("")) {
			lastHistoryCatagory = historyCatagory1;
			addValue(historyCatagory1);
			Thread.sleep(2 * 1000);
		}

		if (historyCatagory2 != null && !historyCatagory2.equals("")) {
			lastHistoryCatagory = historyCatagory2;
			addValue(historyCatagory2);
			Thread.sleep(2 * 1000);
		}

		if (historyCatagory3 != null && !historyCatagory3.equals("")) {
			lastHistoryCatagory = historyCatagory3;
			addValue(historyCatagory3);
			Thread.sleep(2 * 1000);
		}

		if (historyCatagory4 != null && !historyCatagory4.equals("")) {
			lastHistoryCatagory = historyCatagory4;
			addValue(historyCatagory4);
			Thread.sleep(2 * 1000);
		}

		By timeBox = By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[6]/div[2]/div[1]/div[2]/input");
		ensureElementToBeClickable(timeBox);
		driver.findElement(timeBox).sendKeys(time);

		By timeTypeBox = By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[6]/div[2]/div[1]/div[2]/div/div[3]");
		ensureElementToBeClickable(timeTypeBox);
		driver.findElement(timeTypeBox).click();

		String timeTypwDropDownSelector = ".gwt-PopupPanel > div > div > div > div:last-child";
		By dropDownBox = By.cssSelector(timeTypwDropDownSelector);
		ensureElementToBeClickable(dropDownBox);
		if (timeType.equalsIgnoreCase("year")) {
			timeTypwDropDownSelector += " > div:nth-child(1)";
			driver.findElement(By.cssSelector(timeTypwDropDownSelector)).click();
		} else if (timeType.equalsIgnoreCase("month")) {
			timeTypwDropDownSelector += " > div:nth-child(2)";
			driver.findElement(By.cssSelector(timeTypwDropDownSelector)).click();
		} else if (timeType.equalsIgnoreCase("day")) {
			timeTypwDropDownSelector += " > div:nth-child(3)";
			driver.findElement(By.cssSelector(timeTypwDropDownSelector)).click();
		}

		By doneBtn = By.xpath(".//*[text()='Done']");
		ensureElementToBeClickable(doneBtn);
		driver.findElement(doneBtn).click();

		By lastAddedValue = By.cssSelector(
				"#gwt-debug-eyeHistory-pastProblemsWidget > div > div:nth-child(2) > div:last-child > div:nth-child(2) > span");
		ensureElementToBeClickable(lastAddedValue);
		String lastValue = driver.findElement(lastAddedValue).getText();
		Thread.sleep(3 * 1000);
		assertEquals(lastValue.toLowerCase(), lastHistoryCatagory.toLowerCase());

	}

	public void addPriorEyeSurgery(String encounterDate, String historyCatagory1, String historyCatagory2,
			String historyCatagory3, String historyCatagory4, String time, String timeType)
			throws InterruptedException {

		String lastHistoryCatagory = null;

		By addPriorEyeSurgeryLink = By.cssSelector("#gwt-debug-add-eyeSurgery-eyeHistory");
		ensureElementToBeClickable(addPriorEyeSurgeryLink);
		driver.findElement(addPriorEyeSurgeryLink).click();

		Thread.sleep(5 * 1000);

		if (historyCatagory1 != null && !historyCatagory1.equals("")) {
			lastHistoryCatagory = historyCatagory1;
			addValue(historyCatagory1);
			Thread.sleep(2 * 1000);
		}

		if (historyCatagory2 != null && !historyCatagory2.equals("")) {
			lastHistoryCatagory = historyCatagory2;
			addValue(historyCatagory2);
			Thread.sleep(2 * 1000);
		}

		if (historyCatagory3 != null && !historyCatagory3.equals("")) {
			lastHistoryCatagory = historyCatagory3;
			addValue(historyCatagory3);
			Thread.sleep(2 * 1000);
		}

		if (historyCatagory4 != null && !historyCatagory4.equals("")) {
			lastHistoryCatagory = historyCatagory4;
			addValue(historyCatagory4);
			Thread.sleep(2 * 1000);
		}

		By timeBox = By.cssSelector(".blue_text > div > div:nth-child(2) > div > div:nth-child(2) > input");
		ensureElementToBeClickable(timeBox);
		driver.findElement(timeBox).sendKeys(time);

		By timeTypeBox = By.cssSelector(".blue_text > div > div:nth-child(2) > div > div:nth-child(2) > div");
		ensureElementToBeClickable(timeTypeBox);
		driver.findElement(timeTypeBox).click();

		String timeTypwDropDownSelector = ".gwt-PopupPanel > div > div > div > div:last-child";
		By dropDownBox = By.cssSelector(timeTypwDropDownSelector);
		ensureElementToBeClickable(dropDownBox);
		if (timeType.equalsIgnoreCase("year")) {
			timeTypwDropDownSelector += " > div:nth-child(1)";
			driver.findElement(By.cssSelector(timeTypwDropDownSelector)).click();
		} else if (timeType.equalsIgnoreCase("month")) {
			timeTypwDropDownSelector += " > div:nth-child(2)";
			driver.findElement(By.cssSelector(timeTypwDropDownSelector)).click();
		} else if (timeType.equalsIgnoreCase("day")) {
			timeTypwDropDownSelector += " > div:nth-child(3)";
			driver.findElement(By.cssSelector(timeTypwDropDownSelector)).click();
		}

		By doneBtn = By.xpath(".//*[text()='Done']");
		ensureElementToBeClickable(doneBtn);
		driver.findElement(doneBtn).click();

		By lastAddedValue = By.cssSelector(
				".eye_history > div:nth-child(3) > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1)");
		ensureElementToBeClickable(lastAddedValue);
		String lastValue = driver.findElement(lastAddedValue).getText();
		Thread.sleep(3 * 1000);
		assertEquals(lastValue.toLowerCase(), lastHistoryCatagory.toLowerCase());
	}

	public void addOcularMedications(String encounterDate, String historyCatagory1, String historyCatagory2,
			String historyCatagory3, String historyCatagory4, String time, String timeType)
			throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void addTodayExamValue(String encounterDate, String historyCatagory1, String historyCatagory2,
			String historyCatagory3, String historyCatagory4, String time, String timeType)
			throws InterruptedException {
		// TODO Auto-generated method stub

	}

	private WebElement getEncounter(String encounterDate) throws InterruptedException {
		ensureElementToBeClickable(joinOpenEncounterBtn);
		joinOpenEncounterBtn.click();
		ensureElementToBeClickable(encounterContainer);
		Thread.sleep(2 * 1000);
		By encounter = By.xpath("//*[text()='" + encounterDate.trim() + "']");
		ensureElementToBeClickable(encounter);
		return driver.findElements(encounter).get(0);
	}

	private void addValue(String historyCatagory) {
		By value = By.xpath("//*[text() = '" + historyCatagory + "']");
		List<WebElement> elements = driver.findElements(value);
		int size = elements.size();
		WebElement element = null;
		if (size > 1) {
			element = elements.get(size - 1);
			ensureElementToBeClickable(element);
			element.click();
		} else {
			element = elements.get(0);
			ensureElementToBeClickable(element);
			element.click();
		}
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
