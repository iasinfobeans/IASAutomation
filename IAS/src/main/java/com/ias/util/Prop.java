package com.ias.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ias.setup.Driver;

public class Prop {
	
	private static Logger log = Logger.getLogger(Prop.class.getName());

	public static String fetchPropertyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+ "\\src\\main\\resources\\properties\\config.properties");
		Properties property = new Properties();
		property.load(fis);
		log.info("config file loaded");
		return property.get(key).toString();
	}
	
	public static String fetchTestData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+ "\\src\\main\\resources\\properties\\testData.properties");
		Properties property = new Properties();
		property.load(fis);
		log.info("test data file loaded");
		return property.get(key).toString();
	}
}
