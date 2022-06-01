package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pages.PgPatientSearch;
import pages.PgLanding;
import pages.PgCreatePatient;

public class PgPatientTag {

	WebDriver driver;
	WebElement element = null;;
	WebDriverWait wait;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;

	// declare Locater
	@FindBy(how = How.XPATH, using = ".//a[text()='Configuration']")
	private WebElement clickOnConfiguration;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/div")
	private WebElement clickOnMyPatienttags1;

	@FindBy(how = How.XPATH, using = ".//*[starts-with(text(),'Hello test')]")
	private WebElement clickOnMyPatienttags2;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[4]/div")
	private WebElement clickOnMyPatienttags3;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[5]/div")
	private WebElement clickOnMyPatienttags4;

	@FindBy(how = How.XPATH, using = ".//*[starts-with(text(),'Referral')]")
	private WebElement clickOnMyPatienttags5;

	@FindBy(how = How.XPATH, using = ".//a[text()='Done']")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//div[text()='Edit']")
	private WebElement clickOnEdit;

	@FindBy(how = How.XPATH, using = ".//a[@id='gwt-debug-']")
	private WebElement clickOnCloseButton;

	@FindBy(how = How.XPATH, using = ".//span[text()='REF']")
	private WebElement clickOnRefText;

	@FindBy(how = How.XPATH, using = ".//span[text()='asd']")
	private WebElement clickOnAsdText;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"popupContent\"]/div/div/div[2]/div/div/div/div[1]/table/tbody/tr[1]/td/textarea")
	private WebElement enterNameOfTag;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"popupContent\"]/div/div/div[2]/div/div/div/div[1]/table/tbody/tr[2]/td/textarea")
	private WebElement enterAbberviation;

	@FindBy(how = How.XPATH, using = "//a[text()=\"Create this Tag\"]")
	private WebElement clickOnCreateTag;

	public PgPatientTag(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void verifyPatientTag(String tag, boolean myPatientTag1, boolean myPatientTag2, boolean myPatientTag3,
			boolean myPatientTag4, boolean myPatientTag5, String patientName, String pateintTags1, String patientTags2,
			String fName, String lName) throws Exception {

		// click On Configuration
		Thread.sleep(3000);
		clickOnConfiguration.click();

		// select_list PatientTag
		Thread.sleep(3000);
		List<WebElement> select_listPatientTag = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
		for (int i = 1; i < select_listPatientTag.size(); i++) {
			if (select_listPatientTag.get(i).getText().equalsIgnoreCase(tag)) {
				select_listPatientTag.get(i).click();
			}
		}

		// click on Hello test (asd)
		boolean firstTag = true;

		Thread.sleep(3000);
		try {
			if (clickOnMyPatienttags2.isDisplayed())
				clickOnMyPatienttags2.click();
			
			Thread.sleep(2000);
			if (firstTag == !clickOnMyPatienttags2.isSelected() && myPatientTag2) {
				clickOnMyPatienttags2.click();
			}
		} catch (Exception e) {

			enterNameOfTag.sendKeys("Hello" + " " + "test");
			enterAbberviation.sendKeys("asd");
			clickOnCreateTag.click();
			Thread.sleep(3000);
			clickOnMyPatienttags2.click();
		}

		// click on Referral (REF)
		Thread.sleep(2000);
		clickOnMyPatienttags5.click();
		Thread.sleep(2000);
		if (firstTag == !clickOnMyPatienttags5.isSelected() && myPatientTag5) {
			clickOnMyPatienttags5.click();
		}

		// click On done
		Thread.sleep(2000);
		clickOnDone.click();

		Thread.sleep(5000);
		lclPgLanding = new PgLanding(driver);
		Thread.sleep(5000);
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		// click On Edit
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		ensureElementToBeClickable(clickOnEdit);
		clickOnEdit.click();

		Thread.sleep(2000);
		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div/div/div[2]/div[1]"));
		Thread.sleep(3000);

		Thread.sleep(2000);
		boolean value = element.isSelected();
		System.out.println(value);
		if (element.isSelected() && value) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		Thread.sleep(4000);
		WebElement element2 = driver
				.findElement(By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div/div/div[2]/div[6]"));
		boolean value1 = element2.isSelected();
		Thread.sleep(3000);
		System.out.println(value);
		if (element2.isSelected() && value1) {
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].click();", element2);
		}
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		// ensureElementToBeClickable(clickOnCloseButton);
		clickOnCloseButton.click();

		// compare string
		Thread.sleep(2000);
		String strText1 = clickOnRefText.getText();
		System.out.println(strText1);
		Thread.sleep(10000);
		String strText = clickOnAsdText.getText();
		System.out.println(strText);
		Thread.sleep(2000);
		String getTextdata1 = patientTags2.substring(0, 3);
		System.out.println(getTextdata1);
		Thread.sleep(2000);
		String getTextData2 = pateintTags1.substring(12, 15);
		System.out.println(getTextData2);
		Thread.sleep(2000);
		String concatText1 = getTextdata1 + " " + getTextData2;
		System.out.println(concatText1);
		Thread.sleep(2000);
		String concatText2 = strText1 + " " + strText;
		System.out.println(concatText2);
		Thread.sleep(2000);
		if (concatText2.equalsIgnoreCase(concatText1)) {
			Reporter.log(concatText1 + " " + "same as" + " " + concatText2 + " " + "data");
		} else

		{
			Reporter.log("fail");
		}
		// compare refferal
		// Thread.sleep(5000);
		// clickOnMyDashBoard.click();

	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
