package pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.robotKeyb;

public class PageAddCDSIntervention {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.LINK_TEXT, using = "Configuration")
	private WebElement clickOnConfiguration;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Clinical Decision Support\"]")
	private WebElement clickOnCDS;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-addNewDocument>a")
	private WebElement clickOnAddNew;

	@FindBy(how = How.CSS, using = "input#gwt-debug-dlc-docname")
	private WebElement fillCdsRuleName;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div[3]")
	private WebElement clickUserTypeList;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/div/div[2]/div")
	private List<WebElement> selectUserTypeList;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div[3]")
	private WebElement clickOnInfoBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/div/div[3]/div")
	private List<WebElement> selectInfoBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-education")
	private WebElement clickOnEducation;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Select File\"]")
	private WebElement selectFile;

	@FindBy(how = How.CSS, using = "input.gwt-FileUpload#gwt-debug-dlc-fileUpload")
	private WebElement clickOnchoseFile;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-upload>a")
	private WebElement clickOnUploadBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-intervention")
	private WebElement clickOnIntervention;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[6]/textarea")
	private WebElement fillTextArea;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[6]/div[2]/div/div[2]/table/tbody/tr/td/div")
	private List<WebElement> selectCriticality;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-social-details")
	private WebElement clickOnAddSocialtrigger;

	@FindBy(how = How.CSS, using = "input#gwt-debug-snomed-searchText")
	private WebElement clickOnSnomedsearchText;

	@FindBy(how = How.CSS, using = "div#gwt-debug-snomed-search-go>a")
	private WebElement clickOnGo;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/div[3]/div[2]/div")
	private List<WebElement> selectSnomedCode;

	@FindBy(how = How.CSS, using = "div#gwt-debug-ldcv-code>div:nth-child(2)>div")
	private List<WebElement> add_SocialTrigger;

	@FindBy(how = How.CSS, using = "div#gwt-debug-ldcv-done>a")
	private WebElement clickOnsnomedDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-triggerOnAny-container>table>tbody>tr>td>div")
	private List<WebElement> selectAllTrigger;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-save>a")
	private WebElement clickOnSave;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Done\"]")
	private WebElement clickOnCDSDone;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[1]/div/table/tbody/tr/td/div")
	private List<WebElement> select_Patient;

	@FindBy(how = How.CSS, using = "table.encounter_tab_bar>tbody>tr>td:nth-child(3)>div")
	private WebElement selectOtherHistory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-addPastSocialHistory")
	private WebElement clickOnAddPastSocialHistory;

	@FindBy(how = How.CSS, using = "div#gwt-debug-social-smokingFrequency-container>div")
	private List<WebElement> selectSmoker;

	@FindBy(how = How.CSS, using = "div#gwt-debug-socialhistory-done>a")
	private WebElement clickOnSocialhistoryDone;

	@FindBy(how = How.CSS, using = "table.encounter_tab_bar>tbody>tr>td:nth-child(9)>div")
	private WebElement clickOnImpAndPlan;

	@FindBy(how = How.CSS, using = "div#gwt-debug-patientEducation>a")
	private WebElement clickOnPatientEducation;

	@FindBy(how = How.CSS, using = "div#gwt-debug-education-documents-container>div")
	private List<WebElement> selectEducationDocumentsContiner;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-\"]")
	private WebElement clickOnClosePatientEducation;

	@FindBy(how = How.CSS, using = "a#gwt-debug-returnToUserDashboard")
	private WebElement clickOnReturnUserdashBoard;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-documents-container>div>span")
	private List<WebElement> selectRuleName;

	@FindBy(how = How.CSS, using = "div#gwt-debug-dlc-delete>a")
	private WebElement clickOnDelete;

	@FindBy(how = How.CSS, using = "a.gwt-Anchor#gwt-debug-ok")
	private WebElement clickOnOk;

	public PageAddCDSIntervention(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageAddCDSIntervention.this);
	}

	public void verifyAddCDSIntervention(String ruleName, String userTypeList, String infoBtn, Boolean education,
			Boolean Intervention, String criticality, String FileName, String smoking, String triggerOn, String patient,
			String smoker) throws Exception {

		// function is used for perform CDS operation
		PerformCDSOperation(ruleName, userTypeList, infoBtn, education, Intervention, criticality, FileName, smoking,
				triggerOn);

		// function is used for select other History For Pateint Snomed
		 selectotherHistoryForPateintSnomed(patient, smoker);

		// function used for match cds with patient education
		Thread.sleep(3000);
		matchCDS(ruleName);

		Thread.sleep(8000);
		ensureElementToBeClickable(clickOnReturnUserdashBoard);
		clickOnReturnUserdashBoard.click();

		Thread.sleep(3000);
		deleteCDS(ruleName);

	}

	public void PerformCDSOperation(String ruleName, String userTypeList, String infoBtn, Boolean education,
			Boolean Intervention, String criticality, String FileName, String smoking, String triggerOn)
			throws Exception {

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnConfiguration);
		clickOnConfiguration.click();

		ensureElementToBeClickable(clickOnCDS);
		clickOnCDS.click();

		ensureElementToBeClickable(clickOnAddNew);
		clickOnAddNew.click();

		ensureElementToBeClickable(fillCdsRuleName);
		fillCdsRuleName.sendKeys(ruleName);

		ensureElementToBeClickable(clickUserTypeList);
		clickUserTypeList.click();

		ensureElementToBeClickable(selectUserTypeList);
		for (WebElement select_UserTypeList : selectUserTypeList) {
			if (select_UserTypeList.getText().equalsIgnoreCase(userTypeList)) {
				select_UserTypeList.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnInfoBtn);
		clickOnInfoBtn.click();

		Thread.sleep(4000);
		ensureElementToBeClickable(selectInfoBtn);
		for (WebElement select_InfoBtn : selectInfoBtn) {
			if (select_InfoBtn.getText().equalsIgnoreCase(infoBtn)) {
				builder.moveToElement(select_InfoBtn).click().perform();
				break;
			}
		}

		ensureElementToBeClickable(clickOnEducation);
		if (!clickOnEducation.isSelected() && education) {
			clickOnEducation.click();
		}

		selectFile(FileName);
		Thread.sleep(5000);

		ensureElementToBeClickable(clickOnIntervention);
		if (!clickOnIntervention.isSelected() && Intervention) {
			clickOnIntervention.click();
		}
		ensureElementToBeClickable(fillTextArea);
		fillTextArea.sendKeys("CDS Test");

		ensureElementToBeClickable(selectCriticality);
		for (WebElement select_Criticality : selectCriticality) {
			if (select_Criticality.getText().equalsIgnoreCase(criticality)) {
				select_Criticality.click();
				break;
			}

		}
		Thread.sleep(5000);
		addSocialTrigger(smoking);

		Thread.sleep(3000);
		ensureElementToBeClickable(selectAllTrigger);
		for (WebElement select_AllTrigger : selectAllTrigger) {
			if (select_AllTrigger.getText().equalsIgnoreCase(triggerOn)) {
				select_AllTrigger.click();
				break;
			}
		}

		Thread.sleep(7000);
		ensureElementToBeClickable(clickOnSave);
		clickOnSave.click();

		ensureElementToBeClickable(clickOnCDSDone);
		clickOnCDSDone.click();
	}

	private void selectFile(String FileName) throws Exception {
		ensureElementToBeClickable(selectFile);
		selectFile.click();

		ensureElementToBeClickable(clickOnchoseFile);
		clickOnchoseFile.click();

		Thread.sleep(5000);
		StringSelection selectFile = new StringSelection(FileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectFile, null);

		// call robot class for keyPress
		Thread.sleep(2000);
		robotKeyb keyBoardPress = new robotKeyb();
		keyBoardPress.keyPress();
		driver.switchTo().activeElement();

		ensureElementToBeClickable(clickOnUploadBtn);
		clickOnUploadBtn.click();

	}

	private void addSocialTrigger(String smoking) throws Exception {
		ensureElementToBeClickable(clickOnAddSocialtrigger);
		clickOnAddSocialtrigger.click();

		ensureElementToBeClickable(clickOnSnomedsearchText);
		clickOnSnomedsearchText.sendKeys(smoking);

		ensureElementToBeClickable(clickOnGo);
		clickOnGo.click();

		Thread.sleep(6000);
		for (WebElement select_SnomedCode : selectSnomedCode) {
			if (select_SnomedCode.getText().equalsIgnoreCase("Smokes tobacco daily")) {
				select_SnomedCode.click();
				break;
			}
		}

		Thread.sleep(4000);
		for (WebElement select_AddSocialTrigger : add_SocialTrigger) {
			if (select_AddSocialTrigger.getText().startsWith(smoking)) {
				select_AddSocialTrigger.click();
				break;
			}
		}

		ensureElementToBeClickable(clickOnsnomedDone);
		clickOnsnomedDone.click();

	}

	private void selectotherHistoryForPateintSnomed(String patient, String smoker) throws Exception {
		Thread.sleep(10000);
		ensureElementToBeClickable(select_Patient);
		for (WebElement select_PatientFromUserDashBoard : select_Patient) {
			if (select_PatientFromUserDashBoard.getText().equalsIgnoreCase(patient)) {
				select_PatientFromUserDashBoard.click();
				break;
			}
		}

		Thread.sleep(6000);
		ensureElementToBeClickable(selectOtherHistory);
		selectOtherHistory.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnAddPastSocialHistory);
		clickOnAddPastSocialHistory.click();

		boolean checkSmker = driver
				.findElement(By.cssSelector("div#gwt-debug-social-smokingFrequency-container>div:nth-child(1)"))
				.isSelected();

		System.out.println(checkSmker);

		Thread.sleep(3000);
		if (!checkSmker == true) {
			Thread.sleep(5000);
			ensureElementToBeClickable(selectSmoker);
			for (WebElement select_Smoker : selectSmoker) {
				if (select_Smoker.getText().equalsIgnoreCase(smoker)) {
					select_Smoker.click();
					break;

				}
			}
		}
		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnSocialhistoryDone);
		clickOnSocialhistoryDone.click();
	}

	private void matchCDS(String ruleName) throws Exception {

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnImpAndPlan);
		clickOnImpAndPlan.click();

		ensureElementToBeClickable(clickOnPatientEducation);
		clickOnPatientEducation.click();

		Thread.sleep(9000);
		ensureElementToBeClickable(selectEducationDocumentsContiner);
		for (WebElement select_EducationDocuments : selectEducationDocumentsContiner) {
			if (select_EducationDocuments.getText().equalsIgnoreCase(ruleName)) {
				System.out.println(select_EducationDocuments.getText().equalsIgnoreCase(ruleName));
				builder.moveToElement(select_EducationDocuments).perform();
				break;
			}
		}

		Thread.sleep(4000);
		clickOnClosePatientEducation.click();

	}

	public void deleteCDS(String ruleName) throws Exception {
		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnConfiguration);
		clickOnConfiguration.click();

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnCDS);
		clickOnCDS.click();

		Thread.sleep(15000);
		ensureElementToBeClickable(selectRuleName);
		for (WebElement select_RuleName : selectRuleName) {
			if (select_RuleName.getText().equalsIgnoreCase(ruleName)) {
				select_RuleName.click();
				break;
			}

		}
		ensureElementToBeClickable(clickOnDelete);
		clickOnDelete.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnOk);
		clickOnOk.click();

	}

	// finction use for enable element
	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	private void ensureElementToBeClickable(List<WebElement> element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}
}
