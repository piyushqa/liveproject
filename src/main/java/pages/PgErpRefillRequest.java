//package pages;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class PgErpRefillRequest {
//	private WebDriver driver;
//	private WebDriverWait wait;
//	private Actions action;
//	WebElement element;
//	PgErpLanding PgErpLanding;
//	@FindBy(how = How.CSS, using = "#search-results > tbody > tr:nth-child(1) > td > label>span")
//	public WebElement chkMedicationList;
//	public String str;
//
//	public PgErpRefillRequest(WebDriver driver, WebDriverWait wait, Actions action) {
//		this.driver = driver;
//		this.wait = wait;
//		this.action = action;
//		PageFactory.initElements(driver, this);
//
//	}
//
//	public void erpRefillRequest(boolean medicationList, String checkReq, String status) throws InterruptedException {
//
//		//click on refill request
//		Thread.sleep(5000);
//		driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(9) > a > span")).click();
//
//		//check the checkBox
//		Thread.sleep(2 * 1000);
//		if (!chkMedicationList.isSelected() && medicationList)
//			chkMedicationList.click();
//		// Create object of SimpleDateFormat class and decide the format
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
//
//		// get current date time with Date()
//		Date date = new Date();
//
//		// Now format the date
//		String date1 = dateFormat.format(date);
//
//		// Print the Date
//		System.out.println(date1);
//
//		Thread.sleep(2000);
//		String text1 = driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(9) > a > span")).getText();
//
//		String text2 = driver
//				.findElement(By.cssSelector("#search-results > tbody > tr:nth-child(1) > td:nth-child(2) > div >label"))
//				.getText();
//		str = date1 + " " + text1 + " " + text2;
//
//		System.out.println(str);
//		Thread.sleep(3000);
//
//
//		//fill the data in comment box
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//*[@id=\"search-results\"]/tbody/tr/td/div/textarea")).sendKeys(str);
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.linkText("Request a refill")).click();
//
//	//logOut the system
//		Thread.sleep(5000);
//		if (driver.findElement(By.cssSelector(
//				"#main-container > div> div > div > div > div > div > div > div > div.panel-body > div> div > form"))
//				.getText().equals(checkReq)
//				|| driver.findElement(By.cssSelector("#search-results > tbody>tr:nth-child(1)>td:nth-child(6)>span"))
//						.getText().equals(status)) {
//			Thread.sleep(2000);
//			driver.findElement(By.cssSelector("#navbar-container > div> ul > li:nth-child(2) > a > span")).click();
//
//			Thread.sleep(3000);
//			driver.findElement(By.cssSelector("#navbar-container > div> ul > li.open > ul > li:nth-child(2) > a"))
//					.click();
//
//		}
//
//	}
//
//	public void testTask(String date1) throws InterruptedException {
//		// TODO Auto-generated method stub
//
//		//click on task
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(
//				"#content > div > div> div:nth-child(3) > div > table > tbody>tr:nth-child(2)>td:nth-child(1)>a"))
//				.click();
//
//		//select the task
//		Thread.sleep(12000);
//		java.util.List<WebElement> openTask = driver.findElements(
//				By.xpath("//*[@id=\"gwt-debug-contentPanel\"]/div[3]/div/div[3]/div/table/tbody/tr/td/div"));
//		for (int i = 0; i < openTask.size(); i++)
//			// System.out.println(openRelationship.get(i).getText());
//			if (openTask.get(i).getText().equalsIgnoreCase(date1)) {
//				openTask.get(i).click();
//				break;
//			}
//
//		//compare the comment from integrity to log on site
//		int count = driver
//				.findElements(By.xpath("//*[@id=\"gwt-debug-viewTaskWidget\"]/table/tbody/tr/td/div/div[2]/span"))
//				.size();
//		try {
//			for (int i = 1; i <= count; i++)
//
//			{
//				if (driver
//						.findElement(By.xpath(
//								"//*[@id=\"gwt-debug-viewTaskWidget\"]/table/tbody/tr/td/div/div[2]/span[" + i + "]"))
//						.getText().equals(str))
//					;
//				driver.close();
//				// System.out.println(text);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
