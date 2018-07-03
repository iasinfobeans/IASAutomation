package com.ias.setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.ias.pom.DashboardPage;
import com.ias.pom.QuotationRequestFormPage;
import com.ias.pom.SignInPage;

public class Setup {
	public static WebDriver driver;
	private static Logger log = Logger.getLogger(Setup.class.getName());

	public static void testSetup() throws IOException {
		driver = Driver.getDriver();
		PageFactory.initElements(driver, SignInPage.class);
		PageFactory.initElements(driver, DashboardPage.class);
		PageFactory.initElements(driver, QuotationRequestFormPage.class);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Driver.getURL());
	}

	public static void testTearDown() {
		driver.close();
		Reporter.log("Closed browser ", true);
	}

}