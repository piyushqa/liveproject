package pages;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PageOpthalmoscopyReports {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// declare Locater
	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget>a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-integriView\"]")
	private WebElement clickOnIntegriView;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Create New Drawing\"]")
	private WebElement clickIntegrityDrawing;

	// @FindBy(how = How.XPATH, using = ".//div[text()=\"Optic Disc (9)\"]")
	// private WebElement clickOnOpticDisc;

	@FindBy(how = How.XPATH, using = ".//div[@title=\"Optic Nerve - both - OU\"]/div[3]/img[@src=\"/SledgeHammer/image/getImageFromS3/DrawingTemplates/All/optic_nerve_both-thumb\"]")
	private WebElement clickOnImage;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"View Selected Images\"]")
	private WebElement clickOnViewSelectedImage;

	@FindBy(how = How.XPATH, using = ".//span[text()='Paint']")
	private WebElement clickOnpaint;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[2]/div/div[4]/div[2]/div/div/div[1]/canvas[3]")
	private WebElement canvasElement;

	@FindBy(how = How.XPATH, using = ".//span[text()=\"Stamp\"]")
	private WebElement clickOnstamp;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"GKBMPONCI-\"]/div[5]//img[@src=\"https://sprint-qa.integritylogin.com/static/sledgehammer/gwt/integriview/clear.cache.gif\"]")
	private WebElement pickImageFromSourceLocater;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Move\"]")
	private WebElement clickOnMove;

	@FindBy(how = How.XPATH, using = ".//*[@class=\"idsTextArea__text-area\"]")
	private WebElement clickToFillTheText;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Close IntegriView\"]")
	private WebElement clickOnCloseIntegriview;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickOnTheClinicNote;

	@FindBy(how = How.XPATH, using = ".//span[text()=\"Optic Nerve - both\"]")
	private WebElement getIntergiviewOpticNerve_both;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Optic Nerve - both\"][1]")
	private WebElement getClinicNoteOpticNerve_both;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-headingPanel\"]/div/a")
	private WebElement clickOnCancelBtn;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Download\"]")
	private WebElement clickOnDownload;

	@FindBy(how = How.CSS, using = "div.popupContent>div>div>img")
	private WebElement clickOnCancelButtonOfDownloadPage;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	public PageOpthalmoscopyReports(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void createOpthamoscopyReports(String provider, String opthamosCopyReports, String savedDocuments,
			String downloadpath, String filename) throws Exception {

		// // click On OpenEncounter
		// Thread.sleep(6000);
		// clickOnOpenEncounter.click();
		//
		// // Select_Provider
		// Thread.sleep(6000);
		// List<WebElement> select_Provider = driver
		// .findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		// for (int i = 1; i <= select_Provider.size(); i++)
		// if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
		// select_Provider.get(i).click();
		// break;
		// }

		Thread.sleep(8000);
		clickOnOpenEncounter.click();

		// if (select_RowFromOpenEncounter > 0) {

		// Select_Provider
		Thread.sleep(7000);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;
			}

		performIntegriviewOperation(opthamosCopyReports);

		// click On DocumentCenter
		Thread.sleep(5000);
		ensureElementToBeclickable(clickOnDocumentCenter);
		clickOnDocumentCenter.click();

		// select_Documents
		List<WebElement> select_Documents = driver
				.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase(savedDocuments)) {
				select_Documents.get(i).click();
				break;
			}

		// click On Download
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickOnDownload.click();

		// check file exist are not if exist then delete
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		isFileDownloaded(downloadpath, filename);

		Thread.sleep(6000);
		ensureElementToBeclickable(clickOnCancelButtonOfDownloadPage);
		clickOnCancelButtonOfDownloadPage.click();

		// Thread.sleep(6000);
		// clickOnMyDashBoard.click();

	}

	public void performIntegriviewOperation(String opthamosCopyReports) throws Exception {
		// click On Integreiview
		Thread.sleep(7000);
		ensureElementToBeclickable(clickOnIntegriView);
		clickOnIntegriView.click();

		// click on IntegrityDrawing
		Thread.sleep(7000);
		ensureElementToBeclickable(clickIntegrityDrawing);
		clickIntegrityDrawing.click();

		// click on OpticDisc
		Thread.sleep(7000);
		wait = new WebDriverWait(driver, 20);
		By clickOnOpticDisk = By.xpath(".//div[starts-with(text(),\"Optic Disc\")]");
		driver.findElements(clickOnOpticDisk).get(1).click();

		// click On Image
		Thread.sleep(5000);
		ensureElementToBeclickable(clickOnImage);
		clickOnImage.click();

		// click On View Selected Image
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		clickOnViewSelectedImage.click();

		// getText IntergiviewOpticNerve_both
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 20);
		String strIntergiviewOpticNerve_both = getIntergiviewOpticNerve_both.getText();

		// click on Paint
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		clickOnpaint.click();

		// draw an image
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		builder = new Actions(driver);
		builder.clickAndHold(canvasElement).moveByOffset(10, 135).moveByOffset(135, 127).moveByOffset(-15, -50)
				.moveByOffset(-60, -10).moveByOffset(130, 2).moveByOffset(27, 554).moveByOffset(-15, -50).release()
				.perform();

		// click on stamp
		// Thread.sleep(5000);
		// wait = new WebDriverWait(driver, 20);
		// clickOnstamp.click();
		//
		// drag and drop the stamp
		// Thread.sleep(5000);
		// wait = new WebDriverWait(driver, 20);
		// builder.dragAndDrop(pickImageFromSourceLocater,
		// canvasElement).build().perform();

		// // click on move
		Thread.sleep(5000);
		ensureElementToBeclickable(clickOnMove);
		clickOnMove.click();

		// move the image
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		builder.dragAndDropBy(canvasElement, 20, 70).build().perform();

		// click on save btn
		Thread.sleep(5000);
		By clickSaveBtn = By.xpath(".//a[text()=\"Save\"]");
		driver.findElements(clickSaveBtn).get(0).click();

		// click To Fill The Text
		Thread.sleep(5000);
		clickToFillTheText.sendKeys(opthamosCopyReports);

		// click On DoneBtn
		Thread.sleep(5000);
		ensureElementToBeclickable(clickOnDoneBtn);
		clickOnDoneBtn.click();

		// click On Close Integriview
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickOnCloseIntegriview);

		// click On The ClinicNote
		// Thread.sleep(7000);
		// wait = new WebDriverWait(driver, 20);
		// clickOnTheClinicNote.click();
		//
		// // getText getClinicNoteOpticNerve_both and match
		// Thread.sleep(10000);
		// wait = new WebDriverWait(driver, 20);
		// String strgetClinicNoteOpticNerve_both =
		// getClinicNoteOpticNerve_both.getText();
		//
		// if
		// (strIntergiviewOpticNerve_both.equalsIgnoreCase(strgetClinicNoteOpticNerve_both))
		// {
		// Reporter.log(strgetClinicNoteOpticNerve_both + " " + "same as " + " " +
		// strIntergiviewOpticNerve_both);
		// Thread.sleep(4000);
		// clickOnCancelBtn.click();
		// }
		//

	}

	// function to delete the file
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				dirContents[i].delete();
				Reporter.log("File Exist and delete");
				return true;
			}
		}
		return false;
	}

	public void ensureElementToBeclickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
