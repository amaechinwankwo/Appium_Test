package Appium_Dandytech.AppiumTest;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSwipe extends IOSInBuiltBaseTest {

	@Test
	public void swipeGesture() throws InterruptedException
	{
		
		//Start default IOS already installed App, as in Activity for Android
		//Get the app Bundle ID (best ask developer -Bundle id or search on browser - iOS apps bundle id)
		Map<String, String> params = new HashMap<String, String>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile: launchApp", params);
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label = 'All Photos'")).click();
		//get how many photos available
		List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")); //use generic tag
		System.out.println(allPhotos.size());
		
		
		driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
		
		for(int i=0; i<allPhotos.size(); i++)
		{
		//get the date
		System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
		//swipe gesture to end
		Map<String, String> params1 = new HashMap<String, String>();
		//params.put("element", ((RemoteWebElement)ele).getId());
		params1.put("direction", "left");
		driver.executeScript("mobile:swipe", params1);
		}
		driver.navigate().back(); // click back button
		
		//note, always click or return to home on Simulator before each test hence no fresh installation as app continues from open screen 
		driver.findElement(AppiumBy.accessibilityId("Albums")).click();
		
	}

}
