package com.iq.utils.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.iq.constants.FrameworkConstants;
import com.iq.enums.ConfigProperties;
import com.iq.exceptions.InvalidPropertyUsageException;

/**
 * @author Imran Qasim
 * 
 *This class is designed to read the values from the property file(s).
 *
 */
public final class PropertyUtils {
	private static Properties prop;
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	
	/**
	 * Private constructor to restrict the class to instantiate 
	 */
	private PropertyUtils() {
		
	}
	
	/**
	 * static block to load the properties file  
	 */
	static {
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());) {
			prop = new Properties();
			prop.load(file);
			for(Entry<Object, Object> entrySet: prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entrySet.getKey()), String.valueOf(entrySet.getValue()).trim()); //remove leading and trailing spaces
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(ConfigProperties key) {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
			throw new InvalidPropertyUsageException("Property name "+key+" or its value is not found. Please check config.properties file.");
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
}
