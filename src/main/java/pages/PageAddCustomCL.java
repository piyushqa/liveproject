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

public class PageAddCustomCL {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;

	@FindBy(how = How.CSS, using = "span#gwt-debug-addNewContactLens")
	private WebElement clickOnAddNewCL;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[5]/td/div/div[2]/div[1]/div[2]/input[1]")
	private WebElement clickRightEyeSphere;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/table/tbody/tr/td")
	private List<WebElement> selectRightEyeSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[3]/table/tbody/tr[5]/td/div/div[2]/div[1]/div[2]/input[1]")
	private WebElement clickLeftEyeSphere;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/table/tbody/tr/td")
	private List<WebElement> selectLeftEyeSphere;

	@FindBy(how = How.CSS, using = "a#gwt-debug-lens-odCustom")
	private WebElement clickOnCustom;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[6]/td/div/div[2]/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/input")
	private WebElement fillValueOfLensMake;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[6]/td/div/div[2]/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")
	private WebElement fillValueOfDC1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[6]/td/div/div[2]/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input")
	private WebElement fillValueOfDc2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[6]/td/div/div[2]/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[4]/table/tbody/tr[2]/td/input")
	private WebElement fillValueOfDiam;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[6]/td/div/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")
	private WebElement fillValueOfColor;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Add/Update to Custom Library\"]")
	private WebElement clickOnAddUpdateLibrary;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Add Lens\"]")
	private WebElement clickOnAddLens;

	@FindBy(how = How.CSS, using = "input#gwt-debug-rightCentral")
	private WebElement fillName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div")
	private List<WebElement> clickOnCylinder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[2]/div[2]/div[3]/div[2]/div[2]/div")
	private List<WebElement> clickOnType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[2]/div[2]/div[5]/div[2]/div/div[3]")
	private WebElement clickSelectValue;

	@FindBy(how = How.XPATH, using = "/html/body/div[13]/div/div/div/div[2]/div")
	private List<WebElement> selectAnyValue;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[2]/div[2]/div[7]/div[2]/div/input[1]")
	private WebElement fillValueInBC1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[2]/div[2]/div[7]/div[2]/div/input[2]")
	private WebElement fillValueInBC2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[2]/div[2]/div[7]/div[2]/div/input[3]")
	private WebElement fillValueInBC3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[2]/div[2]/div[7]/div[2]/div/input[4]")
	private WebElement fillValueInBC4;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Save\"]")
	private WebElement clickOnSave;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private List<WebElement> clickOnClose;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/table/tbody/tr/td[1]/div/a")
	private WebElement clickOnShowAll;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lens-copyRight\"]")
	private WebElement clickOnCopyRightEye;

	@FindBy(how = How.CSS, using = "div#gwt-debug-popup-done>a")
	private WebElement ClickOnCLDone;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageAddCustomCL(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddCustomCL.this);
	}

	public void verifyAddCustomCL(String provider, String selectRightSphere, String selectLeftSphere, String name,
			String cylinder, String type, String selectValue, String BC1, String BC2, String diam, String color)
			throws Exception {

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		Thread.sleep(6000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVisonTab)).click();
		
		//performCustomCL(selectRightSphere, selectLeftSphere);
		
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnAddNewCL);
		clickOnAddNewCL.click();
		
		addNewLense(name, cylinder, type, selectValue, BC1, BC2, diam, color);
		
		AddContactLens(name);

	}

	public void performCustomCL(String selectRightSphere, String selectLeftSphere) throws Exception {
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnAddNewCL);
		clickOnAddNewCL.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickRightEyeSphere);
		clickRightEyeSphere.click();

		Thread.sleep(2000);
		for (WebElement select_RightEyeSphere : selectRightEyeSphere) {
			if (select_RightEyeSphere.getText().equalsIgnoreCase(selectRightSphere)) {
				select_RightEyeSphere.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(clickLeftEyeSphere);
		clickLeftEyeSphere.click();

		Thread.sleep(2000);
		for (WebElement select_LeftEyeSphere : selectLeftEyeSphere) {
			if (select_LeftEyeSphere.getText().equalsIgnoreCase(selectLeftSphere)) {
				select_LeftEyeSphere.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnCustom);
		clickOnCustom.click();
	}

	public void addNewLense(String name, String cylinder, String type, String selectValue, String BC1, String BC2,
			String diam, String color) throws Exception {

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnAddUpdateLibrary);
		clickOnAddUpdateLibrary.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnAddLens);
		clickOnAddLens.click();

		Thread.sleep(1000);
		ensureElementToBeClickable(fillName);
		fillName.sendKeys(name);

		Thread.sleep(1000);
		for (WebElement select_Cylinder : clickOnCylinder) {
			if (select_Cylinder.getText().equalsIgnoreCase(cylinder)) {
				select_Cylinder.click();
				break;
			}
		}

		Thread.sleep(1000);
		for (WebElement select_Type : clickOnType) {
			if (select_Type.getText().equalsIgnoreCase(type)) {
				select_Type.click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickSelectValue);
		clickSelectValue.click();

		Thread.sleep(1000);
		for (WebElement select_AnyValue : selectAnyValue) {
			if (select_AnyValue.getText().equalsIgnoreCase(selectValue)) {
				select_AnyValue.click();
				break;
			}
		}

		Thread.sleep(1000);
		ensureElementToBeClickable(fillValueInBC1);
		fillValueInBC1.sendKeys(BC1);

		Thread.sleep(1000);
		ensureElementToBeClickable(fillValueInBC2);
		fillValueInBC2.sendKeys(BC2);

		Thread.sleep(1000);
		ensureElementToBeClickable(fillValueInBC3);
		fillValueInBC3.sendKeys(diam);

		Thread.sleep(1000);
		ensureElementToBeClickable(fillValueInBC4);
		fillValueInBC4.sendKeys(color);

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnSave);
		clickOnSave.click();

		Thread.sleep(2000);
		clickOnClose.get(1).click();

	}

	public void AddContactLens(String name) throws Exception {
		// click on LensMake
		Thread.sleep(5000);
		By clickOnLensMake1 = By.xpath("//*[@id=\"gwt-debug-lensPopup-od-make-button\"]/div[3]");
		driver.findElements(clickOnLensMake1).get(0).click();

		// click on ShowAll
		Thread.sleep(5000);
		clickOnShowAll.click();

		// Select the one value from lensMake

		Thread.sleep(3000);
		java.util.List<WebElement> selectLensMake = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-lensPopup-od-make-container\"]/div"));
		for (int i = 0; i < selectLensMake.size(); i++)
			if (selectLensMake.get(i).getText().equalsIgnoreCase(name)) {
				selectLensMake.get(i).click();
				break;
			}

		// click on CopyRightEye
		Thread.sleep(4000);
		clickOnCopyRightEye.click();

	}

	// function use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
