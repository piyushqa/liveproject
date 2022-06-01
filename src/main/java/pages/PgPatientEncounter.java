package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PgPatientEncounter 
{
	private WebDriver driver;
	
	//Patient Dashboard page elements
	@FindBy(how = How.CSS, using = "#gwt-debug-patientDetailName")
	private WebElement divPatientName;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-returnToPatientDashboard")
	private WebElement lnkPatientDashboard;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-returnToUserDashboard")
	private WebElement lnkReturnToMyDashboard;
	
	//Provider Dropdown and list element
	@FindBy(how = How.CSS, using = "#gwt-debug-providerList-button > div:nth-child(3)")
	private WebElement drpdwnProvider;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-providerList-container")
	private WebElement lstProvider;

	//Technician Dropdown and list element
	@FindBy(how = How.CSS, using = "#gwt-debug-technicianList-button > div:nth-child(3)")
	private WebElement drpdwnTechnician;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-technicianList-container")
	private WebElement lstTechnician;
	
	//Scribe Dropdown and list element
	@FindBy(how = How.CSS, using = "#gwt-debug-scribeList-button > div:nth-child(3)")
	private WebElement drpdwnScribe;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-scribeList-container")
	private WebElement lstScribe;

	//Co-manage with Dropdown and its list element
	@FindBy(how = How.CSS, using = "#gwt-debug-comanageList-button > div:nth-child(3)")
	private WebElement drpdwnComanage;

	@FindBy(how = How.CSS, using = "#gwt-debug-comanageList-container")
	private WebElement lstComanage;
	
	//Today's visit Status Dropdown and list element
	@FindBy(how = How.CSS, using = "#gwt-debug-statusList-button > div:nth-child(3)")
	private WebElement drpdwnStatus;

	@FindBy(how = How.CSS, using = "#gwt-debug-statusList-container")
	private WebElement lstStatus;
	
	//Today's visit Location Dropdown and list element
	@FindBy(how = How.CSS, using = ".stylish_combo_label")
	private WebElement drpdwnLocation;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-PicklistTable-dataTable")
	private WebElement lstLocation;
	
	//Linked to Appointment element
	@FindBy(how = How.CSS, using = "#gwt-debug-appointmentList-button > div:nth-child(3)")
	private WebElement drpdwnLinkedToAppointments;

	@FindBy(how = How.CSS, using = "#gwt-debug-appointmentList-container")
	private WebElement lstLinkedToAppointments;
	
	//Encounter MAIN NAVIGATION buttons
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1)")   // CC& HPI Button
	private WebElement btnCCandHPI;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)")   // Eye History Button
	private WebElement btnEyeHistory;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3) > div:nth-child(1)")   // Other History Button
	private WebElement btnOtherHistory;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > div:nth-child(1)")   // ROS Button
	private WebElement btnROS;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(5) > div:nth-child(1)" )  // Vision Button
	private WebElement btnVision;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(6) > div:nth-child(1)" )  // Tech Exam Button
	private WebElement btnTechExam;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(7) > div:nth-child(1)" )  // Dr.Review Button
	private WebElement btnDrReview;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(8) > div:nth-child(1)" )  // Exam Button
	private WebElement btnExam;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9) > div:nth-child(1)" )  // Imp & Plan Coding Button
	private WebElement btnImpAndPlan;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(10) > div:nth-child(1)" )  // Coding Button
	private WebElement btnCoding;
	
	//IntegriView links
	@FindBy(how = How.CSS, using = "#gwt-debug-documentCenter")
	private WebElement lnkDocumentCenter;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-surgeryModule")
	private WebElement lnkSurgeryModule;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-uploadDocument")
	private WebElement lnkUploadDocuments;

	//Summaries dropdown and its list
	@FindBy(how = How.CSS, using = "#gwt-debug-summaries-button > div:nth-child(3)")
	private WebElement drpdwnSummaries;

	@FindBy(how = How.CSS, using = "#gwt-debug-summaries-container")
	private WebElement lstSummaries;

	//Other Links drop downs along with their lists
	@FindBy(how = How.CSS, using = "#gwt-debug-otherLinks-button > div:nth-child(3)")
	private WebElement drpdwnOtherLinks;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-otherLinks-container")
	private WebElement lstOtherLinks;
	
	//Page bottom links
	@FindBy(how = How.CSS, using = "#gwt-debug-glaucomaSummary")
	private WebElement lnkMedsAndAllergies;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-socialFamilyHistory")
	private WebElement lnkSocialAndFamilyHistory;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-glaucomaSummary")
	private WebElement lnkGlaucomaSummary;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-visionSummary")
	private WebElement lnkVisionSummary;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-pdLogout > a:nth-child(3)")
	private WebElement btnLogout;
	
	//Initializing encouter page
	public PgPatientEncounter (WebDriver driver)
	{
		String pgTitle = "Integrity EMR";
		this.driver = driver;
		if (driver.getTitle().contains(pgTitle))
		{
			PageFactory.initElements(driver, this);
		}
		else
		{
			Reporter.log("Incorrect Page: Found: "+driver.getTitle()+" while expecting: "+pgTitle);
		}
	}

	public void entrCCandHPIDetails()
	{
		
	}
	
	public void entrEyeHistory()
	{

	}
	
	public void entrOtherHistory()
	{
		
	}
	
	public void entrROS()
	{
		
	}
	
	public PgVisionTab entrVision()
	{
		WebDriverWait wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(btnVision));
		btnVision.click();
		return new PgVisionTab(driver);
	}
	
	public void entrTechExam()
	{
		
	}
	
	public void entrDrReview()
	{
		
	}
	
	public void entrExam()
	{
		
	}
	
	public void entrImpAndPlan()
	{
		
	}
	
	public void coding()
	{
		
	}
}