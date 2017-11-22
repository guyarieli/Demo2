package com.experitest.auto;

import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemoTest extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities

		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		driver = new IOSDriver<>(new URL("https://stage.experitest.com/wd/hub"), dc);
	}

	@Test
	public void basic() {
		driver.findElement(in.Repo.obj("login.Username")).sendKeys("company");
		driver.findElement(in.Repo.obj("login.Password")).sendKeys("company");
		driver.findElement(in.Repo.obj("login.loginButton")).click();
		driver.findElement(in.Repo.obj("main.logoutButton")).click();
	}
	@Test
	public void basicFail() {
		driver.findElement(in.Repo.obj("login.Username")).sendKeys("company");
		driver.findElement(in.Repo.obj("login.Password")).sendKeys("company");
		driver.findElement(in.Repo.obj("login.loginButton")).click();
		driver.findElement(in.Repo.obj("main.logoutButton")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
