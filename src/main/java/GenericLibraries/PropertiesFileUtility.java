package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all reusable methods to perform operations on Properties
 * file
 * 
 * @author DELL
 *
 */

public class PropertiesFileUtility {
	private Properties property;

	public void propertyFileInitialization(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method returns the data from properties file based on the key passed
	 * 
	 * @param filePath
	 * @return
	 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}

}
