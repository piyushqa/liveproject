package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMatchEncounterDate {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String getDateText = null;

	@FindBy(how = How.CSS, using = "div#gwt-debug-encounterStartDate")
	private WebElement getEncounterDate;

	@FindBy(how = How.CSS, using = "a#gwt-debug-returnToPatientDashboard")
	private WebElement clickOnPatintDashBoard;

	@FindBy(how = How.CSS, using = "div#gwt-debug-listOpenEncounterWidget>a")
	private WebElement clickOnJoinOpenEncounter;

	@FindBy(how = How.CSS, using = "table#gwt-debug-openEncounterTable>tbody>tr:nth-child(1)>td:nth-child(1)>div")
	private WebElement getDate;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageMatchEncounterDate(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageMatchEncounterDate.this);
	}

	public void verifyMatchEncounterDate(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, boolean significantProblem, String visitType,
			boolean noCharges) throws Exception {
		// TODO Auto-generated method stub
		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		Thread.sleep(5000);
		String strEncounterDate1 = getEncounterDate.getText();
		System.out.println("Current Encounter date1:" +" "+ strEncounterDate1);

		getEncounterDate();

		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
		
		Thread.sleep(4000);
		if (strEncounterDate1.equalsIgnoreCase(getDateText)) {
			System.out.println("Matched Date");
		} else {
			System.out.println("Not matched Date");
		}

	}

	public void getEncounterDate() throws Exception {

		Thread.sleep(3000);
		clickOnPatintDashBoard.click();

		Thread.sleep(4000);
		clickOnJoinOpenEncounter.click();

		Thread.sleep(3000);
		getDateText = getDate.getText();
		System.out.println("Encounter Date2:"+" "+ getDateText);

		Thread.sleep(3000);
		getDate.click();
	}
}
