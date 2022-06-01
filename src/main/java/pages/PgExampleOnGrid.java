package pages;

import java.util.List;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PgExampleOnGrid {
	WebDriver driver;
	int row;
	int col;

	public PgExampleOnGrid(WebDriver driver) {
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
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText();
				System.out.println(celltext);
				Thread.sleep(2000);
				if (celltext.contains(searchString)) {
					System.out.println("Found at row " + row + " column " + column + " with value " + celltext);
					try {
					Columns_row.get(column).click();
					}catch(Exception e)
					{e.getMessage();}
					found = true;
					break;
					// found = true;
				}
			}

		}
		return found;

	}
}
