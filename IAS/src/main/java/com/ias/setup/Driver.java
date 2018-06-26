package com.ias.setup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import com.ias.util.Prop;

public class Driver {
	
	public static WebDriver driver;

	public static WebDriver getDriver(String browserName) throws IOException {
		if (Prop.fetchPropertyValue("browser").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
			return new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");
			return new FirefoxDriver();
		}
	
	}

	public static void tearDown() {
     driver.close();
	}
}
