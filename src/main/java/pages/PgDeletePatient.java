package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PgDeletePatient {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch patientsearch;

	public PgDeletePatient(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void deltePatient(String fName, String lName, String date, String startTime,
			String Provider, String Delete) throws Exception {
System.out.println(startTime);
System.out.println(date);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#gwt-debug-listOpenEncounterWidget > a")).click();

		Thread.sleep(2 * 1000);
		int rowCount = driver.findElements(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(rowCount);

		int columnCount = driver.findElements(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr[1]/*"))
				.size();
		System.out.println(columnCount);
		Thread.sleep(2* 1000);
        boolean check = false;

		for (int i = 1; i <= rowCount; i++) {
			if(driver.findElement(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr[" + i + "]/td[1]"))
					.getText().equals(date)
					&& driver
							.findElement(
									By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr[" + i + "]/td[2]"))
							.getText().equals(startTime))

							{
Thread.sleep(2*1000);
				driver
				.findElement(
						By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr[" + i + "]/td[6]")).click();

				check = true;
				Reporter.log("Task with Topic " + Delete + " Found!");
				Thread.sleep(2000);
				WebElement element=driver.findElement(By.cssSelector("#gwt-debug-ok"));
				element.click();

				break;
			}

////
////			System.out.println(driver.findElement(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr[" + i + "]/td[1]"))
////				.getText());
////
////			System.out.println(driver
////							.findElement(
////									By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr[" + i + "]/td[2]"))
////							.getText());
//
		}
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
