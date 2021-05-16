package main.java.controller.handler.utilityHandler;

import java.io.IOException;
import java.util.Properties;

public interface UtilityHandlerInterface {
	String propsPath = "AtdIT/src/main/resources/utilities/";
	
	public Properties retrieveProperties(String propName) throws IOException;
	
	public void setProp(Properties prop);
	
	public Properties getProp();
	
	public String getProperty(String key);
}
