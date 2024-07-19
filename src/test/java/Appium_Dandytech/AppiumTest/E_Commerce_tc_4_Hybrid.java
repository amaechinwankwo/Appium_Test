package Appium_Dandytech.AppiumTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class E_Commerce_tc_4_Hybrid extends BaseTest {

	
	@Test
	public void FillForm() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mary Kate");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		// scroll to the right country
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"))"));
		WebElement country = driver.findElement(By.xpath("//android.widget.TextView[@text='Aruba']"));
		System.out.println(country.getText());
		country.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		// to first two products to cart
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); 
		// text changed after click hence get(0) for second product
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		// wait for page to load before assertion
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		// to ensure prices amount total
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();

		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productPrices.get(i).getText();
			Double price = getFormatedAmount(amountString);
			totalSum = totalSum + price; // 160.97 + 120 = 280.97

		}

		String displayedSum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormatedSum = getFormatedAmount(displayedSum);
		Assert.assertEquals(totalSum, displayFormatedSum);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		
		String tac = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		Assert.assertEquals(tac, "Terms Of Conditions");
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@bounds='[56,1919][1363,2031]']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		
		
		//Hybrid
		//get all the driver contexts, basically two
		
		Set<String> contexts = driver.getContextHandles();
		//enhanced loop
		for(String conttexName :contexts)
		{
			System.out.println(conttexName); //check & copy the WEBVIEW output to the the next line
		}
		//Switching context from Native to Hybrid(Webview) to perform action on web
		driver.context("WEBVIEW_com.androidsample.generalstore");
	
		driver.findElement(By.name("q")).sendKeys("Dandytech");//chrome test
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); //Appium KeyEvent
	
		//switch back to Native app to perform action on Native
		driver.context("NATIVE_APP");
		//continue native test
	
	}

}
