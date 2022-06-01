package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;
import com.relevantcodes.extentreports.model.Log;

import config.ProjectSettings;

public class Util {

	public int generateRandomNumber(int min, int max) {
		Random rand = new Random();
		int randomNum = min + rand.nextInt((max - min) + 1);
		return randomNum;
	}

	public static String getElementXPath(WebDriver driver, WebElement element) {
		String script = "gPt = function (c) { if (c.id !== '') { return \"//*[@id='\" + c.id + \"']\"; } if (c === document.body) { return c.tagName; } var a = 0; var e = c.parentNode.childNodes; for (var b = 0; b < e.length; b++) { var d = e[b]; if (d === c) { return gPt(c.parentNode) + '/' + c.tagName + '[' + (a + 1) + ']'; } if (d.nodeType === 1 && d.tagName === c.tagName) { a++; } } }; return gPt(arguments[0]);";

		return (String) ((JavascriptExecutor) driver).executeScript(script, element);
	}

	public static List<WebElement> findChildren(WebDriver driver, WebElement parent) {
		return parent.findElements(By.xpath(".//*"));
	}

	public static List<String> getChildrenXpathList(WebDriver driver, WebElement parent) {
		List<WebElement> elements = parent.findElements(By.xpath(".//*"));
		List<String> xpathsOfElements = new ArrayList<>();
		for (WebElement e : elements) {
			xpathsOfElements.add(getElementXPath(driver, e));
		}
		return xpathsOfElements;
	}

//	public static List<String> jsonData(String connectorNumber, String keyName) throws Exception {
//		List<String> s1 = new ArrayList<String>();
//		JSONArray array = null;
//		if (connectorNumber != null) {
//			try {
//				JSONObject obj = new JSONObject(connectorNumber);
//
//					array = obj.getJSONArray(keyName);
//				// System.out.println("Array Object" + array);
//
//				for (int i = 0; i < array.length(); i++) {
//					System.out.println(s1.add(array.getJSONObject(i).getString(keyName)));
//				}
//
//				for (int i = 0; i <= s1.size(); i++) {
//					System.out.println(("ACI Connector Number:" + s1.get(i)));
//					// System.out.println(s1.add(array.getString(1)));
//				}
//				// }
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return s1;
//	}

}