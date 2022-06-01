package pages;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageRemoveDocumentFromDocumentCenter {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	// // Define Locater
	// @FindAll({ @FindBy(how = How.XPATH, using =
	// ".//div[starts-with(@class,'datalist-item')]"),
	// @FindBy(how = How.XPATH, using =
	// "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div") })
	// private List<WebElement> select_RefferalDoc;

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget>a")
	private WebElement clickOnOpenEncounter;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-startNewEncounter\"]/a")
	private WebElement clickStartNewEncounter;

	@FindBy(how = How.XPATH, using = ".//div[text()=\"Document Center\"]")
	private WebElement clickOnDocumentCenter;

	@FindBy(how = How.ID, using = "gwt-debug-tabbedPopup-tabContainer")
	private WebElement clickOnRemoveDocument;

	@FindBy(how = How.XPATH, using = ".//a[text()=\"Remove\"]")
	private WebElement clickOnRemove;

	@FindBy(how = How.XPATH, using = ".//div[@id=\"gwt-debug-overlay_content\"]/div/textarea")
	private WebElement fillTheTextArea;

	@FindBy(how = How.XPATH, using = ".//a[@id=\"gwt-debug-ok\" or text=\"Done\"]")
	private WebElement clickOnDoneBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[10]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div")
	private List<WebElement> select_RefferalDoc;

	@FindBy(xpath = "/html/body/div[10]/div/div/div[1]/img")
	private WebElement closeDocumentCenter;

	public PageRemoveDocumentFromDocumentCenter(WebDriver driver, WebDriverWait wait, Actions builder) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.builder = builder;
		PageFactory.initElements(driver, PageRemoveDocumentFromDocumentCenter.this);
	}

	public void verfiyRemoveDocument(String provider) throws Exception {
		// Get Current Date
		Date d1 = new Date();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");;

		String storeCurrentdate = dateFormat.format(d1);
		System.out.println(storeCurrentdate);


		// click On Open Encounter
		Thread.sleep(8000);
		ensureElementToBeClickable(clickOnOpenEncounter);
		clickOnOpenEncounter.click();
		Thread.sleep(3000);
		int select_RowFromOpenEncounter = driver
				.findElements(By.xpath(".//table[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr")).size();
		System.out.println(select_RowFromOpenEncounter);
		Thread.sleep(3000);

		// Select_Provider
		Thread.sleep(4000);
		List<WebElement> select_Provider = driver
				.findElements(By.xpath(".//*[@id=\"gwt-debug-openEncounterTable\"]/tbody/tr/td/div"));
		for (int i = 1; i <= select_Provider.size(); i++)
			if (select_Provider.get(i).getText().equalsIgnoreCase(provider)) {
				select_Provider.get(i).click();
				break;
			}

		// click On Document Center
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDocumentCenter);
		clickOnDocumentCenter.click();

		// select_Remove Document
		Thread.sleep(7000);
		List<WebElement> select_RemoveDocument = clickOnRemoveDocument.findElements(By.xpath(".//*"));
		for (WebElement removeDocument : select_RemoveDocument) {
			if (removeDocument.getText().equalsIgnoreCase("Remove Document")) {
				removeDocument.click();
				break;
			}
		}
		// Thread.sleep(10000);
		// WebElement getDataForRemoveDocument = driver.findElement(By
		// .xpath(".//div[text()=\"01/01/2019 - AnkitRefferalReport.docx (uploaded " +
		// storeCurrentdate + ")\"]"));
		//
		// String refferalDocDate = getDataForRemoveDocument.getText();
		// refferalDocDate = refferalDocDate.substring(13);
		// System.out.println(refferalDocDate);

		// select_refferal Document
		Thread.sleep(7000);
try {
		for (WebElement select_refferalDocument : select_RefferalDoc) {
			if (select_refferalDocument.getText()
					.endsWith("AnkitRefferalReport.docx (uploaded " + storeCurrentdate.trim() + ")")) {
				Thread.sleep(5000);
				builder.moveToElement(select_refferalDocument).click().build().perform();
				break;
			}

		}

		// click On Remove
		Thread.sleep(4000);
		builder.moveToElement(clickOnRemove).click().build().perform();

		// fill The Text Area
		Thread.sleep(4000);
		fillTheTextArea.sendKeys("Remove the document of refferal report");

		// click On Done Btn
		Thread.sleep(2000);
		ensureElementToBeClickable(clickOnDoneBtn);
		clickOnDoneBtn.click();
		 } catch (Exception e) {
		 Thread.sleep(5000);
		 builder.moveToElement(closeDocumentCenter).click().build().perform();
		 System.out.println(e);
		 }
	}

	public void ensureElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, config.ProjectSettings.elementWaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
