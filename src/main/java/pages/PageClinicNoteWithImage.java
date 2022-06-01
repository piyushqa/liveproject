package pages;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ScreenShot;

public class PageClinicNoteWithImage {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Download\"]")
	private WebElement clickOnDownload;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/img")
	private WebElement clickOnCancelButtonOfDownloadPage;

	@FindBy(how = How.CSS, using = "div#gwt-debug-priorClinicVisits-container>table>tbody>tr>td:nth-child(6)>span")
	private List<WebElement> clickOnReports;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Clinic Note\"]")
	private WebElement clickOnClinicNote;

	/**
	 * @param driver
	 * @param wait
	 * @param builder
	 */
	public PageClinicNoteWithImage(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageClinicNoteWithImage.this);
	}

	public void verifyClinicNoteWithImage(String fName, String lName, String opthamosCopyReports, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			Boolean significantProblem, String visitType, Boolean noCharges) throws Exception {

		new PageCloseEncounter(wait, driver, builder).openEncounterWithProblem(category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, significantProblem);

		new PageOpthalmoscopyReports(driver, wait, builder).performIntegriviewOperation(opthamosCopyReports);

		takeScreenShotExpectedImage();

		new PageCloseEncounter(wait, driver, builder).closeEncounter(visitType, noCharges);
		Thread.sleep(2000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		 // this.takeSnapShot(driver, "C://Users//Ankitp//Desktop//TakeData//AnkitFile") ;   
		
		matchClinicNoteImage();
	}

	public void takeScreenShotExpectedImage() throws Exception {
		Thread.sleep(5000);
		clickOnDocumentCenter.click();

		// select_Documents
		List<WebElement> select_Documents = driver
				.findElements(By.xpath(".//div[@id=\"gwt-debug-tabbedPopup-tabContainer\"]/div"));
		for (int i = 1; i <= select_Documents.size(); i++)
			if (select_Documents.get(i).getText().equalsIgnoreCase("Ophthalmoscopy Reports")) {
				select_Documents.get(i).click();
				break;
			}

		Thread.sleep(2000);
		clickOnDownload.click();

		Thread.sleep(3000);
		clickOnCancelButtonOfDownloadPage.click();

	}

	public void matchClinicNoteImage() throws Exception {

		Thread.sleep(6000);
		int length = clickOnReports.size();
		if (length > 0) {
			for (WebElement select_Reports : clickOnReports) {
				if (select_Reports.getText().equalsIgnoreCase("Reports")) {
					select_Reports.click();
					break;
				}
			}
			Thread.sleep(2000);
			clickOnClinicNote.click();

		} else {
			System.out.println("Patient has no encountered");
		}
	}
	public  void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
}
