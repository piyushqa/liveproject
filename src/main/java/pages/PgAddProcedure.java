package pages;

import java.util.List;

//import java.util.List;

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





public class PgAddProcedure {


	WebDriver driver;

	WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch patientsearch;


	public PgAddProcedure(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);
	}

	public void addProcedure(String fName, String lName, String favoritesCategories, String scheduleSurgery,
			String whichEyeOrSide, String associateProcedureProblem, String selectValue,String procedureTime) throws Exception

	{
		System.out.println(favoritesCategories);
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("#gwt-debug-surgeryModule"));
		element.click();

		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id='gwt-debug-newSurgeryLink']/a"));
		element.click();
		Thread.sleep(2000);

		// By editBtn=By.xpath(".//*[text()='Edit']");
		// ensureElementToBeClickable(editBtn);
		// driver.findElement(editBtn).click();
		driver.findElement(By.xpath(".//*[text()='Edit']")).click();

		/*
		 * element=driver.findElement(By.linkText("Edit")); element.click();
		 */
		Thread.sleep(2000);
		By favCategoryRows = By.cssSelector("#gwt-debug-prior_eye-categories-list > div:nth-child(1) > div");
		List<WebElement> rows = driver.findElements(favCategoryRows);
		for (WebElement row : rows) {

			if (row.getText().equalsIgnoreCase(favoritesCategories)) {
				row.click();
				break;

			}
		}

		Thread.sleep(2000);
		By dropDowns1 = By.cssSelector("#gwt-debug-codes-list > div:nth-child(1) > div ");
		List<WebElement> row1 = driver.findElements(dropDowns1);
		for (WebElement row : row1) {
			row.getText().equalsIgnoreCase(scheduleSurgery);
			row.click();
			break;
		}

		Thread.sleep(2000);
		By dropDowns2 = By.cssSelector("#eyeSide-item-0");
		List<WebElement> row2 = driver.findElements(dropDowns2);
		for (WebElement row : row2) {
			row.getText().equalsIgnoreCase(whichEyeOrSide);
			row.click();
			break;
		}

		Thread.sleep(2000);
		By dropDowns3 = By.cssSelector("#surgeryProblemList-item-0");
		List<WebElement> row3 = driver.findElements(dropDowns3);
		for (WebElement row : row3) {
			row.getText().equalsIgnoreCase(associateProcedureProblem);
			row.click();
			break;
		}

		driver.findElement(By.cssSelector("#gwt-debug-done > a")).click();
		Thread.sleep(2000);
		//
		// By commaningType = By
		// .cssSelector("#content > div > div > div > div > div:nth-child(4) > div >
		// table > tbody > tr> td > div > div > div:nth-child(3) > div >
		// div:nth-child(2) > div > div > span:nth-child(3)>input");
		// ensureElementToBeClickable(commaningType);
		// element = driver.findElement(commaningType);
		// System.out.println(comanaging);

		// System.out.println(comanaging);
		// if (comanaging)
		// chkbxComanaging.click();
		Thread.sleep(2000);
		if (selectValue != null && !selectValue.equals("")) {
			By selectValueType = By.cssSelector("#gwt-debug-surgeryLocation");
			//ensureElementToBeClickable(selectValueType);
			driver.findElements(selectValueType).get(0).click();

			Select selectValueTypeSelector = new Select(driver.findElement(selectValueType));
			selectValueTypeSelector.selectByVisibleText(selectValue);

		}
		driver.findElement(By.id("gwt-debug-duration")).sendKeys(procedureTime);;

	}

	private void ensureElementToBeClickable(By element1) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
		wait.until(ExpectedConditions.elementToBeClickable(element1));
	}

}
