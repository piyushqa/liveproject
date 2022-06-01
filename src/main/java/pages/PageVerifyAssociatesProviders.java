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

public class PageVerifyAssociatesProviders {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.XPATH, using = ".//div[contains(text(),'Assoc. Providers')]")
	private WebElement clickOnAssProvders;

	@FindBy(how = How.XPATH, using = ".//td[contains(text(),'Select Provider Tag')]")
	private WebElement clickOnSelectProviderTag;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/div[2]/table/tbody/tr/td")
	private List<WebElement> select_Provider;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */

	public PageVerifyAssociatesProviders(WebDriver driver, WebDriverWait wait, Actions builder) {
		// TODO Auto-generated constructor stub
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageVerifyAssociatesProviders.this);
	}

	public void verifyAssociatesproviders(String provider) throws Exception {
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnAssProvders);
		clickOnAssProvders.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnSelectProviderTag);
		clickOnSelectProviderTag.click();

		Thread.sleep(3000);
		int sizeOfSelectProviderTag = select_Provider.size();
		System.out.println("sizeOfSelectProviderTag:" + " " + sizeOfSelectProviderTag);
		
		Thread.sleep(4000);
		for (WebElement selectProvider : select_Provider) {
			System.out.println(selectProvider.getText());
			
		}

	}

	// function use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
