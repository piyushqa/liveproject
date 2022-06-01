package pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PgJsGridExample {
	WebDriver driver;
	WebElement ele=null;
	public PgJsGridExample(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// this.row=row;
	}

	public boolean searchTable(String tableLocator, String searchString) throws InterruptedException {

		boolean found = false;

		WebElement mytable = driver.findElement(By.xpath(tableLocator));
		System.out.println(mytable);
		Thread.sleep(5000);

		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row = 0; row < rows_count; row++) {
			List<WebElement> ele = rows_table.get(row).findElements(By.tagName("td"));
			int columns_count = ele.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);
			for (int column = 0; column < columns_count; column++) {
				String celltext = ele.get(column).getText();
				System.out.println(celltext);
				Thread.sleep(2000);
				try {
				if (celltext.contains(searchString)) {
					System.out.println("Found at row " + row + " column " + column + " with value " + celltext);

						ele.get(column).click();


					found = true;
					break;
					// found = true;
				}

				}catch(StaleElementReferenceException e)
				{e.getMessage();}

			}



		}

		 highlightElement(driver, ele); //For highlighting the element
	        Thread.sleep(5000L); //to check if the element scrolled to is highlighted.
	        driver.close();
			return found;
	}



	public static void highlightElement(WebDriver driver, WebElement ele) {
        try
        { for (int i = 0; i < 3; i++)
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",ele, "color: red; border: 2px solid red;");
        }
    }
    catch(Throwable t)
    {
        System.err.println("Error came : " +t.getMessage());
    }
}

}
