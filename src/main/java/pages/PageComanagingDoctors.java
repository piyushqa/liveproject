package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageComanagingDoctors {
	WebDriverWait wait;
	WebDriver driver;
	Actions builder;
	String fullName;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;

	@FindBy(how = How.LINK_TEXT, using = "Providers")
	private WebElement clickOnProviders;

	@FindBy(how = How.CSS, using = "a#gwt-debug-addNewProviderLinkAnchor")
	private WebElement clickOnAddNewExternalProviders;

	@FindBy(how = How.CSS, using = "select#gwt-debug-providerTypeList")
	private WebElement selectProviderType;

	@FindBy(how = How.CSS, using = "select#gwt-debug-degreeList")
	private WebElement selectDegreeType;

	@FindBy(how = How.CSS, using = "input#gwt-debug-firstName.gwt-TextBox")
	private WebElement fillFirstName;

	@FindBy(how = How.CSS, using = "input#gwt-debug-lastName.gwt-TextBox")
	private WebElement fillLastName;

	@FindBy(how = How.CSS, using = "input#gwt-debug-initials.gwt-TextBox")
	private WebElement fillInitials;

	@FindBy(how = How.CSS, using = "div#gwt-debug-npi>input.gwt-TextBox")
	private WebElement fillNPI;

	@FindBy(how = How.CSS, using = "input#gwt-debug-pmsReferralId.gwt-TextBox")
	private WebElement fillReferalId;

	@FindBy(how = How.CSS, using = "input#gwt-debug-addressLine1.gwt-TextBox")
	private WebElement fillAddressLine1;

	@FindBy(how = How.CSS, using = "input#gwt-debug-addressLine2.gwt-TextBox")
	private WebElement fillAddressLine2;

	@FindBy(how = How.CSS, using = "input#gwt-debug-city.gwt-TextBox")
	private WebElement fillCity;

	@FindBy(how = How.CSS, using = "select#gwt-debug-stateList.gwt-ListBox")
	private WebElement fillState;

	@FindBy(how = How.CSS, using = "input#gwt-debug-zipCode.gwt-TextBox")
	private WebElement fillZipCode;

	@FindBy(how = How.CSS, using = "input#gwt-debug-officePhone.gwt-TextBox")
	private WebElement fillOfficePhone;

	@FindBy(how = How.CSS, using = "select#gwt-debug-OtherTextFieldComboBox")
	private WebElement selectSpeciality;

	@FindBy(how = How.CSS, using = "a#gwt-debug-saveButton.gwt-Anchor")
	private WebElement clickOnsaveBtn;

	@FindBy(how = How.LINK_TEXT, using = "Practice Configuration")
	private WebElement clickOnPracticeConfiguration;

	@FindBy(how = How.CSS, using = "div#gwt-debug-configurationOptions-container>div")
	private List<WebElement> select_ConfigurationOptions;

	@FindBy(how = How.CSS, using = "div.comanaging-configuration__add")
	private WebElement clickOnAddAnotherDoctor;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div[1]/div/div[1]/span")
	private List<WebElement> getLengthOfName;

	@FindBy(how = How.XPATH, using = "//div[text()=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = "//div[text()=\"Search\"]")
	private List<WebElement> clickOnSearchBtn;

	@FindBy(how = How.XPATH, using = "//a[@class=\"external-provider-list__control-link\" and text()=\"Add\"]")
	private WebElement clickOnAddBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-closeConfiguration>a")
	private WebElement clickOnCloseConfigration;

	@FindBy(how = How.CSS, using = "div#gwt-debug-listOpenEncounterWidget>a")
	private WebElement checkEncounterIsOpenOrNot;

	@FindBy(how = How.CSS, using = "table#gwt-debug-openEncounterTable>tbody>tr")
	private List<WebElement> sizeOfEncounter;

	@FindBy(how = How.CSS, using = "a#gwt-debug-pdReturnToUserDashboard")
	WebElement clickOnMyDashBoard;

	@FindBy(how = How.LINK_TEXT, using = "Configuration")
	private WebElement clickOnConfiguration;

	@FindBy(how = How.CSS, using = "div#gwt-debug-tabbedPopup-tabContainer>div>div:nth-child(1)")
	private List<WebElement> selectNotifyProvider;

	@FindBy(how = How.CSS, using = "div.datalist__container>div:nth-child(1)")
	private WebElement clickOnOnBtn;

	@FindBy(how = How.XPATH, using = "//a[text()=\"Done\"]")
	private WebElement clickOnComangengntDoneBtn;

	@FindBy(how = How.CSS, using = "div#gwt-debug-comanageList-button>div:nth-child(3)")
	private WebElement clickOnComangegdWith;

	@FindBy(how = How.CSS, using = "div#gwt-debug-comanageList-container>div")
	private List<WebElement> selectOnComangedList;

	@FindBy(how = How.CSS, using = "a#gwt-debug-ok.gwt-Anchor")
	private WebElement clickOnYesReplace;

	@FindBy(how = How.CSS, using = "a#gwt-debug-returnToPatientDashboard.gwt-Anchor")
	private WebElement clickOnPatientDashBoard;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div[2]/div/div[2]/div[7]/div[2]/table/tbody/tr/td/div/div[2]")
	private WebElement matchTextOnPatientDashBoard;

	/**
	 * @param wait
	 * @param driver
	 * @param builder
	 */
	public PageComanagingDoctors(WebDriverWait wait, WebDriver driver, Actions builder) {
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, PageComanagingDoctors.this);
	}

	public void verifyComanagingDoctors(String ProviderType, String SelectDegree, String ProviderFirstName,
			String ProviderLastName, String initials, String Npi, String Refferalcode, String Specialty,
			String AddressLine1, String AddressLine2, String City, String State, String ZipCode, String offocephone,
			String fName, String lName, String provider) throws Exception {

		addExternalProvider(ProviderType, SelectDegree, ProviderFirstName, ProviderLastName, initials, Npi,
				Refferalcode, Specialty, AddressLine1, AddressLine2, City, State, ZipCode, offocephone);

		performComanagingDoctorsOperations(ProviderFirstName, ProviderLastName);

		searchPatient(fName, lName);

		checkEncounterIsOpenOrNot();

		searchPatient(fName, lName);

		performComanagigDropdownOperationOnPatientDashboard(provider, fullName);
	}

	public String addExternalProvider(String ProviderType, String SelectDegree, String ProviderFirstName,
			String ProviderLastName, String initials, String Npi, String Refferalcode, String Specialty,
			String AddressLine1, String AddressLine2, String City, String State, String ZipCode, String offocephone)
			throws Exception {

		Thread.sleep(3000);
		clickOnProviders.click();

		Thread.sleep(3000);
		clickOnAddNewExternalProviders.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		selectValue(selectProviderType, ProviderType);

		selectValue(selectDegreeType, SelectDegree);

		String fName = ProviderFirstName.concat(RandomValue());
		fillFirstName.sendKeys(fName);

		String lName = ProviderLastName.concat(RandomValue());
		fillLastName.sendKeys(lName);

		fullName = fName + "," + lName;

		fillInitials.sendKeys(initials);

		fillNPI.sendKeys(Npi);

		selectValue(selectSpeciality, Specialty);

		fillAddressLine1.sendKeys(AddressLine1);

		fillAddressLine2.sendKeys(AddressLine2);

		fillCity.sendKeys(City);

		selectValue(fillState, State);

		fillZipCode.sendKeys(ZipCode);

		fillOfficePhone.sendKeys(offocephone);

		clickOnsaveBtn.click();
		return fullName;
	}

	public void selectValue(WebElement element, String value) throws Exception {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public String RandomValue() {
		Random random = new Random();
		int n = random.nextInt();
		String s1 = Integer.toString(n);
		return s1;
	}

	public void performComanagingDoctorsOperations(String providerFirstName, String providerLastName) throws Exception {

		String[] name = fullName.split(",");
		Thread.sleep(4000);
		clickOnPracticeConfiguration.click();

		Thread.sleep(4000);
		for (WebElement selectConfigurationOptions : select_ConfigurationOptions) {
			if (selectConfigurationOptions.getText().equalsIgnoreCase("Comanaging Doctors")) {
				selectConfigurationOptions.click();
				break;
			}
		}

		Thread.sleep(4000);
		clickOnAddAnotherDoctor.click();

		getFirstAndLastName("First", name[0]);

		getFirstAndLastName("Last", name[1]);

		clickOnSearchBtn.get(1).click();

		Thread.sleep(3000);
		clickOnAddBtn.click();

		Thread.sleep(3000);
		clickOnDoneBtn.click();

		Thread.sleep(3000);
		clickOnCloseConfigration.click();
	}

	public void getFirstAndLastName(String value, String name) throws Exception {

		int length = getLengthOfName.size();
		Thread.sleep(3000);

		for (int i = 1; i <= length; i++) {
			boolean check = (driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/div[1]/span[" + i + "]/span"))
					.getText().startsWith(value));

			if (check == true)

			{
				Thread.sleep(3000);

				driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/div[1]/span[" + i + "]/input"))
						.sendKeys(name);

				break;
			}

		}
	}

	public void checkEncounterIsOpenOrNot() throws Exception {
		Thread.sleep(3000);
		checkEncounterIsOpenOrNot.click();

		int length = sizeOfEncounter.size();
		if (length > 0) {
			Thread.sleep(2000);
			clickOnMyDashBoard.click();

			Thread.sleep(4000);
			clickOnConfiguration.click();

			Thread.sleep(2000);
			for (WebElement select_NotifyProvider : selectNotifyProvider) {
				if (select_NotifyProvider.getText().equalsIgnoreCase("Comanagement")) {
					select_NotifyProvider.click();
					break;
				}
			}

			if (!clickOnOnBtn.isSelected() && true) {
				clickOnOnBtn.click();
			}

			clickOnComangengntDoneBtn.click();
		} else {
			System.out.println("Encounter is not open");
		}
	}

	public void searchPatient(String fName, String lName) throws Exception {
		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
	}

	public void performComanagigDropdownOperationOnPatientDashboard(String provider, String fullName) throws Exception {

		Thread.sleep(3000);
		PageAddAndDeleteExistingGlass obj1 = new PageAddAndDeleteExistingGlass(wait, driver, builder);
		obj1.joinOpenEncounter(provider);

		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clickOnComangegdWith.click();

		String[] firstName = fullName.split(",");
		System.out.println("FULL Name :" + fullName);
		Thread.sleep(3000);
		for (WebElement Select_OnComangedList : selectOnComangedList) {
			if (Select_OnComangedList.getText().startsWith(firstName[0])) {
				Select_OnComangedList.click();
				break;
			}
		}

		Thread.sleep(3000);
		clickOnYesReplace.click();

		Thread.sleep(3000);
		clickOnPatientDashBoard.click();

		Thread.sleep(5000);
		String actualText = matchTextOnPatientDashBoard.getText();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (actualText.startsWith(firstName[0])) {
			System.out.println("Name Matched");
			Reporter.log("Name Matched");
		}
	}
}
