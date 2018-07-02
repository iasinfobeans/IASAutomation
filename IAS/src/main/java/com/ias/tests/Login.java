package com.ias.tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ias.pom.DashboardPage;
import com.ias.pom.QuotationRequestFormPage;
import com.ias.pom.SignInPage;
import com.ias.setup.Driver;
import com.ias.setup.Setup;
import com.ias.util.Prop;

import io.qameta.allure.Description;
public class Login 
{

	@BeforeMethod
	public void testSetup() throws IOException 
	{
		Setup.testSetup();
	}
	
	@Test (priority = 0, description="valid Login Scenario with correct username and password.")
	@Description("Test Description: Valid login with correct credentials")
	public static void testingLoginFunctionality() throws IOException, InterruptedException {
		SignInPage.login("pankaj.shukla@yopmail.com", "Admin@2018", "Customer");
		DashboardPage.verifyDashboardPage();
	}
	
	@Test(priority = 1, description="valid Get a Quote Scenario to generate a Quotation Request")
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
