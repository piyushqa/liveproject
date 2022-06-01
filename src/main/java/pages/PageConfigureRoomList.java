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
import org.testng.Reporter;

public class PageConfigureRoomList {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgPatientSearch lclPgPatientsrch;
	PgLanding lclPglanding;

	@FindBy(how = How.XPATH, using = ".//a[text()='Configuration']")
	private WebElement clickOnConfiguration;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	private List<WebElement> selectConfigurationModule;

	@FindBy(how = How.CSS, using = "div#gwt-debug-roomList-dataList-container>div>b>i")
	private WebElement clickOnAddItem;

	@FindBy(how = How.CSS, using = "input#gwt-debug-roomList-editTextBox")
	private WebElement clickOnAddItemTextBox;

	@FindBy(how = How.CSS, using = "div#gwt-debug-roomList-up")
	private WebElement clickOnUpMenu;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Done\"]")
	private WebElement clickOnDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-locationList")
	private WebElement clickOnLocationDropDown;

	@FindBy(how = How.CSS, using = "table#gwt-debug-PicklistTable-dataTable>tbody>tr>td>div")
	private List<WebElement> selectLoaction;

	@FindBy(how = How.CSS, using = "a#gwt-debug-returnToUserDashboard")
	private WebElement clickOnMydashBoard;

	@FindBy(how = How.CSS, using = "div#gwt-debug-roomList-dataList-container>div")
	private List<WebElement> selectCofigureRoomList;

	@FindBy(how = How.CSS, using = "div#gwt-debug-roomList-delete")
	private WebElement clickOndeleteBtn;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageConfigureRoomList(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageConfigureRoomList.this);
	}

	public void verifyPageConfigureRoomList(String fName, String lName, String provider, String addNewItem)
			throws Exception {

		performConfigurationOpertion(addNewItem);

		Thread.sleep(4000);
		boolean editPatient = false;
		lclPglanding = new PgLanding(driver);
		lclPgPatientsrch = lclPglanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		matchData(addNewItem);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnMydashBoard);
		clickOnMydashBoard.click();

		deleteAddedConfigureData(addNewItem);

	}

	public void performConfigurationOpertion(String addNewItem) throws Exception {

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnConfiguration);
		clickOnConfiguration.click();

		Thread.sleep(3000);
		for (WebElement select_ConfigurationModule : selectConfigurationModule) {
			if (select_ConfigurationModule.getText().equalsIgnoreCase("Configure Room List")) {
				select_ConfigurationModule.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnAddItem);
		clickOnAddItem.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnAddItemTextBox);
		clickOnAddItemTextBox.sendKeys(addNewItem);

		// for (int i = 0; i <= 3; i++) {
		//
		// clickOnUpMenu.click();
		// }

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();

	}

	private void matchData(String addNewItem) throws Exception {
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLocationDropDown);
		clickOnLocationDropDown.click();

		Thread.sleep(3000);
		for (WebElement select_Location : selectLoaction) {
			String strLoaction = select_Location.getText();
			if (strLoaction.equalsIgnoreCase(addNewItem)) {
				Reporter.log(strLoaction + " " + "matched" + addNewItem);
				System.out.println("Pass");
			}
		}

	}

	private void deleteAddedConfigureData(String addNewItem) throws Exception {

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnConfiguration);
		clickOnConfiguration.click();

		Thread.sleep(3000);
		for (WebElement select_ConfigurationModule : selectConfigurationModule) {
			if (select_ConfigurationModule.getText().equalsIgnoreCase("Configure Room List")) {
				select_ConfigurationModule.click();
				break;
			}
		}

		Thread.sleep(4000);
		for (WebElement select_Configuration : selectCofigureRoomList) {
			if (select_Configuration.getText().equalsIgnoreCase(addNewItem)) {
				select_Configuration.click();
				break;
			}
		}

		Thread.sleep(3000);
		clickOndeleteBtn.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
