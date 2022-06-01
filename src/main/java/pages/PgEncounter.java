package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PgEncounter {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	public String getData;

	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgLanding lclPgLanding;
	PgPatientSearch patientsearch;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-listOpenEncounterWidget\"]/a")
	private WebElement clickJionOpenencounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-ok\"]")
	private WebElement clickOnOkBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-eyeHistory-pastProblemsWidget\"]/div[1]/div[1]/div/div[1]/span[1]")
	private WebElement clickOnAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-icd10popup--done\"]/a")
	private WebElement doneBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-dominantEye-button\"]/div[3]")
	private WebElement clickOndominantEye;

	@FindBy(how = How.CSS, using = "#content > div > div> div > div> div > div> table > tbody>tr>td:nth-child(5)>input")
	private WebElement modifydistance;

	@FindBy(how = How.CSS, using = "#content > div > div> div > div> div > div> table > tbody>tr>td:nth-child(7)>input")
	private WebElement modifyNear;

	@FindBy(how = How.CSS, using = "#gwt-debug-uncorrected-addNew")
	private WebElement uncottectedVisionClick;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-normal-od-distance\"]")
	private WebElement clickOdDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-normal-od-intermediate\"]")
	private WebElement clickOdIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-normal-od-near\"]")
	private WebElement clickOdNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-normal-os-distance\"]")
	private WebElement clickOsDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-normal-os-intermediate\"]")
	private WebElement clickOsIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-normal-os-near\"]")
	private WebElement clickOsNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-binocular-od-distance\"]")
	private WebElement clickBinocularDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-binocular-od-intermediate\"]")
	private WebElement clickBinocularIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-binocular-od-near\"]")
	private WebElement clickBinocularNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-pinhole-od-distance\"]")
	private WebElement clickpinholeDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-pinhole-od-intermediate\"]")
	private WebElement clickpinholeIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-pinhole-od-near\"]")
	private WebElement clickpinholeNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-pinhole-os-distance\"]")
	private WebElement clickpinholeOSDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-pinhole-os-intermediate\"]")
	private WebElement clickpinholeOsIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-acuity-pinhole-os-near\"]")
	private WebElement clickpinholeOsNear;

	@FindBy(how = How.CSS, using = "#gwt-debug-glasses-addNew")
	private WebElement clickOnExistingGlass;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-od\"]/input[1]")
	private WebElement clickOnOdSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-od\"]/input[2]")
	private WebElement clickOnodcyliender;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-od\"]/input[3]")
	private WebElement clickOnodAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-od\"]/input[4]")
	private WebElement clickOnodAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-os\"]/input[1]")
	private WebElement clickOnOsSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-os\"]/input[2]")
	private WebElement clickOnoscyliender;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-os\"]/input[3]")
	private WebElement clickOnosAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-refraction-os\"]/input[4]")
	private WebElement clickOnosAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-prism\"]/div[2]/input")
	private WebElement clickOnPrism;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-prism\"]/div[3]/input")
	private WebElement clickOn2Prism;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-acuity-od\"]/input[1]")
	private WebElement clickOnodDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-acuity-os\"]/input[1]")
	private WebElement clickOnosDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-acuity-od\"]/input[2]")
	private WebElement clickOnodIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-acuity-os\"]/input[2]")
	private WebElement clickOnosIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-acuity-od\"]/input[3]")
	private WebElement clickOnodNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0-acuity-os\"]/input[3]")
	private WebElement clickOnosNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[3]/span[1]")
	private WebElement clickonOdComment;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/textarea")
	private WebElement fillOdComment;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[3]/span[2]")
	private WebElement clickonOsComment;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/textarea")
	private WebElement fillOsComment;

	@FindBy(how = How.CSS, using = "#gwt-debug-refraction-addNew")
	private WebElement clickOnRefractionGlass;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-od\"]/input[1]")
	private WebElement clickOnOdRefractionSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-od\"]/input[2]")
	private WebElement clickOnodRefractioncyliender;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-od\"]/input[3]")
	private WebElement clickOnodRefractionAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-od\"]/input[4]")
	private WebElement clickOnodRefractionAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-os\"]/input[1]")
	private WebElement clickOnOsRefractionSphere;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-os\"]/input[2]")
	private WebElement clickOnosRefractioncyliender;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-os\"]/input[3]")
	private WebElement clickOnosRefractionAxis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-refraction-os\"]/input[4]")
	private WebElement clickOnosRefractionAdd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-prism\"]/div[2]/input")
	private WebElement clickOnRefractionPrism;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-prism\"]/div[3]/input")
	private WebElement clickOn2RefractionPrism;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-acuity-od\"]/input[1]")
	private WebElement clickOnodRefractionDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-acuity-os\"]/input[1]")
	private WebElement clickOnosRefractionDistance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-acuity-od\"]/input[2]")
	private WebElement clickOnodRefractionIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-acuity-os\"]/input[2]")
	private WebElement clickOnosRefractionIntermediate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-acuity-od\"]/input[3]")
	private WebElement clickOnodRefractionNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0-acuity-os\"]/input[3]")
	private WebElement clickOnosRefractionNear;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[3]/span[1]")
	private WebElement clickonOdRefractionComment;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/textarea")
	private WebElement fillOdRefractionComment;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[3]/span[2]")
	private WebElement clickonOsRefractionComment;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div/textarea")
	private WebElement fillOsRefractionComment;

	@FindBy(how = How.CSS, using = "#gwt-debug-addNewContactLens")
	private WebElement clickOnContactLens;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lensPopup-od-make-button\"]/div[3]")
	private WebElement clickOnLensMake1;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/table/tbody/tr/td[1]/div/a")
	private WebElement clickOnShowAll;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-lens-copyRight\"]")
	private WebElement clickOnCopyRightEye;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-popup-done\"]/a")
	private WebElement clickOnDoneBtnContactLens;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div[3]/div[3]/div/div[2]/div[9]/div/div[1]/span[3]")
	private WebElement clickOnKeratometry;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-od\"]/table/tbody/tr[2]/td[2]/input")
	private WebElement clickOnRightRadiusTextBoxK1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-od\"]/table/tbody/tr[2]/td[3]/input")
	private WebElement clickOnRightPowerTextK1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-od\"]/table/tbody/tr[2]/td[4]/input")
	private WebElement clickOnRightAxisTextK1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-od\"]/table/tbody/tr[3]/td[2]/input")
	private WebElement clickOnRightRadiusTextBoxK2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-od\"]/table/tbody/tr[3]/td[3]/input")
	private WebElement clickOnRightPowerTextK2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-od\"]/table/tbody/tr[3]/td[4]/input")
	private WebElement clickOnRightAxisTextK2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-os\"]/table/tbody/tr[2]/td[2]/input")
	private WebElement clickOnLeftRadiusTextBoxK1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-os\"]/table/tbody/tr[2]/td[3]/input")
	private WebElement clickOnLeftPowerTextK1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-os\"]/table/tbody/tr[2]/td[4]/input")
	private WebElement clickOnLeftAxisTextK1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-os\"]/table/tbody/tr[3]/td[2]/input")
	private WebElement clickOnLeftRadiusTextBoxK2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-os\"]/table/tbody/tr[3]/td[3]/input")
	private WebElement clickOnLeftPowerTextK2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-os\"]/table/tbody/tr[3]/td[4]/input")
	private WebElement clickOnLeftAxisTextK2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-instrument-button\"]/div[3]")
	private WebElement clickOnInstruMentOfRighteye;

	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-comment\"]")
	private WebElement fillCommentInKeratomatery;

	// @FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-kpopup-done\"]/a")
	// private WebElement clickOnDoneBtnOfKeratometry;

	@FindBy(how = How.CSS, using = "div#gwt-debug-kpopup-done>a")
	private WebElement clickOnDoneBtnOfKeratometry;

	@FindBy(how = How.XPATH, using = ".//a[text()='Cancel']")
	private WebElement clickOnCancelBtn;
	@FindBy(how = How.XPATH, using = ".//*[text()=\"My Dashboard\"]")
	private WebElement clickOnMyDashBoard;

	public PgEncounter(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, this);

	}

	public void addUncorrectedVA(String provider, String history, String category, String subCategory,
			String subCategory1, String eye, String glaucomaSeverity, String glaucomaStability, String vision,
			String dominantEye, String distance, String near, String odDistance, String odIntermidiate, String odNear,
			String osDistance, String osIntermidiate, String osNear, String binocularDistance,
			String binocularIntermidiate, String binocularNear, String pinholeDistance, String pinholeIntermidiate,
			String pinholeNear) throws InterruptedException {
		// click on JionOpenencounter
		// Thread.sleep(5000);
		// clickJionOpenencounter.click();
		//
		// // select_Provider
		// Thread.sleep(2000);
		// List<WebElement> select_Provider = driver
		// .findElements(By.xpath("//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		// for (int i = 1; i <= select_Provider.size(); i++)
		// if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
		// select_Provider.get(i).click();
		// break;
		//
		// }

		Thread.sleep(7000);
		clickJionOpenencounter.click();
		Thread.sleep(7000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(5000);
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

		else if (select_RowFromOpenEncounter <= 0) {
			Thread.sleep(7000);
			clickStartNewEncounter.click();

		}

		// select eyeHistory
		Thread.sleep(7000);
		java.util.List<WebElement> eyeHiostoryClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < eyeHiostoryClick.size(); i++)
			if (eyeHiostoryClick.get(i).getText().equalsIgnoreCase(history)) {
				eyeHiostoryClick.get(i).click();
				break;

			}

		Thread.sleep(7000);
		clickOnAdd.click();

		// select category Glaucoma
		Thread.sleep(7000);
		java.util.List<WebElement> gulcomaCategoryClick = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaCategoryClick.size(); i++)
			if (gulcomaCategoryClick.get(i).getText().equalsIgnoreCase(category)) {
				gulcomaCategoryClick.get(i).click();
				break;

			}

		// select subCategory Glaucoma with Other Disorders
		Thread.sleep(5000);
		java.util.List<WebElement> gulcomaSubCategoryClick = driver.findElements(
				By.xpath("//*[@id='gwt-debug-overlay_content']/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategoryClick.size(); i++)
			if (gulcomaSubCategoryClick.get(i).getText().equalsIgnoreCase(subCategory)) {
				gulcomaSubCategoryClick.get(i).click();
				break;

			}

		// select subCategory1 Glaucoma
		Thread.sleep(2000);
		java.util.List<WebElement> gulcomaSubCategory1Click = driver.findElements(
				By.xpath("//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[4]/div[2]/div"));
		for (int i = 0; i < gulcomaSubCategory1Click.size(); i++)
			if (gulcomaSubCategory1Click.get(i).getText().equalsIgnoreCase(subCategory1)) {
				gulcomaSubCategory1Click.get(i).click();
				break;

			}

		// select Glaucoma Eye
		Thread.sleep(5000);
		java.util.List<WebElement> gulcomaEyeClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaEyeClick.size(); i++)
			if (gulcomaEyeClick.get(i).getText().equalsIgnoreCase(eye)) {
				gulcomaEyeClick.get(i).click();
				break;

			}

		// select Glaucoma Severity
		Thread.sleep(5000);
		java.util.List<WebElement> gulcomaSeverityClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div"));
		for (int i = 0; i < gulcomaSeverityClick.size(); i++)
			if (gulcomaSeverityClick.get(i).getText().equalsIgnoreCase(glaucomaSeverity)) {
				gulcomaSeverityClick.get(i).click();
				break;

			}

		// select Glaucoma Stability
		Thread.sleep(5000);
		java.util.List<WebElement> gulcomaStabilityClick = driver.findElements(By.xpath(
				"//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div"));
		for (int i = 0; i < gulcomaStabilityClick.size(); i++)
			if (gulcomaStabilityClick.get(i).getText().equalsIgnoreCase(glaucomaStability)) {
				gulcomaStabilityClick.get(i).click();
				break;

			}

		// Click on Done Button
		Thread.sleep(5000);
		doneBtn.click();

		// select vision
		Thread.sleep(5000);
		java.util.List<WebElement> visionClick = driver
				.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td> div"));
		for (int i = 0; i < visionClick.size(); i++)
			if (visionClick.get(i).getText().equalsIgnoreCase(vision)) {
				visionClick.get(i).click();
				break;

			}

		Thread.sleep(3000);
		clickOndominantEye.click();

		// select from dominant Eye
		Thread.sleep(6000);
		java.util.List<WebElement> dominanteye = driver
				.findElements(By.cssSelector("#gwt-debug-dominantEye > div>div"));
		for (int i = 0; i < dominanteye.size(); i++)
			if (dominanteye.get(i).getText().equalsIgnoreCase(dominantEye)) {
				dominanteye.get(i).click();
				break;
			}

		// enter the values in email
		Thread.sleep(4000);
		modifydistance.clear();
		Thread.sleep(4000);
		modifydistance.sendKeys(distance);

		// enter the values in email
		Thread.sleep(4000);
		modifyNear.clear();
		Thread.sleep(4000);
		modifyNear.sendKeys(near);

		Thread.sleep(3000);
		uncottectedVisionClick.click();

		// click Od Distance
		Thread.sleep(3000);
		clickOdDistance.click();

		// fill the value in OD distance
		Thread.sleep(5000);
		java.util.List<WebElement> fillOdDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
		for (int i = 0; i < fillOdDistance.size(); i++)
			if (fillOdDistance.get(i).getText().equalsIgnoreCase(odDistance)) {
				fillOdDistance.get(i).click();
				break;
			}

		// click the OD intermideate
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickOdIntermediate.click();

		// fill the value in OD intermidiate
		Thread.sleep(3000);
		java.util.List<WebElement> fillOdIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOdIntermediate.size(); i++)
			if (fillOdIntermediate.get(i).getText().equalsIgnoreCase(odIntermidiate)) {
				fillOdIntermediate.get(i).click();
				break;
			}

		// click the OD near
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickOdNear.click();

		// fill the value in OD Near
		Thread.sleep(3000);
		java.util.List<WebElement> fillOdNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOdNear.size(); i++)
			if (fillOdNear.get(i).getText().equalsIgnoreCase(odNear)) {
				fillOdNear.get(i).click();
				break;
			}

		// click Os Distance
		Thread.sleep(3000);
		clickOsDistance.click();

		// fill the value in OS distance
		Thread.sleep(3000);
		java.util.List<WebElement> fillOsDistance1 = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td[1]/div"));
		for (int i = 0; i < fillOsDistance1.size(); i++)
			if (fillOsDistance1.get(i).getText().equalsIgnoreCase(osDistance)) {
				fillOsDistance1.get(i).click();
				break;
			}

		// click the OS intermideate
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickOsIntermediate.click();

		// fill the value in OS intermidiate
		Thread.sleep(3000);
		java.util.List<WebElement> fillOsIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOsIntermediate.size(); i++)
			if (fillOsIntermediate.get(i).getText().equalsIgnoreCase(osIntermidiate)) {
				fillOsIntermediate.get(i).click();
				break;
			}

		// click the OS near
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickOsNear.click();

		// fill the value in OS Near
		Thread.sleep(3000);
		java.util.List<WebElement> fillOsNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOsNear.size(); i++)
			if (fillOsNear.get(i).getText().equalsIgnoreCase(osNear)) {
				fillOsNear.get(i).click();
				break;
			}

		// click Binocular Distance
		Thread.sleep(3000);
		clickBinocularDistance.click();

		// fill the value in OS distance
		Thread.sleep(3000);
		java.util.List<WebElement> fillBinocularDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td[1]/div"));
		for (int i = 0; i < fillBinocularDistance.size(); i++)
			if (fillBinocularDistance.get(i).getText().equalsIgnoreCase(binocularDistance)) {
				fillBinocularDistance.get(i).click();
				break;
			}

		// click the Binocular intermideate
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickBinocularIntermediate.click();

		// fill the value in OS intermidiate
		Thread.sleep(3000);
		java.util.List<WebElement> fillBinocularIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillBinocularIntermediate.size(); i++)
			if (fillBinocularIntermediate.get(i).getText().equalsIgnoreCase(binocularIntermidiate)) {
				fillBinocularIntermediate.get(i).click();
				break;
			}
		// click the Binocular near
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickBinocularNear.click();

		// fill the value in Binocular Near
		Thread.sleep(3000);
		java.util.List<WebElement> fillBinocularNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillBinocularNear.size(); i++)
			if (fillBinocularNear.get(i).getText().equalsIgnoreCase(binocularNear)) {
				fillBinocularNear.get(i).click();
				break;
			}

		// click pinhole OD Distance
		Thread.sleep(3000);
		clickpinholeDistance.click();

		// fill the value in pinhole OD distance
		Thread.sleep(3000);
		java.util.List<WebElement> fillpinholeDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td[1]/div"));
		for (int i = 0; i < fillpinholeDistance.size(); i++)
			if (fillpinholeDistance.get(i).getText().equalsIgnoreCase(pinholeDistance)) {
				fillpinholeDistance.get(i).click();
				break;
			}

		// click the pinhole OD intermideate
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickpinholeIntermediate.click();

		// fill the value in pinhole OD intermidiate
		Thread.sleep(3000);
		java.util.List<WebElement> fillpinholeIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillpinholeIntermediate.size(); i++)
			if (fillpinholeIntermediate.get(i).getText().equalsIgnoreCase(pinholeIntermidiate)) {
				fillpinholeIntermediate.get(i).click();
				break;

			}

		// click the pinhole OD near
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickpinholeNear.click();

		// fill the value in Binocular OD Near
		Thread.sleep(3000);
		java.util.List<WebElement> fillpinholeNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillpinholeNear.size(); i++)
			if (fillpinholeNear.get(i).getText().equalsIgnoreCase(pinholeNear)) {
				fillpinholeNear.get(i).click();
				break;
			}

		// click pinhole OS Distance
		Thread.sleep(3000);
		clickpinholeOSDistance.click();

		// fill the value in pinhole OS distance
		Thread.sleep(3000);
		java.util.List<WebElement> fillpinholeOSDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td[1]/div"));
		for (int i = 0; i < fillpinholeOSDistance.size(); i++)
			if (fillpinholeOSDistance.get(i).getText().equalsIgnoreCase(pinholeDistance)) {
				fillpinholeOSDistance.get(i).click();
				break;
			}

		// click the pinhole OS intermideate
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickpinholeOsIntermediate.click();

		// fill the value in pinhole OS intermidiate
		Thread.sleep(3000);
		java.util.List<WebElement> fillpinholeOsIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillpinholeOsIntermediate.size(); i++)
			if (fillpinholeOsIntermediate.get(i).getText().equalsIgnoreCase(pinholeIntermidiate)) {
				fillpinholeOsIntermediate.get(i).click();
				break;

			}

		// click the pinhole OS near
		// Thread.sleep(3000);
		clickForEnableElement();
		Thread.sleep(3000);
		// ensureElementToBeClickable(clickOdIntermediate);
		clickpinholeOsNear.click();

		// fill the value in Binocular OS Near
		Thread.sleep(3000);
		java.util.List<WebElement> fillpinholeOsNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillpinholeOsNear.size(); i++)
			if (fillpinholeOsNear.get(i).getText().equalsIgnoreCase(pinholeNear)) {
				fillpinholeOsNear.get(i).click();
				break;
			}
		clickForEnableElement();

	}

	// click to addNew Existing Glass and fill the value un Existing Glass

	public void addNewExistingglass(String od, String odSPhere, String odCyliender, String odAxis, String odAdd,
			String os, String osSphere, String osCyliender, String osAxis, String osAdd, String prism, String prism1,
			String prism2, String prism3, String odDistance, String osDistance, String odIntermediate,
			String osIntermediate, String odNear, String osNear, String OdComment, String osComment)
			throws InterruptedException {

		// click on Addnew
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		// clickOnExistingGlass.click();
		// wait.until(ExpectedConditions.visibilityOf(clickOnExistingGlass)).click();
		wait.until(ExpectedConditions.elementToBeClickable(clickOnExistingGlass)).click();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", clickOnExistingGlass);
		// chose Od RadioButton

		Thread.sleep(5000);
		String getOdText = driver
				.findElement(By.xpath("//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[1]/div[1]/div[1] "))
				.getText();
		System.out.println(getOdText);
		Thread.sleep(3000);
		if (getOdText.equalsIgnoreCase(od)) {
			driver.findElement(By.xpath("//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[1]/div[2]/div[1]")).click();
		}

		// Click on odSphere
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnOdSphere));
		clickOnOdSphere.click();

		// fill rhe value in OdSphere

		Thread.sleep(5000);
		java.util.List<WebElement> fillOdSphere = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillOdSphere.size(); i++)
			if (fillOdSphere.get(i).getText().equalsIgnoreCase(odSPhere)) {
				fillOdSphere.get(i).click();
				break;
			}

		// Click on odcyliender
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodcyliender.click();

		// fill rhe value in odcyliender
		Thread.sleep(5000);
		java.util.List<WebElement> fillodcyliender = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillodcyliender.size(); i++)
			if (fillodcyliender.get(i).getText().equalsIgnoreCase(odCyliender)) {
				fillodcyliender.get(i).click();
				break;
			}

		// Click on odAxis
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodAxis.click();

		// fill rhe value in odAxis Thread.sleep(2000); clickForEnableElement();
		Thread.sleep(3000);
		java.util.List<WebElement> fillodAxis = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillodAxis.size(); i++)
			if (fillodAxis.get(i).getText().equalsIgnoreCase(odAxis)) {
				fillodAxis.get(i).click();
				break;
			}

		// Click on odAdd
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodAdd.click();

		// fill rhe value in odAdd

		Thread.sleep(3000);
		java.util.List<WebElement> fillodAdd = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table[1]/tbody/tr/td"));
		for (int i = 0; i < fillodAdd.size(); i++)
			if (fillodAdd.get(i).getText().equalsIgnoreCase(odAdd)) {
				fillodAdd.get(i).click();
				break;
			}

		// chose Os RadioButton
		Thread.sleep(3000);
		String getOsText = driver
				.findElement(By.xpath("//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[1]/div[1]/div[2]")).getText();
		System.out.println(getOsText);
		Thread.sleep(3000);
		if (getOsText.equalsIgnoreCase(os)) {
			driver.findElement(By.xpath("//*[@id=\"gwt-debug-glasses-0\"]/div[1]/div[4]/div[1]/div[2]/div[2]")).click();
		}

		// Click on osSphere
		Thread.sleep(3000);
		clickOnOsSphere.click();

		// fill rhe value in OsSphere

		Thread.sleep(5000);
		java.util.List<WebElement> fillOsSphere = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillOsSphere.size(); i++)
			if (fillOsSphere.get(i).getText().equalsIgnoreCase(osSphere)) {
				fillOsSphere.get(i).click();
				break;
			}

		// Click on oscyliender
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnoscyliender.click();

		// fill rhe value in odcyliender
		Thread.sleep(5000);
		java.util.List<WebElement> filloscyliender = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < filloscyliender.size(); i++)
			if (filloscyliender.get(i).getText().equalsIgnoreCase(osCyliender)) {
				filloscyliender.get(i).click();
				break;
			}

		// Click on osAxis
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosAxis.click();

		// fill rhe value in osAxis
		Thread.sleep(3000);
		java.util.List<WebElement> fillosAxis = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillosAxis.size(); i++)
			if (fillosAxis.get(i).getText().equalsIgnoreCase(osAxis)) {
				fillosAxis.get(i).click();
				break;
			}

		// Click on osAdd
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosAdd.click();

		// fill rhe value in osAdd

		Thread.sleep(3000);
		java.util.List<WebElement> fillosAdd = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table[1]/tbody/tr/td"));
		for (int i = 0; i < fillosAdd.size(); i++)
			if (fillosAdd.get(i).getText().equalsIgnoreCase(osAdd)) {
				fillosAdd.get(i).click();
				break;
			}

		// click on Prism Ist slider(First prism)
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(5000);
		clickOnPrism.click();

		Thread.sleep(5000);
		Actions builder = new Actions(driver);

		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		// To get pixel count of Slider X axis and Y axis(267,25)

		Dimension sliderWidth = draggablePartOfScrollbar.getSize();
		System.out.println(sliderWidth);

		// We need to give below value in +00 to move slider to 50 and +130 to move
		// slider to 100,-100 to move slider to 12
		int numberOfRangeToDragTheSlider = -100;
		builder.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(numberOfRangeToDragTheSlider, 0)
				.release().perform();

		// select O or I from Prism
		Thread.sleep(3000);
		java.util.List<WebElement> fillPrismValueOI = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div"));
		for (int i = 0; i < fillPrismValueOI.size(); i++)
			if (fillPrismValueOI.get(i).getText().equalsIgnoreCase(prism)) {
				fillPrismValueOI.get(i).click();
				break;
			}

		// select the value from 2Nd slider(First Prism)
		Thread.sleep(5000);
		Actions builder1 = new Actions(driver);

		WebElement draggablePartOfScrollbar1 = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		// To get pixel count of Slider X axis and Y axis(267,25)

		Dimension sliderWidth1 = draggablePartOfScrollbar.getSize();
		System.out.println(sliderWidth1);

		// We need to give below value in +00 to move slider to 50 and +130 to move
		// slider to 100,-100 to move slider to 12
		int numberOfRangeToDragTheSlider1 = -100;
		builder1.moveToElement(draggablePartOfScrollbar1).clickAndHold().moveByOffset(numberOfRangeToDragTheSlider1, 0)
				.release().perform();
		// select O or U from Prism
		Thread.sleep(3000);
		java.util.List<WebElement> fillPrismValue1OI = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div/div[2]/div"));
		for (int i = 0; i < fillPrismValue1OI.size(); i++)
			if (fillPrismValue1OI.get(i).getText().equalsIgnoreCase(prism1)) {
				fillPrismValue1OI.get(i).click();
				break;
			}

		// click on Prism Ist slider(2nd Prism)
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(5000);
		clickOn2Prism.click();

		// select the value from first slider(second Prism)
		Thread.sleep(5000);
		int x = 10;
		WebElement slider = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(slider, ((width * x) / 100), 0).click();
		move.build().perform();
		System.out.println("Slider moved");

		// select O or I from Prism
		Thread.sleep(3000);
		java.util.List<WebElement> fillPrismValue2OI = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div"));
		for (int i = 0; i < fillPrismValue2OI.size(); i++)
			if (fillPrismValue2OI.get(i).getText().equalsIgnoreCase(prism)) {
				fillPrismValue2OI.get(i).click();
				break;
			}

		Thread.sleep(5000);
		By clickInanywhereOnPrism1 = By.xpath("/html/body/div[9]/div/div/table/tbody/tr[2]/td/div");
		driver.findElement(clickInanywhereOnPrism1).click();
		// select the value from 2Nd slider(Second Prism)
		Thread.sleep(5000);
		int y = 10;
		WebElement slider1 = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		int width1 = slider.getSize().getWidth();
		Actions move1 = new Actions(driver);
		move1.moveToElement(slider1, ((width1 * y) / 100), 0).click();
		move1.build().perform();
		System.out.println("Slider moved");

		// select O or Ifrom Prism
		Thread.sleep(3000);
		java.util.List<WebElement> fillPrismValue2UD = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div/div[2]/div"));
		for (int i = 0; i < fillPrismValue2UD.size(); i++)
			if (fillPrismValue2UD.get(i).getText().equalsIgnoreCase(prism3)) {
				fillPrismValue2UD.get(i).click();
				break;
			}
		// Thread.sleep(5000);
		clickForEnableElement();
		// Click on odDistance
		Thread.sleep(3000);
		clickOnodDistance.click();

		// fill rhe value in OdDistance

		Thread.sleep(5000);
		java.util.List<WebElement> fillOdDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
		for (int i = 0; i < fillOdDistance.size(); i++)
			if (fillOdDistance.get(i).getText().equalsIgnoreCase(odDistance)) {
				fillOdDistance.get(i).click();
				break;
			}

		try {
			Thread.sleep(3000);
			clickOnodDistance.click();

			// fill rhe value in OdDistance

			Thread.sleep(5000);
			fillOdDistance = driver
					.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
			for (int i = 0; i < fillOdDistance.size(); i++)
				if (fillOdDistance.get(i).getText().equalsIgnoreCase(odDistance)) {
					fillOdDistance.get(i).click();
					break;
				}
		} catch (Exception e) {
			System.out.println("we can't change the data");
		}
		clickForEnableElement();
		String strGetOdText = clickOnodDistance.getText();
		System.out.println(strGetOdText);
		if (odDistance == strGetOdText) {
			System.out.println("Value Matched");
		} else {
			System.out.println("Value Not Matched");
		}
		// Click on osDistance
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosDistance.click();

		// fill rhe value in osDistance Thread.sleep(2000); clickForEnableElement();
		Thread.sleep(3000);
		java.util.List<WebElement> fillosDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
		for (int i = 0; i < fillosDistance.size(); i++)
			if (fillosDistance.get(i).getText().equalsIgnoreCase(osDistance)) {
				fillosDistance.get(i).click();
				break;
			}

		// Click on odIntermediate
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodIntermediate.click();

		// fill rhe value in OdIntermediate

		Thread.sleep(5000);
		java.util.List<WebElement> fillOdIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOdIntermediate.size(); i++)
			if (fillOdIntermediate.get(i).getText().equalsIgnoreCase(odIntermediate)) {
				fillOdIntermediate.get(i).click();
				break;
			}

		// Click on osIntermediate
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosIntermediate.click();

		// fill rhe value in osIntermediate Thread.sleep(2000); clickForEnableElement();
		Thread.sleep(3000);
		java.util.List<WebElement> fillosIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillosIntermediate.size(); i++)
			if (fillosIntermediate.get(i).getText().equalsIgnoreCase(osIntermediate)) {
				fillosIntermediate.get(i).click();
				break;
			}

		// Click on odNear
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodNear.click();

		// fill rhe value in OdNear

		Thread.sleep(5000);
		java.util.List<WebElement> fillOdNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOdNear.size(); i++)
			if (fillOdNear.get(i).getText().equalsIgnoreCase(odNear)) {
				fillOdNear.get(i).click();
				break;
			}
		// Click on osNear
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosNear.click();

		// fill rhe value in osNear
		Thread.sleep(3000);
		java.util.List<WebElement> fillosNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillosNear.size(); i++)
			if (fillosNear.get(i).getText().equalsIgnoreCase(osNear)) {
				fillosNear.get(i).click();
				break;
			}

		// click on odComment
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(5000);
		clickonOdComment.click();
		fillOdComment.sendKeys(OdComment);

		// click on odComment
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(5000);
		clickonOsComment.click();
		fillOsComment.sendKeys(osComment);
		// for Enable element
		// Thread.sleep(2000);
		clickForEnableElement();

	}
	// click to addNew Refraction and fill the value in Refraction

	public void addNewRefraction(String od, String odSphere, String odCyliender, String odAxis, String odAdd, String os,
			String osSphere, String osCyliender, String osAxis, String osAdd, String prism, String prism1,
			String prism2, String prism3, String odDistance, String osDistance, String odIntermediate,
			String osIntermediate, String odNear, String osNear, String OdComment, String osComment)
			throws InterruptedException {
		// click on Addnew
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnRefractionGlass)).click();
		// clickOnRefractionGlass.click();

		// chose Od RadioButton
		Thread.sleep(3000);
		String getOdText = driver
				.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[1]/div[1]/div[1]"))
				.getText();
		System.out.println(getOdText);
		Thread.sleep(3000);
		if (getOdText.equalsIgnoreCase(od)) {
			driver.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[1]/div[2]/div[1]"))
					.click();
		}
		// Click on odSphere
		Thread.sleep(4000);
		clickOnOdRefractionSphere.click();

		// fill rhe value in OdSphere

		Thread.sleep(4000);
		java.util.List<WebElement> fillOdSphere = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillOdSphere.size(); i++)
			if (fillOdSphere.get(i).getText().equalsIgnoreCase(odSphere)) {
				fillOdSphere.get(i).click();
				break;
			}
		// Click on odcyliender
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodRefractioncyliender.click();

		// fill rhe value in odcyliender
		Thread.sleep(4000);
		java.util.List<WebElement> fillodcyliender = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillodcyliender.size(); i++)
			if (fillodcyliender.get(i).getText().equalsIgnoreCase(odCyliender)) {
				fillodcyliender.get(i).click();
				break;
			}

		// Click on odAxis
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodRefractionAxis.click();

		// fill rhe value in odAxis Thread.sleep(2000); clickForEnableElement();
		Thread.sleep(3000);
		java.util.List<WebElement> fillodAxis = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillodAxis.size(); i++)
			if (fillodAxis.get(i).getText().equalsIgnoreCase(odAxis)) {
				fillodAxis.get(i).click();
				break;
			}

		// Click on odAdd
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodRefractionAdd.click();

		// fill rhe value in odAdd

		Thread.sleep(3000);
		java.util.List<WebElement> fillodAdd = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table[1]/tbody/tr/td"));
		for (int i = 0; i < fillodAdd.size(); i++)
			if (fillodAdd.get(i).getText().equalsIgnoreCase(odAdd)) {
				fillodAdd.get(i).click();
				break;
			}

		// chose Os RadioButton
		Thread.sleep(5000);
		String getOsText = driver
				.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[1]/div[1]/div[2]"))
				.getText();
		System.out.println(getOsText);
		Thread.sleep(6000);
		if (getOsText.equalsIgnoreCase(os)) {
			driver.findElement(By.xpath("//*[@id=\"gwt-debug-refractions-0\"]/div[1]/div[4]/div[1]/div[2]/div[2]"))
					.click();
		}

		// Click on osSphere
		Thread.sleep(6000);
		clickOnOsRefractionSphere.click();

		// fill rhe value in OsSphere

		Thread.sleep(5000);
		java.util.List<WebElement> fillOsSphere = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillOsSphere.size(); i++)
			if (fillOsSphere.get(i).getText().equalsIgnoreCase(osSphere)) {
				fillOsSphere.get(i).click();
				break;
			}

		// Click on oscyliender
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosRefractioncyliender.click();

		// fill rhe value in odcyliender
		Thread.sleep(5000);
		java.util.List<WebElement> filloscyliender = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < filloscyliender.size(); i++)
			if (filloscyliender.get(i).getText().equalsIgnoreCase(osCyliender)) {
				filloscyliender.get(i).click();
				break;
			}

		// Click on osAxis
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosRefractionAxis.click();

		// fill rhe value in osAxis
		Thread.sleep(3000);
		java.util.List<WebElement> fillosAxis = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table/tbody/tr/td"));
		for (int i = 0; i < fillosAxis.size(); i++)
			if (fillosAxis.get(i).getText().equalsIgnoreCase(osAxis)) {
				fillosAxis.get(i).click();
				break;
			}

		// Click on osAdd
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosRefractionAdd.click();

		// fill rhe value in osAdd

		Thread.sleep(3000);
		java.util.List<WebElement> fillosAdd = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/table[1]/tbody/tr/td"));
		for (int i = 0; i < fillosAdd.size(); i++)
			if (fillosAdd.get(i).getText().equalsIgnoreCase(osAdd)) {
				fillosAdd.get(i).click();
				break;
			}

		// click on Prism Ist slider(First prism)
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(5000);
		clickOnRefractionPrism.click();

		Thread.sleep(2000);
		Actions builder = new Actions(driver);

		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		// To get pixel count of Slider X axis and Y axis(267,25)

		Dimension sliderWidth = draggablePartOfScrollbar.getSize();
		System.out.println(sliderWidth);

		// We need to give below value in +00 to move slider to 50 and +130 to move
		// slider to 100,-100 to move slider to 12
		int numberOfRangeToDragTheSlider = -100;
		builder.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(numberOfRangeToDragTheSlider, 0)
				.release().perform();

		// select O or I from Prism
		Thread.sleep(2000);
		java.util.List<WebElement> fillPrismValueOI = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div"));
		for (int i = 0; i < fillPrismValueOI.size(); i++)
			if (fillPrismValueOI.get(i).getText().equalsIgnoreCase(prism)) {
				fillPrismValueOI.get(i).click();
				break;
			}
		// select the value from 2Nd slider(First Prism)
		Thread.sleep(2000);
		Actions builder1 = new Actions(driver);

		WebElement draggablePartOfScrollbar1 = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		// To get pixel count of Slider X axis and Y axis(267,25)

		Dimension sliderWidth1 = draggablePartOfScrollbar.getSize();
		System.out.println(sliderWidth1);

		// We need to give below value in +00 to move slider to 50 and +130 to move
		// slider to 100,-100 to move slider to 12
		int numberOfRangeToDragTheSlider1 = -100;
		builder1.moveToElement(draggablePartOfScrollbar1).clickAndHold().moveByOffset(numberOfRangeToDragTheSlider1, 0)
				.release().perform();
		// select O or U from Prism
		Thread.sleep(2000);
		java.util.List<WebElement> fillPrismValue1OI = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div/div[2]/div"));
		for (int i = 0; i < fillPrismValue1OI.size(); i++)
			if (fillPrismValue1OI.get(i).getText().equalsIgnoreCase(prism1)) {
				fillPrismValue1OI.get(i).click();
				break;
			}
		// click on Prism Ist slider(2nd Prism)
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(2000);
		clickOn2RefractionPrism.click();

		// select the value from first slider(second Prism)
		Thread.sleep(2000);
		int x = 10;
		WebElement slider = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(slider, ((width * x) / 100), 0).click();
		move.build().perform();
		System.out.println("Slider moved");

		// select O or I from Prism
		Thread.sleep(2000);
		java.util.List<WebElement> fillPrismValue2OI = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/divF"));
		for (int i = 0; i < fillPrismValue2OI.size(); i++)
			if (fillPrismValue2OI.get(i).getText().equalsIgnoreCase(prism)) {
				fillPrismValue2OI.get(i).click();
				break;
			}
		// select the value from 2Nd slider(Second Prism)
		Thread.sleep(2000);
		int y = 10;
		WebElement slider1 = driver.findElement(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div/div/form/input"));
		int width1 = slider.getSize().getWidth();
		Actions move1 = new Actions(driver);
		move1.moveToElement(slider1, ((width1 * y) / 100), 0).click();
		move1.build().perform();
		System.out.println("Slider moved");

		// select O or Ifrom Prism
		Thread.sleep(3000);
		java.util.List<WebElement> fillPrismValue2UD = driver.findElements(By.xpath(
				"/html/body/div[9]/div/div/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div/div[2]/div"));
		for (int i = 0; i < fillPrismValue2UD.size(); i++)
			if (fillPrismValue2UD.get(i).getText().equalsIgnoreCase(prism3)) {
				fillPrismValue2UD.get(i).click();
				break;
			}
		// Thread.sleep(5000);
		clickForEnableElement();
		// Click on odDistance
		Thread.sleep(3000);
		clickOnodRefractionDistance.click();

		// fill rhe value in OdDistance

		Thread.sleep(5000);
		java.util.List<WebElement> fillOdDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
		for (int i = 0; i < fillOdDistance.size(); i++)
			if (fillOdDistance.get(i).getText().equalsIgnoreCase(odDistance)) {
				fillOdDistance.get(i).click();
				break;
			}

		try {
			clickOnodRefractionDistance.click();

			// fill rhe value in OdDistance

			Thread.sleep(5000);
			fillOdDistance = driver
					.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
			for (int i = 0; i < fillOdDistance.size(); i++)
				if (fillOdDistance.get(i).getText().equalsIgnoreCase(odDistance)) {
					fillOdDistance.get(i).click();
					break;
				}
		} catch (Exception ex) {
			System.out.println("we can't change the value");

		}
		// Click on osDistance
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosRefractionDistance.click();

		// fill rhe value in odDistance Thread.sleep(2000); clickForEnableElement();
		Thread.sleep(3000);
		java.util.List<WebElement> fillosDistance = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/table/tbody/tr/td/div"));
		for (int i = 0; i < fillosDistance.size(); i++)
			if (fillosDistance.get(i).getText().equalsIgnoreCase(osDistance)) {
				fillosDistance.get(i).click();
				break;
			}

		// Click on odIntermediate
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodRefractionIntermediate.click();

		// fill rhe value in OdIntermediate

		Thread.sleep(5000);
		java.util.List<WebElement> fillOdIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOdIntermediate.size(); i++)
			if (fillOdIntermediate.get(i).getText().equalsIgnoreCase(odIntermediate)) {
				fillOdIntermediate.get(i).click();
				break;
			}

		// Click on osIntermediate
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosRefractionIntermediate.click();

		// fill rhe value in osIntermediate Thread.sleep(2000); clickForEnableElement();
		Thread.sleep(3000);
		java.util.List<WebElement> fillosIntermediate = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillosIntermediate.size(); i++)
			if (fillosIntermediate.get(i).getText().equalsIgnoreCase(osIntermediate)) {
				fillosIntermediate.get(i).click();
				break;
			}

		// Click on odNear
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnodRefractionNear.click();

		// fill rhe value in OdNear

		Thread.sleep(5000);
		java.util.List<WebElement> fillOdNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillOdNear.size(); i++)
			if (fillOdNear.get(i).getText().equalsIgnoreCase(odNear)) {
				fillOdNear.get(i).click();
				break;
			}
		// Click on osNear
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(3000);
		clickOnosRefractionNear.click();

		// fill rhe value in osNear
		Thread.sleep(3000);
		java.util.List<WebElement> fillosNear = driver
				.findElements(By.xpath("/html/body/div[9]/div/div/div[6]/div[2]/div"));
		for (int i = 0; i < fillosNear.size(); i++)
			if (fillosNear.get(i).getText().equalsIgnoreCase(osNear)) {
				fillosNear.get(i).click();
				break;
			}

		// click on odComment
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(5000);
		clickonOdRefractionComment.click();
		// fill the comment in odComment
		fillOdRefractionComment.sendKeys(OdComment);

		// click on odComment
		// Thread.sleep(2000);
		clickForEnableElement();
		Thread.sleep(5000);
		clickonOsRefractionComment.click();
		fillOsRefractionComment.sendKeys(osComment);
		// for Enable element
		// Thread.sleep(2000);
		clickForEnableElement();

	}

	// click to addNew ContactLens and fill the value in ContactLens
	public void addNewContacLens(String lensMake) throws InterruptedException {

		// click of addNew CotactLens
		Thread.sleep(5000);
		clickOnContactLens.click();

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

		// click on DoneBtn of ContactLens
		Thread.sleep(5000);
		clickOnDoneBtnContactLens.click();

	}

	// click to addNew Keratometry and fill the value in Keratometry
	public void addNewKeratometry(String rightRadius, String rightAxis, String rightPower, String leftRadius,
			String leftAxis, String leftPower, String instrument) throws InterruptedException {
		// click on AddNew of addNewKeratometry
		Thread.sleep(3000);
		clickOnKeratometry.click();

		// click on right radius Text
		Thread.sleep(3000);
		clickOnRightRadiusTextBoxK1.click();
		// fill the value in right radius TextBox
		clickOnRightRadiusTextBoxK1.sendKeys(rightRadius);
		// click on Rightpower TextBox
		Thread.sleep(3000);
		clickOnRightPowerTextK1.click();

		// click on right Axis Text
		clickOnRightAxisTextK1.click();
		// fill the value in right axis TextBox
		clickOnRightAxisTextK1.sendKeys(rightAxis);
		// click on RightAxis
		Thread.sleep(3000);
		clickOnRightAxisTextK2.click();

		// click on right power Text
		Thread.sleep(3000);
		clickOnRightPowerTextK2.click();
		// fill the value in right Power TextBox
		clickOnRightPowerTextK2.sendKeys(rightPower);
		// click on rightPower
		clickOnRightRadiusTextBoxK2.click();

		// click on Left radius Text
		Thread.sleep(3000);
		clickOnLeftRadiusTextBoxK1.click();
		// fill the value in Left radius TextBox
		clickOnLeftRadiusTextBoxK1.sendKeys(rightRadius);
		// click on Left power TextBox
		Thread.sleep(3000);
		clickOnLeftPowerTextK1.click();

		// click on Left Axis Text
		clickOnLeftAxisTextK1.click();
		// fill the value in Left axis TextBox
		clickOnLeftAxisTextK1.sendKeys(rightAxis);
		// click on Left Axis
		Thread.sleep(2000);
		clickOnLeftAxisTextK2.click();

		// click on Left power Text
		Thread.sleep(3000);
		clickOnLeftPowerTextK2.click();
		// fill the value in Left Power TextBox
		clickOnLeftPowerTextK2.sendKeys(rightPower);
		// click on Left Power
		Thread.sleep(3000);
		clickOnLeftRadiusTextBoxK2.click();

		// click on instruMent
		Thread.sleep(3000);
		clickOnInstruMentOfRighteye.click();
		// select value from Instrument
		Thread.sleep(3000);
		java.util.List<WebElement> selectFromInstrument = driver
				.findElements(By.xpath("//*[@id=\"gwt-debug-kpopup-instrument-container\"]/div"));
		for (int i = 0; i < selectFromInstrument.size(); i++) {
			System.out.println(selectFromInstrument.get(i).getText().equalsIgnoreCase(instrument));
			if (selectFromInstrument.get(i).getText().equalsIgnoreCase(instrument)) {

				selectFromInstrument.get(i).click();
				break;
			}
		}

		// driver.findElement(By.xpath("//*[@id=\"kpopup-instrument-item-0\"]")).click();
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(fillCommentInKeratomatery)).sendKeys("recored successfully");

		// click On doneButton of Keratometry

		//
		System.out.println(clickOnDoneBtnOfKeratometry.getAttribute("innerText"));

		Thread.sleep(7000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();",clickOnDoneBtnOfKeratometry);

		builder.moveToElement(clickOnDoneBtnOfKeratometry).doubleClick().build().perform();

	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// function for Enable the element
	public void clickForEnableElement() {
		By clickOnPage = By
				.cssSelector("#content > div > div > div> div > div > div > table > tbody > tr > td:nth-child(1)>div");
		driver.findElements(clickOnPage).get(0).click();
	}

}
