package pages;

import java.text.SimpleDateFormat;
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

public class PageAddImmunization {
	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	// Define Locater
	@FindBy(how = How.CSS, using = "#gwt-debug-otherLinks-button>div:last-child")
	private WebElement clickOnOtherLinks;

	@FindBy(how = How.ID, using = "gwt-debug-otherLinks-container")
	private WebElement otherLinksContainer;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/select")
	private WebElement ClickOnImmunizationType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr[2]/td[1]/input")
	private WebElement testBoxForAmounts;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr[2]/td[2]/input")
	private WebElement testBoxForUnits;

	@FindBy(how = How.XPATH, using = ".//input[@type=\"text\" and @class=\"gwt-DateBox\"]")
	private WebElement clickOnDateTextbox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr[2]/td[1]/input")
	private WebElement textLot;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr[2]/td[2]/input")
	private WebElement textMfgCode;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr[2]/td[1]/input")
	private WebElement textMfgname;

	@FindBy(how = How.XPATH, using = "//*[text()=\"Add Immunization\"]")
	private WebElement clickOnAddImmunization;

	@FindBy(how = How.XPATH, using = "//*[text()=\"Submit to Registry\"]")
	private WebElement clickOnSubmitToRegistry;

	// constructor
	public PageAddImmunization(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddImmunization.this);
	}

	// function for verifyImmunization
	public void verifyImmunization(String immunizationsTypes, String AmontUnits, String immunizationdate,
			String lotMfgCodeAndName, String immunizationStatus) throws Exception {
		// clickOnOtherLinks
		Thread.sleep(3000);
		ensureElementToBeClickAble(clickOnOtherLinks);
		builder.moveToElement(clickOnOtherLinks).click().perform();

		//select_OtherLinks
		Thread.sleep(3000);
		for (WebElement select_OtherLinks : otherLinksContainer.findElements(By.xpath(".//*"))) {
			if (select_OtherLinks.getText().equalsIgnoreCase("Immunization History")) {
				select_OtherLinks.click();
				break;
			}
		}

		//Click On Immunization Type
		Thread.sleep(3000);
		ensureElementToBeClickAble(ClickOnImmunizationType);
		builder.moveToElement(ClickOnImmunizationType).click().perform();


		//select Immunization Value
		Thread.sleep(2000);
		List<WebElement> selectImmunizationValue = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/select/option"));
		for (WebElement select_ImmunizationType : selectImmunizationValue) {
			if (select_ImmunizationType.getText().equalsIgnoreCase(immunizationsTypes)) {
				select_ImmunizationType.click();
				break;
			}
		}

		//fill value in amount units
		Thread.sleep(2000);
		String[] amountUnits = AmontUnits.split("-");
		// testBoxForAmounts.clear();
		ensureElementToBeClickAble(testBoxForAmounts);
		testBoxForAmounts.sendKeys(amountUnits[0]);
		// testBoxForUnits.clear();
		ensureElementToBeClickAble(testBoxForUnits);
		testBoxForUnits.sendKeys(amountUnits[1]);


		//click On Date Textbox
		Thread.sleep(3000);
		ensureElementToBeClickAble(clickOnDateTextbox);
		clickOnDateTextbox.click();

		String SelectDate = immunizationdate;

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


		//fill the value in txt Lot# Mfg Code And Name
		Thread.sleep(2000);
		String txtLotMfgCodeAndName[] = lotMfgCodeAndName.split("-");
		ensureElementToBeClickAble(textLot);
		textLot.sendKeys(txtLotMfgCodeAndName[0]);
		ensureElementToBeClickAble(textMfgCode);
		textMfgCode.sendKeys(txtLotMfgCodeAndName[1]);
		ensureElementToBeClickAble(textMfgname);
		textMfgname.sendKeys(txtLotMfgCodeAndName[2]);


		//click List Box ImmunizationStatus
		List<WebElement> clickListBoxImmunizationStatus = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/div/div[9]/select/option"));
		for (WebElement select_ImmunizationStatus : clickListBoxImmunizationStatus) {
			if (select_ImmunizationStatus.getText().equalsIgnoreCase(immunizationStatus)) {
				select_ImmunizationStatus.click();
				break;
			}
		}
		//click On Add Immunization
		Thread.sleep(2000);
		ensureElementToBeClickAble(clickOnAddImmunization);
		clickOnAddImmunization.click();

		//click On Submit To Registry
		Thread.sleep(2000);
		ensureElementToBeClickAble(clickOnSubmitToRegistry);
		clickOnSubmitToRegistry.click();
	}

	//function for element ClickAble
	public void ensureElementToBeClickAble(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
