package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageContactLens {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;

	@FindBy(how = How.CSS, using = "#gwt-debug-addNewContactLens")
	private WebElement clickOnContactLens;

	@FindBy(how = How.XPATH, using = "/html/body/div[12]/div/div/table/tbody/tr/td[1]/div/a")
	private WebElement clickOnShowAll;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lens-copyRight\"]")
	private WebElement clickOnCopyRightEye;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-popup-done\"]/a")
	private WebElement clickOnDoneBtnContactLens;

	@FindBy(how = How.CSS, using = "a#gwt-debug-lensPopup-overRefraction")
	private WebElement clickOnAddOverReferation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[1]")
	private WebElement clickOverRefractionRightSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[2]")
	private WebElement clickOverRefractionRightCylinder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[1]")
	private WebElement clickOverReferactionRightAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[2]")
	private WebElement clickOverReferactionRightAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[1]")
	private WebElement clickOnOverRefractionRightDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[2]")
	private WebElement clickOnOverRefractionRightIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[3]")
	private WebElement clickOnOverRefractionRightNear;

	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div/div/table/tbody/tr/td")
	private List<WebElement> selectOverReferatcionRightSphereValue;

	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> selectOverReferactionRightDistanceVlaue;

	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div/div/div[6]/div/div")
	private List<WebElement> selectOverRefractionRightIntermediateValue;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Contact Lens Over Refraction\"]")
	private WebElement clickForEnableElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[1]")
	private WebElement clickOverRefractionLeftSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[2]")
	private WebElement clickOverRefractionLeftCylinder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[1]")
	private WebElement clickOverReferactionLeftAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[2]")
	private WebElement clickOverReferactionLeftAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[1]")
	private WebElement clickOnOverRefractionLeftDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[2]")
	private WebElement clickOnOverRefractionLeftIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[3]")
	private WebElement clickOnOverRefractionLeftNear;

	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div/div/table/tbody/tr/td")
	private List<WebElement> selectOverReferatcionLeftSphereValue;

	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div/div/div[6]/div[2]/table/tbody/tr/td/div")
	private List<WebElement> selectOverReferactionLeftDistanceValue;

	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div/div/div[6]/div/div")
	private List<WebElement> selectOverRefractionLeftIntermediateValue;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/div[2]/table/tbody/tr/td[2]/div/a")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.CSS, using = "a#gwt-debug-lensPopup-overRefraction")
	private WebElement clickOnEditOverReferaction;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageContactLens(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageContactLens.this);
	}

	public void verifyContactLens(String provider, String lensMake, String od, String odSphere, String odCyliender,
			String odAxis, String odAdd, String os, String osSphere, String osCyliender, String osAxis, String osAdd,
			String prism, String prism1, String prism2, String prism3, String odDistance, String osDistance,
			String odIntermediate, String osIntermediate, String odNear, String osNear, String OdComment,
			String osComment, String visitType, Boolean noCharges, String rightRadius, String rightAxis,
			String rightPower, String leftRadius, String leftAxis, String leftPower, String instrument,
			String rightSphere, String rightCylinder, String Axis, String rightAdd, String rightDistance,
			String rightIntermediate, String rightNear) throws Exception {

		new PageAddAndDeleteExistingGlass(wait, driver, builder).joinOpenEncounter(provider);

		Thread.sleep(6000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnVisonTab)).click();

		PgEncounter encounter = new PgEncounter(driver, wait, builder);
		encounter.addNewRefraction(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender, osAxis, osAdd,
				prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate, odNear, osNear,
				OdComment, osComment);

		encounter = new PgEncounter(driver, wait, builder);
		encounter.addNewKeratometry(rightRadius, rightAxis, rightPower, leftRadius, leftAxis, leftPower, instrument);

		Thread.sleep(5000);
		clickOnContactLens.click();

		Thread.sleep(4000);
		perfromContactLenseOperation(lensMake);

		// new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType,
		// noCharges);
		Thread.sleep(5000);
		clickOnAddOverReferation.click();

		perfromAddOverReferactionRightEyeOperation("-1.25", "-5.25", Axis, rightAdd, rightDistance, "1.60", rightNear);

		perfromAddOverReferactionLeftEyeOperation();

		Thread.sleep(3000);
		clickOnDoneBtn.click();

		editOverReferaction(rightSphere, rightCylinder, Axis, rightAdd, rightDistance, rightIntermediate, rightNear);

		Thread.sleep(3000);
		clickOnDoneBtn.click();

		Thread.sleep(5000);
		clickOnDoneBtnContactLens.click();

	}

	public void perfromAddOverReferactionRightEyeOperation(String rightSphere, String rightCylinder, String Axis,
			String rightAdd, String rightDistance, String rightIntermediate, String rightNear) throws Exception {

		clickOverRefractionRightSphere.click();

		chooseRightEyeSCAA(rightSphere);

		clickOverRefractionRightCylinder.click();

		chooseRightEyeSCAA(rightCylinder);

		clickOverReferactionRightAxis.click();

		chooseRightEyeSCAA(Axis);

		clickOverReferactionRightAdd.click();

		chooseRightEyeSCAA(rightAdd);

		clickForEnableElement.click();

		clickOnOverRefractionRightDistance.click();

		chooseRightEyeDistance(rightDistance);

		clickForEnableElement.click();

		clickOnOverRefractionRightIntermediate.click();

		chooseRightEyeIntermediate(rightIntermediate);

		clickForEnableElement.click();

		clickOnOverRefractionRightNear.click();

		chooseRightEyeIntermediate(rightNear);

		clickForEnableElement.click();
	}

	public void chooseRightEyeSCAA(String value) throws Exception {

		for (WebElement select_OverReferatcionRightSphereValue : selectOverReferatcionRightSphereValue) {
			if (select_OverReferatcionRightSphereValue.getText().equalsIgnoreCase(value)) {
				select_OverReferatcionRightSphereValue.click();
				break;
			}
		}
	}

	public void chooseRightEyeDistance(String value) throws Exception {

		for (WebElement select_OverReferactionRightDistanceVlaue : selectOverReferactionRightDistanceVlaue) {
			if (select_OverReferactionRightDistanceVlaue.getText().equalsIgnoreCase(value)) {
				select_OverReferactionRightDistanceVlaue.click();
				break;
			}
		}
	}

	public void chooseRightEyeIntermediate(String value) throws Exception {

		for (WebElement select_OverRefractionRightIntermediateValue : selectOverRefractionRightIntermediateValue) {
			if (select_OverRefractionRightIntermediateValue.getText().equalsIgnoreCase(value)) {
				select_OverRefractionRightIntermediateValue.click();
				break;
			}
		}
	}

	public void perfromAddOverReferactionLeftEyeOperation() throws Exception {

		clickOverRefractionLeftSphere.click();

		chooseLeftEyeSCAA("2.50");

		clickOverRefractionLeftCylinder.click();

		chooseLeftEyeSCAA("-2.25");

		clickOverReferactionLeftAxis.click();

		chooseLeftEyeSCAA("45");

		clickOverReferactionLeftAdd.click();

		chooseLeftEyeSCAA("+3.25");

		clickForEnableElement.click();

		clickOnOverRefractionLeftDistance.click();

		chooseLeftEyeDistance("20/20");

		clickForEnableElement.click();

		clickOnOverRefractionLeftIntermediate.click();

		chooseLeftEyeIntermediate("1.60");

		clickForEnableElement.click();

		clickOnOverRefractionLeftNear.click();

		chooseLeftEyeIntermediate("-0.10");

		clickForEnableElement.click();
	}

	public void chooseLeftEyeSCAA(String value) throws Exception {

		for (WebElement select_OverReferatcionLeftSphereValue : selectOverReferatcionLeftSphereValue) {
			if (select_OverReferatcionLeftSphereValue.getText().equalsIgnoreCase(value)) {
				select_OverReferatcionLeftSphereValue.click();
				break;
			}
		}
	}

	public void chooseLeftEyeDistance(String value) throws Exception {

		for (WebElement select_OverReferactionLeftDistanceValue : selectOverReferactionLeftDistanceValue) {
			if (select_OverReferactionLeftDistanceValue.getText().equalsIgnoreCase(value)) {
				select_OverReferactionLeftDistanceValue.click();
				break;
			}
		}
	}

	public void chooseLeftEyeIntermediate(String value) throws Exception {

		for (WebElement select_OverRefractionLeftIntermediateValue : selectOverRefractionLeftIntermediateValue) {
			if (select_OverRefractionLeftIntermediateValue.getText().equalsIgnoreCase(value)) {
				select_OverRefractionLeftIntermediateValue.click();
				break;
			}
		}
	}

	public void perfromContactLenseOperation(String lensMake) throws Exception {

		// click on LensMake
		Thread.sleep(5000);
		By clickOnLensMake1 = By.xpath("//*[@id=\"gwt-debug-lensPopup-od-make-button\"]/div[3]");
		driver.findElements(clickOnLensMake1).get(0).click();

		// click on ShowAll
		Thread.sleep(5000);
		clickOnShowAll.click();

		// Select the one value from lensMake

		Thread.sleep(3000);
		java.util.List<WebElement> selectLensMake = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-lensPopup-od-make-container\"]/div"));
		for (int i = 0; i < selectLensMake.size(); i++)
			if (selectLensMake.get(i).getText().equalsIgnoreCase(lensMake)) {
				selectLensMake.get(i).click();
				break;
			}

		// click on CopyRightEye
		Thread.sleep(4000);
		clickOnCopyRightEye.click();

	}

	public void editOverReferaction(String rightSphere, String rightCylinder, String Axis, String rightAdd,
			String rightDistance, String rightIntermediate, String rightNear) throws Exception {
		Thread.sleep(5000);
		boolean checkValueOfEditOverReferaction = clickOnEditOverReferaction.isDisplayed();
		if (checkValueOfEditOverReferaction) {
			Thread.sleep(4000);
			clickOnEditOverReferaction.click();

			perfromAddOverReferactionRightEyeOperation("-4.25", "-1.50", "55", "+5.50", "20/40", "1.25", "-0.20");

		}
	}
}
