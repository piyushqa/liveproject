
//PgpAppintmentsTest.java
package pages;

import java.util.Random;

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

public class PgAddAppintments {
	@FindBy(how = How.CSS, using = "#gwt-debug-provider")
	private WebElement provider;
	@FindBy(how = How.CSS, using = "#gwt-debug-pmsAppointmentId")
	private WebElement appointmentid;

	@FindBy(how = How.CSS, using = "#gwt-debug-clinicSite")
	private WebElement clinicsite;

	@FindBy(how = How.CSS, using = "#gwt-debug-visitType")
	private WebElement visittype;

	@FindBy(how = How.CSS, using = "#gwt-debug-status")
	private WebElement status;
	// For Date
	@FindBy(how = How.CSS, using = "#gwt-debug-appt-day")
	private WebElement lstbxDobDay;
	@FindBy(how = How.CSS, using = "#gwt-debug-appt-month")
	private WebElement lstbxDobMonth;

	@FindBy(how = How.CSS, using = "#gwt-debug-appt-year")
	private WebElement lstbxDobYear;
	// For Time
	@FindBy(how = How.CSS, using = "#gwt-debug-hours")
	private WebElement lstbxHour;
	@FindBy(how = How.CSS, using = "#gwt-debug-mins")
	private WebElement lstbxMin;

	@FindBy(how = How.CSS, using = "#gwt-debug-timePeriod")
	private WebElement lstbxformat;

	@FindBy(how = How.CSS, using = "#gwt-debug-Done")
	private WebElement donebutton;

	private WebDriver driver;
	private WebDriverWait wait;
	@SuppressWarnings("unused")
	private Actions actions;

	public PgAddAppintments(WebDriver driver, WebDriverWait wait, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}

	public void addAppointment(String provider, String clinic, String visit, String status, String date, String time)
			throws InterruptedException {

		if (provider != null && !provider.equals("")) {
			By selectBoxProviderType = By.cssSelector("#gwt-debug-provider");
			ensureElementToBeClickable(selectBoxProviderType);
			Select providerTypeSelector = new Select(driver.findElement(selectBoxProviderType));
			providerTypeSelector.selectByValue(provider);
		}
		// This is for random number generator
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		String numberAsString = Integer.toString(n);
		wait = new WebDriverWait(driver, 10, 500);
		By AppointmentID = By.cssSelector("#gwt-debug-pmsAppointmentId");
		ensureElementToBeClickable(AppointmentID);
		driver.findElement(AppointmentID).sendKeys(numberAsString);

		// This is the selection of clinic type
		if (clinic != null && !clinic.equals("")) {
			By selectBoxClinicType = By.cssSelector("#gwt-debug-clinicSite");
			ensureElementToBeClickable(selectBoxClinicType);
			Select providerTypeSelector = new Select(driver.findElement(selectBoxClinicType));
			providerTypeSelector.selectByValue(clinic);
		}
		// This is the selection of visitType
		if (clinic != null && !clinic.equals("")) {
			By selectBoxVisitType = By.cssSelector("#gwt-debug-visitType");
			ensureElementToBeClickable(selectBoxVisitType);
			Select providerTypeSelector = new Select(driver.findElement(selectBoxVisitType));
			providerTypeSelector.selectByValue(visit);
		}

		// This is the selection of StatusType
		if (status != null && !status.equals("")) {
			By selectBoxStatusType = By.cssSelector("#gwt-debug-status");
			ensureElementToBeClickable(selectBoxStatusType);
			Select providerTypeSelector = new Select(driver.findElement(selectBoxStatusType));
			providerTypeSelector.selectByValue(status);
		}
		// This is a the selection of Date
		Thread.sleep(2 * 1000);
		String[] dobArray = date.split("-");
		Select selectDOBD = new Select(lstbxDobDay);

		String day = dobArray[0];
		selectDOBD.selectByVisibleText(day);

		String month = dobArray[1];
		ensureElementToBeClickable(lstbxDobMonth);
		Select selectDOBM = new Select(lstbxDobMonth);
		// Thread.sleep(3 * 1000);
		selectDOBM.getOptions().size();
		selectDOBM.selectByVisibleText(month);

		Select selectDOBY = new Select(lstbxDobYear);
		selectDOBY.selectByVisibleText(dobArray[2]);

		// This is the selection of Time

		String[] doaArray = time.split("/");
		Select selecttimeh = new Select(lstbxHour);

		String hour = doaArray[0];
		selecttimeh.selectByVisibleText(hour);

		String minutes = doaArray[1];
		Select selecttimem = new Select(lstbxMin);
		selecttimem.selectByVisibleText(minutes);

		Select selecttimef = new Select(lstbxformat);
		selecttimef.selectByVisibleText(doaArray[2]);

		// Click on Done Button
		ensureElementToBeClickable(donebutton);
		donebutton.click();

	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
