package Appium_Dandytech.AppiumTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{

	
	
	@Test
	public void IOSBasicsTest() throws InterruptedException
	{
		//xpath, id, accessibility id, classname, iOSClassChain, iOSNsPredicateString
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		
		//iOSClassChain, faster than xpath 
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello Guys");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
		//iOSNsPredicateString uses chain keywords for perfect locator
		driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value=='Confirm / Cancel'")).click();
		//driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
		//driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'")).click();
		
		WebElement titleEle = driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH[c] 'A message' AND type=='XCUIElementTypeStaticText'"));
		
		String titleTexts = titleEle.getText();
		System.out.println(titleTexts);
		
		Assert.assertTrue(titleTexts != null && titleTexts.contains("A message"), "The element does not contain the expected text.");
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
		
	
		
		Thread.sleep(3000);
	}
}
