package Appium_Dandytech.AppiumTest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Assignment extends BaseTest {

	@Test
	public void AssignmentPractice() throws MalformedURLException, InterruptedException {
driver.findElement(AppiumBy.accessibilityId("App")).click();
driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
driver.findElement(By.id("android:id/button2")).click();

//driver.findElement(By.xpath("//android.widget.Button[@content-desc='Progress dialog']")).click();
//driver.findElement(By.id("io.appium.android.apis:id/checkbox_button2")).click();

driver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();
driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Dandytech@2022");
driver.findElement(By.id("android:id/button1")).click();

driver.findElement(By.id("io.appium.android.apis:id/checkbox_button")).click();

//confirm that Every Tuesday is checked
WebElement Tuesday = driver.findElement(By.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[1]"));
Assert.assertEquals(Tuesday.getAttribute("checked"),"false");
//Confirm that every Thursday is checked
WebElement Thursday = driver.findElement(By.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[3]"));
Assert.assertEquals(Thursday.getAttribute("checked"),"false");
//then check Saturday
WebElement Saturday = driver.findElement(By.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[6]"));
Saturday.click();
	
driver.findElement(By.id("android:id/button1")).click();

//repeat alert to check Saturday is checked
driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();

//ensure Saturday is checked
Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[6]")).getAttribute("checked"),"true");
driver.findElement(By.id("android:id/button2")).click();






	
	
	}
}