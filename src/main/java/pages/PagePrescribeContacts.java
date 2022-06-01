package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PagePrescribeContacts {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;

	@FindBy(how = How.XPATH, using = ".//div[contains(text(),'Prescribe Contacts')]")
	private WebElement clickOnPrescibeContact;

	@FindAll({
			@FindBy(xpath = ".//div[@class=\"plan_details_popup clear\"]/div/div/div/table/tbody/tr/td[2]/div/div[text()=\"Please select a value\"]"),
			@FindBy(xpath = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/div[1]/table[1]/tbody/tr/td[2]/div/div[3]") })

	private WebElement clickPrescriptionForm;

	@FindBy(how = How.XPATH, using = "/html/body/div[12]/div/div/div/div/div")
	private List<WebElement> selectPrescriptionForm;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[1]/div[1]/a")
	private WebElement clickOnCancel;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td[1]/table/tbody/tr[2]/td/div/div[2]/div")
	private List<WebElement> clickOnFinal;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/input")
	private WebElement lensQuantity;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div[3]")
	private WebElement clickOnFreeText;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-PopupPanel\"]/div/div/div/div[2]/div")
	private List<WebElement> selectCatalog;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td[1]/table/tbody/tr[4]/td/div/div[2]/div")
	private List<WebElement> SelectFocalPoint;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td[2]/table/tbody/tr[5]/td/div/div[3]")
	private WebElement clickOnMonthlyDisposal;

	@FindBy(how = How.CSS, using = "div.gwt-PopupPanel>div>div>div>div>div")
	private List<WebElement> selectMonthlyDisposal;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/table[2]/tbody/tr[2]/td/textarea")
	private WebElement addInstructions;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div")
	private WebElement clickOnFirstCopy;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div")
	private WebElement clickOnSecondCopy;

	@FindBy(how = How.CSS, using = "div#gwt-debug-prescriptionTableFooter>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>a.gwt-Anchor")
	private List<WebElement> clickOnDone;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickONClinicNote;

	@FindBy(how=How.XPATH,using=".//div[contains(text(),'Contact Lens Prescribed:')]")
	private WebElement getTextFromClinicNote;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private WebElement clickOnClinicNoteCloseBtn;


	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PagePrescribeContacts(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PagePrescribeContacts.this);
	}

	public void verifyPrescribeContacts(String provider, String lensMake, String od, String odSphere,
			String odCyliender, String odAxis, String odAdd, String os, String osSphere, String osCyliender,
			String osAxis, String osAdd, String prism, String prism1, String prism2, String prism3, String odDistance,
			String osDistance, String odIntermediate, String osIntermediate, String odNear, String osNear,
			String OdComment, String osComment, String lensPrescription, String lenStatus) throws Exception {

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnVisonTab);
		clickOnVisonTab.click();

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnPrescibeContact);
		clickOnPrescibeContact.click();

		performPrescibeContact(lensMake, od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender, osAxis,
				osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate, odNear,
				osNear, OdComment, osComment, lensPrescription, lenStatus);
	}

	public void performPrescibeContact(String lensMake, String od, String odSphere, String odCyliender, String odAxis,
			String odAdd, String os, String osSphere, String osCyliender, String osAxis, String osAdd, String prism,
			String prism1, String prism2, String prism3, String odDistance, String osDistance, String odIntermediate,
			String osIntermediate, String odNear, String osNear, String OdComment, String osComment,
			String lensPrescription, String lenStatus) throws Exception {

		Thread.sleep(4000);
		ensureElementToBeClickable(clickPrescriptionForm);
		clickPrescriptionForm.click();

		int size = selectPrescriptionForm.size();
		System.out.println("Size" + size);

		if (size > 0) {
			System.out.println();
			System.out.println("Pass");

			fillvalueInPrescribeContactForm(lensPrescription, lenStatus);

			matchDataWithClinicNote();
		}

		else {
			System.out.println();
			System.out.println("Fail");

			Thread.sleep(2000);
			ensureElementToBeClickable(clickOnCancel);
			builder.moveToElement(clickOnCancel).click().build().perform();

			PgEncounter encounter = new PgEncounter(driver, wait, builder);
			encounter.addNewRefraction(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender, osAxis,
					osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate,
					odNear, osNear, OdComment, osComment);

			encounter = new PgEncounter(driver, wait, builder);
			encounter.addNewContacLens(lensMake);

			Thread.sleep(4000);
			ensureElementToBeClickable(clickOnPrescibeContact);
			clickOnPrescibeContact.click();

			fillvalueInPrescribeContactForm(lensPrescription, lenStatus);

			matchDataWithClinicNote();
		}

	}

	private void fillvalueInPrescribeContactForm(String lensPrescription, String lenStatus) throws Exception {
		Thread.sleep(4000);
		for (WebElement select_PrescriptionForm : selectPrescriptionForm) {
			if (select_PrescriptionForm.getText().equalsIgnoreCase(lensPrescription)) {
				select_PrescriptionForm.click();
				break;
			}

		}

		Thread.sleep(6000);
		for (WebElement select_LensStaus : clickOnFinal) {
			if (select_LensStaus.getText().equalsIgnoreCase(lenStatus)) {
				select_LensStaus.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(lensQuantity);
		lensQuantity.clear();
		lensQuantity.sendKeys("12");

		Thread.sleep(4000);
		ensureElementToBeClickable(clickOnFreeText);
		builder.moveToElement(clickOnFreeText).click().build().perform();

		Thread.sleep(3000);
		for (WebElement select_Catalog : selectCatalog) {
			if (select_Catalog.getText().equalsIgnoreCase("1 pack(s) of 6 lenses")) {
				select_Catalog.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement select_FocalPoint : SelectFocalPoint) {
			if (select_FocalPoint.getText().equalsIgnoreCase("Monovision")) {
				select_FocalPoint.click();
				break;
			}
		}

		Thread.sleep(2000);
		clickOnMonthlyDisposal.click();

		Thread.sleep(2000);
		for (WebElement select_Disposal : selectMonthlyDisposal) {
			if (select_Disposal.getText().equalsIgnoreCase("Quarterly")) {
				select_Disposal.click();
				break;
			}
		}

		Thread.sleep(3000);
		addInstructions.clear();
		addInstructions.sendKeys("Right eye record");

		Thread.sleep(3000);
		clickOnFirstCopy.click();

		Thread.sleep(3000);
		clickOnSecondCopy.click();

		Thread.sleep(3000);
		clickOnDone.get(0).click();

	}

	private void matchDataWithClinicNote() throws Exception {
		Thread.sleep(8000);
		//ensureElementToBeClickable(clickONClinicNote);
		clickONClinicNote.click();

		Thread.sleep(3000);
		String strClinicNoteText=getTextFromClinicNote.getText();
		System.out.println(strClinicNoteText);

		Thread.sleep(5000);
		if(strClinicNoteText.equalsIgnoreCase("Contact Lens Prescribed:")) {
			Reporter.log(strClinicNoteText+" "+"Data Matched");
			System.out.println("Data matched");
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnClinicNoteCloseBtn);
		clickOnClinicNoteCloseBtn.click();
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
