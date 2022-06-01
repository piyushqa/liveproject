package pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.robotKeyb;

public class PageInterpretationOfOpthalmoscopy {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.CSS, using = "div#gwt-debug-uploadDocument")
	private WebElement clickOnUploadDocument;

	@FindBy(how = How.CSS, using = "#gwt-debug-PicklistTable-dataTable>tbody>tr>td>div")
	private List<WebElement> selectDiagonisticTest;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterList-container>div")
	private List<WebElement> selectAssociatedEncounter;

	@FindBy(how = How.ID, using = "gwt-debug-fileUpload")
	private WebElement clickOnFileChoose;

	@FindBy(how = How.ID, using = "gwt-debug-renameFile")
	private WebElement sendToRenameFile;

	@FindBy(how = How.CSS, using = "div#gwt-debug-eyeSideList>div:last-child>div:nth-child(1)>div:nth-child(1)")
	private WebElement clickOnOdValue;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-uploadButton\"]/a[text()=\"Upload Document\"]")
	private WebElement clickOnUploadBtn;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-doneButton\"]/a[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget>a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-openEncounterTable>tbody>tr>td>div")
	private List<WebElement> selectProvider;

	@FindBy(how = How.CSS, using = "a#gwt-debug-integriView")
	private WebElement clickoNintergiview;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[1]/div[2]/div[2]")
	private WebElement clickOnOct;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/div[3]/img")
	private WebElement clickOnImg;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"View Selected Images\"]")
	private WebElement clickOnViewSelectedImage;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"INT\"]")
	private WebElement clickOnInt;

	@FindBy(how = How.CSS, using = ".integriview__interpretation__diagnosis-container>div:nth-child(2)")
	private WebElement clickOnDiagonsisDropDown;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"datalist datalist--picklist datalist--striping dataDropdown__list datalist--singleSelect\"]/div/div")
	private List<WebElement> selectDiagnosis;

	@FindBy(how = How.CSS, using = ".integriview__interpretation__common__abnormalities-container>div:nth-child(2)>div>div")
	private List<WebElement> selectAbnormalities;

	@FindBy(how = How.CSS, using = ".integriview__interpretation__common__impression-container>div:nth-child(2)>div>div")
	private List<WebElement> selectImpression;

	@FindBy(how = How.CSS, using = ".integriview__interpretation__common__severity-container>div:nth-child(2)>div>div")
	private List<WebElement> selectSeverity;

	@FindBy(how = How.CSS, using = ".integriview__interpretation__common__progression-container>div:nth-child(2)>div>div")
	private List<WebElement> selectProgression;

	@FindBy(how = How.CSS, using = ".integriview__interpretation__common__reliability-container>div:nth-child(2)>div>div")
	private List<WebElement> selectReliability;

	@FindBy(how = How.CSS, using = "div.integriview__interpretation__bottom-row>a:nth-child(3)")
	private WebElement clickOnFinalReport;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'integriview-interpretation-report-modal__print')and(text()=\"Save and Print\")]")
	private WebElement clickOnPrintAndSave;

	@FindBy(how = How.CSS, using = "div.integriview__interpretation__bottom-row>div")
	private WebElement clickOnDone;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Close IntegriView\"]")
	private WebElement clickOnCloseIntregiview;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOndocCenter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div/div[1]")
	private List<WebElement> selectTestInterpreation;

	public PageInterpretationOfOpthalmoscopy(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageInterpretationOfOpthalmoscopy.this);
	}

	public void verifyInterpretationOpthalmoscopy(String provider, String selectDiaDiagonisticTest, String FileName,
			String abnormalities, String impression, String severity, String progression, String reliability,
			String savedDocuments, String diagnosis) throws Exception {

		uploadDocument(provider, selectDiaDiagonisticTest, FileName);

		performInterpretationOpthalmoscopy(provider, abnormalities, impression, severity, progression, reliability,
				savedDocuments, diagnosis);
	}

	public void uploadDocument(String provider, String selectDiaDiagonisticTest, String FileName) throws Exception {
		Thread.sleep(2000);
		clickOnUploadDocument.click();

		for (WebElement select_DiagonisticTest : selectDiagonisticTest) {
			if (select_DiagonisticTest.getText().equalsIgnoreCase(selectDiaDiagonisticTest)) {
				select_DiagonisticTest.click();
				break;
			}
		}

		for (WebElement select_AssociatedEncounet : selectAssociatedEncounter) {
			if (select_AssociatedEncounet.getText().endsWith(provider)) {
				select_AssociatedEncounet.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickOnFileChoose.click();

		// function used to upload the file
		Thread.sleep(2000);
		StringSelection getFileSelection = new StringSelection(FileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(getFileSelection, null);

		// call robot class for keyPress
		Thread.sleep(2000);
		robotKeyb keyBoardPress = new robotKeyb();
		keyBoardPress.keyPress();
		driver.switchTo().activeElement();

		Thread.sleep(2000);
		if (!clickOnOdValue.isSelected()) {
			builder.moveToElement(clickOnOdValue).click().build().perform();
		}

		// click On Upload Btn
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		clickOnUploadBtn.click();

		// click On Done Btn
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		builder.moveToElement(clickOnDoneBtn).click().perform();

	}

	public void performInterpretationOpthalmoscopy(String provider, String abnormalities, String impression,
			String severity, String progression, String reliability, String savedDocuments, String diagnosis)
			throws Exception {
		Thread.sleep(6000);
		clickOnOpenEncounter.click();

		for (WebElement select_Provider : selectProvider) {
			if (select_Provider.getText().equalsIgnoreCase(provider)) {
				select_Provider.click();
				break;
			}
		}

		Thread.sleep(4000);
		clickoNintergiview.click();

		Thread.sleep(7000);
		clickOnOct.click();

		Thread.sleep(4000);
		clickOnImg.click();

		Thread.sleep(3000);
		clickOnViewSelectedImage.click();

		Thread.sleep(5000);
		clickOnInt.click();

		Thread.sleep(4000);
		clickOnDiagonsisDropDown.click();

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);

		for (WebElement select_diagonisis : selectDiagnosis) {
			if (select_diagonisis.getText().equalsIgnoreCase(diagnosis)) {
				select_diagonisis.click();
				break;
			}

		}

		//use abnormalities code both in try and catch block for remove DOM problem
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		try {
			for (WebElement select_Abnormalioties : selectAbnormalities) {
				if (select_Abnormalioties.getText().equalsIgnoreCase(abnormalities)) {
					if (!select_Abnormalioties.isSelected()) {
						select_Abnormalioties.click();
					}
					break;
				}

			}
		} catch (Exception e) {
			for (WebElement select_Abnormalioties : selectAbnormalities) {
				if (select_Abnormalioties.getText().equalsIgnoreCase(abnormalities)) {
					if (!select_Abnormalioties.isSelected()) {
						select_Abnormalioties.click();
					}
					break;
				}

			}
		}

		Thread.sleep(2000);
		for (WebElement select_Impression : selectImpression) {
			if (select_Impression.getText().equalsIgnoreCase(impression)) {
				if (!select_Impression.isSelected()) {
					select_Impression.click();
				}
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_Severity : selectSeverity) {
			if (select_Severity.getText().equalsIgnoreCase(severity)) {
				if (!select_Severity.isSelected()) {
					select_Severity.click();
				}
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_Progression : selectProgression) {
			if (select_Progression.getText().equalsIgnoreCase(progression)) {
				if (!select_Progression.isSelected()) {
					select_Progression.click();
				}
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_Reliability : selectReliability) {
			if (select_Reliability.getText().equalsIgnoreCase(reliability)) {
				if (!select_Reliability.isSelected()) {
					select_Reliability.click();
				}
				break;
			}
		}
		Thread.sleep(4000);
		clickOnFinalReport.click();

		Thread.sleep(4000);
		clickOnPrintAndSave.click();

		Thread.sleep(2000);
		handleWindow();

		Thread.sleep(4000);
		driver.close();

		Thread.sleep(2000);
		handleWindow();

		Thread.sleep(4000);
		clickOnDone.click();

		Thread.sleep(4000);
		clickOnCloseIntregiview.click();

		Thread.sleep(4000);
		documentCenter(savedDocuments);
	}

	public void documentCenter(String savedDocuments) throws Exception {
		Thread.sleep(2000);
		clickOndocCenter.click();

		for (WebElement select_TestInterpreation : selectTestInterpreation) {
			if (select_TestInterpreation.getText().equalsIgnoreCase(savedDocuments)) {
				select_TestInterpreation.click();
				break;
			}
		}
	}

	public void handleWindow() {
		for (String handles : driver.getWindowHandles()) {
			driver.switchTo().window(handles);
		}

	}
}
