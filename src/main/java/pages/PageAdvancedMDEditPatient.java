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

public class PageAdvancedMDEditPatient {
	private WebDriver driver;
	private WebDriverWait wait;
	Actions builder;
	WebElement element;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	public static String firstWinHandle;
	public static String secondWinHandle;
	public static String secondChildhandle;
	private static int n2 = 0;
	String strText = "Null";
	WebElement firstFrame;
	WebElement secondFrame;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ellPtPatient\"]/button/span")
	private WebElement clickOnPatientBtn;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"txtSearch\"]")
	private WebElement fillTheName;

	@FindBy(how = How.XPATH, using = ".//button[@id=\"btnSearch\"]")
	private WebElement clickOnSearchBtn;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//table[@class=\"gridbody\"]/tbody/tr/td/nobr"),
			@FindBy(how = How.XPATH, using = ".//table[@class=\"gridbody\"]/tbody/tr/td") })
	private List<WebElement> selectPatient;

	@FindBy(how = How.XPATH, using = ".//button[@id=\"btnOK\"]")
	private WebElement clickonOk;
	
	@FindBy(how = How.XPATH, using = ".//button[@id=\"btnPtDelete\"]")
	private WebElement fillPatientName;

	public PageAdvancedMDEditPatient(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAdvancedMDEditPatient.this);
	}

	public void verifyEditPMSPatient(String name, String type, String status) throws Exception {

		new PgAdvancedMDPatient(driver, wait, builder).launchPMSPatientCreation();

		performEditpatientoperation(name);
	}

	public void performEditpatientoperation(String name) throws Exception {

		ensureElementToBeClickable(clickOnPatientBtn);
		clickOnPatientBtn.click();

		new PagePMSExternalProvider(driver, wait, builder).handleWindow();
Thread.sleep(10000);
			ensureElementToBeClickable(fillTheName);
			fillTheName.clear();
		fillTheName.sendKeys(name);


			Thread.sleep(2000);
			ensureElementToBeClickable(clickOnSearchBtn);
			clickOnSearchBtn.click();


			ensureElementToBeClickable(selectPatient);
			for (WebElement select_Patient : selectPatient) {
				if (select_Patient.getText().startsWith(name)) {

					select_Patient.click();
					break;
				}

			}

		try {
			ensureElementToBeClickable(clickonOk);
			clickonOk.click();
		} catch (Exception e) {
			ensureElementToBeClickable(clickonOk);
			clickonOk.click();
		}
		
		new PagePMSExternalProvider(driver, wait, builder).handleWindow();
		
		ensureElementToBeClickable(fillPatientName);

		fillPatientName.click();

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
