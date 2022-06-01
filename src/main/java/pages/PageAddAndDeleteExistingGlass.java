package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAddAndDeleteExistingGlass {
	WebDriverWait wait;
	WebDriver driver = null;;
	Actions builder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div")
	private List<WebElement> selectProvider;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-addNew\"]")
	private WebElement getAddNewExistingGlass;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[5]/span")
	private WebElement getDeleteExistingGlass;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()='Yes']")
	private WebElement clickOnYesButton;

	public PageAddAndDeleteExistingGlass(WebDriverWait wait, WebDriver driver, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void verifyAddAndDeleteExistingGlass(String provider, String od, String odSphere, String odCyliender,
			String odAxis, String odAdd, String os, String osSphere, String osCyliender, String osAxis, String osAdd,
			String prism, String prism1, String prism2, String prism3, String odDistance, String osDistance,
			String odIntermediate, String osIntermediate, String odNear, String osNear, String OdComment,
			String osComment, String visitType, Boolean noCharges) throws Exception {

		Thread.sleep(2000);
		joinOpenEncounter(provider);

		// click on visionTab

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVisonTab)).click();
		Thread.sleep(2000);
		// Intialize PgEncounter calss
		PgEncounter p1 = new PgEncounter(driver, wait, builder);
		String strAddNew = "Add New";
		String getValueOfAddNew = getAddNewExistingGlass.getText();
		if (strAddNew.equalsIgnoreCase(getValueOfAddNew)) {
			// call Method
			p1.addNewExistingglass(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender, osAxis, osAdd,
					prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate, odNear,
					osNear, OdComment, osComment);
			Thread.sleep(2000);
			String strDelete = "Delete";
			String getValueOfdelete = getDeleteExistingGlass.getText();
			if (strDelete.equalsIgnoreCase(getValueOfdelete)) {
				wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
				wait.until(ExpectedConditions.elementToBeClickable(getDeleteExistingGlass)).click();
				wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
				wait.until(ExpectedConditions.elementToBeClickable(clickOnYesButton)).click();
			}
		}
		//new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	public void joinOpenEncounter(String provider) throws Exception {
		// click join encounter and select provider
		Thread.sleep(7000);
		clickJionOpenencounter.click();
		Thread.sleep(3000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		// System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(1000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
			for (WebElement select_JoinencounterProvider : selectProvider) {
				if (select_JoinencounterProvider.getText().equalsIgnoreCase(provider)) {
					select_JoinencounterProvider.click();
					break;
				}
			}
		}

		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

		}

	}
}
