package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import config.ProjectSettings;
import tests.LoginTest;

public class PageERPSecureMsg {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String erpUrl = "https://preproductionportal.eyereachpatients.com/Patients/test2";
	String ERPMsg = "ERP msg send to EMR";

	// define locater
	@FindBy(how = How.XPATH, using = ".//a[contains(@id,'gwt-debug-userDashMessageLink')]")
	private WebElement clickOnMessageLinkOfCommunicationCenter;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Compose Message\"]")
	private WebElement clickOnComposeMsg;

	@FindBy(how = How.CSS, using = "a#gwt-debug-addPrimaryRecipLinkAnchor")
	private WebElement clickOnMsgToADD;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Add Patient\"]")
	private WebElement clickOnAddPatient;

	// this locater is same for all recipites dialogue box
	@FindBy(how = How.XPATH, using = ".//div[@class=\"popupContent\"]/div/table[1]/tbody/tr/td/div/div/div[1]/div[2]/div[2]/div")
	private List<WebElement> selectMsgTO;

	// this select locater button is same for all dialogue box
	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/table/tbody/tr[2]/td[2]/div/div/div[4]/a")
	private WebElement clickOnMsgToSelectBtn;

	@FindBy(how = How.CSS, using = "a#gwt-debug-addOtherRecipLinkAnchor")
	private WebElement clickOnOtherRecipitesAdd;

	@FindBy(how = How.CSS, using = "table>tbody>tr:nth-child(4)>td>input#gwt-debug-topic")
	private WebElement fillTheTopic;

	@FindBy(how = How.CSS, using = "table>tbody>tr:nth-child(5)>td>a#gwt-debug-addPatientLinkAnchor")
	private WebElement clickOnRegardingpatientAdd;

	@FindBy(how = How.CSS, using = "input#gwt-debug-urgentBox-input")
	private WebElement clickOnUrgentcheckBox;

	@FindBy(how = How.CSS, using = "input#gwt-debug-patientFirstName")
	private WebElement fillFirstName;

	@FindBy(how = How.CSS, using = "input#gwt-debug-patientLastName")
	private WebElement fillSecondName;

	@FindBy(how = How.CSS, using = "#gwt-debug-searchButton>a")
	private WebElement clickOnSrchBtn;

	@FindBy(how = How.CSS, using = "#gwt-debug-searchResultTable>tbody>tr>td>div")
	private List<WebElement> clickOnlastNameOfPatient;

	@FindBy(how = How.CSS, using = "#gwt-debug-createMessageWidget>table>tbody>tr:nth-child(7)>td>textarea#gwt-debug-message")
	private WebElement fillTheMsgTextArea;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-send-message\"]/a[text()=\"Send Message\"]")
	private WebElement clickOnSendMsg;

	@FindBy(how = How.XPATH, using = ".//input[@placeholder=\"Username\"]")
	private WebElement fillERPUserName;

	@FindBy(how = How.CSS, using = "input#Password")
	private WebElement fillERPPassword;

	@FindBy(how = How.XPATH, using = ".//span[text()=\"Login\"]")
	private WebElement clickOnLoginBtn;

	@FindBy(how = How.XPATH, using = ".//span[contains(text(),' Secure messaging ')]")
	private WebElement clickOnSecureMsg;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"search-results\"]/tbody/tr/td/div//a[text()=\"Medical record\"]")
	private List<WebElement> clickOnMsgInbox;

	@FindBy(how = How.CSS, using = ".panel-heading>div>div:nth-child(2)>div>a:nth-child(1)")
	private WebElement clickOnReplyBtn;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"form-group\"]/textarea")
	private WebElement fillValueInReplyTextArea;

	@FindBy(how = How.XPATH, using = ".//button[text()=\" Send\"]")
	private WebElement clickOnERPsendBtn;

	@FindBy(how = How.XPATH, using = ".//div[starts-with(text(),'Message Inbox')]")
	private WebElement clickOnEMRMsgInbox;

	@FindBy(how = How.CSS, using = "#gwt-debug-viewMessageWidget>table>tbody>tr>td>textarea#gwt-debug-message")
	private WebElement getDataFromTextArea;

	public PageERPSecureMsg(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageERPSecureMsg.this);
	}

	//verifyERPSecureMsg
	public void verifyERPSecureMsg(String msgTo, String otherRecipites, String topic, String fName, String lName,
			String erpUserName, String erpPassword, Boolean urgent) throws Exception {


		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnMessageLinkOfCommunicationCenter);
		clickOnMessageLinkOfCommunicationCenter.click();


		//in this function we compose msg On EMR and send to ERP
		for(int i=1;i<100;i++) {
		//Thread.sleep(2000);
		sendSecureMsgFromEMR(msgTo, otherRecipites, topic, fName, lName, urgent);
		}
		//Match msg on ERP
//		Thread.sleep(2000);
//		matchMsgOnErp();

//		//Reply from ERP and send to EMR and match
//		Thread.sleep(2000);
//		replyMsgForEMR();

	}

	public void sendSecureMsgFromEMR(String msgTo, String otherRecipites, String topic, String fName, String lName,
			Boolean urgent) throws Exception {


		
		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnComposeMsg);
		clickOnComposeMsg.click();

		//Thread.sleep(1000);
		ensureElementToBeClickable(clickOnMsgToADD);
		clickOnMsgToADD.click();

		//call method
		//Thread.sleep(1000);
		searchRegardingpatient(fName, lName);
		// Thread.sleep(3000);
		// for (WebElement select_MsgTo : selectMsgTO) {
		// if (select_MsgTo.getText().equalsIgnoreCase(msgTo)) {
		// select_MsgTo.click();
		// break;
		// }
		// }
		// Thread.sleep(2000);
		// clickOnMsgToSelectBtn.click();
		//
		// Thread.sleep(1000);
		 ensureElementToBeClickable(clickOnOtherRecipitesAdd);
		 clickOnOtherRecipitesAdd.click();
		
		 //Thread.sleep(1000);
		 for (WebElement select_OtherRecipites : selectMsgTO) {
		 if (select_OtherRecipites.getText().equalsIgnoreCase(otherRecipites)) {
		 select_OtherRecipites.click();
		 break;
		 }
		 }
		 // here we click on other recipites select
		 //Thread.sleep(1000);
		 clickOnMsgToSelectBtn.click();

		//Thread.sleep(1000);
		ensureElementToBeClickable(fillTheTopic);
		fillTheTopic.sendKeys("Medical record");

		// Thread.sleep(2000);
		// ensureElementToBeClickable(clickOnRegardingpatientAdd);
		// clickOnRegardingpatientAdd.click();

		//Thread.sleep(1000);
		fillTheMsgTextArea.sendKeys("saved patient,record");

		//Thread.sleep(1000);
		if (!clickOnUrgentcheckBox.isSelected() && urgent) {
			clickOnUrgentcheckBox.click();
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnSendMsg);
		clickOnSendMsg.click();

	}
	public void searchRegardingpatient(String fName, String lName) throws Exception {

		Thread.sleep(2000);
		clickOnAddPatient.click();
		Thread.sleep(2000);
		fillFirstName.sendKeys(fName);
		fillSecondName.sendKeys(lName);

		Thread.sleep(2000);
		clickOnSrchBtn.click();

		Thread.sleep(2000);
		for (WebElement select_LastName : clickOnlastNameOfPatient) {
			if (select_LastName.getText().equalsIgnoreCase(lName)) {
				select_LastName.click();
				break;
			}
		}
		Thread.sleep(4000);
		clickOnMsgToSelectBtn.click();
	}

	public void matchMsgOnErp() throws Exception {
		Thread.sleep(2000);
		driver.get(ProjectSettings.erpUrl);

		Thread.sleep(4000);
		ensureElementToBeClickable(fillERPUserName);
		fillERPUserName.sendKeys(ProjectSettings.erpUserName);

		Thread.sleep(4000);
		ensureElementToBeClickable(fillERPPassword);
		fillERPPassword.sendKeys(ProjectSettings.erpPassword);

		Thread.sleep(3000);
		clickOnLoginBtn.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnSecureMsg);
		clickOnSecureMsg.click();

		Thread.sleep(2000);
		for (WebElement select_Msg : clickOnMsgInbox) {
			if (select_Msg.getText().equalsIgnoreCase("Medical record")) {
				select_Msg.click();
				break;
			}
		}

	}

	public void replyMsgForEMR() throws Exception {
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnReplyBtn);
		clickOnReplyBtn.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(fillValueInReplyTextArea);
		fillValueInReplyTextArea.sendKeys(ERPMsg);

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnERPsendBtn);
		clickOnERPsendBtn.click();

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnMessageLinkOfCommunicationCenter);
		clickOnMessageLinkOfCommunicationCenter.click();

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnEMRMsgInbox);
		clickOnEMRMsgInbox.click();

		Thread.sleep(5000);
		String storeData = getDataFromTextArea.getText();
		if (storeData.endsWith(ERPMsg)) {
			Reporter.log(storeData + " " + "and" + " " + ERPMsg + " " + "Is same");
		}
	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
