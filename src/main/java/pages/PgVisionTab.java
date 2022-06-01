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
import org.testng.Reporter;

public class PgVisionTab {
	private WebDriver driver;
	// Vision page elements

	// Elements for Vision Overview
	@FindBy(how = How.CSS, using = "#gwt-debug-dominantEye-button > div:nth-child(3)")
	private WebElement drpdwnDominantEye;

	@FindBy(how = How.CSS, using = "#gwt-debug-dominantEye-container")
	private WebElement lstDominantEye;

	@FindBy(how = How.CSS, using = "#gwt-debug-pupillaryDistance")
	private WebElement edtbxDistancePD;

	@FindBy(how = How.CSS, using = "#gwt-debug-nearDistance")
	private WebElement edtbxNearPD;

	@FindBy(how = How.CSS, using = "gwt-debug-importFromDevice")
	private WebElement lnkImportFromDevice;

	// Visual Acutity
	// @FindBy(how = How.CSS, using = "span#gwt-debug-uncorrected-addNew")
	@FindBy(how = How.CSS, using = "#gwt-debug-uncorrected-addNew")
	private WebElement lnkAddVision;

	@FindBy(how = How.CSS, using = "span#gwt-debug-uncorrected-delete")
	private WebElement lnkDeleteVision;

	// Visual Acutity Data Entry
	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-scva-od-distance")
	private WebElement edtbxODDistance;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-scva-od-intermediate")
	private WebElement edtbxODIntermediate;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-scva-od-near")
	private WebElement edtbxODNear;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-scva-os-distance")
	private WebElement edtbxOSDistance;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-scva-os-intermediate")
	private WebElement edtbxOSIntermediate;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-scva-os-near")
	private WebElement edtbxOSNear;

	// Binocular VA
	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-binocular-od-distance")
	private WebElement edtbxBinocularVADistance;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-binocular-od-intermediate")
	private WebElement edtbxBinocularVAIntemediate;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-binocular-od-near")
	private WebElement edtbxBinocularVANear;

	// Pinhole VA
	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-ph-od-distance")
	private WebElement edtbxPinHoleVAODDistance;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-ph-od-intermediate")
	private WebElement edtbxPinHoleVAODIntemediate;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-ph-od-near")
	private WebElement edtbxPinHoleVAODNear;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-ph-os-distance")
	private WebElement edtbxPinHoleVAOSDistance;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-ph-os-intermediate")
	private WebElement edtbxPinHoleVAOSIntemediate;

	@FindBy(how = How.CSS, using = "#gwt-debug-acuity-ph-os-near")
	private WebElement edtbxPinHoleVAOSNear;

	@FindBy(how = How.CSS, using = ".GLJD421DCIF > div:nth-child(1) > div:nth-child(2)")
	private WebElement drpdwnCharValue;

	@FindBy(how = How.CSS, using = ".GFEO3AODHFF")
	private WebElement edtbxChart;

	private WebDriverWait wait;
	private Actions actions;

	// Initiallizing vision tab elements
	public PgVisionTab(WebDriver driver) {
		String pgTitle = "Integrity EMR";
		this.driver = driver;
		if (driver.getTitle().contains(pgTitle)) {
			PageFactory.initElements(driver, this);
			Reporter.log("%nPgLogin Instantiated");
		} else {
			Reporter.log("Incorrect Page: Found: " + driver.getTitle() + " while expecting: " + pgTitle);
		}
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		actions = new Actions(driver);
	}

	public void addVisionData(String username, String password) throws Exception {
		addVA();
		// Assert.assertEquals(driver.getTitle(), "Integrity EMR");
	}

	public void addVA() throws InterruptedException {
		Thread.sleep(5 * 1000);
		ensureElementToBeClickable(lnkAddVision);
		lnkAddVision.click();

		String backgroundXpath = "//*[@id='content']/div/div[2]/div[3]/div[3]/div/div[2]/div[2]";

		addValue("Allen (AN)", "20/12", edtbxODDistance, true);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/12", edtbxODIntermediate, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/20", edtbxODNear, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/12", edtbxOSDistance, true);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/12", edtbxOSIntermediate, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/20", edtbxOSNear, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addExaminer("Albert Davis", "#gwt-debug-acuity-scva-examiner");
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/400", edtbxBinocularVADistance, true);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/200", edtbxBinocularVAIntemediate, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Sloan Letters (SL)", "20/200", edtbxBinocularVANear, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addExaminer("Albert Davis", "#gwt-debug-acuity-binocular-examiner");
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/400", edtbxPinHoleVAODDistance, true);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/200", edtbxPinHoleVAODIntemediate, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Sloan Letters (SL)", "20/200", edtbxPinHoleVAODNear, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/400", edtbxPinHoleVAOSDistance, true);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Allen (AN)", "20/200", edtbxPinHoleVAOSIntemediate, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addValue("Sloan Letters (SL)", "20/200", edtbxPinHoleVAOSNear, false);
		clickOnBackGround(By.xpath(backgroundXpath));

		addExaminer("Albert Davis", "#gwt-debug-acuity-ph-examiner");
		clickOnBackGround(By.xpath(backgroundXpath));
	}

	public void addExistingGlasses() throws InterruptedException {
		// @formatter:off
		addExistingGlasses("OD", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12", "Allen (AN),20/20", "Albert Davis", "OD Values");
		addExistingGlasses("OS", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12", "Allen (AN),20/20", "Albert Davis", "OS Values");
		addExistingGlasses("ODBVAG", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12", "Allen (AN),20/20", "Albert Davis", "ODBVAG Values");
		addExistingGlasses("ODPVAG", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12", "Allen (AN),20/20", "Albert Davis", "ODPVAG Values");
		addExistingGlasses("OSPVAG", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12", "Allen (AN),20/20", "Albert Davis", "OSPVAG Values");
		// @formatter:on
	}

	private void addExistingGlasses(String type, String sphere, String cylinder, String axis, String add, String vertex,
			String prism, String distance, String intermediate, String near, String examiner, String comment)
			throws InterruptedException {

		String backgroundId = "gwt-debug-glasses-0";
		String[] distanceVal = distance.split(",");
		String[] intermediateVal = intermediate.split(",");
		String[] nearVal = near.split(",");

		//@formatter:off
		switch (type) {
		case "OD":
			By odRadio = By.id("gwt-debug-glasses-0-od-bcva");
			ensureElementToBeClickable(odRadio);
			WebElement odRadioBtn = driver.findElement(odRadio);
			if (!odRadioBtn.isSelected())
				odRadioBtn.click();

			setValues(sphere, "#gwt-debug-glasses-0-refraction-od-sphere");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(cylinder, "#gwt-debug-glasses-0-refraction-od-cylinder");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(axis, "#gwt-debug-glasses-0-refraction-od-axis");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(add, "#gwt-debug-glasses-0-refraction-od-add");
			clickOnBackGround(By.id(backgroundId));
			
			By vertexBox = By.cssSelector("#gwt-debug-refraction-vertexDistance");
			ensureElementToBeClickable(vertexBox);
			driver.findElement(vertexBox).clear();
			driver.findElement(vertexBox).sendKeys(vertex);
			
			By sliderBox = By.cssSelector("#gwt-debug-glasses-0-prism-od");
			ensureElementToBeClickable(sliderBox);
			driver.findElement(sliderBox).click();
			addPrizm(prism, By.xpath(".//input[@type='range']"), true);
			addPrizm(prism, By.xpath(".//input[@type='range']"), false);
			clickOnBackGround(By.id(backgroundId));
						
			addValue(distanceVal[0], distanceVal[1], driver.findElement(By.cssSelector("#gwt-debug-glasses-0-acuity-od-distance")), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElement(By.cssSelector("#gwt-debug-glasses-0-acuity-od-intermediate")), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElement(By.cssSelector("#gwt-debug-glasses-0-acuity-od-near")), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "OS":
			By osRadio = By.id("gwt-debug-glasses-0-os-bcva");
			ensureElementToBeClickable(osRadio);
			WebElement osRadioBtn = driver.findElement(osRadio);
			if (!osRadioBtn.isSelected())
				osRadioBtn.click();

			setValues(sphere, "#gwt-debug-glasses-0-refraction-os-sphere");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(cylinder, "#gwt-debug-glasses-0-refraction-os-cylinder");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(axis, "#gwt-debug-glasses-0-refraction-os-axis");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(add, "#gwt-debug-glasses-0-refraction-os-add");
			clickOnBackGround(By.id(backgroundId));
			
			By vertexOSBox = By.cssSelector("#gwt-debug-refraction-vertexDistance");
			ensureElementToBeClickable(vertexOSBox);
			driver.findElement(vertexOSBox).clear();
			driver.findElement(vertexOSBox).sendKeys(vertex);
			
			sliderBox = By.cssSelector("#gwt-debug-glasses-0-prism-os");
			ensureElementToBeClickable(sliderBox);
			driver.findElement(sliderBox).click();
			addPrizm(prism, By.xpath(".//input[@type='range']"), true);
			addPrizm(prism, By.xpath(".//input[@type='range']"), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(distanceVal[0], distanceVal[1], driver.findElement(By.cssSelector("#gwt-debug-glasses-0-acuity-os-distance")), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElement(By.cssSelector("#gwt-debug-glasses-0-acuity-os-intermediate")), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElement(By.cssSelector("#gwt-debug-glasses-0-acuity-os-near")), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "ODBVAG":
			// TODO: This will not work until pinhole id will be changed
			addValue(distanceVal[0], distanceVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-od-distance")).get(0), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-od-intermediate")).get(0), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-od-near")).get(0), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "ODPVAG":
			// TODO: needs to change the id of pinhole div
			addValue(distanceVal[0], distanceVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-od-distance")).get(1), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-od-intermediate")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-od-near")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "OSPVAG":
			// TODO: needs to change the id of pinhole div
			addValue(distanceVal[0], distanceVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-os-distance")).get(1), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-os-intermediate")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElements(By.cssSelector("#gwt-debug-glasses-0-binocular-os-near")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			
			break;

		default:
			break;
		}
//formatter:on
	}
	
	public void addRefractions() throws InterruptedException {
	//	@formatter:off
		addRefraction("OD", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12",	"Allen (AN),20/20", "Albert Davis", "OD Values");
		addRefraction("OS", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12",	"Allen (AN),20/20", "Albert Davis", "OS Values");
		addRefraction("ODBVAG", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12",	"Allen (AN),20/20", "Albert Davis", "ODBVAG Values");
		addRefraction("ODPVAG", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12",	"Allen (AN),20/20", "Albert Davis", "ODPVAG Values");
		addRefraction("OSPVAG", "0.25", "-0.25", "12", "+0.25", "14", "20", "Allen (AN),20/12", "Allen (AN),20/12",	"Allen (AN),20/20", "Albert Davis", "OSPVAG Values");
	// @formatter:on
	}

	private void addRefraction(String type, String sphere, String cylinder, String axis, String add, String vertex,
			String prism, String distance, String intermediate, String near, String examiner, String comment)
			throws InterruptedException {

		String backgroundId = "gwt-debug-refractions-0";
		String[] distanceVal = distance.split(",");
		String[] intermediateVal = intermediate.split(",");
		String[] nearVal = near.split(",");

		//@formatter:off
		switch (type) {
		case "OD":
			By odRadio = By.id("gwt-debug-refractions-0-od-bcva");
			ensureElementToBeClickable(odRadio);
			WebElement odRadioBtn = driver.findElement(odRadio);
			if (!odRadioBtn.isSelected())
				odRadioBtn.click();

			setValues(sphere, "#gwt-debug-refractions-0-refraction-od-sphere");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(cylinder, "#gwt-debug-refractions-0-refraction-od-cylinder");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(axis, "#gwt-debug-refractions-0-refraction-od-axis");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(add, "#gwt-debug-refractions-0-refraction-od-add");
			clickOnBackGround(By.id(backgroundId));
			
			By vertexBox = By.cssSelector("#gwt-debug-refraction-vertexDistance");
			ensureElementToBeClickable(vertexBox);
			driver.findElements(vertexBox).get(1).clear();
			driver.findElements(vertexBox).get(1).sendKeys(vertex);
			
			By sliderBox = By.cssSelector("#gwt-debug-refractions-0-prism-od");
			ensureElementToBeClickable(sliderBox);
			driver.findElement(sliderBox).click();
			addPrizm(prism, By.xpath(".//input[@type='range']"), true);
			addPrizm(prism, By.xpath(".//input[@type='range']"), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(distanceVal[0], distanceVal[1], driver.findElement(By.cssSelector("#gwt-debug-refractions-0-acuity-od-distance")), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElement(By.cssSelector("#gwt-debug-refractions-0-acuity-od-intermediate")), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElement(By.cssSelector("#gwt-debug-refractions-0-acuity-od-near")), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "OS":
			By osRadio = By.id("gwt-debug-refractions-0-os-bcva");
			ensureElementToBeClickable(osRadio);
			WebElement osRadioBtn = driver.findElement(osRadio);
			if (!osRadioBtn.isSelected())
				osRadioBtn.click();

			setValues(sphere, "#gwt-debug-refractions-0-refraction-os-sphere");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(cylinder, "#gwt-debug-refractions-0-refraction-os-cylinder");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(axis, "#gwt-debug-refractions-0-refraction-os-axis");
			clickOnBackGround(By.id(backgroundId));
			
			setValues(add, "#gwt-debug-refractions-0-refraction-os-add");
			clickOnBackGround(By.id(backgroundId));
			
			By vertexOSBox = By.cssSelector("#gwt-debug-refraction-vertexDistance");
			ensureElementToBeClickable(vertexOSBox);
			driver.findElements(vertexOSBox).get(1).clear();
			driver.findElements(vertexOSBox).get(1).sendKeys(vertex);
			
			sliderBox = By.cssSelector("#gwt-debug-refractions-0-prism-os");
			ensureElementToBeClickable(sliderBox);
			driver.findElement(sliderBox).click();
			addPrizm(prism, By.xpath(".//input[@type='range']"), true);
			addPrizm(prism, By.xpath(".//input[@type='range']"), false);
			clickOnBackGround(By.id(backgroundId));
					
			
			addValue(distanceVal[0], distanceVal[1], driver.findElement(By.cssSelector("#gwt-debug-refractions-0-acuity-os-distance")), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElement(By.cssSelector("#gwt-debug-refractions-0-acuity-os-intermediate")), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElement(By.cssSelector("#gwt-debug-refractions-0-acuity-os-near")), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "ODBVAG":
			// TODO: This will not work until pinhole id will be changed
			addValue(distanceVal[0], distanceVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-od-distance")).get(0), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-od-intermediate")).get(0), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-od-near")).get(0), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "ODPVAG":
			// TODO: needs to change the id of pinhole div
			addValue(distanceVal[0], distanceVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-od-distance")).get(1), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-od-intermediate")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-od-near")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			break;

		case "OSPVAG":
			// TODO: needs to change the id of pinhole div
			addValue(distanceVal[0], distanceVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-os-distance")).get(1), true);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(intermediateVal[0], intermediateVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-os-intermediate")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			
			addValue(nearVal[0], nearVal[1], driver.findElements(By.cssSelector("#gwt-debug-refractions-0-binocular-os-near")).get(1), false);
			clickOnBackGround(By.id(backgroundId));
			
			break;

		default:
			break;
		}
		//formatter:on
	}

	public void addContactLens() {
		
	}

	private void clickOnBackGround(By background) {
		ensureElementToBeClickable(background);
		WebElement glassesBackgroudElement = driver.findElement(background);
		int x = glassesBackgroudElement.getLocation().getX() + glassesBackgroudElement.getSize().getWidth() - 30;
		int y = glassesBackgroudElement.getLocation().getY() + glassesBackgroudElement.getSize().getHeight() - 30;
		
		actions.moveToElement(glassesBackgroudElement, x, y).click().build().perform();
	}
	
	private void setValues(String value, String selector) throws InterruptedException {
		By valueBox = By.cssSelector(selector);
		ensureElementToBeClickable(valueBox);
		driver.findElement(valueBox).click();
		Thread.sleep(2 * 1000);
		By valuesInBox = By.cssSelector(".gwt-PopupPanel > .popupContent > div > table > tbody > tr > td");
		List<WebElement> valuesList = driver.findElements(valuesInBox);
		for (WebElement val : valuesList) {
			if (val.getText().equalsIgnoreCase(value)) {
				val.click();
				break;
			}
		}
	}
	
	public void importExistingGlasses() throws InterruptedException {
		int count = getTotalOldGlasses();
		count = count > 2 ? 2 : count;
		By closeLink = By.cssSelector("#gwt-debug-");
		ensureElementToBeClickable(closeLink);
		driver.findElement(closeLink).click();
		
		for (int i = 0; i < count ; i++) {
			importGlasses(i);
		}
	}
	
	private void importGlasses(int selealNo) {
		By importGlassLink = By.cssSelector("#gwt-debug-glasses-importOld");
		try {
			Thread.sleep(4 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement importGlassLinkElement =  driver.findElement(importGlassLink);
		if (!importGlassLinkElement.isEnabled()) {
			Reporter.log("No import exists");
			return;
		}
		ensureElementToBeClickable(importGlassLinkElement);
		importGlassLinkElement.click();
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectAppropriateType("Glasses");
		By importBtn = By.linkText("Import");
		ensureElementToBeClickable(importBtn);
		driver.findElements(importBtn).get(selealNo).click();
	}
	
	private int getTotalOldGlasses() {
		By importGlassLink = By.cssSelector("#gwt-debug-glasses-importOld");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ensureElementToBeClickable(importGlassLink);
		WebElement importGlassLinkElement =  driver.findElement(importGlassLink);
		if (!importGlassLinkElement.isEnabled()) {
			Reporter.log("No import exists");
			return 0;
		}
		ensureElementToBeClickable(importGlassLinkElement);
		importGlassLinkElement.click();
		try {
			Thread.sleep(4 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectAppropriateType("Glasses");
		
		By importBtn = By.linkText("Import");
		ensureElementToBeClickable(importBtn);
		return driver.findElements(importBtn).size();
	}
	
	public void importRefractions() throws InterruptedException {
		int count = getTotalRefractions();
		count = count > 2 ? 2 : count;
		By closeLink = By.cssSelector("#gwt-debug-");
		ensureElementToBeClickable(closeLink);
		driver.findElement(closeLink).click();
		
		for (int i = 0; i < count ; i++) {
			importRefractions(i);
		}
	}
	
	private void importRefractions(int selealNo) {
		By importRefractionsLink = By.cssSelector("#gwt-debug-refraction-importOld");
		try {
			Thread.sleep(4 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement importRefractionsLinkElement =  driver.findElement(importRefractionsLink);
		if (!importRefractionsLinkElement.isEnabled()) {
			Reporter.log("No import exists");
			return;
		}
		ensureElementToBeClickable(importRefractionsLinkElement);
		importRefractionsLinkElement.click();
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectAppropriateType("Refraction");
		By importBtn = By.linkText("Import");
		ensureElementToBeClickable(importBtn);
		driver.findElements(importBtn).get(selealNo).click();
	}
	
	
	private int getTotalRefractions() {
		By importRefractionsLink = By.cssSelector("#gwt-debug-refraction-importOld");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ensureElementToBeClickable(importRefractionsLink);
		WebElement importRefractionsLinkElement =  driver.findElement(importRefractionsLink);
		if (!importRefractionsLinkElement.isEnabled()) {
			Reporter.log("No import exists");
			return 0;
		}
		ensureElementToBeClickable(importRefractionsLinkElement);
		importRefractionsLinkElement.click();
		try {
			Thread.sleep(4 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectAppropriateType("Glasses");
		
		By importBtn = By.linkText("Import");
		ensureElementToBeClickable(importBtn);
		return driver.findElements(importBtn).size();
	}

	private void selectAppropriateType(String type) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		By dropDownbox = By.xpath("//div[@id='gwt-debug-overlay_content']/div/div/div[2]/div/div/div[3]");
		ensureElementToBeClickable(dropDownbox);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(dropDownbox).click();
		By options = By.cssSelector(".gwt-PopupPanel > div > div > div > div > div");
		
		ensureElementToBeClickable(options);
		List<WebElement> optionsElement = driver.findElements(options);
		
		for (WebElement opt : optionsElement) {
			String text = opt.getText();
			if (text.equalsIgnoreCase(type)) {
				opt.click();
				break;
			}
		}
	}

	public void importContactLens() {

	}

	private void addKeratometry() {

	}

	private void importKeratometry() {

	}

	private void prescribeGlasses() {

	}

	private void prescribeContacts() {

	}

	private void addValue(String chart, String value, WebElement box, boolean isDistance) {

		try {
			ensureElementToBeClickable(box);
			actions.moveToElement(box).click().perform();

			By metricValueBox = By.cssSelector(".popupContent > div > div:nth-child(2)");
			ensureElementToBeClickable(metricValueBox);
			driver.findElement(metricValueBox).click();
			Thread.sleep(2 * 1000);
			
			By metricsTable = By.cssSelector(".gwt-PopupPanel>.popupContent>div>div>div:nth-child(2)>div");
			ensureElementToBeClickable(metricsTable);
			List<WebElement> metrics =  driver.findElements(metricsTable);
			for (WebElement metricElement : metrics) {
				String metricVal = metricElement.getText();
				if (metricVal.equalsIgnoreCase(chart)) {
					ensureElementToBeClickable(metricElement);
					metricElement.click();
					break;
				}
			}
			
			By doneBtn = By.xpath("//*[text()='Done']");
			ensureElementToBeClickable(doneBtn);
			driver.findElement(doneBtn).click();
			

			By valueTable = null;
			if (isDistance) {
				valueTable = By.cssSelector(".gwt-PopupPanel>.popupContent>div>div>div>table>tbody>tr>td");
				ensureElementToBeClickable(valueTable);
				List<WebElement> values = driver.findElements(valueTable);
				outer:
				for (WebElement td : values) {
					for (WebElement val : td.findElements(By.xpath(".//*"))) {
						String valText = val.getText();
						if (valText.equalsIgnoreCase(value)) {
							ensureElementToBeClickable(val);
							actions.moveToElement(val).click().build().perform();
							break outer;
						}
					}
				}
			} else {
				valueTable = By.cssSelector(".gwt-PopupPanel>.popupContent>div>div>div>div");
				List<WebElement> elements = driver.findElements(valueTable);
				for (WebElement val : elements) {
					String valText = val.getText();
					if (valText.equalsIgnoreCase(value)) {
						ensureElementToBeClickable(val);
						val.click();
						break;
					}
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addExaminer(String examiner, String selector) throws InterruptedException {
		By examinerLink = By.cssSelector(selector);
		ensureElementToBeClickable(examinerLink);
		actions.moveToElement(driver.findElement(examinerLink)).click().build().perform();
		
		By examinerList = By.cssSelector(".gwt-PopupPanel > .popupContent > div > div:nth-child(2) > div");
		List<WebElement> examiners = driver.findElements(examinerList);

		for (WebElement e : examiners) {
			String elemText = e.getText().trim();
			if (elemText.equalsIgnoreCase(examiner)) {
				e.click();
				break;
			}
		}
	}

	private void addPrizm(String prism, By slider, boolean isFirst) {
		ensureElementToBeVisible(slider);
		int prismValue = Integer.parseInt(prism);
		WebElement sliderElement = null;
		if (isFirst) {
			sliderElement = driver.findElements(slider).get(0);
		} else {
			sliderElement = driver.findElements(slider).get(1);
		}
		if (prismValue <= 30) {
			prismValue = -(30 - prismValue);
		}
		prismValue = (prismValue % 30) * 10;
		actions.dragAndDropBy(sliderElement, prismValue + 2, 0).release().build().perform();
	}

	
	private void ensureElementToBeVisible(By slider) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(slider));
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}