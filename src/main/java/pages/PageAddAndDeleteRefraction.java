package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAddAndDeleteRefraction {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// Define Locater

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;

	@FindBy(how = How.XPATH, using = ".//span[@id=\"gwt-debug-refraction-addNew\"]")
	private WebElement getAddNewValueOfRefraction;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[5]/span")
	private WebElement getDeleteValueOfRefraction;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ok\" and text()='Yes']")
	private WebElement clickOnYesButton;

	public PageAddAndDeleteRefraction(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void verfiyAddAndDeleteRefraction(String provider, String od, String odSphere, String odCyliender,
			String odAxis, String odAdd, String os, String osSphere, String osCyliender, String osAxis, String osAdd,
			String prism, String prism1, String prism2, String prism3, String odDistance, String osDistance,
			String odIntermediate, String osIntermediate, String odNear, String osNear, String OdComment,
			String osComment, String visitType, Boolean noCharges) throws Exception {

		Thread.sleep(3000);
		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		// click on visionTab
		Thread.sleep(6000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVisonTab)).click();
		Thread.sleep(4000);
		PgEncounter encounter = new PgEncounter(driver, wait, builder);
		String strAddNew = "Add New";
		String getValueOfAddNew = getAddNewValueOfRefraction.getText();
		Thread.sleep(4000);
		// Add new refraction and then delete
		if (strAddNew.equalsIgnoreCase(getValueOfAddNew)) {
			encounter.addNewRefraction(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender, osAxis,
					osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate,
					odNear, osNear, OdComment, osComment);

			Thread.sleep(4000);
			String strDelete = "Delete";
			String getValueOfdelete = getDeleteValueOfRefraction.getText();
			if (strDelete.equalsIgnoreCase(getValueOfdelete)) {
				wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
				wait.until(ExpectedConditions.elementToBeClickable(getDeleteValueOfRefraction)).click();
				wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
				wait.until(ExpectedConditions.elementToBeClickable(clickOnYesButton)).click();
			}
		}
		//new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}
}
