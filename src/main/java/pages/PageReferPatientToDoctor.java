package pages;

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
import org.testng.Assert;
import org.testng.Reporter;

public class PageReferPatientToDoctor {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// define locater

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-TabBarItem\"]/div/div[text()=\"Refer Patient to Doctor\"]")
	private WebElement clickOnReferPatientToDocter;

	@FindBy(how = How.CSS, using = "table.list_table>tbody>tr>td>div")
	private List<WebElement> select_Provider;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-referralReason")
	private WebElement fillTextArea;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-referPatientToDoctor\"]/div[2]/div[3]/div/div[2]/div[1][text()=\"Letter: Transition to\"]")
	private WebElement clickTransitionTo;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-Done\" and text()=\"Done\"]")
	private List<WebElement> clickOnDone;

	@FindBy(how = How.CSS, using = "a#gwt-debug-thisClinicNoteLink.link")
	private WebElement clickOnClinicNote;

	public PageReferPatientToDoctor(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageReferPatientToDoctor.this);
	}

	public void verifyReferPatientToDoctor(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges, String timeFrame, Boolean transition, String providerName) throws Exception {

		String strotherProcedure = "Other Procedures";

		// invoke method for open encounter from pageCloseEncounter
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		// select other procedure
		new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).selectSurgeryAndProcedures(strotherProcedure);

		// invoke method referPatient To doctor
		performReferPatientToProvider(timeFrame, transition, providerName);

		// match sending data
		matchPatientReferData(providerName);

		// invoke method for close Encounter encounter from pageCloseEncounter
		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
	}

	// method define for perform Refer Patient To Provider
	public void performReferPatientToProvider(String timeFrame, Boolean transition, String providerName)
			throws Exception {

		Thread.sleep(2000);
		clickOnReferPatientToDocter.click();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		for (WebElement select_ProviderName : select_Provider) {
			if (select_ProviderName.getText().equalsIgnoreCase(providerName)) {
				select_ProviderName.click();
				break;

			}
		}

		Thread.sleep(3000);
		WebElement selectTimeFrame = driver.findElement(By.xpath(".//div[text()=" + "\"" + timeFrame + "\"" + "]"));
		selectTimeFrame.click();

		Thread.sleep(2000);
		fillTextArea.sendKeys("refer patient to doctor");

		Thread.sleep(2000);
		if (!clickTransitionTo.isSelected() && transition) {
			clickTransitionTo.click();

		}

		Thread.sleep(4000);
		clickOnDone.get(4).click();
	}

	// method define for match Patient Refer Data
	private void matchPatientReferData(String providerName) throws Exception {
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		builder.moveToElement(clickOnClinicNote).click().perform();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		WebElement selectDataFromClinicNote = driver
				.findElement(By.xpath(".//div[starts-with(text()," + "\"" + providerName + "\"" + ")]"));
		String strSelectDataFromClinicNote = selectDataFromClinicNote.getText();
		//System.out.println(selectDataFromClinicNote);

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		Assert.assertEquals(strSelectDataFromClinicNote, providerName);
		{
			Reporter.log(strSelectDataFromClinicNote + " " + "Same as" + " " + providerName);
		}

	}
}
