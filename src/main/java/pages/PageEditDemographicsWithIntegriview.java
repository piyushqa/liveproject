package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageEditDemographicsWithIntegriview {
	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	@FindBy(how = How.CSS, using = "div#gwt-debug-editPatient")
	private WebElement clckOnEditDemographics;

	@FindBy(how = How.CSS, using = "div#gwt-debug-edit>a")
	private WebElement clickOnEdit;

	@FindBy(how = How.CSS, using = "input#gwt-debug-pmMrn")
	private WebElement inputMrn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[8]/div[2]/a")
	private WebElement clickOnDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-demographicsDone>a")
	private WebElement clickOnDemographicsDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-pdIntegriView")
	private WebElement clickOnIntegriview;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Close IntegriView')]")
	private WebElement ClickOnCloseIntegriview;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageEditDemographicsWithIntegriview(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageEditDemographicsWithIntegriview.this);
	}

	public void verifyEditDemographicsWithIntegriview(String mrn) throws Exception {

		Thread.sleep(6000);
		ensureElementToBeClickable(clckOnEditDemographics);
		clckOnEditDemographics.click();

		editDemographics(mrn);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnIntegriview);
		clickOnIntegriview.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(ClickOnCloseIntegriview);
		ClickOnCloseIntegriview.click();
	}

	public void editDemographics(String mrn) throws Exception {
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnEdit);
		clickOnEdit.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(inputMrn);
		Random random = new Random();
		int n1 = 1000 + random.nextInt();
		inputMrn.clear();
		mrn = Integer.toString(n1);
		inputMrn.sendKeys(mrn);

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDemographicsDone);
		clickOnDemographicsDone.click();
	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
