package pages;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePMSExternalProvider {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// Define locater
	@FindBy(how = How.LINK_TEXT, using = "IntegrityPM")
	private WebElement clickOnIntegrityPMLink;

	@FindBy(how = How.CSS, using = "div#amds-navbar>ul>li:nth-child(7)>a")
	private WebElement clickOnMasterFile;

	@FindBy(how = How.XPATH, using = ".//ul[@class=\"dropdown-menu\"]/li/a[text()=\"Providers/ Groups\"]")
	private WebElement clickOnProvidersGroups;

	@FindBy(how = How.XPATH, using = ".//ul[@class=\"dropdown-menu\"]/li/a[text()=\"Providers\"]")
	private WebElement clickOnProviders;

	@FindBy(how = How.XPATH, using = "//*[@id=\"amds-navbar\"]/ul/li[7]/div/ul/li[21]/div/ul/li/a")
	private List<WebElement> selectProviders;

	@FindBy(how = How.XPATH, using = ".//fieldset/input[@id=\"txtCode\"]")
	private WebElement fillcode;

	@FindBy(how = How.XPATH, using = ".//fieldset/input[@id=\"txtDescription\"]")
	private WebElement fillDescription;

	@FindBy(how = How.XPATH, using = ".//fieldset/input[@id=\"txtName\"]")
	private WebElement fillName;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"txtAddress1\"]")
	private WebElement aptAddress;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"txtAddress2\"]")
	private WebElement proAddress;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ellZipCode\"]/button/span")
	private WebElement clickOnZipCodeBtn;

	@FindAll({ @FindBy(how = How.CSS, using = "table.gridbody>tbody>tr>td"),
			@FindBy(how = How.CSS, using = "table.gridbody>tbody>tr>td>nobr") })
	private List<WebElement> selectZipCode;

	@FindBy(how = How.CSS, using = "button#btnOK")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ellParent\"]/button/span")
	private WebElement clickOnGroupBtn;

	@FindBy(how = How.CSS, using = "table.gridbody>tbody>tr>td>nobr")
	private List<WebElement> selectGroup;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ellStatementGroup\"]/button/span")
	private WebElement clickOnStmtGroupBtn;

	@FindBy(how = How.CSS, using = "table.gridbody>tbody>tr>td")
	private List<WebElement> selectStmtGroup;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ellFeeSchedule\"]/button/span")
	private WebElement clickOnFeeSchedBtn;

	@FindBy(how = How.CSS, using = "table.gridbody>tbody>tr>td")
	private List<WebElement> selectFeeSched;

	@FindBy(how = How.CSS, using = "input#txtUPINNumber")
	private WebElement fillUPIPin;

	@FindBy(how = How.CSS, using = "button#btnSave")
	private WebElement clickBtnSave;

	@FindBy(how = How.LINK_TEXT, using = "Providers")
	private WebElement clickOnPatientSrch;

	@FindBy(how = How.CSS, using = "div#gwt-debug-providerGroup-container>table>tbody>tr>td:nth-child(2)>div")
	private WebElement clickOnExternalLink;

	@FindBy(how = How.CSS, using = "input#gwt-debug-firstName")
	private WebElement clickOnfirstName;

	@FindBy(how = How.CSS, using = "input#gwt-debug-lastName")
	private WebElement clickOnLastname;

	@FindBy(how = How.CSS, using = "div#gwt-debug-searchProviders>a")
	private WebElement clickOnsearchBtn;

	public PagePMSExternalProvider(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PagePMSExternalProvider.this);
	}

	// function use for invoke sub method
	public void verifyPMSExternalProvider(String code, String description, String name, String apt, String adddress,
			String zipCode, String group, String stmtGroup, String feeSched, String upiIN, Boolean external)
			throws Exception {

		// only generate Pms window and click on provider sub menu
		generateExternalProviderWindow();

		// fill the value of external provider on pms
		Thread.sleep(3000);
		addExternalProviderData(code, description, name, apt, adddress, zipCode, group, stmtGroup, feeSched, upiIN);

		// invoke method rhat match pms provider on emr
		serchExtProviderOnEMR(name, external);
	}

	// only generate Pms window and click on provider sub menu
	private void generateExternalProviderWindow() throws Exception {

		// click On IntegrityPMLink
		ensureElementToBeClickable(clickOnIntegrityPMLink);
		clickOnIntegrityPMLink.click();

		// control window
		Thread.sleep(15000);
		handleWindow();

		Thread.sleep(15000);
		driver.manage().window().maximize();

		ensureElementToBeClickable(clickOnMasterFile);
		clickOnMasterFile.click();

		ensureElementToBeClickable(clickOnProvidersGroups);
		builder.moveToElement(clickOnProvidersGroups).build().perform();

		ensureElementToBeClickable(clickOnProviders);
		clickOnProviders.click();

		// for (WebElement select_Providers : selectProviders) {
		// if (select_Providers.getText().equalsIgnoreCase("Providers")) {
		// select_Providers.click();
		// break;
		// }
		// }
	}

	// fill the value of external provider on pms

	public void addExternalProviderData(String code, String description, String name, String apt, String adddress,
			String zipCode, String group, String stmtGroup, String feeSched, String upiIN) throws Exception {

		// control external provider window
		Thread.sleep(5000);
		handleWindow();

		ensureElementToBeClickable(fillcode);
		fillcode.clear();
		fillcode.sendKeys(code);

		ensureElementToBeClickable(fillDescription);
		fillDescription.clear();
		fillDescription.sendKeys(description);

		ensureElementToBeClickable(fillName);
		fillName.clear();
		fillName.sendKeys(name);

		ensureElementToBeClickable(aptAddress);
		aptAddress.clear();
		aptAddress.sendKeys(apt);

		ensureElementToBeClickable(proAddress);
		proAddress.clear();
		proAddress.sendKeys(adddress);

		// invoke method fillZipCodeData
		fillZipCodeData(zipCode);

		// invoke method fillGroupData
		fillGroupData(group);

		// invoke method fillStmtGroupData
		fillStmtGroupData(stmtGroup);

		// invoke method fillFeeSched
		fillFeeSched(feeSched);

		// handle external provider window
		handleWindow();

		fillUPIPin.clear();
		fillUPIPin.sendKeys(upiIN);

		Thread.sleep(3000);
		clickBtnSave.click();

		// close external window
		driver.close();

		// hanle pms window
		handleWindow();

		// close pms window
		driver.close();
	}

	public void fillZipCodeData(String zipCode) throws Exception {

		ensureElementToBeClickable(clickOnZipCodeBtn);
		clickOnZipCodeBtn.click();

		Thread.sleep(5000);
		handleWindow();

		ensureElementToBeClickable(selectZipCode);
		for (WebElement select_ZipCode : selectZipCode) {
			if (select_ZipCode.getText().equalsIgnoreCase(zipCode)) {
				select_ZipCode.click();
				break;
			}
		}
		ensureElementToBeClickable(clickOnOkBtn);
		clickOnOkBtn.click();
	}

	public void fillGroupData(String group) throws Exception {

		Thread.sleep(3000);
		handleWindow();

		ensureElementToBeClickable(clickOnGroupBtn);
		clickOnGroupBtn.click();

		Thread.sleep(3000);
		handleWindow();

		for (WebElement select_Group : selectGroup) {
			if (select_Group.getText().equalsIgnoreCase(group)) {
				select_Group.click();
				break;

			}
		}

		ensureElementToBeClickable(clickOnOkBtn);
		clickOnOkBtn.click();
	}

	public void fillStmtGroupData(String stmtGroup) throws Exception {

		Thread.sleep(3000);
		handleWindow();

		ensureElementToBeClickable(clickOnStmtGroupBtn);
		clickOnStmtGroupBtn.click();

		Thread.sleep(3000);
		handleWindow();

		for (WebElement select_StmtGroup : selectStmtGroup) {
			if (select_StmtGroup.getText().equalsIgnoreCase(stmtGroup)) {
				select_StmtGroup.click();
				break;

			}
		}

		ensureElementToBeClickable(clickOnOkBtn);
		clickOnOkBtn.click();
	}

	public void fillFeeSched(String feeSched) throws Exception {

		Thread.sleep(3000);
		handleWindow();

		ensureElementToBeClickable(clickOnFeeSchedBtn);
		clickOnFeeSchedBtn.click();

		Thread.sleep(3000);
		handleWindow();

		for (WebElement select_FeeSched : selectFeeSched) {
			if (select_FeeSched.getText().equalsIgnoreCase(feeSched)) {
				select_FeeSched.click();
				break;

			}
		}

		ensureElementToBeClickable(clickOnOkBtn);
		clickOnOkBtn.click();
	}

	// match the external pms provider on emr
	public void serchExtProviderOnEMR(String name, Boolean external) throws Exception {
		handleWindow();

		ensureElementToBeClickable(clickOnPatientSrch);
		clickOnPatientSrch.click();

		if (!clickOnExternalLink.isSelected() && external) {
			ensureElementToBeClickable(clickOnExternalLink);
			clickOnExternalLink.click();
		}

		String extName[] = name.split(",");

		ensureElementToBeClickable(clickOnfirstName);
		clickOnfirstName.sendKeys(extName[1]);

		ensureElementToBeClickable(clickOnLastname);
		clickOnLastname.sendKeys(extName[0]);

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnsearchBtn);
		clickOnsearchBtn.click();
	}

	// function use for handle window
	public void handleWindow() {
		for (String controlWindowhandle : driver.getWindowHandles()) {
			driver.switchTo().window(controlWindowhandle);
		}
	}

	// finction use for enable element
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
