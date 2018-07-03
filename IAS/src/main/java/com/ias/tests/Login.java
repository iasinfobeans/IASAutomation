package com.ias.tests;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ias.pom.DashboardPage;
import com.ias.pom.QuotationRequestFormPage;
import com.ias.pom.SignInPage;
import com.ias.setup.Setup;
import com.ias.util.Prop;

import io.qameta.allure.Description;
public class Login 
{
	private static Logger log = Logger.getLogger(Login.class.getName());
	
	@BeforeMethod(alwaysRun = true)
	public void testSetup() throws IOException 
	{
		Setup.testSetup();
	}
	
	@Test (priority = 0, groups = { "smoke", "regression" }, description="valid Login Scenario with correct username and password.")
	@Description("Test Description: Valid login with correct credentials")
	public static void testingLoginFunctionality() throws IOException, InterruptedException {
		SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
		DashboardPage.verifyDashboardPage();
	}
	
	@Test(priority = 1, groups = { "smoke", "regression" }, description="valid Get a Quote Scenario to generate a Quotation Request")
	@Description("Test Description: get a quote form")
	public static void testingGetaQuoteFunctionality() throws IOException, InterruptedException {
		QuotationRequestFormPage.getAQoute();	
		QuotationRequestFormPage.submitQuoteRequest();
	}
	
	@AfterMethod
	public void testTearDown() 
	{
		Setup.testTearDown();
	}
}
