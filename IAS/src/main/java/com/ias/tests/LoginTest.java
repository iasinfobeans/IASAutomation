package com.ias.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ias.pom.LoginPageFactory;
import com.ias.setup.Driver;
import com.ias.util.Prop;

public class LoginTest {

	private static Logger log = Logger.getLogger(LoginTest.class.getName());

	@Test(groups = { "smoke", "regression" })
	public static void testingLoginFunctionality() throws IOException {

		WebDriver driver = Driver.getDriver();
		driver.get(Driver.getURL());
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(Prop.getTestData("username"), Prop.getTestData("password"));
		Assert.assertEquals(driver.getCurrentUrl(), Prop.getTestData("successfulSignIn"));
	}

}
