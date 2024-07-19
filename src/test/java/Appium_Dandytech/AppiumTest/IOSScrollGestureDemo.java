package Appium_Dandytech.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSScrollGestureDemo extends IOSBaseTest {

	@Test
	public void scrollGesture() throws InterruptedException
	{
		WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
		
		IOSScrollAction(ele); //method from IOSBaseTest class
		
		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		
		//Scroll that involve inputs, simply use sendkeys()
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("230");
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");
		String number = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
		Assert.assertEquals(number, "105");
	}

}
