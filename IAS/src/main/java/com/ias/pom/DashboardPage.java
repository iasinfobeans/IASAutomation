package com.ias.pom;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ias.setup.Driver;

import io.qameta.allure.Step;

public class DashboardPage {
	WebDriver driver;
	private static Logger log = Logger.getLogger(Driver.class.getName());
	@FindBy(xpath="//h1[@class='entry-title post-title']")
	static WebElement dashboardElement;
	
	
	 public DashboardPage(WebDriver driver)
	 {
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	}
	@Step("verify dashboard page Step...")
	public static void verifyDashboardPage()
	{
			Assert.assertTrue(dashboardElement.isDisplayed());
			log.info("Dashboard displayed");
	}
}