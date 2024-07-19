package Appium_Dandytech.AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		// start Appium server by telling the IP address and port to start the server
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build/lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		// service.start();

		// set capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Nexus 6P API 33");
		//options.setDeviceName("Android Device"); //to run test on real device plugged to the PC
		
		//Hybrid App to have knowledge of ChromeDriver, use compactible version 
		options.setChromedriverExecutable("//Users//user//eclipse-workspace//AppiumTest//src//test//java//resources//chromedriver");
		
		// options.setApp("//Users//user//eclipse-workspace//AppiumTest//src//test//java//resources//ApiDemos-debug.apk");
		options.setApp("//Users//user//eclipse-workspace//AppiumTest//src//test//java//resources//General-Store.apk");

		// instantiate driver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		// waiting time before test failure
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressAction(WebElement ele)
	{

		//perform the long press gesture on the above element ele
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "durration", 2000));

	}
	
	
	
	public void scrollToEnd() throws InterruptedException {
		// use below when you have no prior idea where to stop
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, // Adjust as per your screen's coordinate
							"top", 100, // Adjust as per your screen's coordinate
							"width", 200, // Adjust as per your screen's coordinate
							"height", 600, // Adjust as per your screen's coordinate
							"direction", "down", "percent", 4.0 // Adjust to ensure a reasonable scroll distance
					));

			Thread.sleep(1000); // Wait for 1 second

		} while (canScrollMore);
	}

	
	
	
	// swipe
	public void swipeAction(WebElement ele, String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.1));

	}

	
	//Format Amount
	public Double getFormatedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
