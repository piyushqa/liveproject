package pages;

import static org.testng.Assert.assertEquals;

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
import org.testng.Assert;
import org.testng.Reporter;

public class PageVisionRefraction {
	WebDriverWait wait;
	Actions builder;
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody > tr > td:nth-child(5)> div")
	private WebElement clickOnVisionTab;
	@FindBy(how = How.CSS, using = "#gwt-debug-addNewContactLens")
	private WebElement clickOnContactLens;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lensPopup-od-make-button\"]/div[3]")
	private WebElement clickOnLensMake1;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/table/tbody/tr/td[1]/div/a")
	private WebElement clickOnShowAll;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lens-copyRight\"]")
	private WebElement clickOnCopyRightEye;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-popup-done\"]/a")
	private WebElement clickOnDoneBtnContactLens;

	@FindBy(how = How.XPATH, using = ".//*[text()=\"Prescribe Glasses\"]")
	private WebElement clickOnPrescribeGlass;

	@FindBy(how = How.CSS, using = "#modal-popup-message>div>div>div>div>div:nth-child(3)>div>div:nth-child(3)>div>div:nth-child(2)>div>div:nth-child(2)>select")
	private WebElement clickOnGlassesRx;

	// Locater for radio and checkBox
	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[3]/div/div[2]/div[1]/div[4]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[3]")
	private WebElement clickOnComputerUsage;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[3]/div/div[2]/div[1]/div[4]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]")
	private WebElement clickOnBifocalType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[3]/div/div[2]/div[1]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div[5]")
	private WebElement clickOnMidIndexLensmaterial;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-popup-message\"]/div/div/div/div/div[3]/div/div[3]/div/div[2]/div[1]/div[4]/div/div[2]/div[2]/div[4]/div[2]/div[2]/div[6]")
	private WebElement clickOnTintLensTreatment;

	@FindBy(how = How.XPATH, using = ".//textarea[@placeholder=\"Comments\"]")
	private WebElement fillTheCommentBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[5]/span")
	private WebElement getDeleteRefractionData;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()='Yes']")
	private WebElement clickOnYesButton;

	// for Matching Locater

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/div[2]/div/span[1]")
	private WebElement matchRefractionRightSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/div[2]/div/span[2]")
	private WebElement matchRefractionRightCylider;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/div[2]/div/input[1]")
	private WebElement matchRefractionRightAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[3]/div/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/div[2]/div/input[2]")
	private WebElement matchRefractionRightAdd;

	//for match clinic note data

	@FindBy(how = How.XPATH, using = ".//a[text()=\"This Clinic Note\"]")
	private WebElement clickONClinicNote;

	@FindBy(how=How.XPATH,using=".//div[contains(text(),'Glasses Prescribed:')]")
	private WebElement getTextFromClinicNote;

	@FindBy(how = How.CSS, using = "a#gwt-debug-.close")
	private WebElement clickOnClinicNoteCloseBtn;

	public PageVisionRefraction(WebDriver driver, WebDriverWait wait, Actions builder) {
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);
	}

	public void matchVisionRefraction(String provider, String od, String odSphere, String odCyliender, String odAxis,
			String odAdd, String os, String osSphere, String osCyliender, String osAxis, String osAdd, String prism,
			String prism1, String prism2, String prism3, String odDistance, String osDistance, String odIntermediate,
			String osIntermediate, String odNear, String osNear, String OdComment, String osComment, String lensMake,
			String glassRx, Boolean usage, Boolean type, Boolean lensMaterial, Boolean lensTreatMent,
			String commentGlass) throws Exception {

		Thread.sleep(9000);
		clickJionOpenencounter.click();
		Thread.sleep(5000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(2000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(8000);
			List<WebElement> select_Provider = driver
					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
			for (int i = 1; i <= select_Provider.size(); i++)
				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
					select_Provider.get(i).click();
					break;
				}
		}

		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

		}
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVisionTab)).click();

		PgEncounter encounter = new PgEncounter(driver, wait, builder);
		encounter.addNewRefraction(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender, osAxis, osAdd,
				prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate, odNear, osNear,
				OdComment, osComment);

		Thread.sleep(5000);
		// click of addNew CotactLens
		// Thread.sleep(10000);
		// clickOnContactLens.click();
		// try {
		// Thread.sleep(5000);
		// String strmatchRefractionRightSphere = matchRefractionRightSphere.getText();
		//
		// Thread.sleep(3000);
		// StringBuilder sb = new StringBuilder(strmatchRefractionRightSphere);
		//
		// Assert.assertEquals((sb.deleteCharAt(0)).toString(), odSphere);
		// {
		// System.out.println("PASS");
		// Reporter.log(strmatchRefractionRightSphere + " " + matchRefractionRightSphere
		// + " " + "Matched");
		// }
		//
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// }
		// try {
		// Thread.sleep(5000);
		// String strmatchRefractionRightCylider =
		// matchRefractionRightCylider.getText();
		// Thread.sleep(3000);
		// StringBuffer sb1 = new StringBuffer(strmatchRefractionRightCylider);
		// Assert.assertEquals((sb1.deleteCharAt(0)).toString(), odCyliender);
		// {
		// System.out.println("PASS");
		// Reporter.log(strmatchRefractionRightCylider + " " +
		// matchRefractionRightCylider + " " + "Matched");
		//
		// }
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// }
		// try {
		// Thread.sleep(5000);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// String strmatchRefractionRightAxis =
		// matchRefractionRightAxis.getAttribute("value");
		// Assert.assertEquals(strmatchRefractionRightAxis.toString(), odAxis);
		// {
		// System.out.println("PASS");
		// Reporter.log(strmatchRefractionRightAxis + " " + matchRefractionRightAxis + "
		// " + "Matched");
		// }
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// }
		//
		// try {
		// Thread.sleep(5000);
		// wait = new WebDriverWait(driver, 20);
		// String strmatchRefractionRightAdd =
		// matchRefractionRightAdd.getAttribute("value");
		// System.out.println(strmatchRefractionRightAdd);
		// Assert.assertEquals(strmatchRefractionRightAdd.toString(), odAdd);
		// {
		// System.out.println("PASS");
		// Reporter.log(strmatchRefractionRightAdd + " " + matchRefractionRightAdd + " "
		// + "Matched");
		// }
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// }
		// // click on LensMake
		// Thread.sleep(7000);
		// By clickOnLensMake1 =
		// By.xpath("//*[@id=\"gwt-debug-lensPopup-od-make-button\"]/div[3]");
		// driver.findElements(clickOnLensMake1).get(0).click();
		//
		// // click on ShowAll
		// Thread.sleep(9000);
		// clickOnShowAll.click();
		//
		// // Select the one value from lensMake
		//
		// Thread.sleep(7000);
		// java.util.List<WebElement> selectLensMake = driver
		// .findElements(By.xpath("//*[@id=\"gwt-debug-lensPopup-od-make-container\"]/div"));
		// for (int i = 0; i < selectLensMake.size(); i++)
		// if (selectLensMake.get(i).getText().equalsIgnoreCase(lensMake)) {
		// selectLensMake.get(i).click();
		// break;
		// }
		//
		// // click on CopyRightEye
		// Thread.sleep(4000);
		// clickOnCopyRightEye.click();
		//
		// // click on DoneBtn of ContactLens
		// Thread.sleep(5000);
		// clickOnDoneBtnContactLens.click();

		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnPrescribeGlass)).click();

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnGlassesRx)).click();

		Thread.sleep(4000);
		List<WebElement> select_Glass = driver.findElements(By.cssSelector(
				"#modal-popup-message>div>div>div>div>div:nth-child(3)>div>div:nth-child(3)>div>div:nth-child(2)>div>div:nth-child(2)>select>option"));
		for (int i = 1; i <= select_Glass.size(); i++)

			if (select_Glass.get(i).getText().equalsIgnoreCase(glassRx)) {
				select_Glass.get(i).click();
				break;
			}

		Thread.sleep(1000);
		if (!clickOnComputerUsage.isSelected() && usage) {
			clickOnComputerUsage.click();
		}

		Thread.sleep(1000);
		if (!clickOnBifocalType.isSelected() && type) {
			clickOnBifocalType.click();
		}
		Thread.sleep(1000);
		if (!clickOnMidIndexLensmaterial.isSelected() && lensMaterial) {
			clickOnMidIndexLensmaterial.click();
		}

		Thread.sleep(1000);
		if (!clickOnTintLensTreatment.isSelected() && lensTreatMent) {
			clickOnTintLensTreatment.click();
		}

		Thread.sleep(1000);
		wait = new WebDriverWait(driver, 20);
		fillTheCommentBox.clear();
		wait.until(ExpectedConditions.elementToBeClickable(fillTheCommentBox)).sendKeys(commentGlass);

		Thread.sleep(1000);
		By doneBtn = By.xpath(
				".//div[@id=\"gwt-debug-prescriptionTableFooter\"][1]//a[@id=\"gwt-debug-Done\"][1][text()=\"Done\"]");
		driver.findElements(doneBtn).get(1).click();

		//matchDataWithClinicNote();

		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(getDeleteRefractionData)).click();
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnYesButton)).click();

	}

	private void matchDataWithClinicNote() throws Exception {
		Thread.sleep(8000);
		//ensureElementToBeClickable(clickONClinicNote);
		clickONClinicNote.click();

		Thread.sleep(3000);
		String strClinicNoteText=getTextFromClinicNote.getText();
		System.out.println(strClinicNoteText);

		Thread.sleep(5000);
		if(strClinicNoteText.equalsIgnoreCase("Glasses Prescribed:")) {
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
