package pages;

import java.awt.datatransfer.StringSelection;
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

import utilities.robotKeyb;

public class PageGeneratingAndPrintingOfRefferalReplyDoc {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// Define Locater
	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;

	@FindBy(how = How.XPATH, using = "//div[text()=\"Referrals and Followups\"]")
	private WebElement clickOnRefferalAndFollowups;

	@FindBy(how = How.XPATH, using = "//td/div[text()=\"Upload\"]")
	private WebElement clickOnUploadDocument;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2][text()=\"Upload a reply document\"]")
	private WebElement clickOnUploadReplyDocument;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div[text()=\"Referral Reply\"]")
	private WebElement clickOnrefferalReplyData;

	@FindBy(how = How.ID, using = "gwt-debug-encounterList-container")
	private WebElement selectAssociateWithencounter;

	@FindBy(how = How.ID, using = "gwt-debug-fileUpload")
	private WebElement clickOnFileChoose;

	@FindBy(how = How.ID, using = "gwt-debug-renameFile")
	private WebElement sendToRenameFile;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-uploadButton\"]/a[text()=\"Upload Document\"]")
	private WebElement clickOnUploadBtn;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-doneButton\"]/a[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-overlay_content\"]/div/div/div/div[2]/div")
	private List<WebElement> selectRefferalAndFollowUp;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Associate\"]")
	private WebElement clickOnAssociatesBtn;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"View\"]")
	private WebElement clickOnViewBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/img")
	private WebElement clickOnCancelButtonOfDownloadPage;

	public PageGeneratingAndPrintingOfRefferalReplyDoc(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageGeneratingAndPrintingOfRefferalReplyDoc.this);
	}

	public void verifyGeneratingAndPrintingOfRefferalReplyDoc(String fName, String lName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String documents, String visitType, Boolean noCharges,
			String associateEncounter, String fileName, String reNameFile) throws Exception {

		// call the function of PgEncounter class
		Thread.sleep(2000);
		PageCloseEncounter closeEncounter = new PageCloseEncounter(wait, driver, builder);
		closeEncounter.openEncounterWithProblem(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, significantProblem);

		// click on Document center
		Thread.sleep(5000);
		ensureElememtToBeClickable(clickOnDocumentCenter);
		clickOnDocumentCenter.click();

		// select_Documents

		List<WebElement> select_Documents = driver
				.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div/div[1]"));

		for (int i = 1; i <= select_Documents.size() - 1; i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase(documents)) {
				select_Documents.get(i).click();
				break;
			}

		// click On Refferal And Follow up

		// call method of generating refferal reply doc
		generatingRefferalReplyDoc(associateEncounter, fileName, reNameFile);
//
//		Thread.sleep(2000);
		closeEncounter = new PageCloseEncounter(wait, driver, builder);
		closeEncounter.closeEncounter(visitType, noCharges);
	}

	public void generatingRefferalReplyDoc(String associateEncounter, String fileName, String reNameFile)
			throws Exception {
		ensureElememtToBeClickable(clickOnRefferalAndFollowups);
		builder.moveToElement(clickOnRefferalAndFollowups).click().perform();

		// click On Upload Document
		Thread.sleep(3000);
		ensureElememtToBeClickable(clickOnUploadDocument);
		clickOnUploadDocument.click();

		// click On Upload Reply Document
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnUploadReplyDocument);
		clickOnUploadReplyDocument.click();

		// scroll the dataList table
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("gwt-debug-PicklistTable-dataTable"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		// click On refferal Reply Data
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnrefferalReplyData);
		clickOnrefferalReplyData.click();

		// associates Enounter
		Thread.sleep(2000);
		for (WebElement associatesEnounter : selectAssociateWithencounter.findElements(By.xpath(".//*"))) {
			if (associatesEnounter.getText().endsWith(associateEncounter)) {
				builder.moveToElement(associatesEnounter).click().perform();
				break;
			}
		}

		// click On File Choose
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnFileChoose);
		clickOnFileChoose.click();

		// function used to upload the file
		Thread.sleep(2000);
		StringSelection getFileSelection = new StringSelection(fileName);
		java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(getFileSelection, null);

		// call robot class for keyPress
		Thread.sleep(2000);
		robotKeyb keyBoardPress = new robotKeyb();
		keyBoardPress.keyPress();
		driver.switchTo().activeElement();

		// send To Rename File
		Thread.sleep(2000);
		ensureElememtToBeClickable(sendToRenameFile);
		sendToRenameFile.sendKeys(reNameFile);

		// click On Upload Btn
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnUploadBtn);
		clickOnUploadBtn.click();

		// click On Done Btn
		Thread.sleep(4000);
		ensureElememtToBeClickable(clickOnDoneBtn);
		builder.moveToElement(clickOnDoneBtn).click().perform();

		// select rename file
		Thread.sleep(5000);
		for (WebElement select_RefferalReplies : selectRefferalAndFollowUp) {
			if (select_RefferalReplies.getText().startsWith(reNameFile)) {
				select_RefferalReplies.click();
				break;
			}
		}

		// click On Associates Btn
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnAssociatesBtn);
		builder.moveToElement(clickOnAssociatesBtn).click().perform();

		// click On View Btn
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnViewBtn);
		clickOnViewBtn.click();

		// click On Cancel Button Of Download Page
		Thread.sleep(2000);
		ensureElememtToBeClickable(clickOnCancelButtonOfDownloadPage);
		clickOnCancelButtonOfDownloadPage.click();

	}

	// fuction is used for visibility and clickAble of elements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
