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

public class PageSendDirectMsgtoProvider {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Direct Message Inbox\"]")
	private WebElement clickOnDirectMSGInbox;

	@FindBy(how = How.XPATH, using = ".//a[text()='Add Provider']")
	private WebElement clickOnAddProvider;

	@FindBy(how = How.XPATH, using = "//*[@id='modal-popup-message']/div/div/div/div/div[3]/div/div[12]/div/div[2]/div[2]/div[1]/div[2]/div[2]")
	private WebElement clickRefferalTo;

	@FindBy(how = How.XPATH, using = ".//div[text()='Complete']")
	private WebElement clickOnComplete;

	@FindBy(how = How.XPATH, using = ".//a[text()='Notify Other Providers']")
	private WebElement clickOnNotifyOtherProvider;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"External\"]")
	private WebElement clickOnExternalProvider;

	@FindBy(how = How.XPATH, using = ".//input[@id='gwt-debug-firstName']")
	private WebElement fillTheFirstName;

	@FindBy(how = How.XPATH, using = ".//a[text()='Search']")
	private WebElement clickOnSearch;

	@FindBy(how = How.XPATH, using = ".//div[text()='Direct']")
	private WebElement clickOnDirect;

	@FindBy(how = How.CSS, using = "#gwt-debug-notifyProviderFooter > div.overlay_footer > div.float_right > div.btn_green>a")
	private WebElement clickOnDoneButton;
	
	//==================================================================================
	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][1]/button[2]/span")
	private WebElement clickOnRefferalToTestEnv;

	@FindBy(how = How.CSS, using = "div#gwt-debug-referPatientToDoctor>div>h4>svg")
	private WebElement clickOnAddProviderTestEnv;

	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][2]/button[1]/span")
	private WebElement clickOnCompleteTestEnv;

	@FindBy(how = How.XPATH, using = ".//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][3]/button[1]/span")
	private WebElement clickOnDirectTestEnv;


	public PageSendDirectMsgtoProvider(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageSendDirectMsgtoProvider.this);
	}

	public void verifySendDirectMsgtoInternalProvider(String category, String subCategory1, String subCategory2,
			String eye, String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges, String name, Boolean refferal, String comments, String provider, String exProviderName)
			throws Exception {

		Thread.sleep(2000);
		PageCloseEncounter encounterOpen = new PageCloseEncounter(wait, driver, builder);
		encounterOpen.openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, significantProblem);

		Thread.sleep(5000);
		switch (provider) {
		case "Internal":
			try {
				PageRefferalAndFollowUpReport refAndFollowUpReport = new PageRefferalAndFollowUpReport(driver, wait,
						builder);
				// refAndFollowUpReport.refferalAndFollowUp(name, refferal, comments);
				refAndFollowUpReport.refferalReportForTestEnv(exProviderName, refferal, comments);

			} catch (Exception e) {
				Thread.sleep(4000);
				wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
				java.util.List<WebElement> providerSearch = driver
						.findElements(By.cssSelector("table#gwt-debug-providerSearchResultTable>tbody>tr>td>div"));
				for (int i = 0; i < providerSearch.size(); i++)

					if (providerSearch.get(i).getText().equalsIgnoreCase(name)) {
						providerSearch.get(i).click();
						break;
					}

				Thread.sleep(2000);
				if (!clickOnRefferalToTestEnv.isSelected() && refferal) {
					clickOnRefferalToTestEnv.click();
				}

				Thread.sleep(2000);
				clickOnCompleteTestEnv.click();

				Thread.sleep(3000);
				ensureElementToBeClickable(clickOnDirectTestEnv);
				clickOnDirectTestEnv.click();

//				Thread.sleep(3000);
//				fillCommentTestEnv.sendKeys("Test Enviorment reffreal report");
		//
//				Thread.sleep(3000);
//				fillLetterPreviewComment.sendKeys("Test enviorment refferal report");

				Thread.sleep(2000);
				ensureElementToBeClickable(clickOnDoneButton);
				clickOnDoneButton.click();

			}
			break;
		case "External":
			sendDirectMSGtoExternalProvider(exProviderName, refferal, comments);
			break;
		default:
			System.out.println("Not select either Internal or External Provider");
			break;

		}
		Thread.sleep(3000);
		PageCloseEncounter encounterClose = new PageCloseEncounter(wait, driver, builder);
		encounterClose.closeEncounter(visitType, noCharges);
		Thread.sleep(5000);

		matchSendDirectMessage(name);
	}

	public void matchSendDirectMessage(String name) throws Exception {

		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ensureElementToBeClickable(clickOnTask);
		clickOnDirectMSGInbox.click();

		// Thread.sleep(20000);
		// List<WebElement> select_ElementFromTask = driver.findElements(By.xpath(
		// "//*[@id=\"gwt-debug-contentPanel\"]/div[3]/div/div[4]/div/table/tbody[1]/tr/td/div[text()=\"Silicon
		// Bondtest\"]"));
		// for (int i = 1; i <= select_ElementFromTask.size(); i++)
		// if (select_ElementFromTask.get(i).getText().startsWith(name)) {
		// select_ElementFromTask.get(i).click();
		// break;
		// }

	}

	public void sendDirectMSGtoExternalProvider(String exProviderName, Boolean refferal, String comments)
			throws Exception {

		// click On AddProvider
		Thread.sleep(1000);
		ensureElementToBeClickable(clickOnAddProvider);
		clickOnAddProvider.click();

		// click On Refferal To
		Thread.sleep(1000);
		ensureElementToBeClickable(clickRefferalTo);
		if (!clickRefferalTo.isSelected() && refferal) {
			clickRefferalTo.click();
		}

		// click On Complete
		Thread.sleep(1000);
		ensureElementToBeClickable(clickOnComplete);
		clickOnComplete.click();

		// click On NotifyOther Provider
		Thread.sleep(1000);
		ensureElementToBeClickable(clickOnNotifyOtherProvider);
		clickOnNotifyOtherProvider.click();

		// click on external command
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnExternalProvider);
		clickOnExternalProvider.click();

		// fill the firstName
		Thread.sleep(1000);
		ensureElementToBeClickable(fillTheFirstName);
		fillTheFirstName.sendKeys(exProviderName);

		// click On serach
		Thread.sleep(1000);
		ensureElementToBeClickable(clickOnSearch);
		clickOnSearch.click();

		Thread.sleep(4000);
		java.util.List<WebElement> providerSearch = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-providerSearchResultTable\"]/tbody/tr/td"));
		for (int i = 0; i < providerSearch.size(); i++)

			if (providerSearch.get(i).getText().equalsIgnoreCase(exProviderName)) {
				providerSearch.get(i).click();
				break;
			}

		// click On Complete
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnComplete);
		clickOnComplete.click();

		// click On Direct
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDirect);
		clickOnDirect.click();

		// click on Done Button
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();

	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void ensureElementsToBeClickable(List<WebElement> elements) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
}
