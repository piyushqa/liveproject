//package tests;
//
//import java.awt.AWTException;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Reporter;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//
//import config.ProjectSettings;
//
//import pages.PgErpLanding;
//
//import pages.PgLanding;
//import pages.PgLogin;
//import utilities.SetUp;
//import utilities.TestDataProviders;
//
//public class TestErpFileSharing {
//
//	String exception = null;
//	public WebDriver driver;
//	SetUp lsetup = new SetUp();
//	PgErpLanding lclPgLanding;
//	public static ExtentReports extent;
//	public static ExtentTest test;
//	private WebDriverWait wait;
//	private Actions builder;
//	PgLanding lclPgLanding1;
//
//	@BeforeTest
//	public void beforeTest() throws Exception {
//		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
//		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
//
//	// function for logOn
//
//
//	// this function upload the file
////	@Parameters({"Enviorment","Name", "FileName", "Comment", "User", "PatientFile" })
////	@Test(description = "This test logs into the Erp Apllication for file sharing", priority = 1, enabled = true, dataProvider = "ErpFileSharingDetails", dataProviderClass = TestDataProviders.class)
////	public void checkFileSharing(String enviorment,String name,String fileName,String comment,String user,String patientFile)
////			throws Exception {
////TestErpLogin test=new TestErpLogin(driver);
////		test.logInErpPoratl();
////
////		PgErpFileSharing fileSharing=new PgErpFileSharing(driver, wait, builder);
////		fileSharing.pateintErpFileSharing(name, fileName, comment, user, patientFile);
////
////
////	}
//
//
//
//	//	@AfterTest
////	public void logout() {
////
////		driver.quit();
////	}
//
//}
