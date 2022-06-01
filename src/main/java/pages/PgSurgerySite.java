package pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PgSurgerySite {
	private WebDriver driver;
	private WebDriverWait wait;
	// private Actions action;

	public PgSurgerySite(WebDriver driver, WebDriverWait wait, Actions action) {
		this.driver = driver;
		this.wait = wait;
		// this.action = action;
		PageFactory.initElements(driver, this);

	}

	public void addSurgerySite(String selectSite, String configrationoptions, String name, String addressLine1,
			String addressline2, String city, String state, String zip, String website, String pmsId)
			throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(
				"#content > div > div > div:nth-child(4) > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a"))
				.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By surgerySiteType = By.xpath("//*[@id=\"gwt-debug-clinicSite-button\"]/div[3]");
		// ensureElementToBeClickable(surgerySiteType);
		driver.findElement(surgerySiteType).click();
		By s1 = By.cssSelector("#gwt-debug-clinicSite>div>div:nth-child(11)");
		driver.findElement(s1).click();

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#gwt-debug-configurationOptions>div>div:nth-child(2)")).click();

		// ensureElementToBeClickable(configrationsOptionsType);

		xlsheetData();
		add(name, addressLine1, addressline2, city, state, zip, website, pmsId);

		}

	public void add(String name, String addressLine1, String addressline2, String city, String state, String zip,
			String website, String pmsId) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By addbtn = By.cssSelector("#content > div > div> div > div> div> div:nth-child(1) > a");
		driver.findElement(addbtn).click();

		By nameType = By.cssSelector("#content>div>div>div>div>div:nth-child(1)>input");
		// ensureElementToBeClickable(nameType);
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(1)>input")).clear();
		// driver.findElement(nameType).clear();
		driver.findElement(nameType).sendKeys(name);

		// By address1Type =
		// By.cssSelector("#content>div>div>div>div>div:nth-child(2)>input");
		// // ensureElementToBeClickable(nameType);
		// driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(2)>input")).clear();
		// driver.findElement(address1Type).sendKeys(addressLine1);
		WebElement address1Type = driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(2)>input"));
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(2)>input")).clear();
		address1Type.sendKeys(addressLine1);
		address1Type.sendKeys(Keys.ENTER);

		By address2Type = By.cssSelector("#content>div>div>div>div>div:nth-child(3)>input");
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(3)>input")).clear();
		driver.findElement(address2Type).sendKeys(addressline2);

		// By cityType =
		// By.cssSelector("#content>div>div>div>div>div:nth-child(4)>input");
		// driver.findElement(cityType).sendKeys(city);

		WebElement cityType = driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(4)>input"));
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(4)>input")).clear();
		cityType.sendKeys(city);
		// cityType.sendKeys(Keys.ENTER);

		By stateType = By.cssSelector("#content>div>div>div>div>div:nth-child(5)>input");
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(5)>input")).clear();
		driver.findElement(stateType).sendKeys(state);

		By zipType = By.cssSelector("#content>div>div>div>div>div:nth-child(6)>input");
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(6)>input")).clear();
		driver.findElement(zipType).sendKeys(zip);

		By websiteType = By.cssSelector("#content>div>div>div>div>div:nth-child(7)>input");
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(7)>input")).clear();
		driver.findElement(websiteType).sendKeys(website);

		By pmsIdType = By.cssSelector("#content>div>div>div>div>div:nth-child(8)>input");
		driver.findElement(By.cssSelector("#content>div>div>div>div>div:nth-child(8)>input")).clear();
		driver.findElement(pmsIdType).sendKeys(pmsId);

		By saveBtn = By.cssSelector("#content > div > div> div > div> div> div:nth-child(2) > a");
		driver.findElement(saveBtn).click();

	}

	public void addAnotherSurgeryData(String name, String addressLine1, String addressline2, String city, String state,
			String zip, String website, String pmsId) throws Exception {
		Thread.sleep(100);
		xlsheetData();
		add(name, addressLine1, addressline2, city, state, zip, website, pmsId);
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void xlsheetData() throws Exception {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Ankitp1\\git\\qc-integrity\\integrityqcautomation\\IntegrityEMR\\src\\resources\\IngetrityTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(12);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		for (int i = 2; i < rowCount; i++) {
		sheet.getRow(i);
		
		

		}

	}

}
