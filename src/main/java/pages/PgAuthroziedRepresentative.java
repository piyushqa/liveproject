package pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

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
import org.testng.Assert;

public class PgAuthroziedRepresentative {
	String exception = null;
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	Actions action;
	PgPatientSearch lclPgPatientSearch;
	private String lName;
	@FindBy(how = How.CSS, using = "#gwt-debug-patient-relationship-button")
	private WebElement relaptionshipToPatient;
	@FindBy(how = How.CSS, using = "#gwt-debug-patient-relationship-container")
	private WebElement relationshipContainer;

	public PgAuthroziedRepresentative(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		// this.action = action;
		PageFactory.initElements(driver, this);

	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void addAuthroziedRepresentative(String name, String phoneNumber, String email,
			String relationshipToThePatient, String fName, String lName) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000);

		element = driver.findElement(By.linkText("Authorized Representatives"));
		element.click();

		Thread.sleep(500);
		element = driver.findElement(By.linkText("Add New Authorized Representative"));
		element.click();

		Thread.sleep(500);
		By clickSelectPatient = By.xpath("//*[@id=\'gwt-debug-patient-select\']");
		// ensureElementToBeClickable(clickSelectPatient);
		driver.findElement(clickSelectPatient).click();
		Thread.sleep(1000);
		boolean editPatient = false;
		lclPgPatientSearch = new PgPatientSearch(driver);

		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		Thread.sleep(2000);

		element = driver.findElement(By.xpath("//*[@id=\"gwt-debug-authRep-name\"]"));
		element.sendKeys(name);
		element = driver.findElement(By.xpath("//*[@id='gwt-debug-authRep-phone']"));
		element.sendKeys(phoneNumber);

		element = driver.findElement(By.xpath("//*[@id=\"gwt-debug-authRep-username\"]"));
		element.sendKeys(email);

		relaptionshipToPatient.click();
		Thread.sleep(3000);

		for (WebElement e : relationshipContainer.findElements(By.xpath(".//*"))) {

			System.out.println(e.getText());

			if (e.getText().equalsIgnoreCase(relationshipToThePatient)) {
				e.click();
				break;

			}

		}
		element = driver.findElement(By.xpath("//*[@id='gwt-debug-authRep-done']/a"));
		element.click();

		// assertAdvertisingBlog();

		assertAdvertisingBlog();
		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));

		assertAdvertisingBlog();

		// Do what you want here, you are in the new tab

		// driver.close();
		// change focus back to old tab
		// driver.switchTo().window(oldTab);
		// assertStartAdvertising();

		// Do what you want here, you are in the old tab
	}

	// private void assertStartAdvertising() {
	// assertEquals("Patient Account Exists", driver.getTitle());
	// }

	private void assertAdvertisingBlog() {
		assertEquals("Integrity EMR", driver.getTitle());
	}

}
