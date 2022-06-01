package pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PgVisionSummary {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	PgPatientSearch patientsearch;
	@FindBy(how = How.CSS, using = "#gwt-debug-summaries-button")
	private WebElement summaryBtn;
	@FindBy(how = How.CSS, using = "#gwt-debug-summaries-container")
	private WebElement summaryContainer;

	public PgVisionSummary(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void addVisionSummary(String fName, String lName, String Vision, String date) throws InterruptedException {

		summaryBtn.click();
		Thread.sleep(2000);

		for (WebElement e : summaryContainer.findElements(By.xpath(".//*"))) {

			System.out.println(e.getText());

			if (e.getText().equalsIgnoreCase(Vision)) {
				e.click();
				break;

			}

		}

		int rowcount = driver.findElements(By.cssSelector(
				"#gwt-debug-firstSummaryWidget > div > div > div > div > div:nth-child(1) > div:nth-child(1)>div:nth-child(7)"))
				.size();
		Thread.sleep(2000);

		for (int i = 1; i <= rowcount; i++) {
			String s1 = driver
					.findElement(By.cssSelector(("#gwt-debug-firstSummaryWidget > div > div> div> div:nth-child(" + i
							+ ") > div:nth-child(1) > div> div:nth-child(7)")))
					.getText();

			printDate(s1, date);
		}
		int colCount = driver.findElements(By.cssSelector(
				"#gwt-debug-secondSummaryWidget > div > div > div> div> div:nth-child(1) > div> div:nth-child(7)"))
				.size();

		for (int i = 1; i <= colCount; i++) {
			String s1 = driver
					.findElement(By.cssSelector(("#gwt-debug-secondSummaryWidget > div > div > div> div:nth-child(" + i
							+ ") > div:nth-child(1) > div> div:nth-child(7)")))
					.getText();
			// System.out.println(s1);
			printDate(s1, date);
		}

	}

	public int printDate(String s1, String date) {
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");

		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format1.parse(s1);
			d2 = format1.parse(date);

			long diff = d2.getTime() - d1.getTime();
			
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");

			System.out.println(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (d1.getTime() > d2.getTime() ? -1 : 1);
	}

}
