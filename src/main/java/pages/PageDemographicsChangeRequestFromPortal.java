package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tests.LoginTest;

public class PageDemographicsChangeRequestFromPortal {

	WebDriver driver;
	Actions builder;
	WebDriverWait wait;

	@FindBy(how = How.XPATH, using = ".//span[contains(text(),' Health information ')]")
	private WebElement clickOnHealthInFormation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/ul/li[3]/ul/li[1]/a")
	private WebElement clickOnPersonalInformation;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Request a change')]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"main-container\"]/div[2]/div/div/div/div/div/div/div/div[2]/div[1]/div/div[2]/div/a") })
	private WebElement clickOnRequestChange;

	@FindBy(how = How.CSS, using = "input#UpdatedAddress2")
	private WebElement fillChangeAddress2;

	@FindBy(how = How.CSS, using = "a#submitBtnHref")
	private WebElement clickOnSubmitBtn;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Review and submit')]"),
			@FindBy(how = How.XPATH, using = ".//*[@id=\"main-container\"]/div[2]/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div/a[2]") })
	private WebElement clickOnReviewSubmitBtn;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//button[contains(text(),' Submit changes')]"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"main-container\"]/div[2]/div/div/div/div/form/div[2]/div/div/div[1]/div/div[2]/div/ol/li/button") })
	private WebElement clickOnSubmitChangesBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/ul/li[3]/ul/li[6]/a")
	private WebElement clickOnRequestHistory;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"search-results\"]/tbody/tr[1]/td[3]/a")
	private WebElement clickOnViewDetails;

	@FindBy(how = How.XPATH, using = ".//label[@class=\"demographics-modified\"]")
	private WebElement getModifiedAddress;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Return')]")
	private WebElement clickOnReturn;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Tasks')]")
	private WebElement clickOnTasks;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-contentPanel\"]/div[3]/div/div[4]/div/table/tbody/tr[1]/td[6]/div[text()=\" Request for change in Demographics\"]")
	private WebElement clickOnChangeInDemographics;

	@FindBy(how = How.CSS, using = "div#gwt-debug-taskWidgetPnl>div:nth-child(1)>table>tbody>tr:nth-child(6)>td>div>div:nth-child(3)>span:nth-child(2)")
	private WebElement getOnAddressLineEmr;

	@FindBy(how = How.CSS, using = "table#gwt-debug-messageStatus>tbody>tr>td>span>label")
	private List<WebElement> selectStatus;
	
	@FindBy(how=How.CSS,using="div#gwt-debug-save-and-close-message>a")
	private WebElement clickOnSaveAndClose;
	
	@FindBy(how=How.CSS,using="div#gwt-debug-close_overlay>a.close")
	private WebElement clickOnCloseOfMessageCenter;

	/**
	 * @param driver
	 * @param builder
	 * @param wait
	 */
	public PageDemographicsChangeRequestFromPortal(WebDriver driver, Actions builder, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.builder = builder;
		this.wait = wait;
		PageFactory.initElements(driver, PageDemographicsChangeRequestFromPortal.this);
	}

	public void verifyDemographicsChangeRequestFromPortal(String changeAddress2, String taskStatus) throws Exception {
		performDemographicsChangeOperation(changeAddress2);

		verifyDemographicsChanges(changeAddress2);
		
		verifyDemographicsChangeToEMR(changeAddress2, taskStatus);
	}

	public void performDemographicsChangeOperation(String changeAddress2) throws Exception {

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnHealthInFormation);
		builder.click(clickOnHealthInFormation).build().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnPersonalInformation);
		builder.click(clickOnPersonalInformation).build().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnRequestChange);
		clickOnRequestChange.click();

		Thread.sleep(5000);
		ensureElementToBeClickable(fillChangeAddress2);
		fillChangeAddress2.clear();
		fillChangeAddress2.sendKeys(changeAddress2);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSubmitBtn);
		builder.click(clickOnSubmitBtn).build().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnReviewSubmitBtn);
		builder.click(clickOnReviewSubmitBtn).build().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSubmitChangesBtn);
		builder.click(clickOnSubmitChangesBtn).build().perform();
	}

	public void verifyDemographicsChanges(String changeAddress2) throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnHealthInFormation);
		builder.click(clickOnHealthInFormation).build().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnRequestHistory);
		builder.click(clickOnRequestHistory).build().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnViewDetails);
		builder.click(clickOnViewDetails).build().perform();

		Thread.sleep(3000);
		String getAddress2 = getModifiedAddress.getText();
		Thread.sleep(2000);
		Assert.assertEquals(changeAddress2, getAddress2);
		System.out.println("Address Modified Successfully");

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnReturn);
		builder.click(clickOnReturn).build().perform();
	}

	public void verifyDemographicsChangeToEMR(String changeAddress2, String taskStatus) throws Exception {
		// handleWindow();

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnTasks);
		clickOnTasks.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnChangeInDemographics);
		builder.click(clickOnChangeInDemographics).build().perform();

		Thread.sleep(5000);
		String getAddressEMR = getOnAddressLineEmr.getText();
		if (getAddressEMR.equalsIgnoreCase(changeAddress2)) {
			System.out.println("EMR Data Matched Successfully");
		} else {
			System.out.println("EMR data not matched");
		}

		Thread.sleep(3000);
		for (WebElement select_Status : selectStatus) {
			if (select_Status.getText().equalsIgnoreCase(taskStatus)) {
				select_Status.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSaveAndClose);
		builder.click(clickOnSaveAndClose).build().perform();
		
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnCloseOfMessageCenter);
		builder.click(clickOnCloseOfMessageCenter).build().perform();
		
	}

	public void handleWindow() throws Exception {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
