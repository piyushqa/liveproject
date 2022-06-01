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

public class PageRestoreVisionConfig {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;

	@FindBy(how = How.CSS, using = "table#gwt-debug-encounterTabBar>tbody>tr>td:nth-child(5)>div")
	private WebElement clickOnVisionTab;

	@FindBy(how = How.CSS, using = "div#gwt-debug-visionConfig")
	private WebElement clickOnConfig;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[3]/div/div[2]/div")
	private List<WebElement> selecetCylinder;

	@FindBy(xpath = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[3]/div/div[2]/div[1]")
	private WebElement selcetPlusCylinder;

	@FindBy(xpath = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[3]/div/div[2]/div[2]")
	private WebElement selcetMinusCylinder;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Done')]")
	private WebElement clickOnConfigDone;

	@FindBy(how = How.CSS, using = "a#gwt-debug-returnToUserDashboard")
	private WebElement clickOnMyDashBoard;
	
	@FindBy(how = How.XPATH, using = ".//a[text()='Configuration']")
	private WebElement clickOnConfiguration;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	private List<WebElement> selectConfigurationModule;
	
	@FindBy(how=How.XPATH,using = ".//div[contains(text(),'Vision Configuration')]")
	private WebElement clickOnVisionConfig;
	
	@FindBy(how=How.XPATH,using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[3]/div[2]/div[2]/div[1]")
	private WebElement clickOnCurrentTime;
	
	@FindBy(how=How.XPATH,using=".//a[contains(text(),'Restore')]")
	private WebElement clickOnRestore;
	
	@FindBy(how=How.XPATH,using = ".//a[@id=\"gwt-debug-ok\" and text()=\"Yes\"]")
	private WebElement clickOnYesBtn;
	
	@FindBy(how=How.XPATH,using = ".//a[@id=\"gwt-debug-ok\" and text()=\"OK\"]")
	private WebElement clickOnOkBtn;
	
	@FindBy(how=How.XPATH,using = ".//a[contains(text(),'Done')]")
	private WebElement clickOnRestoreConfigDone;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageRestoreVisionConfig(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageRestoreVisionConfig.this);
	}

	public void verifyVisionConfig(String fName,String lName,String provider) throws Exception {
		// TODO Auto-generated method stub
		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnVisionTab);
		clickOnVisionTab.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnConfig);
		clickOnConfig.click();

		performConfigOperation();
		
		performRestoreConfigurationOperation();
		
		Thread.sleep(2000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient); 
		
		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);
		
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnVisionTab);
		clickOnVisionTab.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnConfig);
		clickOnConfig.click();
	}

	public void performConfigOperation() throws Exception {
		Thread.sleep(5000);
		// ensureElementToBeClickable(selecetCylinder);
		if (selcetPlusCylinder.isSelected()) {
			Thread.sleep(3000);
			ensureElementToBeClickable(selcetMinusCylinder);
			selcetMinusCylinder.click();
		} else {
			Thread.sleep(3000);
			ensureElementToBeClickable(selcetPlusCylinder);
			selcetPlusCylinder.click();
			Thread.sleep(3000);
			ensureElementToBeClickable(selcetMinusCylinder);
			selcetMinusCylinder.click();

		}

		try {
			Thread.sleep(4000);
			ensureElementToBeClickable(clickOnConfigDone);
			String str = clickOnConfigDone.getText();
			System.out.println("DOM Data" + str);
			clickOnConfigDone.click();
		} catch (Exception e) {
			// TODO: handle exception
			Thread.sleep(4000);
			clickOnConfigDone.click();
			// e.getMessage();
		}

		Thread.sleep(3000);
		clickOnMyDashBoard.click();
	}
	
	public void performRestoreConfigurationOperation()throws Exception{
		
		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnConfiguration);
		clickOnConfiguration.click();

		Thread.sleep(3000);
		for (WebElement select_ConfigurationModule : selectConfigurationModule) {
			if (select_ConfigurationModule.getText().equalsIgnoreCase("Restore Configuration")) {
				select_ConfigurationModule.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnVisionConfig);
		clickOnVisionConfig.click();
		
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnCurrentTime);
		clickOnCurrentTime.click();
		
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnRestore);
		clickOnRestore.click();
		
		
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnYesBtn);
		clickOnYesBtn.click();
		
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnOkBtn);
		clickOnOkBtn.click();
		
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnRestoreConfigDone);
		clickOnRestoreConfigDone.click();
	}

	// function use for enable element
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
