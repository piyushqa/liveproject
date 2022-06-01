 package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

import tests.LoginTest;

public class PgErpFileSharing {
	private WebDriver driver;
	WebElement element;
	private WebDriverWait wait;
	private Actions builder;

	// declration of element locaters
	@FindBy(how = How.CSS, using = "#sidebar > ul > li:nth-child(7) > a > span.menu-text")
	private WebElement clickOnFileSharing;

	@FindBy(how = How.XPATH, using = "//*[@class=\"new-object btn-sm btn btn-primary\"]/span[2]")
	private WebElement clickOnUpload;

	@FindBy(how = How.CSS, using = "#main-container > div.main-content > div > div > div > div > form > div.row > div > div > div> div:nth-child(6) > div > div:nth-child(1)>input")
	private WebElement clickOnInputName;

	@FindBy(how = How.CSS, using = "#main-container > div> div > div > div > div > form > div > div > div > div> div:nth-child(6) > div > div:nth-child(2) > div>span>label")
	private WebElement clickOnChooseFile;

	@FindBy(how = How.CSS, using = "#main-container > div > div > div > div > div > form > div.row > div > div > div > div:nth-child(6) > div > div:nth-child(3)>textarea")
	private WebElement clickOnCommentBox;

	@FindBy(how = How.XPATH, using = ".//button[@id=\"uploadButton\"]/span[1]")
	private WebElement clickOnAgainUploadButton;

	@FindBy(how = How.CSS, using = "#content > div > div > div:nth-child(3) > div> table > tbody>tr:nth-child(2)>td:nth-child(1)>a")
	private WebElement clickOnTask;

	@FindBy(how = How.CSS, using = "#gwt-debug-viewTaskWidget > table > tbody > tr:nth-child(6) > td > div > div:nth-child(5)>span:nth-child(2)")
	private WebElement matchDocumentpdf;


	//constructor
	public PgErpFileSharing(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	//function for uploading file
	public void pateintErpFileSharing(String name, String fileName, String comment,String user,String patientFile)
			throws Exception {

		//click on fileSharing
		Thread.sleep(6000);
		clickOnFileSharing.click();

//		//click on upload file button
//		Thread.sleep(8000);
//		clickOnUpload.click();
//
//		//click on NameText and fill the Text
//		Thread.sleep(3000);
//		clickOnInputName.click();
//		Thread.sleep(3000);
//		clickOnInputName.sendKeys(name);
//
//		//click on choosefile tag
//		Thread.sleep(4000);
//		clickOnChooseFile.click();
//
//		//upload the file from a window
//		Thread.sleep(4000);
//		StringSelection s = new StringSelection(fileName);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
//
//		Thread.sleep(4000);
//		// hit enter
//		Robot r = new Robot();
//
//		r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//		r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
//		r.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
//		r.keyPress(java.awt.event.KeyEvent.VK_V);
//		r.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//		Thread.sleep(3000);
//		r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//		Thread.sleep(4000);
//		// switch back
//		driver.switchTo().activeElement();
//
//		//click on commentBox and fill the value
//		Thread.sleep(4000);
//		clickOnCommentBox.click();
//		Thread.sleep(3000);
//		clickOnCommentBox.sendKeys(comment);
//
//		//click on uploading Button
//		Thread.sleep(25000);
//		clickOnAgainUploadButton.click();
//
//		LoginTest test=new LoginTest(driver);
//		test.testLogin();
//
//	matchErpFileSharingPatient(user, patientFile);
	}

	//function for mtch the document from patient
	public void matchErpFileSharingPatient(String user, String patientFile) throws InterruptedException {

		//clickon task
		Thread.sleep(15000);
		clickOnTask.click();

		//select specified patient
		Thread.sleep(6000);
		java.util.List<WebElement> clickOnPatientTask = driver.findElements(By.cssSelector(
				"#gwt-debug-contentPanel > div:nth-child(3) > div > div > div > table > tbody:nth-child(3)>tr>td>div"));
		for (int i = 0; i < clickOnPatientTask.size(); i++)
			if (clickOnPatientTask.get(i).getText().equalsIgnoreCase(user)) {
				clickOnPatientTask.get(i).click();
				break;

			}

		//match the document if match then pass otherwise fail
		Thread.sleep(4000);
		String storeText = matchDocumentpdf.getText();
		if (patientFile.equals(storeText)) {
			Reporter.log(patientFile + " will same as" + " " + storeText + " " + "Erp uploadedfile");
		} else {
			Reporter.log("Fail");
		}

	}

}
