package pages;

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
public class PgConfigBinocularPinhole {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch patientsearch;

	// create Constructor
	public PgConfigBinocularPinhole(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	// Create method configureLens
	public void configureBinocularPinhole(String fName, String lName, String provider, String vision,
			String binocular1Status, String pinHole1Status, String binocular2Status, String pinHole2Status)
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

		// click on configButton
		configButton();
		// check OffButton of Binocular
		Thread.sleep(2000);

		java.util.List<WebElement> binocularOff = driver
				.findElements(By.cssSelector("#gwt-debug-overlay_content > div > div > div:nth-child(6) > div>div"));

		for (int i = 0; i < binocularOff.size(); i++) {

			if (binocularOff.get(i).getText().equalsIgnoreCase(binocular1Status)) {

				driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> a")).click();
			}
		}

		// click on Existing Glass(binocular)
		Thread.sleep(2000);
		addnew();

		// chechkBincoular is display or not in existing glass
		Thread.sleep(2000);
		binocularDisplayForExistingGlass();

		// click on Retraction(bincoluar)
		Thread.sleep(2000);
		addNew1();

		// check bincoular is display or not in Retraction
		Thread.sleep(2000);
		binocularDisplayForRefraction();

		// check OffButton of pinHole
		Thread.sleep(2000);
		configButton();

		Thread.sleep(2000);

		java.util.List<WebElement> pinHole = driver
				.findElements(By.cssSelector("#gwt-debug-overlay_content > div > div> div:nth-child(8) > div>div"));

		for (int i = 0; i < pinHole.size(); i++) {

			if (pinHole.get(i).getText().equalsIgnoreCase(pinHole1Status)) {

				driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> a")).click();

			}
		}

		// pinHole for Existing Glass
		Thread.sleep(2000);
		addnew();
		// check pinHole is display or not in existing glass
		pinHoleForExistingGlass();
		// pinHole for reTraction
		Thread.sleep(2000);
		addNew1();
		// check pinHole is display or not in recfraction
		pinHoleForRetraction();

		// config for onButton
		Thread.sleep(2000);
		configButton();

		// check onButton of Binocular
		Thread.sleep(2000);

		java.util.List<WebElement> binocularOn = driver
				.findElements(By.cssSelector("#gwt-debug-overlay_content > div > div > div:nth-child(6) > div>div"));
		for (int i = 0; i < binocularOn.size(); i++) {
			if (binocularOn.get(i).getText().equalsIgnoreCase(binocular2Status)) {
				binocularOn.get(i).click();
				driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> a")).click();
				break;
			}
		}

		// bincoular with onButton for existing glass
		Thread.sleep(2000);
		addnew();

		// check binocular with existing glass for on Button
		binocularDisplayForExistingGlassWithOnButton();

		// binocular with onButton for refraction
		Thread.sleep(2000);
		addNew1();

		// check binocular with refraction for on button
		binocularDisplayForRefractionWithOnButton();

		// CLICK ON CONFIG BUTTON FOR PINHOLE ON BUTTON
		configButton();

		// Check on button for pinHole
		Thread.sleep(2000);

		java.util.List<WebElement> refractionOn = driver
				.findElements(By.cssSelector("#gwt-debug-overlay_content > div > div > div:nth-child(8) > div>div"));
		for (int i = 0; i < refractionOn.size(); i++) {
			if (refractionOn.get(i).getText().equalsIgnoreCase(pinHole2Status)) {
				refractionOn.get(i).click();
				driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div>a")).click();
				break;
			}
		}
		// pinHole with onButton for existing glass
		Thread.sleep(2000);
		addnew();

		// check pinHole with existing Glass for on button
		pinHoleDisplayForexistingGlassWithOnButton();

		// pinHole With onButton for refraction
		addNew1();

		// check pinHole with refraction for on button
		pinHoleDisplayForrefractionWithOnButton();

		// disable radioButton
		Thread.sleep(2000);
		configButton();

		// off radio Button
		driver.findElement(
				By.cssSelector("#gwt-debug-overlay_content > div > div > div:nth-child(6) >div> div:nth-child(2)"))
				.click();
		driver.findElement(
				By.cssSelector("#gwt-debug-overlay_content > div > div> div:nth-child(8) > div>div:nth-child(2)"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> a")).click();
	}

	public void configButton() throws InterruptedException {
		Thread.sleep(2000);
		By configButton = By.id("gwt-debug-visionConfig");
		driver.findElement(configButton).click();
	}

	// addNew Function for Existing Glass
	public void addnew() throws InterruptedException {
		Thread.sleep(2000);
		By addnewButton = By.xpath("//*[@id=\"gwt-debug-glasses-addNew\"]");
		driver.findElement(addnewButton).click();
	}

	// addNew Function for Retraction
	public void addNew1() throws InterruptedException {
		Thread.sleep(2000);
		By addnewButton1 = By.xpath("//*[@id=\"gwt-debug-refraction-addNew\"]");
		driver.findElement(addnewButton1).click();

	}

	// check BinocularDispalyOrNot
	public void binocularDisplayForExistingGlass() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\'gwt-debug-glasses-0\']/div[2]/div[1]/div[2]")).isDisplayed()) {
			Reporter.log("Elemenet is not display");
		} else {
			driver.findElement(
					By.cssSelector("#gwt-debug-glasses-0 > div:nth-child(1) > div > div:nth-child(5) > span")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div[4]")).click();
		}

	}

	public void binocularDisplayForRefraction() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[2]/div[1]/div[2]")).isDisplayed()) {
			Reporter.log("Elemenet is not display");
		} else {
			driver.findElement(
					By.cssSelector("#gwt-debug-refractions-0 > div:nth-child(1) > div> div:nth-child(5) > span"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> div > div.btn_green>a")).click();
		}

	}

	// check for pinHole for Existing Glass
	public void pinHoleForExistingGlass() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\"gwt-debug-glasses-0\"]/div[3]/div[1]/div[2]")).isDisplayed()) {
			Reporter.log("Elemenet is not display");
		} else {
			driver.findElement(
					By.cssSelector("#gwt-debug-glasses-0 > div:nth-child(1) > div > div:nth-child(5) > span")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div[4]")).click();

		}

	}

	public void pinHoleForRetraction() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[3]/div[1]/div[2]")).isDisplayed()) {
			Reporter.log("Elemenet is not display");
		} else {
			driver.findElement(
					By.cssSelector("#gwt-debug-refractions-0 > div:nth-child(1) > div> div:nth-child(5) > span"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> div > div.btn_green>a")).click();

		}

	}

	// check BinocularDispaly with On radioButton For existing glass
	public void binocularDisplayForExistingGlassWithOnButton() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\'gwt-debug-glasses-0\']/div[2]/div[1]/div[2]")).isDisplayed()) {
			driver.findElement(
					By.cssSelector("#gwt-debug-glasses-0 > div:nth-child(1) > div > div:nth-child(5) > span")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div[4]")).click();

		} else {
			Reporter.log("Elemenet is not display");
		}
	}

	// check BinocularDisplay With on radioButton For refraction
	public void binocularDisplayForRefractionWithOnButton() throws InterruptedException {

		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[2]/div[1]/div[2]")).isDisplayed()) {

			driver.findElement(
					By.cssSelector("#gwt-debug-refractions-0 > div:nth-child(1) > div> div:nth-child(5) > span"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> div > div.btn_green>a")).click();

		} else {

			Reporter.log("Elemenet is not display");
		}

	}

	// check for pinHole for Existing Glass
	public void pinHoleDisplayForexistingGlassWithOnButton() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\"gwt-debug-glasses-0\"]/div[3]/div[1]/div[2]")).isDisplayed()) {
			driver.findElement(
					By.cssSelector("#gwt-debug-glasses-0 > div:nth-child(1) > div > div:nth-child(5) > span")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div[4]")).click();
		} else {
			Reporter.log("Elemenet is not display");
		}

	}

	// check pinHole for refraction
	public void pinHoleDisplayForrefractionWithOnButton() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[3]/div[1]/div[2]")).isDisplayed()) {
			driver.findElement(
					By.cssSelector("#gwt-debug-refractions-0 > div:nth-child(1) > div> div:nth-child(5) > span"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div > div> div > div.btn_green>a")).click();
		} else {
			Reporter.log("Elemenet is not display");
		}

	}

}
