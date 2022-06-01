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
import org.testng.Reporter;
import org.testng.annotations.Factory;

public class PgPendingPatient {

	WebDriver driver;
	WebElement element = null;;
	WebDriverWait wait;

	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;

	// declare Locater

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickOnJoinEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-startNewEncounter>a")
	private WebElement clickStartEncounter;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-ok\"][text()='Yes']")
	private WebElement clickOnEncounterOk;

	@FindBy(how = How.XPATH, using = "//*[@id='gwt-debug-encounterTabBar']/tbody/tr/td[9]/div")
	private WebElement clickOnImpPlan;

	@FindBy(how = How.XPATH, using = ".//div[text()='Add New Problem']")
	private WebElement clickOnAddnewProblem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-icd10popup--done\"]/a")
	private WebElement doneBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()='Add Provider']")
	private WebElement clickOnAddProvider;

	@FindBy(how = How.XPATH, using = "//*[@id='modal-popup-message']/div/div/div/div/div[3]/div/div[12]/div/div[2]/div[2]/div[1]/div[2]/div[2]")
	private WebElement clickRefferalTo;

	@FindBy(how = How.XPATH, using = ".//div[text()='Complete']")
	private WebElement clickOnComplete;

	@FindBy(how = How.XPATH, using = ".//a[text()='Notify Other Providers']")
	private WebElement clickOnNotifyOtherProvider;

	@FindBy(how = How.XPATH, using = ".//div[text()='Internal']")
	private WebElement clickOnInternal;

	@FindBy(how = How.XPATH, using = ".//input[@id='gwt-debug-firstName']")
	private WebElement fillTheFirstName;

	@FindBy(how = How.XPATH, using = ".//a[text()='Search']")
	private WebElement clickOnSearch;

	@FindBy(how = How.XPATH, using = ".//div[text()='Direct']")
	private WebElement clickOnDirect;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder='reason for referral']")
	private WebElement fillTextInput;

	@FindBy(how = How.CSS, using = "#gwt-debug-notifyProviderFooter > div.overlay_footer > div.float_right > div.btn_green>a")
	private WebElement clickOnDoneButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingButton;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	@FindBy(how = How.XPATH, using = ".//a[text()='My Dashboard']")
	private WebElement clickOnMyDashBoard;

	@FindBy(how = How.XPATH, using = "//a[@id=\"gwt-debug-taskLink\"][text()=\"Direct Message Inbox\"]")
	private WebElement clickOnDirectMessageInbox;

	@FindBy(how = How.XPATH, using = ".//span[text()='Add Patient & Associate Attachments']")
	private WebElement clickOnpatientandAttachments;

	@FindBy(how = How.XPATH, using = ".//a[text()='Search']")
	private WebElement clickOnSearchBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()='Create Pending Patient']")
	private WebElement clickOnCreatePendingPatient;

	public PgPendingPatient(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;

		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void createPendingPatient(String provider, String category, String subCategory, String subCategory1,
			String eye, String glaucomaSeverity, String glaucomaStability, String name, String textInput,
			String recipites) throws Exception {
		 wait = new WebDriverWait(driver, 20);
		 enSureElementToBeClickable(clickStartEncounter);
		 clickStartEncounter.click();

		// // select providre from dropDown
		// Thread.sleep(4000);
		// java.util.List<WebElement> openCounter = driver
		// .findElements(By.cssSelector("#gwt-debug-openEncounterTable > tbody > tr >
		// td:nth-child(3)>div"));
		// for (int i = 0; i < openCounter.size(); i++)
		// // System.out.println(openCounter.get(i).getText());
		// if (openCounter.get(i).getText().equalsIgnoreCase(provider)) {
		// openCounter.get(i).click();
		// break;
		// }

//		Thread.sleep(5000);
//		clickOnJoinEncounter.click();
//		int select_RowFromOpenEncounter = driver
//				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
//		System.out.println(select_RowFromOpenEncounter);
//		Thread.sleep(5000);
//		if (select_RowFromOpenEncounter > 0) {
//
//			// Select_Provider
//			Thread.sleep(4000);
//			List<WebElement> select_Provider = driver
//					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
//			for (int i = 1; i <= select_Provider.size(); i++)
//				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
//					select_Provider.get(i).click();
//					break;
//				}
//		}
		// Thread.sleep(5000);
//		else if (select_RowFromOpenEncounter <= 0) {
//			Thread.sleep(7000);
//			clickStartEncounter.click();
//
//		}

		 Thread.sleep(3000);
		 clickOnEncounterOk.click();

		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnImpPlan);
		clickOnImpPlan.click();

		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnAddnewProblem);
		clickOnAddnewProblem.click();

		// select category Glaucoma
		Thread.sleep(6000);
		java.util.List<WebElement> gulcomaCategoryClick = driver.findElements(
				By.xpath("//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaCategoryClick.size(); i++)
			if (gulcomaCategoryClick.get(i).getText().equalsIgnoreCase(category)) {
				gulcomaCategoryClick.get(i).click();
				break;

			}

		// select subCategory Glaucoma with Other Disorders
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaSubCategoryClick = driver.findElements(
				By.xpath("//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[3]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategoryClick.size(); i++)
			if (gulcomaSubCategoryClick.get(i).getText().equalsIgnoreCase(subCategory)) {
				gulcomaSubCategoryClick.get(i).click();
				break;

			}

		// select subCategory1 Glaucoma
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaSubCategory1Click = driver.findElements(
				By.xpath("//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategory1Click.size(); i++)
			if (gulcomaSubCategory1Click.get(i).getText().equalsIgnoreCase(subCategory1)) {
				gulcomaSubCategory1Click.get(i).click();
				break;

			}

		// select Glaucoma Eye
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaEyeClick = driver.findElements(By.xpath(
				"//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaEyeClick.size(); i++)
			if (gulcomaEyeClick.get(i).getText().equalsIgnoreCase(eye)) {
				gulcomaEyeClick.get(i).click();
				break;

			}

		// select Glaucoma Severity
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaSeverityClick = driver.findElements(By.xpath(
				"//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaSeverityClick.size(); i++)
			if (gulcomaSeverityClick.get(i).getText().equalsIgnoreCase(glaucomaSeverity)) {
				gulcomaSeverityClick.get(i).click();
				break;

			}

		// select Glaucoma Stability
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaStabilityClick = driver.findElements(By.xpath(
				"//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div"));
		for (int i = 0; i < gulcomaStabilityClick.size(); i++)
			if (gulcomaStabilityClick.get(i).getText().equalsIgnoreCase(glaucomaStability)) {
				gulcomaStabilityClick.get(i).click();
				break;

			}

		// Click on Done Button
		Thread.sleep(3000);
		doneBtn.click();

		// click On AddProvider
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnAddProvider);
		clickOnAddProvider.click();

		// click On Refferal To
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickRefferalTo);
		clickRefferalTo.click();

		// click On Complete
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnComplete);
		clickOnComplete.click();

		// click On NotifyOther Provider
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnNotifyOtherProvider);
		clickOnNotifyOtherProvider.click();

		// click On Internal
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnInternal);
		clickOnInternal.click();

		// click On Fill The FirstName
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(fillTheFirstName);
		fillTheFirstName.sendKeys(name);

		// click On search;
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnSearch);
		clickOnSearch.click();

		Thread.sleep(4000);
		java.util.List<WebElement> providerSearch = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-providerSearchResultTable\"]/tbody/tr/td"));
		for (int i = 0; i < providerSearch.size(); i++)

			if (providerSearch.get(i).getText().equalsIgnoreCase(name)) {
				providerSearch.get(i).click();
				break;
			}

		// click On Complete
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnComplete);
		clickOnComplete.click();

		// click On Direct
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnDirect);
		clickOnDirect.click();

		// click on Done Button
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnDoneButton);
		clickOnDoneButton.click();

		// click On coding Button
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnCodingButton);
		clickOnCodingButton.click();

		// click On Nocharges
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnNoCharges);
		clickOnNoCharges.click();

		// clickOn submit and Close
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnsubmitandclose);
		clickOnsubmitandclose.click();

		// click On Direct Message Inbox
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
//		//enSureElementToBeClickable(clickOnDirectMessageInbox);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnDirectMessageInbox)).click();
		

		Thread.sleep(15000);
		java.util.List<WebElement> recipients_Select = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-contentPanel\"]/div[3]/div/div[4]/div/table/tbody/tr/td/div"));
		for (int i = 0; i < recipients_Select.size(); i++)

			if (recipients_Select.get(i).getText().equalsIgnoreCase(recipites)) {
				recipients_Select.get(i).click();
				break;
			}

		// click On patient and Attachments
		Thread.sleep(13000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnpatientandAttachments);
		clickOnpatientandAttachments.click();

		// click On Search Button
		Thread.sleep(6000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnSearchBtn);
		clickOnSearchBtn.click();

		// click On Create PendingPatient
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		enSureElementToBeClickable(clickOnCreatePendingPatient);
		clickOnCreatePendingPatient.click();

		Thread.sleep(7000);
		By closeOnbtn = By.xpath(".//*[@id=\"gwt-debug-headingPanel\"]/div[1]/a[@class=\"close\"]");
		driver.findElements(closeOnbtn).get(2).click();

		Thread.sleep(5000);
		By cancelButton = By.xpath(".//div[@id=\"gwt-debug-cancel-view-message\"]/a[text()='Close']");

		driver.findElements(cancelButton).get(2).click();

		Thread.sleep(5000);
		By cancelButton1 = By.xpath(".//div[@id=\"gwt-debug-cancel-view-message\"]/a[text()='Close']");

		driver.findElements(cancelButton1).get(1).click();
	}

	public void enSureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
