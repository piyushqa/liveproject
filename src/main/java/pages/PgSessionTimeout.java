package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PgSessionTimeout {

	private WebDriver driver;
	private WebDriverWait wait;
	// private Actions action;

	public PgSessionTimeout(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		// this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void sessionTimeOut(String inactivityPeriod) throws InterruptedException {
		By sessionTime = By.cssSelector(
				"#content > div > div > div:nth-child(4) > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > a");
		// ensureElementToBeClickable(sessionTime);
		driver.findElement(sessionTime).click();

		Thread.sleep(2000);
		WebElement period = driver.findElement(By.cssSelector("#gwt-debug-sessionInactivityPeriod"));
		// ensureElementToBeClickable(period);
		period.clear();
		period.sendKeys(inactivityPeriod);

		Thread.sleep(1000);
		By saveBtn = By.cssSelector("#gwt-debug-saveAnchor");
		// ensureElementToBeClickable(saveBtn);
		driver.findElement(saveBtn).click();

		Thread.sleep(2 * 1000);


		String value1 = driver.findElement(By.cssSelector("#gwt-debug-sessionInactivityPeriod")).getAttribute("value");
		System.out.println(value1);
		boolean status = driver.findElement(By.cssSelector("#gwt-debug-sessionInactivityPeriod")).isDisplayed();
		boolean result = driver.findElement(By.id("gwt-debug-sessionInactivityPeriod")).isEnabled();

		System.out.println(status);
		System.out.println(result);

	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
