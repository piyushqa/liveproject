package pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class PgPatientDataModification {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmsId")
	private WebElement clickPMSId;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmMrn")
	private WebElement clickMRN;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmFirstName")
	private WebElement clickFirstName;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmLastName")
	private WebElement clickLastName;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(1)")
	private WebElement clickbxDobMonth;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(2)")
	private WebElement clickbxDobDay;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(3)")
	private WebElement clickbxDobYear;

	@FindBy(how = How.CSS, using = "#gwt-debug-genderSelect-button")
	private WebElement clickbxGender;

	@FindBy(how = How.CSS, using = "#gwt-debug-saveButton")
	private WebElement btnCreate;

	public PgPatientDataModification(WebDriver driver, WebDriverWait wait, Actions action) {

		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void performModifyPatient(String PMSID, String MRN, String firstName, String lastName, String month,
			String date, String year, String gender) throws InterruptedException {

		// modify PMSID
		Thread.sleep(2000);
		clickPMSId.clear();
		Random random = new Random();
		int n = 10000 + random.nextInt(900000);
		PMSID = Integer.toString(n);
		clickPMSId.sendKeys(PMSID);

		// modify MRN
		Thread.sleep(2000);
		clickMRN.clear();
		Random random1 = new Random();
		int n1 = 10000 + random1.nextInt(900000);   
		MRN = Integer.toString(n1);
		clickMRN.sendKeys(MRN);

		Thread.sleep(2000);
		clickFirstName.clear();
		clickFirstName.sendKeys(firstName);

		// Fill lastName
		Thread.sleep(2000);
		clickLastName.clear();
		clickLastName.sendKeys(lastName);

		// modify month
		Thread.sleep(2000);
		clickbxDobMonth.click();
		Random r1 = new Random();
		int n3 = 2 + r1.nextInt(1);
		month = Integer.toString(n3);
		java.util.List<WebElement> clickOnmonth = driver
				.findElements(By.cssSelector("#gwt-debug-dateOfBirth > select:nth-child(1)>option"));
		for (int i = 0; i < clickOnmonth.size(); i++)
			if (clickOnmonth.get(i).getText().equalsIgnoreCase(month)) {
				clickOnmonth.get(i).click();
				break;
			}
		// modify date
		Thread.sleep(2000);
		clickbxDobDay.click();
		Random r2 = new Random();
		int n4 = 11 + r2.nextInt(13);
		month = Integer.toString(n4);
		java.util.List<WebElement> clickOnday = driver
				.findElements(By.cssSelector("#gwt-debug-dateOfBirth > select:nth-child(2)>option"));
		for (int i = 0; i < clickOnday.size(); i++)
			if (clickOnday.get(i).getText().equalsIgnoreCase(date)) {
				clickOnday.get(i).click();
				break;
			}

		// modify year
		Thread.sleep(2000);
		clickbxDobYear.click();
		Random r3 = new Random();
		int n5 = 1911 + r3.nextInt(1121);
		month = Integer.toString(n5);
		java.util.List<WebElement> clickOnYear = driver
				.findElements(By.cssSelector("#gwt-debug-dateOfBirth > select:nth-child(3)>option"));
		for (int i = 0; i < clickOnYear.size(); i++)
			if (clickOnYear.get(i).getText().equalsIgnoreCase(year)) {
				clickOnYear.get(i).click();
				break;
			}
		// modify Gender
		Thread.sleep(2000);
		clickbxGender.click();
		java.util.List<WebElement> clickOnGender = driver
				.findElements(By.cssSelector("#gwt-debug-genderSelect-container>div"));
		for (int i = 0; i < clickOnGender.size(); i++)
			if (clickOnGender.get(i).getText().equalsIgnoreCase(gender)) {
				clickOnGender.get(i).click();
				break;
			}
		// Cilck On save Button
		Thread.sleep(4000);
		btnCreate.click();
	}

}
