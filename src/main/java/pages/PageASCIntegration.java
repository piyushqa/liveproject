package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ProjectSettings;

public class PageASCIntegration {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/section/div/span[1]")
	private List<WebElement> getASCIntegrationText;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/section/div[5]/input")
	private WebElement getASCIntegration;

	@FindBy(how = How.CSS, using = "div#gwt-debug-surgeryModule")
	private WebElement clickOnSurgeryModule;

	@FindBy(how = How.CSS, using = "div#gwt-debug-newSurgeryLink>a")
	private WebElement clickScheduledNewSurgery;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//a[text()=\"Send to ASC\"]"),
			@FindBy(how = How.CSS, using = "#content > div > div > div> div > div:nth-child(4) > div > div:nth-child(6) > div > a") })
	private WebElement checkAvalibilityOfASC;

	@FindAll({ @FindBy(how = How.XPATH, using = "//div[starts-with(text(),'Preview ASC documents')]"),
			@FindBy(how = How.CSS, using = "#content > div > div > div> div > div:nth-child(4) > div> div:nth-child(7) > div > div.gwt-Label") })
	private WebElement checkAvalibilityOfPreviewASCDocuments;

	@FindBy(how = How.CSS, using = "body > div.gwt-PopupPanel > div > div > div > div > div.datalist-item")
	private List<WebElement> checkAvalibilityOfListItem;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Cancel>a")
	private WebElement clickOnCancel;

	@FindBy(how = How.CSS, using = "div#gwt-debug-closeSurgeriesLink>a")
	private WebElement clickOnCloseSurgery;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageASCIntegration(WebDriverWait wait, WebDriver driver, Actions builder) {
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageASCIntegration.this);
	}

	public void verifyASCIntegration(String fName, String lName) throws Exception {

		new PageReconFin(driver, wait, builder).handleIntegritySettings();

		Thread.sleep(4000);
		String ASCIntegration = performASCSettingIntegrationOpertion("enableASCIntegration");
		System.out.println(ASCIntegration);

		if (ASCIntegration.equalsIgnoreCase("true")) {
			performCommonOperationWithAllCondition(fName, lName);

			boolean buttonAvbility = checkAvbilityOfASCButton(getASCIntegration, checkAvalibilityOfPreviewASCDocuments,
					checkAvalibilityOfListItem);
			System.out.println(buttonAvbility);
			System.out.println("ASC scaffold is true and hence Preview doc and Send to ASC buttons are enabled");

			//closeSurgery();

		} else if (ASCIntegration.equalsIgnoreCase("false")) {

			try {
				performCommonOperationWithAllCondition(fName, lName);
				boolean buttonAvbility = checkAvbilityOfASCButton(getASCIntegration,
						checkAvalibilityOfPreviewASCDocuments, checkAvalibilityOfListItem);
				System.out.println(buttonAvbility);
				//closeSurgery();
				System.out.println("ASC scaffold is false and hence Preview doc and Send to ASC buttons are disabled");
			} catch (NoSuchElementException ex) {
				System.out.println("ASC scaffold is false and hence Preview doc and Send to ASC buttons are disabled");
			}
		} else {
			System.out.println("Nothing to display first enable ASC scaffold");
		}
	}

	public void openSurgery() throws Exception {

		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnSurgeryModule);
		clickOnSurgeryModule.click();

		Thread.sleep(2000);
		ensureElememtToBeClickable(clickScheduledNewSurgery);
		clickScheduledNewSurgery.click();
	}

	public String performASCSettingIntegrationOpertion(String value) throws Exception {
		String getText1 = null;
		int length = getASCIntegrationText.size();
		Thread.sleep(3000);
		for (int i = 0; i <= length;i++) {
			if (getASCIntegrationText.get(i).getText().equals(value)) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(2000);
				i = i + 1;
				getText1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/section/div[" + i + "]/input"))
						.getAttribute("value");
				System.out.println("Element:" + getText1);

				break;
			}

		}
		return getText1;
	}

	public void performCommonOperationWithAllCondition(String fName, String lName) throws Exception {
		Thread.sleep(5000);
		driver.navigate().back();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		new PageReconFin(driver, wait, builder).logInFunction(ProjectSettings.userName, ProjectSettings.password);

		new PageCloseEncounterWithPopUp(wait, driver, builder).serchPatient(fName, lName);

		openSurgery();
	}

	public boolean checkAvbilityOfASCButton(WebElement element1, WebElement element2, List<WebElement> element3)
			throws Exception {

		boolean value = checkAvalibilityOfASC.isDisplayed();
		System.out.println(value);

		value = checkAvalibilityOfPreviewASCDocuments.isDisplayed();
		System.out.println(value);

		Thread.sleep(3000);
		checkAvalibilityOfPreviewASCDocuments.click();

		for (WebElement chek_AvalibilityOfListItem : element3) {
			value = chek_AvalibilityOfListItem.isDisplayed();
		}

		return value;
	}

	public void closeSurgery() throws Exception {
		Thread.sleep(2000);
		clickOnCancel.click();

		Thread.sleep(3000);
		clickOnCloseSurgery.click();
	}

	// function is used for visibility and clickAble of WebElements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
