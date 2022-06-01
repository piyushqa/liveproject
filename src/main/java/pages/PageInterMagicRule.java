package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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

public class PageInterMagicRule {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	boolean checkValue;
	String InterMagicName;

	@FindBy(how = How.LINK_TEXT, using = "User Management")
	private WebElement clickOnUserMagmentLink;

	@FindBy(how = How.CSS, using = "#gwt-debug-addNewUserLinkAnchor")
	private WebElement clickOnaddNewUserBtn;

	@FindBy(how = How.ID, using = "gwt-debug-userTypeList")
	private WebElement selectRole;

	@FindBy(how = How.ID, using = "gwt-debug-job-title")
	private WebElement select_JobTitle;

	@FindBy(how = How.ID, using = "gwt-debug-physician-type")
	private WebElement selectJobTitle;

	@FindBy(how = How.ID, using = "gwt-debug-physician-role")
	private WebElement selectUserRole;

	@FindBy(how = How.ID, using = "gwt-debug-physician-degree")
	private WebElement selectDegre;

	@FindBy(how = How.ID, using = "gwt-debug-firstName")
	private WebElement fillTheFirstName;

	@FindBy(how = How.ID, using = "gwt-debug-middleName")
	private WebElement fillTheMiddleName;

	@FindBy(how = How.ID, using = "gwt-debug-lastName")
	private WebElement fillTheLastName;

	@FindBy(how = How.ID, using = "gwt-debug-initials")
	private WebElement fillTheIntialType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(3) > div:nth-child(1) > span > input")
	private WebElement canEditPracticeCPTCodesType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(3) > div:nth-child(2) > span > input")
	private WebElement hasPracticeAdministratorPermissionsType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(4) > div:nth-child(1) > span > input")
	private WebElement canEditPracticeICDCodesType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(4) > div:nth-child(2) > span > input")
	private WebElement makeThisUserInvisibleType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(5) > div:nth-child(1) > span > input")
	private WebElement canEditPracticeSurgeryScreensType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(5) > div:nth-child(2) > span > input")
	private WebElement canEditClinicalDecisionSupportType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(5) > div:nth-child(3) > span > input")
	private WebElement canEditPracticeContactLensesType;

	@FindBy(how = How.CSS, using = "#gwt-debug-userDetailsPanel > div > div:nth-child(5)>div:nth-child(5)>span>input")
	private WebElement clickOnInterMagic;

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

	@FindBy(how = How.ID, using = "gwt-debug-OtherTextFieldComboBox")
	private List<WebElement> selectPrimarySpecality;

	@FindBy(how = How.ID, using = "gwt-debug-OtherTextFieldComboBox")
	private List<WebElement> selectSecondarySpecality;

	@FindBy(how = How.ID, using = "gwt-debug-OtherTextFieldComboBox")
	private List<WebElement> selectThirdSpecality;

	@FindBy(how = How.ID, using = "gwt-debug-clinicSiteCombo")
	private WebElement selectClinicSitesAssociatedWithThisUserType;

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

	@FindBy(how = How.LINK_TEXT, using = "Configuration")
	private WebElement clickOnConfigurationLink;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	private List<WebElement> selectNotifyProvider;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	private List<WebElement> clickOnInterMagicRule;

	@FindBy(how = How.CSS, using = "div.master-rule-plus>a>svg>path")
	private WebElement clickOnMasterRule;

	@FindBy(how = How.CSS, using = "div.magic-wrapper>div>div>div>a>svg:nth-child(1)>path")
	private List<WebElement> clickOnTriggerAndActionPlus;

	@FindBy(how = How.CSS, using = "div.left-side-action-component>div>div>a>Svg>path")
	private WebElement clickOnActionPlusIcon;

	@FindBy(how = How.CSS, using = "div.gwt-header-panel-component>select>option")
	private List<WebElement> selectTriggerType;

	@FindBy(how = How.CSS, using = "div.plan-details>div>div>div>div>div:nth-child(3)>div:nth-child(1)>div:nth-child(2)>div")
	private List<WebElement> selectDiagnosisCategory;

	@FindBy(how = How.CSS, using = "div.plan-details>div>div>div>div>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)>div")
	private List<WebElement> selectDiagnosisCategory2;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[3]/div[4]/div[2]/div[1]/div")
	private List<WebElement> selectDiagnosisCategory3;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div[3]")
	private WebElement clickOnICD10DropDown;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/div/div[2]/div/div")
	private List<WebElement> selectICD10;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[3]/div[1]/div[2]/div[1]/div[2]/div")
	private List<WebElement> SelectEye;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div")
	private List<WebElement> selectGlaucomaSeverity;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[3]/div[1]/div[2]/div[3]/div[2]/div")
	private List<WebElement> selectGlaucomaStability;

	@FindBy(how = How.CSS, using = "div.gwt-header-panel-component>select>option")
	private List<WebElement> selectActionType;

	@FindBy(how = How.CSS, using = "div#gwt-debug-provider>table>tbody>tr:nth-child(2)>td>div>table>tbody>tr>td>div")
	private List<WebElement> selectProvider;

	@FindBy(how = How.CSS, using = "div#gwt-debug-timeFrame>table>tbody>tr:nth-child(2)>td>div>table>tbody>tr>td>div")
	private List<WebElement> selectTimeFrame;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-visitComments")
	private WebElement fillTextArea;

	@FindBy(how = How.XPATH, using = ".//input[@placeholder=\"Rule Name\"]")
	private WebElement enterInterMagicHolderName;

	@FindBy(how = How.CSS, using = "div.gwt-footer-panel-component>button:nth-child(3)")
	private WebElement clickOnSubmitAndClose;

	@FindBy(how = How.XPATH, using = ".//input[@placeholder=\"Rule Search\"]")
	private WebElement fillTheValueInRuleSearch;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/table[2]/div/div/tbody/tr/td[1]/a")
	private List<WebElement> getTextOfRuleNameOfMasterRule;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/table[2]/div/div/tbody/tr/td/label/div")
	private List<WebElement> clickTheMenuIcon;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]/select[1]/option")
	private List<WebElement> selectDisplayTriggrType;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]/select[2]/option")
	private List<WebElement> selectDisplayActionType;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Done')]")
	private List<WebElement> clickOnDone;

	@FindBy(how = How.CSS, using = "div#gwt-debug-saveAndAddAnother>a")
	private WebElement clickOnSaveAndAddAnother;

	@FindBy(how = How.CSS, using = "div#gwt-debug-selectCategory>div:nth-child(2)>div>div>div")
	private List<WebElement> select_PlanLibrary;

	@FindBy(how = How.CSS, using = "div#gwt-debug-selectItem>div:nth-child(2)>div>div>div")
	private List<WebElement> select_Retina;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-libraryText")
	private WebElement fillCommentsInPlan;

	@FindBy(xpath = ".//textarea[@id=\"gwt-debug-comments\"]")
	private WebElement fillComments;

	// Fill order eye test

	@FindBy(how = How.CSS, using = "#gwt-debug-orderLabTest-Category > table>tbody > tr:nth-child(2)> td > div>table#gwt-debug-PicklistTable-dataTable>tbody>tr>td>div")
	private List<WebElement> selectEyeTestCategory;

	@FindBy(how = How.CSS, using = "#gwt-debug-orderLabTest-Item> table>tbody > tr:nth-child(2)> td > div>table#gwt-debug-PicklistTable-dataTable>tbody>tr>td>div")
	private List<WebElement> selectEyeTest;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-orderEyeComments")
	private WebElement fillCommentOfOrderEyeTest;

	@FindBy(how = How.CSS, using = "div#gwt-debug-labTests>table>tbody tr:nth-child(2)> td > div>table#gwt-debug-PicklistTable-dataTable>tbody>tr>td>div")
	private List<WebElement> selectLabTest1;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-orderComments")
	private WebElement fillCommentsOfOrderComments;

	// @FindBy(how=How.)

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */

	public PageInterMagicRule(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageInterMagicRule.this);

	}

	public void verifyInterMagicRule(String role, String providerType, String aciUserRole, String selectDegree,
			String mustHaveSupervisingDoctor, String firstName, String middleName, String lastName, String initials,
			boolean canEditPracticeCPTCodes, boolean canEditPracticeICDCodes, boolean canEditPracticeSurgeryScreens,
			boolean hasPracticeAdministratorPermissions, boolean makeThisUserInvisible,
			boolean canEditClinicalDecisionSupport, boolean canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email, boolean interMagicRule, String SelectTriggerType, String Category1, String Category2,
			String Category3, String ICD, String Eye, String GlaucomaSeverity, String GlaucomaStability,
			String SelectActonType, String SpecifyProvider, String SpecifyTimeframe, String Comments,
			String TrigeerType, String TriggerAction, String InterMagicRuleName, String SelectActonType2,
			String planLiberary, String retina, String SelectActonType3, String radiologyTest, String otherTest,
			String SelectActonType4, String selectLabTest, String SelectActonType5, String eyeTestCategory,
			String eyeTest) throws Exception {

		ensureElememtToBeClickable(clickOnUserMagmentLink);
		clickOnUserMagmentLink.click();

		Thread.sleep(3000);
		ensureElememtToBeClickable(clickOnaddNewUserBtn);
		clickOnaddNewUserBtn.click();

		switch (role) {
		case "Provider":
			Thread.sleep(3000);
			// ensureElememtToBeClickable(clickOnInterMagic);
			boolean checkValue = clickOnInterMagic.isEnabled();
			System.out.println(checkValue);
			if (checkValue == false) {
				performProviderOperation(role, providerType, aciUserRole, selectDegree, firstName, middleName, lastName,
						initials, canEditPracticeCPTCodes, canEditPracticeICDCodes, canEditPracticeSurgeryScreens,
						hasPracticeAdministratorPermissions, makeThisUserInvisible, canEditClinicalDecisionSupport,
						canEditPracticeContactLenses, practiceManagementId, pmSystemReferralCode, doctorNumber,
						providerNPI, providerTaxID, providerERXUsername, providerRXLicense, primarySpecialty,
						secondarySpecialty, thirdSpecialty, clinicSitesAssociatedWithThisUser, loginName,
						assignPassword, email, interMagicRule);

			} else {
				Reporter.log("Element is not enable");
			}
			break;
		case "Practice Administrator":

		{
			// for (int i = 1; i <= 2; i++) {
			performAdministrativeOperation(role, providerType, aciUserRole, firstName, middleName, lastName, initials,
					canEditPracticeCPTCodes, canEditPracticeICDCodes, canEditPracticeSurgeryScreens,
					hasPracticeAdministratorPermissions, makeThisUserInvisible, canEditClinicalDecisionSupport,
					canEditPracticeContactLenses, practiceManagementId, pmSystemReferralCode, doctorNumber, providerNPI,
					providerTaxID, providerERXUsername, providerRXLicense, primarySpecialty, secondarySpecialty,
					thirdSpecialty, clinicSitesAssociatedWithThisUser, loginName, assignPassword, email,
					interMagicRule);
			// }

		}

			break;
		case "Technician":
			break;
		default:
			System.out.println("");
		}

		Thread.sleep(5000);
		ensureElememtToBeClickable(clickOnConfigurationLink);
		clickOnConfigurationLink.click();

		matchInterMagicOnConfiguration();

		addMasterRuleWithTriggerAndAction(SelectTriggerType, Category1, Category2, Category3, ICD, Eye,
				GlaucomaSeverity, GlaucomaStability, SelectActonType, SpecifyProvider, SpecifyTimeframe, Comments,
				TrigeerType, TriggerAction, InterMagicRuleName, SelectActonType2, planLiberary, retina,
				SelectActonType3, radiologyTest, otherTest, SelectActonType4, selectLabTest, SelectActonType5,
				eyeTestCategory, eyeTest);
	}

	public void performProviderOperation(String role, String providerType, String aciUserRole, String selectDegree,
			String firstName, String middleName, String lastName, String initials, boolean canEditPracticeCPTCodes,
			boolean canEditPracticeICDCodes, boolean canEditPracticeSurgeryScreens,
			boolean hasPracticeAdministratorPermissions, boolean makeThisUserInvisible,
			boolean canEditClinicalDecisionSupport, boolean canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email, boolean interMagicRule) throws Exception {

		Thread.sleep(3000);
		if (role != null && !role.equals("")) {
			Select roleTypeSelector = new Select(selectRole);
			roleTypeSelector.selectByVisibleText(role);
		}
		Thread.sleep(4000);
		if (providerType != null && !providerType.equals("")) {
			Select providerTypeSelector = new Select(selectJobTitle);
			providerTypeSelector.selectByVisibleText(providerType);

		}
		Thread.sleep(2000);
		if (aciUserRole != null && !aciUserRole.equals("")) {
			Select aciUserRoleTypeSelector = new Select(selectUserRole);
			aciUserRoleTypeSelector.selectByVisibleText(aciUserRole);
		}
		Thread.sleep(2000);
		if (selectDegree != null && !selectDegree.equals("")) {
			Select selectDegreeTypeSelector = new Select(selectDegre);
			selectDegreeTypeSelector.selectByVisibleText(selectDegree);
		}
//		Thread.sleep(2000);
//		if (mustHaveSupervisingDoctor != null && !mustHaveSupervisingDoctor.equals("")) {
//			By mustHaveSupervisingDoctorType = By
//					.cssSelector("#gwt-debug-otherUserTypeDetails > div:nth-child(4) > select");
//			ensureElememtToBeClickable(mustHaveSupervisingDoctorType);
//			Select mustHaveSupervisingDoctorTypeSelector = new Select(
//					driver.findElement(mustHaveSupervisingDoctorType));
//			mustHaveSupervisingDoctorTypeSelector.selectByVisibleText(mustHaveSupervisingDoctor);
//		}

		Random r1 = new Random();
		int n = 100 + r1.nextInt(100);
		String Name1 = Integer.toString(n);
		fillTheFirstName.clear();
		ensureElememtToBeClickable(fillTheFirstName);
		fillTheFirstName.sendKeys(firstName.concat(Name1));

		fillTheMiddleName.clear();
		ensureElememtToBeClickable(fillTheMiddleName);
		fillTheMiddleName.sendKeys(middleName);

		fillTheLastName.clear();
		ensureElememtToBeClickable(fillTheLastName);
		fillTheLastName.sendKeys(lastName);

		fillTheIntialType.clear();
		ensureElememtToBeClickable(fillTheIntialType);
		fillTheIntialType.sendKeys(initials);

		if (!canEditPracticeCPTCodesType.isSelected() && canEditPracticeCPTCodes)
			canEditPracticeCPTCodesType.click();

		if (!hasPracticeAdministratorPermissionsType.isSelected() && canEditPracticeICDCodes)
			hasPracticeAdministratorPermissionsType.click();

		if (!canEditPracticeICDCodesType.isSelected() && canEditPracticeICDCodes)
			canEditPracticeICDCodesType.click();

		if (!makeThisUserInvisibleType.isSelected() && makeThisUserInvisible)
			makeThisUserInvisibleType.click();

		if (!canEditPracticeSurgeryScreensType.isSelected() && canEditPracticeSurgeryScreens)
			canEditPracticeSurgeryScreensType.click();

		if (!canEditClinicalDecisionSupportType.isSelected() && canEditClinicalDecisionSupport)
			canEditClinicalDecisionSupportType.click();

		if (!canEditPracticeContactLensesType.isSelected() && canEditPracticeCPTCodes)
			canEditPracticeContactLensesType.click();

		performInterMagicOperation(interMagicRule);

		Random random = new Random();
		int m = 10000 + random.nextInt(900000);
		practiceManagementId = Integer.toString(m);
		clickOnPraticeMgtId.clear();
		ensureElememtToBeClickable(clickOnPraticeMgtId);
		clickOnPraticeMgtId.sendKeys(practiceManagementId);

		Random random1 = new Random();
		int n1 = 10000 + random1.nextInt(900000);
		pmSystemReferralCode = Integer.toString(n1);
		clickOnPraticeMgtRefferalId.clear();
		ensureElememtToBeClickable(clickOnPraticeMgtRefferalId);
		clickOnPraticeMgtRefferalId.sendKeys(pmSystemReferralCode);

		random = new Random();
		int dcNo = 287 + random.nextInt(6451);
		doctorNumber = Integer.toString(dcNo);
		clickOnDoctorNo.clear();
		ensureElememtToBeClickable(clickOnDoctorNo);
		clickOnDoctorNo.sendKeys(doctorNumber);

		clickOnNPI.clear();
		ensureElememtToBeClickable(clickOnNPI);
		clickOnNPI.sendKeys(providerNPI);

		clickTheTaxID.clear();
		ensureElememtToBeClickable(clickTheTaxID);
		clickTheTaxID.sendKeys(providerTaxID);

		clickTheERXUserName.clear();
		ensureElememtToBeClickable(clickTheERXUserName);
		clickTheERXUserName.sendKeys(providerERXUsername);

		clickTheLicenseNumber.clear();
		ensureElememtToBeClickable(clickTheLicenseNumber);
		clickTheLicenseNumber.sendKeys(providerRXLicense);

		if (primarySpecialty != null && !primarySpecialty.equals("")) {
			Select primarySpecialtyTypeSelector = new Select(selectPrimarySpecality.get(0));
			if (primarySpecialtyTypeSelector.getOptions().size() > 0)
				primarySpecialtyTypeSelector.selectByVisibleText(primarySpecialty);
		}
		if (secondarySpecialty != null && !secondarySpecialty.equals("")) {
			Select secondarySpecialtyTypeSelector = new Select(selectSecondarySpecality.get(1));
			if (secondarySpecialtyTypeSelector.getOptions().size() > 0)
				secondarySpecialtyTypeSelector.selectByVisibleText(secondarySpecialty);
		}
		if (thirdSpecialty != null && !thirdSpecialty.equals("")) {
			Select thirdSpecialtyTypeSelector = new Select(selectThirdSpecality.get(2));
			if (thirdSpecialtyTypeSelector.getOptions().size() > 0)
				thirdSpecialtyTypeSelector.selectByVisibleText(thirdSpecialty);
		}

		if (clinicSitesAssociatedWithThisUser != null && !clinicSitesAssociatedWithThisUser.equals("")) {
			Select clinicSitesAssociatedWithThisUserTypeSelector = new Select(
					selectClinicSitesAssociatedWithThisUserType);
			if (clinicSitesAssociatedWithThisUserTypeSelector.getOptions().size() > 0)
				clinicSitesAssociatedWithThisUserTypeSelector.selectByVisibleText(clinicSitesAssociatedWithThisUser);
		}
		Random r = new Random();
		int randomValue = 111 + r.nextInt(477);
		String logInName = Integer.toString(randomValue);
		firstName = firstName.trim();
		clickTheLoginName.clear();
		ensureElememtToBeClickable(clickTheLoginName);
		loginName = firstName.concat(lastName);
		clickTheLoginName.sendKeys(loginName.concat(logInName));
//		clickTheLoginName.sendKeys(loginName);

		clickThePasswordBox.clear();
		ensureElememtToBeClickable(clickThePasswordBox);
		clickThePasswordBox.sendKeys(assignPassword);

		clickTheConfirmPassword.clear();
		ensureElememtToBeClickable(clickTheConfirmPassword);
		clickTheConfirmPassword.sendKeys(assignPassword);

		clickTheEmailAddress.clear();
		ensureElememtToBeClickable(clickTheEmailAddress);
		clickTheEmailAddress.sendKeys(email);

		ensureElememtToBeClickable(clickOnsaveBtn);
		clickOnsaveBtn.click();

	}

	public void performAdministrativeOperation(String role, String providerType, String aciUserRole, String firstName,
			String middleName, String lastName, String initials, boolean canEditPracticeCPTCodes,
			boolean canEditPracticeICDCodes, boolean canEditPracticeSurgeryScreens,
			boolean hasPracticeAdministratorPermissions, boolean makeThisUserInvisible,
			boolean canEditClinicalDecisionSupport, boolean canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email, boolean interMagicRule) throws Exception {

		Thread.sleep(4000);
		if (role != null && !role.equals("")) {
			Select roleTypeSelector = new Select(selectRole);
			roleTypeSelector.selectByVisibleText(role);
		}

		Thread.sleep(3000);
		boolean checkValue = clickOnInterMagic.isEnabled();

		System.out.println(checkValue);
		Thread.sleep(3000);

		boolean checkSelection = clickOnInterMagic.isSelected();
		System.out.println(checkSelection);

		if (checkValue == checkSelection) {

//		Thread.sleep(4000);
//		if (providerType != null && !providerType.equals("")) {
//			Select providerTypeSelector = new Select(selectJobTitle);
//			providerTypeSelector.selectByVisibleText(providerType);
//
//		}
//			Thread.sleep(2000);
//			if (aciUserRole != null && !aciUserRole.equals("")) {
//				Select aciUserRoleTypeSelector = new Select(selectUserRole);
//				aciUserRoleTypeSelector.selectByVisibleText(aciUserRole);
//			}

			Random r1 = new Random();
			int n = 100 + r1.nextInt(100);
			String Name1 = Integer.toString(n);
			fillTheFirstName.clear();
			ensureElememtToBeClickable(fillTheFirstName);
			fillTheFirstName.sendKeys(firstName.concat(Name1));

			fillTheMiddleName.clear();
			ensureElememtToBeClickable(fillTheMiddleName);
			fillTheMiddleName.sendKeys(middleName);

			fillTheLastName.clear();
			ensureElememtToBeClickable(fillTheLastName);
			fillTheLastName.sendKeys(lastName);

			fillTheIntialType.clear();
			ensureElememtToBeClickable(fillTheIntialType);
			fillTheIntialType.sendKeys(initials);

			if (!canEditPracticeCPTCodesType.isSelected() && canEditPracticeCPTCodes)
				canEditPracticeCPTCodesType.click();

			if (!hasPracticeAdministratorPermissionsType.isSelected() && canEditPracticeICDCodes)
				hasPracticeAdministratorPermissionsType.click();

			if (!canEditPracticeICDCodesType.isSelected() && canEditPracticeICDCodes)
				canEditPracticeICDCodesType.click();

			if (!makeThisUserInvisibleType.isSelected() && makeThisUserInvisible)
				makeThisUserInvisibleType.click();

			if (!canEditPracticeSurgeryScreensType.isSelected() && canEditPracticeSurgeryScreens)
				canEditPracticeSurgeryScreensType.click();

			if (!canEditClinicalDecisionSupportType.isSelected() && canEditClinicalDecisionSupport)
				canEditClinicalDecisionSupportType.click();

			if (!canEditPracticeContactLensesType.isSelected() && canEditPracticeCPTCodes)
				canEditPracticeContactLensesType.click();

			performInterMagicOperation(interMagicRule);

//			if (clinicSitesAssociatedWithThisUser != null && !clinicSitesAssociatedWithThisUser.equals("")) {
//				Select clinicSitesAssociatedWithThisUserTypeSelector = new Select(
//						selectClinicSitesAssociatedWithThisUserType);
//				if (clinicSitesAssociatedWithThisUserTypeSelector.getOptions().size() > 0)
//					clinicSitesAssociatedWithThisUserTypeSelector
//							.selectByVisibleText(clinicSitesAssociatedWithThisUser);
//			}
			Random r = new Random();
			int randomValue = 111 + r.nextInt(119);
			String logInName = Integer.toString(randomValue);
			firstName = firstName.trim();
			clickTheLoginName.clear();
			ensureElememtToBeClickable(clickTheLoginName);
			loginName = firstName.concat(lastName);
			clickTheLoginName.sendKeys(loginName.concat(logInName));
//		clickTheLoginName.sendKeys(loginName);

			clickThePasswordBox.clear();
			ensureElememtToBeClickable(clickThePasswordBox);
			clickThePasswordBox.sendKeys(assignPassword);

			clickTheConfirmPassword.clear();
			ensureElememtToBeClickable(clickTheConfirmPassword);
			clickTheConfirmPassword.sendKeys(assignPassword);

			clickTheEmailAddress.clear();
			ensureElememtToBeClickable(clickTheEmailAddress);
			clickTheEmailAddress.sendKeys(email);

			ensureElememtToBeClickable(clickOnsaveBtn);
			clickOnsaveBtn.click();

//			ensureElememtToBeClickable(clickOnSaveAndAddAnother);
//			clickOnSaveAndAddAnother.click();
		}
	}

	public boolean performInterMagicOperation(boolean interMagicRule) throws Exception {
		checkValue = clickOnInterMagic.isSelected();
		if (checkValue == false) {
			Thread.sleep(3000);
			if (!clickOnInterMagic.isSelected() && interMagicRule) {
				clickOnInterMagic.click();
			}
		} else {
			clickOnInterMagic.click();
			Thread.sleep(3000);
			clickOnInterMagic.click();
		}

		return checkValue;
	}

	public void matchInterMagicOnConfiguration() throws Exception {
		System.out.println(checkValue);
		Thread.sleep(3000);
		if (checkValue) {

			for (WebElement select_NotifyProvider : selectNotifyProvider) {
				if (select_NotifyProvider.getText().equalsIgnoreCase("IntegriMagic")) {
					select_NotifyProvider.click();
					System.out.println("IntegriMagic Display");
					break;
				}
			}

		}

		else {
			System.out.println("IntegriMagic not Display");
		}
	}

	public void addMasterRuleWithTriggerAndAction(String SelectTriggerType, String Category1, String Category2,
			String Category3, String ICD, String Eye, String GlaucomaSeverity, String GlaucomaStability,
			String SelectActonType, String SpecifyProvider, String SpecifyTimeframe, String Comments,
			String TrigeerType, String TriggerAction, String InterMagicRuleName, String SelectActonType2,
			String planLiberary, String retina, String SelectActonType3, String radiologyTest, String otherTest,
			String SelectActonType4, String selectLabTest, String SelectActonType5, String eyeTestCategory,
			String eyeTest) throws Exception {

		Thread.sleep(4000);
		for (WebElement click_OnInterMagicRule : clickOnInterMagicRule) {
			if (click_OnInterMagicRule.getText().equalsIgnoreCase("IntegriMagic")) {
				click_OnInterMagicRule.click();
				break;

			}
		}

		Thread.sleep(4000);
		// ensureElememtToBeClickable(clickOnMasterRule);
		clickOnMasterRule.click();

		addTrigerDiagnosis(SelectTriggerType, Category1, Category2, Category3, ICD, Eye, GlaucomaSeverity,
				GlaucomaStability);
		addTriggerAction(SelectActonType2, SpecifyProvider, SpecifyTimeframe, Comments, TrigeerType, TriggerAction,
				InterMagicRuleName, SelectActonType2, planLiberary, retina, SelectActonType3, radiologyTest, otherTest,
				SelectActonType4, selectLabTest, SelectActonType5, eyeTestCategory, eyeTest);
		matchInterMagicRuleName(InterMagicRuleName, TrigeerType, TriggerAction);

	}

	public void addTrigerDiagnosis(String SelectTriggerType, String Category1, String Category2, String Category3,
			String ICD, String Eye, String GlaucomaSeverity, String GlaucomaStability) throws Exception {
		Thread.sleep(5000);
		clickOnTriggerAndActionPlus.get(0).click();

		Thread.sleep(2000);
		for (WebElement select_TriggerType : selectTriggerType) {
			if (select_TriggerType.getText().equalsIgnoreCase(SelectTriggerType)) {
				select_TriggerType.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement select_DiagnosisCategory : selectDiagnosisCategory) {
			if (select_DiagnosisCategory.getText().equalsIgnoreCase(Category1)) {
				select_DiagnosisCategory.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement select_DiagnosisCategory2 : selectDiagnosisCategory2) {
			if (select_DiagnosisCategory2.getText().equalsIgnoreCase(Category2)) {
				select_DiagnosisCategory2.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_DiagnosisCategory3 : selectDiagnosisCategory3) {
			if (select_DiagnosisCategory3.getText().equalsIgnoreCase(Category3)) {
				select_DiagnosisCategory3.click();
				break;
			}
		}

//		Thread.sleep(3000);
//		clickOnICD10DropDown.click();
//
//		Thread.sleep(3000);
//		for (WebElement select_ICD10 : selectICD10) {
//			if (select_ICD10.getText().equalsIgnoreCase(ICD)) {
//				select_ICD10.click();
//				break;
//			}
//		}

		Thread.sleep(3000);
		for (WebElement Select_Eye : SelectEye) {
			if (Select_Eye.getText().equalsIgnoreCase(Eye)) {
				Select_Eye.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement Select_GlaucomaSeverity : selectGlaucomaSeverity) {
			if (Select_GlaucomaSeverity.getText().equalsIgnoreCase(GlaucomaSeverity)) {
				Select_GlaucomaSeverity.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement Select_GlaucomaStability : selectGlaucomaStability) {
			if (Select_GlaucomaStability.getText().equalsIgnoreCase(GlaucomaStability)) {
				Select_GlaucomaStability.click();
				break;
			}
		}
	}

	public void addTriggerAction(String SelectActonType, String SpecifyProvider, String SpecifyTimeframe,
			String Comments, String TrigeerType, String TriggerAction, String InterMagicRuleName,
			String SelectActonType2, String planLiberary, String retina, String SelectActonType3, String radiologyTest,
			String otherTest, String SelectActonType4, String selectLabTest, String SelectActonType5,
			String eyeTestCategory, String eyeTest) throws Exception {
		Thread.sleep(5000);
		clickOnActionPlusIcon.click();

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectActionType) {
			if (Select_ActionType.getText().equalsIgnoreCase("Schedule Return Visit ")) {
				Select_ActionType.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement Select_Provider : selectProvider) {
			if (Select_Provider.getText().equalsIgnoreCase(SpecifyProvider)) {
				Select_Provider.click();
				break;
			}
		}
		Thread.sleep(3000);
		for (WebElement Select_TimeFrame : selectTimeFrame) {
			if (Select_TimeFrame.getText().equalsIgnoreCase(SpecifyTimeframe)) {
				Select_TimeFrame.click();
				break;
			}
		}

		fillTextArea.sendKeys("scheduled return visit");

		addTriggerAction2(SelectActonType2, Comments, TrigeerType, TriggerAction, InterMagicRuleName, planLiberary,
				retina);

		checkRadiologyReport(SelectActonType3, radiologyTest, "RadiologyTest", otherTest);

		orderLabTest(SelectActonType4, selectLabTest);

		orderEyeTest(SelectActonType5, eyeTestCategory, eyeTest);

		Thread.sleep(4000);
		ensureElememtToBeClickable(enterInterMagicHolderName);
		enterInterMagicHolderName.clear();
		enterInterMagicHolderName.sendKeys(InterMagicRuleName);

		Thread.sleep(3000);
		ensureElememtToBeClickable(clickOnSubmitAndClose);
		clickOnSubmitAndClose.click();
	}

	public void addTriggerAction2(String SelectActonType2, String Comments, String TrigeerType, String TriggerAction,
			String InterMagicRuleName, String planLiberary, String retina) throws Exception {
		Thread.sleep(10000);
		// ensureElememtToBeClickable(clickOnActionPlusIcon);
		builder.moveToElement(clickOnActionPlusIcon).click().perform();

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectActionType) {
			if (Select_ActionType.getText().equalsIgnoreCase(SelectActonType2)) {
				Select_ActionType.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement selectPlanLibrary : select_PlanLibrary) {
			if (selectPlanLibrary.getText().equalsIgnoreCase(planLiberary)) {
				selectPlanLibrary.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement selectRetina : select_Retina) {
			if (selectRetina.getText().equalsIgnoreCase(retina)) {
				selectRetina.click();
				break;

			}
		}

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectActionType) {
			if (Select_ActionType.getText().equalsIgnoreCase(SelectActonType2)) {
				Select_ActionType.click();
				break;
			}
		}

//		Thread.sleep(4000);
//		fillCommentsInPlan.sendKeys("Plan");

	}

	public void checkRadiologyReport(String SelectActonType3, String radioLogyTest, String comments,
			String associatesLabWithProblem) throws Exception {
		Thread.sleep(5000);
		clickOnActionPlusIcon.click();

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectActionType) {
			if (Select_ActionType.getText().equalsIgnoreCase(SelectActonType3)) {
				Select_ActionType.click();
				break;
			}
		}

		try {
			Thread.sleep(5000);
			WebElement select_LabTest = driver
					.findElement(By.xpath(".//table[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div[text()="
							+ "\"" + radioLogyTest + "\"" + "]"));

			wait.until(ExpectedConditions.elementToBeClickable(select_LabTest));
			wait.until(ExpectedConditions.visibilityOf(select_LabTest));

			builder = new Actions(driver);
			builder.moveToElement(select_LabTest).click().perform();
		} catch (Exception e) {
			e.getMessage();
		}

		// Fill Comments
		Thread.sleep(3000);
		ensureElememtToBeClickable(fillComments);
		wait.until(ExpectedConditions.elementToBeClickable(fillComments)).sendKeys(comments);

		// select problem
		By clickOnProblem = By.xpath("//*[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div[text()=" + "\""
				+ associatesLabWithProblem + "\"" + "]");
		driver.findElement(clickOnProblem).click();

	}

	public void orderLabTest(String SelectActonType4, String selectLabTest) throws Exception {

		Thread.sleep(5000);
		clickOnActionPlusIcon.click();

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectActionType) {
			if (Select_ActionType.getText().equalsIgnoreCase(SelectActonType4)) {
				Select_ActionType.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement select_LabTest : selectLabTest1) {
			if (select_LabTest.getText().equalsIgnoreCase(selectLabTest)) {
				select_LabTest.click();
				break;
			}

		}

		fillCommentsOfOrderComments.sendKeys("lab test");
	}

	public void orderEyeTest(String SelectActonType5, String eyeTestCategory, String eyeTest) throws Exception {

		Thread.sleep(5000);
		clickOnActionPlusIcon.click();

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectActionType) {
			if (Select_ActionType.getText().equalsIgnoreCase(SelectActonType5)) {
				Select_ActionType.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectEyeTestCategory) {
			if (Select_ActionType.getText().equalsIgnoreCase(eyeTestCategory)) {
				Select_ActionType.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement Select_ActionType : selectEyeTest) {
			if (Select_ActionType.getText().equalsIgnoreCase(eyeTest)) {
				Select_ActionType.click();
				break;
			}
		}

		fillCommentOfOrderEyeTest.sendKeys("eye Test");
	}

	public void matchInterMagicRuleName(String InterMagicRuleName, String TrigeerType, String TriggerAction)
			throws Exception {
		boolean b = false, c = false;

		Thread.sleep(3000);
		ensureElememtToBeClickable(fillTheValueInRuleSearch);
		fillTheValueInRuleSearch.sendKeys(InterMagicRuleName);

		selectDisplayActionAndTriggerType(TrigeerType, TriggerAction);

		Thread.sleep(3000);
		for (WebElement getTextOf_RuleNameOfMasterRule : getTextOfRuleNameOfMasterRule) {
			String a = getTextOf_RuleNameOfMasterRule.getText();
			System.out.println(a);
			Thread.sleep(3000);
			b = a.equalsIgnoreCase(InterMagicRuleName);
			System.out.println(b);
			break;
		}

		Thread.sleep(3000);
		for (WebElement click_TheMenuIcon : clickTheMenuIcon) {
			c = click_TheMenuIcon.isSelected();
			System.out.println(c);
			// Thread.sleep(3000);
			if (b != c) {

				click_TheMenuIcon.click();
			}
			break;
		}
		Thread.sleep(3000);
		clickOnDone.get(1).click();
	}

	public void selectDisplayActionAndTriggerType(String TrigeerType, String TriggerAction) throws Exception {

		Thread.sleep(3000);
		for (WebElement select_DisplayTriggrType : selectDisplayTriggrType) {
			if (select_DisplayTriggrType.getText().equalsIgnoreCase(TrigeerType)) {
				select_DisplayTriggrType.click();
				break;
			}
		}

		Thread.sleep(3000);
		for (WebElement select_DisplayActionType : selectDisplayActionType) {
			if (select_DisplayActionType.getText().equalsIgnoreCase(TriggerAction)) {
				select_DisplayActionType.click();
				break;
			}
		}
	}

	// fuction is used for visibility and clickAble of elements
	public void ensureElememtToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
