package com.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;



public class PropertyFileUtil {

	static FileInputStream fis;
	static Properties p;
	protected static Logger log = Logger.getLogger("devpinoyLogger");
	public static String getConfigValue(String Key) throws IOException {
		
		fis = new FileInputStream(
				"D:\\Testing\\TestingFrameWork\\TestingFrameWork\\src\\test\\java\\com\\framework\\propertyfile\\Config.properties");
		p = new Properties();
		p.load(fis);
		return p.getProperty(Key);
	}

	public static String getPropertyValue(String Key) throws IOException {

		fis = new FileInputStream(
				"D:\\Testing\\TestingFrameWork\\TestingFrameWork\\src\\test\\java\\com\\framework\\propertyfile\\Properties.properties");
		p = new Properties();
		p.load(fis);
		return p.getProperty(Key);
	}

	public static Set<String> getAllPropertyValues() throws IOException {
		
		fis = new FileInputStream(
				"D:\\Testing\\TestingFrameWork\\TestingFrameWork\\src\\test\\java\\com\\framework\\propertyfile\\Properties.properties");
		p = new Properties();
		p.load(fis);
		Set<String> keys = p.stringPropertyNames();
	
		return keys;
	}

	
}
