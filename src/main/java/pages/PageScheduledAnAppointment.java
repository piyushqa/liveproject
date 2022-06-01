package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageScheduledAnAppointment {
	WebDriverWait wait;
	WebDriver driver;
	Actions builder;
	public static String firstWinHandle;
	public static String secondWinHandle;
	public static String secondChildhandle;

	// Define Locater
	@FindBy(how = How.LINK_TEXT, using = "IntegrityPM")
	private WebElement clickOnIntegrityPM;

	@FindBy(how = How.XPATH, using = ".//*[@title='Scheduler' or @class=\"amdicons amds-appointments\"]")
	private WebElement clickOnScheduler;

	@FindBy(how = How.CSS, using = "#frmScheduler")
	private WebElement frame1;

	@FindBy(how = How.XPATH, using = "/html/body/amds-root/div/div/div[1]/div[1]/amds-date-selector/div/div[1]/div[1]")
	private WebElement clickOnDateTab;

	@FindBy(how = How.XPATH, using = "/html/body/amds-root/div/div/div[1]/div[1]/amds-date-selector/div/div[1]/div[2]/input[1]")
	private WebElement inputForMonth;

	@FindBy(how = How.XPATH, using = "/html/body/amds-root/div/div/div[1]/div[1]/amds-date-selector/div/div[1]/div[2]/input[2]")
	private WebElement inputForDay;

	@FindBy(how = How.XPATH, using = "/html/body/amds-root/div/div/div[1]/div[1]/amds-date-selector/div/div[1]/div[2]/input[3]")
	private WebElement inputForYear;

	public PageScheduledAnAppointment(WebDriverWait wait, WebDriver driver, Actions builder) {

		this.wait = wait;
		this.driver = driver;
		this.builder = builder;

		PageFactory.initElements(driver, this);
	}

	public void checkScheduledAppointment(String day, String date) throws Exception {

		Thread.sleep(10000);
		ensureElementToBeClickable(clickOnIntegrityPM);
		builder = new Actions(driver);
		builder.moveToElement(clickOnIntegrityPM).click().perform();

		Thread.sleep(20000);
		Set handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle = (String) handles.iterator().next();

		if (winHandle != firstWinHandle) {

			// To retrieve the handle of second window, extracting the handle which does not
			// match to first window handle

			secondWinHandle = winHandle; // Storing handle of second window handle

			// Switch control to new window

			driver.switchTo().window(secondWinHandle);
		}
		Thread.sleep(20000);
		driver.manage().window().maximize();

		Thread.sleep(15000);
		ensureElementToBeClickable(clickOnScheduler);
		clickOnScheduler.click();

		Thread.sleep(20000);
		handles = driver.getWindowHandles();

		secondWinHandle = driver.getWindowHandle();

		handles.remove(secondWinHandle);

		int freameSize = driver.findElements(By.id("frmScheduler")).size();
		System.out.println("\n");
		System.out.println("Frame Size" + freameSize);

		Thread.sleep(2000);
		driver.switchTo().frame(frame1);

		Thread.sleep(6000);
		clickOnDateTab.click();

		// Thread.sleep(6000);
		// List<WebElement> select_Date = driver.findElements(By.xpath(
		// ".//*[@class=\"current-calendar\"]/amds-calendar/div/div[2]/div[not
		// (contains(@class,'amds-calendar-day amds-calendar-selectable
		// out-of-month'))]"));
		// for (int i = 1; i <= select_Date.size(); i++)
		// if (select_Date.get(i).getText().equalsIgnoreCase(day)) {
		// select_Date.get(i).click();
		// break;
		// }

		Thread.sleep(2000);
		String day_Text[] = date.split("/");
		inputForMonth.clear();
		inputForMonth.sendKeys(day_Text[0]);

		Thread.sleep(2000);
		inputForDay.clear();
		inputForDay.sendKeys(day_Text[1]);

		Thread.sleep(2000);
		inputForYear.clear();
		inputForYear.sendKeys(day_Text[2]);

		Thread.sleep(5000);
		inputForYear.sendKeys(Keys.ENTER);
	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
