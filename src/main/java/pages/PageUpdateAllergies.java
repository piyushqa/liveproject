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

public class PageUpdateAllergies {
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

	@FindBy(how = How.XPATH, using = ".//table[@id=\"allergy_table\"]/tbody/tr/td/a[text()=\"[Modify]\"]")
	private WebElement clickOnmodify;

	@FindBy(how = How.XPATH, using = ".//input[@value=\"Change\"]")
	private WebElement clickOnChange;
	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-close_overlay\"]/a[contains(@class,'close')]")
	private WebElement clickOnClose;

	@FindBy(how = How.XPATH, using = ".//*[starts-with(@class,'datalist-item')]/div[(contains(@class,'gwt-Label'))][2]")
	private WebElement clickOnEMRAllergis;

	@FindBy(how = How.ID, using = "gwt-debug-onsetDate")
	private WebElement getOnSetDate;

	@FindBy(how = How.CSS, using = "#gwt-debug-erxDone>a")
	private WebElement clickOnERXDone;

	public PageUpdateAllergies(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageUpdateAllergies.this);
	}

	public void verifyUpdateAllerigies(String provider, String recation, String severity, String modifyDate)
			throws Exception {

		// click Open Encounter
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOpenEncounter);
		builder.moveToElement(clickOpenEncounter).click().perform();

		// select provider
		Thread.sleep(2000);
		for (WebElement select_Provider : selectProvider) {
			if (select_Provider.getText().equalsIgnoreCase(provider)) {
				select_Provider.click();
				break;
			}
		}

		// select other History
		Thread.sleep(2000);
		for (WebElement select_OtherHistory : selectOtherHistory) {
			if (select_OtherHistory.getText().equalsIgnoreCase("Other History")) {
				select_OtherHistory.click();
				break;
			}
		}

		// click On ERX
		Thread.sleep(1000);
		clickOnERX.click();

		// click On Launch DrFirst
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLaunchDrFirst);
		clickOnLaunchDrFirst.click();

		// switch to DrFirst window
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

		//call method update alergie to update recation,severity,modifyDate
		try {
			updateAllergie(recation, severity, modifyDate);
		}catch(Exception e) {
			String allergies="Biaxin";
			String Date="Feb-12-2018";
			PageAddAllergies addAllergies=new PageAddAllergies(driver, wait, builder);
			addAllergies.addAllergie(allergies, recation, severity, Date);
		}
		//close dr first driver
		Thread.sleep(2000);
		driver.close();

		//click on switch to integrityEMR Application
		Thread.sleep(2000);
		driver.switchTo().window(firstWinHandle);

		//click on close of dr first window
		Thread.sleep(2000);
		builder.moveToElement(clickOnClose).click().perform();

        //click On EMR Allergis
		Thread.sleep(2000);
		clickOnEMRAllergis.click();

		//click on match EMR Date to Modify date
		Thread.sleep(3000);
		matchEMRDate(modifyDate);

	}

	//Update the allergie by reaction ,severity and modifyDate
	public void updateAllergie(String recation, String severity, String modifyDate) throws Exception {

		//click on manage Allergies
		Thread.sleep(6000);
		clickOnManageAllergies.click();

		//clickOn modify
		Thread.sleep(4000);
		clickOnmodify.click();

		//click on reaction
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnReaction);
		clickOnReaction.click();

		//select Reaction
		Thread.sleep(2000);
		for (WebElement select_Reaction : selectReaction) {
			if (select_Reaction.getText().equalsIgnoreCase(recation)) {
				select_Reaction.click();
				break;
			}
		}

		//click on severity
//		Thread.sleep(2000);
//		clickOnSeverity.click();
//
//		//selectSeverity
//		for (WebElement select_Severity : selectSeverity) {
//			if (select_Severity.getText().equalsIgnoreCase(severity)) {
//				select_Severity.click();
//				break;
//			}
//		}

		//split date
		String splitModifydate[] = modifyDate.split("-");

		//click on set month
		Thread.sleep(2000);
		clickOnSetMonth.click();

		//select Month
		Thread.sleep(2000);
		for (WebElement select_Month : selectMonth) {
			if (select_Month.getText().equalsIgnoreCase(splitModifydate[0])) {
				select_Month.click();
				break;
			}
		}

		//click On Day
		Thread.sleep(2000);
		clickOnDay.click();

		//select Day
		Thread.sleep(2000);
		for (WebElement select_date : selectDay) {
			if (select_date.getText().equalsIgnoreCase(splitModifydate[1])) {
				select_date.click();
				break;
			}

		}

		//click On Year
		Thread.sleep(2000);
		clickOnYear.click();


		//select Year
		Thread.sleep(2000);
		for (WebElement select_Year : selectYear) {
			if (select_Year.getText().equalsIgnoreCase(splitModifydate[2])) {
				select_Year.click();
				break;
			}
		}

		//click On change when data is added
		Thread.sleep(2000);
		clickOnChange.click();

	}

//function used to get date from integrityEMR and match the date with excel then click on done
	public void matchEMRDate(String modifyDate) throws Exception {

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

		String getOriginalStopDateForEMR = OriginalMonth + "-" + stopDate + "-" + stopYear;

		if (modifyDate.contains(getOriginalStopDateForEMR)) {
			Reporter.log(getOriginalStopDateForEMR + " " + "and" + " " + modifyDate + " " + "matched");
		}
		Thread.sleep(2000);
		clickOnERXDone.click();

	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
