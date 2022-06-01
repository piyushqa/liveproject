package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//create Class
public class PgAdvanceSearch {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	@FindBy(how = How.CSS, using = "#gwt-debug-age-show>input")
	public WebElement chkGender;
	// @FindBy(how = How.CSS, using = "#gwt-debug-dlc-education")
	// public WebElement chkeducation;

	// create Constructor
	public PgAdvanceSearch(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void addSerachCriteria(String addCriteria, boolean gender, String relationsShip, String selectGender)
			throws InterruptedException {

		// click on addCriteriaButton
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/table/tbody/tr[3]/td[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#gwt-debug-addcriteria-button")).click();
		// Thread.sleep(2000);
		Thread.sleep(2000);
		java.util.List<WebElement> openCriteria = driver.findElements(By.cssSelector("#gwt-debug-addcriteria>div>div"));
		for (int i = 0; i < openCriteria.size(); i++)
			// System.out.println(openCounter.get(i).getText());
			if (openCriteria.get(i).getText().equalsIgnoreCase(addCriteria)) {
				openCriteria.get(i).click();
				break;
			}

		// check and unchecked the button

		boolean x = driver.findElement(By.cssSelector("#gwt-debug-mrn-show>input")).isSelected();
		if (x = true)

			driver.findElement(By.cssSelector("#gwt-debug-mrn-show>input")).click();

		boolean y = driver.findElement(By.cssSelector("#gwt-debug-age-show>input")).isSelected();
		if (y = true)

			driver.findElement(By.cssSelector("#gwt-debug-age-show>input")).click();

		boolean z = driver.findElement(By.cssSelector("#gwt-debug-age-show>input")).isSelected();
		if (z = true)

			driver.findElement(By.cssSelector("#gwt-debug-gender-operator>select")).click();

		Thread.sleep(2 * 1000);
		if (!chkGender.isSelected() && gender)
			chkGender.click();

		// select relationShip
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#gwt-debug-gender-operator>select")).click();
		Thread.sleep(3000);
		java.util.List<WebElement> openRelationship = driver
				.findElements(By.cssSelector("#gwt-debug-gender-operator>select>option"));
		for (int i = 0; i < openRelationship.size(); i++)
			// System.out.println(openRelationship.get(i).getText());
			if (openRelationship.get(i).getText().equalsIgnoreCase(relationsShip)) {
				openRelationship.get(i).click();
				// break;
			}

		// Select gender
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#gwt-debug-gender > select")).click();
		Thread.sleep(3000);
		java.util.List<WebElement> openGender = driver.findElements(By.cssSelector("#gwt-debug-gender>select>option"));
		for (int i = 0; i < openGender.size(); i++)
			// System.out.println(openRelationship.get(i).getText());
			if (openGender.get(i).getText().equalsIgnoreCase(selectGender)) {
				openGender.get(i).click();
				// break;
			}

		// click on addCriteriaButton
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#gwt-debug-addCriteria>a")).click();

		// click on searchButton
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#gwt-debug-search>a")).click();

		// count the male text
		Thread.sleep(3000);
		int count = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/table/tbody[1]/tr/td[3]/div"))
				.size();

		System.out.println(count);

		// match the male text
		Thread.sleep(5000);

		try {
			for (int i = 1; i <= count; i++)

			{
				if (driver
						.findElement(By
								.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/table/tbody[1]/tr[" + i + "]/td[3]/div"))
						.getText().equals(selectGender))
					;
				driver.close();
				// System.out.println(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}