package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClinicSiteForUserProfile {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;
	String storeUrl;
	String newUrl;

	@FindAll({ @FindBy(how = How.XPATH, using = ".//div[@class=\"nav\"]/span[3]/a"),
			@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Associate Users With Sites')]") })
	private WebElement clickOnAssociateUsersWithSites;

	@FindBy(how = How.XPATH, using = "//input[@class=\"selectAll\"]")
	private WebElement clickOnSelectAll;

	@FindBy(how = How.XPATH, using = ".//table[@id=\"clinicSiteTable\"]/tbody/tr/td")
	private List<WebElement> selectClinicSiteName;

	@FindBy(how = How.CSS, using = "div.save>input")
	private WebElement clickOnDoneButton;

	@FindBy(how = How.LINK_TEXT, using = "User Management")
	private WebElement clickOnUserMgt;

	@FindBy(how = How.CSS, using = "select#gwt-debug-clinicSiteCombo>option")
	private List<WebElement> getClinicSiteSelection;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private WebElement clickOnClose;

	

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageClinicSiteForUserProfile(WebDriverWait wait, WebDriver driver, Actions builder) {
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageClinicSiteForUserProfile.this);
	}

	public void verifyClinicSiteForUserProfile(boolean selectAll, String fNameForOneUserProfile, String clinicSite,
			String role, String providerType, String aciUserRole, String selectDegree, String mustHaveSupervisingDoctor,
			String firstName, String middleName, String lastName, String initials, boolean canEditPracticeCPTCodes,
			boolean canEditPracticeICDCodes, boolean canEditPracticeSurgeryScreens,
			boolean hasPracticeAdministratorPermissions, boolean makeThisUserInvisible,
			boolean canEditClinicalDecisionSupport, boolean canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email) throws Exception {

		storeUrl = driver.getCurrentUrl();

		driver = openNewWindow(1);

		driver.get(handleURL(storeUrl));
		Thread.sleep(2000);
		performClinicSiteOperationForAllProvider(selectAll, fNameForOneUserProfile, clinicSite);

		driver.close();

		handleWindow();
		Thread.sleep(2000);

		loginName = new PgUserManagement(driver, wait, builder).createProvider(role, providerType, aciUserRole,
				selectDegree, mustHaveSupervisingDoctor, firstName, middleName, lastName, initials,
				canEditPracticeCPTCodes, canEditPracticeICDCodes, canEditPracticeSurgeryScreens,
				hasPracticeAdministratorPermissions, makeThisUserInvisible, canEditClinicalDecisionSupport,
				canEditPracticeContactLenses, practiceManagementId, pmSystemReferralCode, doctorNumber, providerNPI,
				providerTaxID, providerERXUsername, providerRXLicense, primarySpecialty, secondarySpecialty,
				thirdSpecialty, clinicSitesAssociatedWithThisUser, loginName, assignPassword, email);

		System.out.println(loginName);

		// performUserMgtOperation(fNameForOneUserProfile);

		storeUrl = driver.getCurrentUrl();

		driver = openNewWindow(1);

		driver.get(handleURL(storeUrl));
		Thread.sleep(2000);
		perfromClinicSiteOperationForOneProvider(fNameForOneUserProfile, clinicSite);

		driver.close();

		handleWindow();

		performUserMgtOperationForOneProvider("ankitTestprovider01116");

	}

	public WebDriver openNewWindow(int i) throws Exception {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(i));

		return driver;
	}

	public String handleURL(String storeUrl) throws Exception {

		int v = storeUrl.indexOf("SledgeHammer/");
		String val = storeUrl.substring(0, v + 13);
		newUrl = val.concat("clinicSite/list");
		System.out.println(newUrl);
		return newUrl;
	}

	public void performClinicSiteOperationForAllProvider(boolean selectAll, String fNameForOneUserProfile,
			String clinicSite) throws Exception {
		Thread.sleep(2000);
		clickOnAssociateUsersWithSites.click();

		if (!clickOnSelectAll.isSelected() && selectAll) {
			clickOnSelectAll.click();
		}
		Thread.sleep(2000);
		String[] spliteClinicSite = clinicSite.split(",");

		int length = clinicSite.split(",").length;
		System.out.println(length);

		for (int i = 0; i < length;) {
			if (selectClinicSiteName.get(i).getText().equalsIgnoreCase(spliteClinicSite[i])) {
				i = i + 1;
				driver.findElement(By.xpath(".//table[@id=\"clinicSiteTable\"]/tbody/tr[" + i + "]/td")).click();
			}

		}

		clickOnDoneButton.click();

	}

//	public void performUserMgtOperation(String fNameForOneUserProfile) throws Exception {
//		boolean value = false;
//		clickOnUserMgt.click();
//
//		Thread.sleep(3000);
//		new PageResidentWorkflow(driver, wait, builder).editProvider(fNameForOneUserProfile);

//		Thread.sleep(2000);
//		for (WebElement get_ClinicSiteSelection : getClinicSiteSelection) {
//			value = get_ClinicSiteSelection.isEnabled();
//			System.out.println(value);
//		}
//
//		if (value == false) {
//			clickOnClose.click();
//		}
	// }

	public void perfromClinicSiteOperationForOneProvider(String fNameForOneUserProfile, String clinicSite)
			throws Exception {
		Thread.sleep(2000);
		clickOnAssociateUsersWithSites.click();

		Thread.sleep(3000);
		WebElement providerElement = driver.findElement(
				By.xpath("//table[@id=\"userTable\"]/tbody/tr/td[text()='" + " " + fNameForOneUserProfile + "']"));
		providerElement.click();

		String[] spliteClinicSite = clinicSite.split(",");

		Thread.sleep(2000);
		for (WebElement select_ClinicSiteName : selectClinicSiteName) {
			if (select_ClinicSiteName.getText().equalsIgnoreCase(spliteClinicSite[3])) {
				select_ClinicSiteName.click();
				break;

			}
		}
		clickOnDoneButton.click();
	}

	public void performUserMgtOperationForOneProvider(String fNameForOneUserProfile) throws Exception {
		Thread.sleep(2000);
		
		clickOnUserMgt.click();

		Thread.sleep(3000);
		new PageResidentWorkflow(driver, wait, builder).editProvider(fNameForOneUserProfile);
		
		Thread.sleep(2000);
		for (WebElement get_ClinicSiteSelection : getClinicSiteSelection) {
		boolean	value = get_ClinicSiteSelection.isEnabled();
			System.out.println(value);
		}

	}

	public void handleWindow() {
		for (String handles : driver.getWindowHandles()) {
			driver.switchTo().window(handles);
		}
	}
}
