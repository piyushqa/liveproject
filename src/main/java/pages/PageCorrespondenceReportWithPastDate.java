package pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCorrespondenceReportWithPastDate {
	WebDriverWait wait;
	WebDriver driver;
	Actions builder;
	public String pastDate = "04/05/2018";

	// Define Locater
	@FindBy(xpath = "//*[@id=\"gwt-debug-correspondence\"]/a")
	private WebElement clickOnCorrespondence;

	@FindBy(xpath = ".//input[@class=\"gwt-DatePicker gwt-DatePicker-readonly\"]")
	private WebElement clickOnDateLink;

	@FindBy(xpath = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div[2]/div[2]/div/div[3]")
	private WebElement clickOnCorrespondenceType;

	@FindBy(xpath = ".//textarea[@id=\"gwt-debug-txt-plan\" and @placeholder=\"Enter text here...\"]")
	private WebElement fillComment;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-correspondencePopupFooter\"]/div[2]/div/div/a[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-priorClinicVisits-container\"]")
	private WebElement reportContainer;

	@FindBy(how = How.XPATH, using = ".//a[@class=\"gwt-Anchor blue_text_blk display_block align_left\" and text()=\"Corresp.\"]")
	private WebElement clickOnCorresp;

	public PageCorrespondenceReportWithPastDate(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void verifyCorrespondenceReportWithPastDate(String corrospondenceType, String text, String matchAge,
			String dob, String view) throws Exception {
		// click On crrospondence
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnCorrespondence);
		clickOnCorrespondence.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDateLink);
		clickOnDateLink.click();
		String SelectDate = pastDate;

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

		// click On CorrespondenceType
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnCorrespondenceType);
		clickOnCorrespondenceType.click();

		// select_CorrespondenceType
		Thread.sleep(2000);
		List<WebElement> select_CorrespondenceType = driver
				.findElements(By.xpath("//*[@class=\"gwt-PopupPanel\"]/div/div/div/div[2]/div"));
		for (int i = 1; i <= select_CorrespondenceType.size(); i++)
			if (select_CorrespondenceType.get(i).getText().equalsIgnoreCase(corrospondenceType)) {
				select_CorrespondenceType.get(i).click();
				break;
			}
		// fillComment
		Thread.sleep(1000);
		fillComment.sendKeys(text);

		// click On DoneBtn
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();

		// Differnce between current date and birth date
		Thread.sleep(2000);
		// DateTimeFormatter formatter =DateTimeFormatter.ofPattern("MM/DD/YYYY");
		try {
			LocalDate endofCentury = LocalDate.of(1994, 04, 04);
			LocalDate now = LocalDate.now();
			System.out.println(now);
			Period diff = Period.between(endofCentury, now);
			int Year = diff.getYears();
			System.out.println("Year" + Year);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// get report link
		Thread.sleep(2000);
		for (WebElement e : reportContainer.findElements(By.xpath(".//*"))) {
			//System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(view)) {
				e.click();
				break;
			}
		}

		// click On Corresp
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnCorresp);
		clickOnCorresp.click();

		// switch to window handle
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	// function to check visibility , element time out and clickable
	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
