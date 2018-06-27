package com.ias.setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ias.util.Prop;

public class Driver {
	
	public static WebDriver driver;
	private static Logger log = Logger.getLogger(Driver.class.getName());

	public static WebDriver getDriver() throws IOException {
		switch(Prop.getConfigValue("browserName")){
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FireFox": 
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default: log.info("Set browser name - chrome or FireFox or IE ");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void tearDown() {
     driver.close();
	}
}
