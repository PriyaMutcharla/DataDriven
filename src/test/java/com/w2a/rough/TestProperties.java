package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		//to get the root path of the project
		System.out.println(System.getProperty("user.dir"));
		//initiating properties class
		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		//loading config file
		config.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		//loading OR file
		OR.load(fis);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("btnbnkmnglgn"));
	}

}
