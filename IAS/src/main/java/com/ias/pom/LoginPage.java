package com.ias.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ias.util.Prop;

public class LoginPage {

	static WebDriver driver;

	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
	}

	public static void enterUserName(String userName) throws IOException {
		driver.findElement(By.id("user_login")).sendKeys(userName);
				
	}

	public static void enterPassword(String password) throws IOException {
		driver.findElement(By.id("user_pass")).sendKeys(password);
	}

	public static void clickSignIn() throws IOException {
		driver.findElement(By.id("wp-submit")).click();
	}
}
