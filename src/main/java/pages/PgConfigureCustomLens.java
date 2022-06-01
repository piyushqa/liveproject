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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


//create Class
public class PgConfigureCustomLens {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch patientsearch;

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget > a")
	private WebElement clickOnJoinEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-eye-erx")
	private WebElement clickOnErx;

	// create Constructor
	public PgConfigureCustomLens(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	// Create method configureLens
	public void configureLens(String provider, String vision, String AddNew, String CustomLens, String CustomLenses,
			String showFavourites, String customLensEditior) throws InterruptedException {

		// Click on OpenEncounter

		Thread.sleep(5000);
		clickOnJoinEncounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);

		Thread.sleep(6000);
//		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(4000);
			List<WebElement> select_Provider = driver
					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
			for (int i = 1; i <= select_Provider.size(); i++)
				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
					select_Provider.get(i).click();
					break;
				}
	//	}
//		// Thread.sleep(5000);
//		else if (select_RowFromOpenEncounter <= 0) {
//			Thread.sleep(7000);
//			clickStartNewEncounter.click();
//
//		}

		// click on visionTab
		Thread.sleep(2000);
		java.util.List<WebElement> visionClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < visionClick.size(); i++)
			if (visionClick.get(i).getText().equalsIgnoreCase(vision)) {
				visionClick.get(i).click();
				break;
			}

		// click on addNew
		Thread.sleep(5000);

		By addNewClick = By.cssSelector("#content > div > div> div > div > div > div> div > div>span:nth-child(3)");
		driver.findElement(addNewClick).click();

		// click on CustommDisplay
		Thread.sleep(4000);
		By customlensobj = By.cssSelector(
				"#gwt-debug-overlay_content > div > div:nth-child(3) > div > table > tbody > tr > td:nth-child(1) > table > tbody>tr:nth-child(4)>td");
		if (driver.findElement(customlensobj).isDisplayed()) {
			// System.out.println(driver.findElement(customlensobj).isDisplayed());
			driver.findElement(customlensobj).click();

		} else {

			Reporter.log("Configration Custom is Not Display");
		}
		// select from customLensDropDown
		Thread.sleep(10000);
		java.util.List<WebElement> dropdownContactLens = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div[1]/div/div[2]/div[2]/div"));

		for (int i = 0; i < dropdownContactLens.size(); i++) {
			System.out.println(dropdownContactLens.get(i).getText());
			if (dropdownContactLens.get(i).getText().equalsIgnoreCase(CustomLenses)) {
				dropdownContactLens.get(i).click();
				break;
			}
		}
		// click On archiveButton
		Thread.sleep(4000);
		By archiveBtn = By
				.cssSelector("#gwt-debug-overlay_content > div > div> div:nth-child(2) > div > div:nth-child(2) > a");
		driver.findElement(archiveBtn).click();

		// click on OkButton
		Thread.sleep(2000);
		By okBtn = By.xpath("//*[@id=\'gwt-debug-ok\']");
		driver.findElement(okBtn).click();

		// click on showArchiveButton
		Thread.sleep(2000);
		By showArchiveBtn = By.cssSelector(
				"#gwt-debug-overlay_content > div > div > div:nth-child(1) > div > table > tbody > tr > td:nth-child(2) > div > a");
		driver.findElement(showArchiveBtn).click();

		// Click italic customLens
		Thread.sleep(2000);
		By changeArchive = By.tagName("i");
		driver.findElements(changeArchive).get(1).click();

		// click on restoreArchive
		Thread.sleep(2000);
		By restoreArchivebtton = By
				.cssSelector("#gwt-debug-overlay_content > div > div> div:nth-child(2) > div > div:nth-child(3) > a");
		driver.findElement(restoreArchivebtton).click();

		// Click On cancleSymbol
		Thread.sleep(4000);
		By cancelbtton = By.xpath("//*[@id=\'gwt-debug-\']");
		driver.findElements(cancelbtton).get(1).click();

		// click on dropdownLensmake

		Thread.sleep(2000);
		By dropdownLensMake = By.cssSelector("#gwt-debug-lensPopup-od-make-button>div:nth-child(3)");
		driver.findElements(dropdownLensMake).get(0).click();

		// Thread.sleep(2000);
		// By showAllBtn = By
		// .cssSelector("body > div.gwt-PopupPanel > div > div > table > tbody > tr >
		// td:nth-child(1) > div > a");
		// driver.findElement(showAllBtn).click();

		// select element from dropDown customLens
		Thread.sleep(3000);
		java.util.List<WebElement> dropDownShowFavourites = driver

				.findElements(By.cssSelector("#gwt-debug-lensPopup-od-make>div>div"));
		System.out.println(dropDownShowFavourites.size());
		for (int i = 0; i < dropDownShowFavourites.size(); i++) {
			// // System.out.println(dropDownShowFavourites.get(i).getText());
			if (dropDownShowFavourites.get(i).getText().equalsIgnoreCase(showFavourites)) {
				// Thread.sleep(2000);
				dropDownShowFavourites.get(i).click();
				break;
			}
		}

		// click on customLens
		Thread.sleep(3000);
		WebElement element = driver.findElement(customlensobj);
		element.click();

		// click match element from dropDown
		Thread.sleep(3000);
		java.util.List<WebElement> dropdownContactLens1 = driver.findElements(By.cssSelector(
				"#gwt-debug-overlay_content > div > div> div:nth-child(1) > div> div:nth-child(2) > div>div"));
		for (int i = 0; i < dropdownContactLens1.size(); i++) {
			// System.out.println(dropdownContactLens.get(i).getText());
			if (dropdownContactLens1.get(i).getText().equalsIgnoreCase(customLensEditior)) {
				dropdownContactLens1.get(i).click();
				break;
			}
		}
		// click on archive
		Thread.sleep(4000);
		By archivebtn1 = By
				.cssSelector("#gwt-debug-overlay_content > div > div > div:nth-child(2) > div > div:nth-child(2)");
		driver.findElements(archivebtn1).get(1).click();

		Thread.sleep(4000);
		By cancelbtton1 = By.xpath("//*[@id=\'gwt-debug-\']");
		driver.findElements(cancelbtton1).get(1).click();

		Thread.sleep(4000);
		By cancelbtton2 = By.cssSelector("#gwt-debug-overlay_body>div>div>a");
		driver.findElement(cancelbtton2).click();

		// Thread.sleep(2000);
		// if (driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div >
		// div.GPW4UUFDVF")).isDisplayed()) {
		// driver.quit();
		// }
	}

}
