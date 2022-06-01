package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Create_Patients;
import utilities.TestDataProviders;
//import utility.TestDataProvider;

public class TestCreatePatients {
	WebDriver driver;

	@BeforeTest
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
	//System.setProperty("webdriver.gecko.driver", "C:/BrowserDrivers/geckodriver.exe");
		
	//	WebDriver driver1=new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test

	(dataProvider = "createDetails", dataProviderClass = TestDataProviders.class)

	public void createpatient(String env,String PMSID1, String MRN1, String firstname1, String middlename1, String Address,
			String City1, String Zip2) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();
		Create_Patients createpatient = new Create_Patients(driver);
		createpatient.createpatient(PMSID1, MRN1, firstname1, middlename1, Address, City1, Zip2);

	}
}