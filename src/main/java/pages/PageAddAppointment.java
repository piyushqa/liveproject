package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class PageAddAppointment {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.CSS, using = "div#gwt-debug-addAppointment>a")
	private WebElement clickOnAddAppointment;

	@FindBy(how = How.LINK_TEXT, using = "search")
	private WebElement clickOnSearch;

	@FindBy(how = How.CSS, using = "input#gwt-debug-mrn")
	private WebElement fillMRN;

	@FindBy(how = How.CSS, using = "div#gwt-debug-searchButton>a")
	private WebElement clickOnPatientsearch;

	@FindBy(how = How.CSS, using = "table#gwt-debug-searchResultTable>tbody>tr>td>div")
	private List<WebElement> select_MRN;

	@FindBy(how = How.CSS, using = "input#gwt-debug-pmsAppointmentId")
	private WebElement fillAppointMentID;

	@FindBy(how = How.CSS, using = "select#gwt-debug-visitType")
	private WebElement selectVistype;

	@FindBy(how = How.CSS, using = "select#gwt-debug-appt-day")
	private WebElement clickOnDay;

	@FindBy(how = How.CSS, using = "select#gwt-debug-appt-day>option")
	private List<WebElement> selectDay;

	@FindBy(how = How.CSS, using = "select#gwt-debug-appt-month")
	private WebElement clickOnMonth;

	@FindBy(how = How.CSS, using = "select#gwt-debug-appt-month>option")
	private List<WebElement> selectMonth;

	@FindBy(how = How.CSS, using = "select#gwt-debug-appt-year")
	private WebElement clickYear;

	@FindBy(how = How.CSS, using = "select#gwt-debug-appt-year>option")
	private List<WebElement> selectYear;

	@FindBy(how = How.CSS, using = "select#gwt-debug-hours")
	private WebElement clickOnHours;

	@FindBy(how = How.CSS, using = "select#gwt-debug-hours>option")
	private List<WebElement> selectHours;

	@FindBy(how = How.CSS, using = "select#gwt-debug-mins")
	private WebElement clickMinutes;

	@FindBy(how = How.CSS, using = "select#gwt-debug-mins>option")
	private List<WebElement> selectMinutes;

	@FindBy(how = How.CSS, using = "select#gwt-debug-timePeriod")
	private WebElement clickTimeForamt;

	@FindBy(how = How.CSS, using = "select#gwt-debug-timePeriod>option")
	private List<WebElement> selectTimeFormat;

	@FindBy(how = How.CSS, using = "a#gwt-debug-Done.gwt-Anchor")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-appointment-table\"]/div[3]/div/div[2]/div/div/table/tbody/tr/td[13]/div/img")
	private WebElement clickOnEditIMG;

	@FindBy(how = How.CSS, using = "a#gwt-debug-Delete.gwt-Anchor")
	private WebElement clickOnDeleteAppointment;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok.gwt-Anchor")
	private WebElement clickOnyes;

	@FindBy(how = How.CSS, using = "input#gwt-debug-dateBox.gwt-DatePicker-readonly")
	private WebElement clickOnDate;

	public PageAddAppointment(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddAppointment.this);
	}

	public void verifyAddAppointment(String mrn, String visitType, String date, String appointment) throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnAddAppointment);
		clickOnAddAppointment.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSearch);
		clickOnSearch.click();

		addAppointMent(mrn, visitType, date, appointment);

		selectDate(date);

		deleteAppointMent();
	}

	public void addAppointMent(String mrn, String visitType, String date, String appointment) throws Exception {
		Thread.sleep(3000);
		ensureElementToBeClickable(fillMRN);
		fillMRN.sendKeys(mrn);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnPatientsearch);
		clickOnPatientsearch.click();

		Thread.sleep(4000);
		ensureElementToBeClickable(select_MRN);
		for (WebElement selectMRN : select_MRN) {
			if (selectMRN.getText().equals(mrn)) {
				// builder.moveToElement(selectMRN).click();
				selectMRN.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(selectVistype);
		selectVistype.click();

		Thread.sleep(4000);
		Select selectData = new Select(selectVistype);
		selectData.selectByVisibleText(visitType);

		String[] storeDate = date.split("-");

		ensureElementToBeClickable(clickOnDay);
		clickOnDay.click();

		for (WebElement select_Day : selectDay) {
			if (select_Day.getText().equalsIgnoreCase(storeDate[0])) {
				select_Day.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnMonth);
		clickOnMonth.click();

		ensureElementToBeClickable(selectMonth);
		for (WebElement select_Month : selectMonth) {
			if (select_Month.getText().equalsIgnoreCase(storeDate[1])) {
				select_Month.click();
				break;
			}
		}

		ensureElementToBeClickable(clickYear);
		clickYear.click();

		ensureElementToBeClickable(selectYear);
		for (WebElement select_Year : selectYear) {
			if (select_Year.getText().equalsIgnoreCase(storeDate[2])) {
				select_Year.click();
				break;
			}
		}

		Thread.sleep(4000);
		String storeTimeFormat[] = appointment.split("-");

		ensureElementToBeClickable(clickOnHours);
		clickOnHours.click();

		ensureElementToBeClickable(selectHours);
		for (WebElement select_Hours : selectHours) {
			if (select_Hours.getText().equalsIgnoreCase(storeTimeFormat[0])) {
				select_Hours.click();
				break;
			}
		}

		ensureElementToBeClickable(clickMinutes);
		clickMinutes.click();

		ensureElementToBeClickable(selectMinutes);
		for (WebElement select_Minutes : selectMinutes) {
			if (select_Minutes.getText().equalsIgnoreCase(storeTimeFormat[1])) {
				select_Minutes.click();
				break;
			}
		}

		ensureElementToBeClickable(clickTimeForamt);
		clickTimeForamt.click();

		ensureElementToBeClickable(selectTimeFormat);
		for (WebElement select_Timeformat : selectTimeFormat) {
			if (select_Timeformat.getText().equalsIgnoreCase(storeTimeFormat[2])) {
				select_Timeformat.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();
	}

	public void selectDate(String selectDate) throws Exception {

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDate);
		clickOnDate.click();

		String SelectDate = selectDate;

		String[] sp = SelectDate.split("-");

		Date d = new Date(SelectDate);

		SimpleDateFormat dt = new SimpleDateFormat("MMMM-dd-yyyy");
		String date = dt.format(d);

		String[] split = date.split("-");

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
		// int monthDateReadFromExel = Integer.parseInt(sp[1]);
		// Exel readed year convert to integer
		int yearDateReadFromExel = Integer.parseInt(split[2]);

		// if (mm.equals("Jan")) {
		// monthdateinteger = 1;
		//
		// }
		// if (mm.equals("Feb")) {
		// monthdateinteger = 2;
		// }
		// if (mm.equals("Mar")) {
		// monthdateinteger = 3;
		// }
		// if (mm.equals("Apr")) {
		// monthdateinteger = 4;
		// }
		// if (mm.equals("May")) {
		// monthdateinteger = 5;
		// }
		// if (mm.equals("Jun")) {
		// monthdateinteger = 6;
		// }
		// if (mm.equals("Jul")) {
		// monthdateinteger = 7;
		// }
		// if (mm.equals("Aug")) {
		// monthdateinteger = 8;
		// }
		// if (mm.equals("Sep")) {
		// monthdateinteger = 9;
		// }
		// if (mm.equals("Oct")) {
		// monthdateinteger = 10;
		// }
		// if (mm.equals("Nov")) {
		// monthdateinteger = 11;
		// }
		// if (mm.equals("Dec")) {
		// monthdateinteger = 12;
		// }

		// int monthdiff = monthDateReadFromExel - mm;
		int yeardiff = yearDateReadFromExel - yearinteger;
		// Select The Year
		if (yeardiff >= 0) {
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

	public void deleteAppointMent() throws Exception {
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnEditIMG);
		clickOnEditIMG.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDeleteAppointment);
		clickOnDeleteAppointment.click();

		ensureElementToBeClickable(clickOnyes);

		clickOnyes.click();
	}

	// finction use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	private void ensureElementToBeClickable(List<WebElement> element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}
}
