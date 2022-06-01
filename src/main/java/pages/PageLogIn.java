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

public class PageLogIn {
	private WebDriver driver;
	SetUp lsetup = new SetUp();
	// Page elements
	@FindBy(how = How.CSS, using = "#USERNAME")
	private WebElement editboxUsername;

	@FindBy(how = How.CSS, using = "#PASSWORD")
	private WebElement editboxPassword;

	@FindBy(how = How.CSS, using = "#lform > a.loginButton")
	private WebElement btnLogin;

	@FindBy(how = How.CSS, using = "#gwt-debug-userdash-logout > a:nth-child(3)")
	private WebElement btnLogout;

	@FindBy(how = How.CSS, using = "a:contains('Patient Search')")
	private WebElement lnkPatientSearch;

	@FindBy(how = How.CSS, using = "#t_footer_section>img.logo")
	private WebElement imgLogo;

	@FindBy(how = How.CSS, using = "#t_footer_section>img.logo")
	private WebElement myCareIntegrityLinkForBuildNo;

	@FindBy(how = How.CSS, using = "")
	private WebElement buildBaloon;

	@FindBy(how = How.XPATH, using = "/html/body/pre")
	private WebElement getAciData;

	// Initiallizing page
	public PageLogIn(WebDriver driver) {
		String pgTitle = "Integrity EMR";
		this.driver = driver;

		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);
			Reporter.log("%nPgLogin Instantiated");
		} else {
			Reporter.log("Incorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);
		}
	}

	// Function to login
	public PgLanding validLogin1(String username, String password) throws Exception {
		// public PgLanding validLogin1() throws Exception {
		PgLanding pgLanding = null;
		ProjectSettings.baseURL = driver.getCurrentUrl();
		Reporter.log("URL Details:" + ProjectSettings.baseURL);
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		Reporter.log(ProjectSettings.eol + "Loging in with username: " + username + "Password: " + password);
		// Waiting for the first element UserName to be Clickable
		wait.until(ExpectedConditions.elementToBeClickable(editboxUsername));
		editboxUsername.sendKeys(username);
		// editboxUsername.sendKeys(ProjectSettings.userName);
		editboxPassword.sendKeys(password);
		// editboxPassword.sendKeys(ProjectSettings.password);
		btnLogin.click();
		wait.until(ExpectedConditions.elementToBeClickable(imgLogo));
		ProjectSettings.buildNumber = imgLogo.getAttribute("title");
		Reporter.log("Build Details: " + ProjectSettings.buildNumber);
		System.out.print("AUT Build Number: " + ProjectSettings.buildNumber);
		// driver.close();
		// driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		// driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.navigate().to(ProjectSettings.baseURL);

		String storeConnectorNumber = getAciData.getText();
		int l = storeConnectorNumber.length();
		// System.out.println("Length"+l);
		ProjectSettings.aciConnectorNumber = storeConnectorNumber.substring(12, 17);
		Reporter.log("Aci ConnectorNumber" + ProjectSettings.aciConnectorNumber);
		System.out.println("aci Connector Number" + ProjectSettings.aciConnectorNumber);

		// Returning next page (landing) in sequence
		pgLanding = new PgLanding(driver);
		return pgLanding;
		// Assert.assertEquals(driver.getTitle(), "Integrity EMR");
	}

}
