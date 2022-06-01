package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageIntravitrealInjection {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding = null;
	PgPatientSearch lclPgPatientSearch = null;;
	PgCreatePatient lclpgCreatePatient;

	// declare Locater
	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickOnJoinEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()=\"Yes\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Surgeries and Procedures\"]")
	private WebElement clickOnSurgeriAndProcedures;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Start New Procedure\"]")
	private WebElement clickOnStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//textarea[@class=\"ivi__titleSection__notes\"]")
	private WebElement fillTheInjectionText;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"ivi__eyeSection--right\"]/div[3]/div[1]/div[text()=\"Preliminary\"]")
	private WebElement clickOnPreliminary;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"ivi__eyeSection--right\"]/div[3]/div[1]/div[text()=\"Drug Preparation\"]")
	private WebElement clickOnDrugPrepration;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"ivi__eyeSection--right\"]/div[3]/div[1]/div[text()=\"Procedure\"]")
	private WebElement clickOnProcedure;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"ivi__eyeSection--right\"]/div[3]/div[1]/div[text()=\"Comments & Follow-up\"]")
	private WebElement clickOnCommentsAndProcedure;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"ivi__eyeSection--right\"]/div[3]/div[2]/div/table/tbody/tr[4]/td[1]/div/div/div[1]")
	private WebElement clickOnSignedTodayRadio;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__prelim__right\"]/tbody/tr[1]/td[2]/div")
	private WebElement clickOnScrub1;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__prelim__right\"]/tbody/tr[2]/td[2]/div")
	private WebElement clickOnScrub2;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__prelim__right\"]/tbody/tr[4]/td[2]/div")
	private WebElement clickOnTopicaldrops1;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__prelim__right\"]/tbody/tr[5]/td[2]/div")
	private WebElement clickOnTopicaldrops2;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__drugPrep\"]/tbody/tr[2]/td[2]/div")
	private WebElement clickOnDrug;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__drugPrep\"]/tbody/tr[4]/td[2]/div[1]")
	private WebElement clickOnStudyDrugChkbk;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__drugPrep\"]/tbody/tr[4]/td[2]/div[2]")
	private WebElement clickOnPrivateVialChkbk;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__drugPrep\"]/tbody/tr[4]/td[2]/div[3]")
	private WebElement clickOnSampleVialChkbk;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__drugPrep\"]/tbody/tr[4]/td[2]/div[4]")
	private WebElement clickOnNewVialOpendforProcedureChkbk;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[4]/td[2]/div")
	private WebElement clickOnDiagonsis;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[2]/td[4]/input")
	private WebElement fillTheLimbusValue;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[2]/td[5]/input")
	private WebElement fillTheNeedleValue;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[3]/td[5]/div")
	private WebElement clickOnAnethesia;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[4]/td[4]/div")
	private WebElement clickOnInjectionDrops;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[5]/td[4]/input")
	private WebElement clickOnInjectionIop;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[6]/td[4]/input")
	private WebElement clickOnTabIop;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[5]/td[5]/div[1]")
	private WebElement clickOnVACheckChkbk;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[5]/td[5]/div[2]")
	private WebElement clickOnFundsExamChkbk;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[5]/td[5]/div[3]")
	private WebElement clickOnACtabDoneChkbk;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__procedure\"]/tbody/tr[7]/td[4]/div")
	private WebElement clickOnSurgon;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder=\"Comments\" and @class=\"iviData__comments__comments\"]")
	private WebElement fillTheCommentsBox;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__comments__scheduleTable\"]/tbody/tr[1]/td[3]/div")
	private WebElement clickOnTimeFrame;

	@FindBy(how = How.XPATH, using = ".//table[@class=\"iviData__comments__scheduleTable\"]/tbody/tr[1]/td[5]/div")
	private WebElement clickOndrug1;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"popup__done idsButton--green\" and text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickOnTheClinicNote;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Avastin (Office) 2.5 mg / 0.1 ml - OD: Surgeon: ANKIT PANDEY\"]")
	private WebElement getTextFromCliniNote;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-headingPanel\"]/div/a")
	private WebElement clickOnCancelBtn;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[10]/div")
	private WebElement clickOnCodingTab;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr[1]/td[9]/div")
	private WebElement clickOnImpAndPlan;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-planWidget\"]/div/div[2]/div/div/div[1]")
	private WebElement getImpAndPlanMedicineText;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Patient Dashboard\"]")
	private WebElement clickOnPatientDashboard;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-summaries-button\"]/div[3]")
	private WebElement clickOnSummariesBtn;

	@FindBy(how = How.XPATH, using = ".//div[text()='No Charge']")
	private WebElement clickOnNoCharges;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-visitType-button\"]/div[3]")
	private WebElement clickOnVistType;

	@FindBy(how = How.XPATH, using = ".//a[text()='Submit & Close']")
	private WebElement clickOnsubmitandclose;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"ivi__eyeSection--right\"]/div[3]/div[2]/div/div[3]")
	private WebElement clickOnFlag;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"popup__done idsButton--green\" and text()=\"Confirm\"]")
	private WebElement clickOnConfirm;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"ivi__eyeSection--left\"]/div[3]/div[2]/table/tbody/tr[3]/td[2]/div")
	private WebElement clickOnLeftDoctorEye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div")
	private List<WebElement> selectSurgonOflefteye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"ivi__eyeSection--left\"]/div[3]/div[2]/table/tbody/tr[4]/td[2]/div")
	private WebElement clickOnLeftInjectionEye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div")
	private List<WebElement> selectLeftInjectionEye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"ivi__eyeSection--left\"]/div[3]/div[2]/table/tbody/tr[5]/td[2]/div")
	private WebElement clickOnLeftDiagonsisEye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div")
	private List<WebElement> selectLeftDiagonsisEye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"ivi__eyeSection--left\"]/div[3]/div[2]/table/tbody/tr[4]/td[5]/input")
	private WebElement clickOnLeftVisualActivityEye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"ivi__eyeSection--left\"]/div[3]/div[2]/table/tbody/tr[4]/td[6]/div")
	private WebElement clickOnLeftSCEye;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist__container\"]/div")
	private List<WebElement> selectLeftSCEye;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	@FindBy(xpath = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtoon;

	public PageIntravitrealInjection(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void checkIntravitrealInjection1(String fName, String lName, String provider, String injectionName,
			String InjectionText, Boolean signedToday, String lidScrub1, String lidScrub2, String tropicalDrops1,
			String tropicalDrops2, String drug, Boolean studtDrug, Boolean privateVial, Boolean sampleVial,
			Boolean NewVialOpenForProcedure, String diagnosis, String limbus, String needle, String anethesia,
			String injectiondrop, String injectionIOP, String tapIOP, Boolean VAchecks, Boolean fundsExam,
			Boolean tapDone, String surgon, String timeFrame, String drug1, String visitType, Boolean noCharges,
			Boolean flag, String sc, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem) throws Exception {

		Thread.sleep(5000);
		// clickOnJoinEncounter.click();
		// int select_RowFromOpenEncounter = driver
		// .findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		// System.out.println(select_RowFromOpenEncounter);
		// // if (select_RowFromOpenEncounter > 0) {
		//
		// // Select_Provider
		// Thread.sleep(4000);
		// List<WebElement> select_Provider = driver
		// .findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		// for (int i = 1; i <= select_Provider.size(); i++)
		// if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
		// select_Provider.get(i).click();
		// break;
		// }

		PageCloseEncounter openencounter = new PageCloseEncounter(wait, driver, builder);
		openencounter.openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, significantProblem);


		// click On Surgeri And Procedures
		Thread.sleep(5000);
		ensureElementTobeClickable(clickOnSurgeriAndProcedures);
		clickOnSurgeriAndProcedures.click();

		// Select_Injection
		Thread.sleep(3000);
		List<WebElement> select_Injection = driver
				.findElements(By.xpath(".//div[@class=\"popupContent\"]/div/div/div[2]/div"));
		for (int i = 1; i <= select_Injection.size(); i++)
			if (select_Injection.get(i).getText().equalsIgnoreCase(injectionName)) {
				select_Injection.get(i).click();
				break;
			}
		// click On Start NewEncounter
		Thread.sleep(3000);
		ensureElementTobeClickable(clickOnStartNewEncounter);
		clickOnStartNewEncounter.click();

		// fill The Injection Text
		Thread.sleep(3000);
		fillTheInjectionText.clear();
		fillTheInjectionText.sendKeys(InjectionText);

		// click On Preliminary
		Thread.sleep(3000);
		clickOnPreliminary.click();

		// click On Signed TodayRadio
		Thread.sleep(3000);
		if (!clickOnSignedTodayRadio.isSelected() && signedToday) {
			clickOnSignedTodayRadio.click();
		}

		// click On Scrub1
		Thread.sleep(3000);
		clickOnScrub1.click();

		// select_Scrub
		Thread.sleep(3000);
		List<WebElement> select_Scrub = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_Scrub.size(); i++)
			if (select_Scrub.get(i).getText().equalsIgnoreCase(lidScrub1)) {
				select_Scrub.get(i).click();
				break;
			}

		// click On Scrub2
		Thread.sleep(3000);
		ensureElementTobeClickable(clickOnScrub2);
		clickOnScrub2.click();

		// select_Scrub1
		Thread.sleep(3000);
		List<WebElement> select_Scrub1 = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_Scrub1.size(); i++)
			if (select_Scrub1.get(i).getText().equalsIgnoreCase(lidScrub2)) {
				select_Scrub1.get(i).click();
				break;
			}

		// click On Topicaldrops1
		Thread.sleep(3000);
		clickOnTopicaldrops1.click();

		// select_Drops1
		Thread.sleep(3000);
		List<WebElement> select_Drops1 = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_Drops1.size(); i++)
			if (select_Drops1.get(i).getText().equalsIgnoreCase(tropicalDrops1)) {
				select_Drops1.get(i).click();
				break;
			}

		// click On Topical drops2
		Thread.sleep(3000);
		clickOnTopicaldrops2.click();

		// select_Drops2
		Thread.sleep(3000);
		List<WebElement> select_Drops2 = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_Drops2.size(); i++)
			if (select_Drops2.get(i).getText().equalsIgnoreCase(tropicalDrops2)) {
				select_Drops2.get(i).click();
				break;
			}

		// click On Drug Prepration
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnDrugPrepration.click();

		// click On Drug
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnDrug.click();

		// select_Drug
		Thread.sleep(3000);
		List<WebElement> select_Drug = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_Drug.size(); i++)
			if (select_Drug.get(i).getText().equalsIgnoreCase(drug)) {
				select_Drug.get(i).click();
				break;
			}

		// click On Study Drug CheckBox
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnStudyDrugChkbk.isSelected() && studtDrug) {
			clickOnStudyDrugChkbk.click();
		}

		// click On Private Vial CheckBox
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnPrivateVialChkbk.isSelected() && sampleVial) {
			clickOnPrivateVialChkbk.click();
		}

		// click On Sample Vial CheckBox
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnSampleVialChkbk.isSelected() && sampleVial) {
			clickOnSampleVialChkbk.click();
		}

		// click On New Vial Opend for Procedure CheckBox
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnNewVialOpendforProcedureChkbk.isSelected() && NewVialOpenForProcedure) {
			clickOnNewVialOpendforProcedureChkbk.click();
		}

		// click On Procedure
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnProcedure.click();

		// click On Diagonsis
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnDiagonsis.click();

		// select_Diagnosis
		Thread.sleep(4000);

		int select_Diagnosis = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"))
				.size();
		System.out.println(select_Diagnosis);
		for (int i = 1; i <= select_Diagnosis; i++)
			if (driver.findElement(By.xpath(
					".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div["
							+ i + "]"))
					.getText().equalsIgnoreCase(diagnosis)) {
				driver.findElement(By.xpath(
						".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div["
								+ i + "]"))
						.click();
				break;
			}

		// fill The Limbus Value
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		fillTheLimbusValue.sendKeys(limbus);

		// fill The Needle Value
		Thread.sleep(3000);
		fillTheNeedleValue.sendKeys(needle);

		// click On Anethesia
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnAnethesia.click();

		// select_anethesia
		Thread.sleep(3000);
		List<WebElement> select_anethesia = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_anethesia.size(); i++)
			if (select_anethesia.get(i).getText().equalsIgnoreCase(anethesia)) {
				select_anethesia.get(i).click();
				break;
			}

		// click On Injection Drops
		Thread.sleep(3000);
		clickOnInjectionDrops.click();

		// select_InjectionDrop
		Thread.sleep(3000);
		List<WebElement> select_InjectionDrop = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_InjectionDrop.size(); i++)
			if (select_InjectionDrop.get(i).getText().equalsIgnoreCase(injectiondrop)) {
				select_InjectionDrop.get(i).click();
				break;
			}

		// click On Injection Iop
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnInjectionIop.sendKeys(injectionIOP);

		// click On Tab Iop
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnTabIop.sendKeys(tapIOP);

		// click On VA Check CheckBox
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnVACheckChkbk.isSelected() && VAchecks) {
			clickOnVACheckChkbk.click();
		}

		// click On Funds Exam CheckBox
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnFundsExamChkbk.isSelected() && fundsExam) {
			clickOnFundsExamChkbk.click();
		}

		// click On AC tab Done CheckBox
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnACtabDoneChkbk.isSelected() && tapDone) {
			clickOnACtabDoneChkbk.click();
		}

		// click On Surgon
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnSurgon.click();

		// select_Surgon
		Thread.sleep(3000);
		List<WebElement> select_Surgon = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_Surgon.size(); i++)
			if (select_Surgon.get(i).getText().equalsIgnoreCase(surgon)) {
				select_Surgon.get(i).click();
				break;
			}

		// click On Comments And Procedure
		Thread.sleep(3000);
		clickOnCommentsAndProcedure.click();

		// fill The Comments Box
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		fillTheCommentsBox.sendKeys(InjectionText);

		// click On Time Frame
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnTimeFrame.click();

		// select_TimeFrame
		Thread.sleep(3000);
		List<WebElement> select_TimeFrame = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_TimeFrame.size(); i++)
			if (select_TimeFrame.get(i).getText().equalsIgnoreCase(timeFrame)) {
				select_TimeFrame.get(i).click();
				break;
			}

		// click On drug1
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		clickOndrug1.click();

		// select_drug
		Thread.sleep(3000);

		List<WebElement> select_drug1 = driver.findElements(By.xpath(
				".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div"));
		for (int i = 1; i <= select_drug1.size(); i++)
			if (select_drug1.get(i).getText().equalsIgnoreCase(drug1)) {
				select_drug1.get(i).click();
				break;
			}

		// click On Done Btn
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnDoneBtn.click();

		// click On The Clinic Note
		Thread.sleep(3000);

//		wait = new WebDriverWait(driver, 20);
//		clickOnTheClinicNote.click();
//
//		// select_ClinicSurgon
//		Thread.sleep(10000);
//		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		List<WebElement> select_ClinicSurgon = driver
//				.findElements(By.xpath("//*[text()='Avastin (Office) 2.5 mg / 0.1 ml - OD: Surgeon: ANKIT PANDEY']"));
//		for (int i = 0; i <= select_ClinicSurgon.size(); i++)
//			if (select_ClinicSurgon.get(i).getText().endsWith(surgon)) {
//				Thread.sleep(5000);
//				clickOnCancelBtn.click();
//				break;
//			}

		// clickOnCodingTab
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickOnCodingTab.click();

		// select_CodingMedicine
		try {
			Thread.sleep(10000);
			List<WebElement> select_CodingMedicine = driver
					.findElements(By.xpath(".//div[@id=\"gwt-debug-procsAndTests-container\"]/div/span"));
			for (int i = 1; i <= select_CodingMedicine.size(); i++)

				if (select_CodingMedicine.get(i).getText().startsWith(drug)) {
					// Reporter.log(strMedicineText + " " + "name same as" + " " + drug);

					System.out.println("fail");
					break;
				}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		// New script
		// int
		// select_CodingMedicine=driver.findElements(By.xpath(".//div[@id=\"gwt-debug-procsAndTests-container\"]/div/span")).size();

		// click On ImpAndPlan
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickOnImpAndPlan.click();

		// select_ImpAndPlan Medicine Text
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, 20);

		try {
			List<WebElement> select_ImpAndPlanMedicineText = driver
					.findElements(By.xpath(".//div[@id=\"gwt-debug-planWidget\"]/div/div[2]/div/div/div[1]"));
			for (int i = 1; i <= select_ImpAndPlanMedicineText.size(); i++)
				if (select_ImpAndPlanMedicineText.get(i).getText().startsWith(drug1)) {
					System.out.println("Pass");
					break;
				}
		} catch (IndexOutOfBoundsException e)

		{
			e.printStackTrace();
		}

		// close Encounter
		openencounter.closeEncounter(visitType, noCharges);

		Thread.sleep(7000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		// click On Summaries Btn
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickOnSummariesBtn.click();

		// select_InjectionOption
		Thread.sleep(7000);
		List<WebElement> select_InjectionOption = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-summaries\"]/div[2]/div"));
		for (int i = 1; i < select_InjectionOption.size(); i++)
			if (select_InjectionOption.get(i).getText().equalsIgnoreCase(injectionName + "s")) {
				select_InjectionOption.get(i).click();
				break;
			}

		Thread.sleep(10000);

		WebElement frocelyClick = driver
				.findElement(By.xpath(".//div[@class=\"ivi__eyeSection--right\"]/div[2]/div/table/tbody/tr[1]/td[3]"));

		builder.moveToElement(frocelyClick).click().perform();

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		if (!clickOnFlag.isSelected() && flag) {
			clickOnFlag.click();
		}

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnConfirm.click();

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnLeftDoctorEye.click();

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		for (WebElement select_leftEyeDoctorOd : selectSurgonOflefteye) {
			if (select_leftEyeDoctorOd.getText().startsWith(surgon)) {
				select_leftEyeDoctorOd.click();
				break;
			}
		}
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnLeftInjectionEye.click();

		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		for (WebElement select_LeftInjectionEye : selectLeftInjectionEye) {
			if (select_LeftInjectionEye.getText().equalsIgnoreCase(drug)) {

				select_LeftInjectionEye.click();
				break;
			}
		}
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnLeftDiagonsisEye.click();

		Thread.sleep(2000);

		Thread.sleep(3000);
		for (WebElement select_LeftDiagonsisEye : selectLeftDiagonsisEye) {
			if (select_LeftDiagonsisEye.getText().equalsIgnoreCase(diagnosis)) {
				select_LeftDiagonsisEye.click();
				break;
			}
		}

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnLeftVisualActivityEye.sendKeys(limbus);

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnLeftSCEye.click();

		Thread.sleep(3000);
		for (WebElement select_LeftSCEye : selectLeftSCEye) {
			if (select_LeftSCEye.getText().equalsIgnoreCase(sc)) {
				select_LeftSCEye.click();
				break;
			}
		}

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		clickOnDoneBtn.click();

		// Thread.sleep(8000);
		// clickOnMyDashBoard.click();
	}

	public void ensureElementTobeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
