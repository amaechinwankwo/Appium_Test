package Appium_Dandytech.AppiumTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSLongPress extends IOSBaseTest{

	
	
	@Test
	public void IOSLongPressTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
	
		IOSLongPressAction(ele);
		Thread.sleep(3000);
	}
}
