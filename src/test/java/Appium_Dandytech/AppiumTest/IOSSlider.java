package Appium_Dandytech.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSlider extends IOSBaseTest {

	@Test
	public void slideGesture() throws InterruptedException
	{
		
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));
		slider.sendKeys("0%");
		System.out.println(slider.getAttribute("value"));
		Thread.sleep(2000);
		slider.sendKeys("1%"); //slide to 100%
		System.out.println(slider.getAttribute("value"));
		Thread.sleep(2000);
		slider.sendKeys("0.6%"); //slide to 55%
		System.out.println(slider.getAttribute("value"));
		Assert.assertEquals("55%", slider.getAttribute("value"));
		
		
	}

}
