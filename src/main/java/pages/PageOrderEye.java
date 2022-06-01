package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class PageOrderEye {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@FindBy(how = How.XPATH, using = ".//div[@class=\"gwt-TabBarItem\"]/div/div[text()=\"Order Eye Test\"]")
	private WebElement clickOnOrderEyeTest;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-PicklistTable-dataTable\"]/tbody/tr/td/div"),
			@FindBy(how = How.CSS, using = "#gwt-debug-PicklistTable-dataTable > tbody > tr> td > div") })
	private List<WebElement> selectOrderEyeList;

	@FindBy(how = How.CSS, using = "textarea#gwt-debug-orderEyeComments")
	private WebElement fillTextArea;

	@FindBy(how = How.CSS, using = "a#gwt-debug-Done.gwt-Anchor")
	private List<WebElement> clickOnDone;

	@FindBy(how = How.CSS, using = "a#gwt-debug-thisClinicNoteLink.link")
	private WebElement clickOnClinicNote;

	@FindBy(how = How.CSS, using = "div#gwt-debug-close_overlay.close_overlay>a.close")
	private WebElement clickOnCloseBtn;

	public PageOrderEye(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageOrderEye.this);
	}

	public void verifyOrderEye(String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, Boolean significantProblem, String visitType,
			Boolean noCharges, String EyeTestCategory, String EyeTest, String regardingProblem, String WhichEye,
			String when) throws Exception {
		String strotherProcedure = "Other Procedures";

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		new PageSurgeryModuleFromOutSideEncounter(driver, wait, builder).selectSurgeryAndProcedures(strotherProcedure);

		performOrderEye(EyeTestCategory, EyeTest, regardingProblem, WhichEye, when);

		matchDataWithClinicNote(EyeTestCategory, EyeTest, regardingProblem);

		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);

	}

	public void performOrderEye(String EyeTestCategory, String EyeTest, String regardingProblem, String WhichEye,
			String when) throws Exception {

		Thread.sleep(5000);
		try {
			clickOnOrderEyeTest.click();

		} catch (Exception e) {
			clickOnOrderEyeTest.click();
		}

		//invoke method perform Eye Test Category
		performEyeTestCategory(EyeTestCategory);

		//invoke method perform Eye Test
		performEyeTest(EyeTest);

		//invoke method perform Regrading Problem
		performRegradingProblem(regardingProblem);

		//invoke method for perform Which Eye
		performWhichEye(WhichEye);

		//invoke method for perform When
		performWhen(when);

		Thread.sleep(5000);
		fillTextArea.sendKeys("Eye medication");

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		clickOnDone.get(6).click();
	}

	// we can use try catch with same code for reslove the DOM problem
	public void performEyeTestCategory(String EyeTestCategory) {
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		try {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(EyeTestCategory)) {
					select_EyeTestCategory.click();
					break;
				}

			}

		} catch (Exception e) {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(EyeTestCategory)) {
					select_EyeTestCategory.click();
					break;
				}
			}
		}
	}

	// we can use try catch with same code for reslove the DOM problem
	public void performEyeTest(String EyeTest) {
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		try {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(EyeTest)) {
					select_EyeTestCategory.click();
					break;
				}

			}

		} catch (Exception e) {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(EyeTest)) {
					select_EyeTestCategory.click();
					break;
				}
			}
		}
	}

	// we can use try catch with same code for reslove the DOM problem

	public void performRegradingProblem(String regardingProblem) {
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		try {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(regardingProblem)) {
					select_EyeTestCategory.click();
					break;
				}

			}

		} catch (Exception e) {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(regardingProblem)) {
					select_EyeTestCategory.click();
					break;
				}
			}
		}
	}

	// we can use try catch with same code for reslove the DOM problem
	public void performWhichEye(String WhichEye) {
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		try {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(WhichEye)) {
					select_EyeTestCategory.click();
					break;
				}

			}

		} catch (Exception e) {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(WhichEye)) {
					select_EyeTestCategory.click();
					break;
				}
			}
		}
	}
	//we can use try catch with same code for reslove the DOM problem

	public void performWhen(String when) {
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		try {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(when)) {
					select_EyeTestCategory.click();
					break;
				}

			}

		} catch (Exception e) {
			for (WebElement select_EyeTestCategory : selectOrderEyeList) {
				if (select_EyeTestCategory.getText().equalsIgnoreCase(when)) {
					select_EyeTestCategory.click();
					break;
				}
			}
		}
	}

	private void matchDataWithClinicNote(String WhichEye, String EyeTest, String when) throws Exception {
		Thread.sleep(5000);
		builder.moveToElement(clickOnClinicNote).click().build().perform();

		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		WebElement matchOrderEyeWithClinicNoteData = driver
				.findElement(By.xpath(".//div[starts-with(text()," + "\"" + EyeTest + "\"" + ")]"));

		String getOrderEyeWithClinicNoteData = matchOrderEyeWithClinicNoteData.getText();

		if (getOrderEyeWithClinicNoteData.startsWith(EyeTest))

		{
			Reporter.log(getOrderEyeWithClinicNoteData + " " + "same as" + EyeTest);
		}
		Thread.sleep(3000);
		clickOnCloseBtn.click();
	}

}
