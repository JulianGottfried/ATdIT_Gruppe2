package main.java.handler;

import java.io.IOException;
import java.util.Properties;

public interface HandlerInterface {
	String propsPath = "AtdIT/src/main/resources/utilities/";
	
	public Properties retrieveProperties(String propName) throws IOException;
	
	public void setProp(Properties prop);
	
	public Properties getProp();
	
	String getProperty(String key);
}
