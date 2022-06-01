package pages;

import java.util.Set;

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

public class PgErpEducationResources {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	public static String suggestedDo1;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	@FindBy(how = How.CSS, using = "#gwt-debug-noCharge")
	public WebElement chkCharge;

	public PgErpEducationResources(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void checkEducationResources(String provider, String impPlan, String suggestedDo, String Coding,
			boolean charge) throws InterruptedException {
		suggestedDo1 = suggestedDo;
		// click on dropDown
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#gwt-debug-listOpenEncounterWidget > a")).click();

		// select provider from dropDown
		Thread.sleep(5000);
		java.util.List<WebElement> openCounter = driver
				.findElements(By.cssSelector("#gwt-debug-openEncounterTable > tbody > tr > td:nth-child(3)>div"));
		for (int i = 0; i < openCounter.size(); i++)
			// System.out.println(openCounter.get(i).getText());
			if (openCounter.get(i).getText().equalsIgnoreCase(provider)) {
				openCounter.get(i).click();
				break;
			}

		// select Imp&Plan
		Thread.sleep(4000);
		java.util.List<WebElement> eyeHiostoryClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < eyeHiostoryClick.size(); i++)
			if (eyeHiostoryClick.get(i).getText().equalsIgnoreCase(impPlan)) {
				eyeHiostoryClick.get(i).click();
				break;

			}

		// click on patientEducation
		Thread.sleep(2000);
		By patientEdu = By.cssSelector("#gwt-debug-patientEducation > a");
		driver.findElement(patientEdu).click();

		// click on suggestedDoc
		Thread.sleep(8000);
		java.util.List<WebElement> suggestedDocClick = driver
				.findElements(By.cssSelector("#gwt-debug-suggestedDocs-container>div"));
		for (int i = 0; i < suggestedDocClick.size(); i++)
			if (suggestedDocClick.get(i).getText().equalsIgnoreCase(suggestedDo)) {
				suggestedDocClick.get(i).click();
				break;

			}

		// click on sendtoPortal
		Thread.sleep(6000);
		By sndToPortal = By.cssSelector("#gwt-debug-sugDoc-view > a");
		driver.findElements(sndToPortal).get(0).click();


		//click on cancelButton
		Thread.sleep(6000);
		if (driver.findElement(By.cssSelector("#gwt-debug-overlay_content > div>div:nth-child(1)>div")).isDisplayed()) {
			By cancelBtn = By.cssSelector("#gwt-debug-overlay_body>div>div>a");
			driver.findElement(cancelBtn).click();

		}

		// select coding button
		Thread.sleep(4000);
		java.util.List<WebElement> codingClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < codingClick.size(); i++)
			if (codingClick.get(i).getText().equalsIgnoreCase(Coding)) {
				codingClick.get(i).click();
				break;

			}

		//check on onCharge checkBox
		Thread.sleep(5 * 1000);
		if (!chkCharge.isSelected() && charge)
			chkCharge.click();

		//click on SubmitButton
		Thread.sleep(3000);
		By submitBtn = By.cssSelector("#gwt-debug-submit_and_close ");
		driver.findElement(submitBtn).click();

	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//function work for EducationResources
	public void eduResources() throws InterruptedException {

		//click on educationResources
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(7) > a > span")).click();

		//match the Birth defects and click
		Thread.sleep(4000);
		String findElement1 = driver
				.findElement(By.cssSelector("#search-results > tbody>tr:nth-child(1)>td:nth-child(1)>a")).getText();
		System.out.println(findElement1);
		System.out.println(suggestedDo1);
		Thread.sleep(5000);
		if (findElement1.equals(suggestedDo1)) {
			driver.findElement(By.cssSelector("#search-results > tbody>tr:nth-child(1)>td:nth-child(1)>a")).click();
		}

		//same match the Birth defects and click and then quit
		Thread.sleep(3000);
		String findElement2 = driver
				.findElement(By.cssSelector("#topic > article > div.page-info > div.page-title.syndicate > h1"))
				.getText();
		System.out.println(findElement2);

		Thread.sleep(3000);
		if (findElement2.equals(suggestedDo1)) {
			Reporter.log(findElement2 +" "+ "and" + suggestedDo1 +" "+ " are matched");
			driver.close();
		}

	}
}