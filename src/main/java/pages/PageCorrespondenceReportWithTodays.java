package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCorrespondenceReportWithTodays {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	// Define Locater
	@FindBy(xpath = "//*[@id=\"gwt-debug-correspondence\"]/a")
	private WebElement clickOnCorrespondence;

	@FindBy(xpath = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div[2]/div[2]/div/div[3]")
	private WebElement clickOnCorrespondenceType;

	@FindBy(xpath = ".//textarea[@id=\"gwt-debug-txt-plan\" and @placeholder=\"Enter text here...\"]")
	private WebElement fillComment;

	@FindBy(xpath = ".//*[@id=\"gwt-debug-correspondencePopupFooter\"]/div[2]/div/div/a[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-priorClinicVisits-container\"]")
	private WebElement reportContainer;

	@FindBy(how = How.XPATH, using = ".//a[@class=\"gwt-Anchor blue_text_blk display_block align_left\" and text()=\"Corresp.\"]")
	private WebElement clickOnCorresp;


	//constructor
	public PageCorrespondenceReportWithTodays(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void verifyCorrespondenceReportWithTodays(String corrospondenceType, String text, String matchAge,
			String dob, String view) throws Exception {
		//click On crrospondence
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnCorrespondence);
		clickOnCorrespondence.click();

		//click On CorrespondenceType
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnCorrespondenceType);
		clickOnCorrespondenceType.click();

		//select_CorrespondenceType
		Thread.sleep(4000);
		List<WebElement> select_CorrespondenceType = driver
				.findElements(By.xpath("//*[@class=\"gwt-PopupPanel\"]/div/div/div/div[2]/div"));
		for (int i = 1; i <= select_CorrespondenceType.size(); i++)
			if (select_CorrespondenceType.get(i).getText().equalsIgnoreCase(corrospondenceType)) {
				select_CorrespondenceType.get(i).click();
				break;
			}
		//fillComment
		Thread.sleep(1000);
		fillComment.sendKeys(text);

		//click On DoneBtn
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();

	//Differnce between current date and birth date
		Thread.sleep(5000);
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/DD/YYYY");
		try {
			LocalDate endofCentury = LocalDate.of(1994, 04, 04);
			LocalDate now = LocalDate.now();
			System.out.println(now);
			Period diff = Period.between(endofCentury, now);
			int Year = diff.getYears();
			System.out.println("Year" + Year);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//get report link
		Thread.sleep(5000);
		for (WebElement e : reportContainer.findElements(By.xpath(".//*"))) {
			//System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(view)) {
				e.click();
				break;
			}
		}

		//click On Corresp
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnCorresp);
		clickOnCorresp.click();

		//switch to window handle
		for(String handle:driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
	}

	//function to check visibility , element time out and clickable
	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
