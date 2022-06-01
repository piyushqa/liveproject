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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;

public class PageReconDashBoard {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.LINK_TEXT, using = "File Transfer Recon Dashboard")
	private WebElement clickOnReconDashBoard;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"root\"]/select")
	private WebElement selectIntegritySettings;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/section/div[19]/input")
	private WebElement fillValueInReconText;

	@FindBy(how = How.CSS, using = "input#USERNAME")
	private WebElement fillUserNameText;

	@FindBy(how = How.CSS, using = "input#PASSWORD")
	private WebElement fillUserPassword;

	@FindBy(how = How.CSS, using = "a.loginButton")
	private WebElement clickOnLogInBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-userdash-logout>a")
	private WebElement clickOnLogOutBtn;

	// =====================================================================================================
	@FindBy(how = How.XPATH, using = ".//div[@class=\"ids_dropdown-bar ids_dropdown-bar--dark\"]")
	private WebElement clickOnStatusDropDown;

	@FindBy(how = How.CSS, using = "div.ids_pick-list__item-container>div")
	private List<WebElement> selectstatus;

	@FindBy(how = How.XPATH, using = ".//button[@class=\"ids_button refresh\"]")
	private WebElement clickOnRefreshButton;

	// For calender

	@FindBy(how = How.CSS, using = "input.react-datepicker-ignore-onclickoutside")
	private WebElement clickOnDatePiker;

	@FindBy(how = How.CSS, using = "div.react-datepicker__current-month")
	private WebElement clickOnCurrentMonth;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"react-datepicker\"]/button[2]")
	private WebElement clickOnRightButton;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"react-datepicker\"]/button[1]")
	private WebElement clickOnLeftButton;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"react-datepicker__month\"]/div/div")
	private List<WebElement> selectDay;

	@FindBy(how = How.CSS, using = "div#gwt-debug-userdash-logout>a")
	private WebElement clickOnLogOut;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageReconDashBoard(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageReconDashBoard.this);
	}

	public void verifyRecondashBoard(String selectDate, String status) throws Exception {

		performReconSettingOperation();
		
		boolean check = isClickable(clickOnReconDashBoard);
		// String check=clickOnReconDashBoard.getText();
		System.out.println(check);

		try {
			if (check) {
				Thread.sleep(3000);
				ensureElememtToBeClickable(clickOnReconDashBoard);
				clickOnReconDashBoard.click();
				handleWindow();

				selectStatus(status);
			}
		} catch (Exception e) {
			Reporter.log("Recon setting is disabled");
			System.out.println("Recon setting is disabled");
		}

	}

	public void performReconSettingOperation() throws Exception {

		new PageReconFin(driver, wait, builder).handleIntegritySettings();

		perfromReconSetting();

		//logInFunction();

	}

	public void perfromReconSetting() throws Exception {

		Thread.sleep(4000);
		//ensureElememtToBeClickable(fillValueInReconText);
		String reconValue = new PageASCIntegration(wait, driver, builder).performASCSettingIntegrationOpertion("reconEnabled");
		//fillValueInReconText.clear();
		if (reconValue.equalsIgnoreCase("true")) {
		logInFunction();
		}
	}

	public void perfromReconSettingDelete() throws Exception {
	}

	public void logInFunction() throws Exception {
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(3000);
		clickOnLogOut.click();
		fillUserNameText.sendKeys(ProjectSettings.userName);
		fillUserPassword.sendKeys(ProjectSettings.password);
		clickOnLogInBtn.click();

	}

	public void selectDate(String selectDate) throws Exception {
		Thread.sleep(7000);
		ensureElememtToBeClickable(clickOnDatePiker);
		builder.moveToElement(clickOnDatePiker).click().build().perform();

		String SelectDate = selectDate;

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
		String currentdate = clickOnCurrentMonth.getText();

		System.out.println(currentdate);
		// current month
		String mm = currentdate.substring(0, 5);
		// current year
		String year = currentdate.substring(6, 10);

		int monthdateinteger = 0;
		// current year convert to integer
		int yearinteger = Integer.parseInt(year);
		// Exel readed month convert to integer
		int monthDateReadFromExel = Integer.parseInt(sp[0]);
		// Exel readed year convert to integer
		int yearDateReadFromExel = Integer.parseInt(split[2]);

		if (mm.startsWith("Jan")) {
			monthdateinteger = 1;

		}
		if (mm.startsWith("Feb")) {
			monthdateinteger = 2;
		}
		if (mm.startsWith("Mar")) {
			monthdateinteger = 3;
		}
		if (mm.startsWith("Apr")) {
			monthdateinteger = 4;
		}
		if (mm.startsWith("May")) {
			monthdateinteger = 5;
		}
		if (mm.startsWith("Jun")) {
			monthdateinteger = 6;
		}
		if (mm.startsWith("Jul")) {
			monthdateinteger = 7;
		}
		if (mm.startsWith("Aug")) {
			monthdateinteger = 8;
		}
		if (mm.startsWith("Sep")) {
			monthdateinteger = 9;
		}
		if (mm.startsWith("Oct")) {
			monthdateinteger = 10;
		}
		if (mm.startsWith("Nov")) {
			monthdateinteger = 11;
		}
		if (mm.startsWith("Dec")) {
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
					clickOnRightButton.click();
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
					clickOnLeftButton.click();
				}

			}
		}
		// Select the day of the month
		List<WebElement> list_AllMonthToBook = selectDay;

		for (int i = 0; i < list_AllMonthToBook.size(); i++) {

			if (list_AllMonthToBook.get(i).getText().equalsIgnoreCase(day)) {
				list_AllMonthToBook.get(i).click();
				break;

			}

		}
	}

	public boolean isClickable(WebElement element) {

		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void selectStatus(String status) throws Exception {

		Thread.sleep(4000);
		ensureElememtToBeClickable(clickOnStatusDropDown);
		clickOnStatusDropDown.click();

		Thread.sleep(2000);
		for (WebElement select_status : selectstatus) {
			if (select_status.getText().equalsIgnoreCase(status)) {
				select_status.click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnRefreshButton);
		builder.moveToElement(clickOnRefreshButton).click().build().perform();
	}

	public void handleWindow() throws Exception {
		for (String handleWindow : driver.getWindowHandles()) {
			driver.switchTo().window(handleWindow);
		}
	}

	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
}
