package main.java.controller.handler.utilityHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The AbstractUtilityHandler includes some base for the .properties file handlers.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */

public abstract class AbstractUtilityHandler implements UtilityHandlerInterface {
	private Properties prop;

	public AbstractUtilityHandler(String propName) {
		try {
			setProp(retrieveProperties(propName));
		} catch (IOException ioe) {
			// TODO logger
		}
	}
	
	@Override
	/**
	 * retrieveProperties is used to find the internal .properties files
	 */
	public Properties retrieveProperties(String propName) throws IOException {
		FileInputStream inputStream = null;
		Properties prop = null;
		try {
			inputStream = new FileInputStream(propsPath + propName);
			prop = new Properties();
			prop.load(inputStream);
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException");
			System.out.println((propsPath + propName));
			// TODO: logger
		} catch (IOException ioe) {
			System.out.println("IOException");
			System.out.println((propsPath + propName));
			// TODO: logger
		} finally {
			inputStream.close();
		}
		return prop;
	}

	@Override
	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public Properties getProp() {
		return this.prop;
	}
	
	@Override
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
