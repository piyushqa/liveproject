package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class WbElement
{
	WebDriver wait;
	public static boolean checkElement(WebElement ele) throws InterruptedException
	{
		boolean found = false;
		int loopCount = 1;
		try
		{
			do
			{
				if (((org.openqa.selenium.WebElement)ele).isDisplayed())
				{
					Reporter.log("\nWeb Element Found!");
					found = true;
					loopCount = 1;
					break;
				}
				Thread.sleep(5000);
				loopCount = loopCount + 1;
				Reporter.log("\nWaiting for "+Integer.toString(loopCount)+" instance of 5 seconds wait");
			} while (loopCount==4);
		}
		catch (NoSuchElementException e)
		{
			Reporter.log("\nWeb Element: "+ele.getText()+" not found!!/nException: "+e.toString());
		}
		return found;
	}
}