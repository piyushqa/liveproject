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
public  class Facebooklogin  {
	private WebDriver driver;
	SetUp lsetup = new SetUp();
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	private WebElement editboxUsername;
	
	
	public PgLanding validLogin1(String username, String password) throws Exception {
		PgLanding pgLanding = null;
		ProjectSettings.baseURL = driver.getCurrentUrl();
		Reporter.log("URL Details:" + ProjectSettings.baseURL);
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		Reporter.log(ProjectSettings.eol + "Loging in with username: " + username );
		// Waiting for the first element UserName to be Clickable
		wait.until(ExpectedConditions.elementToBeClickable(editboxUsername));
		editboxUsername.sendKeys(username);
		PgLanding pgLanding1 = new PgLanding(driver);
		return pgLanding1;
	
	


}
}
