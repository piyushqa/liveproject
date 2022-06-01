package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePersonalTouch {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	
	@FindBy(how = How.CSS, using = "span#gwt-debug-pdPersonalTouchLink")
	private WebElement clickOnPersonalTouch;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-txtPersonalTouch")
	private WebElement fillTextOfPersonalTouch;

	@FindBy(how = How.CSS, using = "div#gwt-debug-Save>a")
	private WebElement clickOnDone;
	
	
	
	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 * @param clickOnDoctorNote
	 * @param fillTextOfDoctorNote
	 * @param clickOnDone
	 */
	public PagePersonalTouch(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PagePersonalTouch.this);
		
	}

	public void verifypersonalTouch() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		String strColorBeforeChange = clickOnPersonalTouch.getCssValue("color");
		System.out.println(strColorBeforeChange);

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnPersonalTouch);
		clickOnPersonalTouch.click();

		
		Thread.sleep(2000);
		ensureElementToBeClickable(fillTextOfPersonalTouch);
		fillTextOfPersonalTouch.clear();
		fillTextOfPersonalTouch.sendKeys("Verify personal touch");

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDone);
		clickOnDone.click();

		Thread.sleep(3000);
		String strColorAfterChange = clickOnPersonalTouch.getCssValue("color");
		System.out.println(strColorAfterChange);

		if (strColorBeforeChange.equalsIgnoreCase(strColorAfterChange)) {
			System.out.println("Matched");
		} else {
			System.out.println("Not Matched");
		}
	}

	// function use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}


}
