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

public class Browser_BaseTest {

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
		// Hybrid App to have knowledge of ChromeDriver, use compactible version
		options.setChromedriverExecutable(
				"//Users//user//eclipse-workspace//AppiumTest//src//test//java//resources//chromedriver");
		options.setCapability("browserName", "Chrome");

		// instantiate driver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		// Waiting time before test failure
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Format Amount
	public Double getFormatedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
