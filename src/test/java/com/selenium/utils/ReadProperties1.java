package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties1 {
	public static String getObject(String filename,String key) {
		String value=null;
		Properties p = new Properties();
		try {
		FileInputStream file =new FileInputStream("src/test/resources/ObjectRepositories/"+filename+".properties");
		p.load(file);
	value = p.getProperty(key);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException io) {
			io.printStackTrace();
		}
		return value;
}
}