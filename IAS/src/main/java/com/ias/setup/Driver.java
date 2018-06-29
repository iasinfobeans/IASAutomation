package com.ias.setup;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ias.util.Prop;

public class Driver {
	
	public static WebDriver driver;
	public static String url;
	private static Logger log = Logger.getLogger(Driver.class.getName());

	/*public static WebDriver getDriver(String browserName) throws IOException {
		if (Prop.getConfigValue("browser").toString().equalsIgnoreCase("chrome")) {
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
	
	}*/
	
	public static WebDriver getDriver(String browserName) throws IOException {
		if (System.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
			return new ChromeDriver();

		} else if (System.getProperty("Browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\driver\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.firefox.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");
			return new FirefoxDriver();
		}
	
	}
	
	public static String getURL() throws IOException {

		
		/*if(Prop.getEnv("env").toString().equalsIgnoreCase("qa")){       
	        url=Prop.getTestData("applicationURL-QA").toString();
	          
	    }else if (Prop.getEnv("env").toString().equalsIgnoreCase("uat")){
	    	url=Prop.getTestData("applicationURL-UAT").toString();
	    }else {
	    	url=Prop.getTestData("applicationURL-PROD").toString();
	    }*/
		
		if(System.getProperty("Env").equalsIgnoreCase("qa")) {
			url=Prop.getTestData("applicationURL-QA").toString();
		}else if(System.getProperty("Env").equalsIgnoreCase("uat")) {
			url=Prop.getTestData("applicationURL-UAT").toString();
		}else {
			url=Prop.getTestData("applicationURL-PROD").toString();
		}
		 return url;
	}

	@AfterMethod
	public static void tearDown() {
     driver.close();
	}
}
