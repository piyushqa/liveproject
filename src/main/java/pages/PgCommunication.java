package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PgCommunication {

	// @FindBy(how = How.CSS, using = "#gwt-debug-userDashMessageLink")
	// private WebElement ClickOnMessage;
	// @FindBy(how = How.CSS, using = "#modal-popup-message > div > div > div > div
	// > div > div > div > div:nth-child(6)")
	// private WebElement clickOnComposeMessage;
	//
	// @FindBy(how = How.CSS, using = "#modal-popup-message > div > div > div > div
	// > div > div > div > div:nth-child(6)")
	// private WebElement clickOnAddLink;
	//

	private WebDriver driver;
	private WebDriverWait wait;
	@SuppressWarnings("unused")
	private Actions actions;
	PgPatientSearch lclPgPatientSearch;

	public PgCommunication(WebDriver driver, WebDriverWait wait, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}

	// public void messageToClick() throws InterruptedException {
	//
	// // Click on Message Link
	// // wait = new WebDriverWait(driver, 10, 500);
	// // By ClickOnMessage = By.cssSelector("#gwt-debug-userDashMessageLink");
	// // ensureElementToBeClickable(ClickOnMessage);
	// // driver.findElement(ClickOnMessage).click();
	// wait = new WebDriverWait(driver, 10, 500);
	// // Click on Compose Message
	// /* By clickOnComposeMessage = By
	// .cssSelector("#modal-popup-message > div > div > div > div > div > div > div
	// > div:nth-child(6)");
	// ensureElementToBeClickable(clickOnComposeMessage);
	// driver.findElement(clickOnComposeMessage).click();
	// // click to add button
	// By clickOnAddLink = By.cssSelector("#gwt-debug-addPrimaryRecipLinkAnchor");
	// ensureElementToBeClickable(clickOnAddLink);
	// driver.findElement(clickOnAddLink).click();*/
	// // click on Add Patient
	////
	//// Thread.sleep(2 * 1000);
	////
	//// By clickOnAdPatient = By
	//// .cssSelector("body > div:nth-child(13) > div > div > table > tbody > tr >
	// td > div > div > div > a");
	//// ensureElementToBeClickable(clickOnAdPatient);
	//// driver.findElements(clickOnAdPatient).get(0).click();
	//
	// }
	//
	// // click on add link Regarding Patient
	//// public void regardingPatient() throws InterruptedException {
	//// Thread.sleep(5 * 1000);
	//// By clickOnAdLink = By.cssSelector("#gwt-debug-addPatientLinkAnchor");
	//// WebElement add3 = driver.findElements(clickOnAdLink).get(0);
	//// ensureElementToBeClickable(add3);
	//// add3.click();
	////
	//// }
	//
	// // method for send mail
	//// public void sendMail(String topic, String message, boolean urgentmessage) {
	//// By topicName = By.cssSelector("#gwt-debug-topic");
	//// WebElement tpName = driver.findElements(topicName).get(1);
	//// tpName.sendKeys(topic);
	////
	//// By messageDetail = By.cssSelector("#gwt-debug-message");
	//// WebElement msgDetail = driver.findElements(messageDetail).get(1);
	//// msgDetail.sendKeys(message);
	//// if (!chkbxurgentmsg.isSelected() && urgentmessage)
	//// chkbxurgentmsg.click();
	////
	//// }

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void sendMail(String topic, String message, Boolean urgentmessage, String firstName, String lastName)
			throws Exception {
		// click messages

		By ClickOnMessage = By.cssSelector("#gwt-debug-userDashMessageLink");
		ensureElementToBeClickable(ClickOnMessage);
		driver.findElement(ClickOnMessage).click();
		Thread.sleep(2 * 1000);
		int count1 = getSentMailCount();
		By composeMessageLink = By.xpath(".//*[text()='Compose Message']");
		ensureElementToBeClickable(composeMessageLink);
		driver.findElement(composeMessageLink).click();
		// click to add button
		By clickOnAddLink = By.cssSelector("#gwt-debug-addPrimaryRecipLinkAnchor");
		ensureElementToBeClickable(clickOnAddLink);
		driver.findElement(clickOnAddLink).click();
		// click on Add Patient

		Thread.sleep(2 * 1000);

		By clickOnAdPatient = By.xpath(".//*[text()='Add Patient']");
		ensureElementToBeClickable(clickOnAdPatient);
		driver.findElement(clickOnAdPatient).click();

		boolean editPatient = false;

		lclPgPatientSearch = new PgPatientSearch(driver);
		lclPgPatientSearch.searchPatient(firstName, lastName, "", editPatient);

		Thread.sleep(2 * 1000);
		// click on select button
		By clickOnSelect = By.xpath(".//*[text()='Select']");
		WebElement selectElement = driver.findElements(clickOnSelect).get(2);
		ensureElementToBeClickable(selectElement);
		selectElement.click();

		Thread.sleep(3 * 1000);
		By clickOnAdLink = By.cssSelector("#gwt-debug-addPatientLinkAnchor");
		WebElement add3 = driver.findElements(clickOnAdLink).get(0);
		ensureElementToBeClickable(add3);
		add3.click();
		lclPgPatientSearch.searchPatient(firstName, lastName, "", editPatient);

		By topicName = By.cssSelector("#gwt-debug-topic");
		WebElement tpName = driver.findElements(topicName).get(1);
		tpName.sendKeys(topic);

		By messageDetail = By.cssSelector("#gwt-debug-message");
		WebElement msgDetail = driver.findElements(messageDetail).get(1);
		msgDetail.sendKeys(message);

		if (urgentmessage) {
			By chkbxurgentmsg = By.cssSelector("#gwt-debug-urgentBox-input");
			ensureElementToBeClickable(chkbxurgentmsg);
			driver.findElement(chkbxurgentmsg).click();
		}

		By sendMessage = By.cssSelector("#gwt-debug-send-message > a");
		WebElement send = driver.findElements(sendMessage).get(0);
		ensureElementToBeClickable(send);
		send.click();

		Thread.sleep(2 * 1000);

		int sentMailCount2 = getSentMailCount();
		assertEquals(sentMailCount2, count1 + 1);
		// close popup
		By closePopUp = By.cssSelector("#gwt-debug-");
		ensureElementToBeClickable(closePopUp);
		driver.findElement(closePopUp).click();

	}

	private int getSentMailCount() {
		By sentMailLink = By.xpath(".//*[text()='Messages Sent']");
		ensureElementToBeClickable(sentMailLink);
		driver.findElement(sentMailLink).click();

		By sentMailContainer = By.cssSelector(
				"#gwt-debug-contentPanel > div:nth-child(1) > div > div> div > table > tbody:nth-child(3) > tr");
		ensureElementToBeClickable(sentMailContainer);

		return driver.findElements(sentMailContainer).size();
	}
}
