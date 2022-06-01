package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;
import utilities.SetUp;

public class ErpLogInPage {
	private WebDriver driver;
	SetUp lsetup = new SetUp();
	// Page elements
	@FindBy(how = How.XPATH, using = ".//input[@id=\"Username\"]")
	private WebElement fillUserName;

	@FindBy(how = How.XPATH, using = ".//input[@id=\"Password\"]")
	private WebElement fillPswd;

	@FindBy(how=How.XPATH,using=".//span[text()=\"Login\"]")
	private WebElement clickOnLogin;

	@FindBy(how = How.XPATH, using = "/html/body/pre")
	private WebElement getAciData;

	// Initiallizing page
	public ErpLogInPage(WebDriver driver) {
		String pgTitle = "Log on";
		this.driver = driver;

		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);
			Reporter.log("%nPgLogin Instantiated");
		} else {
			Reporter.log("Incorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);
		}
	}

	// Function to login
	public PgErpLanding validLogin1(String username, String password) throws Exception {
		// public PgLanding validLogin1() throws Exception {
		PgErpLanding pgErpLanding = null;
//		ProjectSettings.baseURL = driver.getCurrentUrl();
//		Reporter.log("URL Details:" + ProjectSettings.baseURL);
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		Reporter.log(ProjectSettings.eol + "Loging in with username: " + username + "Password: " + password);
		// Waiting for the first element UserName to be Clickable
		wait.until(ExpectedConditions.elementToBeClickable(fillUserName));
		fillUserName.sendKeys(username);
		// editboxUsername.sendKeys(ProjectSettings.userName);
		fillPswd.sendKeys(password);
		// editboxPassword.sendKeys(ProjectSettings.password);
		clickOnLogin.click();
//		wait.until(ExpectedConditions.elementToBeClickable(imgLogo));
//		ProjectSettings.buildNumber = imgLogo.getAttribute("title");
//		Reporter.log("Build Details: " + ProjectSettings.buildNumber);
//		System.out.print("AUT Build Number: " + ProjectSettings.buildNumber);
		// driver.close();
		// driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		// driver.manage().window().maximize();
		Thread.sleep(2000);

//		driver.navigate().to(ProjectSettings.aciConnectorURL);
//
//		String storeConnectorNumber = getAciData.getText();
//		int l = storeConnectorNumber.length();
//		// System.out.println("Length"+l);
//		ProjectSettings.aciConnectorNumber = storeConnectorNumber.substring(12, 17);
//		Reporter.log("Aci ConnectorNumber" + ProjectSettings.aciConnectorNumber);
//		System.out.println("aci Connector Number" + ProjectSettings.aciConnectorNumber);

		// Returning next page (landing) in sequence
		pgErpLanding = new PgErpLanding(driver);
		return pgErpLanding;
		// Assert.assertEquals(driver.getTitle(), "Integrity EMR");
	}

}
