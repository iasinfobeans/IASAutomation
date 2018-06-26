package com.ias.setup;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ias.util.Prop;

public class Driver {
	
	public static WebDriver driver;
	private static Logger log = Logger.getLogger(Driver.class.getName());

	public static WebDriver getDriver(String browserName) throws IOException {
		if (Prop.fetchPropertyValue("browser").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
			log.info("Browser used is: "+ browserName);
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
