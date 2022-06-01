package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.TestDeleteVisionTab;

public class PageDeleteVisionTab {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	WebElement element;
	public String getData;
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
	private WebElement uncorrectedVisionClick;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-uncorrected-delete\"]")
	private WebElement clickOnDeleteUncorretedVA;

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

	public PageDeleteVisionTab(WebDriver driver, WebDriverWait wait, Actions builder) {

		this.driver = driver;
		this.wait = wait;
		this.builder = builder;

		PageFactory.initElements(driver, this);
	}

	public void vrifyUncorrectedVa(String provider, String history, String category, String subCategory,
			String subCategory1, String eye, String glaucomaSeverity, String glaucomaStability, String vision,
			String dominantEye, String distance, String near, String odDistance, String odIntermidiate, String odNear,
			String osDistance, String osIntermidiate, String osNear, String binocularDistance,
			String binocularIntermidiate, String binocularNear, String pinholeDistance, String pinholeIntermidiate,
			String pinholeNear) throws InterruptedException {
		Thread.sleep(7000);
		clickJionOpenencounter.click();
		Thread.sleep(7000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(5000);
		if (select_RowFromOpenEncounter > 0) {

			// Select_Provider
			Thread.sleep(7000);
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
		 java.util.List<WebElement> eyeHiostoryClick = driver.findElements(By.cssSelector("#gwt-debug-encounterTabBar > tbody > tr > td>div"));
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
		 if (gulcomaSubCategory1Click.get(i).getText().equalsIgnoreCase(subCategory1))
		 {
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
		 java.util.List<WebElement> gulcomaSeverityClick =
		 driver.findElements(By.xpath(
		 "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div"));
		 for (int i = 0; i < gulcomaSeverityClick.size(); i++)
		 if (gulcomaSeverityClick.get(i).getText().equalsIgnoreCase(glaucomaSeverity))
		 {
		 gulcomaSeverityClick.get(i).click();
		 break;

		 }

		 // select Glaucoma Stability
		 Thread.sleep(5000);
		 java.util.List<WebElement> gulcomaStabilityClick =
		 driver.findElements(By.xpath(
		 "//*[@id=\"gwt-debug-overlay_content\"]/div/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/div[2]/div"));
		 for (int i = 0; i < gulcomaStabilityClick.size(); i++)
		 if
		 (gulcomaStabilityClick.get(i).getText().equalsIgnoreCase(glaucomaStability))
		 {
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

		Thread.sleep(5000);
		String strUncorretedVAText = "Add Vision";
		String getUncorretedVAText = uncorrectedVisionClick.getText();

		Thread.sleep(5000);
		String strUncorretedVAText1 = "Delete Vision";
		String getUncorretedVAText1 = clickOnDeleteUncorretedVA.getText();
	if(strUncorretedVAText.equalsIgnoreCase(getUncorretedVAText)) {

			System.out.println(strUncorretedVAText);
			Thread.sleep(3000);
			uncorrectedVisionClick.click();

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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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
			Thread.sleep(3000);
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

	else if (strUncorretedVAText1.equalsIgnoreCase(getUncorretedVAText1)) {

			Thread.sleep(5000);
			wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(clickOnDeleteUncorretedVA));
			clickOnDeleteUncorretedVA.click();
		}

	}

	public void clickForEnableElement() {
		By clickOnPage = By
				.cssSelector("#content > div > div > div> div > div > div > table > tbody > tr > td:nth-child(1)>div");
		driver.findElements(clickOnPage).get(0).click();
	}
}
