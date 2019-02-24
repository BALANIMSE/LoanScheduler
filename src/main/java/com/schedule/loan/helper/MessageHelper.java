
package com.schedule.loan.helper;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * The Class MessageHelper. This class loads all the message.properties being
 * used by application.
 */
public class MessageHelper {

	/** The prop. */
	private static Properties prop = null;

	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @return the message
	 */
	public static String getMessage(String key) {

		String value = "";

		if (prop == null)
			initProperties();

		value = (String) prop.get(key);

		if (value == null || value.equals(""))
			value = (String) prop.get("LN_DEF_ERROR");

		return value;
	}

	/**
	 * Inits the properties.
	 */
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
