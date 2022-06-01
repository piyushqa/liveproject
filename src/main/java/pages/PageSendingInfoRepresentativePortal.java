package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageSendingInfoRepresentativePortal {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String firstWinHandle;
	// element locater

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-close_overlay\"]/a[contains(@class,'close')]")
	private WebElement clickOnClose;

	@FindBy(how = How.XPATH, using = ".//*[starts-with(@class,'datalist-item')]/div[(contains(@class,'gwt-Label'))][2]")
	private WebElement clickOnEMRAllergis;

	public PageSendingInfoRepresentativePortal(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageSendingInfoRepresentativePortal.this);
	}

	public void verifySendingInfoRepresentativePortal(String allergies, String recation, String severity, String Date,
			String category, String subCategory1, String subCategory2, String eye, String galuocmaSeverity,
			String galuocmaStability, Boolean significantProblem, String visitType, Boolean noCharges,
			String fileLocation, String renameFileName) throws Exception {

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		new PageAddAllergies(driver, wait, builder).launchDrFirst();

		new PageAddAllergies(driver, wait, builder).addAllergie(allergies, recation, galuocmaSeverity, Date);

		// close dr first
		closeDrFirst();

		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	public void closeDrFirst() throws Exception {
		Thread.sleep(2000);
		driver.close();

		// Switch to EMR
		Thread.sleep(3000);
		driver.switchTo().window(firstWinHandle);

		// click on close(Dr first launch window)
		Thread.sleep(2000);
		builder.moveToElement(clickOnClose).click().perform();

	}
}
