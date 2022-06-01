package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageOTCMedication {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	int count = 1;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-TabBarItem\"]/div/div[text()=\"OTC Medication\"]")
	private WebElement clickOnOTCMedication;

	@FindBy(how = How.CSS, using = "div#gwt-debug-selectCategory-list>div>div")
	private List<WebElement> selectOtcMedicationLiberary;

	@FindBy(how = How.CSS, using = "div#gwt-debug-selectItem-list>div>div")
	private List<WebElement> selectArtificialTears;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-libraryText")
	private List<WebElement> fillTextArea;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-saveAddAnother\"][1]/a[text()=\"Enter & Add Another\"]")
	private List<WebElement> clickOnAddAnother;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-done\"]/a[text()=\"Done\"]")
	private List<WebElement> clickOnDone;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-selectCategory-list\"]/div[1]/div[5]")
	private WebElement clickOnOtcMedicationLiberary;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-selectItem-list\"]/div[1]/div[2]")
	private WebElement clickOnArtificialTears;

	@FindBy(how = How.XPATH, using = ".//div[starts-with(text(),'ASPIRIN')]")
	private WebElement matchText;

	public PageOTCMedication(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageOTCMedication.this);
	}

	public void verifyOTCMedication(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges, String otcMedicationLiberary, String artificialsTears) throws Exception {

		String strotherProcedure = "Other Procedures";

		// Invoke method for openencounter
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		// select other procedure
		new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).selectSurgeryAndProcedures(strotherProcedure);

//		ensureElementToBeClickable(clickOnOTCMedication);
//		clickOnOTCMedication.click();
//
//		// call OTC medication method
//		performOTCMedicationOpertaion(otcMedicationLiberary, artificialsTears);
//
//		// match data
//		matchOTCMedication();
//
//		// close necounter
//		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	public void performOTCMedicationOpertaion(String otcMedicationLiberary, String artificialsTears) throws Exception {

		// System.out.println(otcMedicationLiberary);
		// ensureElementToBeClickable(selectOtcMedicationLiberary);
		// driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut,
		// TimeUnit.SECONDS);
		// try {
		// for (WebElement select_OtcMedicationLiberary : selectOtcMedicationLiberary) {
		// System.out.println(select_OtcMedicationLiberary.getText().startsWith(otcMedicationLiberary));
		// {
		// System.out.println(select_OtcMedicationLiberary.getText());
		// break;
		// }
		// }
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }

		ensureElementToBeClickable(clickOnOtcMedicationLiberary);
		clickOnOtcMedicationLiberary.click();

		// ensureElementToBeClickable(selectArtificialTears);
		// driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut,
		// TimeUnit.SECONDS);
		// try {
		// for (WebElement select_ArtificialTears : selectArtificialTears) {
		// if (select_ArtificialTears.getText().equalsIgnoreCase(artificialsTears)) {
		// select_ArtificialTears.click();
		// break;
		// }
		// }
		// } catch (Exception e) {
		// e.getMessage();
		// }
		try {
			ensureElementToBeClickable(clickOnArtificialTears);
			clickOnArtificialTears.click();
		} catch (Exception e) {
			ensureElementToBeClickable(clickOnArtificialTears);
			clickOnArtificialTears.click();
		}
		// ensureElementToBeClickable(fillTextArea);
		// fillTextArea.get(1).sendKeys("OTC Medication problem");

		switch (count) {
		case 1:
			clickOnAddAnother.get(1).click();
			--count;
			performOTCMedicationOpertaion(otcMedicationLiberary, artificialsTears);
			break;
		case 0:
			clickOnDone.get(1).click();
			break;
		default:
			System.out.println("Not match any value");

		}
	}

	private void matchOTCMedication() throws Exception {
		String str = "ASPIRIN";
		ensureElementToBeClickable(matchText);
		String getOTCmedication = matchText.getText();

		if (getOTCmedication.startsWith(str)) {
			Reporter.log(str + " " + "same as" + " " + getOTCmedication);
		}

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
