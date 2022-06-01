package config;

public class ProjectSettings {
	// Project Settings

	// ------For Sprint
//	public static String baseURL = "https://sprint-qa.integritylogin.com/auth/login.html";
//	public static String userName = "provider1";
	// public static String userName = "provider1539281431292";
	// public static String password = "IntegrityFTW1n";
//	public static String password = "God2020$";
//	public static String aciConnectorURL = "https://sprint-qa.integritylogin.com/rcp-connector/meta/version";

	// ------For Production
	// public static String baseURL="https://sandbox-neon.integritylogin.com";
	//public static String baseURL = "https://www.facebook.com/";
	public static String userName = "provider1";
	// public static String userName = "admin";
	public static String password = "God2020$";
	//public static String aciConnectorURL = "https://sandbox-wolfe.integritylogin.com/rcp-connector/meta/version";

	// -----For dev
	// public static String baseURL =
	// "https://dev.integritylogin.com/auth/login.html";
	// public static String userName = "provider1";
	// public static String userName = "Dalbeer";
	// public static String password = "Apple@1234";
	// public static String password = "God2020$";
	// public static String aciConnectorURL =
	// "https://dev.integritylogin.com/rcp-connector/meta/version";

	// ---For cert
	// public static String baseURL =
	// "https://certification.integritylogin.com/auth/login.html";
//	public static String baseURL ="https://integrimagic-sx-test.integritylogin.com/auth/login.html";
	// public static String userName = "feb05user01";
	// public static String userName = "cousin";
	// public static String userName = "provider1539281570462";
	// public static String userName = "provider_in980010";
	// public static String userName = "PHYG04";
	// public static String password = "God2020$";
	// public static String password="Jan@2019";
	// public static String aciConnectorURL =
	// "https://integrimagic-sx-test.integritylogin.com/rcp-connector/meta/version";

	// ---For test
//	 public static String baseURL = "https://integrimagic-sx-test.integritylogin.com/auth/login.html";
	public static String baseURL = "https://test.integritylogin.com/auth/login.html";
//	public static String userName = "provider1";
	// public static String userName = "provider_in980010";
	// =======for usermgt supervising functionality
	// public static String userName = "ankitTestprovider01122";
	// public static String password="Ankit@123";
	// public static String password = "God2020$";
//	public static String aciConnectorURL = "https://test4.integritylogin.com/rcp-connector/meta/version";

	// ------For test2
	// public static String baseURL =
	// "https://test2.integritylogin.com/auth/login.html";
	// public static String userName = "provider_in980010";
//	public static String userName ="provider1539281431292";
	// public static String userName = "provider1";
	// public static String userName="admin1";
	// public static String userName = "Hemant";
	// public static String password = "God2020$";
//	public static String password = "IntegrityFTW1n";
	// public static String password = "Hemant@123";
	// public static String aciConnectorURL =
	// "https://test2.integritylogin.com/rcp-connector/meta/version";

	// -----ERP for dev
	// public static String
	// erpUrl="https://preproductionportal.eyereachpatients.com/Patients/dev";

	// -----ERP for Sprint-QA
//	 public static String erpUrl="https://preproductionportal.eyereachpatients.com/Patients/sprint-qa";
//    public static String erpUserName = "DavidAddRep18";
//    public static String erpPassword = "Apple@123";

	// ----ERP for test2
	public static String erpUrl = "https://preproductionportal.eyereachpatients.com/Patients/test2";
	public static String erpUserName = "DavidAddRep12";
	public static String erpPassword = "Apple@123";

	public static String AdvancedMDPMS = "https://login.advancedmd.com/";
	// public static String PMSUserName = "TESTADMIN2";
	public static String PMSUserName = "testadmin1";
	// public static String PMSPasword = "Santa@123";
	public static String PMSPasword = "givenjanF6!";
	public static String PMSOfficekey = "991115";
	public static String ErpPoratlURL = "https://preproductionportal.eyereachpatients.com/Patients/certification/Account/LogOn?ReturnUrl=%2fPatients%2fcertification";
	public static String ERPUserName = "ankitPandey1";
	public static String ERPPassword = "abcdefgh1";
	// public static String rcpCoonecter =
	// "https://sprint-qa.integritylogin.com/rcp-connector/resendBatch";
	public static String rcpCoonecter = "https://test2.integritylogin.com/rcp-connector/resendBatch";
	public static String projectPath = "IntegrityEMR";
	public static int elementWaitTimeOut = 120;
	public static int pageLoadTimeOut = 120;

	public static enum browserType {
		CHROME, IE, FIREFOX, EDGE
	}

	public static String eol = System.getProperty("line.separator");

	// Following parameters are using for sending automation run report email from
	// Automation Suite after automation suite run
	public static String SMTPServerName = "smtp.gmail.com";
	public static int SMTPServerPort = 587;
	public static String SMTPMailFromEmail = "donotreply@myvisionexpress.com";
	public static String SMTPUserName = "hkumar@myvisionexpress.com";
	public static String SMTPPassword = "";

	// Test Data Location
	// public static String xlFile =
	// "/home/niyaza/git/integrityqcautomation/IntegrityEMR/src/resources/";
	public static String xlFile = "src/main/java/resources/";

	// Email list of target recipients of Automation Report

	// public static String screenShotLocation = "test-output/screenShot/";
	public static String screenShotLocation = "test-output/screenShot/";
	public static String reportLocation = "test-output/extentreports/";
	public static String releaseVersion = "1.00";
	public static String buildNumber = "";
	public static String aciConnectorNumber = "";
}