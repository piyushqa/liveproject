package pages;




	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Reporter;

	public class PgErpLanding {
		private WebDriver driver;
		//Page elements
//		@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Patient Search")
//		private WebElement lnkPatientSearch;
	//
//		@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Patient")
//		private WebElement lnkCreatePatient;
	//
		//Initillizing page
		public PgErpLanding (WebDriver driver)
		{
			String pgTitle = "Log on";
			this.driver = driver;
			//Checking for page title
			if (driver.getTitle().contains(pgTitle))
			{
				PageFactory.initElements(driver, this);
			}
			else
			{
				Reporter.log("\nIncorrect Page: Found: "+driver.getTitle()+" while expecting: "+pgTitle);
			}
		}


	}



