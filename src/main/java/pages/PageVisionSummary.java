
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

public class PageVisionSummary {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */

	@FindBy(how = How.CSS, using = "a#gwt-debug-visionSummaryLink")
	private WebElement clickOnVisionSummaryLink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-firstSummaryWidget\"]/div/div[2]/div/div[1]/div[3]")
	private WebElement clickOnGlassDropDown;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/div/div[2]/div")
	private List<WebElement> select_Glass;

	@FindBy(how = How.CSS, using = "a#gwt-debug-Done.gwt-Anchor")
	private WebElement clickOnDone;

	public PageVisionSummary(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageVisionSummary.this);
	}

	public void perfromVisionSummaryOperation(String provider, String glass) throws Exception {

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnVisionSummaryLink);
		clickOnVisionSummaryLink.click();

		visionSummaryOperation(glass);
	}

	public void visionSummaryOperation(String glass) throws Exception {
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnGlassDropDown);
		clickOnGlassDropDown.click();

		Thread.sleep(2000);
		for (WebElement selectGlass : select_Glass) {
			if (selectGlass.getText().equalsIgnoreCase("Refraction")) {
				selectGlass.click();
				break;
			}
		}
		Thread.sleep(5000);
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
