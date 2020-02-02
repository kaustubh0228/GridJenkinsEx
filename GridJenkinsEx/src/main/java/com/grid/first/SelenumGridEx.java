package com.grid.first;

import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelenumGridEx {

	private static Wait<WebDriver> wait;
	private static DesiredCapabilities capabillities;
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		
		capabillities = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabillities);
		capabillities.setBrowserName("chrome");
		wait = new WebDriverWait(driver, 6000);
	}

	@Test
	public void loginPageTest() throws Exception {

		driver.get("file:///C:/Users/Kaustubh%20Aras/Desktop/JavaByKiran/Offline_Website/index.html");
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				return webDriver.findElement(By.tagName("title")) != null;
			}
		});
		System.out.println(Thread.currentThread().getId());

		System.out.println("You're on login Page!");
	}

	@Test
	public void dashboardPageTest() throws Exception {

		driver.get("file:///C:/Users/Kaustubh%20Aras/Desktop/JavaByKiran/Offline_Website/pages/examples/dashboard.html");
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				return webDriver.findElement(By.tagName("title")) != null;
			}
		});
		System.out.println(Thread.currentThread().getId());
		System.out.println("You're on dashboard!");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
}
