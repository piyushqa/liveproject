package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ProjectSettings;

public class PageManageAccessPermission {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Manage Access Permissions')]")
	private WebElement clickOnManageAccessPermission;

	@FindBy(how = How.CSS, using = "span#gwt-debug-requiresAtleastOneAlphabet>input")
	private WebElement clickOnForceAtLeastOneAlphabet;

	@FindBy(how = How.CSS, using = "span#gwt-debug-requiresAtleastOneNumber>input")
	private WebElement clickOnRequiresAtLeasOneNumber;

	@FindBy(how = How.CSS, using = "span#gwt-debug-forceMixedCase>input")
	private WebElement clickOnForceMixedCase;

	@FindBy(how = How.CSS, using = "span#gwt-debug-userNameAllowed>input")
	private WebElement clickOnUserNameAllowed;

	@FindBy(how = How.CSS, using = "input#gwt-debug-minPasswordLength")
	private WebElement clickOnMinPassword;

	@FindBy(how = How.CSS, using = "span#gwt-debug-forceSplCharacters>input")
	private WebElement clickOnForceSpecialChar;

	@FindBy(how = How.CSS, using = "a#gwt-debug-saveAnchor.gwt-Anchor")
	private WebElement clickOnSaveBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-userdash-logout>a")
	private WebElement clickOnLogOut;

	@FindBy(how = How.CSS, using = "input#USERNAME")
	private WebElement inputUserName;

	@FindBy(how = How.CSS, using = "input#PASSWORD")
	private WebElement inputPassword;

	@FindBy(how = How.CSS, using = "a.loginButton")
	private WebElement clickOnLoginBtn;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageManageAccessPermission(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageManageAccessPermission.this);
	}

	public void verifyManageAccessPermission(Boolean userNameAllowed, Boolean atLeastOneNumber, Boolean atleastSplChar,
			String providerName, String providerPswd) throws Exception {
		Thread.sleep(3000);
		ensureElementTObeClickable(clickOnManageAccessPermission);
		clickOnManageAccessPermission.click();

		// userNameAllowed(userNameAllowed);
		atLeastOneNumber(atLeastOneNumber, atleastSplChar, providerName, providerPswd);
	}

	public void userNameAllowed(Boolean userNameAllowed) throws Exception {
		try {
			if (clickOnUserNameAllowed.isSelected() && userNameAllowed) {
				clickOnUserNameAllowed.click();
			}
		} catch (Exception e) {
			clickOnUserNameAllowed.click();
		}
		Thread.sleep(3000);
		ensureElementTObeClickable(clickOnSaveBtn);
		clickOnSaveBtn.click();

		loginWithoutUserName();

	}

	public void atLeastOneNumber(Boolean atLeastOneNumber, Boolean atleastSplChar, String providerName,
			String providerPswd) throws Exception {
		try {
			if (clickOnRequiresAtLeasOneNumber.isSelected() && atLeastOneNumber) {
				clickOnRequiresAtLeasOneNumber.click();
			}
		} catch (Exception e) {
			clickOnRequiresAtLeasOneNumber.click();
		}

		
		Thread.sleep(3000);
		if (clickOnForceSpecialChar.isSelected() && atleastSplChar) {
			builder.moveToElement(clickOnForceSpecialChar).click();
		}

		Thread.sleep(3000);
		ensureElementTObeClickable(clickOnSaveBtn);
		clickOnSaveBtn.click();

		loginAtleastOneNumber(providerName, providerPswd);
	}

	public void loginAtleastOneNumber(String providerName, String providerPswd) throws Exception {
		Thread.sleep(3000);
		ensureElementTObeClickable(clickOnLogOut);
		clickOnLogOut.click();

		Thread.sleep(2000);
		ensureElementTObeClickable(inputUserName);
		inputUserName.sendKeys(providerName);

		Thread.sleep(1000);
		ensureElementTObeClickable(inputPassword);
		inputPassword.sendKeys(providerPswd);

		Thread.sleep(2000);
		ensureElementTObeClickable(clickOnLoginBtn);
		clickOnLoginBtn.click();
	}

	public void loginWithoutUserName() throws Exception {

		Thread.sleep(3000);
		ensureElementTObeClickable(clickOnLogOut);
		clickOnLogOut.click();

//		Thread.sleep(2000);
//		ensureElementTObeClickable(inputUserName);
//		inputUserName.sendKeys(ProjectSettings.userName);

		Thread.sleep(1000);
		ensureElementTObeClickable(inputPassword);
		inputPassword.sendKeys(ProjectSettings.password);

		Thread.sleep(2000);
		ensureElementTObeClickable(clickOnLoginBtn);
		clickOnLoginBtn.click();

	}

	private void ensureElementTObeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
