package pages;

import static org.testng.Assert.assertEquals;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



//create Class
public class PgDominantEyeCheck {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch patientsearch;

	// create Constructor
	public PgDominantEyeCheck(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	// Create method configureLens
	public void dominantEyeCheck(String fName, String lName, String provider, String vision, String dominantEye)
			throws InterruptedException {

		// Click on OpenEncounter
		Thread.sleep(3000);
		try {
			if (driver.findElements(By.xpath("//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")).size() > 0)

			{

				driver.findElement(By.xpath("//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")).click();
			}
		} catch (Exception e) {
			System.out.println("Element not found" + e);
		}


		//click On Provider
		Thread.sleep(2000);
		java.util.List<WebElement> openCounter = driver
				.findElements(By.cssSelector("#gwt-debug-openEncounterTable > tbody > tr > td:nth-child(3)>div"));
		for (int i = 0; i < openCounter.size(); i++)
			// System.out.println(openCounter.get(i).getText());
			if (openCounter.get(i).getText().equalsIgnoreCase(provider)) {
				openCounter.get(i).click();
				break;
			}

		// click on visionTab
		Thread.sleep(2000);
		java.util.List<WebElement> visionClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < visionClick.size(); i++)
			if (visionClick.get(i).getText().equalsIgnoreCase(vision)) {
				visionClick.get(i).click();
				break;
			}

		//click on dominantEye
		By clickOndominantEye = By.xpath("//*[@id=\"gwt-debug-dominantEye-button\"]/div[3]");
		driver.findElement(clickOndominantEye).click();


		//select from dominant Eye
		Thread.sleep(4000);
		java.util.List<WebElement> dominanteye = driver
				.findElements(By.cssSelector("#gwt-debug-dominantEye > div>div"));
		for (int i = 0; i < dominanteye.size(); i++)
			if (dominanteye.get(i).getText().equalsIgnoreCase(dominantEye)) {
				dominanteye.get(i).click();
				break;
			}

		// click on addNew
		Thread.sleep(5000);

		By addNewClick = By.cssSelector("#content > div > div> div > div > div > div> div > div>span:nth-child(3)");
		driver.findElement(addNewClick).click();



		//match the both dominantEye
		Thread.sleep(18000);

		String element=driver.findElement(By.cssSelector("#gwt-debug-lensPopup-dominantEye-button > div.gwt-Label.GIGNACEDN4B")).getText();
		System.out.println(element);
		assertEquals(dominantEye, element);

		driver.quit();

	}
}
