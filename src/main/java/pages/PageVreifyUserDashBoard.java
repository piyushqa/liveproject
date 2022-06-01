package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageVreifyUserDashBoard {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	boolean chckCondition;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[3]/div[1]/table/tbody/tr/td/a")
	private List<WebElement> SizeOfCommunicationCenter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[4]/div[1]/table/tbody/tr/td/a")
	private List<WebElement> SizeOfPracticeCommunication;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[5]/table/tbody/tr/td/a")
	private List<WebElement> sizeOfPatientTable;

	@FindBy(how = How.CSS, using = "a#gwt-debug-userDashMessageLink")
	private WebElement verifyMessage;

	@FindBy(how = How.CSS, using = "a#gwt-debug-faxLink")
	private WebElement verifyFax;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Tasks\"]")
	private WebElement verifyTask;

	@FindBy(how = How.CSS, using = "a#gwt-debug-directLink")
	private WebElement verifyDirectMessageHistory;

	@FindBy(how = How.CSS, using = "a#gwt-debug-addendaLink")
	private WebElement verifyPendingAgendaLink;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Direct Message Inbox\"]")
	private WebElement verifyDirectMessageInbox;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"User Management\"]")
	private WebElement verifyUserMgt;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Manage Access Permissions\"]")
	private WebElement verifyAccessPermission;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Practice Configuration\"]")
	private WebElement verifyPraticeConfiguration;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Configure Session Timeout\"]")
	private WebElement verifyConfigureSessionTimeOut;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Audit Search\"]")
	private WebElement verifyAuditSearch;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Coding Integration Report\"]")
	private WebElement verifyCodingIntegrationReport;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"File Transfer Recon Dashboard\"]")
	private WebElement verifyFileTransferReconDashBoard;

	@FindBy(how = How.LINK_TEXT, using = "Patient Search")
	private WebElement verifyPatientSearch;

	@FindBy(how = How.LINK_TEXT, using = "Create Patient")
	private WebElement verifycreatePatient;

	@FindBy(how = How.LINK_TEXT, using = "Providers")
	private WebElement verifyProviders;

	@FindBy(how = How.LINK_TEXT, using = "Appointments")
	private WebElement verifyAppointments;

	@FindBy(how = How.LINK_TEXT, using = "Change Password")
	private WebElement verifyChangePswd;

	@FindBy(how = How.LINK_TEXT, using = "Advanced Search")
	private WebElement verifyAdvanceSearch;

	@FindBy(how = How.LINK_TEXT, using = "Surgery Dashboard")
	private WebElement verifySurgeryDashBoard;

	@FindBy(how = How.LINK_TEXT, using = "Configuration")
	private WebElement verifyConfiguration;

	@FindBy(how = How.LINK_TEXT, using = "Document Library")
	private WebElement verifyDocumentLibrary;

	@FindBy(how = How.LINK_TEXT, using = "Authorized Representatives")
	private WebElement verifyAuthorizedRepresntative;

	@FindBy(how = How.LINK_TEXT, using = "IntegrityPM")
	private WebElement verifyIntegrityPM;

	@FindBy(how = How.LINK_TEXT, using = "RCP MIPS Dashboard")
	private WebElement verifyRCP;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageVreifyUserDashBoard(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageVreifyUserDashBoard.this);
	}

	public void verifyUserDashBoardLink() throws Exception {

		// In this function we count size of link
		totalNoLinkPresenceOfUserDashBoard();

		// In this below function verify Link is visible or not

		UserDashBoardLink(verifyMessage);

		UserDashBoardLink(verifyFax);

		UserDashBoardLink(verifyTask);

		UserDashBoardLink(verifyDirectMessageHistory);

		UserDashBoardLink(verifyPendingAgendaLink);

		UserDashBoardLink(verifyDirectMessageInbox);

		UserDashBoardLink(verifyUserMgt);

		UserDashBoardLink(verifyAccessPermission);

		UserDashBoardLink(verifyPraticeConfiguration);

		UserDashBoardLink(verifyConfigureSessionTimeOut);

		UserDashBoardLink(verifyAuditSearch);

		UserDashBoardLink(verifyCodingIntegrationReport);

		UserDashBoardLink(verifyFileTransferReconDashBoard);

		UserDashBoardLink(verifyPatientSearch);

		UserDashBoardLink(verifycreatePatient);

		UserDashBoardLink(verifyAppointments);

		UserDashBoardLink(verifyChangePswd);

		UserDashBoardLink(verifyAdvanceSearch);

		UserDashBoardLink(verifySurgeryDashBoard);

		UserDashBoardLink(verifyConfiguration);

		UserDashBoardLink(verifyDocumentLibrary);

		UserDashBoardLink(verifyAuthorizedRepresntative);

		UserDashBoardLink(verifyIntegrityPM);

		UserDashBoardLink(verifyRCP);

		// In this below function check element is clickable or not

		boolean check=isClickable(verifyIntegrityPM);
		System.out.println("Integrity PM Link clickAble"+" "+check);

		
		check=isClickable(verifyMessage);
		System.out.println("Message Link clickAble"+" "+check);
		
		check=isClickable(verifyTask);
		System.out.println("Task Link clickAble"+" "+check);
		
		check=isClickable(verifyFax);
		System.out.println("Fax Link clickAble"+" "+check);
		
		check=isClickable(verifyPendingAgendaLink);
		System.out.println("Pending Agenda Link clickAble"+" "+check);
		
		check=isClickable(verifyDirectMessageHistory);
		System.out.println("Direct Message History Link clickAble"+" "+check);
		
		check=isClickable(verifyDirectMessageInbox);
		System.out.println("Direct Message Inbox clickAble"+" "+check);
		
		check=isClickable(verifyUserMgt);
		System.out.println("User Mgt Link clickAble"+" "+check);
		
		check=isClickable(verifyAccessPermission);
		System.out.println("Access Permission Link clickAble"+" "+check);
		
		check=isClickable(verifyPraticeConfiguration);
		System.out.println("Pratice Configuration Link clickAble"+" "+check);
		
		check=isClickable(verifyConfigureSessionTimeOut);
		System.out.println("Configure Session TimeOut Link clickAble"+" "+check);
		
		check=isClickable(verifyAuditSearch);
		System.out.println("Audit Search Link clickAble"+" "+check);
		
		check=isClickable(verifyCodingIntegrationReport);
		System.out.println("Coding Integration Report Link clickAble"+" "+check);
		
		check=isClickable(verifyFileTransferReconDashBoard);
		System.out.println("File Transfer ReconDash Board Link clickAble"+" "+check);
		
		check=isClickable(verifyPatientSearch);
		System.out.println("Patient Search Link clickAble"+" "+check);
		
		check=isClickable(verifycreatePatient);
		System.out.println("create Patient Link clickAble"+" "+check);
		
		check=isClickable(verifyProviders);
		System.out.println("Providers Link clickAble"+" "+check);
		
		check=isClickable(verifyAppointments);
		System.out.println("Appointments Link clickAble"+" "+check);
		
		check=isClickable(verifyChangePswd);
		System.out.println("ChangePswd Link clickAble"+" "+check);
		
		check=isClickable(verifyAdvanceSearch);
		System.out.println("Advance Search Link clickAble"+" "+check);
		
		check=isClickable(verifySurgeryDashBoard);
		System.out.println("Surgery DashBoard Link clickAble"+" "+check);
		
		check=isClickable(verifyConfiguration);
		System.out.println("Configuration Link clickAble"+" "+check);
		
		check=isClickable(verifyDocumentLibrary);
		System.out.println("DocumentLibrary Link clickAble"+" "+check);
		
		check=isClickable(verifyAuthorizedRepresntative);
		System.out.println("AuthorizedRepresntative Link clickAble"+" "+check);
		
		check=isClickable(verifyRCP);
		System.out.println("RCP Link clickAble"+" "+check);
		
		
	}

	public void totalNoLinkPresenceOfUserDashBoard() throws Exception {

		Thread.sleep(2000);

		int communicationCenter = SizeOfCommunicationCenter.size();

		int practiceConfiguration = SizeOfPracticeCommunication.size();

		int patientSize = sizeOfPatientTable.size();
		

		System.out.println("Total No of Link Presence User DashBoard" + " : "
				+ (communicationCenter + practiceConfiguration + patientSize));
	}

	public void UserDashBoardLink(WebElement element) throws Exception {
		Thread.sleep(2000);

		chckCondition = element.isDisplayed();
		String strText = element.getText();
		if (chckCondition = true) {
			System.out.println(strText + " " + "Link Displayed");
		} else {
			System.out.println(strText + " " + "Link is Not getting Displayed");
		}
	}

	public boolean isClickable(WebElement element) {

		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
