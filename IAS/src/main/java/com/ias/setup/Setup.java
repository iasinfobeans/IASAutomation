/*package com.ias.setup;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;

public class Setup {
	
	private static Logger log = Logger.getLogger(Setup.class.getName());

	@BeforeMethod(alwaysRun = true)
	public synchronized void beforeMethod() {
		log.info("\n");
		log.info("**********************************************");
		
		switch (System.getProperty("browser")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
			log.info("Browser used is chrome");
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");
			log.info("Browser used is firefox");
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\driver\\IEDriverServer.exe");
			log.info("Browser used is IE");
			break;
		default:
			log.info("Invalid Platform, please use Chrome or Firefox or IE browsers");
			break;
		}
	}
}
*/