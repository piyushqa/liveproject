package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSurgeryModuleWithTemplate {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.LINK_TEXT, using = "Configuration")
	private WebElement clickOnConfigurationLink;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	private List<WebElement> selectNotifyProvider;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"card surgery-config\"]/div[2]/ul/li/a/span")
	private List<WebElement> selectConfigOptions;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/table/tbody")
	private WebElement scrollViewTheTable;

	@FindBy(how = How.XPATH, using = ".//td[@class=\"configurableTemplateGroupTempNameFont\" and text()=\"  Add New Item...\"]")
	private WebElement clickOnAddNewItem;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"card category-config-inactive surgerconfig\"]/table/tbody/tr/td")
	private List<WebElement> selectTemplate;

	@FindBy(how = How.XPATH, using = ".//mark[contains(text(),'ankit')]")
	private WebElement clickOnText;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageSurgeryModuleWithTemplate(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageSurgeryModuleWithTemplate.this);
	}

	public void verifySurgeryModuleWithTemplate(String tempalteName, String renameTemplate) throws Exception {

		Thread.sleep(3000);
		ensureElememtToBeClickable(clickOnConfigurationLink);
		clickOnConfigurationLink.click();

		surgeryModule();

		addNewItemInSurgery(tempalteName, renameTemplate);

	}

	public void surgeryModule() throws Exception {
		for (WebElement select_NotifyProvider : selectNotifyProvider) {
			if (select_NotifyProvider.getText().equalsIgnoreCase("Surgery Module")) {
				select_NotifyProvider.click();
				break;
			}
		}
	}

	public void addNewItemInSurgery(String tempalteName, String renameTemplate) throws Exception {

		for (WebElement select_ConfigOptions : selectConfigOptions) {
			if (select_ConfigOptions.getText().equalsIgnoreCase("Surgery Categories")) {
				select_ConfigOptions.click();
				break;
			}
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", scrollViewTheTable);

//		Thread.sleep(2000);
//		ensureElememtToBeClickable(clickOnAddNewItem);
//		clickOnAddNewItem.click();
		Thread.sleep(6000);
		try {
			for (WebElement select_Template : selectTemplate) {
				if (select_Template.getText().equalsIgnoreCase(tempalteName)) {
					// System.out.println(select_Template);
					select_Template.click();
					break;
				}

			}
		} catch (Exception ex) {
			for (WebElement select_Template : selectTemplate) {
				if (select_Template.getText().equalsIgnoreCase(tempalteName)) {
					// System.out.println(select_Template);
					select_Template.click();
					break;
				}

			}
		}

		Thread.sleep(8000);
		WebElement templateElement = driver.findElement(By
				.xpath(".//span[@class=\"categoryRename configurableTemplateGroupTempNameFont\"]/span[contains(text(),'"
						+ tempalteName + "')]"));
//		Thread.sleep(5000);

		String name = templateElement.getText();
		System.out.println(name);
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click();", templateElement);

		Thread.sleep(3000);
		WebElement templateElement1 = driver.findElement(By.xpath(
				".//span[@class=\"categoryRename configurableTemplateGroupTempNameFont\"]/input[contains(text(),'"
						+ tempalteName + "')]"));
		jse.executeScript("arguments[0].value = '';", templateElement1);
////		clickOnText.sendKeys(renameTemplate);
//		Thread.sleep(5000);
//		
//		Thread.sleep(5000);
//		clickOnText.sendKeys(renameTemplate);
	}

	// fuction is used for visibility and clickAble of elements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
