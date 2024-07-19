package Appium_Dandytech.AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSInBuiltBaseTest {

	public IOSDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		// start Appium server by telling the IP address and port to start the server
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build/lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		// service.start();
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 14");
		//options.setApp("//Users//user//eclipse-workspace//AppiumTest//src//test//java//resources//UIKitCatalog.app");
		//options.setApp("//Users//user//eclipse-workspace//AppiumTest//src//test//java//resources//TestApp 3.app");
		
		options.setPlatformVersion("16.2"); //Simulator version
		//Appium - WebDriver Agent -> IOS Apps
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		// instantiate driver
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		// waiting time before test failure
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
