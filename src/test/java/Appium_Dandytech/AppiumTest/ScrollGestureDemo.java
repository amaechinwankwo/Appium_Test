package Appium_Dandytech.AppiumTest;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollGestureDemo extends BaseTest {

	@Test
	public void scrollGesture() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// note androidUIAutomator is a google engine selector, \\ on the text is to
		// remove error.
		// use this when you know the element to stop at
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

		// use below when you have no prior idea where to stop
		scrollToEnd(); //called from BaseTest

	}

}
