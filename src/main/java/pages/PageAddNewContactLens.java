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

public class PageAddNewContactLens {

	WebDriverWait wait;
	WebDriver driver;
	Actions builder;

	// Define Locater
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" and text()=\"Yes\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-encounterTabBar\"]/tbody/tr/td[5]/div")
	private WebElement clickOnVisonTab;

	@FindBy(how = How.ID, using = "gwt-debug-addNewContactLens")
	private WebElement clickOnAddnewOfCL;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lens-0-normal-od-distance\"]")
	private WebElement clickOnOdDistanceToReEnterInCL;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Reset and Clear")
	private WebElement clickOnResetAndClear;

	@FindBy(how = How.ID, using = "gwt-debug-od-lens-reset")
	private WebElement clickOnOdReset;

	@FindBy(how = How.ID, using = "gwt-debug-os-lens-reset")
	private WebElement clickOnOsReset;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-popup-saveAddAnother\"]/a")
	private WebElement clickOnSaveAddAnother;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-close_overlay\"]/a[@class=\"close\"]")
	private WebElement clickOnCancelButton;

	@FindBy(how = How.XPATH, using = "/html/body/div[11]/div/div/table/tbody/tr/td[1]/div/a")
	private WebElement clickOnShowAll;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lens-copyRight\"]")
	private WebElement clickOnCopyRightEye;

	@FindBy(how = How.ID, using = "gwt-debug-lensPopup-od-fitting-container")
	private WebElement QuickNotesRightContainer;

	@FindBy(how = How.ID, using = "gwt-debug-lensPopup-notes-addDetail")
	private WebElement clickOnrightEyeAddDetails;

	@FindBy(how = How.ID, using = "gwt-debug-notes-od-selection-topLeft-container")
	private WebElement moveMentContainer;

	@FindBy(how = How.ID, using = "gwt-debug-notes-od-selection-topMiddle-container")
	private WebElement rotationRightContainer;

	@FindBy(how = How.ID, using = "gwt-debug-notes-od-selection-topRight-container")
	private WebElement surfaceContainer;

	@FindBy(how = How.ID, using = "gwt-debug-notes-od-selection-bottomLeft-container")
	private WebElement decentrationContainer;

	@FindBy(how = How.ID, using = "gwt-debug-notes-od-selection-bottomMiddle-container")
	private WebElement rotationLeftContainer;

	@FindBy(how = How.ID, using = "gwt-debug-notes-od-selection-bottomRight-container")
	private WebElement monovisionContainer;

	@FindBy(how = How.ID, using = "gwt-debug-notes-od-copy")
	private WebElement clickleftNotesCopy;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-Done\"]")
	private WebElement clickOnAdddetailsDoneBtn;

	@FindBy(how = How.ID, using = "gwt-debug-lensPopup-od-notes")
	private WebElement fillOdPresNotesRight;

	@FindBy(how = How.ID, using = "gwt-debug-lensPopup-od-fitting-container")
	private WebElement QuickNotesLeftContainer;

	@FindBy(how = How.ID, using = "gwt-debug-lensPopup-od-notes")
	private WebElement fillOdPresNotesLeft;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-popup-done\"]/a")
	private WebElement clickOnDoneBtnContactLens;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "CONFIGURE")
	private WebElement clickOnConfigureLink;

	@FindBy(how = How.ID, using = "gwt-debug-configNotes-0-container")
	private WebElement configureMoveMentContainer;

	@FindBy(how = How.ID, using = "gwt-debug-configNotes-1-container")
	private WebElement configureRotationRightContainer;

	@FindBy(how = How.ID, using = "gwt-debug-configNotes-2-container")
	private WebElement configureSurfaceContainer;

	@FindBy(how = How.ID, using = "gwt-debug-configNotes-3-container")
	private WebElement configureDecentrationContainer;

	@FindBy(how = How.ID, using = "gwt-debug-configNotes-4-container")
	private WebElement configureRotationLeftContainer;

	@FindBy(how = How.ID, using = "gwt-debug-configNotes-5-container")
	private WebElement configureMonovisionContainer;

	@FindBy(how = How.CSS, using = "#gwt-debug-configNotes-done>a")
	private WebElement clickOnConfigureDoneBtn;

	@FindBy(how = How.ID, using = "gwt-debug-lensPopup-overRefraction")
	private WebElement clickOnAddOverRefraction;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[1]")
	private WebElement clickOnRightSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[2]")
	private WebElement clickOnRightCylinder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[1]")
	private WebElement clickOnRightAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[2]")
	private WebElement clickOnRightAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[1]")
	private WebElement clickOnRightDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[2]")
	private WebElement clickOnRightIntermideate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[3]")
	private WebElement clickOnRightNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[1]")
	private WebElement clickOnLeftSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/span[2]")
	private WebElement clickOnLeftCylinder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[1]")
	private WebElement clickOnLeftAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[2]/div/div/div/input[2]")
	private WebElement clickOnLeftAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[1]")
	private WebElement clickOnLeftDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[2]")
	private WebElement clickOnLeftIntermideate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-overlay_content\"]/div/table/tbody/tr/td[4]/table/tbody/tr[2]/td/div/table[2]/tbody/tr/td[3]/div/div/div/input[3]")
	private WebElement clickOnLeftNear;

	public PageAddNewContactLens(WebDriverWait wait, WebDriver driver, Actions builder) {
		super();
		this.wait = wait;
		this.driver = driver;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void verifyAddNewContactLense(String provider, String lensMake, String quickNotes, String movement,
			String rotationRight, String surface, String decentration, String rotationLeft, String monovision,
			String prespriction, String sphere, String cylinder, String axis, String add, String distance,
			String intermediate, String near) throws Exception {
		Thread.sleep(7000);
		clickJionOpenencounter.click();
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(4000);
			List<WebElement> select_Provider = driver
					.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
			for (int i = 1; i <= select_Provider.size(); i++)
				if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
					select_Provider.get(i).click();
					break;
				}
		}
		// Thread.sleep(5000);
		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(clickOnOkBtn)).click();
		}
		Thread.sleep(1000);
		ensureElementToBeClickable(clickOnVisonTab);
		clickOnVisonTab.click();

		PgEncounter encounter1 = new PgEncounter(driver, wait, builder);
		encounter1.addNewContacLens(lensMake);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnOdDistanceToReEnterInCL);
		builder = new Actions(driver);
		builder.moveToElement(clickOnOdDistanceToReEnterInCL).click().perform();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnResetAndClear);
		clickOnResetAndClear.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnOdReset);
		builder.moveToElement(clickOnOdReset).click().perform();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnOsReset);
		builder.moveToElement(clickOnOsReset).click().perform();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnSaveAddAnother);
		clickOnSaveAddAnother.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnCancelButton);
		clickOnCancelButton.click();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnOdDistanceToReEnterInCL);
		builder = new Actions(driver);
		builder.moveToElement(clickOnOdDistanceToReEnterInCL).click().perform();

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

		Thread.sleep(2000);
		By select_QuickNotes = By.xpath(".//*[@id=\"gwt-debug-lensPopup-od-fitting-button\"]/div[3]");
		ensureElementToBeClickable(select_QuickNotes);
		driver.findElements(select_QuickNotes).get(0).click();

		Thread.sleep(2000);
		for (WebElement e : QuickNotesRightContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(quickNotes)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnrightEyeAddDetails);
		clickOnrightEyeAddDetails.click();

		Thread.sleep(2000);
		for (WebElement e : moveMentContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(movement)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement e : rotationRightContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(rotationRight)) {
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
		for (WebElement e : surfaceContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(surface)) {
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
		for (WebElement e : decentrationContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(decentration)) {
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
		for (WebElement e : rotationLeftContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(rotationLeft)) {
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
		for (WebElement e : monovisionContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(monovision)) {
				e.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(clickleftNotesCopy);
		builder.moveToElement(clickleftNotesCopy).click().perform();

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnAdddetailsDoneBtn);
		String str = clickOnAdddetailsDoneBtn.getAttribute("innerText");
		System.out.println(str);
		builder.moveToElement(clickOnAdddetailsDoneBtn).click().perform();

		Thread.sleep(2000);
		ensureElementToBeClickable(fillOdPresNotesRight);
		fillOdPresNotesRight.sendKeys(prespriction);

		Thread.sleep(2000);
		ensureElementToBeClickable(select_QuickNotes);
		driver.findElements(select_QuickNotes).get(1).click();

		Thread.sleep(2000);
		for (WebElement e : QuickNotesRightContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(quickNotes)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		By fillOdPresNotesLeft = By.id("gwt-debug-lensPopup-od-notes");
		ensureElementToBeClickable(fillOdPresNotesLeft);
		driver.findElements(fillOdPresNotesLeft).get(1).sendKeys(prespriction);

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnDoneBtnContactLens);
		builder.moveToElement(clickOnDoneBtnContactLens).click().perform();

		Thread.sleep(3000);
		ensureElementToBeClickable(clickOnOdDistanceToReEnterInCL);
		builder = new Actions(driver);
		builder.moveToElement(clickOnOdDistanceToReEnterInCL).click().perform();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnrightEyeAddDetails);
		clickOnrightEyeAddDetails.click();

		// Call modifyDetails function
		Thread.sleep(2000);
		modifyAddDetails();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnrightEyeAddDetails);
		clickOnrightEyeAddDetails.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnConfigureLink);
		clickOnConfigureLink.click();

		// call configureDetailedFittingNotes function
		configureDetailedFittingNotes(movement, rotationRight, surface, decentration, rotationLeft, monovision);

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnAdddetailsDoneBtn);
		builder.moveToElement(clickOnAdddetailsDoneBtn).click().perform();

		// call addOvertRefractionLink
		addOvertRefractionLink(sphere, cylinder, axis, add, distance, intermediate, near);
	}

	public void modifyAddDetails() throws Exception {
		By modifyMovement = By.cssSelector("#gwt-debug-notes-od-selection-topLeft-container>div:nth-child(2)");
		ensureElementToBeClickable(modifyMovement);
		driver.findElement(modifyMovement).click();

		Thread.sleep(2000);
		for (WebElement e : moveMentContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("too loose")) {
				e.click();
				break;
			}
		}
		By modifyRotationRightContainer = By
				.cssSelector("#gwt-debug-notes-od-selection-topMiddle-container>div:nth-child(2)");
		ensureElementToBeClickable(modifyRotationRightContainer);
		driver.findElement(modifyRotationRightContainer).click();

		Thread.sleep(2000);
		for (WebElement e : rotationRightContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("10?")) {
				e.click();
				break;
			}
		}

		By modifySurfaceContainer = By.cssSelector("#gwt-debug-notes-od-selection-topRight-container>div:nth-child(3)");
		ensureElementToBeClickable(modifySurfaceContainer);
		driver.findElement(modifySurfaceContainer).click();

		Thread.sleep(2000);
		for (WebElement e : surfaceContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("lipid")) {
				e.click();
				break;
			}
		}

		By modifyDecentrationContainer = By
				.cssSelector("#gwt-debug-notes-od-selection-bottomLeft-container>div:nth-child(3)");
		ensureElementToBeClickable(modifyDecentrationContainer);
		driver.findElement(modifyDecentrationContainer).click();

		Thread.sleep(2000);
		for (WebElement e : decentrationContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("inferior")) {
				e.click();
				break;
			}
		}
		By modifyRotationLeftContainer = By
				.cssSelector("#gwt-debug-notes-od-selection-bottomMiddle-container>div:nth-child(3)");
		ensureElementToBeClickable(modifyRotationLeftContainer);
		driver.findElement(modifyRotationLeftContainer).click();

		Thread.sleep(2000);
		for (WebElement e : rotationLeftContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("5?")) {
				e.click();
				break;
			}
		}
		By modifyMonovisionContainer = By
				.cssSelector("#gwt-debug-notes-od-selection-bottomRight-container>div:nth-child(2)");
		ensureElementToBeClickable(modifyMonovisionContainer);
		driver.findElement(modifyMonovisionContainer).click();

		Thread.sleep(2000);
		for (WebElement e : monovisionContainer.findElements(By.xpath(".//*"))) {
			// System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("distance")) {
				e.click();
				break;
			}
		}

		Thread.sleep(3000);
		ensureElementToBeClickable(clickleftNotesCopy);
		builder.moveToElement(clickleftNotesCopy).click().perform();

		Thread.sleep(5000);
		ensureElementToBeClickable(clickOnAdddetailsDoneBtn);
		String str = clickOnAdddetailsDoneBtn.getAttribute("innerText");
		System.out.println(str);
		builder.moveToElement(clickOnAdddetailsDoneBtn).click().perform();

	}

	public void configureDetailedFittingNotes(String movement, String rotationRight, String surface,
			String decentration, String rotationLeft, String monovision) throws Exception {

		Thread.sleep(2000);
		for (WebElement e : configureMoveMentContainer.findElements(By.xpath(".//*"))) {
			if (e.getText().equalsIgnoreCase(movement)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement e : configureRotationRightContainer.findElements(By.xpath(".//*"))) {
			if (e.getText().equalsIgnoreCase(rotationRight)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement e : configureSurfaceContainer.findElements(By.xpath(".//*"))) {
			if (e.getText().equalsIgnoreCase(surface)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement e : configureDecentrationContainer.findElements(By.xpath(".//*"))) {
			if (e.getText().equalsIgnoreCase(decentration)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement e : configureRotationLeftContainer.findElements(By.xpath(".//*"))) {
			if (e.getText().equalsIgnoreCase(rotationLeft)) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		for (WebElement e : configureMonovisionContainer.findElements(By.xpath(".//*"))) {
			if (e.getText().equalsIgnoreCase(monovision)) {
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnConfigureDoneBtn);
		clickOnConfigureDoneBtn.click();

	}

	public void addOvertRefractionLink(String sphere, String cylinder, String axis, String add, String distance,
			String intermediate, String near) throws Exception {
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnAddOverRefraction);
		clickOnAddOverRefraction.click();

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnRightSphere);
		clickOnRightSphere.click();

		// select Sphere Value
		List<WebElement> select_Sphere = driver.findElements(By.xpath("/html/body/div[13]/div/div/table/tbody/tr/td"));
		for (int i = 1; i <= select_Sphere.size(); i++) {
			if (select_Sphere.get(i).getText().equalsIgnoreCase(sphere)) {
				select_Sphere.get(i).click();
				break;
			}
		}

//		Thread.sleep(2000);
//		ensureElementToBeClickable(clickOnRightCylinder);
//		clickOnRightCylinder.click();
//
//		// select Cylinder value
//		List<WebElement> select_Cylinder = driver
//				.findElements(By.xpath("/html/body/div[13]/div/div/table/tbody/tr/td"));
//		for (int i = 1; i <= select_Cylinder.size(); i++) {
//			if (select_Cylinder.get(i).getText().equalsIgnoreCase(cylinder)) {
//				select_Cylinder.get(i).click();
//				break;
//			}
//		}

		// Thread.sleep(2000);
		// ensureElementToBeClickable(clickOnRightAxis);
		// clickOnRightAxis.click();
		//
		// // select Axis value
		// List<WebElement> select_Axis =
		// driver.findElements(By.xpath("/html/body/div[13]/div/div/table/tbody/tr/td"));
		// for (int i = 1; i <= select_Axis.size(); i++) {
		// if (select_Axis.get(i).getText().equalsIgnoreCase(axis)) {
		// select_Axis.get(i).click();
		// break;
		// }
		// }

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnRightAdd);
		clickOnRightAdd.click();

		// select Add value
		List<WebElement> select_Add = driver.findElements(By.xpath("/html/body/div[13]/div/div/table[1]/tbody/tr/td"));
		for (int i = 1; i <= select_Add.size(); i++) {
			if (select_Add.get(i).getText().equalsIgnoreCase(add)) {
				select_Add.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnRightDistance);
		clickOnRightDistance.click();
		Thread.sleep(3000);

		// select Distance value
		List<WebElement> select_Distance = driver
				.findElements(By.xpath("/html/body/div[13]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
		for (int i = 1; i <= select_Distance.size(); i++) {
			if (select_Distance.get(i).getText().equalsIgnoreCase(distance)) {
				select_Distance.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnRightIntermideate);
		clickOnRightIntermideate.click();

		// select Intermidate value
		List<WebElement> select_Intermediate = driver
				.findElements(By.xpath("/html/body/div[13]/div/div/div[6]/div[2]/div"));
		for (int i = 1; i <= select_Intermediate.size(); i++) {
			if (select_Intermediate.get(i).getText().equalsIgnoreCase(intermediate)) {
				select_Intermediate.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnRightNear);
		clickOnRightNear.click();

		// select Near value
		List<WebElement> select_Near = driver.findElements(By.xpath("/html/body/div[13]/div/div/div[6]/div[2]/div"));
		for (int i = 1; i <= select_Near.size(); i++) {
			if (select_Near.get(i).getText().equalsIgnoreCase(near)) {
				select_Near.get(i).click();
				break;
			}
		}
		// For left

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLeftSphere);
		clickOnLeftSphere.click();

		// select Sphere Value
		List<WebElement> select_LeftSphere = driver
				.findElements(By.xpath("/html/body/div[13]/div/div/table/tbody/tr/td"));
		for (int i = 1; i <= select_LeftSphere.size(); i++) {
			if (select_LeftSphere.get(i).getText().equalsIgnoreCase(sphere)) {
				select_LeftSphere.get(i).click();
				break;
			}
		}

//		Thread.sleep(2000);
//		ensureElementToBeClickable(clickOnLeftCylinder);
//		clickOnLeftCylinder.click();
//
//		// select Cylinder value
//		List<WebElement> select_LeftCylinder = driver
//				.findElements(By.xpath("/html/body/div[13]/div/div/table/tbody/tr/td"));
//		for (int i = 1; i <= select_LeftCylinder.size(); i++) {
//			if (select_LeftCylinder.get(i).getText().equalsIgnoreCase(cylinder)) {
//				select_LeftCylinder.get(i).click();
//				break;
//			}
//		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLeftAdd);
		clickOnLeftAdd.click();

		// select Add value
		List<WebElement> select_LeftAdd = driver
				.findElements(By.xpath("/html/body/div[13]/div/div/table[1]/tbody/tr/td"));
		for (int i = 1; i <= select_LeftAdd.size(); i++) {
			if (select_LeftAdd.get(i).getText().equalsIgnoreCase(add)) {
				select_LeftAdd.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLeftDistance);
		clickOnLeftDistance.click();

		// select Distance value
		List<WebElement> select_LeftDistance = driver
				.findElements(By.xpath("/html/body/div[13]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
		for (int i = 1; i <= select_LeftDistance.size(); i++) {
			if (select_LeftDistance.get(i).getText().equalsIgnoreCase(distance)) {
				select_LeftDistance.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLeftIntermideate);
		clickOnLeftIntermideate.click();

		// select Intermidate value
		List<WebElement> select_LeftIntermediate = driver
				.findElements(By.xpath("/html/body/div[13]/div/div/div[6]/div[2]/div"));
		for (int i = 1; i <= select_LeftIntermediate.size(); i++) {
			if (select_LeftIntermediate.get(i).getText().equalsIgnoreCase(intermediate)) {
				select_LeftIntermediate.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnLeftNear);
		clickOnLeftNear.click();

		// select Near value
		List<WebElement> select_LeftNear = driver
				.findElements(By.xpath("/html/body/div[13]/div/div/div[6]/div[2]/div"));
		for (int i = 1; i <= select_LeftNear.size(); i++) {
			if (select_LeftNear.get(i).getText().equalsIgnoreCase(near)) {
				select_LeftNear.get(i).click();
				break;
			}
		}
	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void ensureElementToBeClickable(By element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}

}
