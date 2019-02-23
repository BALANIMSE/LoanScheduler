package com.schedule.loan.helper;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MessageHelper {

	private static Properties prop = null;

	public static String getMessage(String key) {

		String value = "";

		if (prop == null)
			initProperties();

		value = (String) prop.get(key);

		if (value == null || value.equals(""))
			value = (String) prop.get("LN_DEF_ERROR");

		return value;
	}

	private static void initProperties() {

		prop = new Properties();
		Resource resource = null;

		try {
			resource = new ClassPathResource("message.properties");
			prop.load(resource.getInputStream());

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
