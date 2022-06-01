package pages;

import java.util.List;
import java.util.Set;
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
import org.testng.Reporter;

public class PgDrFirst {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	public static String firstWinHandle;

	// Element Locater
	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget > a")
	private WebElement clickOpenEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-sys-erx")
	private WebElement clickOneRX;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content>div>div>a")
	private WebElement clickOnDrFirstLaunch;

	@FindBy(how = How.CSS, using = "#status_bar_patient > tbody>tr:nth-child(2)>td:nth-child(4)>a:nth-child(2)")
	private WebElement clickOnPrescribe;

	@FindBy(how=How.XPATH,using="//a[text()=\"Manage Medications\"]")
	private WebElement clickOnMedication;

	@FindBy(how = How.CSS, using = "#favorites_select_box")
	private WebElement clickOnFavourites;

	@FindBy(how = How.CSS, using = "#favorites_select_box_id > input[type=\"submit\"]:nth-child(2)")
	private WebElement clickOnUse;

	@FindBy(how = How.XPATH, using = "/html/body/table[4]/tbody/tr[2]/td[2]/form/div/input[2]")
	private WebElement clickOnPrescribrAnyways;

	@FindBy(how = How.CSS, using = "#pending_prescription_table > tbody > tr:nth-child(5) > td.dataValue > table > tbody > tr > td:nth-child(1) > table > tbody>tr:nth-child(1)>td:nth-child(1)>input:nth-child(1)")
	private WebElement fillSignaturePassword;

	@FindBy(how = How.CSS, using = "#pending_prescription_table > tbody > tr:nth-child(3) > td.dataValue > table > tbody > tr > td:nth-child(1) > table > tbody>tr:nth-child(3)>td:nth-child(1)>input:nth-child(1)")
	private WebElement clickOnSend;

	@FindBy(how = How.CSS, using = "#gwt-debug-close_overlay>a")
	private WebElement clickOnCancelButton;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody>tr>td:nth-child(2)>div")
	private WebElement clickOnEyeHistory;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-eye-meds-container\"]/div/div[1]")
	private WebElement getMedicineText;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody>tr>td:nth-child(9)>div")
	private WebElement clickOnImpPlan;

	@FindBy(how = How.CSS, using = "#gwt-debug-addNewProblem")
	private WebElement clickAddNewProblem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[2]/div[11]")
	private WebElement clickOnOkSurgery;

	@FindBy(how = How.CSS, using = "#gwt-debug-overlay_content > div > div > div > div.btn_green>a")
	private WebElement clickOnOk;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[2]/div[9]/div[3]")
	private WebElement clickOnSurgeryAndprocedures;

	@FindBy(how = How.CSS, using = "#gwt-debug-newSurgeryLink > a")
	private WebElement clickOnScheduleNewSurgery;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-surgeryName\"]")
	private WebElement clickOnEditButton;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(3)>input")
	private WebElement clickOnComanaging;

	@FindBy(how = How.CSS, using = "#gwt-debug-done > a")
	private WebElement clickOnDoneBtton;

	@FindBy(how = How.CSS, using = "#content > div > div > div > div > div:nth-child(4) > div > table > tbody > tr> td > div > div > div:nth-child(3) > div > div:nth-child(2) > div > div > span:nth-child(4)>input")
	private WebElement clickOnStagedProcedure;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[1]/select")
	private WebElement clickOnlocationOfSurgery;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[2]/select")
	private WebElement clickOnWhen;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[3]/select")
	private WebElement clickOnAnthesia;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[4]/select")
	private WebElement clickOnSurgon;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[5]/select")
	private WebElement clickOnAssitantSurgon;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[4]/select")
	private WebElement clickOnCategoryOfSurgon;

	@FindBy(how = How.CSS, using = "#gwt-debug-planCompleteCheck>input")
	private WebElement clickOnPrimilaryPlanning;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[5]/input")
	private WebElement clickOnProcedure;

	@FindBy(how = How.CSS, using = "#gwt-debug-Done > a")
	private WebElement clickOnPrimilaryplanningDoneBtton;

	@FindBy(how = How.CSS, using = "#gwt-debug-closeSurgeriesLink")
	private WebElement clickOnCloseSurgery;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	// @FindBy(how = How.CSS, using = "#gwt-debug-planWidget > div:nth-child(4) >
	// div.GIGNACEDFV.GIGNACEDMV.GIGNACEDFW>div:nth-child(2)")
	// private WebElement compareMedicine;

	public PgDrFirst(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void verifyDrFirst(String provider, String OtherHistory, String medName, String password, String category,
			String subCategory, String subCategory1, String eye, String glaucomaSeverity, String glaucomaStability,
			String surgery, String favouriteCategories, String scheduleSurgery, String whicheyeOrSide, String problem,
			Boolean comanaging, Boolean stagedProcedure, String locationSurgery, String when, String anethesia,
			String surgon, String assitantsurgon, String categoryOfsurgon, String procedure, Boolean primilareyPlanning)
			throws InterruptedException {

		Thread.sleep(5000);
		clickOpenEncounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
//		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(15000);
			List<WebElement> select_Provider = driver
					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
			for (int i = 1; i <= select_Provider.size(); i++)
				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
					select_Provider.get(i).click();
					break;
				}
		//}

//		// Thread.sleep(5000);
//		else if (select_RowFromOpenEncounter <= 0) {
//			Thread.sleep(7000);
//			clickStartNewEncounter.click();
//
//		}

		// select eyeHistory
		Thread.sleep(2000);
		java.util.List<WebElement> eyeHiostoryClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < eyeHiostoryClick.size(); i++)
			if (eyeHiostoryClick.get(i).getText().equalsIgnoreCase(OtherHistory)) {
				eyeHiostoryClick.get(i).click();
				break;

			}

		// click On eRX
		Thread.sleep(4000);
		clickOneRX.click();

		// click On Dr first Launch
		Thread.sleep(5000);
		clickOnDrFirstLaunch.click();

		// code for enable dr.first
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

		// click on prescribe
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnMedication)).click();

		// click on favourites
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnFavourites)).click();

		// select medicine
		Thread.sleep(5000);
		java.util.List<WebElement> clickOnMedicine = driver.findElements(By.cssSelector(
				"#medication_selection_table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody>tr:nth-child(3)>td:nth-child(2)>select>option"));
		for (int i = 0; i < clickOnMedicine.size(); i++)
			if (clickOnMedicine.get(i).getText().equalsIgnoreCase(medName)) {
				clickOnMedicine.get(i).click();
				break;

			}

		// click on Use Button
		Thread.sleep(3000);
		clickOnUse.click();

		// click on PrescibeAnyways
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnPrescribrAnyways)).click();

		// click on Fill signature Password
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(fillSignaturePassword)).sendKeys(password);

		// click on send button
		Thread.sleep(3000);
		clickOnSend.click();

		// close driver
		Thread.sleep(3000);
		driver.close();

		// switch to CertificationSite
		driver.switchTo().window(firstWinHandle);

		// click on CalncelButton
		Thread.sleep(3000);
		clickOnCancelButton.click();

		// click on eyeHistoryTab
		Thread.sleep(3000);
		clickOnEyeHistory.click();

		// compareString
		Thread.sleep(5000);
		String storeMedicineText = getMedicineText.getText();
		String actualText = medName.substring(0, 8);
		System.out.println(actualText);
		String storeActualMedicine = storeMedicineText.substring(0, 8);
		System.out.println(storeActualMedicine);
		if (storeActualMedicine.startsWith(actualText)) {
			Thread.sleep(2000);
			clickOnImpPlan.click();
		}

		// click on addNewProblem linkl
		Thread.sleep(3000);
		clickAddNewProblem.click();

		// select category Glaucoma
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaCategoryClick = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaCategoryClick.size(); i++)
			if (gulcomaCategoryClick.get(i).getText().equalsIgnoreCase(category)) {
				gulcomaCategoryClick.get(i).click();
				break;

			}

		// select subCategory Glaucoma with Other Disorders
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaSubCategoryClick = driver.findElements(
				By.xpath("//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategoryClick.size(); i++)
			if (gulcomaSubCategoryClick.get(i).getText().equalsIgnoreCase(subCategory)) {
				gulcomaSubCategoryClick.get(i).click();
				break;

			}

		// select subCategory1 Glaucoma
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaSubCategory1Click = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategory1Click.size(); i++)
			if (gulcomaSubCategory1Click.get(i).getText().equalsIgnoreCase(subCategory1)) {
				gulcomaSubCategory1Click.get(i).click();
				break;

			}

		// select Glaucoma Eye
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaEyeClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaEyeClick.size(); i++)
			if (gulcomaEyeClick.get(i).getText().equalsIgnoreCase(eye)) {
				gulcomaEyeClick.get(i).click();
				break;

			}

		// select Glaucoma Severity
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaSeverityClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaSeverityClick.size(); i++)
			if (gulcomaSeverityClick.get(i).getText().equalsIgnoreCase(glaucomaSeverity)) {
				gulcomaSeverityClick.get(i).click();
				break;

			}

		// select Glaucoma Stability
		Thread.sleep(4000);
		java.util.List<WebElement> gulcomaStabilityClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div"));
		for (int i = 0; i < gulcomaStabilityClick.size(); i++)
			if (gulcomaStabilityClick.get(i).getText().equalsIgnoreCase(glaucomaStability)) {
				gulcomaStabilityClick.get(i).click();
				break;

			}

		// click on okSurgery Button
		Thread.sleep(3000);
		clickOnOkSurgery.click();

		// click on OkTab
		Thread.sleep(3000);
		clickOnOk.click();

		// click on SurgeryAndProcedures
		Thread.sleep(5000);
		clickOnSurgeryAndprocedures.click();

		// select Surgery
		Thread.sleep(4000);
		java.util.List<WebElement> clickOnSurgery = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div/div[2]/div"));
		for (int i = 0; i < clickOnSurgery.size(); i++)
			if (clickOnSurgery.get(i).getText().equalsIgnoreCase(surgery)) {
				clickOnSurgery.get(i).click();
				break;

			}

		// click on ScheduleNewSurgery
		Thread.sleep(3000);
		clickOnScheduleNewSurgery.click();

		// click on Edit
		Thread.sleep(3000);
		clickOnEditButton.click();

		// select category
		Thread.sleep(4000);
		java.util.List<WebElement> clickOnFavCategory = driver
				.findElements(By.cssSelector("#gwt-debug-prior_eye-categories-list>div>div"));
		for (int i = 0; i < clickOnFavCategory.size(); i++)
			if (clickOnFavCategory.get(i).getText().equalsIgnoreCase(favouriteCategories)) {
				clickOnFavCategory.get(i).click();
				break;

			}

		// select Surgery
		Thread.sleep(4000);

		// driver.findElement(By.xpath("//*[@id=\"gwt-debug-codes-list\"]/div[1]/div[2]/div[3]")).click();

		List<WebElement> selct_ScheduleSurgery = driver
				.findElements(By.cssSelector("#gwt-debug-codes-list > div:nth-child(1) > div > div"));
		for (int i = 1; i <= selct_ScheduleSurgery.size(); i++)
			if (selct_ScheduleSurgery.get(i).getText().equalsIgnoreCase(scheduleSurgery)) {
				selct_ScheduleSurgery.get(i).click();
				break;
			}
		// select EyeOrSide
		Thread.sleep(4000);
		java.util.List<WebElement> clickOnEyeOrSide = driver
				.findElements(By.cssSelector("#gwt-debug-eyeSide-container>div"));
		for (int i = 0; i < clickOnEyeOrSide.size(); i++)
			if (clickOnEyeOrSide.get(i).getText().equalsIgnoreCase(whicheyeOrSide)) {
				clickOnEyeOrSide.get(i).click();
				break;

			}

		// select Problem
		Thread.sleep(4000);
		java.util.List<WebElement> clickOnProblem = driver
				.findElements(By.cssSelector("#gwt-debug-surgeryProblemList-container>div"));
		for (int i = 0; i < clickOnProblem.size(); i++)
			if (clickOnProblem.get(i).getText().equalsIgnoreCase(problem)) {
				clickOnProblem.get(i).click();
				break;

			}

		// click On DoneButton
		Thread.sleep(4000);
		clickOnDoneBtton.click();

		// for Selecting comanaging checkbox
		Thread.sleep(2 * 1000);
		if (!clickOnComanaging.isSelected() && comanaging)
			clickOnComanaging.click();

		// for Selecting StagedProcedure checkbox
		Thread.sleep(2 * 1000);
		if (!clickOnStagedProcedure.isSelected() && stagedProcedure)
			clickOnStagedProcedure.click();

		// Select Location Of surgery
		Thread.sleep(3000);
		clickOnlocationOfSurgery.click();

		Thread.sleep(4000);
		java.util.List<WebElement> clicklocationSurgery = driver.findElements(By.xpath(
				"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[1]/select/option"));
		for (int i = 0; i < clicklocationSurgery.size(); i++)
			if (clicklocationSurgery.get(i).getText().equalsIgnoreCase(locationSurgery)) {
				clicklocationSurgery.get(i).click();
				break;

			}
		// select when Value
		Thread.sleep(3000);
		clickOnWhen.click();
		Thread.sleep(2000);
		java.util.List<WebElement> clickWhen = driver.findElements(By.xpath(
				"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[2]/select/option"));
		for (int i = 0; i < clickWhen.size(); i++)
			if (clickWhen.get(i).getText().equalsIgnoreCase(when)) {
				clickWhen.get(i).click();
				break;

			}

		// Select Anthesia
		Thread.sleep(3000);
		clickOnAnthesia.click();
		Thread.sleep(2000);
		java.util.List<WebElement> clickAnthesia = driver.findElements(By.xpath(
				"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[3]/select/option"));
		for (int i = 0; i < clickAnthesia.size(); i++)
			if (clickAnthesia.get(i).getText().equalsIgnoreCase(anethesia)) {
				clickAnthesia.get(i).click();
				break;

			}

		// Select surgon
		Thread.sleep(3000);
		clickOnSurgon.click();
		Thread.sleep(2000);
		java.util.List<WebElement> clickSurgon = driver.findElements(By.xpath(
				"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[4]/select/option"));
		for (int i = 0; i < clickSurgon.size(); i++)
			if (clickSurgon.get(i).getText().equalsIgnoreCase(surgon)) {
				clickSurgon.get(i).click();
				break;

			}

		// Select Assitant Surgon
		Thread.sleep(3000);
		clickOnAssitantSurgon.click();
		Thread.sleep(2000);
		java.util.List<WebElement> clickassitantSurgon = driver.findElements(By.xpath(
				"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[3]/div[5]/select/option"));
		for (int i = 0; i < clickassitantSurgon.size(); i++)
			if (clickassitantSurgon.get(i).getText().equalsIgnoreCase(assitantsurgon)) {
				clickassitantSurgon.get(i).click();
				break;

			}

		// Select Category of surgon
		Thread.sleep(3000);
		clickOnCategoryOfSurgon.click();
		Thread.sleep(2000);
		java.util.List<WebElement> clickcategorysurgon = driver.findElements(By.xpath(
				"//*[@id=\"content\"]/div/div/div[2]/div/div[3]/div[1]/table[1]/tbody/tr[2]/td[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[4]/select/option"));
		for (int i = 0; i < clickcategorysurgon.size(); i++)
			if (clickcategorysurgon.get(i).getText().equalsIgnoreCase(categoryOfsurgon)) {
				clickcategorysurgon.get(i).click();
				break;

			}

		// fill procedure value
		Thread.sleep(3000);
		clickOnProcedure.clear();
		Thread.sleep(3000);
		clickOnProcedure.sendKeys(procedure);

		// clcik On PrimilaryPlanning
		Thread.sleep(3 * 1000);
		if (!clickOnPrimilaryPlanning.isSelected() && primilareyPlanning)
			clickOnPrimilaryPlanning.click();

		// Click on PrimilaryPlanningDoneButton
		Thread.sleep(3000);
		clickOnPrimilaryplanningDoneBtton.click();

		// click on close Surgery
		Thread.sleep(3000);
		clickOnCloseSurgery.click();

		// // compare string and close
		// String compareText = "New";
		// String strMedicineText = compareMedicine.getText();
		// strMedicineText = strMedicineText.substring(0, 20);
		// if (strMedicineText.startsWith(compareText)) {
		// Reporter.log("the medicine text is statred with" + " " + compareText);
		// }

		// Thread.sleep(5000);
		// clickOnMyDashBoard.click();
	}
}
