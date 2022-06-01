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

public class PageAddDataKeratomatery {
	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	// Define Locatder

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;
	
	

	public PageAddDataKeratomatery(WebDriverWait wait, WebDriver driver, Actions builder) {

		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void verfiyKeratomateryData(String provider, String rightRadius, String rightAxis, String rightPower,
			String leftRadius, String leftAxis, String leftPower, String instrument) throws Exception {
		// click On Open encounter
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickJionOpenencounter));
		clickJionOpenencounter.click();

		// check encounter contain any provider then join otherwise start new encounter
		Thread.sleep(5000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(5000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(7000);
			List<WebElement> select_Provider = driver
					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
			for (int i = 1; i <= select_Provider.size(); i++)
				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
					select_Provider.get(i).click();
					break;
				}
		}

		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

		}
		// click on visionTab

		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVisonTab)).click();

		PgEncounter encounter = new PgEncounter(driver, wait, builder);
		encounter.addNewKeratometry(rightRadius, rightAxis, rightPower, leftRadius, leftAxis, leftPower, instrument);

	
	}

}
