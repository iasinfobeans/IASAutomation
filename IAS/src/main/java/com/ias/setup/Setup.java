package com.ias.setup;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ias.pom.DashboardPage;
import com.ias.pom.QuotationRequestFormPage;
import com.ias.pom.SignInPage;
import com.ias.util.Prop;

public class Setup
{
	public static WebDriver driver;
	static String baseurl = Prop.getTestData("applicationURL");
	
	public static void testSetup() throws IOException
	{
		driver= Driver.getDriver();
		PageFactory.initElements(driver, SignInPage.class);
		PageFactory.initElements(driver, DashboardPage.class);
		PageFactory.initElements(driver, QuotationRequestFormPage.class);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Prop.getTestData("applicationURL").toString());	
	}
	
	public static void testTearDown()
	{
		driver.close();
		Reporter.log("Closed browser ", true);
	}
}