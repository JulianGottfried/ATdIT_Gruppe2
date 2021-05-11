package main.java.handler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler implements HandlerInterface {
	private Properties prop;

	public PropertiesHandler(String propName) {
		try {
			setProp(retrieveProperties(propName));
		} catch (IOException ioe) {
			// TODO logger
		}
	}

	@Override
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
