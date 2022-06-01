package pages;

//import utilities.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//import com.sun.java.util.jar.pack.Package.File;

import config.ProjectSettings;
import utilities.XLConnect;

public class PgUserManagement {

	private WebDriver driver;
	private WebDriverWait wait;
	 private Actions builder;

	// Define Locater

	@FindBy(how = How.LINK_TEXT, using = "User Management")
	private WebElement clickOnUserMagmentLink;

	@FindBy(how = How.CSS, using = "#gwt-debug-addNewUserLinkAnchor")
	private WebElement clickOnaddNewUserBtn;

	@FindBy(how = How.ID, using = "gwt-debug-firstName")
	private WebElement fillTheFirstName;

	@FindBy(how = How.ID, using = "gwt-debug-middleName")
	private WebElement fillTheMiddleName;

	@FindBy(how = How.ID, using = "gwt-debug-lastName")
	private WebElement fillTheLastName;

	@FindBy(how = How.ID, using = "gwt-debug-initials")
	private WebElement fillTheIntialType;

	@FindBy(how = How.ID, using = "gwt-debug-txt-practice_mgmt_id")
	private WebElement clickOnPraticeMgtId;

	@FindBy(how = How.ID, using = "gwt-debug-txt-practice_mgmt_referral_id")
	private WebElement clickOnPraticeMgtRefferalId;

	@FindBy(how = How.ID, using = "gwt-debug-txt-doctorNo")
	private WebElement clickOnDoctorNo;

	@FindBy(how = How.ID, using = "gwt-debug-txt-npi")
	private WebElement clickOnNPI;

	@FindBy(how = How.ID, using = "gwt-debug-txt-taxidid")
	private WebElement clickTheTaxID;

	@FindBy(how = How.ID, using = "gwt-debug-txt-erxusername")
	private WebElement clickTheERXUserName;

	@FindBy(how = How.ID, using = "gwt-debug-txt-rx_license_number")
	private WebElement clickTheLicenseNumber;

	@FindBy(how = How.ID, using = "gwt-debug-loginBox")
	private WebElement clickTheLoginName;

	@FindBy(how = How.ID, using = "gwt-debug-passwordBox")
	private WebElement clickThePasswordBox;

	@FindBy(how = How.ID, using = "gwt-debug-repasswordBox")
	private WebElement clickTheConfirmPassword;

	@FindBy(how = How.ID, using = "gwt-debug-emailAddress")
	private WebElement clickTheEmailAddress;

	@FindBy(how = How.CSS, using = "#gwt-debug-saveButton > a")
	private WebElement clickOnsaveBtn;

	@FindBy(how = How.XPATH, using = "//*[text()='Show Invisible Users']")
	private WebElement clickOnInvisbleUser;

	public PgUserManagement(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder=builder;
		PageFactory.initElements(driver, this);

	}

	// create createUser function
	public String createProvider(String role, String providerType, String aciUserRole, String selectDegree,
			String mustHaveSupervisingDoctor, String firstName, String middleName, String lastName, String initials,
			boolean canEditPracticeCPTCodes, boolean canEditPracticeICDCodes, boolean canEditPracticeSurgeryScreens,
			boolean hasPracticeAdministratorPermissions, boolean makeThisUserInvisible,
			boolean canEditClinicalDecisionSupport, boolean canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email

	) throws InterruptedException {
		Thread.sleep(2 * 1000);

		ensureElementToBeClickAble(clickOnUserMagmentLink);
		clickOnUserMagmentLink.click();

		ensureElementToBeClickAble(clickOnaddNewUserBtn);
		clickOnaddNewUserBtn.click();

		// call create function

		loginName=create(role, providerType, aciUserRole, selectDegree, mustHaveSupervisingDoctor, firstName, middleName,
				lastName, initials, canEditPracticeCPTCodes, canEditPracticeICDCodes, canEditPracticeSurgeryScreens,
				hasPracticeAdministratorPermissions, makeThisUserInvisible, canEditClinicalDecisionSupport,
				canEditPracticeContactLenses, practiceManagementId, pmSystemReferralCode, doctorNumber, providerNPI,
				providerTaxID, providerERXUsername, providerRXLicense, primarySpecialty, secondarySpecialty,
				thirdSpecialty, clinicSitesAssociatedWithThisUser, loginName, assignPassword, email);
		
		        // clickOnsaveBtn.clear();
				ensureElementToBeClickAble(clickOnsaveBtn);
				clickOnsaveBtn.click();

				return loginName;
	}

	// create create function
	public String create(String role, String providerType, String aciUserRole, String selectDegree,
			String mustHaveSupervisingDoctor, String firstName, String middleName, String lastName, String initials,
			boolean canEditPracticeCPTCodes, boolean canEditPracticeICDCodes, boolean canEditPracticeSurgeryScreens,
			boolean hasPracticeAdministratorPermissions, boolean makeThisUserInvisible,
			boolean canEditClinicalDecisionSupport, boolean canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email) throws InterruptedException {
		// XLConnect.getXLSXData("‪C:/Users/Ankitp1/Desktop/Ankit/IngetrityTestData.xlsx",
		// "UserManagment", 1, 1);
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// LocalDateTime now = LocalDateTime.now();
		// String time = dtf.format(now);

		Thread.sleep(3000);
		if (role != null && !role.equals("")) {
			By roleType = By.id("gwt-debug-userTypeList");
			ensureElementToBeClickable(roleType);
			Select roleTypeSelector = new Select(driver.findElement(roleType));
			roleTypeSelector.selectByVisibleText(role);
		}
		Thread.sleep(4000);
		if (providerType != null && !providerType.equals("")) {
			By providerType1 = By.id("gwt-debug-physician-type");

			ensureElementToBeClickable(providerType1);
			Select providerTypeSelector = new Select(driver.findElement(providerType1));
			providerTypeSelector.selectByVisibleText(providerType);

		}
		Thread.sleep(2000);
		if (aciUserRole != null && !aciUserRole.equals("")) {
			By aciUserRoleType = By.id("gwt-debug-physician-role");
			ensureElementToBeClickable(aciUserRoleType);
			Select aciUserRoleTypeSelector = new Select(driver.findElement(aciUserRoleType));
			aciUserRoleTypeSelector.selectByVisibleText(aciUserRole);
		}
		Thread.sleep(2000);
		if (selectDegree != null && !selectDegree.equals("")) {
			By selectDegreeType = By.id("gwt-debug-physician-degree");
			ensureElementToBeClickable(selectDegreeType);
			Select selectDegreeTypeSelector = new Select(driver.findElement(selectDegreeType));
			selectDegreeTypeSelector.selectByVisibleText(selectDegree);
		}
//		Thread.sleep(2000);
//		if (mustHaveSupervisingDoctor != null && !mustHaveSupervisingDoctor.equals("")) {
//			By mustHaveSupervisingDoctorType = By
//					.cssSelector("#gwt-debug-otherUserTypeDetails > div:nth-child(4) > select");
//			ensureElementToBeClickable(mustHaveSupervisingDoctorType);
//			Select mustHaveSupervisingDoctorTypeSelector = new Select(
//					driver.findElement(mustHaveSupervisingDoctorType));
//			mustHaveSupervisingDoctorTypeSelector.selectByVisibleText(mustHaveSupervisingDoctor);
//		}

		Random r1 = new Random();
		int n = 100 + r1.nextInt(100);
		String Name1 = Integer.toString(n);
		fillTheFirstName.clear();
		ensureElementToBeClickAble(fillTheFirstName);
		fillTheFirstName.sendKeys(firstName.concat(Name1));
		
		
		fillTheMiddleName.clear();
		ensureElementToBeClickAble(fillTheMiddleName);
		fillTheMiddleName.sendKeys(middleName);

		fillTheLastName.clear();
		ensureElementToBeClickAble(fillTheLastName);
		fillTheLastName.sendKeys(lastName);
		
		
		fillTheIntialType.clear();
		ensureElementToBeClickAble(fillTheIntialType);
		fillTheIntialType.sendKeys(initials);

		By canEditPracticeCPTCodesType = By
				.cssSelector("#gwt-debug-userDetailsPanel > div > div:nth-child(3) > div:nth-child(1) > span > input");
		ensureElementToBeClickable(canEditPracticeCPTCodesType);
		WebElement element = driver.findElement(canEditPracticeCPTCodesType);
		if (canEditPracticeCPTCodes)
			element.click();

		By hasPracticeAdministratorPermissionsType = By
				.cssSelector("#gwt-debug-userDetailsPanel > div > div:nth-child(3) > div:nth-child(2) > span > input");
		ensureElementToBeClickable(hasPracticeAdministratorPermissionsType);
		WebElement element3 = driver.findElement(hasPracticeAdministratorPermissionsType);
		if (hasPracticeAdministratorPermissions)
			element3.click();

		By canEditPracticeICDCodesType = By
				.cssSelector("#gwt-debug-userDetailsPanel > div > div:nth-child(4) > div:nth-child(1) > span > input");
		ensureElementToBeClickable(canEditPracticeICDCodesType);
		WebElement element1 = driver.findElement(canEditPracticeCPTCodesType);
		if (canEditPracticeICDCodes)
			element1.click();

		By makeThisUserInvisibleType = By
				.cssSelector("#gwt-debug-userDetailsPanel > div > div:nth-child(4) > div:nth-child(2) > span > input");
		ensureElementToBeClickable(makeThisUserInvisibleType);
		WebElement element4 = driver.findElement(makeThisUserInvisibleType);
		if (makeThisUserInvisible)
			element4.click();

		By canEditPracticeSurgeryScreensType = By
				.cssSelector("#gwt-debug-userDetailsPanel > div > div:nth-child(5) > div:nth-child(1) > span > input");
		ensureElementToBeClickable(canEditPracticeSurgeryScreensType);
		WebElement element2 = driver.findElement(canEditPracticeSurgeryScreensType);
		if (canEditPracticeSurgeryScreens)
			element2.click();

		By canEditClinicalDecisionSupportType = By
				.cssSelector("#gwt-debug-userDetailsPanel > div > div:nth-child(5) > div:nth-child(2) > span > input");
		ensureElementToBeClickable(canEditClinicalDecisionSupportType);
		WebElement element5 = driver.findElement(canEditClinicalDecisionSupportType);
		if (canEditClinicalDecisionSupport)
			element5.click();

		By canEditPracticeContactLensesType = By
				.cssSelector("#gwt-debug-userDetailsPanel > div > div:nth-child(5) > div:nth-child(3) > span > input");
		ensureElementToBeClickable(canEditPracticeContactLensesType);
		WebElement element6 = driver.findElement(canEditPracticeContactLensesType);
		if (canEditPracticeContactLenses)
			element6.click();

		Random random = new Random();
		int m = 10000 + random.nextInt(900000);
		practiceManagementId = Integer.toString(m);
		clickOnPraticeMgtId.clear();
		ensureElementToBeClickAble(clickOnPraticeMgtId);
		clickOnPraticeMgtId.sendKeys(practiceManagementId);

		Random random1 = new Random();
		int n1 = 10000 + random1.nextInt(900000);
		pmSystemReferralCode = Integer.toString(n1);
		clickOnPraticeMgtRefferalId.clear();
		ensureElementToBeClickAble(clickOnPraticeMgtRefferalId);
		clickOnPraticeMgtRefferalId.sendKeys(pmSystemReferralCode);

		random = new Random();
		int dcNo = 111 + random.nextInt(796);
		doctorNumber = Integer.toString(dcNo);
		clickOnDoctorNo.clear();
		ensureElementToBeClickAble(clickOnDoctorNo);
		clickOnDoctorNo.sendKeys(doctorNumber);

		clickOnNPI.clear();
		ensureElementToBeClickAble(clickOnNPI);
		clickOnNPI.sendKeys(providerNPI);

		clickTheTaxID.clear();
		ensureElementToBeClickAble(clickTheTaxID);
		clickTheTaxID.sendKeys(providerTaxID);

		clickTheERXUserName.clear();
		ensureElementToBeClickAble(clickTheERXUserName);
		clickTheERXUserName.sendKeys(providerERXUsername);

		clickTheLicenseNumber.clear();
		ensureElementToBeClickAble(clickTheLicenseNumber);
		clickTheLicenseNumber.sendKeys(providerRXLicense);

		if (primarySpecialty != null && !primarySpecialty.equals("")) {
			By primarySpecialtyType = By.id("gwt-debug-OtherTextFieldComboBox");
			ensureElementToBeClickable(primarySpecialtyType);
			Select primarySpecialtyTypeSelector = new Select(driver.findElements(primarySpecialtyType).get(0));
			if (primarySpecialtyTypeSelector.getOptions().size() > 0)
				primarySpecialtyTypeSelector.selectByVisibleText(primarySpecialty);
		}
		if (secondarySpecialty != null && !secondarySpecialty.equals("")) {
			By secondarySpecialtyType = By.id("gwt-debug-OtherTextFieldComboBox");
			ensureElementToBeClickable(secondarySpecialtyType);
			Select secondarySpecialtyTypeSelector = new Select(driver.findElements(secondarySpecialtyType).get(1));
			if (secondarySpecialtyTypeSelector.getOptions().size() > 0)
				secondarySpecialtyTypeSelector.selectByVisibleText(secondarySpecialty);
		}
		if (thirdSpecialty != null && !thirdSpecialty.equals("")) {
			By thirdSpecialtyType = By.id("gwt-debug-OtherTextFieldComboBox");
			ensureElementToBeClickable(thirdSpecialtyType);
			Select thirdSpecialtyTypeSelector = new Select(driver.findElements(thirdSpecialtyType).get(2));
			if (thirdSpecialtyTypeSelector.getOptions().size() > 0)
				thirdSpecialtyTypeSelector.selectByVisibleText(thirdSpecialty);
		}

		if (clinicSitesAssociatedWithThisUser != null && !clinicSitesAssociatedWithThisUser.equals("")) {
			By clinicSitesAssociatedWithThisUserType = By.id("gwt-debug-clinicSiteCombo");
			ensureElementToBeClickable(clinicSitesAssociatedWithThisUserType);
			Select clinicSitesAssociatedWithThisUserTypeSelector = new Select(
					driver.findElement(clinicSitesAssociatedWithThisUserType));
			if (clinicSitesAssociatedWithThisUserTypeSelector.getOptions().size() > 0)
				clinicSitesAssociatedWithThisUserTypeSelector.selectByVisibleText(clinicSitesAssociatedWithThisUser);
		}
		Random r = new Random();
		int randomValue = 111 + r.nextInt(119);
		String logInName = Integer.toString(randomValue);
		firstName = firstName.trim();
		clickTheLoginName.clear();
		ensureElementToBeClickAble(clickTheLoginName);
		loginName = firstName.concat(lastName);
		clickTheLoginName.sendKeys(loginName.concat(logInName));
		//clickTheLoginName.sendKeys("gjprovider4");
		loginName=loginName.concat(logInName);
		
		clickThePasswordBox.clear();
		ensureElementToBeClickAble(clickThePasswordBox);
		clickThePasswordBox.sendKeys(assignPassword);

		clickTheConfirmPassword.clear();
		ensureElementToBeClickAble(clickTheConfirmPassword);
		clickTheConfirmPassword.sendKeys(assignPassword);

		clickTheEmailAddress.clear();
		ensureElementToBeClickAble(clickTheEmailAddress);
		clickTheEmailAddress.sendKeys(email);

		
		//
		// //clickOnInvisbleUser.clear();
		// ensureElementToBeClickAble(clickOnInvisbleUser);
		// clickOnInvisbleUser.click();
		// Thread.sleep(5000);

		// By firstNameBox = By.xpath("//*[text()='" + loginName + "']");
		// String actual = driver.findElement(firstNameBox).getText();
		// assertEquals(actual, loginName);
		// driver.findElement(firstNameBox).click();
return loginName;
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickAble(WebElement element) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
