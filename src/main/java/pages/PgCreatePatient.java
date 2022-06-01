package pages;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

import config.ProjectSettings;

public class PgCreatePatient {
	private WebDriver driver;
	// Page Elements
	// Edit popup iframe
	@FindBy(how = How.CSS, using = "gwt-debug-overlay_large_popup")
	private WebElement patientEditPopUp;

	// Elements on Patient Creation Page
	@FindBy(how = How.CSS, using = "#gwt-debug-pmsId")
	private WebElement edtbxPMSId;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmMrn")
	private WebElement edtbxMRN;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmFirstName")
	private WebElement edtbxFirstName;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmLastName")
	private WebElement edtbxLastName;

	@FindBy(how = How.CSS, using = "#gwt-debug-alias")
	private WebElement edtbxNickName;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(1)")
	private WebElement lstbxDobMonth;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(2)")
	private WebElement lstbxDobDay;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(3)")
	private WebElement lstbxDobYear;

	@FindBy(how = How.CSS, using = "#gwt-debug-SsnField > input:nth-child(1)")
	private WebElement edtbxSSN1;

	@FindBy(how = How.CSS, using = "#gwt-debug-SsnField > input:nth-child(2)")
	private WebElement edtbxSSN2;

	@FindBy(how = How.CSS, using = "#gwt-debug-SsnField > input:nth-child(3)")
	private WebElement edtbxSSN3;

//	@FindBy(how = How.CSS, using = "#gwt-debug-pmGender")
	@FindBy(how = How.CSS, using = "#gwt-debug-genderSelect-button")
	private WebElement lstbxGender;

	@FindBy(how = How.CSS, using = "#gwt-debug-genderSelect-container")
	private WebElement genderContainer;

	@FindBy(how = How.CSS, using = "#gwt-debug-addressLine1")
	private WebElement edtbxAddress1;

	@FindBy(how = How.CSS, using = "#gwt-debug-addressLine2")
	private WebElement edtbxAddress2;

	@FindBy(how = How.CSS, using = "#gwt-debug-city")
	private WebElement edtbxCity;

	@FindBy(how = How.CSS, using = "#gwt-debug-state")
	private WebElement lstbxState;

	@FindBy(how = How.CSS, using = "#gwt-debug-zipCode")
	private WebElement edtbxZipCode;

	// Objects for Home Phone Number
	@FindBy(how = How.CSS, using = "#gwt-debug-homePhoneField > input:nth-child(1)")
	private WebElement edtbxHomePhoneCityCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-homePhoneField > input:nth-child(2)")
	private WebElement edtbxHomePhoneAreaCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-homePhoneField > input:nth-child(3)")
	private WebElement edtbxHomePhoneNo;

	// Objects for Work Phone Number
	@FindBy(how = How.CSS, using = "#gwt-debug-workPhoneField > input:nth-child(1)")
	private WebElement edtbxWorkPhoneCityCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-workPhoneField > input:nth-child(2)")
	private WebElement edtbxWorkPhoneAreaCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-workPhoneField > input:nth-child(3)")
	private WebElement edtbxWorkPhoneNo;

	// Objects for Cell Phone Number
	@FindBy(how = How.CSS, using = "#gwt-debug-cellPhoneField > input:nth-child(1)")
	private WebElement edtbxCellPhoneCityCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-cellPhoneField > input:nth-child(2)")
	private WebElement edtbxCellPhoneAreaCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-cellPhoneField > input:nth-child(3)")
	private WebElement edtbxCellPhoneNo;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientHasMedicare-input")
	private WebElement chkbxInsuranceMedicare;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientHasMedicaid-input")
	private WebElement chkbxInsuranceMedicaid;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientHasUnknownCoverage-input")
	private WebElement chkbxInsuranceUnknown;

	@FindBy(how = How.CSS, using = "#gwt-debug-preferredLanguage")
	private WebElement drpbxPrefLanguage;

//	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-preferredlanguage-button > div.gwt-Label.GFEO3AODC0B")
	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-ethnicity-button > div:last-child")
	private WebElement drpbxEthnicity;

////	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-preferredlanguage-container")
//	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-ethnicity-container > div")
//	private WebElement lstEthnicity;

//	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-race-button > div.gwt-Label.GFEO3AODC0B")
//	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-race-button")
//	private WebElement drpbxRace;

//	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-race-button")
//	private WebElement lstRace;

	@FindBy(how = How.CSS, using = "#gwt-debug-isDead-input")
	private WebElement chkbxDeceased;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientEmail")
	private WebElement edtbxEmail;

	@FindBy(how = How.CSS, using = "#gwt-debug-onlineAccessChkBox-input")
	private WebElement chkbxPatientOnlineAccess;

//	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-preferredmethodofcontact-button > div.gwt-Label.GFEO3AODC0B")
	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-preferredmethodofcontact-button")
	private WebElement drpbxPrefModeOfContact;

//	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-preferredmethodofcontact-container > div")
//	private WebElement lstMethodOfContact;

	@FindBy(how = How.CSS, using = "#gwt-debug-saveButton")
	private WebElement btnCreate;

	@FindBy(how = How.CSS, using = "div.succ_msg>div.gwt-Label")
	private WebElement patientSaveMessage;

	private Actions actions;
	// Initializing patient creation page
	public PgCreatePatient(WebDriver driver) {
		String pgTitle = "Integrity EMR";
		this.driver = driver;
		actions = new Actions(driver);
		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);
		} else {
			Reporter.log("Incorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);
		}
	}

	public boolean createPatient(String mrn, String pmsid, String firstName, String lastName, String dob, String ssn,
			String gender, String address1, String address2, String city, String state, String zipCode,
			String homePhone, String workPhone, String cellPhone, String email, boolean medicare, boolean medicaid,
			boolean unknown, String language, String ethnicity, boolean deceased, String race, boolean onlineAccess,
			String contactMethod) {
		create(mrn, pmsid, firstName, lastName, dob, ssn,
				gender, address1, address2, city, state, zipCode,
				homePhone, workPhone, cellPhone, email, medicare, medicaid,
				unknown, language, ethnicity, deceased, race, onlineAccess,
				contactMethod);

		WebDriverWait wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.textToBePresentInElement(patientSaveMessage, "Saved Patient"));
		return patientSaveMessage.getText().contains("Saved Patient");
	}

	public void modifyPatient(String mrn, String pmsid, String firstName, String lastName, String dob, String ssn,
			String gender, String address1, String address2, String city, String state, String zipCode,
			String homePhone, String workPhone, String cellPhone, String email, boolean medicare, boolean medicaid,
			boolean unknown, String language, String ethnicity, boolean deceased, String race, boolean onlineAccess,
			String contactMethod) {

		create(mrn, pmsid, firstName, lastName, dob, ssn,
				gender, address1, address2, city, state, zipCode,
				homePhone, workPhone, cellPhone, email, medicare, medicaid,
				unknown, language, ethnicity, deceased, race, onlineAccess, contactMethod);
		WebElement errorLable = driver.findElement(By.xpath("//*[@id='gwt-debug-overlay_content']/div/div[1]/div"));
		if (errorLable.isEnabled()) {
			Reporter.log(errorLable.getText());
			return;
		}

		Reporter.log("Patient Modified successfully!");
	}


	// Function to create new patient
	private void create(String mrn, String pmsid, String firstName, String lastName, String dob, String ssn,
			String gender, String address1, String address2, String city, String state, String zipCode,
			String homePhone, String workPhone, String cellPhone, String email, boolean medicare, boolean medicaid,
			boolean unknown, String language, String ethnicity, boolean deceased, String race, boolean onlineAccess,
			String contactMethod) {

		String[] splitData = null;
//		String randNum = Integer.toString(lutil.generateRandomNumber(100000, 999999));
//		Reporter.log(ProjectSettings.eol + "Patient PMSId & MRN Set to: " + randNum);
		WebDriverWait wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
		// Waiting for the first element of the page to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(edtbxPMSId));

		edtbxPMSId.clear();
		edtbxPMSId.sendKeys(mrn);

		edtbxMRN.clear();
		edtbxMRN.sendKeys(pmsid);

		edtbxFirstName.clear();
		edtbxFirstName.sendKeys(firstName);

		edtbxLastName.clear();
		edtbxLastName.sendKeys(lastName);

		edtbxNickName.clear();
		edtbxNickName.sendKeys(firstName);

		// Entering Date of Birth

		String[] dobArray = dob.split("/");
		Select selectDOBM = new Select(lstbxDobMonth);

		String month = dobArray[0];
		if (month.charAt(0) == '0')
			month = month.charAt(1) + "";
		selectDOBM.selectByVisibleText(month);

		String day = dobArray[1];
		if (day.charAt(0) == '0')
			day = day.charAt(1) + "";
		Select selectDOBD = new Select(lstbxDobDay);
		selectDOBD.selectByVisibleText(day);

		Select selectDOBY = new Select(lstbxDobYear);
		selectDOBY.selectByVisibleText(dobArray[2]);

		lstbxGender.click();
		wait.until(ExpectedConditions.elementToBeClickable(genderContainer));
		String selectedGender = driver.findElement(By.xpath("//*[@id='gwt-debug-genderSelect-button']/div[3]")).getText();
		for (WebElement e : genderContainer.findElements(By.xpath(".//*"))) {
			if (e.getText().equalsIgnoreCase(gender) && !e.getText().equalsIgnoreCase(selectedGender)) {
				e.click();
				break;
			}
		}

		// Entring values for SSN
		splitData = ssn.split("-");
		edtbxSSN1.clear();
		edtbxSSN1.sendKeys(splitData[0]);
		edtbxSSN2.clear();
		edtbxSSN2.sendKeys(splitData[1]);
		edtbxSSN3.clear();
		edtbxSSN3.sendKeys(splitData[2]);
		splitData = null;

		// Entering Address values for Patient
		edtbxAddress1.clear();
		edtbxAddress1.sendKeys(address1);
		edtbxAddress2.clear();
		edtbxAddress2.sendKeys(address2);
		edtbxCity.clear();
		edtbxCity.sendKeys(city);

		// Selecting value for State
		Select selectState = new Select(lstbxState);
		selectState.selectByVisibleText(state);
		edtbxZipCode.clear();
		edtbxZipCode.sendKeys(zipCode);

		// Entering the values for Paitent Phone Numbers
		String[] hPhoneArray = homePhone.split("-");
		edtbxHomePhoneCityCode.clear();
		edtbxHomePhoneCityCode.sendKeys(hPhoneArray[0]);
		edtbxHomePhoneAreaCode.clear();
		edtbxHomePhoneAreaCode.sendKeys(hPhoneArray[1]);
		edtbxHomePhoneNo.clear();
		edtbxHomePhoneNo.sendKeys(hPhoneArray[2]);
		// Work Phone

		String[] wPhoneArray = workPhone.split("-");
		edtbxWorkPhoneCityCode.clear();
		edtbxWorkPhoneCityCode.sendKeys(wPhoneArray[0]);
		edtbxWorkPhoneAreaCode.clear();
		edtbxWorkPhoneAreaCode.sendKeys(wPhoneArray[1]);
		edtbxWorkPhoneNo.clear();
		edtbxWorkPhoneNo.sendKeys(wPhoneArray[2]);
		// Cell Phone
		String[] cPhoneArray = cellPhone.split("-");
		edtbxCellPhoneCityCode.clear();
		edtbxCellPhoneCityCode.sendKeys(cPhoneArray[0]);
		edtbxCellPhoneAreaCode.clear();
		edtbxCellPhoneAreaCode.sendKeys(cPhoneArray[1]);
		edtbxCellPhoneNo.clear();
		edtbxCellPhoneNo.sendKeys(cPhoneArray[2]);

		// Choosing the indicated type of insurance for patient

		if (!chkbxInsuranceMedicare.isSelected() && medicare)
			chkbxInsuranceMedicare.click();
		else if (chkbxInsuranceMedicare.isSelected() && !medicare)
			chkbxInsuranceMedicare.click();

		if (!chkbxInsuranceMedicaid.isSelected() && medicaid)
			chkbxInsuranceMedicaid.click();
		else if (chkbxInsuranceMedicaid.isSelected() && !medicaid)
			chkbxInsuranceMedicaid.click();

		if (!chkbxInsuranceUnknown.isSelected() && unknown)
			chkbxInsuranceUnknown.click();
		else if (chkbxInsuranceUnknown.isSelected() && !unknown)
			chkbxInsuranceUnknown.click();

		// Select preferred language box is quite a normal box thus normal select is
		// used to choose the value
		Select selectPrefLanguage = new Select(drpbxPrefLanguage);
		wait.until(ExpectedConditions.elementToBeClickable(drpbxPrefLanguage));
		for (WebElement e : selectPrefLanguage.getOptions()) {
			if (e.getText().equalsIgnoreCase(language)) {
				e.click();
				break;
			}
		};

		Set<String> ethinicities = Stream.of(ethnicity.split("\\s*,\\s*")).collect(Collectors.toSet());
		wait.until(ExpectedConditions.visibilityOf(drpbxEthnicity));
		wait.until(ExpectedConditions.elementToBeClickable(drpbxEthnicity));
		actions.moveToElement(drpbxEthnicity).click().build().perform();
		By lstEthinicity = By.cssSelector("#gwt-debug-pmv-ethnicity-container > div");
		wait.until(ExpectedConditions.elementToBeClickable(lstEthinicity));
		WebElement valueBox = driver.findElement(By.xpath("//*[@id='gwt-debug-pmv-ethnicity-button']/div[3]"));
		Set<String> alreadySelectedValues =  Stream.of(valueBox.getText().split("\\s*,\\s*")).collect(Collectors.toSet());
		int size = driver.findElements(lstEthinicity).size();

		for (int i = 0; i < size; i++) {
			By id = By.id("pmv-ethnicity-item-" + i);
			wait.until(ExpectedConditions.elementToBeClickable(id));
			WebElement e = driver.findElement(id);
			String option = e.getText();
			if (!alreadySelectedValues.contains(option) && ethinicities.contains(option)) {
				wait.until(ExpectedConditions.elementToBeClickable(e));
				e.click();
			} else if (alreadySelectedValues.contains(option) && !ethinicities.contains(option)) {
				wait.until(ExpectedConditions.elementToBeClickable(e));
				e.click();
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(drpbxEthnicity));
		actions.moveToElement(drpbxEthnicity, drpbxEthnicity.getLocation().getX() + 1, drpbxEthnicity.getLocation().getY() + 1).click().build().perform();  // click to hide popup


		Set<String> races = Stream.of(race.split("\\s*,\\s*")).collect(Collectors.toSet());
		By drpbxRace = By.cssSelector("#gwt-debug-pmv-race-button > div:last-child");
		wait.until(ExpectedConditions.elementToBeClickable(drpbxRace));
		WebElement drpbxRaceBtn = driver.findElements(drpbxRace).get(0);
		actions.moveToElement(drpbxRaceBtn).click().build().perform();
		valueBox = driver.findElement(By.xpath("//*[@id='gwt-debug-pmv-ethnicity-button']/div[3]"));
		alreadySelectedValues =  Stream.of(valueBox.getText().split("\\s*,\\s*")).collect(Collectors.toSet());
		By lstRace = By.cssSelector("#gwt-debug-pmv-race-container > div");
		wait.until(ExpectedConditions.elementToBeClickable(lstRace));
		size = driver.findElements(lstRace).size();
		for (int i = 0; i < size; i++) {
			String id = "pmv-race-item-" + i;
			WebElement e = driver.findElement(By.id(id));
			String option = e.getText();
			if (!alreadySelectedValues.contains(option) && races.contains(option)) {
				wait.until(ExpectedConditions.elementToBeClickable(e));
				e.click();
			} else if (alreadySelectedValues.contains(option) && !ethinicities.contains(option)) {
				wait.until(ExpectedConditions.elementToBeClickable(e));
				e.click();
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(drpbxRaceBtn));
		actions.moveToElement(drpbxRaceBtn, drpbxRaceBtn.getLocation().getX() + 1, drpbxRaceBtn.getLocation().getY() + 1).click().build().perform();

		edtbxEmail.clear();
		edtbxEmail.sendKeys(email);


		wait.until(ExpectedConditions.elementToBeClickable(drpbxPrefModeOfContact));
		actions.moveToElement(drpbxPrefModeOfContact).click().build().perform();
		By conatiner = By.cssSelector("#gwt-debug-pmv-preferredmethodofcontact-container > div");
		wait.until(ExpectedConditions.elementToBeClickable(conatiner));
		size = driver.findElements(conatiner).size();
		for (int i = 0; i < size; i++) {
			By option = By.cssSelector("#pmv-preferredmethodofcontact-item-" + i);
			wait.until(ExpectedConditions.elementToBeClickable(option));
			String text = driver.findElement(option).getText();
			if(text.equalsIgnoreCase(contactMethod)){
				wait.until(ExpectedConditions.elementToBeClickable(option));
				driver.findElement(option).click();
				break;
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(btnCreate));
		btnCreate.click();
//		wait.until(ExpectedConditions.textToBePresentInElement(patientSaveMessage, "Saved Patient"));
//		if (patientSaveMessage.getText().contains("Saved Patient")) {
//			saved = true;
//		}
//		return saved;
	}
}

