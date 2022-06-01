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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Util;

public class PgAddCCAndHPIValues {

	@FindBy(how = How.CSS, using = "#gwt-debug-listOpenEncounterWidget > a")
	private WebElement joinOpenEncounterBtn;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-openEncounterTable > tbody")
	private WebElement encounterContainer;
	
	@FindBy(how = How.CSS, using = "#gwt-debug-encounterTabBar > tbody > tr > td:nth-child(1) > div")
	private WebElement ccAndHPILink;

	private WebDriver driver;
	private WebDriverWait wait;
	@SuppressWarnings("unused")
	private Actions actions;
	
	public PgAddCCAndHPIValues(WebDriver driver, WebDriverWait wait, Actions actions) {
		this.driver = driver;
		this.wait = wait;
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}

	public void addPastEyeProblem(String encounterDate, List<String> values) throws InterruptedException {
		goToCCAndHPITab(encounterDate);
		By senetenceLink = By.xpath("//*[text()='Sentences']");
		ensureElementToBeClickable(senetenceLink);
		driver.findElement(senetenceLink).click();
		
		Thread.sleep(5 * 1000);
		addValues(values);
		By doneBtn = By.linkText("Done");
		ensureElementToBeClickable(doneBtn);
		driver.findElement(doneBtn).click();
	}
	
	public void addCCAndHPI(String encounterDate, String visitType, String lastVisitDate, String lastVisitProviderFirstName, String lastVisitProviderLastName, String referingProviderFirstName, String referingProviderLastName, String referingProviderAssociation) throws InterruptedException {
		addVisitType(encounterDate, visitType);
		addLastVisitProvider(lastVisitProviderFirstName, lastVisitProviderLastName, "", "");
		addReferingProvider(referingProviderFirstName, referingProviderLastName, "", "", referingProviderAssociation);
	}

	public void addVisitType(String encounterDate, String type) throws InterruptedException {
//		goToCCAndHPITab(encounterDate);
		By visitType = By.cssSelector("#gwt-debug-ccHpiVisitType");
		ensureElementToBeClickable(visitType);
		driver.findElement(visitType).click();
		Thread.sleep(2 * 1000);
		By dropDownRows = By.cssSelector("#gwt-debug-PicklistTable-dataTable > tbody  > tr");
		List<WebElement> rows = driver.findElements(dropDownRows);
		for (WebElement row : rows) {
			String xPath = Util.getElementXPath(driver, row);
			xPath += "/td/div";
			WebElement tdDiv = driver.findElement(By.xpath(xPath));
			String value = tdDiv.getText();
			if (value.equalsIgnoreCase(type)) {
				tdDiv.click();
				break;
			}
		}
	}
	
	@SuppressWarnings("unused")
	public void addLastVisitDate(String date) {
		//TODO: Need to handle calendar with specific data
		By calenderDays = By.xpath("//table[@class='datePickerDays']//td");
	}
	
	public void addLastVisitProvider(String firstName, String lastName, String primarySpeciality, String providerAssociation ) throws InterruptedException {
		By lastVisitProvider = By.id("gwt-debug-lastVisitProvider");
		ensureElementToBeClickable(lastVisitProvider);
		driver.findElement(lastVisitProvider).click();
		Thread.sleep(3 * 1000);
		searchProvider(firstName, lastName, "", primarySpeciality, providerAssociation);
	}
	
	public void addReferingProvider(String firstName, String lastName, String type, String primarySpeciality, String providerAssociation) throws InterruptedException {
		By referingProvider = By.id("gwt-debug-referringProvider");
		ensureElementToBeClickable(referingProvider);
		driver.findElement(referingProvider).click();
		Thread.sleep(3 * 1000);
		searchProvider(firstName, lastName, type, primarySpeciality, providerAssociation);
	}	
	
	public void searchProvider(String firstName, String lastName, String type, String primarySpeciality, String providerAssociation) throws InterruptedException {
		
		if (firstName != null && !firstName.equals("")) {
			By providerFirstNameBox = By.id("gwt-debug-firstName");
			ensureElementToBeClickable(providerFirstNameBox);
			driver.findElement(providerFirstNameBox).sendKeys(firstName);
		}
		
		if (lastName != null && !lastName.equals("")) {
			By providerLastNameBox = By.id("gwt-debug-lastName");
			ensureElementToBeClickable(providerLastNameBox);
			driver.findElement(providerLastNameBox).sendKeys(lastName);
		}
		
		if (type != null && !type.equals("")) {
			By selectBoxProviderType = By.id("gwt-debug-providerType");
			ensureElementToBeClickable(selectBoxProviderType);
			Select providerTypeSelector = new Select(driver.findElement(selectBoxProviderType));
			providerTypeSelector.selectByValue(type);
		}
		
		if (primarySpeciality != null && !primarySpeciality.equals("")) {
			By selectBoxSpeciality = By.id("gwt-debug-speciality");
			ensureElementToBeClickable(selectBoxSpeciality);
			Select primaryProviderSpeciality = new Select(driver.findElement(selectBoxSpeciality));
			primaryProviderSpeciality.selectByValue(primarySpeciality);
		}
		
		if (providerAssociation != null && !providerAssociation.equals("")) {
			if (providerAssociation.equalsIgnoreCase("internal")) {
				By internalRadio = By.id("providerGroup-item-0");
				ensureElementToBeClickable(internalRadio);
				driver.findElement(internalRadio).click();
			} else if (providerAssociation.equalsIgnoreCase("external")) {
				By externalRadio = By.id("providerGroup-item-1");
				ensureElementToBeClickable(externalRadio);
				driver.findElement(externalRadio).click();
			}
		}
		
		By searchBtn = By.cssSelector("#gwt-debug-searchProviders > a");
		ensureElementToBeClickable(searchBtn);
		driver.findElement(searchBtn).click();
		
		Thread.sleep(3 * 1000);
		
		By foundProvider = By.cssSelector("#gwt-debug-providerSearchResultTable > tbody > tr:first-child > td:first-child");
		ensureElementToBeClickable(foundProvider);
		driver.findElement(foundProvider).click();
	}
	

	private void addValues(List<String> values) throws InterruptedException {
		for (String value : values) {

//			By addMoreLink = By.cssSelector(".GNVKRBJBA1D > div:last-child");
			By addMoreLink = By.cssSelector(".gwt-TabLayoutPanelContentContainer > div:nth-child(3) > div > div > div:last-child");
			WebElement addMoreLinkElement = driver.findElement(addMoreLink);
//			((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('class');", addMoreLinkElement);
			
			addMoreLinkElement.click();
			
			By textBox = By.cssSelector("#content > div > div > div > div > div > div > div.gwt-TabLayoutPanel > div:nth-child(3) > div > div:nth-child(3) > div > div > div:last-child > input");
			ensureElementToBeClickable(textBox);
			driver.findElement(textBox).sendKeys(value);
			
//			By saveLink = By.cssSelector(".GNVKRBJBA1D>div:last-child>span:last-child");
			By saveLink = By.cssSelector(".gwt-TabLayoutPanelContentContainer>div:nth-child(3) > div > div > div:last-child > span:last-child");
			ensureElementToBeClickable(saveLink);
			driver.findElement(saveLink).click();
			Thread.sleep(1 * 1000);
		}
	}

	public void addPriorEyeSurgery(String encounterDate, List<String> values) {
		// TODO Auto-generated method stub

	}

	public void addOcularMedications(String encounterDate, List<String> values) {
		// TODO Auto-generated method stub

	}

	public void addTodayExamValue(String encounterDate, List<String> values) {
		// TODO Auto-generated method stub

	}
	
	
	private void goToCCAndHPITab(String encounterDate) throws InterruptedException {
		WebElement encounter = getEncounter(encounterDate);
		ensureElementToBeClickable(encounter);
		encounter.click();
		ensureElementToBeClickable(ccAndHPILink);
		ccAndHPILink.click();
	}
	
	private WebElement getEncounter(String encounterDate) throws InterruptedException {
		ensureElementToBeClickable(joinOpenEncounterBtn);
		joinOpenEncounterBtn.click();
		ensureElementToBeClickable(encounterContainer);
		Thread.sleep(2 * 1000);
		By encounter = By.xpath("//*[text()='" + encounterDate.trim() + "']");
		ensureElementToBeClickable(encounter);
		return driver.findElement(encounter);
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
