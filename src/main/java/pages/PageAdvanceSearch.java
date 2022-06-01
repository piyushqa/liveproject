package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAdvanceSearch {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.LINK_TEXT, using = "Advanced Search")
	private WebElement clickOnAdvanceSearch;

	@FindBy(how = How.CSS, using = "#gwt-debug-addcriteria-button>div:nth-child(3)")
	private WebElement clickOnAddCriterion;

	// For Demographics

	@FindBy(how = How.CSS, using = "#gwt-debug-addcriteria-container>div")
	private List<WebElement> selectCriteria;

	@FindBy(how = How.CSS, using = "#gwt-debug-mrn>input[class=\"gwt-TextBox input\"]")
	private WebElement fillValueInMrn;

	@FindBy(how = How.CSS, using = "#gwt-debug-addCriteria>a")
	private WebElement clickOnAddcriteria;

	@FindBy(how = How.CSS, using = "#gwt-debug-search>a")
	private WebElement clickOnSrch;

	@FindBy(how = How.CSS, using = "#gwt-debug-returnToDashboard>a")
	private WebElement clickOnReturnTodashBoard;

	// For Appointments and past encounter

	@FindBy(how = How.CSS, using = "#gwt-debug-appointments-operator>select")
	private WebElement selectAppointment;

	@FindBy(how = How.CSS, using = "#gwt-debug-appointments-operator>select>option")
	private List<WebElement> select_AppointmentData;

	@FindBy(how = How.CSS, using = "div.input>input:nth-child(1)")
	private WebElement clickOnDateInput;

	// For allergy

	@FindBy(how = How.CSS, using = "#gwt-debug-criteriaPanel>div>div:nth-child(3)>select.gwt-ListBox")
	private WebElement clickAllergyWith;

	@FindBy(how = How.CSS, using = "#gwt-debug-criteriaPanel>div>div:nth-child(3)>select>option")
	private List<WebElement> selectAllergy;

	@FindBy(how = How.CSS, using = "#gwt-debug-criteriaPanel>div>input")
	private WebElement fillAllergyName;

	// for vital sign
	@FindBy(how = How.CSS, using = "#gwt-debug-bmi>div>select")
	private WebElement clickOnBMI;

	@FindBy(how = How.CSS, using = "#gwt-debug-bmi>div>select>option")
	private List<WebElement> select_BMI;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-bmi\"]/input")
	private WebElement fillBMIValue;

	@FindBy(how = How.CSS, using = "#gwt-debug-systolic>div>select")
	private WebElement clicksystolic;

	@FindBy(how = How.CSS, using = "#gwt-debug-systolic>div>select>option")
	private List<WebElement> select_systolic;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-systolic\"]/input")
	private WebElement fillsystolicValue;

	@FindBy(how = How.CSS, using = "#gwt-debug-diastolic>div>select")
	private WebElement clickdiastolic;

	@FindBy(how = How.CSS, using = "#gwt-debug-diastolic>div>select>option")
	private List<WebElement> select_diastolic;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-diastolic\"]/input")
	private WebElement filldiastolicValue;

	@FindBy(how = How.CSS, using = "#gwt-debug-heartrate>div>select")
	private WebElement clickheartrate;

	@FindBy(how = How.CSS, using = "#gwt-debug-heartrate>div>select>option")
	private List<WebElement> select_heartrate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-heartrate\"]/input")
	private WebElement fillheartrateValue;

	@FindBy(how = How.CSS, using = "#gwt-debug-temperature>div>select")
	private WebElement clicktemperature;

	@FindBy(how = How.CSS, using = "#gwt-debug-temperature>div>select>option")
	private List<WebElement> select_temperature;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-temperature\"]/input")
	private WebElement filltemperatureValue;

	public PageAdvanceSearch(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAdvanceSearch.this);
	}

	public void verifyAdvanceSearch(String mrn, String appointment, String date, String allergyWith, String allergyName)
			throws Exception {
		String criteria = null;

		Thread.sleep(2000);
		verifyForDemographics(criteria, mrn);

		Thread.sleep(2000);
		verifyAppointments(criteria, appointment, date);

		Thread.sleep(2000);
		verifyPastEncounter(criteria, appointment, date);

		Thread.sleep(2000);
		verifyAllergies(criteria, allergyWith, allergyName, appointment, date);

		Thread.sleep(2000);
		verifyVitalSigns(criteria);

	}

	public void verifyForDemographics(String criteria, String mrn) throws Exception {

		criteria = "Demographics";

		Thread.sleep(2000);
		clickOnAdvanceSrchAndCriteria();

		Thread.sleep(2000);
		searchCriteria(criteria);

		Thread.sleep(2000);
		fillValueInMrn.sendKeys(mrn);

		Thread.sleep(2000);
		clickOnsearchCriteria();
	}

	public void verifyAppointments(String criteria, String appointment, String date) throws Exception {

		criteria = "Appointments";

		Thread.sleep(2000);
		clickOnAdvanceSrchAndCriteria();

		Thread.sleep(2000);
		searchCriteria(criteria);

		Thread.sleep(2000);
		selectAppointment.click();

		Thread.sleep(2000);
		for (WebElement select_Appointment : select_AppointmentData) {
			if (select_Appointment.getText().equalsIgnoreCase(appointment)) {
				select_Appointment.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickOnDateInput.click();

		Thread.sleep(2000);
		selectDate(date);

		Thread.sleep(2000);
		clickOnsearchCriteria();
	}

	public void verifyPastEncounter(String criteria, String appointment, String date) throws Exception {
		criteria = "Past Encounter";

		Thread.sleep(2000);
		clickOnAdvanceSrchAndCriteria();

		Thread.sleep(2000);
		searchCriteria(criteria);

		Thread.sleep(2000);
		for (WebElement select_Appointment : select_AppointmentData) {
			if (select_Appointment.getText().equalsIgnoreCase(appointment)) {
				select_Appointment.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickOnDateInput.click();

		Thread.sleep(2000);
		selectDate(date);

		Thread.sleep(2000);
		clickOnsearchCriteria();
	}

	public void verifyAllergies(String criteria, String allergyWith, String allergyName, String appointment,
			String date) throws Exception {
		criteria = "Allergies";

		Thread.sleep(2000);
		clickOnAdvanceSrchAndCriteria();

		Thread.sleep(2000);
		searchCriteria(criteria);

		enterAllergyAndMedicicne(allergyWith, allergyName);

		Thread.sleep(2000);
		for (WebElement select_Appointment : select_AppointmentData) {
			if (select_Appointment.getText().equalsIgnoreCase(appointment)) {
				select_Appointment.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickOnDateInput.click();

		Thread.sleep(2000);
		selectDate(date);

		Thread.sleep(2000);
		clickOnsearchCriteria();
	}

	public void verifyVitalSigns(String criteria) throws Exception {
		criteria = "Vital Signs";

		Thread.sleep(2000);
		clickOnAdvanceSrchAndCriteria();

		Thread.sleep(2000);
		searchCriteria(criteria);

		Thread.sleep(2000);
		fillVitalvalue();

		Thread.sleep(2000);
		clickOnsearchCriteria();

	}

	public void clickOnAdvanceSrchAndCriteria() throws Exception {
		Thread.sleep(4000);
		try {
			clickOnAdvanceSearch.click();
		} catch (NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
		Thread.sleep(2000);
		builder.moveToElement(clickOnAddCriterion).click().build().perform();

	}

	public void searchCriteria(String criteria) throws Exception {
		Thread.sleep(5000);
		for (WebElement select_Criteria : selectCriteria) {
			if (select_Criteria.getText().equalsIgnoreCase(criteria)) {
				select_Criteria.click();
				break;
			}
		}

	}

	public void clickOnsearchCriteria() throws Exception {
		Thread.sleep(3000);
		clickOnAddcriteria.click();

		Thread.sleep(2000);
		clickOnSrch.click();

		Thread.sleep(3000);
		clickOnReturnTodashBoard.click();
	}

	public void enterAllergyAndMedicicne(String allergyWith, String allergyName) throws Exception {

		Thread.sleep(2000);
		clickAllergyWith.click();

		Thread.sleep(3000);
		for (WebElement select_Allergy : selectAllergy) {
			if (select_Allergy.getText().equalsIgnoreCase(allergyWith)) {
				select_Allergy.click();
				break;
			}
		}

		Thread.sleep(2000);
		fillAllergyName.sendKeys(allergyName);
	}

	public void fillVitalvalue() throws Exception {
		Thread.sleep(2000);
		clickOnBMI.click();

		Thread.sleep(2000);
		for (WebElement select_BMIValue : select_BMI) {
			if (select_BMIValue.getText().equalsIgnoreCase("Is")) {
				select_BMIValue.click();
				break;
			}
		}

		fillBMIValue.sendKeys("40");

		Thread.sleep(1000);
		clicksystolic.click();

		Thread.sleep(1000);
		for (WebElement select_systolicValue : select_systolic) {
			if (select_systolicValue.getText().equalsIgnoreCase("Is")) {
				select_systolicValue.click();
				break;
			}
		}

		fillsystolicValue.sendKeys("50");

		Thread.sleep(1000);
		clickdiastolic.click();

		Thread.sleep(1000);
		for (WebElement select_diastolicValue : select_diastolic) {
			if (select_diastolicValue.getText().equalsIgnoreCase("Is")) {
				select_diastolicValue.click();
				break;
			}
		}

		filldiastolicValue.sendKeys("30");

		Thread.sleep(1000);
		clickheartrate.click();

		Thread.sleep(1000);
		for (WebElement select_heartrateValue : select_heartrate) {
			if (select_heartrateValue.getText().equalsIgnoreCase("Is")) {
				select_heartrateValue.click();
				break;
			}
		}

		fillheartrateValue.sendKeys("80");

		Thread.sleep(1000);
		clicktemperature.click();

		Thread.sleep(1000);
		for (WebElement select_temperatureValue : select_temperature) {
			if (select_temperatureValue.getText().equalsIgnoreCase("Is")) {
				select_temperatureValue.click();
				break;
			}
		}
		filltemperatureValue.sendKeys("45");
	}

	public void selectDate(String selDate) throws Exception {
		String SelectDate = selDate;

		String[] sp = SelectDate.split("/");

		Date d = new Date(SelectDate);

		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		String date = dt.format(d);

		String[] split = date.split("/");

		String month = split[0];
		String day = split[1];
		if (day.charAt(0) == '0')
			day = day.charAt(1) + "";

		String monthName = month.substring(0, 3);

		String monthYear = monthName + " " + split[2];

		Thread.sleep(2 * 1000);
		String currentdate = driver
				.findElement(By
						.xpath(".//table[@class=\"datePickerMonthSelector\"]/tbody/tr/td[@class=\"datePickerMonth\"]"))
				.getText();
		// current month
		String mm = currentdate.substring(0, 3);
		// current year
		String year = currentdate.substring(4, 8);

		int monthdateinteger = 0;
		// current year convert to integer
		int yearinteger = Integer.parseInt(year);
		// Exel readed month convert to integer
		int monthDateReadFromExel = Integer.parseInt(sp[0]);
		// Exel readed year convert to integer
		int yearDateReadFromExel = Integer.parseInt(split[2]);

		if (mm.equals("Jan")) {
			monthdateinteger = 1;

		}
		if (mm.equals("Feb")) {
			monthdateinteger = 2;
		}
		if (mm.equals("Mar")) {
			monthdateinteger = 3;
		}
		if (mm.equals("Apr")) {
			monthdateinteger = 4;
		}
		if (mm.equals("May")) {
			monthdateinteger = 5;
		}
		if (mm.equals("Jun")) {
			monthdateinteger = 6;
		}
		if (mm.equals("Jul")) {
			monthdateinteger = 7;
		}
		if (mm.equals("Aug")) {
			monthdateinteger = 8;
		}
		if (mm.equals("Sep")) {
			monthdateinteger = 9;
		}
		if (mm.equals("Oct")) {
			monthdateinteger = 10;
		}
		if (mm.equals("Nov")) {
			monthdateinteger = 11;
		}
		if (mm.equals("Dec")) {
			monthdateinteger = 12;
		}
		int monthdiff = monthDateReadFromExel - monthdateinteger;
		int yeardiff = yearDateReadFromExel - yearinteger;
		// Select The Year
		if (monthdiff >= 0 && yeardiff >= 0) {
			while (true) {

				try {
					Thread.sleep(1000);
					if (driver.findElement(By.xpath("//*[text()='" + monthYear + "']")).isDisplayed()) {

						break;
					}

				} catch (Exception e) {
					driver.findElement(By.cssSelector(
							"body > div.dateBoxPopup > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(3) > div > div"))
							.click();
				}

			}
		} else {

			while (true) {

				try {
					Thread.sleep(1000);
					if (driver.findElement(By.xpath("//*[text()='" + monthYear + "']")).isDisplayed()) {

						break;
					}

				} catch (Exception e) {
					driver.findElement(By.cssSelector(
							"body > div.dateBoxPopup > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > div > div"))
							.click();
				}

			}
		}
		// Select the day of the month
		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath(
				".//table[@class=\"datePickerDays\"]/tbody/tr/td[not(contains(@class,'datePickerDay datePickerDayIsFiller '))and not(contains(@class,'datePickerDay datePickerDayIsWeekend datePickerDayIsFiller'))]"));

		for (int i = 0; i < list_AllMonthToBook.size(); i++) {

			if (list_AllMonthToBook.get(i).getText().equalsIgnoreCase(day)) {
				list_AllMonthToBook.get(i).click();
				break;

			}

		}
	}
}
