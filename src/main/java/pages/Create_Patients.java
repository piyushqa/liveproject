package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Create_Patients {

	// private static final String = null;
	WebDriver driver;
	@FindBy(how = How.LINK_TEXT, using = "Create Patient")
	private WebElement username;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmsId\"]")
	private WebElement PMSID;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmMrn\"]")
	private WebElement MRN;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmFirstName\"]")
	private WebElement firstname;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmMiddleName\"]")
	private WebElement middlename;
	@FindBy(how = How.CSS, using = "div#gwt-debug-dateOfBirth>select:nth-child(1)")
	private WebElement Day;
	@FindBy(how = How.CSS, using = "div#gwt-debug-dateOfBirth>select:nth-child(2)")
	private WebElement month;
	@FindBy(how = How.CSS, using = "div#gwt-debug-dateOfBirth>select:nth-child(3)")
	private WebElement Year;
	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-genderSelect-button\"]/div[3]")
	private WebElement clickonsx;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmv-suffix-button\"]/div[3]")
	private WebElement clickonorination;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-addressLine1\"]")
	private WebElement Address1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-city\"]")
	private WebElement City;
	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-state\"]/option[1]")
	private WebElement ClickonState;
	@FindBy(how = How.XPATH, using = ".//*[@id='gwt-debug-zipCode']")
	private WebElement Zip;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-homePhoneField\"]/input[1]")
	private WebElement input1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-homePhoneField\"]/input[2]")
	private WebElement input2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-homePhoneField\"]/input[3]")
	private WebElement input3;
	@FindBy(how = How.XPATH, using = ".//*[@id=\"gwt-debug-pmv-ethnicity-button\"]/div")
	private WebElement ethnicity;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmv-race-button\"]")
	private WebElement Racenotcorrectlocator;

	@FindBy(how = How.CSS, using = "select#gwt-debug-state")
	WebElement clickOnCountry;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmv-ethnicity-container\"]/div[1]")
	WebElement Ethnicitylist ;
	@FindBy(how = How.XPATH, using = "//*[@id=\"gwt-debug-pmv-ethnicity-button\"]/div[3]")
	WebElement Ethnicityselection ;
	
	
	
	
	

	public Create_Patients(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, Create_Patients.this);
	}

	public void createpatient(String PMSID1, String MRN1, String firstname1, String middlename1, String Address,
			String City1, String Zip2) throws InterruptedException {
		Thread.sleep(8000);

		username.click();
		
		Thread.sleep(8000);
	
		PMSID.sendKeys(PMSID1);
		MRN.sendKeys(MRN1);
		firstname.sendKeys(firstname1);
		middlename.sendKeys(middlename1);
		Address1.sendKeys(Address);
		City.sendKeys(City1);
		Zip.sendKeys(Zip2);
		
		
		Select objselect = new Select(Day);
		objselect.selectByIndex(2);

		Select objselect1 = new Select(month);
		objselect1.selectByIndex(2);

		Select objselect2 = new Select(Year);
		objselect2.selectByIndex(2);
		clickonsx.click();
		Thread.sleep(5000);
		// Select the Male oprion from Sex list
		List<WebElement> obj1 = driver.findElements(By.xpath("//*[@id=\"gwt-debug-genderSelect\"]/div/div"));
		for (WebElement obj2 : obj1) {
			if (obj2.getText().equalsIgnoreCase("Male")) {
				obj2.click();
				break;
				
				
				
			}
			
			Thread.sleep(5000);
			Ethnicityselection.click();
			Ethnicitylist.click();
			
			
		}
		
		
	
		
		//String[] value = ssn2.split("-");
	//input1.sendKeys(value[0]);
	//input2.sendKeys(value[1]);
	//	input3.sendKeys(value[2]);
		//ethnicity.click();
		//List<WebElement> obj11 = driver.findElements(By.xpath(".//*[@id=\"gwt-debug-pmv-ethnicity-container\"]/div"));
		//for (WebElement obj12 : obj11) {
		//	if (obj12.getText().equalsIgnoreCase("Chicano")) {
		//		obj12.click();

			}

	//	}
	//	Racenotcorrectlocator.click();
	//	List<WebElement> obj22 = driver
	//			.findElements(By.xpath("//*[@class=\"container GOKQO-1BFV GOKQO-1BOV GOKQO-1BDV\"]/div"));
		//for (WebElement obj24 : obj22) {
		//	if (obj24.getText().equalsIgnoreCase("Other")) {
		//		obj24.click();
		//	}
		//}

	//}

	// clickonorination.click();

		}
