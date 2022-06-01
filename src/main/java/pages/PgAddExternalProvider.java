//pageAddExternalProvider.java
package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PgAddExternalProvider {
	private WebDriver driver;
	private WebDriverWait wait;
//	private Actions actions;

	public PgAddExternalProvider(WebDriver driver, WebDriverWait wait, Actions actions) {
		this.driver = driver;
		this.wait = wait;
//		this.actions = actions;
		PageFactory.initElements(driver, this);
	}
//method addExternalProvider
	public void addExternalProvider(String provider, String degree, String fName, String mName, String lName,
			String initialsCode, String npi, String refcode, String addressLine1, String city, String state,
			String zipcode, String officePhone, String email, String doctorNo, String pratice, String directAddress) {
		//provider Area
		By externalProviderLink = By.xpath(".//*[text()='Providers']");
		ensureElementToBeClickable(externalProviderLink);
		driver.findElement(externalProviderLink).click();

		//externalProvider Area
		By externalProvider = By.id("gwt-debug-addNewProviderLinkAnchor");
		ensureElementToBeClickable(externalProvider);
		driver.findElement(externalProvider).click();

		//providerType Area
		By providertype = By.id("gwt-debug-providerTypeList");
		ensureElementToBeClickable(providertype);
		driver.findElement(providertype).sendKeys(provider);


		By selDegree = By.id("gwt-debug-degreeList");
		ensureElementToBeClickable(selDegree);
		driver.findElement(selDegree).sendKeys(degree);

		//firstNmae
		By firstName = By.id("gwt-debug-firstName");
		ensureElementToBeClickable(firstName);
		driver.findElements(firstName).get(1).sendKeys(fName);

		//middleNmae
		By middleName = By.id("gwt-debug-middleName");
		ensureElementToBeClickable(middleName);
		driver.findElement(middleName).sendKeys(mName);

		//lastName
		By lastName = By.id("gwt-debug-lastName");
		ensureElementToBeClickable(lastName);
		driver.findElements(lastName).get(1).sendKeys(lName);

		By initCode = By.id("gwt-debug-initials");
		ensureElementToBeClickable(initCode);
		driver.findElement(initCode).sendKeys(initialsCode);

		By npiBox = By.xpath("//*[@id='gwt-debug-npi']/input");
		ensureElementToBeClickable(npiBox);
		driver.findElement(npiBox).sendKeys(npi);

		Random random = new Random();
		int n = 10000 + random.nextInt(900000);
		refcode = Integer.toString(n);
		By systemRefCode = By.id("gwt-debug-pmsReferralId");
		ensureElementToBeClickable(systemRefCode);
		driver.findElement(systemRefCode).sendKeys(refcode);

		By addressLine = By.id("gwt-debug-addressLine1");
		ensureElementToBeClickable(addressLine);
		driver.findElement(addressLine).sendKeys(addressLine1);

		By cityName = By.id("gwt-debug-city");
		ensureElementToBeClickable(cityName);
		driver.findElement(cityName).sendKeys(city);

		By stateName = By.id("gwt-debug-stateList");
		ensureElementToBeClickable(stateName);
		driver.findElement(stateName).sendKeys(state);

		By zipCode = By.id("gwt-debug-zipCode");
		ensureElementToBeClickable(zipCode);
		driver.findElement(zipCode).sendKeys(zipcode);

		By officePh = By.id("gwt-debug-officePhone");
		ensureElementToBeClickable(officePh);
		driver.findElement(officePh).sendKeys(officePhone);

		By emailid = By.id("gwt-debug-email");
		ensureElementToBeClickable(emailid);
		driver.findElement(emailid).sendKeys(email);

		By drNo = By.cssSelector("#gwt-debug-doctorNumber > input");
		ensureElementToBeClickable(drNo);
		driver.findElement(drNo).sendKeys(doctorNo);

		By pra = By.id("gwt-debug-practice");
		ensureElementToBeClickable(pra);
		driver.findElement(pra).sendKeys(pratice);

		By directAdd = By.id("gwt-debug-directAddress");
		ensureElementToBeClickable(directAdd);
		driver.findElement(directAdd).sendKeys(directAddress);

		By clickOnsave = By.id("gwt-debug-saveButton");
		ensureElementToBeClickable(clickOnsave);
		driver.findElement(clickOnsave).click();
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
