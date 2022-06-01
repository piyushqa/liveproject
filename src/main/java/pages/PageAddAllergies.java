package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageAddAllergies {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String firstWinHandle;

	// Define Locater
	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget > a")
	private WebElement clickOpenEncounter;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div")
	private List<WebElement> selectProvider;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"encounter_tab_bar_container\"]/table/tbody/tr/td/div")
	private List<WebElement> selectOtherHistory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-sys-erx")
	private WebElement clickOnERX;

	@FindBy(how = How.CSS, using = "div#gwt-debug-overlay_content>div>div>a")
	private WebElement clickOnLaunchDrFirst;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Manage Allergies\"]")
	private WebElement clickOnManageAllergies;

	@FindBy(how = How.XPATH, using = "//input[contains(@name,'drug')]")
	private WebElement fillTheValueInAllergiesTextBox;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'Find')]")
	private WebElement clickOnFindBtn;

	@FindBy(how = How.XPATH, using = ".//b[text()=\"Biaxin XL\"]")
	private WebElement clickOnBiaxinXL;

	@FindBy(how=How.XPATH,using="//*[@id=\"allergy_report_selections\"]/tbody/tr/td[2]/dl/dt[2]/a[1]/b")
	private WebElement clickOnCiproHCL;

	@FindBy(how = How.XPATH, using = ".//select[contains(@name,'allergy_reaction_picklist')]")
	private WebElement clickOnReaction;

	@FindBy(how = How.XPATH, using = ".//select[contains(@name,'allergy_reaction_picklist')]/option")
	private List<WebElement> selectReaction;

	@FindBy(how = How.XPATH, using = ".//select[contains(@name,'allergy_severity_picklist')]")
	private WebElement clickOnSeverity;

	@FindBy(how = How.XPATH, using = ".//select[contains(@name,'allergy_severity_picklist')]/option")
	private List<WebElement> selectSeverity;

	@FindBy(how = How.XPATH, using = ".//select[contains(@id,'onset_month')]")
	private WebElement clickOnSetMonth;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//select[contains(@id,'onset_month')]/option"),
			@FindBy(how = How.XPATH, using = ".//select[contains(@name,'onset_month')]/option") })
	private List<WebElement> selectMonth;

	@FindBy(how = How.XPATH, using = ".//select[contains(@id,'onset_day')]")
	private WebElement clickOnDay;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//select[contains(@id,'onset_day')]/option"),
			@FindBy(how = How.XPATH, using = ".//select[contains(@name,'onset_day')]/option") })
	private List<WebElement> selectDay;

	@FindBy(how = How.XPATH, using = ".//select[contains(@id,'onset_year')]")
	private WebElement clickOnYear;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//select[contains(@id,'onset_year')]/option"),
			@FindBy(how = How.XPATH, using = ".//select[contains(@name,'onset_year')]/option") })
	private List<WebElement> selectYear;

	@FindBy(how = How.XPATH, using = ".//input[@value=\"Add\"]")
	private WebElement clickOnAdd;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-close_overlay\"]/a[contains(@class,'close')]")
	private WebElement clickOnClose;

	@FindBy(how = How.XPATH, using = ".//*[starts-with(@class,'datalist-item')]/div[(contains(@class,'gwt-Label'))][2]")
	private WebElement clickOnEMRAllergis;

	@FindBy(how = How.ID, using = "gwt-debug-onsetDate")
	private WebElement getOnSetDate;

	@FindBy(how = How.CSS, using = "#gwt-debug-erxDone>a")
	private WebElement clickOnERXDone;

	public PageAddAllergies(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddAllergies.this);
	}

	public void verifyAddAllerigies(String provider, String allergies, String recation, String severity, String Date,
			String category, String subCategory1, String subCategory2, String eye, String galuocmaSeverity,
			String galuocmaStability, Boolean significantProblem, String visitType, Boolean noCharges)
			throws Exception {

		// click to open existing encounter
		// Thread.sleep(3000);
		// ensureElementToBeClickable(clickOpenEncounter);
		// builder.moveToElement(clickOpenEncounter).click().perform();
		//
		// // select provider
		// Thread.sleep(2000);
		// for (WebElement select_Provider : selectProvider) {
		// if (select_Provider.getText().equalsIgnoreCase(provider)) {
		// select_Provider.click();
		// break;
		// }
		// }

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		//open dr first window
		Thread.sleep(2000);
		launchDrFirst();

		// call add Allergie method for add allergies,recation,severity and date
		addAllergie(allergies, recation, severity, Date);

		// close Dr First window
		Thread.sleep(2000);
		driver.close();

		// Switch to EMR
		Thread.sleep(3000);
		driver.switchTo().window(firstWinHandle);

		// click on close(Dr first launch window)
		Thread.sleep(2000);
		builder.moveToElement(clickOnClose).click().perform();


//		// click On EMRAllergis
//		Thread.sleep(4000);
//		clickOnEMRAllergis.click();
//
//		// call matchEMRDate function for match the date
//		Thread.sleep(3000);
//		matchEMRDate(Date);

		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	public void launchDrFirst() throws Exception {
		// select other history
		Thread.sleep(2000);
		for (WebElement select_OtherHistory : selectOtherHistory) {
			if (select_OtherHistory.getText().equalsIgnoreCase("Other History")) {
				select_OtherHistory.click();
				break;
			}
		}
		// click on ERX
		Thread.sleep(1000);
		clickOnERX.click();

		// click on launch Drfirst
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLaunchDrFirst);
		clickOnLaunchDrFirst.click();

		// switch to dr first window
		Set handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle = (String) handles.iterator().next();

		if (winHandle != firstWinHandle) {

			// To retrieve the handle of second window, extracting the handle which does not
			// match to first window handle

			String secondWinHandle = winHandle; // Storing handle of second window handle

			// Switch control to new window

			driver.switchTo().window(secondWinHandle);
		}

		// click on manage allergies
		Thread.sleep(6000);
		clickOnManageAllergies.click();

	}

	// Add allergie method for add allergie,severity,reaction and date
	public void addAllergie(String allergies, String recation, String severity, String Date) throws Exception {

		// fill The Value In Allergies TextBox
		Thread.sleep(3000);
		fillTheValueInAllergiesTextBox.sendKeys(allergies);

		// click On Find Btn
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnFindBtn);
		clickOnFindBtn.click();

		// click On Biaxin XL
		Thread.sleep(2000);
		try {
		builder.moveToElement(clickOnBiaxinXL).click().perform();
		}catch(Exception ex) {
			Thread.sleep(5000);
			builder.moveToElement(clickOnCiproHCL).click().perform();
		}
		// click On Reaction
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnReaction);
		clickOnReaction.click();

		// select_Reaction
		Thread.sleep(2000);
		for (WebElement select_Reaction : selectReaction) {
			if (select_Reaction.getText().equalsIgnoreCase(recation)) {
				select_Reaction.click();
				break;
			}
		}

		// click On Severity
//		Thread.sleep(2000);
//		clickOnSeverity.click();
//		for (WebElement select_Severity : selectSeverity) {
//			if (select_Severity.getText().equalsIgnoreCase(severity)) {
//				select_Severity.click();
//				break;
//			}
//		}

		// split the date
		String splitDate[] = Date.split("-");

		// click On Set Month
		Thread.sleep(2000);
		clickOnSetMonth.click();

		// select Month
		Thread.sleep(2000);
		for (WebElement select_Month : selectMonth) {
			if (select_Month.getText().equalsIgnoreCase(splitDate[0])) {
				select_Month.click();
				break;
			}
		}

		// click On Day
		Thread.sleep(2000);
		clickOnDay.click();

		// select Day
		Thread.sleep(2000);
		for (WebElement select_date : selectDay) {
			if (select_date.getText().equalsIgnoreCase(splitDate[1])) {
				select_date.click();
				break;
			}

		}

		// click On Year
		Thread.sleep(2000);
		clickOnYear.click();

		// select Year
		Thread.sleep(2000);
		for (WebElement select_Year : selectYear) {
			if (select_Year.getText().equalsIgnoreCase(splitDate[2])) {
				select_Year.click();
				break;
			}
		}
		// click on Add
		Thread.sleep(4000);
		clickOnAdd.click();

	}

	// matchEMRDate method use to match date from dr first to integrityEMR
	public void matchEMRDate(String Date) throws Exception {

		// getText of date
		Thread.sleep(3000);
		String getAllerigsEMRDate = getOnSetDate.getText();

		String splitgetAllerigsEMRDate[] = getAllerigsEMRDate.split("-");

		String stopMonth = splitgetAllerigsEMRDate[0];

		String stopDate = splitgetAllerigsEMRDate[1];

		String stopYear = splitgetAllerigsEMRDate[2];

		String OriginalMonth = null;

		switch (stopMonth) {
		case "01":
			OriginalMonth = "Jan";
			break;
		case "02":
			OriginalMonth = "Feb";
			break;
		case "03":
			OriginalMonth = "Mar";
			break;
		case "04":
			OriginalMonth = "Apr";
			break;
		case "05":
			OriginalMonth = "May";
			break;
		case "06":
			OriginalMonth = "Jun";
			break;
		case "07":
			OriginalMonth = "Jul";
			break;
		case "08":
			OriginalMonth = "Aug";
			break;
		case "09":
			OriginalMonth = "Sep";
			break;
		case "10":
			OriginalMonth = "Oct";
			break;
		case "11":
			OriginalMonth = "Nov";
			break;
		case "12":
			OriginalMonth = "Dec";
			break;
		default:
			System.out.println("unknown month");

		}

		// match excel date to integrity EMR date
		Thread.sleep(3000);
		String getOriginalStopDateForEMR = OriginalMonth + "-" + stopDate + "-" + stopYear;

		if (Date.contains(getOriginalStopDateForEMR)) {
			System.out.println(getOriginalStopDateForEMR + " " + "and" + " " + Date + " " + "matched");
		}

		// click on ERX Done
		Thread.sleep(3000);
		builder.moveToElement(clickOnERXDone).click().perform();

	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
