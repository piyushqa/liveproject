package pages;

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

public class PageNotifyProviderWithoutEncounter {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	@FindBy(how = How.CSS, using = "#content > div > div> div:nth-child(3) > div > div> div:nth-child(4) > a > img")
	private WebElement clickOnProviderOnPatientDashboard;

	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_content>div>div:nth-child(2)>div>div:nth-child(3)")
	private WebElement clickOnSendingProvider;

	@FindBy(how = How.CSS, using = "div#gwt-debug-comanageList-container>div")
	private List<WebElement> Select_SendingProvider;

	@FindBy(how = How.CSS, using = "div#gwt-debug-referPatientToDoctor>div>h4>svg")
	private WebElement clickOnAddProviderTestEnv;

	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][2]/button[1]/span")
	private WebElement clickOnCompleteTestEnv;

	@FindBy(how = How.XPATH, using = ".//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][3]/button[1]/span")
	private WebElement clickOnDirectTestEnv;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder=\"Comments\"]")
	private WebElement fillCommentTestEnv;

	@FindBy(how = How.XPATH, using = " .//div[@class=\"ql-container ql-snow\"]/div[1]")
	private WebElement fillLetterPreviewComment;

	@FindBy(how = How.XPATH, using = ".//div[text()='Internal']")
	private WebElement clickOnInternal;

	@FindBy(how = How.XPATH, using = ".//input[@id='gwt-debug-firstName']")
	private WebElement fillTheFirstName;

	@FindBy(how = How.XPATH, using = ".//a[text()='Search']")
	private WebElement clickOnSearch;

	@FindBy(how = How.XPATH, using = " .//div[starts-with(@class,'configurableTemplateBtn-toggle configurableTemplateBtn-group Buttons')][1]/button[2]/span")
	private WebElement clickOnRefferalToTestEnv;

	@FindBy(how = How.CSS, using = "#gwt-debug-notifyProviderFooter > div.overlay_footer > div.float_right > div.btn_green>a")
	private WebElement clickOnDoneButton;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageNotifyProviderWithoutEncounter(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageNotifyProviderWithoutEncounter.this);
	}

	public void verifyNotifyProviderWithoutEncounter(String fName,String lName,String downloadPath, String fileName, String sendingProvider,
			String name, Boolean refferal, String comments, String documents) throws Exception {
		
		selectProviderForNotifyProvider(sendingProvider);
		
		performNotifyProviderOperation(name, refferal, comments);
		
		new PageRefferalAndFollowUpReport(driver, wait, builder).searchAndSelectSamePatient(fName, lName, documents, name);

	}

	public void selectProviderForNotifyProvider(String sendingProvider) throws Exception {

		ensureElememtToBeClickable(clickOnProviderOnPatientDashboard);
		clickOnProviderOnPatientDashboard.click();

		ensureElememtToBeClickable(clickOnSendingProvider);
		clickOnSendingProvider.click();

		for (WebElement selectSendingProvider : Select_SendingProvider) {
			if (selectSendingProvider.getText().equalsIgnoreCase(sendingProvider)) {
				selectSendingProvider.click();
				break;
			}
		}

	}

	public void performNotifyProviderOperation(String name, Boolean refferal, String comments) throws Exception {

		Thread.sleep(2000);
		clickOnAddProviderTestEnv.click();

		Thread.sleep(3000);
		clickOnInternal.click();

		Thread.sleep(1000);
		ensureElememtToBeClickable(fillTheFirstName);
		fillTheFirstName.sendKeys("sandeep");

		// click On search;
		Thread.sleep(3000);

		ensureElememtToBeClickable(clickOnSearch);
		clickOnSearch.click();

		Thread.sleep(4000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		java.util.List<WebElement> providerSearch = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-providerSearchResultTable\"]/tbody/tr/td"));
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
		ensureElememtToBeClickable(clickOnDirectTestEnv);
		clickOnDirectTestEnv.click();

//		Thread.sleep(3000);
//		fillCommentTestEnv.sendKeys("Test Enviorment reffreal report");
//
//		Thread.sleep(3000);
//		fillLetterPreviewComment.sendKeys("Test enviorment refferal report");

		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();

	}

	// fuction is used for visibility and clickAble of elements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
