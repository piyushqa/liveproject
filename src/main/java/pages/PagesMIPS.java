package pages;

import static org.testng.Assert.fail;

import java.awt.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PagesMIPS {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement element;
	public static String firstWinHandle;
	public static String secondWinHandle;
	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-header/nav/div/div[5]/div/div[2]/div/div/div/div/div/div[1]/p-dropdown/div/label")
	private WebElement clickOnlocation;
	@FindBy(how = How.XPATH, using = ".//*[@class=\"ui-dropdown-items-wrapper\"]/ul/li[1]")
	private WebElement loctiontext;

	// @FindBy(xpath =
	// "/html/body/app-root/app-login/div[3]/div/div/div/div/form/div[4]/button")
	// private WebElement clickOnLoginBtn;
	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-header/nav/div/div[5]/div/div[1]/div/div/select")
	private WebElement adminOpertaions;

	@FindBy(xpath = ".//option[text()='Admin Operations']")
	private WebElement adminText;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[1]/a")
	private WebElement clickDashBoard;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/a")
	private WebElement clickDemographics;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/a/i")
	private WebElement clickCompliance;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[1]/a/span")
	private WebElement ComplianceIconClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-dashboard/div/div/div/div[1]/div/div[1]/h3")
	private WebElement matchCompliance;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[2]/a/span")
	private WebElement clickIreregularPatient;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement matchIreRegularPatient;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[3]/a/span")
	private WebElement clickCancellationRate;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li[1]/h3")
	private WebElement matchCancellationRate;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[4]/a/span")
	private WebElement clickNoShowAnalysis;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/a/i")
	private WebElement clickOnOrOps;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/div/ul/li[1]/a/span")
	private WebElement clickNoOr;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-dashboard/div/div/div/div[1]/div/div[1]/h3")
	private WebElement matchNoOrOps;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/div/ul/li[1]/a/span")
	private WebElement clickNoCompliaction;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement matchNoOrComplication;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/div/ul/li[3]/a/span")
	private WebElement clickNoReturn;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement matchNoOrReturn;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/div/ul/li[4]/a/span")
	private WebElement clickNoInjectionSummary;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement matchNoOrInjectionSummary;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/div/ul/li[5]/a/span")
	private WebElement clickNoIndexByCC;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement matchNoOrIndexByCC;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement matchNoShowAnalysis;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[1]/a/span")
	private WebElement demographicsIconClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-dashboard/div/div/div/div[1]/div/div[1]/h3")
	private WebElement matchDemogragraphics;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[2]/a/span")
	private WebElement clickPayerMixText;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li")
	private WebElement payerMiXMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[3]/a/span")
	private WebElement clickReffrealMgtText;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement refferalMgtMatch;

	@FindBy(css = "#main-menu > li:nth-child(2) > div > ul > li:nth-child(4) > a > span")
	private WebElement clickPatientMixText;

	@FindBy(xpath = ".//*[@class=\"innerpage-title clearfix ng-star-inserted\"]/div/ul/li/h3")
	private WebElement pateintMixMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[5]/a/i")
	private WebElement practicesElements;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[5]/div/ul/li[1]/a/span")
	private WebElement clickPraticeElementsText;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-dashboard/div/div/div/div[1]/div/div[1]/h3")
	private WebElement praticeElementsMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[5]/div/ul/li[2]/a/span")
	private WebElement diagonsisMixClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement diagonsisMisxMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[5]/div/ul/li[3]/a/span")
	private WebElement procedureMixClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement procedureMisxMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[6]/a/i")
	private WebElement iconGrowthClick;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[6]/div/ul/li[1]/a/span")
	private WebElement iconGrowthTrendClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-dashboard/div/div/div/div[1]/div/div[1]/h3")
	private WebElement iconGrowthTrendMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[6]/div/ul/li[2]/a/span")
	private WebElement YOYClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement YOYMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[6]/div/ul/li[3]/a/span")
	private WebElement QOQClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement QOQMatch;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[6]/div/ul/li[4]/a/span")
	private WebElement MOMClick;

	@FindBy(xpath = "/html/body/app-root/div/div[2]/app-drill-view/div[2]/div/div/div/div[1]/div/div[1]/ul/li/h3")
	private WebElement MOMMatch;

	@FindBy(xpath = "//*[@class=\"resp-select\"][1]/div/select")
	private WebElement DropDownClick;

	@FindBy(xpath = ".//*[@class=\"resp-select\"][1]/div/select/option[1]")
	private WebElement dailyDropDownClick;

	@FindBy(xpath = "//*[@class=\"resp-select\"][2]/div/select")
	private WebElement calendraDropDownClick;

	@FindBy(xpath = "//*[@class=\"resp-select\"][2]/div/select/option[1]")
	private WebElement calendraDateClick;

	@FindBy(xpath = ".//button[@type=\"reset\"]")
	private WebElement clickOnReset;

	@FindBy(xpath = "//*[@class=\"resp-select\"][1]/div/select/option[2]")
	private WebElement weeklyClick;

	@FindBy(xpath = "//*[@class=\"resp-select\"][1]/div/select/option[3]")
	private WebElement monthlyClick;

	@FindBy(xpath = "//*[@class=\"resp-select\"][1]/div/select/option[4]")
	private WebElement quartilyClick;

	@FindBy(xpath = ".//*[text()='Clinical Operations']")
	private WebElement clickOnClinicalOpertaions;

	@FindBy(xpath = ".//*[@class=\"mat-input-infix mat-form-field-infix\"]/input")
	private WebElement getSystemDate;

	 @FindBy(how = How.XPATH, using = "//*[@class=\"ti-settings\"]")
     private static WebElement Clickonsettingmenu;

     @FindBy(how = How.XPATH, using = "//*[@class=\"dropdown-menu settingNAV\"]/li[1]/a")
     private static WebElement ClickonUserMetricAssigment;

     @FindBy(how = How.XPATH, using = ".//span[text()='Multi User Settings']")
     private static WebElement Matchingusermetrictext;

     @FindBy(how = How.XPATH, using = "//*[@class=\"dropdown-menu settingNAV\"]/li[2]/a")
     private static WebElement ClickonKPIThresholdAssigment;
     @FindBy(how = How.XPATH, using = "//*[@class=\"dropdown-menu settingNAV\"]/li[3]/a")
     private static WebElement ClickonKAdminconfig;

     //testing
     @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div[2]/app-usersetting/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[5]/button/i")
     private static WebElement Clickonedit;
     @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div[2]/app-usersetting/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[4]/div/div/p-treetable/div/div/table/tbody[2]/div/td/a")
     private static WebElement Clickonicon;

     @FindBy(how=How.XPATH,using=".//div[@class=\"ui-treetable ui-widget\"]/div/table/tbody[2]/div/td/a")
     private  WebElement clickOnBilling;

     @FindBy(how=How.XPATH,using=".//*[@class=\"ui-treetable ui-widget\"]/div/table/tbody[2]/div[1]/td[1]/span")
      private WebElement clickOnChkbox;

     @FindBy(how=How.XPATH,using=".//tr[@class=\"ng-star-inserted\"][1]/td[4]/div/div/div/button[1]")
     private WebElement clickOnsave;


     public PagesMIPS(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void mipsDashboard() throws InterruptedException {
//		Thread.sleep(5000);
//		element = driver.findElement(By.xpath(".//a[text()='Analytics Dashboard']"));
//		element.click();
//		Thread.sleep(5000);
//		for (String handle : driver.getWindowHandles()) {
//
//			driver.switchTo().window(handle);
//		}
		try {

			driver.navigate().to("http://mcsa.eyecareleaders.com/#/drillview");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#username")).sendKeys("user3");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#password")).sendKeys("mycare@123");
			Thread.sleep(9000);
			driver.findElement(By.xpath("/html/body/app-root/app-login/div[3]/div/div/div/div/form/div[4]/button"))
					.click();

			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].click();", clickOnLoginBtn);
			// driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		} catch (Exception e) {

			System.out.println("invalid login credentials");
			// Reporter.log("login credentials fails");
		}

		Thread.sleep(15000);
		wait = new WebDriverWait(driver, 20);
		// ensureElementToBeClickable(loctiontext);
		String str = clickOnlocation.getText();
		System.out.println(str);
		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickOnlocation);
		// clickOnlocation.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", loctiontext);

		//loctiontext.click();

//		Thread.sleep(15000);
//		driver.findElement(By.xpath(".//label[text()='Dimension value']")).click();
//		Thread.sleep(5000);
//		String strText = "EyeCare Leaders";
//		String text1 = driver.findElement(By.xpath(".//label[text()='EyeCare Leaders']")).getText();
//		if (text1.equals(strText)) {
//			System.out.println("Pass");
//		}
		// Thread.sleep(12000);
		// wait = new WebDriverWait(driver, 20);
		// loctiontext.click();
		//
		// Thread.sleep(5000);
		// wait = new WebDriverWait(driver, 20);
		// driver.findElement(By.xpath(
		// "/html/body/app-root/app-header/nav/div/div[5]/div/div[2]/div/div/div/div/div/div[1]/p-dropdown/div/div[4]/div/ul/li[2]/span"))
		// .click();
		//
		// Thread.sleep(5000);
		// // wait = new WebDriverWait(driver, 20);
		// driver.findElement(By.xpath(".//label[text()='Dimension value']")).click();
		// String deminsionValueText = "Alexis Jones";
		//
		// int length = driver.findElements(By.xpath(
		// "/html/body/app-root/app-header/nav/div/div[5]/div/div[2]/div/div/div/div/div/div[2]/p-multiselect/div/div[4]/div[2]/ul/li/label"))
		// .size();
		// System.out.println(length);
		// for (int i = 1; i <= length; i++) {
		// if (driver.findElement(By.xpath(
		// "/html/body/app-root/app-header/nav/div/div[5]/div/div[2]/div/div/div/div/div/div[2]/p-multiselect/div/div[4]/div[2]/ul/li["
		// + i + "]/label"))
		// .getText().equalsIgnoreCase(deminsionValueText))
		// ;
		// {
		// System.out.println("Pass");
		// }
		// break;
		// }
		//
		// Thread.sleep(5000);
		// wait = new WebDriverWait(driver, 20);
		// adminOpertaions.click();
		// Thread.sleep(5000);
		// if (adminText.isDisplayed()) {
		// adminText.click();
		// }
		// Thread.sleep(5000);
		// clickDashBoard.click();
		// if
		// (driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[1]/div/ul/li/a/span")).isDisplayed())
		// {
		// System.out.println("DashBoard Show");
		// }
		// Thread.sleep(5000);
		// clickDemographics.click();
		// String demographicsText = demographicsIconClick.getText();
		// demographicsIconClick.click();
		// String demographicsDashBoardText = matchDemogragraphics.getText();
		// if (demographicsText.equals(demographicsDashBoardText)) {
		// System.out.println("Demographics Pass");
		// }
		// Thread.sleep(5000);
		// clickDemographics.click();
		//
		// String payerMixText = clickPayerMixText.getText();
		// clickPayerMixText.click();
		// String payerMixDashBoardText = payerMiXMatch.getText();
		// if (payerMixText.equalsIgnoreCase(payerMixDashBoardText)) {
		// System.out.println("Payer mix text pass");
		// }
		//
		// Thread.sleep(5000);
		// clickDemographics.click();
		// String referralMgtText = clickReffrealMgtText.getText();
		// clickReffrealMgtText.click();
		// String refferalDashBoardText = refferalMgtMatch.getText();
		// if (referralMgtText.equalsIgnoreCase(refferalDashBoardText)) {
		// System.out.println("refferal mgt text pass");
		// }
		//
		// Thread.sleep(5000);
		// clickDemographics.click();
		//
		// Thread.sleep(3000);
		// String patientMixText = clickPatientMixText.getText();
		// System.out.println(patientMixText);
		// clickPatientMixText.click();
		// Thread.sleep(3000);
		// String patientMixDashBoardText = pateintMixMatch.getText();
		// System.out.println(patientMixDashBoardText);
		// if (patientMixText.equalsIgnoreCase(patientMixDashBoardText)) {
		// System.out.println("Patient Mix text pass");
		// } else {
		// System.out.println("fail");
		// }
		//
		// Thread.sleep(5000);
		// practicesElements.click();
		// Thread.sleep(3000);
		// String praticeElementsText = clickPraticeElementsText.getText();
		//
		// clickPraticeElementsText.click();
		// Thread.sleep(3000);
		// String praticeElementsDashboardText = praticeElementsMatch.getText();
		//
		// if (praticeElementsText.equalsIgnoreCase(praticeElementsDashboardText)) {
		// System.out.println("Practice Elements text pass");
		// } else {
		// System.out.println("fail");
		// }
		// Thread.sleep(5000);
		// practicesElements.click();
		// Thread.sleep(3000);
		// String diagonsisMixText = diagonsisMixClick.getText();
		//
		// diagonsisMixClick.click();
		// Thread.sleep(3000);
		// String diagonsisMixDashboardText = diagonsisMisxMatch.getText();
		//
		// if (diagonsisMixText.equalsIgnoreCase(diagonsisMixDashboardText)) {
		// System.out.println("diagonsis text pass");
		// } else {
		// System.out.println("fail");
		// }
		// Thread.sleep(5000);
		// practicesElements.click();
		// Thread.sleep(3000);
		// String procedureMixText = procedureMixClick.getText();
		//
		// procedureMixClick.click();
		// Thread.sleep(3000);
		// String procedureMixDashboardText = procedureMisxMatch.getText();
		//
		// if (procedureMixText.equalsIgnoreCase(procedureMixDashboardText)) {
		// System.out.println("procedure text pass");
		// } else {
		// System.out.println("fail");
		// }
		// Thread.sleep(5000);
		// iconGrowthClick.click();
		// Thread.sleep(3000);
		// String iconGrowthTrendText = iconGrowthTrendClick.getText();
		//
		// iconGrowthTrendClick.click();
		// Thread.sleep(3000);
		// String iconGrowthTrendDashboardText = iconGrowthTrendMatch.getText();
		//
		// if (iconGrowthTrendText.equalsIgnoreCase(iconGrowthTrendDashboardText)) {
		// System.out.println("iconGrowth text pass");
		// } else {
		// System.out.println("fail");
		// }
		// Thread.sleep(5000);
		// iconGrowthClick.click();
		// Thread.sleep(3000);
		// String yoyText = YOYClick.getText();
		//
		// YOYClick.click();
		// Thread.sleep(3000);
		// String yoyDashboardText = YOYMatch.getText();
		//
		// if (yoyText.equalsIgnoreCase(yoyDashboardText)) {
		// System.out.println("YOY text pass");
		// } else {
		// System.out.println("fail");
		// }
		// Thread.sleep(5000);
		// iconGrowthClick.click();
		// Thread.sleep(3000);
		// String qoqText = QOQClick.getText();
		//
		// QOQClick.click();
		// Thread.sleep(3000);
		// String qoqDashboardText = QOQMatch.getText();
		//
		// if (qoqText.equalsIgnoreCase(qoqDashboardText)) {
		// System.out.println("QOQ text pass");
		// } else {
		// System.out.println("fail");
		// }
		//
		// Thread.sleep(5000);
		// iconGrowthClick.click();
		// Thread.sleep(3000);
		// String momText = MOMClick.getText();
		//
		// QOQClick.click();
		// Thread.sleep(3000);
		// String momDashboardText = MOMMatch.getText();
		//
		// if (momText.equalsIgnoreCase(momDashboardText)) {
		// System.out.println("MOM text pass");
		// } else {
		// System.out.println("fail");
		// }
		// Thread.sleep(50000);
		// DropDownClick.click();
		// Thread.sleep(5000);
		// dailyDropDownClick.click();
		//
		// Thread.sleep(5000);
		// calendraDropDownClick.click();
		// Thread.sleep(5000);
		// calendraDateClick.click();
		//
		// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Date date = new Date();
		// String getCurrentDate = dateFormat.format(date);
		// System.out.println(getCurrentDate);
		// String getdatetext = getSystemDate.getText();
		// System.out.println(getdatetext);
		// if (getCurrentDate.equals(getdatetext)) {
		// System.out.println("case Pass");
		// } else {
		// System.out.println("Fail");
		// }

		// Thread.sleep(5000);
		// clickOnReset.click();
		//
		// Thread.sleep(5000);
		// DropDownClick.click();
		//
		// Thread.sleep(2000);
		// weeklyClick.click();
		//
		// Thread.sleep(5000);
		// calendraDropDownClick.click();
		// Thread.sleep(5000);
		// calendraDateClick.click();
		//
		// Thread.sleep(5000);
		// clickOnReset.click();
		//
		// Thread.sleep(5000);
		// DropDownClick.click();
		// Thread.sleep(2000);
		// monthlyClick.click();
		//
		// Thread.sleep(5000);
		// calendraDropDownClick.click();
		// Thread.sleep(5000);
		// calendraDateClick.click();
		//
		// Thread.sleep(5000);
		// clickOnReset.click();
		//
		// Thread.sleep(5000);
		// DropDownClick.click();
		// Thread.sleep(2000);
		// quartilyClick.click();
		//
		// Thread.sleep(5000);
		// calendraDropDownClick.click();
		// Thread.sleep(5000);
		// calendraDateClick.click();
		//
		// Thread.sleep(5000);
		// clickOnReset.click();
		//
		// Thread.sleep(25000);
		// adminOpertaions.click();
		// Thread.sleep(10000);
		// if (clickOnClinicalOpertaions.isDisplayed()) {
		// clickOnClinicalOpertaions.click();
		// }
		//
		// Thread.sleep(5000);
		// clickDashBoard.click();
		// if
		// (driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[1]/div/ul")).isDisplayed())
		// {
		// System.out.println("DashBoard Show");
		// }
		// Thread.sleep(5000);
		// clickCompliance.click();
		// String complianceText = ComplianceIconClick.getText();
		// ComplianceIconClick.click();
		// String compliancesDashBoardText = matchCompliance.getText();
		// if (complianceText.equals(compliancesDashBoardText)) {
		// System.out.println("Compliance Pass");
		// }
		//
		// Thread.sleep(5000);
		// clickCompliance.click();
		//
		// String irregularpatientText = clickIreregularPatient.getText();
		// clickIreregularPatient.click();
		// String irregularpatientDashBoardText = matchIreRegularPatient.getText();
		// if (irregularpatientText.equalsIgnoreCase(irregularpatientDashBoardText)) {
		// System.out.println("IreregularPatient Pass");
		// }
		// Thread.sleep(5000);
		// clickCompliance.click();
		// String cancellationRateText = clickCancellationRate.getText();
		// clickCancellationRate.click();
		// String cancellationRateDashBoardText = matchCancellationRate.getText();
		// if (cancellationRateText.equalsIgnoreCase(cancellationRateDashBoardText)) {
		// System.out.println("Cancellation Pass");
		// }
		//
		// Thread.sleep(5000);
		// clickCompliance.click();
		// String noShowanalysisText = clickNoShowAnalysis.getText();
		// clickNoShowAnalysis.click();
		// String noShowanalysisDashBoardText = matchNoShowAnalysis.getText();
		// if (noShowanalysisText.equalsIgnoreCase(noShowanalysisDashBoardText)) {
		// System.out.println("No Analysis Pass");
		// }
		//
		// Thread.sleep(5000);
		// clickOnOrOps.click();
		// String OROPSText = clickNoOr.getText();
		// clickNoOr.click();
		// String OROPSDashBoardText = matchNoOrOps.getText();
		// if (OROPSText.equalsIgnoreCase(OROPSDashBoardText)) {
		// System.out.println("OR Ops Pass");
		// }
		//
		// Thread.sleep(5000);
		// clickOnOrOps.click();
		// String ORComplicationText = clickNoCompliaction.getText();
		// clickNoCompliaction.click();
		// String ORComplicationDashBoardText = matchNoOrComplication.getText();
		// if (ORComplicationText.equalsIgnoreCase(ORComplicationDashBoardText)) {
		// System.out.println("OR Complication Pass");
		// }
		//
		// Thread.sleep(5000);
		// clickOnOrOps.click();
		// String ORReturnText = clickNoReturn.getText();
		// clickNoReturn.click();
		// String ORReturnDashBoardText = matchNoOrReturn.getText();
		// if (ORReturnText.equalsIgnoreCase(ORReturnDashBoardText)) {
		// System.out.println("OR Return Pass");
		// }
		// Thread.sleep(5000);
		// clickOnOrOps.click();
		// String ORInjectionSummaryText = clickNoInjectionSummary.getText();
		// clickNoInjectionSummary.click();
		// String ORInjectionSummaryDashBoardText = matchNoOrInjectionSummary.getText();
		// if (ORInjectionSummaryText.equalsIgnoreCase(ORInjectionSummaryDashBoardText))
		// {
		// System.out.println("OR Injection Summary Pass");
		// }
		//
		// Thread.sleep(5000);
		// clickOnOrOps.click();
		// String ORIndexByCcText = clickNoIndexByCC.getText();
		// clickNoIndexByCC.click();
		// String ORIndexByCcDashBoardText = matchNoOrIndexByCC.getText();
		// if (ORIndexByCcText.equalsIgnoreCase(ORIndexByCcDashBoardText)) {
		// System.out.println("OR Index By CC Pass");
		// }

		 Thread.sleep(25000);
         Clickonsettingmenu.click();
         Thread.sleep(5000);
         String ClickonUserMetrictext1=ClickonUserMetricAssigment.getText();
         ClickonUserMetricAssigment.click();

         //System.out.println(ClickonUserMetrictext1);
         String MultiUserSettings=Matchingusermetrictext.getText();
         //System.out.println(MultiUserSettings);

         //Matchingusermetrictext.click();
         String text = "Multi User Settings";
         if(MultiUserSettings.equalsIgnoreCase(text)){
                         System.out.println("User Metric Assigment Pass");
                         //testing
                         Thread.sleep(5000);
                         Clickonedit.click();
                         int length;
                         length=driver.findElements(By.xpath("/html/body/app-root/div/div[2]/app-usersetting/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[4]/div/div/p-treetable/div/div/table/tbody")).size();
                         //for (int p = 1; p <= length; p++) {
                         //driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-usersetting/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[4]/div/div/p-treetable/div/div/table/tbody[p]")).getSize();

                                         {

                                                         System.out.println(length);
                                         }
                                         Clickonicon.click();
                         }
         Thread.sleep(5000);
         Clickonsettingmenu.click();
                         //testing
//                         Thread.sleep(5000);
//                         ClickonKPIThresholdAssigment.click();
//                         Thread.sleep(5000);
//                         ClickonKAdminconfig.click();

         Thread.sleep(5000);
         Clickonicon.click();

         Thread.sleep(5000);
         clickOnBilling.click();

         Thread.sleep(5000);


        	 clickOnChkbox.click();

        	 Thread.sleep(5000);
        	 clickOnsave.click();

//        	   Thread.sleep(5000);
//               Clickonicon.click();


	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
