package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;

public class PageMissalenousExample {
	WebDriver driver;
	Actions builder;
	WebDriverWait wait;

	// @FindBy(how = How.LINK_TEXT, using = "Configuration")
	@FindBy(how = How.XPATH, using = ".//a[text()=\"Configuration\"]")
	private WebElement clickOnConfigruation;

	@FindBy(how = How.LINK_TEXT, using = "Patient Search")
	private WebElement clickOnPatientSearch;

	@FindBy(how = How.CSS, using = "#gwt-debug-tabbedPopup-tabContainer>div>div")
	private List<WebElement> selectMissleanousTab;

	@FindBy(how = How.CSS, using = "#gwt-debug-misc-patient-search-field-button>div:nth-child(3)")
	private WebElement clickOnDefaultpatientField;

	@FindBy(how = How.CSS, using = "#gwt-debug-misc-patient-search-field-container>div")
	private List<WebElement> selectDefaultPatientField;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[2]/a")
	private WebElement clickOnDone;

	@FindBy(how = How.CSS, using = "input#gwt-debug-patientFirstName")
	private WebElement fillValueInFirstName;

	@FindBy(how = How.CSS, using = "input#gwt-debug-patientLastName")
	private WebElement fillValueInLastName;

	@FindBy(how = How.CSS, using = "input#gwt-debug-mrn")
	private WebElement fillValueInMRN;

	@FindBy(how = How.CSS, using = "input#gwt-debug-SsnField1")
	private WebElement fillValueInSSN1;

	@FindBy(how = How.CSS, using = "input#gwt-debug-SsnField2")
	private WebElement fillValueInSSN2;

	@FindBy(how = How.CSS, using = "input#gwt-debug-SsnField3")
	private WebElement fillValueInSSN3;

	@FindBy(how = How.CSS, using = "select#gwt-debug-search-month")
	private WebElement clickOnMonthBox;

	@FindBy(how = How.CSS, using = "select#gwt-debug-search-month>option")
	private List<WebElement> selectMonth;

	@FindBy(how = How.CSS, using = "select#gwt-debug-search-day")
	private WebElement clickOnDaybox;

	@FindBy(how = How.CSS, using = "select#gwt-debug-search-day>option")
	private List<WebElement> selectDaybox;

	@FindBy(how = How.CSS, using = "select#gwt-debug-search-year")
	private WebElement clickOnYearBox;

	@FindBy(how = How.CSS, using = "select#gwt-debug-search-year>option")
	private List<WebElement> selectYearBox;

	@FindBy(how = How.CSS, using = "div#gwt-debug-searchButton>a")
	private WebElement clickOnSearch;

	public PageMissalenousExample(WebDriver driver, Actions builder, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.builder = builder;
		this.wait = wait;
		PageFactory.initElements(driver, PageMissalenousExample.this);
	}

	public void verifyMissleanous(String fName, String lName, String mrn, String gender, String dob, String ssn,
			String value) throws Exception {

		// invoke selectMissleanousData method
		// driver.manage().timeouts().implicitlyWait(ProjectSettings.elementWaitTimeOut,
		// TimeUnit.SECONDS);
		Thread.sleep(2000);
		selectMissleanousData(value);

		// click on search patient
		Thread.sleep(2000);
		clickOnPatientSearch.click();

		// select drop down
		Thread.sleep(2000);
		switch (value) {
		case "First Name":
			checkColourofFirstName(fName);
			break;
		case "Last Name":
			checkColourofLastName(lName);
			break;
		case "MRN#":
			checkColourofMRN(mrn);
			break;
		case "Date of Birth":
			checkColourofDOB(dob);
			break;
		case "SSN#":
			checkColourofSSN(ssn);
			break;
		default:
			Reporter.log("No value match so program terminate");
		}
	}

	public void selectMissleanousData(String value) throws Exception {

		// driver.manage().timeouts().implicitlyWait(ProjectSettings.elementWaitTimeOut,
		// TimeUnit.SECONDS);
		// click on configuration
		Thread.sleep(2000);
		builder.moveToElement(clickOnConfigruation).click().build().perform();

		// selct missleanous value
		Thread.sleep(3000);
		for (WebElement select_Missleanous : selectMissleanousTab) {
			if (select_Missleanous.getText().equalsIgnoreCase("Miscellaneous")) {
				select_Missleanous.click();
				break;
			}
		}

		// click on default patient field dropdown
		Thread.sleep(2000);
		clickOnDefaultpatientField.click();

		// invoke method select default patient field
		selectDefaultPatientField(value);

		// click on done
		Thread.sleep(2000);
		clickOnDone.click();

	}

	public void selectDefaultPatientField(String value) throws Exception {
		// select value (FirstName,LastName,MRN,SSN,DOB)
		for (WebElement select_DefaultPatientFeild : selectDefaultPatientField) {
			if (select_DefaultPatientFeild.getText().equalsIgnoreCase(value)) {
				select_DefaultPatientFeild.click();
				break;
			}

		}

	}

	// function for firstName
	public void checkColourofFirstName(String fName) throws Exception {

		// fill Value In FirstName
		Thread.sleep(2000);
		fillValueInFirstName.sendKeys(fName);
		// click On Search
		Thread.sleep(3000);
		builder.moveToElement(clickOnSearch).click().build().perform();
		// get text border color
		Thread.sleep(2000);
		String textColor = fillValueInFirstName.getCssValue("border-top-color");
		Thread.sleep(2000);
		final Color RGBA_COLOUR = Color.fromString(textColor);
		System.out.println(RGBA_COLOUR);
	}

	// function for LastName
	public void checkColourofLastName(String lName) throws Exception {
		//fill Value In Last Name
		Thread.sleep(2000);
		fillValueInLastName.sendKeys(lName);
		//click On Search
		Thread.sleep(3000);
		builder.moveToElement(clickOnSearch).click().build().perform();
		//get text border color
		Thread.sleep(2000);
		System.out.println("Text Border.color" + fillValueInLastName.getCssValue("border-top-color"));

	}

	// function for MRN
	public void checkColourofMRN(String mrn) throws Exception {
		//fill Value In MRN
		Thread.sleep(2000);
		fillValueInMRN.sendKeys(mrn);
		//click On Search
		Thread.sleep(3000);
		builder.moveToElement(clickOnSearch).click().build().perform();
		//get text border color
		Thread.sleep(2000);
		System.out.println("Text Border.color" + fillValueInMRN.getCssValue("border-top-color"));

	}

	public void checkColourofDOB(String dob) throws Exception {
//split date and select date
		String storeDOB[] = dob.split("/");

		Thread.sleep(2000);
		clickOnMonthBox.click();

		for (WebElement select_MonthBox : selectMonth) {
			if (select_MonthBox.getText().equalsIgnoreCase(storeDOB[0])) {
				select_MonthBox.click();
				break;
			}
		}
		Thread.sleep(2000);
		clickOnDaybox.click();

		for (WebElement select_DayBox : selectDaybox) {
			if (select_DayBox.getText().equalsIgnoreCase(storeDOB[1])) {
				select_DayBox.click();
				break;
			}
		}
		Thread.sleep(2000);
		clickOnYearBox.click();

		for (WebElement select_YearBox : selectYearBox) {
			if (select_YearBox.getText().equalsIgnoreCase(storeDOB[2])) {
				select_YearBox.click();
				break;
			}
		}
		//click on search
		Thread.sleep(3000);
		builder.moveToElement(clickOnSearch).click().build().perform();
		//get color
		Thread.sleep(2000);
		System.out.println("Text Border.color" + clickOnMonthBox.getCssValue("border-top-color"));
		Thread.sleep(1000);
		System.out.println("Text Border.color" + clickOnDaybox.getCssValue("border-top-color"));
		Thread.sleep(1000);
		System.out.println("Text Border.color" + clickOnYearBox.getCssValue("border-top-color"));
	}

	public void checkColourofSSN(String ssn) throws Exception {
		
		//split ssn and select ssn
		String[] storeSSN = ssn.split("-");
		Thread.sleep(2000);
		fillValueInSSN1.clear();
		fillValueInSSN1.sendKeys(storeSSN[0]);

		Thread.sleep(2000);
		fillValueInSSN2.clear();
		fillValueInSSN2.sendKeys(storeSSN[1]);

		Thread.sleep(2000);
		fillValueInSSN3.clear();
		fillValueInSSN3.sendKeys(storeSSN[2]);

		Thread.sleep(3000);
		builder.moveToElement(clickOnSearch).click().build().perform();

		//get color ssn text box
		Thread.sleep(2000);
		System.out.println("Text Border.color" + fillValueInSSN1.getCssValue("border-top-color"));
		Thread.sleep(1000);
		System.out.println("Text Border.color" + fillValueInSSN2.getCssValue("border-top-color"));
		Thread.sleep(1000);
		System.out.println("Text Border.color" + fillValueInSSN3.getCssValue("border-top-color"));
	}

}
