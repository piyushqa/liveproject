package pages;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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

public class PgAutoCreatePatient {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	private static int n2 = 0;
	// private int m;
	private static final AtomicInteger count = new AtomicInteger(0);

//	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[5]/table/tbody/tr[1]/td[2]/a")
//	private WebElement clickCreatePatient;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Patient")
	private WebElement clickCreatePatient;

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

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(1)>option")
	private List<WebElement> selectMonth;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(2)")
	private WebElement clickbxDobDay;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(2)>option")
	private List<WebElement> selectDay;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(3)")
	private WebElement clickbxDobYear;

	@FindBy(how = How.CSS, using = "#gwt-debug-dateOfBirth > select:nth-child(3)>option")
	private List<WebElement> selectYear;

	@FindBy(how = How.CSS, using = "#gwt-debug-SsnField > input:nth-child(1)")
	private WebElement clickbxSSN1;

	@FindBy(how = How.CSS, using = "#gwt-debug-SsnField > input:nth-child(2)")
	private WebElement clickbxSSN2;

	@FindBy(how = How.CSS, using = "#gwt-debug-SsnField > input:nth-child(3)")
	private WebElement clickbxSSN3;

	@FindBy(how = How.CSS, using = "#gwt-debug-genderSelect-button")
	private WebElement clickbxGender;

	@FindBy(how = How.CSS, using = "#gwt-debug-genderSelect-container")
	private WebElement genderContainer;

	@FindBy(how = How.CSS, using = "#gwt-debug-addressLine1")
	private WebElement clickAddress1;

	@FindBy(how = How.CSS, using = "#gwt-debug-addressLine2")
	private WebElement clickAddress2;

	@FindBy(how = How.CSS, using = "#gwt-debug-city")
	private WebElement clickCity;

	@FindBy(how = How.CSS, using = "#gwt-debug-state")
	private WebElement clickbxState;

	@FindBy(how = How.CSS, using = "#gwt-debug-zipCode")
	private WebElement clickZipCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-homePhoneField > input:nth-child(1)")
	private WebElement clickHomePhoneCityCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-homePhoneField > input:nth-child(2)")
	private WebElement clickHomePhoneAreaCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-homePhoneField > input:nth-child(3)")
	private WebElement clickHomePhoneNo;

	@FindBy(how = How.CSS, using = "#gwt-debug-workPhoneField > input:nth-child(1)")
	private WebElement clickWorkPhoneCityCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-workPhoneField > input:nth-child(2)")
	private WebElement clickWorkPhoneAreaCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-workPhoneField > input:nth-child(3)")
	private WebElement clickWorkPhoneNo;

	@FindBy(how = How.CSS, using = "#gwt-debug-cellPhoneField > input:nth-child(1)")
	private WebElement clickCellPhoneCityCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-cellPhoneField > input:nth-child(2)")
	private WebElement clickCellPhoneAreaCode;

	@FindBy(how = How.CSS, using = "#gwt-debug-cellPhoneField > input:nth-child(3)")
	private WebElement clickCellPhoneNo;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-ethnicity-button > div:last-child")
	private WebElement drpbxEthnicity;

	@FindBy(how = How.CSS, using = "#gwt-debug-patientEmail")
	private WebElement clickEmail;

	@FindBy(how = How.CSS, using = "#gwt-debug-pmv-preferredmethodofcontact-button")
	private WebElement drpbxPrefModeOfContact;

	@FindBy(how = How.XPATH, using = ".//button[@type=\"button\" and text()=\"Create\"]")
	private WebElement btnCreate;

	public PgAutoCreatePatient(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
		

	}

	public String insertPatientDetails(String PMSID, String MRN, String firstName, String lastName, String date,
			String ssn, String SexcualOrientation, String GenderIdentity, String gender, String address1,
			String address2, String city, String state, String zipCode, String homePhone, String workPhone,
			String cellPhone, String ethnicity, String race, String detailedrace, String emailAddress,
			String contactMethod) throws InterruptedException {

		// Click on create Patient
		 Thread.sleep(2000);
		clickCreatePatient.click();

		// Fill PMSID
		// Thread.sleep(2000);
		Random random = new Random();
		int n = 10000 + random.nextInt(900000);
		PMSID = Integer.toString(n);
		clickPMSId.sendKeys(PMSID);

		// Fill MRN
		// Thread.sleep(2000);
		 Random random1 = new Random();
		 int n1 = 10000 + random1.nextInt(900000);
		 MRN = Integer.toString(n1);
		//clickMRN.clear();
		clickMRN.sendKeys(MRN);
		String strMRN = MRN;

		// Fill firstName
		// Thread.sleep(2000);
		//clickFirstName.clear();
		n2 = count.incrementAndGet();
		String str = Integer.toString(n2);
		String storeString = firstName.concat(str);
		clickFirstName.sendKeys(storeString);

		// Fill lastName
		// Thread.sleep(2000);
		//clickLastName.clear();
		//n2 = count.incrementAndGet();
//		str = Integer.toString(n2);
//		storeString = lastName.concat(str);
		clickLastName.sendKeys(lastName);

		// Fill month
		String[] dob = date.split("-");
		// Thread.sleep(2000);
		clickbxDobMonth.click();
		for (WebElement select_Month : selectMonth) {
			if (select_Month.getText().equalsIgnoreCase(dob[0])) {
				select_Month.click();
				break;
			}
		}
		// Fill date
		// Thread.sleep(2000);
		clickbxDobDay.click();
		for (WebElement select_Day : selectDay) {
			if (select_Day.getText().equalsIgnoreCase(dob[1])) {
				select_Day.click();
				break;
			}
		}
		// Fill year
		// Thread.sleep(2000);
		clickbxDobYear.click();

		for (WebElement select_year : selectYear) {
			if (select_year.getText().equalsIgnoreCase(dob[2])) {
				select_year.click();
				break;
			}
		}
		// Fill SSN1
		// Thread.sleep(2000);
		String[] SSN = ssn.split("-");
		Random r4 = new Random();
		int n6 = 200 + r4.nextInt(250);
		SSN[0] = Integer.toString(n6);
		clickbxSSN1.sendKeys(SSN[0]);

		// Fill SSN2
		// Thread.sleep(2000);
		Random r5 = new Random();
		int n7 = 20 + r5.nextInt(25);
		SSN[1] = Integer.toString(n7);
		clickbxSSN2.sendKeys(SSN[1]);

		// Fill SSN3
		// Thread.sleep(2000);
		Random r6 = new Random();
		int n8 = 2001 + r6.nextInt(2514);
		SSN[2] = Integer.toString(n8);
		clickbxSSN3.sendKeys(SSN[2]);

		// Fill Gender
		// Thread.sleep(2000);
		clickbxGender.click();
		java.util.List<WebElement> clickOnGender = driver
				.findElements(By.cssSelector("#gwt-debug-genderSelect-container>div"));
		System.out.println(clickOnGender.size());
		try {
			for (int i = 0; i <= clickOnGender.size(); i++)
				if (clickOnGender.get(i).getText().equalsIgnoreCase(gender)) {
					clickOnGender.get(i).click();
					break;
				}
		} catch (IndexOutOfBoundsException ex) {
			ex.getMessage();
		}
		// Fill SexualOrientation
		// Thread.sleep(2000);
		By sexualOrientation = By.cssSelector("#gwt-debug-sexualOrientation-button>div:nth-child(3)");
		driver.findElements(sexualOrientation).get(0).click();
		java.util.List<WebElement> clickOnsexualOrientation = driver
				.findElements(By.cssSelector("#gwt-debug-sexualOrientation-container>div "));
		for (int i = 1; i <= clickOnsexualOrientation.size(); i++)
			if (clickOnsexualOrientation.get(i).getText().equalsIgnoreCase(SexcualOrientation)) {
				clickOnsexualOrientation.get(i).click();
				break;
			}

		// Fill GenderIdentity
		// Thread.sleep(2000);
		By sexualIdentity = By.cssSelector("#gwt-debug-sexualOrientation-button>div:nth-child(3)");
		driver.findElements(sexualIdentity).get(1).click();
		java.util.List<WebElement> clickOnsexualIdentity = driver
				.findElements(By.cssSelector("#gwt-debug-sexualOrientation-container>div "));
		for (int i = 1; i <= clickOnsexualIdentity.size(); i++)
			if (clickOnsexualIdentity.get(i).getText().equalsIgnoreCase(GenderIdentity)) {
				clickOnsexualIdentity.get(i).click();
				break;
			}

		// Fill Address1
		// Thread.sleep(2000);
		clickAddress1.clear();
		clickAddress1.sendKeys(address1);

		// Fill Address2
		// Thread.sleep(2000);
		clickAddress2.clear();
		clickAddress2.sendKeys(address2);

		// Fill City
		// Thread.sleep(2000);
		clickCity.clear();
		clickCity.sendKeys(city);

		// Fill State
		// Thread.sleep(2000);
		Select selectState = new Select(clickbxState);
		selectState.selectByVisibleText(state);

		// Fill zipCode
		// Thread.sleep(2000);
		clickZipCode.clear();
		clickZipCode.sendKeys(zipCode);

		// Fill phoneCitycode
		// Thread.sleep(2000);
		String[] hPhoneArray = homePhone.split("-");
		clickHomePhoneCityCode.clear();
		clickHomePhoneCityCode.sendKeys(hPhoneArray[0]);
		clickHomePhoneAreaCode.clear();
		clickHomePhoneAreaCode.sendKeys(hPhoneArray[1]);
		clickHomePhoneNo.clear();
		clickHomePhoneNo.sendKeys(hPhoneArray[2]);

		// Fill workPhoneCity
		// Thread.sleep(2000);
		String[] wPhoneArray = workPhone.split("-");
		clickWorkPhoneCityCode.clear();
		clickWorkPhoneCityCode.sendKeys(wPhoneArray[0]);
		clickWorkPhoneAreaCode.clear();
		clickWorkPhoneAreaCode.sendKeys(wPhoneArray[1]);
		clickWorkPhoneNo.clear();
		clickWorkPhoneNo.sendKeys(wPhoneArray[2]);

		// Fill CellPhoneCity
		// Thread.sleep(2000);
		String[] cPhoneArray = cellPhone.split("-");
		clickCellPhoneCityCode.clear();
		clickCellPhoneCityCode.sendKeys(cPhoneArray[0]);
		clickCellPhoneAreaCode.clear();
		clickCellPhoneAreaCode.sendKeys(cPhoneArray[1]);
		clickCellPhoneNo.clear();
		clickCellPhoneNo.sendKeys(cPhoneArray[2]);

		// Fill Ethnicity
		// Thread.sleep(2000);
		drpbxEthnicity.click();

		// Thread.sleep(2000);
		java.util.List<WebElement> clickOnEnthnicity = driver
				.findElements(By.cssSelector("#gwt-debug-pmv-ethnicity-container>div"));
		for (int i = 1; i <= clickOnEnthnicity.size(); i++)
			if (clickOnEnthnicity.get(i).getText().equalsIgnoreCase(ethnicity)) {
				clickOnEnthnicity.get(i).click();
				break;
			}
		// Fill DrpRace

		driver.findElement(By.xpath("//*[@id=\"gwt-debug-widgetLabel\"]")).click();

		// Thread.sleep(2000);
		By drpRace = By.cssSelector("#gwt-debug-pmv-race-button>div:nth-child(3)");
		driver.findElements(drpRace).get(0).click();
		java.util.List<WebElement> clickOnRace = driver
				.findElements(By.cssSelector("#gwt-debug-pmv-race-container>div"));
		for (int i = 1; i <= clickOnRace.size(); i++)
			if (clickOnRace.get(i).getText().equalsIgnoreCase(race)) {
				clickOnRace.get(i).click();
				break;
			}

		// Fill DrpDetailRace
		driver.findElement(By.xpath("//*[@id=\"gwt-debug-widgetLabel\"]")).click();
		// Thread.sleep(2000);
		By drpdetailRace = By.cssSelector("#gwt-debug-pmv-race-button>div:nth-child(3)");
		driver.findElements(drpdetailRace).get(1).click();
		java.util.List<WebElement> clickOnDetailRace = driver
				.findElements(By.cssSelector("#gwt-debug-pmv-race-container>div"));
		for (int i = 1; i <= clickOnDetailRace.size(); i++)
			if (clickOnDetailRace.get(i).getText().equalsIgnoreCase(detailedrace)) {
				clickOnDetailRace.get(i).click();
				break;
			}

		// Fill mail
		driver.findElement(By.xpath("//*[@id=\"gwt-debug-widgetLabel\"]")).click();
		// Thread.sleep(2000);
		clickEmail.clear();
		clickEmail.sendKeys(emailAddress);

		// Fill ModeOfContact
		// Thread.sleep(2000);
		drpbxPrefModeOfContact.click();

		java.util.List<WebElement> clickOnContact = driver
				.findElements(By.cssSelector("#gwt-debug-pmv-preferredmethodofcontact-container>div"));
		for (int i = 1; i <= clickOnContact.size(); i++)
			if (clickOnContact.get(i).getText().equalsIgnoreCase(contactMethod)) {
				clickOnContact.get(i).click();
				break;
			}

		// Cilck On create Button
		// Thread.sleep(2000);
		btnCreate.click();
		return strMRN;
	}
}
