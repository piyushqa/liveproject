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
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ProjectSettings;

public class PageAuditSearch {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.LINK_TEXT, using = "Audit Search")
	private WebElement clickOnAuditSearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[1]/div[1]/input")
	private WebElement clickOnFromdateTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[1]/div[2]/input")
	private WebElement clickOnTodateTextbox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[1]/div[3]/input")
	private WebElement fillTheMrnName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[1]/div[4]/a")
	private WebElement clickOnsearchBtn;

	public PageAuditSearch(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAuditSearch.this);

	}

	public void verifyAuditsearch(String fromDate, String toDate, String mrn, String user, String activityType,
			String action) throws Exception {

		Thread.sleep(2000);
		clickOnAuditSearch.click();

		// call start date method
		driver.manage().timeouts().implicitlyWait(ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		startDate(fromDate);

		// call end date method
		endDate(toDate);

		// fill the MRN
		Thread.sleep(2000);
		fillTheMrnName.sendKeys(mrn);
//!------ use the below code when we write full script of autit search
		// for (WebElement select_User : driver.findElements(
		// By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/div[1]/div[2]/div")))
		// {
		// if (select_User.getText().equalsIgnoreCase(user)) {
		// select_User.click();
		// break;
		// }
		//
		// }

		// for (WebElement select_ActivityType : driver.findElements(
		// By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[3]/div/div[2]/div")))
		// {
		// if (select_ActivityType.getText().equalsIgnoreCase(activityType)) {
		// select_ActivityType.click();
		// break;
		// }
		// }
		//
		// for (WebElement select_Actions : driver.findElements(
		// By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/div/div[2]/div")))
		// {
		// if (select_Actions.getText().equalsIgnoreCase(action)) {
		// select_Actions.click();
		// break;
		//
		// }
		// }

		Thread.sleep(2000);
		builder.moveToElement(clickOnsearchBtn).click().build().perform();
	}

	public void startDate(String fromDate) throws Exception {

		
		clickOnFromdateTextBox.click();

		String sp[] = fromDate.split("/");

		Date d = new Date(fromDate);
		// System.out.println("Date" + d);
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/YYYY");
		// System.out.println("dt" + dt);
		String date = dt.format(d);
		// System.out.println("date" + date);

		String split[] = date.split("/");
		String month = split[0];
		// System.out.println("month" + month);
		String day = split[1];
		// System.out.println("day" + day);
		if (day.charAt(0) == '0')
			day = day.charAt(1) + " ";
		String monthName = month.substring(0, 3);
		// System.out.println("monthName" + monthName);

		String monthYear = monthName + " " + split[2];

		// System.out.println("monthYear" + monthYear);

		
		String currentdate = driver
				.findElement(By.xpath("/html/body/div[11]/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).getText();

		// Current Month
		String mm = currentdate.substring(0, 3);
		// Current Year

		String year = currentdate.substring(4, 8);
		// System.out.println("year" + year);

		int monthdateinteger = 0;

		int yearInteger = Integer.parseInt(year);

		// System.out.println("yearInteger" + yearInteger);

		int monthDateReadFromExcel = Integer.parseInt(sp[0]);

		// System.out.println("monthDateReadFromExcel" + monthDateReadFromExcel);

		int yearDateReadFromExcel = Integer.parseInt(split[2]);

		// System.out.println("yearDateReadFromExcel" + yearDateReadFromExcel);

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

		int monthdiff = monthDateReadFromExcel - monthdateinteger;

		// System.out.println("MonthDiff" + monthdiff);

		int yeardiff = yearDateReadFromExcel - yearInteger;
		// System.out.println("yearDiff" + yeardiff);
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
							"body > div > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(3) > div > div"))
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
				"/html/body/div[11]/div/table/tbody/tr[2]/td/table/tbody/tr/td[not(contains(@class,'datePickerDay datePickerDayIsWeekend datePickerDayIsFiller'))and not(contains(@class,'datePickerDay datePickerDayIsFiller '))]"));

		for (int i = 0; i < list_AllMonthToBook.size(); i++) {

			if (list_AllMonthToBook.get(i).getText().equalsIgnoreCase(day)) {
				list_AllMonthToBook.get(i).click();
				break;

			}
		}

	}

	public void endDate(String toDate) throws InterruptedException {

		Thread.sleep(2000);
		clickOnTodateTextbox.click();
		String sp[] = toDate.split("/");
		// System.out.println(sp[0]);
		// System.out.println(sp[1]);
		// System.out.println(sp[2]);

		Date d = new Date(toDate);
		// System.out.println("Date" + d);
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/YYYY");
		// System.out.println("dt" + dt);
		String date = dt.format(d);
		// System.out.println("date" + date);

		String split[] = date.split("/");
		String month = split[0];
		// System.out.println("month" + month);
		String day = split[1];
		// System.out.println("day" + day);
		if (day.charAt(0) == '0')
			day = day.charAt(1) + " ";
		String monthName = month.substring(0, 3);
		// System.out.println("monthName" + monthName);

		String monthYear = monthName + " " + split[2];

		// System.out.println("monthYear" + monthYear);

		Thread.sleep(2000);
		String currentdate = driver
				.findElement(By.xpath("/html/body/div[11]/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).getText();

		// Current Month
		String mm = currentdate.substring(0, 3);
		// Current Year

		String year = currentdate.substring(4, 8);
		// System.out.println("year" + year);

		int monthdateinteger = 0;

		int yearInteger = Integer.parseInt(year);

		// System.out.println("yearInteger" + yearInteger);

		int monthDateReadFromExcel = Integer.parseInt(sp[0]);

		// System.out.println("monthDateReadFromExcel" + monthDateReadFromExcel);

		int yearDateReadFromExcel = Integer.parseInt(split[2]);

		// System.out.println("yearDateReadFromExcel" + yearDateReadFromExcel);

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

		int monthdiff = monthDateReadFromExcel - monthdateinteger;

		// System.out.println("MonthDiff" + monthdiff);

		int yeardiff = yearDateReadFromExcel - yearInteger;
		// System.out.println("yearDiff" + yeardiff);
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
							"body > div > div > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(3) > div > div"))
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
				"/html/body/div[11]/div/table/tbody/tr[2]/td/table/tbody/tr/td[not(contains(@class,'datePickerDay datePickerDayIsWeekend datePickerDayIsFiller '))and not (contains(@class,'datePickerDay datePickerDayIsFiller '))]"));

		for (int i = 0; i < list_AllMonthToBook.size(); i++) {

			if (list_AllMonthToBook.get(i).getText().equalsIgnoreCase(day)) {
				list_AllMonthToBook.get(i).click();
				break;

			}
		}

	}

}
